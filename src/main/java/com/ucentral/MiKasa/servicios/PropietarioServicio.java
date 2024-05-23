package com.ucentral.MiKasa.servicios;

import com.ucentral.MiKasa.dto.PropietarioDto;
import com.ucentral.MiKasa.entidades.Propietario;
import com.ucentral.MiKasa.repositorios.PropietarioRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropietarioServicio implements Serializable {

    private ModelMapper modelMapper;

    @Autowired
    private PropietarioRepositorio propietarioRepositorio;

    public void registrarPropietario(PropietarioDto propietarioDto) {
        propietarioRepositorio.save(modelMapper.map(propietarioDto, Propietario.class));
    }

    public List<PropietarioDto> obtenerPropietarios() {
        List<Propietario> propietarios = propietarioRepositorio.findAll();
        return propietarios.stream()
                .map(propietario -> modelMapper.map(propietario, PropietarioDto.class))
                .collect(Collectors.toList());
    }
}
