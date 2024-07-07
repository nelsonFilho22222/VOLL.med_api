package med.voll.api.domain.paciente;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import med.voll.api.domain.enderecos.endereco_Paciente.EnderecoPaciente;


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


    public Paciente(@Valid DadosCadastroPacientes dadospaciente) {
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

    public Paciente(DadosPaciente dadospaciente){
        this.nome = dadospaciente.nome();
        this.email = dadospaciente.email();
        this.cpf = dadospaciente.cpf();
    }



    public void excluirPaciente() {
       this.ativo = false;
    }

}

