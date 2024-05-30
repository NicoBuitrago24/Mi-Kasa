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
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservaServicio implements Serializable {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ReservaRepositorio reservaRepositorio;

    public ReservaDto registrarReserva(ReservaDto reservaDto) {
        Reserva reserva = modelMapper.map(reservaDto, Reserva.class);
        reserva = reservaRepositorio.save(reserva);
        return modelMapper.map(reserva, ReservaDto.class);
    }

    public List<ReservaDto> obtenerReservas() {
        List<Reserva> reservas = reservaRepositorio.findAll();
        return reservas.stream()
                .map(reserva -> modelMapper.map(reserva,ReservaDto.class))
                .collect(Collectors.toList());
    }

    public ReservaDto obtenerReservaPorId(Long id) {
        Optional<Reserva> optionalReserva = reservaRepositorio.findById(id);
        return optionalReserva.map(reserva -> modelMapper.map(reserva, ReservaDto.class)).orElse(null);
    }

    public ReservaDto saveReserva (ReservaDto reservaDto){
        Reserva reserva= modelMapper.map(reservaDto, Reserva.class);
        reserva = reservaRepositorio.save(reserva);
        return modelMapper.map(reserva, ReservaDto.class);
    }

    public void eliminarReserva(Long id){
        reservaRepositorio.deleteById(id);
    }

}
