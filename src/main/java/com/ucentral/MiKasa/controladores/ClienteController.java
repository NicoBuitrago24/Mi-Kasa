package com.ucentral.MiKasa.controladores;

import com.ucentral.MiKasa.dto.InmuebleDto;
import com.ucentral.MiKasa.servicios.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.ucentral.MiKasa.dto.ReservaDto;
import com.ucentral.MiKasa.dto.ClienteDto;
import com.ucentral.MiKasa.servicios.ReservaServicio;
import com.ucentral.MiKasa.servicios.InmuebleServicio;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("clienteDto")
public class ClienteController {

    @Autowired
    private ReservaServicio reservaServicio;

    @Autowired
    private InmuebleServicio inmuebleServicio;

    @Autowired
    private ClienteServicio clienteServicio;

    @GetMapping("/cliente")
    public String clienteHome(Model model) {
        ClienteDto clienteDto = (ClienteDto) model.getAttribute("clienteDto");
        if (clienteDto == null) {
            return "redirect:/";
        }
        model.addAttribute("cliente", clienteDto);
        model.addAttribute("inmueblesAprobados", inmuebleServicio.obtenerInmueblesAprobados());
        return "cliente";
    }

    @PostMapping("/reserva")
    public ResponseEntity<String> crearReserva(@RequestParam("fechaInicio") LocalDate fechaInicio,
                                               @RequestParam("fechaFin") LocalDate fechaFin,
                                               @RequestParam("cantHuespedes") int cantHuespedes,
                                               @RequestParam("tipoPago") String tipoPago,
                                               @RequestParam("inmuebleId") Long inmuebleId,
                                               Model model) {
        InmuebleDto inmuebleDto = inmuebleServicio.obtenerInmueblePorId(inmuebleId);
        ClienteDto clienteDto = (ClienteDto) model.getAttribute("clienteDto");
        ReservaDto reservaDto = new ReservaDto();
        reservaDto.setFecha_inicio(fechaInicio);
        reservaDto.setFecha_fin(fechaFin);
        reservaDto.setNumerohuespedes(cantHuespedes);
        reservaDto.setTipodepago(tipoPago);
        reservaDto.setInmueble(inmuebleDto);
        reservaDto.setCliente(clienteDto);

        long numeroDeNoches = fechaInicio.until(fechaFin).getDays();
        double valor = numeroDeNoches * inmuebleDto.getValorNoche();
        reservaDto.setValor(valor);

        ReservaDto nuevaReserva = reservaServicio.registrarReserva(reservaDto);
        assert clienteDto != null;
        List<ReservaDto> lista = clienteDto.getReservas();
        lista.add(nuevaReserva);
        clienteDto.setReservas(lista);
        clienteServicio.saveCliente(clienteDto);

        List<ReservaDto> list2 = inmuebleDto.getReservas();
        list2.add(nuevaReserva);
        inmuebleDto.setReservas(list2);
        inmuebleServicio.saveInmueble(inmuebleDto);

        return ResponseEntity.ok("Exitoso");
    }



    @GetMapping("/formularioReserva")
    public String mostrarFormularioReserva(@RequestParam("inmuebleId") Long inmuebleId, Model model) {
        ClienteDto clienteDto = (ClienteDto) model.getAttribute("clienteDto");
        if (clienteDto == null) {
            return "redirect:/";
        }
        InmuebleDto inmuebleDto = inmuebleServicio.obtenerInmueblePorId(inmuebleId);
        if (inmuebleDto == null) {
            return "redirect:/cliente";
        }

        model.addAttribute("inmueble", inmuebleDto);

        return "formularioReserva";
    }

}
