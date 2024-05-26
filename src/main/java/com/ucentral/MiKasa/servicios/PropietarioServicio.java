package com.ucentral.MiKasa.servicios;


import com.ucentral.MiKasa.dto.PropietarioDto;
import com.ucentral.MiKasa.entidades.Propietario;
import com.ucentral.MiKasa.repositorios.PropietarioRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PropietarioServicio implements Serializable {

    @Autowired
    private  ModelMapper modelMapper;
    @Autowired
    private  PropietarioRepositorio propietarioRepositorio;

    public PropietarioDto registrarPropietario(PropietarioDto propietarioDto) {
        Propietario propietario = modelMapper.map(propietarioDto, Propietario.class);
        propietario = propietarioRepositorio.save(propietario);
        return modelMapper.map(propietario, PropietarioDto.class);
    }

    public List<PropietarioDto> obtenerPropietarios() {
       List<Propietario> propietarios = propietarioRepositorio.findAll();
       return propietarios.stream()
               .map(prop -> modelMapper.map(prop, PropietarioDto.class))
               .collect(Collectors.toList());
    }

    public PropietarioDto obtenerPropietarioById(Long id) {
        Optional<Propietario> optionalPropietario = propietarioRepositorio.findById(id);
        return optionalPropietario.map(propietario-> modelMapper.map(propietario, PropietarioDto.class)).orElse(null);
    }

    public PropietarioDto savePropietario(PropietarioDto propietarioDto) {
        Propietario propietario = modelMapper.map(propietarioDto, Propietario.class);
        propietario= propietarioRepositorio.save(propietario);
        return modelMapper.map(propietario,PropietarioDto.class);
    }
    public void eliminarPropietario(Long id) {
        propietarioRepositorio.deleteById(id);

    }
}
