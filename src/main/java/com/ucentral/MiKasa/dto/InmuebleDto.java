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
public class InmuebleDto implements Serializable {
    private Long id;

    private String ciudad;
    private String barrio;
    private String descripcion;
    private String avaluo;
    private String fotos;
    private String estado;
}
