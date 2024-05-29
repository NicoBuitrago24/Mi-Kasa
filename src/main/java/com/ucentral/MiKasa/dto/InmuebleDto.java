package com.ucentral.MiKasa.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class InmuebleDto implements Serializable {
    private Long id;
    private String ciudad;
    private String barrio;
    private String descripcion;
    private int avaluo;
    private String direccion;
    private boolean aprobado;
    private FotoDto fotos;
    private PropietarioDto propietario;
    private List<ReservaDto> reservas;
}