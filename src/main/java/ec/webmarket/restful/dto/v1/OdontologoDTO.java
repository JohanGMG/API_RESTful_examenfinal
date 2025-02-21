package ec.webmarket.restful.dto.v1;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OdontologoDTO {
    private String cedula;
    private String nombre;
    private String apellido;
    private String especialidad;
    private String telefono;
    private String email;
    private Long usuarioId; // Relación con Usuario
}
