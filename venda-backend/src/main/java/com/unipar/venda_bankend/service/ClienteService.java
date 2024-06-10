package com.unipar.venda_bankend.service;

import com.unipar.venda_bankend.domain.Cliente;
import com.unipar.venda_bankend.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));
    }

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}
