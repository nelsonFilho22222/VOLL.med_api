package med.voll.api.domain.medico;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.domain.enderecos.enderecoMedico.EnderecoMedico;


@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
//Para o lombok gerar codigos mais verbosos de forma altomatica
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Medico {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String telefone;

    private String crm;

    private Boolean ativo;

    /*-------*/

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;


    //esquema de Embaddable Atrribute, para que fique em uma classe separada, mas na mesma tabela no BD
        @Embedded
    private EnderecoMedico enderecoMedico;

    public Medico(DadosCadastroMedico dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.enderecoMedico = new EnderecoMedico(dados.endereco());
    }

    public void atualizarInformacoes(DadosAtualizacaoMedico dados) {
        if (dados.nome() != null)
        {
            this.nome = dados.nome();
        }
        if (dados.telefone() != null)
        {
            this.telefone = dados.telefone();
        }
        if(dados.endereco() != null)
        {
            this.enderecoMedico.atualizarInformacoesMedico(dados.endereco()); ;
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
