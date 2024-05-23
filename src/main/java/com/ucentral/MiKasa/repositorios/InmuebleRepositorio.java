package com.ucentral.MiKasa.repositorios;

import com.ucentral.MiKasa.entidades.Inmueble;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface InmuebleRepositorio extends JpaRepository<Inmueble, Long>, JpaSpecificationExecutor<Inmueble> {
}
