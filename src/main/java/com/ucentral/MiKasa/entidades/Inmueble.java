package com.ucentral.MiKasa.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Inmuebles")
@Table(name = "INMU_REL")
@ToString
public class Inmueble implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_INMU_REL")
    @SequenceGenerator(name = "SEQ_INMU_REL", sequenceName = "SEQ_INMU_REL", allocationSize = 1)
    @Column(name = "INMU_CODIGO", nullable = false)
    private long id;

    @Column(name = "INMU_CIUDAD", nullable = false)
    private String ciudad;

    @Column(name = "INMU_BARRIO", nullable = false)
    private String barrio;

    @Column(name = "INMU_DESCRIPCION", nullable = false)
    private String descripcion;

    @Column(name = "INMU_AVALUO", nullable = false)
    private int avaluo;

    @Column(name = "INMU_VALNOCHE", nullable = false)
    private int valorNoche;

    @Column(name = "INMU_DIRECCION", nullable = false)
    private String direccion;

    @Column(name = "INMU_APROBADO", nullable = false)
    private boolean aprobado;

    @OneToMany(mappedBy = "inmueble", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reserva> reservas;

    @ManyToOne
    @JoinColumn(name = "PROPI_CODIGO", referencedColumnName = "PROPI_CODIGO")
    private Propietario propietario;
}
