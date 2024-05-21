package com.ucentral.MiKasa.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ClienteDto implements Serializable {
    private long serial;
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
    @NotBlank(message = "El apellido es obligatorio")
    private String apellido;
    @NotBlank(message = "El correo es obligatorio")
    private String correo;
    @NotBlank(message = "El celular es obligatorio")
    private String celular;
    @NotBlank(message = "La contraseña es obligatorio")
    private String contrasena;
}
