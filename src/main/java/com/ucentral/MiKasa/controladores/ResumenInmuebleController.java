package com.ucentral.MiKasa.controladores;

import com.ucentral.MiKasa.dto.InmuebleDto;
import com.ucentral.MiKasa.servicios.InmuebleServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ResumenInmuebleController {

    @Autowired
    private InmuebleServicio inmuebleServicio;

    @GetMapping("/resumen/{id}")
    public String verDetalles(@PathVariable Long id, Model model) {
        InmuebleDto inmueble = inmuebleServicio.obtenerInmueblePorId(id);
        if (inmueble == null) {
            return "redirect:/propietario";
        }
        model.addAttribute("inmueble", inmueble);
        return "resumenInmueble";
    }
}
