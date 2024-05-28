package com.ucentral.MiKasa.controladores;

import com.ucentral.MiKasa.dto.LoginDto;
import com.ucentral.MiKasa.servicios.ClienteServicio;
import com.ucentral.MiKasa.servicios.PropietarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private ClienteServicio clienteServicio;

    @Autowired
    private PropietarioServicio propietarioServicio;

    // Pendiente Funcionario

    @GetMapping("/")
    public String login(Model model) {
        LoginDto loginDto = new LoginDto();
        model.addAttribute("loginDto", loginDto);
        return "login";
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginPost(@ModelAttribute("loginDto") LoginDto loginDto) {
        if (clienteServicio.esCliente(loginDto.getCorreo()) || propietarioServicio.esPropietario(loginDto.getCorreo())) {
            // Cómo si existe, lo traemos (lo buscamos en la base de datos) y comparamos la clave
            return ResponseEntity.ok("success");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("error");
        }
    }


}
