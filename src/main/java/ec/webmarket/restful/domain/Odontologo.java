package ec.webmarket.restful.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "odontologo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Odontologo {

    @Id
    private String cedula;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false)
    private String especialidad;

    @Column(nullable = false, length = 15)
    private String telefono;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "odontologo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cita> citas;
}
