package com.ucentral.MiKasa.controladores;

    import com.ucentral.MiKasa.dto.FuncionarioDto;
    import com.ucentral.MiKasa.dto.InmuebleDto;
    import com.ucentral.MiKasa.servicios.InmuebleServicio;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/funcionario/aprobar/{id}")
    public ResponseEntity<String> aprobarInmueble(@PathVariable Long id, @RequestBody AprobacionRequest request) {
        inmuebleServicio.aprobarInmueble(id, request.getValorNoche());
        return ResponseEntity.ok("Exitoso");
    }

    public static class AprobacionRequest {
        private int valorNoche;

        public int getValorNoche() {
            return valorNoche;
        }

        public void setValorNoche(int valorNoche) {
            this.valorNoche = valorNoche;
        }
    }
}