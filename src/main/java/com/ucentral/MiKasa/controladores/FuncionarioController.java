package com.ucentral.MiKasa.controladores;

    import com.ucentral.MiKasa.dto.FuncionarioDto;
    import com.ucentral.MiKasa.dto.InmuebleDto;
    import com.ucentral.MiKasa.servicios.InmuebleServicio;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

    import java.util.List;

@Controller
@SessionAttributes("funcionarioDto")
public class FuncionarioController {

    @Autowired
    InmuebleServicio inmuebleServicio;

    @GetMapping("/funcionario")
    public String clienteHome(Model model) {
        FuncionarioDto funcionarioDto = (FuncionarioDto) model.getAttribute("funcionarioDto");
        if (funcionarioDto == null) {
            return "redirect:/";
        }
        model.addAttribute("funcionario", funcionarioDto);

        List<InmuebleDto> inmueblesNoAprobados = inmuebleServicio.obtenerInmueblesNoAprobados();
        model.addAttribute("inmueblesNoAprobados", inmueblesNoAprobados);

        return "funcionario";
    }
}