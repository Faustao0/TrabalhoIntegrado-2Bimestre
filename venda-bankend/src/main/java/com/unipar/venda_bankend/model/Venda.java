package com.unipar.venda_bankend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String observacoes;

    @NotNull
    private Timestamp data;

    @NotNull
    private BigDecimal total;

    @ManyToOne
    @JoinColumn(name = "fk_cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL)
    private List<ItemVenda> itens;

    public Venda(Long id, String observacoes, Timestamp data, BigDecimal total, Cliente cliente, List<ItemVenda> itens) {
        this.id = id;
        this.observacoes = observacoes;
        this.data = data;
        this.total = total;
        this.cliente = cliente;
        this.itens = itens;
    }

    public Venda() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public @NotNull Timestamp getData() {
        return data;
    }

    public void setData(@NotNull Timestamp data) {
        this.data = data;
    }

    public @NotNull BigDecimal getTotal() {
        return total;
    }

    public void setTotal(@NotNull BigDecimal total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }
}
