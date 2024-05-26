package com.ucentral.MiKasa.entidades;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Fetch;

import java.io.Serializable;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Propietarios")
@Table(name = "PROPI_REL")
@ToString
public class Propietario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PROPI_REL")
    @SequenceGenerator(name = "SEQ_PROPI_REL", sequenceName = "SEQ_PROPI_REL", allocationSize = 1)
    @Column(name = "PROPI_CODIGO", nullable = false)
    private long id;

    @Column(name = "PROPI_NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "PROPI_APELLIDO", nullable = false)
    private String apellido;

    @Column(name = "PROPI_CORREO", nullable = false)
    private String correo;

    @Column(name = "PROPI_CONTRASENA", nullable = false)
    private String contrasena;

    @OneToMany(mappedBy = "propietario", cascade = CascadeType.ALL)
    private List<Inmueble> inmuebles;
}
