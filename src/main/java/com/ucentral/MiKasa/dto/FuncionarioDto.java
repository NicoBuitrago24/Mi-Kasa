package com.ucentral.MiKasa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class FuncionarioDto implements Serializable {
    private Long id;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasena;
    private String celular;
}
