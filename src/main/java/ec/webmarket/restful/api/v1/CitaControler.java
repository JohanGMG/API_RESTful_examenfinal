package ec.webmarket.restful.api.v1;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ec.webmarket.restful.domain.Cita;
import ec.webmarket.restful.service.crud.CitaService;


@RestController
@RequestMapping("/api/citas")
public class CitaControler {

    @Autowired
    private CitaService citaService;

    @GetMapping
    public List<Cita> obtenerTodas() {
        return citaService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cita> obtenerPorId(@PathVariable Long id) {
        Optional<Cita> cita = citaService.obtenerPorId(id);
        return cita.map(ResponseEntity::ok)
                  .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cita guardar(@RequestBody Cita cita) {
        return citaService.guardar(cita);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        citaService.cancelar(id);
        return ResponseEntity.ok().build();
    }
}
