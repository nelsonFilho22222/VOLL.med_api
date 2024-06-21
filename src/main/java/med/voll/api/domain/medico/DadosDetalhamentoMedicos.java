package med.voll.api.domain.medico;

import med.voll.api.domain.enderecoMedico.EnderecoMedico;

public record DadosDetalhamentoMedicos(Long id, String nome, String email, String crm, String telefone, Especialidade especialidade, EnderecoMedico enderecoMedico) {
   public DadosDetalhamentoMedicos (Medico medico){
       this(
               medico.getId(),
               medico.getNome(),
               medico.getEmail(),
               medico.getCrm(),
               medico.getTelefone(),
               medico.getEspecialidade(),
               medico.getEnderecoMedico()
       );
   }

}
