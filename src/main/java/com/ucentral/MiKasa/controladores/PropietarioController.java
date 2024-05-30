package com.ucentral.MiKasa.controladores;

import com.ucentral.MiKasa.dto.InmuebleDto;
import com.ucentral.MiKasa.dto.PropietarioDto;
import com.ucentral.MiKasa.servicios.InmuebleServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("propietarioDto")
@RequestMapping("/propietario")
public class PropietarioController {

    @Autowired
    InmuebleServicio inmuebleServicio;

    @GetMapping
    public String clienteHome(Model model) {
        PropietarioDto propietarioDto = (PropietarioDto) model.getAttribute("propietarioDto");
        if (propietarioDto == null) {
            return "redirect:/";
        }
        model.addAttribute("propietario", propietarioDto);
        model.addAttribute("inmuebles", inmuebleServicio.obtenerInmueblesPorPropietario(propietarioDto.getId()));
        return "propietario";
    }

    @GetMapping("/agregarInmueble")
    public String agregarInmueble(Model model) {
        return "agregarInmueble";
    }

    @PostMapping("/agregarInmueble")
    public ResponseEntity<String> publicarInmueble(
            @RequestParam("ciudad") String ciudad,
            @RequestParam("barrio") String barrio,
            @RequestParam("avaluo") int avaluo,
            @RequestParam("direccion") String direccion,
            @RequestParam("descripcion") String descripcion,
            Model model) {

        PropietarioDto propietarioDto = (PropietarioDto) model.getAttribute("propietarioDto");
        if (propietarioDto == null) {
            return ResponseEntity.badRequest().body("Error: Propietario no encontrado");
        }

        InmuebleDto nuevoInmueble = new InmuebleDto();
        nuevoInmueble.setCiudad(ciudad);
        nuevoInmueble.setBarrio(barrio);
        nuevoInmueble.setAvaluo(avaluo);
        nuevoInmueble.setDireccion(direccion);
        nuevoInmueble.setDescripcion(descripcion);
        nuevoInmueble.setAprobado(false);
        nuevoInmueble.setValorNoche(0);
        nuevoInmueble.setPropietario(propietarioDto);

        InmuebleDto inmuebleGuardado = inmuebleServicio.registrarInmueble(nuevoInmueble);

        if (inmuebleGuardado != null) {
            return ResponseEntity.ok("Exitoso");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al registrar el inmueble.");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        inmuebleServicio.eliminarInmueble(id);
        return ResponseEntity.ok().body("Inmueble eliminado correctamente");
    }
}
