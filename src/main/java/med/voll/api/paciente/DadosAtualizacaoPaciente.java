package med.voll.api.paciente;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPaciente(
        @NotNull
        Long Id,
        String nome,
        String telefone,
        String endereco
)
{
}
