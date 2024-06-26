package com.ucentral.MiKasa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ClienteDto implements Serializable {
    private Long id;
    private String nombre;
    private String apellido;
    private String correo;
    private String celular;
    private String contrasena;
    private List<ReservaDto> reservas;
}
