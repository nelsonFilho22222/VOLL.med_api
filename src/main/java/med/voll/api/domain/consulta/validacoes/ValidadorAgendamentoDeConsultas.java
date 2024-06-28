package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.http.ResponseEntity;

public interface ValidadorAgendamentoDeConsultas {
    void validar (DadosAgendamentoConsulta dados);
}
