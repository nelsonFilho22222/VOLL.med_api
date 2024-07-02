package med.voll.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.*;
import jakarta.validation.Valid;
import med.voll.api.domain.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("medicos")
@SecurityRequirement(name = "bearer-key")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedico dados, UriComponentsBuilder uriBuilder ) {

        var medico = new Medico(dados);
        repository.save(medico);

        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();

        return ResponseEntity.created((uri)).body(new DadosDetalhamentoMedicos(medico));
    }

    //Pageable --> interface do prorpio Spring para fazer paginação
    @GetMapping
    // @PageableDefault --> usado para limitar os registros quando a API disparar, e ordenar pelo nome.
    public  ResponseEntity <Page<DadosListagemMedico>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        //findALL() --> retorna uma lista de tudo que tem em Medico
        //strem() --> converte a lista de Medico em um stream do Java 8. --> O Page já tem seu metodo para fazer o mapeamento internamente
        //map() --> para mapear a strem de medicos
        //toList() --> para finalmente converter novamente para uma lista, mas agora somente com o DTO --> O Page tambem já retorna uma paginação,
        // assim não precisando mais desse metodo
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
        return ResponseEntity.ok(page);

    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados ){
        //carrega a base de dados pelo ID
        var medico  = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoMedicos(medico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id){
        var medico  = repository.getReferenceById(id);
        medico.excluir();

        return ResponseEntity.noContent().build();
    }


    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var medico  = repository.getReferenceById(id);


        return ResponseEntity.ok(new DadosDetalhamentoMedicos(medico));
    }


}
