package ec.webmarket.restful.service.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ec.webmarket.restful.domain.Cita;
import ec.webmarket.restful.persistence.CitaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CitaService {

    @Autowired
    private CitaRepository citaRepository;

    public List<Cita> obtenerTodas() {
        return citaRepository.findAll();
    }

    public Optional<Cita> obtenerPorId(Long id) {
        return citaRepository.findById(id);
    }

    public Cita guardar(Cita cita) {
        return citaRepository.save(cita);
    }

    public Cita modificar(Cita cita) {
        return citaRepository.save(cita);
    }

    public void cancelar(Long id) {
        citaRepository.findById(id).ifPresent(cita -> {
            cita.setEstado("cancelada");
            citaRepository.save(cita);
        });
    }

    public List<Cita> obtenerHistorialPaciente(String cedula) {
        return citaRepository.findByPaciente_Cedula(cedula);
    }

    public List<Cita> obtenerHistorialOdontologo(String cedula) {
        return citaRepository.findByOdontologo_Cedula(cedula);
    }
    
    public List<Cita> obtenerCitasPorOdontologo(String cedula) {  
        return citaRepository.findByOdontologo_Cedula(cedula);
    }
}
