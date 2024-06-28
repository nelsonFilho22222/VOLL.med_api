package med.voll.api.domain.paciente;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Page<Paciente> findAllByAtivoTrue(Pageable paginas);

    @Query("""
select p.ativo from Paciente p
where 
p.id = :idPaciente
""")
    Boolean findAtivoById(Long idPaciente);
}

