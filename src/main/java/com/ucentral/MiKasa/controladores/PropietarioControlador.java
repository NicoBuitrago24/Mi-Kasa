package com.ucentral.MiKasa.controladores;

import com.ucentral.MiKasa.dto.PropietarioDto;
import com.ucentral.MiKasa.servicios.PropietarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping; // Importa esta anotación
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/propietarios")
public class PropietarioControlador {

    private final PropietarioServicio propietarioServicio;

    @Autowired
    public PropietarioControlador(PropietarioServicio propietarioServicio) {this.propietarioServicio = propietarioServicio;}

    @GetMapping("/")
    public String obtenerPropietarios(Model model) {
        List<PropietarioDto> propietarios = propietarioServicio.obtenerPropietarios();
        model.addAttribute("propietarios", propietarios);
        return "propietarios";
    }
}
