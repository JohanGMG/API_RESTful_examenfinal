package ec.webmarket.restful.service.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import ec.webmarket.restful.domain.Paciente;
import ec.webmarket.restful.persistence.PacienteRepository;
import ec.webmarket.restful.persistence.UsuarioRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository; 

    public List<Paciente> obtenerTodos() {
        return pacienteRepository.findAll();
    }

    @Transactional
    public Paciente guardar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Optional<Paciente> obtenerPorCedula(String cedula) {
        return pacienteRepository.findById(cedula);
    }

    public Optional<Paciente> obtenerPorEmail(String email) {
        return pacienteRepository.findByEmail(email);
    }

    @Transactional
    public Paciente actualizarPaciente(String cedula, Paciente pacienteActualizado) {
        return pacienteRepository.findById(cedula).map(paciente -> {
            paciente.setNombre(pacienteActualizado.getNombre());
            paciente.setApellido(pacienteActualizado.getApellido());
            paciente.setTelefono(pacienteActualizado.getTelefono());
            paciente.setEmail(pacienteActualizado.getEmail());
            paciente.setFechaNacimiento(pacienteActualizado.getFechaNacimiento());
            paciente.setDireccion(pacienteActualizado.getDireccion());
            return pacienteRepository.save(paciente);
        }).orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
    }

    @Transactional
    public void eliminar(String cedula) {
        pacienteRepository.deleteById(cedula);
    }
}
