package med.voll.api.medico;

import io.micrometer.observation.ObservationFilter;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

//os metodos do CRUD estão no JpaRepository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> findAllByAtivoTrue(Pageable paginacao);
}
