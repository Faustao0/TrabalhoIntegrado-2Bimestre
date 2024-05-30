package com.unipar.venda_bankend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Entity
public class ItemVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Integer quantidade;

    @NotNull
    private BigDecimal valorUnitario;

    @NotNull
    private BigDecimal valorTotal;

    @ManyToOne
    @JoinColumn(name = "fk_venda_id")
    private Venda venda;

    @ManyToOne
    @JoinColumn(name = "fk_produto_id")
    private Produto produto;

    public ItemVenda(Long id, Integer quantidade, BigDecimal valorUnitario, BigDecimal valorTotal, Venda venda, Produto produto) {
        this.id = id;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.valorTotal = valorTotal;
        this.venda = venda;
        this.produto = produto;
    }

    public ItemVenda() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public @NotNull BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(@NotNull BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public @NotNull BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(@NotNull BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
