package ec.webmarket.restful.dto.v1;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {
    private Long id;
    private String nombreUsuario;
    private String tipoUsuario;
}
