package com.ucentral.MiKasa.servicios;

import com.ucentral.MiKasa.dto.ClienteDto;
import com.ucentral.MiKasa.entidades.Cliente;
import com.ucentral.MiKasa.repositorios.ClienteRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class ClienteServicio implements Serializable {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    ClienteRepositorio clienteRepositorio;

    public void registrarCliente(ClienteDto clienteDto) {
        clienteRepositorio.save(modelMapper.map(clienteDto, Cliente.class));
    }
}
