package med.voll.api.domain.usuario;


import org.springframework.data.jpa.repository.*;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    UserDetails findByLogin(String login);
}
