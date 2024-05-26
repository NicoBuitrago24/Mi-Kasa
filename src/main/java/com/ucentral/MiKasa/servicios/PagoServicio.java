package com.ucentral.MiKasa.servicios;

import com.ucentral.MiKasa.dto.PagoDto;
import com.ucentral.MiKasa.entidades.Pago;
import com.ucentral.MiKasa.repositorios.PagoRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PagoServicio implements Serializable {

    private final ModelMapper modelMapper;
    private final PagoRepositorio pagoRepositorio;

    @Autowired
    public PagoServicio(ModelMapper modelMapper, PagoRepositorio pagoRepositorio) {
        this.modelMapper = modelMapper;
        this.pagoRepositorio = pagoRepositorio;
    }

    public PagoDto registrarPago(PagoDto pagoDto) {
        Pago pago = modelMapper.map(pagoDto, Pago.class);
        pago =pagoRepositorio.save(pago);
        return modelMapper.map(pago, PagoDto.class);
    }

    public List<PagoDto> obtenerPago(){
        List<Pago> pagos= pagoRepositorio.findAll();
        return pagos.stream()
                .map(pago -> modelMapper.map(pago,PagoDto.class))
                .collect(Collectors.toList());
    }

    public PagoDto obtenerPagoPorId(Long id) {
        Optional<Pago> optionalPago = pagoRepositorio.findById(id);
        return optionalPago.map(pago -> modelMapper.map(pago,PagoDto.class)).orElse(null);
    }

    public PagoDto savePago(PagoDto pagoDto) {
        Pago pago = modelMapper.map(pagoDto, Pago.class);
        pago =pagoRepositorio.save(pago);
        return modelMapper.map(pago, PagoDto.class);
    }

    public void eliminarPago(Long id) {
        pagoRepositorio.deleteById(id);
    }

}

