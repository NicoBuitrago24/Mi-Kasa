package com.ucentral.MiKasa.servicios;

import com.ucentral.MiKasa.dto.FuncionarioDto;
import com.ucentral.MiKasa.entidades.Funcionario;
import com.ucentral.MiKasa.repositorios.FuncionarioRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FuncionarioServicio implements Serializable {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private FuncionarioRepositorio funcionarioRepositorio;

    public boolean esFuncionario(String correo) {
        Optional<Funcionario> funcionario = funcionarioRepositorio.findByCorreo(correo);
        return funcionario.isPresent();
    }

    public FuncionarioDto registrarFuncionario(FuncionarioDto funcionarioDto) {
        Funcionario funcionario = modelMapper.map(funcionarioDto, Funcionario.class);
        funcionario = funcionarioRepositorio.save(funcionario);
        return modelMapper.map(funcionario, FuncionarioDto.class);
    }

    public List<FuncionarioDto> obtenerFuncionarios() {
        List<Funcionario> funcionarios = funcionarioRepositorio.findAll();
        return funcionarios.stream()
                .map(funcionario -> modelMapper.map(funcionario, FuncionarioDto.class))
                .collect(Collectors.toList());
    }
    public FuncionarioDto obtenerFuncionarioPorCorreo(String correo){
        Optional<Funcionario> optionalFuncionario = funcionarioRepositorio.findByCorreo(correo);
        return optionalFuncionario.map(funcionario -> modelMapper.map(funcionario,FuncionarioDto.class)).orElse(null);
    }

    public FuncionarioDto obtenerFuncionarioPorId(Long id) {
        Optional<Funcionario> optionalFuncionario = funcionarioRepositorio.findById(id);
        return optionalFuncionario.map(funcionario -> modelMapper.map(funcionario, FuncionarioDto.class)).orElse(null);
    }


    public FuncionarioDto saveFuncionario(FuncionarioDto funcionarioDto) {
        Funcionario funcionario = modelMapper.map(funcionarioDto, Funcionario.class);
        funcionario = funcionarioRepositorio.save(funcionario);
        return modelMapper.map(funcionario, FuncionarioDto.class);
    }
    public void eliminarFuncionario(Long id) {
        funcionarioRepositorio.deleteById(id);
    }
}
