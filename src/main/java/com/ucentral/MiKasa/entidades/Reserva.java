package com.ucentral.MiKasa.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "Reservas")
@Table(name = "RESER_REL")
@ToString
public class Reserva implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_RESER_REL")
    @SequenceGenerator(name = "SEQ_RESER_REL", sequenceName = "SEQ_RESER_REL", allocationSize = 1)
    @Column(name = "RESER_CODIGO", nullable = false)
    private long id;

    @Column(name = "RESER_FECHAINICIO", nullable = false)
    private LocalDate fecha_inicio;

    @Column(name = "RESER_FECHAFIN", nullable = false)
    private LocalDate fecha_fin;

    @Column(name = "RESER_NUMEROHUESPEDES", nullable = false)
    private int numerohuespedes;

    @Column(name = "RESER_TIPODEHABITACION", nullable = false)
    private double valor;

    @Column(name = "RESER_TIPODEPAGO", nullable = false)
    private String tipodepago;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLIEN_CODIGO", referencedColumnName = "CLIEN_CODIGO")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "INMU_CODIGO", referencedColumnName = "INMU_CODIGO")
    private Inmueble inmueble;

}