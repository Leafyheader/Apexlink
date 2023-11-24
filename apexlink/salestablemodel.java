/*
 * CarTableModel.java
 *
 * Created on 2005/01/17, 15:31
 */

package apexlink;

import javax.swing.table.AbstractTableModel;
import java.sql.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author noniko
 */
public class salestablemodel extends AbstractTableModel {
    
    public static void setColumnWidths(JTable table, int... widths) {
    TableColumnModel columnModel = table.getColumnModel();
    for (int i = 0; i < widths.length; i++) {
        if (i < columnModel.getColumnCount()) {
            columnModel.getColumn(i).setMaxWidth(widths[i]);
           
          
        }
        else break;
         
    }
    }
   public static void setJTableColumnsWidth(JTable table, int tablePreferredWidth,
        double... percentages) {
    double total = 0;
    for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
        total += percentages[i];
    }
 
    for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
        TableColumn column = table.getColumnModel().getColumn(i);
        column.setPreferredWidth((int)
                (tablePreferredWidth * (percentages[i] / total)));
    }
}
  
    private int colnum=4;
    private int rownum;
    private String[] colNames={
        "name","quantity","price","amount"
    };
    private  ArrayList<String[]> ResultSets;
    
    /** Creates a new instance of FoodTableModel */
    public salestablemodel(ResultSet rs) {
      
      ResultSets=new ArrayList<String[]>();  
    
      try{
        while(rs.next()){
      
              String[] row={
               rs.getString("name"), rs.getString("quantity"),rs.getString("price"),rs.getString("amount")
          
            };
            ResultSets.add(row);
             
        
      
         }   
      }
      catch(Exception e){
        // System.out.println("Exception in salestablemodel");       
    }
    }
    public Object getValueAt(int rowindex, int columnindex) {
        
       String[] row=ResultSets.get(rowindex);
       return row[columnindex];
        
    }

    public int getRowCount() {
        return ResultSets.size();
    }

    public int getColumnCount() {
        return colnum;
    }

    public String getColumnName(int param) {

       return colNames[param];
    }
    

}
