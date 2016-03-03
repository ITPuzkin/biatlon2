package model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

/**
 * Created by eroshin on 03.03.2016.
 */
public class JTableModel extends AbstractTableModel{

    public String modelName;
    public String[] columnNames;
    public ArrayList<Object[]> listData;

    public JTableModel(String n,String[] cArr){
        modelName = n;
        columnNames = cArr;
        listData = new ArrayList<>();
    }

    public void addData(JPerson p){
        listData.add(p.getObject());
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public int getRowCount() {
        return listData.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return listData.get(rowIndex)[columnIndex];
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        if (col < getColumnCount()-1)
            return false;
        else
            return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        listData.get(rowIndex)[5]=aValue.toString();
    }
}
