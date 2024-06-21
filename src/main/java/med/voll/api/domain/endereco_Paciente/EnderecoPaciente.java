package med.voll.api.domain.endereco_Paciente;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import med.voll.api.domain.enderecoMedico.DadosEnderecoMedico;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoPaciente {
    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;


    public EnderecoPaciente(DadosEnderecoMedico enderecoPaciente) {
        this.logradouro = enderecoPaciente.logradouro();
        this.bairro = enderecoPaciente.bairro();
        this.cep = enderecoPaciente.cep();
        this.uf = enderecoPaciente.uf();
        this.cidade = enderecoPaciente.cidade();
        this.numero = enderecoPaciente.numero();
        this.complemento = enderecoPaciente.complemento();
    }

    public void atualizarInformacoesPaciente(DadosEnderecoPaciente dados)
    {
        if(dados.logradouro() != null )
        {
            this.logradouro = dados.logradouro();
        }
        if(dados.bairro() != null )
        {
            this.bairro = dados.bairro();
        }
        if(dados.cep() != null )
        {
            this.cep = dados.cep();
        }
        if(dados.uf() != null)
        {
            this.uf = dados.uf();
        }
        if(dados.cidade() != null )
        {
            this.cidade = dados.cidade();
        }
        if(dados.numero() != null )
        {
            this.numero = dados.numero();
        }
        if(dados.complemento() != null )
        {
            this.complemento = dados.complemento();
        }
    }


}

