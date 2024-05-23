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
    private String monto;
    private String fechadepago;
    private String metododepago;
    private String numerodetrx;
    private String descripcion;
}
