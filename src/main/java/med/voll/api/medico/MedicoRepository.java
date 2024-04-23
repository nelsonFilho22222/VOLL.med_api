package med.voll.api.medico;

import org.springframework.data.jpa.repository.JpaRepository;

//os metodos do CRUD estão no JpaRepository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
