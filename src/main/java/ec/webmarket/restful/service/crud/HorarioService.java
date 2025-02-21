package ec.webmarket.restful.service.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ec.webmarket.restful.domain.Horario;
import ec.webmarket.restful.persistence.HorarioRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class HorarioService {

    @Autowired
    private HorarioRepository horarioRepository;

    public List<Horario> obtenerTodos() {
        return horarioRepository.findAll();
    }

    public Optional<Horario> obtenerPorId(Long id) {
        return horarioRepository.findById(id);
    }

    public Horario guardar(Horario horario) {
        return horarioRepository.save(horario);
    }

    public void eliminar(Long id) {
        horarioRepository.deleteById(id);
    }

    public List<Horario> obtenerPorOdontologo(String cedula) {
        return horarioRepository.findByOdontologo_Cedula(cedula);
    }

    public List<Horario> obtenerPorFecha(LocalDate fecha) {
        return horarioRepository.findByFecha(fecha);
    }

    public List<Horario> obtenerDisponibles(Boolean disponible) {
        return horarioRepository.findByDisponible(disponible);
    }

    public Horario actualizarHorario(Long id, Horario horario) {
        return horarioRepository.findById(id)
                .map(h -> {
                    h.setFecha(horario.getFecha());
                    h.setHoraInicio(horario.getHoraInicio());
                    h.setHoraFin(horario.getHoraFin());
                    h.setDisponible(horario.getDisponible());
                    return horarioRepository.save(h);
                })
                .orElseThrow(() -> new RuntimeException("Horario no encontrado"));
    }

    public void bloquearHorario(Long id) {
        horarioRepository.findById(id).ifPresent(h -> {
            h.setDisponible(false);
            horarioRepository.save(h);
        });
    }
}
