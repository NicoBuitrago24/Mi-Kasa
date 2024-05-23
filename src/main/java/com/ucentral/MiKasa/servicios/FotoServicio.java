package com.ucentral.MiKasa.servicios;

import com.ucentral.MiKasa.dto.FotoDto;
import com.ucentral.MiKasa.entidades.Foto;
import com.ucentral.MiKasa.repositorios.FotoRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class FotoServicio implements Serializable {

    private final ModelMapper modelMapper;

    @Autowired
    public FotoServicio(ModelMapper modelMapper, FotoRepositorio fotoRepositorio) {
        this.modelMapper = modelMapper;
        this.fotoRepositorio = fotoRepositorio;
    }
    private final FotoRepositorio fotoRepositorio;

    public void registrarFoto(FotoDto fotoDto) {
        fotoRepositorio.save(modelMapper.map(fotoDto, Foto.class));
    }

}
