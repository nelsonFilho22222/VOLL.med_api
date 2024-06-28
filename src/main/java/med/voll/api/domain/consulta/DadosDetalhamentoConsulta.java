package med.voll.api.domain.consulta;

import med.voll.api.domain.medico.Especialidade;

import java.time.LocalDateTime;

public record DadosDetalhamentoConsulta (Long id, Long idMedico, Long idPaciente, LocalDateTime data, Especialidade especialidade) {
    public DadosDetalhamentoConsulta(Consulta consulta) {
        this(consulta.getId(),
                consulta.getPaciente().getId(),
                consulta.getMedico().getId(),
                consulta.getData(),
                consulta.getMedico().getEspecialidade());
    }
}
