package com.unipar.venda_bankend.service;

import com.unipar.venda_bankend.model.ItemVenda;
import com.unipar.venda_bankend.repository.ItemVendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemVendaService {

    @Autowired
    private ItemVendaRepository itemVendaRepository;

    public List<ItemVenda> findAll() {
        return itemVendaRepository.findAll();
    }

    public ItemVenda findById(Long id) {
        return itemVendaRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado!"));
    }

    public ItemVenda save(ItemVenda itemVenda) {
        return itemVendaRepository.save(itemVenda);
    }
}
