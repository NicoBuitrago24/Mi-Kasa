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

public class FotoDto implements Serializable {
    private long serial;
    @NotBlank(message = "Foto de la habitación principal")
    private String habitación;
    @NotBlank(message = "Foto del baño principal")
    private String bano;
    @NotBlank(message = "Foto del frente del inmueble")
    private String frente;
    @NotBlank(message = "Foto del interior del inmueble")
    private String interior;
    @NotBlank(message = "Foto de la cocina del inmueble")
    private String cocina;
}

