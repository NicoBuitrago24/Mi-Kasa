package com.ucentral.MiKasa.controladores;

import com.ucentral.MiKasa.dto.ClienteDto;
import com.ucentral.MiKasa.dto.FuncionarioDto;
import com.ucentral.MiKasa.dto.LoginDto;
import com.ucentral.MiKasa.dto.PropietarioDto;
import com.ucentral.MiKasa.servicios.ClienteServicio;
import com.ucentral.MiKasa.servicios.FuncionarioServicio;
import com.ucentral.MiKasa.servicios.PropietarioServicio;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Objects;

@Controller
@SessionAttributes({"clienteDto", "propietarioDto", "funcionarioDto"})
public class LoginController {

    @Autowired
    private ClienteServicio clienteServicio;

    @Autowired
    private PropietarioServicio propietarioServicio;

    @Autowired
    private FuncionarioServicio funcionarioServicio;

    @GetMapping("/")
    public String login(Model model) {
        LoginDto loginDto = new LoginDto();
        model.addAttribute("loginDto", loginDto);
        return "login";
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginPost(@ModelAttribute("loginDto") LoginDto loginDto, HttpSession session) {
        if (clienteServicio.esCliente(loginDto.getCorreo())) {
            ClienteDto clienteDto = clienteServicio.obtenerClientePorCorreo(loginDto.getCorreo());
            if (clienteDto != null && Objects.equals(clienteDto.getContrasena(), loginDto.getContrasena())) {
                session.setAttribute("clienteDto", clienteDto);
                return ResponseEntity.ok("cliente");
            }
        }
        if (propietarioServicio.esPropietario(loginDto.getCorreo())) {
            PropietarioDto propietarioDto = propietarioServicio.obtenerPropietarioPorCorreo(loginDto.getCorreo());
            if (propietarioDto != null && Objects.equals(propietarioDto.getContrasena(), loginDto.getContrasena())) {
                session.setAttribute("propietarioDto", propietarioDto);
                return ResponseEntity.ok("propietario");
            }
        }
        if (funcionarioServicio.esFuncionario(loginDto.getCorreo())) {
            FuncionarioDto funcionarioDto = funcionarioServicio.obtenerFuncionarioPorCorreo(loginDto.getCorreo());
            if (funcionarioDto != null && Objects.equals(funcionarioDto.getContrasena(), loginDto.getContrasena())) {
                session.setAttribute("funcionarioDto", funcionarioDto);
                return ResponseEntity.ok("funcionario");
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Acceso erroneo");
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return ResponseEntity.ok("exitoso");
    }
}
