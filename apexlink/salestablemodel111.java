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

/**
 *
 * @author noniko
 */
public class salestablemodel111 extends AbstractTableModel {
    
    private int colnum=7;
    private int rownum;
    private String[] colNames={
        "orderid","orderdate","productname","quantity","price","customername","salesuser"
    };
    private  ArrayList<String[]> ResultSets;
    
    /** Creates a new instance of FoodTableModel */
    public salestablemodel111(ResultSet rs) {
      
      ResultSets=new ArrayList<String[]>();  
    
      try{
        while(rs.next()){
      
              String[] row={
               rs.getString("orderid"), rs.getString("orderdate"), rs.getString("productname"), rs.getString("quantity"), rs.getString("price"), rs.getString("customername"), rs.getString("salesuser")
          
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

       return colNames[param];
    }
  
}
