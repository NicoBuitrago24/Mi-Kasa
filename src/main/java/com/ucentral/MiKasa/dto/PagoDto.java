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
public class PagoDto implements Serializable {
    private Long id;
    private int monto;
    private String fechadepago;
    private String metododepago;
    private int numerodetrx;
    private String descripcion;
}
