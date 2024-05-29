package com.ucentral.MiKasa.dto;

import com.ucentral.MiKasa.entidades.Inmueble;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.io.Serializable;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
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
    private InmuebleDto inmueble;
}

