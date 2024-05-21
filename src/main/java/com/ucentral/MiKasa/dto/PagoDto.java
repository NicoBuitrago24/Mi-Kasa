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
public class PagoDto implements Serializable {
    private long serial;
    @NotBlank(message = "El monto es obligatorio")
    private String monto;
    @NotBlank(message = "La fecha de pago es obligatoria")
    private String fechadepago;
    @NotBlank(message = "EL metodo de pago es obligatorio")
    private String metododepago;
    @NotBlank(message = "El numero de la transacción es obligatorio")
    private String numerodetrx;
    @NotBlank(message = "La descripción del pago es obligatorio")
    private String descripcion;
}
