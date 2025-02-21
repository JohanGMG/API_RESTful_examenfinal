package ec.webmarket.restful.service.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ec.webmarket.restful.domain.Usuario;
import ec.webmarket.restful.persistence.UsuarioRepository;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario registrarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario); 
    }

    public Optional<Usuario> autenticarUsuario(String nombreUsuario, String clave) {
        Optional<Usuario> usuario = usuarioRepository.findByNombreUsuario(nombreUsuario);
        return usuario.filter(u -> u.getClave().equals(clave));
    }

    public void actualizarClave(Long id, String nuevaClave) {
        usuarioRepository.findById(id).ifPresent(usuario -> {
            usuario.setClave(nuevaClave); 
            usuarioRepository.save(usuario);
        });
    }
}
