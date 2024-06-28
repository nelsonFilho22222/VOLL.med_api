package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoAtivo implements ValidadorAgendamentoDeConsultas{

    @Autowired
    private MedicoRepository medicoRepository;

    public void validar(DadosAgendamentoConsulta dados) {
        if(dados.idPaciente() == null){
            throw new ValidacaoException("Medico nunca cadastrado");
        }
        var pacienteAtivo = medicoRepository.findAtivoById(dados.idMedico());
        if(!pacienteAtivo){
            throw new ValidacaoException("O medico não esta ativo");
        }
    }
}
