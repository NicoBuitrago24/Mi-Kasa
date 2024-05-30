package com.ucentral.MiKasa.servicios;

import com.ucentral.MiKasa.dto.ClienteDto;
import com.ucentral.MiKasa.entidades.Cliente;
import com.ucentral.MiKasa.repositorios.ClienteRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteServicio implements Serializable {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public boolean esCliente(String correo){
        Optional<Cliente> cliente = clienteRepositorio.findByCorreo(correo);
        return cliente.isPresent();
    }

    public ClienteDto registrarCliente(ClienteDto clienteDto) {
        Cliente cliente = modelMapper.map(clienteDto, Cliente.class);
        cliente = clienteRepositorio.save(cliente);
        return modelMapper.map(cliente, ClienteDto.class);
    }

    public List<ClienteDto> obtenerClientes() {
        List<Cliente> clientes = clienteRepositorio.findAll();
        return clientes.stream()
                .map(cliente -> modelMapper.map(cliente,ClienteDto.class))
                .collect(Collectors.toList());
    }

    public ClienteDto obtenerClientePorId(Long id) {
        Optional<Cliente> optionalCliente = clienteRepositorio.findById(id);
        return optionalCliente.map(cliente -> modelMapper.map(cliente,ClienteDto.class)).orElse(null);
    }

    public ClienteDto obtenerClientePorCorreo(String correo){
        Optional<Cliente> optionalCliente = clienteRepositorio.findByCorreo(correo);
        return optionalCliente.map(cliente -> modelMapper.map(cliente,ClienteDto.class)).orElse(null);
    }

    public ClienteDto saveCliente(ClienteDto clienteDto) {
        Cliente cliente = modelMapper.map(clienteDto, Cliente.class);
        cliente = clienteRepositorio.save(cliente);
        return modelMapper.map(cliente,ClienteDto.class);
    }

    public void eliminarCliente(Long id) {
        clienteRepositorio.deleteById(id);
    }


}
