package ec.webmarket.restful.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ec.webmarket.restful.domain.Horario;
import ec.webmarket.restful.service.crud.HorarioService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/horarios")
public class HorarioControler {

    @Autowired
    private HorarioService horarioService;

    @GetMapping
    public List<Horario> obtenerTodos() {
        return horarioService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Horario> obtenerPorId(@PathVariable Long id) {
        Optional<Horario> horario = horarioService.obtenerPorId(id);
        return horario.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Horario guardar(@RequestBody Horario horario) {
        return horarioService.guardar(horario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Horario> actualizarHorario(@PathVariable Long id, @RequestBody Horario horario) {
        return ResponseEntity.ok(horarioService.actualizarHorario(id, horario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        horarioService.eliminar(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}/bloquear")
    public ResponseEntity<Void> bloquearHorario(@PathVariable Long id) {
        horarioService.bloquearHorario(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/odontologo/{cedula}")
    public List<Horario> obtenerPorOdontologo(@PathVariable String cedula) {
        return horarioService.obtenerPorOdontologo(cedula);
    }

    @GetMapping("/fecha/{fecha}")
    public List<Horario> obtenerPorFecha(@PathVariable LocalDate fecha) {
        return horarioService.obtenerPorFecha(fecha);
    }

    @GetMapping("/disponibles/{disponible}")
    public List<Horario> obtenerDisponibles(@PathVariable Boolean disponible) {
        return horarioService.obtenerDisponibles(disponible);
    }
}
