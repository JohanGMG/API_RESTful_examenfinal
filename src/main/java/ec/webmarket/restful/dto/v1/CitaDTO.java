package ec.webmarket.restful.dto.v1;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CitaDTO {
    private Long id;
    private String pacienteCedula;
    private String odontologoCedula;
    private Long horarioId;
    private LocalDateTime fechaHora;
    private String estado;
    private String motivo;
}
