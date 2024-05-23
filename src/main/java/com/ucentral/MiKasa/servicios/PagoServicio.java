package com.ucentral.MiKasa.servicios;

import com.ucentral.MiKasa.dto.PagoDto;
import com.ucentral.MiKasa.entidades.Pago;
import com.ucentral.MiKasa.repositorios.PagoRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Serializable;

@Service
public class PagoServicio implements Serializable {

    private final ModelMapper modelMapper;
    private final PagoRepositorio pagoRepositorio;

    @Autowired
    public PagoServicio(ModelMapper modelMapper, PagoRepositorio pagoRepositorio) {
        this.modelMapper = modelMapper;
        this.pagoRepositorio = pagoRepositorio;
    }

    public void registrarPago(PagoDto pagoDto) {
        Pago pago = modelMapper.map(pagoDto, Pago.class);
        pagoRepositorio.save(pago);
    }

}

