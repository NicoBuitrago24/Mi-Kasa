package com.ucentral.MiKasa.controladores;

import com.ucentral.MiKasa.dto.FotoDto;
import com.ucentral.MiKasa.servicios.FotoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("fotos")
public class FotoControlador {

    private final FotoServicio fotoServicio;

    @Autowired
    public FotoControlador(FotoServicio fotoServicio) {this.fotoServicio = fotoServicio;}

    @PostMapping("/registrar")
    public ResponseEntity<String> registrarFoto(@RequestBody FotoDto fotoDto) {
        try{
            fotoServicio.registrarFoto(fotoDto);
            return ResponseEntity.ok("Foto registrado correctamente");
        }catch (Exception e){
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al registrar la foto" +e.getMessage());
        }
    }
}
