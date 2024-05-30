package com.unipar.venda_bankend.controller;

import com.unipar.venda_bankend.model.ItemVenda;
import com.unipar.venda_bankend.service.ItemVendaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Itens de vendas")
public class ItemVendaController {

    @Autowired
    private ItemVendaService itemVendaService;

    @GetMapping
    public List<ItemVenda> getAllItemVenda() {
        return itemVendaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemVenda> getItemVendaById(@PathVariable("id") Long id) {
        ItemVenda itemVenda = itemVendaService.findById(id);
        return ResponseEntity.ok(itemVenda);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ItemVenda createItenVenda(@Valid @RequestBody ItemVenda itemVenda) {
        return itemVendaService.save(itemVenda);
    }
}
