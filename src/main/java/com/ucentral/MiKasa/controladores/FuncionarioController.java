package com.ucentral.MiKasa.controladores;

    import com.ucentral.MiKasa.dto.FuncionarioDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("funcionarioDto")
public class FuncionarioController {

    @GetMapping("/funcionario")
    public String clienteHome(Model model) {
        FuncionarioDto funcionarioDto = (FuncionarioDto) model.getAttribute("funcionarioDto");
        if (funcionarioDto == null) {
            return "redirect:/";
        }
        model.addAttribute("funcionario", funcionarioDto);
        return "funcionario";
    }
}