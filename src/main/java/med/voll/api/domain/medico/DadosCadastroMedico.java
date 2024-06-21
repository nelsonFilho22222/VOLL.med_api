package med.voll.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import med.voll.api.domain.enderecoMedico.DadosEnderecoMedico;

public record DadosCadastroMedico(

        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String telefone,

        @NotBlank
        //Expressão regular, para limitar o tamanho do CRM, o \\d pra ser digitos e o (n,nM) onde n é o minimo e nM é o maximo
        @Pattern(regexp = "\\d{4,6}")
        String crm,

        @NotNull
        //por ser uma Enum o proprio Spring espera uma resposta referente a um dos elemntos da Enum
        Especialidade especialidade,

        @NotNull
        @Valid
        DadosEnderecoMedico endereco
)
{
}
