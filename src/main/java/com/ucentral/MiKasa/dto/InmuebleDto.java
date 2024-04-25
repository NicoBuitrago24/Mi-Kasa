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
public class InmuebleDto implements Serializable {
    private long serial;
    @NotBlank(message = "La ciudad es obligatorio")
    private String ciudad;
    @NotBlank(message = "El barrio es obligatorio")
    private String barrio;
    @NotBlank(message = "La descripcion es obligatorio")
    private String descripcion;
    @NotBlank(message = "El avaluo es obligatorio")
    private String avaluo;
    @NotBlank(message = "Las fotos es obligatorio")
    private String fotos;
    @NotBlank(message = "El estado es obligatorio")
    private String estado;
}
