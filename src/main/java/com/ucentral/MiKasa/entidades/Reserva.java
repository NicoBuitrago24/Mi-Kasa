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
    private String fecha_inicio;

    @Column(name = "RESER_FECHAFIN", nullable = false)
    private String fecha_fin;

    @Column(name = "RESER_NUMEROHUESPEDES", nullable = false)
    private String numerohuespedes;

    @Column(name = "RESER_TIPODEHABITACION", nullable = false)
    private String tipohabitacion;

    @Column(name = "RESER_TIPODEPAGO", nullable = false)
    private String tipodepago;

    @ManyToOne
    @JoinColumn(name = "INMU_CODIGO", referencedColumnName = "INMU_CODIGO")
    private Inmueble inmueble;

}