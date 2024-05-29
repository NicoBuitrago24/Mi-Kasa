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
@Entity(name="Funcionarios")
@Table(name = "FUNCI_REL")
@ToString

public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_FUNCI_REL")
    @SequenceGenerator(name = "SEQ_FUNCI_REL", sequenceName = "SEQ_FUNCI_REL", allocationSize = 1)
    @Column(name = "FUNCI_CODIGO", nullable = false)

    private long id;

    @Column(name = "FUNCI_NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "FUNCI_APELLIDO", nullable = false)
    private String apellido;

    @Column(name = "FUNCI_CORREO", nullable = false)
    private String correo;

    @Column(name = "FUNCI_CONTRASENA", nullable = false)
    private String contrasena;

    @Column(name = "FUNCI_CELULAR", nullable = false)
    private int celular;

}
