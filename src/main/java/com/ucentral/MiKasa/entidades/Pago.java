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
@Entity(name = "Pagos")
@Table(name = "PAGO_REL")
@ToString

public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PAGO_REL")
    @SequenceGenerator(name = "SEQ_PAGO_REL", sequenceName = "SEQ_PAGO_REL", allocationSize = 1)
    @Column(name = "PAGO_CODIGO", nullable = false)
    private long serial;

    @Column(name = "PAGO_MONTO", nullable = false)
    private String monto    ;

    @Column(name = "PAGO_FECHADEPAGO", nullable = false)
    private String fechadepago;

    @Column(name = "PAGO_METODODEPAGO", nullable = false)
    private String metododepago;

    @Column(name = "PAGO_NUMERODETRX", nullable = false)
    private String numerodetrx;

    @Column(name = "PAGO_DESCRIPCION", nullable = false)
    private String descripcion;
}
