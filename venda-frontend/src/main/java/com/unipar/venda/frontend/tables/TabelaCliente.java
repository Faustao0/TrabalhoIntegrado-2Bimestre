package com.unipar.venda.frontend.tables;

import com.unipar.venda.frontend.model.Cliente;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TabelaCliente extends AbstractTableModel{

    private final List<Cliente> clientes;
    private final String[] colunas = {"ID", "Nome", "Telefone", "Email"};

    public TabelaCliente(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    public Cliente getClienteAt(int rowIndex) {
    return clientes.get(rowIndex);
}

    @Override
    public int getRowCount() {
        return clientes.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente cliente = clientes.get(rowIndex);
        switch (columnIndex) {
            case 0: return cliente.getId();
            case 1: return cliente.getNome();
            case 2: return cliente.getTelefone();
            case 3: return cliente.getEmail();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
}

