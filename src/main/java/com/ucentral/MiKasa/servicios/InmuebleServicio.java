package com.ucentral.MiKasa.servicios;

import com.ucentral.MiKasa.dto.InmuebleDto;
import com.ucentral.MiKasa.entidades.Inmueble;
import com.ucentral.MiKasa.repositorios.InmuebleRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InmuebleServicio {
    @Autowired
    private  ModelMapper modelMapper;
    @Autowired
    private InmuebleRepositorio inmuebleRepositorio;

    public InmuebleDto registrarInmueble(InmuebleDto inmuebleDto) {
        Inmueble inmueble = modelMapper.map(inmuebleDto, Inmueble.class);
        inmueble = inmuebleRepositorio.save(inmueble);
        return modelMapper.map(inmueble, InmuebleDto.class);
    }

    public List<InmuebleDto> obtenerInmuebles() {
        List<Inmueble> inmuebles = inmuebleRepositorio.findAll();
        return inmuebles.stream()
                .map(inmueble -> modelMapper.map(inmueble,InmuebleDto.class))
                .collect(Collectors.toList());
    }

    public InmuebleDto obtenerInmueblePorId(Long id) {
        Optional<Inmueble> optionalInmueble = inmuebleRepositorio.findById(id);
        return optionalInmueble.map(inmueble -> modelMapper.map(inmueble, InmuebleDto.class)).orElse(null);
    }

    public InmuebleDto saveInmueble(InmuebleDto inmuebleDto) {
        Inmueble inmueble = modelMapper.map(inmuebleDto,Inmueble.class);
        inmueble = inmuebleRepositorio.save(inmueble);
        return modelMapper.map(inmueble, InmuebleDto.class);
    }
    public void eliminarInmueble(Long id) {
        inmuebleRepositorio.deleteById(id);
    }

    public List<InmuebleDto> obtenerInmueblesPorPropietario(Long propietarioId) {
        List<Inmueble> inmuebles = inmuebleRepositorio.findByPropietarioId(propietarioId);
        return inmuebles.stream()
                .map(inmueble -> modelMapper.map(inmueble, InmuebleDto.class))
                .collect(Collectors.toList());
    }
}
