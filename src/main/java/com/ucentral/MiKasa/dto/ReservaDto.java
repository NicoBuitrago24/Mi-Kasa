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

public class ReservaDto implements Serializable {
    private long serial;
    @NotBlank(message = "El nombre es obligatorio")
    private String fecha_inicio;
    @NotBlank(message = "El apellido es obligatorio")
    private String fecha_fin;
    @NotBlank(message = "El correo es obligatorio")
    private String numerohuespedes;
    @NotBlank(message = "La contraseña es obligatorio")
    private String tipohabitacion;
    @NotBlank(message = "Tipo de pago es obligatorio")
    private String tipodepago;
}
