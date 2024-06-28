package med.voll.api.domain.consulta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.medico.Especialidade;

import java.time.LocalDateTime;

// Trecho de código suprimido

public record DadosAgendamentoConsulta(

        @NotNull
        Long idPaciente,

        Long idMedico,



        @NotNull
        @Future
        LocalDateTime data,

        Especialidade especialidade) {
}
