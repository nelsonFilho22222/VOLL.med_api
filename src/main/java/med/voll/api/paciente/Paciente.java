package med.voll.api.paciente;

import jakarta.persistence.*;
import lombok.*;

import med.voll.api.enderecoMedico.EnderecoMedico;
import med.voll.api.endereco_Paciente.EnderecoPaciente;


@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Paciente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;

    private boolean ativo;

    @Embedded
    private EnderecoPaciente enderecoPaciente;


    public Paciente(DadosPacientes dadospaciente) {
        this.ativo = true;
        this.nome = dadospaciente.nome();
        this.email = dadospaciente.email();
        this.telefone = dadospaciente.telefone();
        this.cpf = dadospaciente.cpf();
        this.enderecoPaciente = new EnderecoPaciente(dadospaciente.endereco());
    }

    public void atualizarInformacoes(DadosAtualizacaoPaciente dados) {
        if (dados.nome() != null)
        {
            this.nome = dados.nome();
        }
        if (dados.telefone() != null)
        {
            this.telefone = dados.telefone();
        }
    }
    public void excluirPaciente() {
        this.ativo = false;
    }

}

