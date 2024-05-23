package com.ucentral.MiKasa.controladores;

import com.ucentral.MiKasa.dto.ClienteDto;
import com.ucentral.MiKasa.servicios.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteControlador {

    private final ClienteServicio clienteServicio;

    @Autowired
    public ClienteControlador(ClienteServicio clienteServicio) {
        this.clienteServicio = clienteServicio;
    }

    @PostMapping
    public void crearCliente(@RequestBody ClienteDto clienteDto) {
        clienteServicio.registrarCliente(clienteDto);
    }
}
