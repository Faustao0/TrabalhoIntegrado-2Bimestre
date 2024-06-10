package com.unipar.venda_bankend.controller;

import com.unipar.venda_bankend.domain.Cliente;
import com.unipar.venda_bankend.domain.ItemVenda;
import com.unipar.venda_bankend.service.ItemVendaService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok", content =
                    { @Content(mediaType = "application/json", schema =
                    @Schema(implementation = Cliente.class)) }),
            @ApiResponse(responseCode = "400", description = "ID invalido informado"),
            @ApiResponse(responseCode = "404", description = "ItemVenda não encontrado"),
            @ApiResponse(responseCode = "500", description = "Internal server error", content =
                    { @Content(mediaType = "application/json", schema =
                    @Schema(implementation = Exception.class)) }) })

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
