package com.unipar.venda_bankend.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
public class ItemVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "A quantidade é obrigatória.")
    private Integer quantidade;

    @NotNull(message = "O valor unitário é obrigatório.")
    private BigDecimal valorUnitario;

    @NotNull(message = "O valor total é obrigatório.")
    private BigDecimal valorTotal;

    @ManyToOne
    @JoinColumn(name = "fk_venda_id", nullable = false)
    private Venda venda;

    @ManyToOne
    @JoinColumn(name = "fk_produto_id", nullable = false)
    private Produto produto;

    public ItemVenda(Long id, Integer quantidade, BigDecimal valorUnitario, BigDecimal valorTotal, Venda venda, Produto produto) {
        this.id = id;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.valorTotal = valorTotal;
        this.venda = venda;
        this.produto = produto;
    }

    public ItemVenda() {}

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

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
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
