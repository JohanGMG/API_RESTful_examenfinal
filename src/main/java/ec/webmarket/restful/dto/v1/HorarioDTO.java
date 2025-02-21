package ec.webmarket.restful.dto.v1;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class HorarioDTO {
    private Long id;
    private String odontologoCedula;
    private LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private Boolean disponible;
}
