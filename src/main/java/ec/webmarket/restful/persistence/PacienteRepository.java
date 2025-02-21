package ec.webmarket.restful.persistence;

import ec.webmarket.restful.domain.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, String> {
    Optional<Paciente> findByEmail(String email);
}
