package com.unipar.venda_bankend.controller;

import com.unipar.venda_bankend.domain.Cliente;
import com.unipar.venda_bankend.domain.Venda;
import com.unipar.venda_bankend.service.VendaService;
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
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @GetMapping
    public List<Venda> getAllVendas() {
        return vendaService.findAll();
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok", content =
                    { @Content(mediaType = "application/json", schema =
                    @Schema(implementation = Cliente.class)) }),
            @ApiResponse(responseCode = "400", description = "ID invalido informado"),
            @ApiResponse(responseCode = "404", description = "Venda não encontrada"),
            @ApiResponse(responseCode = "500", description = "Internal server error", content =
                    { @Content(mediaType = "application/json", schema =
                    @Schema(implementation = Exception.class)) }) })

    @GetMapping("/{id}")
    public ResponseEntity<Venda> getVendaById(@PathVariable("id") Long id) {
        Venda venda = vendaService.findById(id);
        return ResponseEntity.ok(venda);
    }

    @PostMapping("/salvar")
    public ResponseEntity<String> salvarVenda(@RequestBody Venda venda) {
        try {
            vendaService.save(venda);
            return ResponseEntity.ok("Venda salva com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao salvar venda: " + e.getMessage());
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Venda createVenda(@Valid @RequestBody Venda venda) {
        return vendaService.save(venda);
    }

}
