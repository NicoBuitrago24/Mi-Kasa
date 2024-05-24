package com.ucentral.MiKasa.controladores;

import com.ucentral.MiKasa.dto.PropietarioDto;
import com.ucentral.MiKasa.servicios.PropietarioServicio;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PropietarioControlador {
    private static final Logger logger = LogManager.getLogger(InmuebleControlador.class);

    @Autowired
    private PropietarioServicio servicioPropietario;

    @GetMapping("/propietarios")
    public String ListarPropietarios(Model model){
        logger.info("Obteniendo lista de propietarios");
        List<PropietarioDto> propietarios = servicioPropietario.obtenerPropietarios();
        if (propietarios.isEmpty()) {
            model.addAttribute("mensaje", "No hay propietarios");
        }
        model.addAttribute("propietarios", propietarios);
        return "propietario";

    }

    @GetMapping ("/propietarios/nuevos")
    public String mostrarFormulario(Model model){
        PropietarioDto propietarioDto = new PropietarioDto();
        model.addAttribute("propietario", propietarioDto);
        return "crear_propietarios";
    }
    @PostMapping("propietarios/nuevos")
    public String CrearPropietario(@ModelAttribute("propietario") PropietarioDto propietarioDto, Model model){
        try{
            servicioPropietario.registrarPropietario(propietarioDto);
            model.addAttribute("mensaje", "Propietario registrado correctamente") ;
            return "redirect:/propietarios";

        }catch(Exception e){
            model.addAttribute("error", "Error al registrar propietario"+ e.getMessage()); ;
        }
        return "redirect:/crear_propietario";
    }
    @GetMapping("/propietarios/modificar/{id}")
    public String mostrarFormularioModificar(@PathVariable long id, Model model) {
        PropietarioDto propietarioDto = servicioPropietario.obtenerPropietarioById(id);
        if (propietarioDto == null) {
            model.addAttribute("error", "No existe un propietario con el id " + id);
            return "redirect:/propietarios";
        }
        List<PropietarioDto> propietarios = servicioPropietario.obtenerPropietarios();
        model.addAttribute("propietarios", propietarioDto);;
        return "modificar_propietarios";
    }

    @PostMapping("/propietarios/modificar/{id}")
    public String modificarPropietario(@PathVariable long id, @ModelAttribute("propietarios") PropietarioDto propietarioDto, Model model) {
        try {
            servicioPropietario.actualizarPropietario(propietarioDto);
            model.addAttribute("mensaje", "Propietario modificado correctamente");
            return "redirect:/propietario";
        } catch (Exception e) {
            model.addAttribute("error", "Error al modificar propietario" + e.getMessage());
            return "modificar_propietarios";
        }
    }
    @GetMapping("propietarios/eliminar/{id}")
    public String eliminarPropietario(@PathVariable("id") long id, Model model){
        servicioPropietario.eliminarPropietario(id);
        return "redirect:/propietario";

    }

}

