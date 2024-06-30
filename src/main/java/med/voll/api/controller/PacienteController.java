package med.voll.api.controller;

import jakarta.transaction.*;
import jakarta.validation.Valid;
import med.voll.api.domain.paciente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("paciente")
public class PacienteController {

    @Autowired
    private PacienteRepository repositoryP;


    @PostMapping
    @Transactional
    public ResponseEntity cadastrarPacintes(@RequestBody @Valid DadosPacientes pacienteDados, UriComponentsBuilder uriBuilder) {

        var paciente = new Paciente(pacienteDados);
        repositoryP.save(paciente);

        var uri = uriBuilder.path("/paciente/{id}").buildAndExpand(paciente.getId()).toUri();

        return ResponseEntity.created((uri)).body(new DadosDetalhamentoPaciente(paciente));

    }

        @GetMapping
        public ResponseEntity <Page<DadosListagemPaciente>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {

            var pagina= repositoryP.findAllByAtivoTrue(paginacao).map(DadosListagemPaciente::new);

            return ResponseEntity.ok(pagina);
        }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarPaciente(@RequestBody @Valid DadosAtualizacaoPaciente dados ){
        var paciente  = repositoryP.getReferenceById(dados.Id());
        paciente.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluirPaciente(@PathVariable Long id){
        var paciente = repositoryP.getReferenceById(id);
        paciente.excluirPaciente();

        return ResponseEntity.noContent().build();
    }

}





