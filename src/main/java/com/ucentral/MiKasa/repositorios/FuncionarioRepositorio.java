package com.ucentral.MiKasa.repositorios;

import com.ucentral.MiKasa.entidades.Cliente;
import com.ucentral.MiKasa.entidades.Foto;
import com.ucentral.MiKasa.entidades.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface FuncionarioRepositorio extends JpaRepository<Funcionario, Long>,JpaSpecificationExecutor<Funcionario>{
    Optional<Funcionario> findByCorreo(String correo);
}
