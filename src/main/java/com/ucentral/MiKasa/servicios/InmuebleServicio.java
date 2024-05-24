package com.ucentral.MiKasa.servicios;

import com.ucentral.MiKasa.dto.InmuebleDto;
import com.ucentral.MiKasa.entidades.Inmueble;
import com.ucentral.MiKasa.repositorios.InmuebleRepositorio;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InmuebleServicio {

    private final ModelMapper modelMapper;
    private final InmuebleRepositorio inmuebleRepositorio;
    private final ClienteServicio clienteServicio;

    @Autowired
    public InmuebleServicio(ModelMapper modelMapper, InmuebleRepositorio inmuebleRepositorio, ClienteServicio clienteServicio) {
        this.modelMapper = modelMapper;
        this.inmuebleRepositorio = inmuebleRepositorio;
        this.clienteServicio = clienteServicio;
    }

    public void registrarInmueble(InmuebleDto inmuebleDto) {System.out.println("En pruebas");}

    public List<InmuebleDto> obtenerInmuebles() {
        List<Inmueble> inmuebles = inmuebleRepositorio.findAll();
        return modelMapper.map(inmuebles, new TypeToken<List<InmuebleDto>>() {}.getType());
    }

    public InmuebleDto obtenerInmuebleById(Long id) {
        Optional<Inmueble> optionalInmueble = inmuebleRepositorio.findById(id);
        return optionalInmueble.map(inmueble -> modelMapper.map(inmueble, InmuebleDto.class)).orElse(null);
    }

    public void actualizarInmueble(InmuebleDto inmuebleDto) {
        Inmueble inmueble = modelMapper.map(inmuebleDto, Inmueble.class);
        inmuebleRepositorio.save(inmueble);
    }
    public void eliminarInmueble(Long id) {inmuebleRepositorio.deleteById(id);}
}
