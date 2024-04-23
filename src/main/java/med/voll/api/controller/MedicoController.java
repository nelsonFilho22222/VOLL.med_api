package med.voll.api.controller;

import java.util.*;
import jakarta.transaction.*;
import jakarta.validation.Valid;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.DadosListagemMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados ) {
        //System.out.println(dados);
        repository.save(new Medico(dados));
    }

    //Pageable --> interface do prorpio Spring para fazer paginação
    @GetMapping
    // @PageableDefault --> usado para limitar os registros quando a API disparar, e ordenar pelo nome.
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        //findALL() --> retorna uma lista de tudo que tem em Medico
        //strem() --> converte a lista de Medico em um stream do Java 8. --> O Page já tem seu metodo para fazer o mapeamento internamente
        //map() --> para mapear a strem de medicos
        //toList() --> para finalmente converter novamente para uma lista, mas agora somente com o DTO --> O Page tambem já retorna uma paginação,
        // assim não precisando mais desse metodo
        return repository.findAll(paginacao).map(DadosListagemMedico::new);
    }
}
