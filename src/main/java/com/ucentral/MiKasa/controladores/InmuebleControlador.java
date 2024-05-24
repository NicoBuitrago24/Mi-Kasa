package com.ucentral.MiKasa.controladores;

import com.ucentral.MiKasa.dto.InmuebleDto;
import com.ucentral.MiKasa.dto.PropietarioDto;
import com.ucentral.MiKasa.servicios.InmuebleServicio;
import com.ucentral.MiKasa.servicios.PropietarioServicio;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Log4j2
@Controller
public class InmuebleControlador {
    private static final Logger logger = LogManager.getLogger(InmuebleControlador.class);

    @Autowired
    InmuebleServicio Servicioinmuebles;

    @Autowired
    PropietarioServicio propietarioServicio;

    @GetMapping("/inmuebles")
    public String listarInmuebles(Model model) {
        logger.info("Obteniendo lista de inmuebles");
        List<InmuebleDto> inmuebles = Servicioinmuebles.obtenerInmuebles();
        if (inmuebles.isEmpty()) {
            model.addAttribute("mensaje", "No hay inmuebles");
        }
        model.addAttribute("inmuebles", inmuebles);
        return "inmuebles";
    }

    @GetMapping("/inmuebles/nuevos")
    public String mostrarFormulario(Model model) {
        InmuebleDto inmuebleDto = new InmuebleDto();
        List<PropietarioDto> propietarios = propietarioServicio.obtenerPropietarios();
        if (propietarios.isEmpty()) {
            model.addAttribute("error", "No hay propietarios disponibles. Registre un propietario antes de crear un inmueble");
        }
        model.addAttribute("propietarios", propietarios);
        model.addAttribute("inmuebleDto", inmuebleDto);
        return "crear_inmuebles";
    }

    @PostMapping("/inmuebles/nuevos")
    public String crearInmueble(@ModelAttribute InmuebleDto inmuebleDto, Model model) {
        try {
            Servicioinmuebles.registrarInmueble(inmuebleDto);
            System.out.println("si entra");
            model.addAttribute("mensaje", "Inmueble creado correctamente");
            return "redirect:/inmuebles";
        } catch (Exception e) {
            model.addAttribute("error", "Error al crear inmueble" + e.getMessage());
            return "crear_inmuebles";
        }
    }

    @GetMapping("/inmuebles/modificar/{id}")
    public String mostrarFormularioModificar(@PathVariable long id, Model model) {
        InmuebleDto inmuebleDto = Servicioinmuebles.obtenerInmuebleById(id);
        if (inmuebleDto == null) {
            model.addAttribute("error", "No existe un inmueble con el id " + id);
            return "redirect:/inmuebles";
        }
        List<PropietarioDto> propietarios = propietarioServicio.obtenerPropietarios();
        model.addAttribute("propietarios", propietarios);
        model.addAttribute("inmuebleDto", inmuebleDto);
        return "modificar_inmuebles";
    }

    @PostMapping("/inmuebles/modificar/{id}")
    public String modificarInmueble(@PathVariable long id, @ModelAttribute("inmuebles") InmuebleDto inmuebleDto, Model model) {
        try {
            Servicioinmuebles.actualizarInmueble(inmuebleDto);
            model.addAttribute("mensaje", "Inmueble modificado correctamente");
            return "redirect:/inmuebles";
        } catch (Exception e) {
            model.addAttribute("error", "Error al modificar inmueble" + e.getMessage());
            return "modificar_inmuebles";
        }
    }

    @GetMapping("/inmuebles/eliminar/{id}")
    public String eliminarInmueble(@PathVariable long id, Model model) {
        try {
            Servicioinmuebles.eliminarInmueble(id);
            model.addAttribute("mensaje", "Inmueble eliminado correctamente");
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar inmueble" + e.getMessage());
        }
        return "redirect:/inmuebles";
    }
}

