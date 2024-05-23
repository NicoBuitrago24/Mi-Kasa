package com.ucentral.MiKasa.controladores;

import com.ucentral.MiKasa.dto.PagoDto;
import com.ucentral.MiKasa.servicios.PagoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pagos")
public class PagoControlador {
    private final PagoServicio pagoServicio;

    @Autowired
    public PagoControlador(PagoServicio pagoServicio) {this.pagoServicio = pagoServicio;}

    @PostMapping("/registar")
    public ResponseEntity<String> registrarPago(@RequestBody PagoDto pagoDto) {
        try{
            pagoServicio.registrarPago(pagoDto);
            return ResponseEntity.ok("Foto Registrada correctamente");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al registrar la foto"+ e.getMessage());
        }
    }
}
