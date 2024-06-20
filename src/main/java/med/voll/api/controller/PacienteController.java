package med.voll.api.controller;

import jakarta.transaction.*;
import jakarta.validation.Valid;
import med.voll.api.medico.DadosDetalhamentoMedicos;
import med.voll.api.medico.DadosListagemMedico;
import med.voll.api.paciente.*;
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
    public void cadastrarPacintes(@RequestBody @Valid DadosPacientes pacienteDados) {
        var paciente = new Paciente(pacienteDados);

        repositoryP.save(paciente);

    }

    @GetMapping
// @PageableDefault --> usado para limitar os registros quando a API disparar, e ordenar pelo nome.
    public Page<DadosListagemPaciente> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {


        return repositoryP.findAll(paginacao).map(DadosListagemPaciente::new);
    }

    @PutMapping
    @Transactional
    public void atualizarPaciente(@RequestBody @Valid DadosAtualizacaoPaciente dados ){
        //carrega a base de dados pelo ID
        var medico  = repositoryP.getReferenceById(dados.Id());
        medico.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    public void excluirPaciente(@PathVariable Long id){
        var paciente = repositoryP.getReferenceById(id);
        paciente.excluirPaciente();
    }

}





