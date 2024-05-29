package com.ucentral.MiKasa.controladores;

import com.ucentral.MiKasa.dto.FotoDto;
import com.ucentral.MiKasa.dto.InmuebleDto;
import com.ucentral.MiKasa.dto.PropietarioDto;
import com.ucentral.MiKasa.servicios.FotoServicio;
import com.ucentral.MiKasa.servicios.InmuebleServicio;
import com.ucentral.MiKasa.servicios.ReservaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@SessionAttributes("propietarioDto")
@RequestMapping("/propietario")
public class PropietarioController {

    @Autowired
    InmuebleServicio inmuebleServicio;

    @Autowired
    ReservaServicio reservaServicio;

    @Autowired
    FotoServicio fotoServicio;

    @GetMapping
    public String clienteHome(Model model) {
        PropietarioDto propietarioDto = (PropietarioDto) model.getAttribute("propietarioDto");
        if (propietarioDto == null) {
            return "redirect:/";
        }
        model.addAttribute("propietario", propietarioDto);
        model.addAttribute("inmuebles", inmuebleServicio.obtenerInmueblesPorPropietario(propietarioDto.getId()));
        return "propietario";
    }

    @GetMapping("/agregarInmueble")
    public String agregarInmueble(Model model) {
        FotoDto fotoDto = new FotoDto();
        model.addAttribute("foto", fotoDto);
        InmuebleDto inmuebleDto = new InmuebleDto();
        inmuebleDto.setAprobado(false);
        inmuebleDto.setReservas(new ArrayList<>());
        inmuebleDto.setPropietario((PropietarioDto) model.getAttribute("propietarioDto"));
        model.addAttribute("inmueble", inmuebleDto);
        return "agregarInmueble";
    }

    @PostMapping("/agregarInmueble")
    public ResponseEntity<String> publicarInmueble(@ModelAttribute InmuebleDto inmuebleDto, @ModelAttribute FotoDto fotoDto) {
        return ResponseEntity.ok("success");
    }
}
