package ec.webmarket.restful.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ec.webmarket.restful.domain.Cita;
import ec.webmarket.restful.domain.Odontologo;
import ec.webmarket.restful.service.crud.CitaService;
import ec.webmarket.restful.service.crud.OdontologoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/odontologos")
public class OdontologoControler {

    @Autowired
    private OdontologoService odontologoService;
    
    @Autowired
    private CitaService citaService;

    @GetMapping
    public List<Odontologo> obtenerTodos() {
        return odontologoService.obtenerTodos();
    }

    @GetMapping("/{cedula}")
    public ResponseEntity<Odontologo> obtenerPorCedula(@PathVariable String cedula) {
        return odontologoService.obtenerPorCedula(cedula)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Odontologo guardar(@RequestBody Odontologo odontologo) {
        return odontologoService.guardar(odontologo);
    }

    @DeleteMapping("/{cedula}")
    public ResponseEntity<Void> eliminar(@PathVariable String cedula) {
        odontologoService.eliminar(cedula);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/especialidad/{especialidad}")
    public List<Odontologo> obtenerPorEspecialidad(@PathVariable String especialidad) {
        return odontologoService.obtenerPorEspecialidad(especialidad);
    }
    
    @GetMapping("/{cedula}/citas")  
    public ResponseEntity<List<Cita>> obtenerCitasPorOdontologo(@PathVariable String cedula) {
        List<Cita> citas = citaService.obtenerCitasPorOdontologo(cedula);
        return citas.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(citas);
    }
}
