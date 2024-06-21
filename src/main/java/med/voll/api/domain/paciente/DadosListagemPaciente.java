package med.voll.api.domain.paciente;

public record DadosListagemPaciente(
        String nome,
        String Email,
        String cpf
) {
    public DadosListagemPaciente(Paciente paciente){
        this(paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}
