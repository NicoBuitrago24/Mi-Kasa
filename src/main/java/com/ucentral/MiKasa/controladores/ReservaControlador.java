package com.ucentral.MiKasa.controladores;

import com.ucentral.MiKasa.dto.ReservaDto;
import com.ucentral.MiKasa.entidades.Reserva;
import com.ucentral.MiKasa.servicios.ReservaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/reservas")
public class ReservaControlador {

    private final ReservaServicio reservaServicio;

    @Autowired
    public ReservaControlador(ReservaServicio partidoservicios) {this.reservaServicio = partidoservicios;}

    @PostMapping("/registrar")
    public ResponseEntity<String> registrar(@RequestBody ReservaDto reservaDto) {
        try{
            reservaServicio.registrarReserva(reservaDto);
            return ResponseEntity.ok("Reserva registarda correctamente");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al registrar el partido"+ e.getMessage());
        }
    }

    @GetMapping("/listar")
    public String obtenerReservas(Model model) {
        List<ReservaDto> reservas = reservaServicio.obtenerReservas();
        model.addAttribute("reservas", reservas);
        return "reservas";
    }
}
