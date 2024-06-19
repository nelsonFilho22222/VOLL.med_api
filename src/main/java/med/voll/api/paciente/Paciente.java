package med.voll.api.paciente;

import jakarta.persistence.*;
import lombok.*;

import med.voll.api.endereco.Endereco;



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
    private Endereco endereco;


    public Paciente(DadosPacientes dadospaciente) {
        this.ativo = true;
        this.nome = dadospaciente.nome();
        this.email = dadospaciente.email();
        this.telefone = dadospaciente.telefone();
        this.cpf = dadospaciente.cpf();
        this.endereco = new Endereco(dadospaciente.endereco());
    }


}

