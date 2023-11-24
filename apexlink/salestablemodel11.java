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
import javax.swing.table.TableColumnModel;

/**
 *
 * @author noniko
 */
public class salestablemodel11 extends AbstractTableModel {
    public static void setColumnWidths(JTable table, int... widths) {
    TableColumnModel columnModel = table.getColumnModel();
    for (int i = 0; i < widths.length; i++) {
        if (i < columnModel.getColumnCount()) {
            columnModel.getColumn(i).setMaxWidth(widths[i]);
           
          
        }
        else break;
    }
    }
    
    private int colnum=4;
    private int rownum;
   // private String[] colNames={
       // "orderid","orderdate","productname","customername"
  //  };
    private  ArrayList<String[]> ResultSets;
    
    /** Creates a new instance of FoodTableModel */
    public salestablemodel11(ResultSet rs) {
      
      ResultSets=new ArrayList<String[]>();  
    
      try{
        while(rs.next()){
      
              String[] row={
               rs.getString("orderid"), rs.getString("orderdate"), rs.getString("name"), rs.getString("customername")
          
            };
            ResultSets.add(row);
      
         }   
      }
      catch(Exception e){
        //  System.out.println("Exception in salestablemodel");
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

       return null;
    }
  
 
}
