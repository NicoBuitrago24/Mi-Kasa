package com.ucentral.MiKasa.repositorios;

import com.ucentral.MiKasa.entidades.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PagoRepositorio extends JpaRepository<Pago, Long>, JpaSpecificationExecutor<Pago> {
}
