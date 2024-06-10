package com.unipar.venda_bankend.repository;

import com.unipar.venda_bankend.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
