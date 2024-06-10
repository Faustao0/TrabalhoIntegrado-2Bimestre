package com.unipar.venda_bankend.service;

import com.unipar.venda_bankend.domain.Venda;
import com.unipar.venda_bankend.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public List<Venda> findAll() {
        return vendaRepository.findAll();
    }

    public Venda findById(Long id) {
        return vendaRepository.findById(id).orElseThrow(() -> new RuntimeException("Venda não encontrada!"));
    }

    public Venda save(Venda venda) {
        return vendaRepository.save(venda);
    }
}
