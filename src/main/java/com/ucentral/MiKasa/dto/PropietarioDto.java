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
public class PropietarioDto implements Serializable {
    private long serial;
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
    @NotBlank(message = "El apellido es obligatorio")
    private String apellido;
    @NotBlank(message = "El correo es obligatorio")
    private String correo;
    @NotBlank(message = "La contraseña es obligatorio")
    private String contrasena;
    @NotBlank(message = "El inmueble es obligatorio")
    private String inmueble;
}
