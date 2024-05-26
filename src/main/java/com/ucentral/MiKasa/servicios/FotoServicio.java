package com.ucentral.MiKasa.servicios;

import com.ucentral.MiKasa.dto.FotoDto;
import com.ucentral.MiKasa.entidades.Foto;
import com.ucentral.MiKasa.repositorios.FotoRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FotoServicio implements Serializable {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private FotoRepositorio fotoRepositorio;

    public FotoDto registrarFoto(FotoDto fotoDto) {
        Foto foto = modelMapper.map(fotoDto, Foto.class);
        foto = fotoRepositorio.save(foto);
        return modelMapper.map(foto, FotoDto.class);
    }

    public List <FotoDto> obtenerFotos() {
        List<Foto> fotos = fotoRepositorio.findAll();
        return fotos.stream()
                .map(foto -> modelMapper.map(foto, FotoDto.class))
                .collect(Collectors.toList());
    }
    public FotoDto obtenerFotoPorId(Long id) {
        Optional<Foto> optionalFoto = fotoRepositorio.findById(id);
        return optionalFoto.map ( foto -> modelMapper.map(foto,FotoDto.class)).orElse(null);
    }

    public FotoDto saveFoto(FotoDto fotoDto) {
        Foto foto = modelMapper.map(fotoDto, Foto.class);
        foto = fotoRepositorio.save(foto);
        return modelMapper.map(foto, FotoDto.class);
    }
    public void EliminarFoto(Long id) {
        fotoRepositorio.deleteById(id);
    }


}



