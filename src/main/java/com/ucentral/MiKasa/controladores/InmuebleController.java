package com.ucentral.MiKasa.controladores;

import com.ucentral.MiKasa.dto.InmuebleDto;
import com.ucentral.MiKasa.servicios.InmuebleServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inmueble")
public class InmuebleController {

    private final InmuebleServicio inmuebleServicio;

    @Autowired
    public InmuebleController(InmuebleServicio inmuebleServicio) {
        this.inmuebleServicio = inmuebleServicio;
    }

    @GetMapping("/{id}")
    public ResponseEntity<InmuebleDto> obtenerInmueblePorId(@PathVariable Long id) {
        try {
            InmuebleDto inmuebleDto = inmuebleServicio.obtenerInmueblePorId(id);
            if (inmuebleDto != null) {
                inmuebleDto.setPropietario(null);
                return new ResponseEntity<>(inmuebleDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
