package com.unipar.venda_bankend.service;

import com.unipar.venda_bankend.model.Produto;
import com.unipar.venda_bankend.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Produto findById(Long id) {
        return produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado!"));
    }

    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }
}
