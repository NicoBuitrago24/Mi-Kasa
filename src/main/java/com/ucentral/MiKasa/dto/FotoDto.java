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

public class FotoDto implements Serializable {
    private Long id;
    private String habitación;
    private String bano;
    private String frente;
    private String interior;
    private String cocina;
}

