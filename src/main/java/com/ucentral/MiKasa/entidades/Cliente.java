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
@Entity(name = "Clientes")
@Table(name = "CLIEN_REL")
@ToString

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CLIEN_REL")
    @SequenceGenerator(name = "SEQ_CLIEN_REL", sequenceName = "SEQ_CLIEN_REL", allocationSize = 1)
    @Column(name = "CLIEN_CODIGO", nullable = false)
    private long serial;

    @Column(name = "CLIEN_NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "CLIEN_APELLIDO", nullable = false)
    private String apellido;

    @Column(name = "CLIEN_CORREO", nullable = false)
    private String correo;

    @Column(name = "CLIEN_CELULAR", nullable = false)
    private String celular;

    @Column(name = "CLIEN_CONTRASENA", nullable = false)
    private String contrasena;
}
