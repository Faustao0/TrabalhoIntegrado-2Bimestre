package com.unipar.venda.frontend.tables;

import com.unipar.venda.frontend.model.Produto;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TabelaProduto extends AbstractTableModel{

   private final List<Produto> produtos;
   private final String[] colunas = {"ID", "Descrição", "Valor", "Categoria"};

    public TabelaProduto(List<Produto> produto) {
        this.produtos = produto;
    }
    
    public Produto getProdutoAt(int rowIndex) {
    return produtos.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return produtos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Produto produto = produtos.get(rowIndex);
        switch (columnIndex) {
            case 0: return produto.getId();
            case 1: return produto.getDescricao();
            case 2: return produto.getValor();
            case 3: return produto.getCategoria();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
}
