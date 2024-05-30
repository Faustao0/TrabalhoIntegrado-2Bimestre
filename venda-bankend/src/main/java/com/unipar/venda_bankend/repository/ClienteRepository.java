package com.unipar.venda_bankend.repository;

import com.unipar.venda_bankend.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
