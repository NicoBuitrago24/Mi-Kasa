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

public class ReservaDto implements Serializable {
    private long serial;
    private String fecha_inicio;
    private String fecha_fin;
    private int numerohuespedes;
    private String tipohabitacion;
    private String tipodepago;
    private InmuebleDto inmueble;
}
