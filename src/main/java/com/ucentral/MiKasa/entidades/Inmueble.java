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
@Entity(name = "Inmuebles")
@Table(name = "INMU_REL")
@ToString
public class Inmueble implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_INMUEBLES_REL")
    @SequenceGenerator(name = "SEQ_INMUEBLES_REL", sequenceName = "SEQ_INMUEBLES_REL", allocationSize = 1)
    @Column(name = "INMU_CODIGO", nullable = false)
    private long serial;

    @Column(name = "INMU_CIUDAD", nullable = false)
    private String ciudad;

    @Column(name = "INMU_BARRIO", nullable = false)
    private String barrio;

    @Column(name = "INMU_DESCRIPCION", nullable = false)
    private String descripcion;

    @Column(name = "INMU_AVALUO", nullable = false)
    private String avaluo;

    @Column(name = "INMU_FOTOS", nullable = false)
    private String fotos;

    @Column(name = "INMU_ESTADO", nullable = false)
    private String estado;

}
