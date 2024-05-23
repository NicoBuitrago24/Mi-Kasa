package com.ucentral.MiKasa.repositorios;

import com.ucentral.MiKasa.entidades.Propietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PropietarioRepositorio extends JpaRepository<Propietario, Long>, JpaSpecificationExecutor<Propietario> {
}
