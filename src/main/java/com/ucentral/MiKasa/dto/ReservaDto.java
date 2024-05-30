package com.ucentral.MiKasa.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.cglib.core.Local;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class ReservaDto implements Serializable {
    private long id;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
    private int numerohuespedes;
    private double valor;
    private String tipodepago;
    private ClienteDto cliente;
    private InmuebleDto inmueble;
}
