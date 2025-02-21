package ec.webmarket.restful.dto.v1;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class PacienteDTO {
    private String cedula;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private LocalDate fechaNacimiento;
    private String direccion;
    private Long usuarioId; // Relación con Usuario
}
