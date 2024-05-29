package com.ucentral.MiKasa.controladores;

import com.ucentral.MiKasa.dto.PropietarioDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("propietarioDto")
public class PropietarioController {

    @GetMapping("/propietario")
    public String clienteHome(Model model) {
        PropietarioDto propietarioDto = (PropietarioDto) model.getAttribute("propietarioDto");
        if (propietarioDto == null) {
            return "redirect:/";
        }
        model.addAttribute("propietario", propietarioDto);
        return "propietario";
    }
}
