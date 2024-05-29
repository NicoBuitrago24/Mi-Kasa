package com.ucentral.MiKasa.controladores;

import com.ucentral.MiKasa.dto.ClienteDto;
import com.ucentral.MiKasa.servicios.FotoServicio;
import com.ucentral.MiKasa.servicios.InmuebleServicio;
import com.ucentral.MiKasa.servicios.ReservaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("clienteDto")
public class ClienteController {

    @GetMapping("/cliente")
    public String clienteHome(Model model) {
        ClienteDto clienteDto = (ClienteDto) model.getAttribute("clienteDto");
        if (clienteDto == null) {
            return "redirect:/";
        }
        model.addAttribute("cliente", clienteDto);
        return "cliente";
    }
}
