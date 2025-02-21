package ec.webmarket.restful.persistence;

import ec.webmarket.restful.domain.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OdontologoRepository extends JpaRepository<Odontologo, String> {
    List<Odontologo> findByEspecialidad(String especialidad);
}
