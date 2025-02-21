package ec.webmarket.restful.api.v1;

import ec.webmarket.restful.domain.Usuario;
import ec.webmarket.restful.service.crud.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registro")
    public ResponseEntity<Usuario> registrarUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.registrarUsuario(usuario));
    }

    @PostMapping("/login")
    public ResponseEntity<String> autenticarUsuario(@RequestParam String nombreUsuario, @RequestParam String clave) {
        Optional<Usuario> usuario = usuarioService.autenticarUsuario(nombreUsuario, clave);
        return usuario.isPresent() 
            ? ResponseEntity.ok("Autenticación exitosa") 
            : ResponseEntity.status(401).body("Credenciales incorrectas");
    }

    @PutMapping("/{id}/clave")
    public ResponseEntity<Void> actualizarClave(@PathVariable Long id, @RequestBody String nuevaClave) {
        usuarioService.actualizarClave(id, nuevaClave);
        return ResponseEntity.ok().build();
    }
}
