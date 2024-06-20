package med.voll.api.paciente;


import med.voll.api.endereco_Paciente.EnderecoPaciente;

public record DadosDetalhamentoPaciente(Long id, String nome, String crm, String telefone, EnderecoPaciente enderecoPaciente) {
    public DadosDetalhamentoPaciente(Paciente paciente){
        this(
                paciente.getId(),
                paciente.getNome(),
                paciente.getEmail(),
                paciente.getTelefone(),
                paciente.getEnderecoPaciente()
        );
    }

}
