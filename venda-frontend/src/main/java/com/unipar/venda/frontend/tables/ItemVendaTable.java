package com.unipar.venda.frontend.tables;

import javax.swing.table.AbstractTableModel;
import com.unipar.venda.frontend.model.ItemVenda;
import java.math.BigDecimal;
import java.util.List;

public class ItemVendaTable extends AbstractTableModel {

     private final List<ItemVenda> itensVenda;
    private final String[] colunas = {"ID", "Produto", "Quantidade", "Valor Unitário", "Valor Total"};

    public ItemVendaTable(List<ItemVenda> itensVenda) {
        this.itensVenda = itensVenda;
    }

    @Override
    public int getRowCount() {
        return itensVenda.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ItemVenda item = itensVenda.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return item.getProduto().getId(); 
            case 1:
                return item.getProduto().getDescricao();
            case 2:
                return item.getQuantidade();
            case 3:
                return item.getValorUnitario();
            case 4:
                return item.getValorTotal();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 2; 
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (columnIndex == 2) {
            ItemVenda item = itensVenda.get(rowIndex);
            item.setQuantidade((Integer) aValue);
            item.setValorTotal(item.getValorUnitario().multiply(BigDecimal.valueOf(item.getQuantidade())));
            fireTableCellUpdated(rowIndex, 4); // Atualiza a célula do valor total
            fireTableDataChanged(); // Atualiza a tabela inteira
        }
    }
    
}
