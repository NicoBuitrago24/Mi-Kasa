package com.ucentral.MiKasa.repositorios;

import com.ucentral.MiKasa.entidades.Foto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FotoRepositorio extends JpaRepository<Foto, Long>, JpaSpecificationExecutor<Foto> {
}
