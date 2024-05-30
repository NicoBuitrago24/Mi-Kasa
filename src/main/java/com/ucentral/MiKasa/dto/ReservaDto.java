package com.ucentral.MiKasa.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class ReservaDto implements Serializable {
    private long id;
    private Date fecha_inicio;
    private Date fecha_fin;
    private int numerohuespedes;
    private String tipohabitacion;
    private String tipodepago;
    private InmuebleDto inmueble;
}
