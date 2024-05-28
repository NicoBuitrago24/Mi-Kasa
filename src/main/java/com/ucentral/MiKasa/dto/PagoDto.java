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
    private Integer monto;
    private String fechadepago;
    private String metododepago;
    private  Integer numerodetrx;
    private String descripcion;
}
