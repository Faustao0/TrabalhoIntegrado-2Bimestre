package com.unipar.venda.frontend.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigDecimal;
import java.util.List;

public class Produto {

    private Long id;
    private String descricao;
    private BigDecimal valor;
    private String categoria;
    
    public Produto() { }

    public Produto(Long id, String descricao, BigDecimal valor, String categoria) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.categoria = categoria;
    }
    
    public static List<Produto> unmarshalFromJson(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<Produto> clienteList = mapper.readValue(json, new TypeReference<List<Produto>>(){});
        return clienteList;
    }

    public static String marshalToJson(Produto produto) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(produto);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}

