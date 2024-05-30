package com.ucentral.MiKasa.repositorios;

import com.ucentral.MiKasa.entidades.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ReservaRepositorio extends JpaRepository<Reserva, Long>, JpaSpecificationExecutor<Reserva> {
}
