package ec.webmarket.restful.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ec.webmarket.restful.domain.Horario;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Long> {
    List<Horario> findByOdontologo_Cedula(String cedula);
    List<Horario> findByFecha(LocalDate fecha);
    List<Horario> findByDisponible(Boolean disponible);
}
