package com.unipar.venda_bankend.repository;

import com.unipar.venda_bankend.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
