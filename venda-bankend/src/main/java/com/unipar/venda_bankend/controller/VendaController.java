package com.unipar.venda_bankend.controller;

import com.unipar.venda_bankend.model.Venda;
import com.unipar.venda_bankend.service.VendaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @GetMapping
    public List<Venda> getAllVendas() {
        return vendaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venda> getVendaById(@PathVariable("id") Long id) {
        Venda venda = vendaService.findById(id);
        return ResponseEntity.ok(venda);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Venda createVenda(@Valid @RequestBody Venda venda) {
        return vendaService.save(venda);
    }

}
