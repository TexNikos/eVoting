/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablemodels;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nikos
 */
public class DisplayStatsTableModel extends AbstractTableModel {

    public static List<Object[]> tableContents = new ArrayList<>();
    private final String[] columns = {"Κόμμα", "Ψήφοι", "Ποσοστό"};


    @Override
    public int getRowCount() {
        return tableContents.size();
    }
    
    @Override
    public String getColumnName(int col) {
        return columns[col];
    }
    
    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object[] current = tableContents.get(rowIndex);
        return current[columnIndex];
    }
    
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

}
