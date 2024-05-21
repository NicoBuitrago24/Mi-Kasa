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
@Entity(name = "Fotos")
@Table(name = "FOTO_REL")
@ToString

public class Foto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_FOTO_REL")
    @SequenceGenerator(name = "SEQ_FOTO_REL", sequenceName = "SEQ_FOTO_REL", allocationSize = 1)
    @Column(name = "FOTO_CODIGO", nullable = false)
    private long serial;

    @Column(name = "FOTO_HABITACION", nullable = false)
    private String habitacion;

    @Column(name = "FOTO_BANO", nullable = false)
    private String bano;

    @Column(name = "FOTO_FRENTE", nullable = false)
    private String frente;

    @Column(name = "FOTO_INTERIOR", nullable = false)
    private String interior;

    @Column(name = "FOTO_COCINA", nullable = false)
    private String cocina;
}
