package ec.webmarket.restful.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ec.webmarket.restful.domain.Paciente;
import ec.webmarket.restful.service.crud.PacienteService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteControler {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public List<Paciente> obtenerTodos() {
        return pacienteService.obtenerTodos();
    }

    @GetMapping("/{cedula}")
    public ResponseEntity<Paciente> obtenerPorCedula(@PathVariable String cedula) {
        return pacienteService.obtenerPorCedula(cedula)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Paciente> obtenerPorEmail(@PathVariable String email) {
        return pacienteService.obtenerPorEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Paciente guardar(@RequestBody Paciente paciente) {
        return pacienteService.guardar(paciente);
    }

    @PutMapping("/{cedula}")
    public ResponseEntity<Paciente> actualizarPaciente(@PathVariable String cedula, @RequestBody Paciente paciente) {
        return ResponseEntity.ok(pacienteService.actualizarPaciente(cedula, paciente));
    }

    @DeleteMapping("/{cedula}")
    public ResponseEntity<Void> eliminar(@PathVariable String cedula) {
        pacienteService.eliminar(cedula);
        return ResponseEntity.ok().build();
    }
}
