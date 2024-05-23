package com.ucentral.MiKasa.servicios;

import com.ucentral.MiKasa.dto.ReservaDto;
import com.ucentral.MiKasa.entidades.Reserva;
import com.ucentral.MiKasa.repositorios.ReservaRepositorio;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class ReservaServicio implements Serializable {

    private final ModelMapper modelMapper;

    @Autowired
    public ReservaServicio(ModelMapper modelMapper) {this.modelMapper = modelMapper;}

    @Autowired
    ReservaRepositorio reservaRepositorio;

    public void registrarReserva(ReservaDto reservaDto) {
        reservaRepositorio.save(modelMapper.map(reservaDto, Reserva.class));
    }

    public List<ReservaDto> obtenerReservas() {
        TypeToken<List<ReservaDto>> typeToken =new TypeToken<>() {};
        return modelMapper.map(reservaRepositorio.findAll(), typeToken.getType());
    }
}
