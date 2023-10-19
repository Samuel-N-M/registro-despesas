/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.infogest.model;

import java.awt.Color;
import java.awt.Component;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author samuel
 */
public class CorTabela extends DefaultTableCellRenderer {

    private List<String> tipos;

    public CorTabela(List<String> tipos) {
        this.tipos = tipos;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Verifique se o valor da coluna "tipo" na lista é igual a "receita" (ajuste isso de acordo com seus dados)
        String tipo = tipos.get(row);
        if (tipo.equals("Receita")) {
            setBackground(Color.GREEN);
        } else {
            setBackground(Color.RED);
        }

        return this;
    }
}
