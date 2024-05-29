package com.ucentral.MiKasa.controladores;

import com.ucentral.MiKasa.dto.ClienteDto;
import com.ucentral.MiKasa.dto.FuncionarioDto;
import com.ucentral.MiKasa.dto.PropietarioDto;
import com.ucentral.MiKasa.servicios.ClienteServicio;
import com.ucentral.MiKasa.servicios.FuncionarioServicio;
import com.ucentral.MiKasa.servicios.PropietarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping("/registrarse")
public class RegistrarseController {
    @Autowired
    private ClienteServicio clienteServicio;

    @Autowired
    private PropietarioServicio propietarioServicio;

    @Autowired
    private FuncionarioServicio funcionarioServicio;

    @GetMapping
    public String registrarse(Model model) {
        return "registrarse";
    }

    @PostMapping
    public ResponseEntity<String> registrarsePost(@RequestParam("role") String rol,
                                                  @RequestParam("nombre") String nombre,
                                                  @RequestParam("apellido") String apellido,
                                                  @RequestParam("correo") String correo,
                                                  @RequestParam("contrasena") String contrasena,
                                                  @RequestParam("celular") int celular,
                                                  Model model) {
        switch(rol){
            case "cliente":
                ClienteDto clienteDto = new ClienteDto();
                clienteDto.setNombre(nombre);
                clienteDto.setApellido(apellido);
                clienteDto.setCorreo(correo);
                clienteDto.setContrasena(contrasena);
                clienteDto.setCelular(celular);
                clienteServicio.registrarCliente(clienteDto);
                break;
            case "propietario":
                PropietarioDto propietarioDto = new PropietarioDto();
                propietarioDto.setNombre(nombre);
                propietarioDto.setApellido(apellido);
                propietarioDto.setCorreo(correo);
                propietarioDto.setContrasena(contrasena);
                propietarioDto.setCelular(celular);
                propietarioDto.setInmuebles(new ArrayList<>());
                propietarioServicio.registrarPropietario(propietarioDto);
                break;
            case "funcionario":
                FuncionarioDto funcionarioDto = new FuncionarioDto();
                funcionarioDto.setNombre(nombre);
                funcionarioDto.setApellido(apellido);
                funcionarioDto.setCorreo(correo);
                funcionarioDto.setContrasena(contrasena);
                funcionarioDto.setCelular(celular);
                funcionarioServicio.registrarFuncionario(funcionarioDto);
                break;
            default:
                model.addAttribute("mensaje", "El rol no existe");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("error");
        }

        return ResponseEntity.ok("success");
    }
}
