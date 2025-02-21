package ec.webmarket.restful.service.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ec.webmarket.restful.domain.Odontologo;
import ec.webmarket.restful.persistence.OdontologoRepository;
import ec.webmarket.restful.persistence.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {

    @Autowired
    private OdontologoRepository odontologoRepository;
    
    @Autowired
    private CitaService citaService;
    
    @Autowired
    private UsuarioRepository usuarioRepository; 

    public List<Odontologo> obtenerTodos() {
        return odontologoRepository.findAll();
    }

    public Odontologo guardar(Odontologo odontologo) {
        return odontologoRepository.save(odontologo);
    }

    public Optional<Odontologo> obtenerPorCedula(String cedula) {
        return odontologoRepository.findById(cedula);
    }

    public void eliminar(String cedula) {
        odontologoRepository.deleteById(cedula);
    }

    public List<Odontologo> obtenerPorEspecialidad(String especialidad) {
        return odontologoRepository.findByEspecialidad(especialidad);
    }
    
    
}
