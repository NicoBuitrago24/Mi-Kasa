package com.ucentral.MiKasa.servicios;

import com.ucentral.MiKasa.dto.InmuebleDto;
import com.ucentral.MiKasa.dto.PropietarioDto;
import com.ucentral.MiKasa.entidades.Inmueble;
import com.ucentral.MiKasa.entidades.Propietario;
import com.ucentral.MiKasa.repositorios.InmuebleRepositorio;
import com.ucentral.MiKasa.repositorios.PropietarioRepositorio;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PropietarioServicio implements Serializable {

    private final ModelMapper modelMapper;
    private final PropietarioRepositorio propietarioRepositorio;


    @Autowired
    public PropietarioServicio(ModelMapper modelMapper, PropietarioRepositorio propietarioRepositorio ) {
        this.modelMapper = modelMapper;
        this.propietarioRepositorio = propietarioRepositorio;
    }

    public PropietarioDto registrarPropietario(PropietarioDto propietarioDto) {
        Propietario propietario = modelMapper.map(propietarioDto, Propietario.class);
        propietario = propietarioRepositorio.save(propietario);
        return modelMapper.map(propietario, PropietarioDto.class);
    }

    public List<PropietarioDto> obtenerPropietarios() {
        List<Propietario> propietarios = propietarioRepositorio.findAll();
        return modelMapper.map(propietarios, new TypeToken<List<InmuebleDto>>() {}.getType());
    }

    public PropietarioDto obtenerPropietarioById(Long id) {
        Optional<Propietario> optionalPropietario = propietarioRepositorio.findById(id);
        return optionalPropietario.map(propietario-> modelMapper.map(propietario, PropietarioDto.class)).orElse(null);
    }

    public void actualizarPropietario(PropietarioDto propietarioDto) {
        Propietario propietario = modelMapper.map(propietarioDto, Propietario.class);
        propietarioRepositorio.save(propietario);
    }
    public void eliminarPropietario(Long id) {propietarioRepositorio.deleteById(id);}
}
