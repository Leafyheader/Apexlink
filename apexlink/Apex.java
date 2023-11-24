/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Leafyheader
 */

package apexlink;
 
//import static apexlink.Display.outputStream;
//import static apexlink.InvoiceGenerator.generateInvoiceNumber;
import com.jtattoo.plaf.DecorationHelper;
import java.awt.Color;
import java.awt.Graphics;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import org.apache.commons.dbutils.DbUtils;
import static apexlink.salestablemodel.setJTableColumnsWidth;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.IOException;
import java.sql.Statement;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Leafyheader
 */
public class Apex extends javax.swing.JFrame {

    private ResultSet rs;
    int xMouse;
    int yMouse;
    private static final String CREATE_TABLE = "CREATE TABLE Till1(id INT(11) NOT NULL AUTO_INCREMENT,name VARCHAR(100)  NOT NULL CHECK (name <> ''), quantity INT(4)  NOT NULL, price DECIMAL(10,2),PRIMARY KEY (id), orderid INT(11) NOT NULL, customername VARCHAR(45), salesuser VARCHAR(45) NOT NULL, amount DECIMAL(10,2),orderdate DATETIME,   UNIQUE INDEX (name))";
   private static final String CREATE_TABLE1 = "CREATE TABLE Till2(id INT(11) NOT NULL AUTO_INCREMENT,name VARCHAR(100)  NOT NULL CHECK (name <> ''), quantity INT(4)  NOT NULL, price DECIMAL(10,2),PRIMARY KEY (id), orderid INT(11) NOT NULL, customername VARCHAR(45), salesuser VARCHAR(45) NOT NULL, amount DECIMAL(10,2),orderdate DATETIME,   UNIQUE INDEX (name))";

    private static final String RELOAD  = "CREATE TABLE RELOAD (id INT(11) NOT NULL AUTO_INCREMENT,name VARCHAR(100)  NOT NULL CHECK (name <> ''), quantity INT(4)  NOT NULL, price DECIMAL(10,2),PRIMARY KEY (id), orderid INT(30) NOT NULL, customername VARCHAR(45), salesuser VARCHAR(45) NOT NULL, amount DECIMAL(10,2),orderdate DATETIME,   UNIQUE INDEX (name)) ";
    private static final String DROP_INSTOCK = "DROP TABLE instocktemp";
    private static final String DROP_INSTOCK1 = "DROP TABLE instocktemp1";
    private static final String DROP_TABLE = "DROP TABLE Till1";
     private static final String DROP_TABLE1 = "DROP TABLE Till2";
private static final String CREATE_TOTALS = "CREATE TABLE totals1(orderid INT(11) NOT NULL  , total DECIMAL(10,2), customername VARCHAR(45), salesuser VARCHAR(45), orderdate DATETIME,PRIMARY KEY (orderid))";
private static final String CREATE_TOTALS1 = "CREATE TABLE totals11(orderid INT(11) NOT NULL  , total DECIMAL(10,2), customername VARCHAR(45), salesuser VARCHAR(45), orderdate DATETIME,PRIMARY KEY (orderid))";
 
private static final String INVOICE1_TABLE ="CREATE TABLE INVOICE LIKE MARKER";
    private static final String DROP_TOTALS = "DROP TABLE totals1";
     private static final String DROP_TOTALS1 = "DROP TABLE totals11";
     private static final String DROP_RELOAD = "DROP TABLE RELOAD";
    // private static final String DROP_INSTOCK = "DROP TABLE instocktemp";
 private static final String CREATE_INSTOCK= "create table instocktemp (name varchar (100), stock int (11))";
private static final String CREATE_INSTOCK1= "create table instocktemp1 (name varchar (100), stock int (11))";

 private static final String SEARCH_TABLE_lite = "CREATE TABLE invoicesales(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,name VARCHAR(100)  NOT NULL, quantity INT(4)  NOT NULL, price DOUBLE,orderid INT(11) NOT NULL, customername VARCHAR(45), salesuser VARCHAR(45) NOT NULL,amount DOUBLE,  UNIQUE(name))";
private static final String DROP_INVOICETABLE= "DROP TABLE invoicesales";  
//    private static final String DROP_TABLE = "insert into searchsales (name, quantity, price) select productname, quantity, price from invoice where orderid = ?";
  private static final String totals_TABLE = "CREATE TABLE totals111(orderid INT(11) NOT NULL  , total DECIMAL(10,2), customername VARCHAR(45), salesuser VARCHAR(45), orderdate DATETIME,PRIMARY KEY (orderid))";
 private static final String DROP_INVOICETOTALS = "DROP TABLE totals111";
 private static final String SEARCH_TABLE = "CREATE TABLE invoicesales(id INT(11) NOT NULL AUTO_INCREMENT,idrow INT(11),name VARCHAR(100)  NOT NULL, quantity INT(4)  NOT NULL, price DECIMAL(10,2),PRIMARY KEY (id), orderid INT(11) NOT NULL, customername VARCHAR(45), salesuser VARCHAR(45) NOT NULL,amount DOUBLE,orderdate DATETIME,UNIQUE(name) )";
  
 /**
     * Creates new form Apex
     */
    public Apex() {
        initComponents();
      //  setBackground(new Color(0,0,0,0));
       // start();
      //  panelremove();
      setIcon();
       error.setEnabled(false);
          error.setVisible(false);
          errorclose.setEnabled(false);
          errorclose.setVisible(false);
          errormsg.setEnabled(false);
          errormsg.setVisible(false);
          error1.setEnabled(false);
          error1.setVisible(false);
          success.setEnabled(false);
          success.setVisible(false);
          ok.setEnabled(false);
          ok.setVisible(false);
          gif.setEnabled(false);
          gif.setVisible(false);
          error2.setEnabled(false);
          error2.setVisible(false);
          success1.setEnabled(false);
          success1.setVisible(false);
          ok1.setEnabled(false);
          ok1.setVisible(false);
          gif1.setEnabled(false);
          gif1.setVisible(false);
          error4.setEnabled(false);
          error4.setVisible(false);
          errormsg1.setEnabled(false);
          errormsg1.setVisible(false);
          errorclose1.setEnabled(false);
          errorclose1.setVisible(false);
                
       start();
           panelremove();
           
    }
    private void setIcon(){
     setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icons/logo1.png")));
}
    private void start(){
          try{
           main.removeAll();
          main.repaint();
           main.revalidate();
           main.add(tillone);
           main.repaint();
           main.revalidate();
       }catch(Exception e){
       
       }  
         header.setText("TILL ONE");
    
    }
    private void start2(){
          try{
           main.removeAll();
        main.repaint();
           main.revalidate();
           main.add(tilltwo);
          main.repaint();
           main.revalidate();
       }catch(Exception e){
       
       } 
         header1.setText("TILL TWO");
    
    }
     private void start3(){
          try{
           main.removeAll();
          main.repaint();
           main.revalidate();
           main.add(invoice);
           main.repaint();
           main.revalidate();
       }catch(Exception e){
       
       }  
         header2.setText("INVOICE");
    
    }
      private void start4(){
          try{
           main.removeAll();
          main.repaint();
           main.revalidate();
           main.add(product);
           main.repaint();
           main.revalidate();
       }catch(Exception e){
       
       }  
         header2.setText("PRODUCT");
    
    }
       private void productlogin(){
          try{
           main.removeAll();
          main.repaint();
           main.revalidate();
           main.add(productlogin);
           main.repaint();
           main.revalidate();
       }catch(Exception e){
          password.requestFocusInWindow();
       
       }  
      //   header.setText("TILL ONE");
    
    }
        private void Changepass(){
          try{
           main.removeAll();
          main.repaint();
           main.revalidate();
           main.add(ChangePass);
           main.repaint();
           main.revalidate();
       }catch(Exception e){
          password.requestFocusInWindow();
       
       }  
      //   header.setText("TILL ONE");
    
    }
private void panelremove(){
   invoicepanelview.setEnabled(false);
        invoicepanelview.setVisible(false);
        tilltwopanelview.setEnabled(false);
        tilltwopanelview.setVisible(false);
        tillonepanelview.setEnabled(false);
        tillonepanelview.setVisible(false);
        settingspanelview.setEnabled(false);
        settingspanelview.setVisible(false);
        userpanelview.setEnabled(false);
        userpanelview.setVisible(false);
        printpanelview.setEnabled(false);
        printpanelview.setVisible(false);
        refreshpanelview.setEnabled(false);
        refreshpanelview.setVisible(false);
        savepanel.setEnabled(false);
        savepanel.setVisible(false);
        updatepanel.setEnabled(false);
        updatepanel.setVisible(false);
        deletepanel.setEnabled(false);
        deletepanel.setVisible(false);
        clearpanel.setEnabled(false);
        clearpanel.setVisible(false);
        settings.setEnabled(false);
        settings.setVisible(false);
        printpanel.setEnabled(false);
        printpanel.setVisible(false);
        productspanel.setEnabled(false);
        productspanel.setVisible(false);
        exitpanel.setEnabled(false);
        exitpanel.setVisible(false);
       settingsoff.setEnabled(false);
       settingsoff.setVisible(false);
       printerbutt.setEnabled(false);
       printerbutt.setVisible(false);
       productbutt.setEnabled(false);
       productbutt.setVisible(false);
       exitbutt.setEnabled(false);
       exitbutt.setVisible(false);
       Useroff.setEnabled(false);
       Useroff.setVisible(false);
         createuser.setEnabled(false);
        createuser.setVisible(false);
        changepass.setEnabled(false);
        changepass.setVisible(false);
        quantityField.setEnabled(true);
        quantityField.setVisible(true);
        updatebutt.setEnabled(true);
        updatebutt.setVisible(true);
        deletebutt.setEnabled(true);
        deletebutt.setVisible(true);
      
}    
private void panelremove2(){
   invoicepanelview1.setEnabled(false);
        invoicepanelview1.setVisible(false);
        tilltwopanelview1.setEnabled(false);
        tilltwopanelview1.setVisible(false);
        tillonepanelview1.setEnabled(false);
        tillonepanelview1.setVisible(false);
        settingspanelview1.setEnabled(false);
        settingspanelview1.setVisible(false);
        userpanelview1.setEnabled(false);
        userpanelview1.setVisible(false);
        printpanelview1.setEnabled(false);
        printpanelview1.setVisible(false);
        refreshpanelview1.setEnabled(false);
        refreshpanelview1.setVisible(false);
        savepanel1.setEnabled(false);
        savepanel1.setVisible(false);
        updatepanel1.setEnabled(false);
        updatepanel1.setVisible(false);
        deletepanel1.setEnabled(false);
        deletepanel1.setVisible(false);
        clearpanel1.setEnabled(false);
        clearpanel1.setVisible(false);
        settings1.setEnabled(false);
        settings1.setVisible(false);
        printpanel1.setEnabled(false);
        printpanel1.setVisible(false);
        productspanel1.setEnabled(false);
        productspanel1.setVisible(false);
        exitpanel1.setEnabled(false);
        exitpanel1.setVisible(false);
        settingsoff1.setEnabled(false);
       settingsoff1.setVisible(false);
        printerbutt1.setEnabled(false);
       printerbutt1.setVisible(false);
       productbutt1.setEnabled(false);
       productbutt1.setVisible(false);
       exitbutt1.setEnabled(false);
       exitbutt1.setVisible(false);
}    
 private void panelremove3(){
   invoicepanelview2.setEnabled(false);
        invoicepanelview2.setVisible(false);
        tilltwopanelview2.setEnabled(false);
        tilltwopanelview2.setVisible(false);
        tillonepanelview2.setEnabled(false);
        tillonepanelview2.setVisible(false);
        settingspanelview2.setEnabled(false);
        settingspanelview2.setVisible(false);
        userpanelview2.setEnabled(false);
        userpanelview2.setVisible(false);
        printpanelview2.setEnabled(false);
        printpanelview2.setVisible(false);
        refreshpanelview2.setEnabled(false);
        refreshpanelview2.setVisible(false);
        savepanel2.setEnabled(false);
        savepanel2.setVisible(false);
        updatepanel2.setEnabled(false);
        updatepanel2.setVisible(false);
        deletepanel2.setEnabled(false);
        deletepanel2.setVisible(false);
        clearpanel2.setEnabled(false);
        clearpanel2.setVisible(false);
        settings2.setEnabled(false);
        settings2.setVisible(false);
        printpanel2.setEnabled(false);
        printpanel2.setVisible(false);
        productspanel2.setEnabled(false);
        productspanel2.setVisible(false);
        exitpanel2.setEnabled(false);
        exitpanel2.setVisible(false);
        settingsoff2.setEnabled(false);
       settingsoff2.setVisible(false);
        printerbutt2.setEnabled(false);
       printerbutt2.setVisible(false);
       productbutt2.setEnabled(false);
       productbutt2.setVisible(false);
       exitbutt2.setEnabled(false);
       exitbutt2.setVisible(false);
       settingsoff2.setEnabled(false);
       settingsoff2.setVisible(false);
       editpanel.setEnabled(false);
       editpanel.setEnabled(false);
} 
 private void panelremove4(){
   invoicepanelview3.setEnabled(false);
        invoicepanelview3.setVisible(false);
        tilltwopanelview3.setEnabled(false);
        tilltwopanelview3.setVisible(false);
        tillonepanelview3.setEnabled(false);
        tillonepanelview3.setVisible(false);
        settingspanelview3.setEnabled(false);
        settingspanelview3.setVisible(false);
        userpanelview3.setEnabled(false);
        userpanelview3.setVisible(false);
      //  printpanelview3.setEnabled(false);
       // printpanelview3.setVisible(false);
       // refreshpanelview3.setEnabled(false);
       // refreshpanelview3.setVisible(false);
        savepanel3.setEnabled(false);
        savepanel3.setVisible(false);
        updatepanel3.setEnabled(false);
        updatepanel3.setVisible(false);
        deletepanel3.setEnabled(false);
        deletepanel3.setVisible(false);
        clearpanel3.setEnabled(false);
        clearpanel3.setVisible(false);
        settings3.setEnabled(false);
        settings3.setVisible(false);
        printpanel3.setEnabled(false);
        printpanel3.setVisible(false);
        productspanel3.setEnabled(false);
        productspanel3.setVisible(false);
        exitpanel3.setEnabled(false);
        exitpanel3.setVisible(false);
       settingsoff3.setEnabled(false);
       settingsoff3.setVisible(false);
       printerbutt3.setEnabled(false);
       printerbutt3.setVisible(false);
       productbutt3.setEnabled(false);
       productbutt3.setVisible(false);
       exitbutt3.setEnabled(false);
       exitbutt3.setVisible(false);
}    
private void Createinvoice(){
    Connection conn = null;
    Statement stmt = null;
    try {
     conn= mysqlconnect.ConnectDb();
      stmt = conn.createStatement();
      stmt.executeUpdate(SEARCH_TABLE);
    }
catch (Exception e){
        JOptionPane.showMessageDialog(null, e);
        }
      finally{
           // DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(stmt);
    DbUtils.closeQuietly(conn);
                        }    
               
   
                                
}
private void Create() {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = mysqlconnect.ConnectDb();
            stmt = conn.createStatement();
            stmt.executeUpdate(CREATE_TABLE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
           DbUtils.closeQuietly(stmt);
    DbUtils.closeQuietly(conn);
        }
    }
private void Create1() {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = mysqlconnect.ConnectDb();
            stmt = conn.createStatement();
            stmt.executeUpdate(CREATE_TABLE1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
           DbUtils.closeQuietly(stmt);
    DbUtils.closeQuietly(conn);
        }
    }

private void DropTable() throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = mysqlconnect.ConnectDb();
            stmt = conn.createStatement();
            stmt.executeUpdate(DROP_TABLE);
          
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
           DbUtils.closeQuietly(stmt);
    DbUtils.closeQuietly(conn);
        }
    } 
private void DropTable1() throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = mysqlconnect.ConnectDb();
            stmt = conn.createStatement();
            stmt.executeUpdate(DROP_TABLE1);
          
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
           DbUtils.closeQuietly(stmt);
    DbUtils.closeQuietly(conn);
        }
    } 

 private void Labeldisplay(){
              Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
Statement stmt =null;
              conn = mysqlconnect.ConnectDb();
    String sql1 = "select orderid from ordersinvoice where orderid = ?";
    try{
                    // String tmp1 = (String)custCombo.getSelectedItem();
                      pst = conn.prepareStatement(sql1);
                       //pst.setString(1, tmp1);
                       pst.setString(1, orderField.getText());
                    rs = pst.executeQuery();
                    if (rs.next()){
                       String add = rs.getString("orderid");
                        orderid.setText(add);
                       
                    }
    }
        catch (Exception e){
        JOptionPane.showMessageDialog(null, e);
    
 }
    finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
                        }    
 }
  private void CreateTotalsinvoice() {
        Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
Statement stmt =null;
        try {
            conn = mysqlconnect.ConnectDb();
            stmt = conn.createStatement();
            stmt.executeUpdate(totals_TABLE );
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
      finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
                        }    
    
 }
 private void Labeldisplay2(){
     Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
Statement stmt =null;
     conn = mysqlconnect.ConnectDb();
    String sql = "select * from custinvoice where customername = ?";
    try{
                    String tmp1 = (String)custCombo.getSelectedItem();
                      pst = conn.prepareStatement(sql);
                       //pst.setString(1, tmp1);
                       pst.setString(1, tmp1);
                    rs = pst.executeQuery();
                    if (rs.next()){
                       String add = rs.getString("customername");
                        custName.setText(add);
                       
                    }
    }
        catch (Exception e){
        JOptionPane.showMessageDialog(null, e);
    
 }
     finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
                        }    
 }
private void UpdateAmount2invoice(){
    Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
Statement stmt =null;
    conn= mysqlconnect.ConnectDb();
  String sql = "update amountinvoice inner join quantityinvoice on amountinvoice.name= quantityinvoice.name and amountinvoice.orderid= quantityinvoice.orderid inner join priceinvoice on amountinvoice.name= priceinvoice.name and amountinvoice.orderid= priceinvoice.orderid set amount = ROUND(quantityinvoice.quantity*priceinvoice.price,2) where amountinvoice.name = 'R L' and amountinvoice.orderid = '3775'";
  String tmp = (String) nameCombo2.getSelectedItem();
  try {
            pst = conn.prepareStatement(sql);
            pst.setString(1,nameCode2.getText());
            //pst.setString(1,priceLabel.getText());
         pst.setString(2, orderid.getText());
             pst.execute();   
}
       catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
  finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
                        }    
}
private void UpdateAmountinvoice(){
    Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
Statement stmt =null;
    conn= mysqlconnect.ConnectDb();
         String tmp = (String) nameCombo2.getSelectedItem();
    String sql = "update invoicesales set amount = ROUND(quantity*price,2) where name = ?";
    try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, nameCode2.getText());
           // pst.setString(1, priceLabel.getText());
             pst.execute();   
    }
       catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
                        }    
    }
private void Amountinvoice(){
    Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
Statement stmt =null;
    conn= mysqlconnect.ConnectDb();
  String sql = "update invoicesales set amount = ROUND(quantity*price,2) where name = ?";
  String tmp = (String) nameCombo2.getSelectedItem();
  try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, tmp);
            //pst.setString(1, priceLabel.getText());
             pst.execute();   
}
       catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
   finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
                        }    
}
private void interest(){
        Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
    String tmp = (String) percentage4.getSelectedItem();
    String tmp1 = (String) nameCombo.getSelectedItem();
    String sql = "update Till1 set price = ROUND((?*?/?+?),2) where name = ? ";
    try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, pricefortable.getText());
            pst.setString(2, tmp);
            pst.setString(3, percenlabel.getText());
            pst.setString(4, pricefortable.getText());
            pst.setString(5, tmp1);
             pst.execute();   
}
       catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
      
                finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
                        }                     
    }
private void interestinvoice(){
        Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
    String tmp = (String) invoicepercentage.getSelectedItem();
    String tmp1 = (String) nameCombo2.getSelectedItem();
    String sql = "update invoicesales set price = ROUND((?*?/?+?),2) where name = ? ";
    try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, pricefortable2.getText());
            pst.setString(2, tmp);
            pst.setString(3, percenlabel2.getText());
            pst.setString(4, pricefortable2.getText());
            pst.setString(5, tmp1);
             pst.execute();   
}
       catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
      
                finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
                        }                     
    }
private void interest1(){
        Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
    String tmp = (String) percentage5.getSelectedItem();
    String tmp1 = (String) nameCombo1.getSelectedItem();
    String sql = "update Till2 set price = ROUND((?*?/?+?),2) where name = ? ";
    try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, pricefortable1.getText());
            pst.setString(2, tmp);
            pst.setString(3, percenlabel1.getText());
            pst.setString(4, pricefortable1.getText());
            pst.setString(5, tmp1);
             pst.execute();   
}
       catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
      
                finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
                        }                     
    }
 private void interest2(){
       Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
  String sql = "update invoice set price = ROUND((?*?/?+?),2) where productname = ? and orderid = ?";
  try {
      String tmp = (String) percentage.getSelectedItem();
      String tmp1 = (String) nameCombo.getSelectedItem();
            pst = conn.prepareStatement(sql);
            pst.setString(1, pricefortable.getText());
            pst.setString(2, tmp);
            pst.setString(3, percenlabel.getText());
            pst.setString(4, pricefortable.getText());
            pst.setString(5, tmp1);
            pst.setString(6, orderid2.getText());
             pst.execute();   
}
       catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
   finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
                        }     
   }
private void productsearch(){
     Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
        try {
             
            String tmp = (String) nameCombo.getSelectedItem();
            String sql = "select * from product where name = ?";

            pst = conn.prepareStatement(sql);
            pst.setString(1, tmp);
            rs = pst.executeQuery();
            if (rs.next()) {
                String add1 = rs.getString("pricesell");
                priceLabel.setText(add1);
                String add2 = rs.getString("name");
                nameCode.setText(add2);
                 String add3 = rs.getString("description");
                typeLabel.setText(add3);
                 String add4 = rs.getString("inthebox");
                boxLabel.setText(add4);
               String add5 = rs.getString("instock");
                instocklabel.setText(add5);
                 String add6 = rs.getString("pricesell");
               pricefortable.setText(add6);
                //String add7 = rs.getString("stocklimit");
                //instocklimit.setText(add7);
                RetailShow();
 /*  if(display.getText().equals("1")){
     String add8=RetailLabel.getText();
     String text1=" "+add2+" "; 
     String text2="     "+add8+"     ";  
      PrintFirstLine1("  "+text1+"  ");
    PrintSecondLine1(" "+text2+" ");
   }else{             
    String text1=" "+add2+" ";                              // 20 characters
    String text2="     "+add6+"     ";                              //20 characters
    PrintFirstLine1("  "+text1+"  ");
    PrintSecondLine1(" "+text2+" ");
            }*/
        
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
        }
        //searchlist();
nameCombo.transferFocus();
        quantityField.requestFocusInWindow();
        //Retail();
        
       // nameCode.setText("");
        
checkinstock();
               
}
private void productsearchinvoice(){
     Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
        try {
             
            String tmp = (String) nameCombo2.getSelectedItem();
            String sql = "select * from product where name = ?";

            pst = conn.prepareStatement(sql);
            pst.setString(1, tmp);
            rs = pst.executeQuery();
            if (rs.next()) {
                String add1 = rs.getString("pricesell");
                priceLabel2.setText(add1);
               // String add2 = rs.getString("name");
                //nameCode.setText(add2);
                 String add3 = rs.getString("description");
                typeLabel2.setText(add3);
                 String add4 = rs.getString("inthebox");
                boxLabel2.setText(add4);
               String add5 = rs.getString("instock");
                instocklabel2.setText(add5);
                 String add6 = rs.getString("pricesell");
               pricefortable2.setText(add6);
                //String add7 = rs.getString("stocklimit");
                //instocklimit.setText(add7);
            }
        

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
        }
        //searchlist();
nameCombo2.transferFocus();
        quantityField2.requestFocusInWindow();
        //Retail();
        RetailShowinvoice();
        nameCode2.setText("");
        
checkinstockinvoice();
}            
private void productsearch1(){
     Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
        try {
             
            String tmp = (String) nameCombo1.getSelectedItem();
            String sql = "select * from product where name = ?";

            pst = conn.prepareStatement(sql);
            pst.setString(1, tmp);
            rs = pst.executeQuery();
            if (rs.next()) {
                String add1 = rs.getString("pricesell");
                priceLabel1.setText(add1);
                String add2 = rs.getString("name");
                //nameCode.setText(add2);
                 String add3 = rs.getString("description");
                typeLabel1.setText(add3);
                 String add4 = rs.getString("inthebox");
                boxLabel1.setText(add4);
               String add5 = rs.getString("instock");
                instocklabel1.setText(add5);
                 String add6 = rs.getString("pricesell");
                pricefortable1.setText(add6);
                //String add7 = rs.getString("stocklimit");
                //instocklimit.setText(add7);
                RetailShow1();
            /*  if(display1.getText().equals("1")){
     String add8=RetailLabel1.getText();
     String text1=" "+add2+" "; 
     String text2="     "+add8+"     ";  
      PrintFirstLine1("  "+text1+"  ");
    PrintSecondLine1(" "+text2+" ");
   }else{             
    String text1=" "+add2+" ";                              // 20 characters
    String text2="     "+add6+"     ";                              //20 characters
    PrintFirstLine1("  "+text1+"  ");
    PrintSecondLine1(" "+text2+" ");
            }*/
            }
        

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
        }
        //searchlist();
nameCombo1.transferFocus();
        quantityField1.requestFocusInWindow();
        //Retail();
        
        nameCode1.setText("");
        
checkinstock1();
               
}
private void CountRecords(){
    Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
    try {
            String sql = "select count(*)from Till1";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String name = rs.getString("count(*)");
                count.setText(name);
                ordercheck.setText("1");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e); 
} 
    DbUtils.closeQuietly(rs);
           DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
}
private void CountRecords1(){
    Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
    try {
            String sql = "select count(*)from Till2";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String name = rs.getString("count(*)");
                count1.setText(name);
                ordercheck1.setText("1");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e); 
} 
    DbUtils.closeQuietly(rs);
           DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
}
private void CountRecordsinvoice(){
    Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
    try {
            String sql = "select count(*)from invoicesales";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String name = rs.getString("count(*)");
                count2.setText(name);
                ordercheck2.setText("1");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e); 
} 
    DbUtils.closeQuietly(rs);
           DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
}

    private void Amount(){
         Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
         String tmp = (String) nameCombo.getSelectedItem();
    String sql = "update Till1 set amount = ROUND(quantity*price,2) where name = ?";
    try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, tmp);
           // pst.setString(1, priceLabel.getText());
             pst.execute();   
    }
       catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
                        }     
    }
     private void Amount1(){
         Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
         String tmp = (String) nameCombo1.getSelectedItem();
    String sql = "update Till2 set amount = ROUND(quantity*price,2) where name = ?";
    try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, tmp);
           // pst.setString(1, priceLabel.getText());
             pst.execute();   
    }
       catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
                        }     
    }
     private void invoicenorminsert() {
         Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
        String sql = "insert into invoice (orderid, orderdate, productname, quantity, price, customername, salesuser,amount) select orderid,orderdate,name,quantity,price,customername,salesuser,amount from Till1";
 String sql1 = "insert into ordersinvoice (orderid, orderdate,name) select orderid,orderdate,name from Till1";
 String sql2 = "insert into productinvoice (orderid, name) select orderid,name from Till1";
 String sql3 = "insert into priceinvoice (orderid, price,name) select orderid,price,name from Till1";
 String sql4 = "insert into amountinvoice (orderid, amount,name) select orderid,amount,name from Till1";
String sql5 = "insert into quantityinvoice (orderid, quantity,name) select orderid,quantity,name from Till1";
String sql6 = "insert into custinvoice (orderid, customername,name) select orderid,customername,name from Till1";
String sql7 = "insert into salesperson (orderid,salesuser,name ) select orderid,salesuser,name from Till1";
        String tmp = (String) nameCombo.getSelectedItem();
        String tmp1 = (String) customerCombo.getSelectedItem();
        try {
            pst = conn.prepareStatement(sql1);
            pst.execute();
            pst.close();
            pst = conn.prepareStatement(sql2);
            pst.execute();
            pst.close();
            pst = conn.prepareStatement(sql3);
            pst.execute();
            pst.close();
            pst = conn.prepareStatement(sql4);
            pst.execute();
            pst.close();
            pst = conn.prepareStatement(sql5);
            pst.execute();
            pst.close();
            pst = conn.prepareStatement(sql6);
            pst.execute();
            pst.close();
            pst = conn.prepareStatement(sql7);
            pst.execute();
            pst.close();

           // UpdateJTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
    }
    }
     private void UpdateInvoice3(){
      Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
//String name1= invoicebox.getSelectedItem().toString();
      String tmp = (String) invoicepercentage.getSelectedItem();
    String sql = "update priceinvoice set price = ROUND((price* ?/? + price),2) where orderid = ? ";
    try {
            pst = conn.prepareStatement(sql);
           // pst.setString(1, priceLabel.getText());
            pst.setString(1, tmp);
            pst.setString(2, percenlabel2.getText());
           // pst.setString(4, priceLabel.getText());
            pst.setString(3, orderid.getText());
             pst.execute();   
}
       catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            
            
}
    finally{
           DbUtils.closeQuietly(rs);
           DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
                                           
       }
}
     private void invoicenormupdate() {
         Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
        String sql = "insert into invoice (orderid, orderdate, productname, quantity, price, customername, salesuser,amount) select orderid,orderdate,name,quantity,price,customername,salesuser,amount from Till1";
// String sql1 = "update ordersinvoice,invoicesales set ordersinvoice.orderid=invoicesales.orderid, ordersinvoice.orderdate=invoicesales.orderdate,ordersinvoice.name=invoicesales.name where ordersinvoice.orderid=invoicesales.orderid";
// String sql2 = "update productinvoice,invoicesales set productinvoice.orderid=invoicesales.orderid,productinvoice.name=invoicesales.name where productinvoice.orderid=invoicesales.orderid";
 String sql3 = "update priceinvoice,invoicesales set  priceinvoice.price=invoicesales.price where priceinvoice.orderid=invoicesales.orderid and priceinvoice.name=invoicesales.name";
String sql4 = "update amountinvoice,invoicesales set  amountinvoice.amount=invoicesales.amount where amountinvoice.orderid=invoicesales.orderid and amountinvoice.name=invoicesales.name";
//String sql5 = "update quantityinvoice,invoicesales set quantityinvoice.orderid=invoicesales.orderid, quantityinvoice.orderdate=invoicesales.orderdate,quantityinvoice.name=invoicesales.name where quantityinvoice.orderid=invoicesales.orderid";
//String sql6 = "update custinvoice,invoicesales set custinvoice.orderid=invoicesales.orderid, custinvoice.orderdate=invoicesales.orderdate,custinvoice.name=invoicesales.name where custinvoice.orderid=invoicesales.orderid";
//String sql7 = "update salesperson,invoicesales set salesperson.orderid=invoicesales.orderid, salesperson.orderdate=invoicesales.orderdate,salesperson.name=invoicesales.name where salesperson.orderid=invoicesales.orderid";
        String tmp = (String) nameCombo.getSelectedItem();
        String tmp1 = (String) customerCombo.getSelectedItem();
        try {
           // pst = conn.prepareStatement(sql1);
           // pst.execute();
           // pst.close();
           // pst = conn.prepareStatement(sql2);
            //pst.execute();
            //pst.close();
            pst = conn.prepareStatement(sql3);
            pst.execute();
            pst.close();
            pst = conn.prepareStatement(sql4);
            pst.execute();
            pst.close();
            //pst = conn.prepareStatement(sql5);
            //pst.execute();
            //pst.close();
           // pst = conn.prepareStatement(sql6);
           // pst.execute();
           // pst.close();
            //pst = conn.prepareStatement(sql7);
            //pst.execute();
           // pst.close();

           // UpdateJTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
    }
    }
     private void invoicenorminsert1() {
         Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
        String sql = "insert into invoice (orderid, orderdate, productname, quantity, price, customername, salesuser,amount) select orderid,orderdate,name,quantity,price,customername,salesuser,amount from Till2";
 String sql1 = "insert into ordersinvoice (orderid, orderdate,name) select orderid,orderdate,name from Till2";
 String sql2 = "insert into productinvoice (orderid, name) select orderid,name from Till2";
 String sql3 = "insert into priceinvoice (orderid, price,name) select orderid,price,name from Till2";
 String sql4 = "insert into amountinvoice (orderid, amount,name) select orderid,amount,name from Till2";
String sql5 = "insert into quantityinvoice (orderid, quantity,name) select orderid,quantity,name from Till2";
String sql6 = "insert into custinvoice (orderid, customername,name) select orderid,customername,name from Till2";
String sql7 = "insert into salesperson (orderid,salesuser,name ) select orderid,salesuser,name from Till2";
        String tmp = (String) nameCombo1.getSelectedItem();
        String tmp1 = (String) customerCombo1.getSelectedItem();
        try {
            pst = conn.prepareStatement(sql1);
            pst.execute();
            pst.close();
            pst = conn.prepareStatement(sql2);
            pst.execute();
            pst.close();
            pst = conn.prepareStatement(sql3);
            pst.execute();
            pst.close();
            pst = conn.prepareStatement(sql4);
            pst.execute();
            pst.close();
            pst = conn.prepareStatement(sql5);
            pst.execute();
            pst.close();
            pst = conn.prepareStatement(sql6);
            pst.execute();
            pst.close();
            pst = conn.prepareStatement(sql7);
            pst.execute();
            pst.close();

           // UpdateJTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
    }
    }
      private void invoicenorminsert2() {
         Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
        String sql = "insert into invoice (orderid, orderdate, productname, quantity, price, customername, salesuser,amount) select orderid,orderdate,name,quantity,price,customername,salesuser,amount from Till1";
 String sql1 = "insert into ordersinvoice (orderid, orderdate,name) values (?,?,?)";
 String sql2 = "insert into productinvoice (orderid, name) values (?,?)";
 String sql3 = "insert into priceinvoice (orderid, price,name) values (?,?,?)";
 String sql4 = "insert into amountinvoice (orderid,name) values (?,?)";
String sql5 = "insert into quantityinvoice (orderid, quantity,name) values (?,?,?)";
String sql6 = "insert into custinvoice (orderid, customername,name) values (?,?,?)";
String sql7 = "insert into salesperson (orderid,salesuser,name ) values(?,?,?)";
        String tmp = (String) nameCombo2.getSelectedItem();
        String tmp1 = (String) customerCombo.getSelectedItem();
        try {
            pst = conn.prepareStatement(sql1);
            pst.setString(1, orderid.getText());
            pst.setTimestamp(2, getCurrentDate());
            pst.setString(3,tmp);
            pst.execute();
            pst.close();
            pst = conn.prepareStatement(sql2);
            pst.setString(1, orderid.getText());
            pst.setString(2,tmp);
            pst.execute();
            pst.close();
            pst = conn.prepareStatement(sql3);
            pst.setString(1, orderid.getText());
            pst.setString(2, priceLabel2.getText());
            pst.setString(3,tmp);
            pst.execute();
            pst.close();
            pst = conn.prepareStatement(sql4);
            pst.setString(1, orderid.getText());
           // pst.setTimestamp(2, getCurrentDate());
            pst.setString(2,tmp);
            pst.execute();
            pst.close();
            pst = conn.prepareStatement(sql5);
            pst.setString(1, orderid.getText());
            pst.setString(2, quantityField2.getText());
            pst.setString(3,tmp);
            pst.execute();
            pst.close();
            pst = conn.prepareStatement(sql6);
            pst.setString(1, orderid.getText());
            pst.setString(2, custName.getText());
            pst.setString(3,tmp);
            pst.execute();
            pst.close();
            pst = conn.prepareStatement(sql7);
            pst.setString(1, orderid.getText());
            pst.setString(2, salesLabel2.getText());
            pst.setString(3,tmp);
            pst.execute();
            pst.close();

           // UpdateJTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
    }
    }
      private void Amount2invoicenorm(){
    Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
Statement stmt =null;
    conn= mysqlconnect.ConnectDb();
  String sql = "insert into amountinvoice (orderid, amount,name) values (?,?,?)";
 String tmp = (String) nameCombo2.getSelectedItem();
  try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, orderid.getText());
           // pst.setString(1, priceLabel.getText());
            pst.setString(2, orderid.getText());
             pst.execute();   
}
       catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
 finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
                        }    
}
    private void Amount2(){
    Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
  String sql = "update invoice set amount = ROUND(quantity*price,2) where productname = ? and orderid = ?";
  String tmp = (String) nameCombo1.getSelectedItem();
  try {
            pst = conn.prepareStatement(sql);
            pst.setString(1,tmp);
            //pst.setString(1,priceLabel.getText());
         pst.setString(2, orderid3.getText());
             pst.execute();   
}
       catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
  finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
                        }    
}
    private void CreateTotals() {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = mysqlconnect.ConnectDb();
            stmt = conn.createStatement();
            stmt.executeUpdate(CREATE_TOTALS );
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
           DbUtils.closeQuietly(stmt);
    DbUtils.closeQuietly(conn);
        }
    }
     private void CreateTotals1() {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = mysqlconnect.ConnectDb();
            stmt = conn.createStatement();
            stmt.executeUpdate(CREATE_TOTALS1 );
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
           DbUtils.closeQuietly(stmt);
    DbUtils.closeQuietly(conn);
        }
    }
    private void Createinstock() {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = mysqlconnect.ConnectDb();
            stmt = conn.createStatement();
            stmt.executeUpdate(CREATE_INSTOCK);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
           DbUtils.closeQuietly(stmt);
    DbUtils.closeQuietly(conn);
        }
    }
    private void Createinstock1() {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = mysqlconnect.ConnectDb();
            stmt = conn.createStatement();
            stmt.executeUpdate(CREATE_INSTOCK1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
           DbUtils.closeQuietly(stmt);
    DbUtils.closeQuietly(conn);
        }
    }
   private void CustomerReplaceInvoice(){
         Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
    try{
       String tmp = (String) customerCombo.getSelectedItem();
        String sql = "select * from Till1";
        String sql2 = "update invoice set customername = (?) where orderid = (?)  ";
          pst = conn.prepareStatement(sql);
           rs = pst.executeQuery();
            if (rs.next());
             pst = conn.prepareStatement(sql2);
             pst.setString(1, tmp);
             pst.setString(2, orderid2.getText());
             pst.executeUpdate();
             
            
            
    }   catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e);
        }
 finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
        }
}
    private void CustomerReplaceInvoice1(){
         Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
    try{
       String tmp = (String) customerCombo1.getSelectedItem();
        String sql = "select * from Till1";
        String sql2 = "update invoice set customername = (?) where orderid = (?)  ";
          pst = conn.prepareStatement(sql);
           rs = pst.executeQuery();
            if (rs.next());
             pst = conn.prepareStatement(sql2);
             pst.setString(1, tmp);
             pst.setString(2, orderid3.getText());
             pst.executeUpdate();
             
            
            
    }   catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e);
        }
 finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
        }
}
   private void DropTotals() throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = mysqlconnect.ConnectDb();
            stmt = conn.createStatement();
            stmt.executeUpdate(DROP_TOTALS);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
           DbUtils.closeQuietly(stmt);
    DbUtils.closeQuietly(conn);
        }
    }
   private void DropTotals1() throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = mysqlconnect.ConnectDb();
            stmt = conn.createStatement();
            stmt.executeUpdate(DROP_TOTALS1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
           DbUtils.closeQuietly(stmt);
    DbUtils.closeQuietly(conn);
        }
    }
   private void Dropinstock() throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = mysqlconnect.ConnectDb();
            stmt = conn.createStatement();
            stmt.executeUpdate(DROP_INSTOCK);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
         finally{
           DbUtils.closeQuietly(stmt);
    DbUtils.closeQuietly(conn);
        }
    }   

 private void Dropinstock1() throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = mysqlconnect.ConnectDb();
            stmt = conn.createStatement();
            stmt.executeUpdate(DROP_INSTOCK1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
         finally{
           DbUtils.closeQuietly(stmt);
    DbUtils.closeQuietly(conn);
        }
    }      
   private void RetailShow(){
   Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null; 
conn = mysqlconnect.ConnectDb();
   try {
            String tmp = (String) nameCombo.getSelectedItem();
            String sql = "select ROUND(pricesell*20/100+pricesell,2) from product where name = ?";

            pst = conn.prepareStatement(sql);
            pst.setString(1, tmp);
            rs = pst.executeQuery();
            if (rs.next()) {
                String add1 = rs.getString("ROUND(pricesell*20/100+pricesell,2)");
                RetailLabel.setText(add1);
                
            }
        

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e); 
}
   finally{
       DbUtils.closeQuietly(rs);
           DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
        }
}   
   private void RetailShowinvoice(){
   Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null; 
conn = mysqlconnect.ConnectDb();
   try {
            String tmp = (String) nameCombo2.getSelectedItem();
            String sql = "select ROUND(pricesell*20/100+pricesell,2) from product where name = ?";

            pst = conn.prepareStatement(sql);
            pst.setString(1, tmp);
            rs = pst.executeQuery();
            if (rs.next()) {
                String add1 = rs.getString("ROUND(pricesell*20/100+pricesell,2)");
                RetailLabel2.setText(add1);
                
            }
        

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e); 
}
   finally{
       DbUtils.closeQuietly(rs);
           DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
        }
}  
   private void RetailShow1(){
   Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null; 
conn = mysqlconnect.ConnectDb();
   try {
            String tmp = (String) nameCombo1.getSelectedItem();
            String sql = "select ROUND(pricesell*20/100+pricesell,2) from product where name = ?";

            pst = conn.prepareStatement(sql);
            pst.setString(1, tmp);
            rs = pst.executeQuery();
            if (rs.next()) {
                String add1 = rs.getString("ROUND(pricesell*20/100+pricesell,2)");
                RetailLabel1.setText(add1);
                
            }
        

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e); 
}
   finally{
       DbUtils.closeQuietly(rs);
           DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
        }
}         
    private void SubtractStock(){
     Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
     String tmp = (String) nameCombo.getSelectedItem();
    try{
         String sql = "update product,instocktemp set product.instock = (product.instock-instocktemp.stock) where product.name = instocktemp.name";
         
            pst = conn.prepareStatement(sql);
             //pst.setString(1, tmp);
              //pst.setString(2, tmp);
            pst.executeUpdate();
            
        
         
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
    }
     finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
        }
}
     private void SubtractStock1(){
     Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
     String tmp = (String) nameCombo1.getSelectedItem();
    try{
         String sql = "update product,instocktemp set product.instock = (product.instock-instocktemp.stock) where product.name = instocktemp.name";
         
            pst = conn.prepareStatement(sql);
             //pst.setString(1, tmp);
              //pst.setString(2, tmp);
            pst.executeUpdate();
            
        
         
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
    }
     finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
        }
}
     private void SumTotal() {
         Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
        try {
            String sql = "select ROUND(sum(quantity*price),2) from Till1";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String sum = rs.getString("ROUND(sum(quantity*price),2)");
                //String strDouble = String.format("%.2f;",)
                sumtotal.setText(sum);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
    }
    }
     private void SumTotal1() {
         Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
        try {
            String sql = "select ROUND(sum(quantity*price),2) from Till2";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String sum = rs.getString("ROUND(sum(quantity*price),2)");
                //String strDouble = String.format("%.2f;",)
                sumtotal1.setText(sum);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
    }
    }
     private void UpdateAmount(){
         Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
         String tmp = (String) nameCombo.getSelectedItem();
    String sql = "update Till1 set amount = ROUND(quantity*price,2) where name = ?";
    try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, nameCode.getText());
           // pst.setString(1, priceLabel.getText());
             pst.execute();   
    }
       catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
                        } 
}
     private void UpdateAmount1(){
         Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
         String tmp = (String) nameCombo1.getSelectedItem();
    String sql = "update Till2 set amount = ROUND(quantity*price,2) where name = ?";
    try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, nameCode1.getText());
           // pst.setString(1, priceLabel.getText());
             pst.execute();   
    }
       catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
                        } 
}
     private void UpdateAmount2(){
    Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
  String sql = "update invoice set amount = ROUND(quantity*price,2) where productname = ? and orderid = ?";
  String tmp = (String) nameCombo.getSelectedItem();
  try {
            pst = conn.prepareStatement(sql);
            pst.setString(1,nameCode2.getText());
            //pst.setString(1,priceLabel.getText());
         pst.setString(2, orderid2.getText());
             pst.execute();   
}
       catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
  finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
                        }    
}
     private void UpdateInvoice(){
        Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
    String sql = "update invoice set quantity = ? where productname = ? and orderid = ?";
    try {
            pst = conn.prepareStatement(sql);
        //pst.setString(1, txtname.getText());
            
            pst.setString(1, quantityField.getText());
           // pst.setString(2, priceLabel.getText());
            pst.setString(2, nameCode.getText());
            pst.setString(3, orderid2.getText());
            pst.executeUpdate();
           // Amount();
            //insertInvoice();
            Amount2();   
            // JOptionPane.showMessageDialog(null, "Updated");
           // UpdateJTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
       // SumTotal();
finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
    }
    }
     private void UpdateInvoicenorm(){
        Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
    String sql = "update quantityinvoice set quantity = ? where name = ? and orderid = ?";
    try {
            pst = conn.prepareStatement(sql);
        //pst.setString(1, txtname.getText());
            
            pst.setString(1, quantityField2.getText());
           // pst.setString(2, priceLabel.getText());
            pst.setString(2, nameCode2.getText());
            pst.setString(3, orderid.getText());
            pst.executeUpdate();
           // Amount();
            //insertInvoice();
            Amount2();   
            // JOptionPane.showMessageDialog(null, "Updated");
           // UpdateJTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
       // SumTotal();
finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
    }
    }
      private void UpdateInvoice2(){
        Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
    String sql = "update invoice set quantity = ? where productname = ? and orderid = ?";
    try {
            pst = conn.prepareStatement(sql);
        //pst.setString(1, txtname.getText());
            
            pst.setString(1, quantityField2.getText());
           // pst.setString(2, priceLabel.getText());
            pst.setString(2, nameCode2.getText());
            pst.setString(3, orderid2.getText());
            pst.executeUpdate();
           // Amount();
            //insertInvoice();
            Amount2();   
            // JOptionPane.showMessageDialog(null, "Updated");
           // UpdateJTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
       // SumTotal();
finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
    }
    }
    private void CustomerReplace(){
     Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
    try{
       String tmp = (String) customerCombo.getSelectedItem();
        String sql = "select * from Till1";
        String sql2 = "update Till1 set customername = (?) where orderid = (?)  ";
          pst = conn.prepareStatement(sql);
           rs = pst.executeQuery();
            if (rs.next());
             pst = conn.prepareStatement(sql2);
            pst.setString(2, orderid2.getText());
            pst.setString(1, tmp);
             pst.setString(2, orderid2.getText());
             pst.executeUpdate();
             
            
            
    }   catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e);
        }
     finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
        }
}
    private void CustomerReplace1(){
     Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
    try{
       String tmp = (String) customerCombo1.getSelectedItem();
        String sql = "select * from Till2";
        String sql2 = "update Till2 set customername = (?) where orderid = (?)  ";
          pst = conn.prepareStatement(sql);
           rs = pst.executeQuery();
            if (rs.next());
             pst = conn.prepareStatement(sql2);
            pst.setString(2, orderid3.getText());
            pst.setString(1, tmp);
             pst.setString(2, orderid3.getText());
             pst.executeUpdate();
             
            
            
    }   catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e);
        }
     finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
        }
}
   private void checkinstock(){
    try{
     int result = Integer.parseInt(instocklabel.getText());
     int result1 = Integer.parseInt(instocklimit.getText());
        
         if(result < result1 ){
           JOptionPane.showMessageDialog(null, "THE DRUG STOCK LEVEL LOW"); 
         }
       } catch (Exception e) {
            return;
            
  
       
   }        
   }
    private void checkinstockinvoice(){
    try{
     int result = Integer.parseInt(instocklabel2.getText());
     int result1 = Integer.parseInt(instocklimit2.getText());
        
         if(result < result1 ){
           JOptionPane.showMessageDialog(null, "THE DRUG STOCK LEVEL LOW"); 
         }
       } catch (Exception e) {
            return;
            
  
       
   }        
}
   private void checkinstock1(){
    try{
     int result = Integer.parseInt(instocklabel1.getText());
     int result1 = Integer.parseInt(instocklimit1.getText());
        
         if(result < result1 ){
           JOptionPane.showMessageDialog(null, "THE DRUG STOCK LEVEL LOW"); 
         }
       } catch (Exception e) {
            return;
            
  
       
   }        

    
}
   private void deleteinvoice(){
     Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
     String sql = "delete from invoice where productname = ? and orderid = ?";
        // String tmp = (String)jComboBox1.getSelectedItem();
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, nameCode2.getText());
            pst.setString(2,orderid2.getText());
            pst.execute();
            //JOptionPane.showMessageDialog(null, "Deleted");
            UpdateJTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
}
}
     private void deleteinvoicenorm(){
     Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
     String sql = "delete from amountinvoice where name = ? and orderid = ?";
     String sq2 = "delete from ordersinvoice where name = ? and orderid = ?";
     String sq3 = "delete from productinvoice where name = ? and orderid = ?";
     String sq4 = "delete from quantityinvoice where name = ? and orderid = ?";
     String sq5 = "delete from priceinvoice where name = ? and orderid = ?";
     String sq6 = "delete from custinvoice where name = ? and orderid = ?";
     String sq7 = "delete from salesperson where name = ? and orderid = ?";
        // String tmp = (String)jComboBox1.getSelectedItem();
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, nameCode2.getText());
            pst.setString(2,orderid.getText());
            pst.execute();
            pst.close();
            pst = conn.prepareStatement(sq2);
            pst.setString(1, nameCode2.getText());
            pst.setString(2,orderid.getText());
            pst.execute();
            pst.close();
            pst = conn.prepareStatement(sq3);
            pst.setString(1, nameCode2.getText());
            pst.setString(2,orderid.getText());
            pst.execute();
            pst.close();
            pst = conn.prepareStatement(sq4);
            pst.setString(1, nameCode2.getText());
            pst.setString(2,orderid.getText());
            pst.execute();
            pst.close();
            pst = conn.prepareStatement(sq5);
            pst.setString(1, nameCode2.getText());
            pst.setString(2,orderid.getText());
            pst.execute();
            pst.close();
            pst = conn.prepareStatement(sq6);
            pst.setString(1, nameCode2.getText());
            pst.setString(2,orderid.getText());
            pst.execute();
            pst.close();
            pst = conn.prepareStatement(sq7);
            pst.setString(1, nameCode2.getText());
            pst.setString(2,orderid.getText());
            pst.execute();
            pst.close();
            
            //JOptionPane.showMessageDialog(null, "Deleted");
         //   UpdateJTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
}
}
   private void insertInvoice() {
         Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
        String sql = "insert into invoice (orderid, orderdate, productname, quantity, price, customername, salesuser,amount) select orderid,orderdate,name,quantity,price,customername,salesuser,amount from Till1";

        String tmp = (String) nameCombo.getSelectedItem();
        String tmp1 = (String) customerCombo.getSelectedItem();
        try {
            pst = conn.prepareStatement(sql);
       // pst.setString(1, tmp);

         /*   pst.setString(1, orderid.getText());
            pst.setTimestamp(2, getCurrentDate());
            pst.setString(3, tmp);
            pst.setString(4, quantityField.getText());
            pst.setString(5, priceLabel.getText());
          //  if (customerCombo.getSelectedItem().toString() ==""){
                // pst.setString (6, customer.getText());
           // }
           // else
            pst.setString(6, tmp1);
            pst.setString(7, salesLabel.getText());
             pst.setTimestamp(8, getCurrentDate());
            pst.setString(9, productid.getText());*/
            pst.execute();

           // UpdateJTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
    }
    }
   private void insertInvoice1() {
         Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
        String sql = "insert into invoice (orderid, orderdate, productname, quantity, price, customername, salesuser,amount) select orderid,orderdate,name,quantity,price,customername,salesuser,amount from Till1";

        String tmp = (String) nameCombo1.getSelectedItem();
        String tmp1 = (String) customerCombo1.getSelectedItem();
        try {
            pst = conn.prepareStatement(sql);
       // pst.setString(1, tmp);

         /*   pst.setString(1, orderid.getText());
            pst.setTimestamp(2, getCurrentDate());
            pst.setString(3, tmp);
            pst.setString(4, quantityField.getText());
            pst.setString(5, priceLabel.getText());
          //  if (customerCombo.getSelectedItem().toString() ==""){
                // pst.setString (6, customer.getText());
           // }
           // else
            pst.setString(6, tmp1);
            pst.setString(7, salesLabel.getText());
             pst.setTimestamp(8, getCurrentDate());
            pst.setString(9, productid.getText());*/
            pst.execute();

           // UpdateJTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
    }
    }
   private void invoiceinsert() {
  Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
        String sql = "insert into invoicenum (date) values(?)";
String sql2 = "select last_insert_id() as invoiceid from invoicenum ";
        // String tmp = (String)jComboBox1.getSelectedItem();
        try{
      if ((ordercheck.getText().trim().equals("1") )){
          return;
      }
       else   
          
           pst = conn.prepareStatement(sql);
       // pst.setString(1, tmp);

          pst.setTimestamp(1, getCurrentDate());
        //pst.setString(4, txtage.getText());
            // pst.setString(2,priceName.getText());
            //pst.setTimestamp(4, getCurrentDate());
            //pst.setString(4,dateLabel.getText());
           // pst.setString(2, PhoneField.getText());
            pst.execute();
        pst.close();
        pst = conn.prepareStatement(sql2);
        rs = pst.executeQuery();
        if (rs.next()) {
                String add = rs.getString("invoiceid");
                invoicecounter.setText(add);
                    
                }
      
       } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
         
   
  //updatecustomerCombo();
        //FillCombo2();
          
        }
         finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
}
   }
   private void invoiceinsert1() {
  Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
        String sql = "insert into invoicenum (date) values(?)";
String sql2 = "select last_insert_id() as invoiceid from invoicenum ";
        // String tmp = (String)jComboBox1.getSelectedItem();
        try{
      if ((ordercheck1.getText().trim().equals("1") )){
          return;
      }
       else   
          
           pst = conn.prepareStatement(sql);
       // pst.setString(1, tmp);

          pst.setTimestamp(1, getCurrentDate());
        //pst.setString(4, txtage.getText());
            // pst.setString(2,priceName.getText());
            //pst.setTimestamp(4, getCurrentDate());
            //pst.setString(4,dateLabel.getText());
           // pst.setString(2, PhoneField.getText());
            pst.execute();
        pst.close();
        pst = conn.prepareStatement(sql2);
        rs = pst.executeQuery();
        if (rs.next()) {
                String add = rs.getString("invoiceid");
                invoicecounter1.setText(add);
                    
                }
      
       } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
         
   
  //updatecustomerCombo();
        //FillCombo2();
          
        }
         finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
}
   }

   private void removeitems() throws SQLException{
    customerCombo.setSelectedItem("");
    //customerid.setText("");
    orderid2.setText("");
    nameCombo.setSelectedItem("");
    quantityField.setText("");
    sumtotal.setText("");
    priceLabel.setText("");
    boxLabel.setText("");
    typeLabel.setText("");
    nameCode.setText("");
    count.setText("");
    customer.setText("");
    RetailLabel.setText("");
    ordercheck.setText("");
    instocklabel.setText("");
    DropTable();
    Create();
    UpdateJTable();
}
    private void removeitems1() throws SQLException{
    customerCombo1.setSelectedItem("");
    //customerid.setText("");
    orderid3.setText("");
    nameCombo1.setSelectedItem("");
    quantityField1.setText("");
    sumtotal1.setText("");
    priceLabel1.setText("");
    boxLabel1.setText("");
    typeLabel1.setText("");
    nameCode1.setText("");
    count1.setText("");
    customer1.setText("");
    RetailLabel1.setText("");
    ordercheck1.setText("");
    instocklabel1.setText("");
    DropTable1();
    Create1();
    UpdateJTable1();
}
   private void retailclick(){
       Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null; 
conn = mysqlconnect.ConnectDb();
    try{
        int row = table.getSelectedRow();
        String click = (table.getModel().getValueAt(row, 0).toString());
    String sql = "select ROUND(pricesell*20/100+pricesell,2) from product where name = ?";
    //String sql1 = "select *from product where name = '"+click+"'"
        pst = conn.prepareStatement(sql);
        pst.setString(1, click);
        rs = pst.executeQuery();
        if (rs.next()) {
                String add1 = rs.getString("ROUND(pricesell*20/100+pricesell,2)");
                RetailLabel.setText(add1);
             /*  String add3 = rs.getString("description");
                typeLabel.setText(add3);
                 String add4 = rs.getString("inthebox");
                boxLabel.setText(add4);*/
            
        }
    
 }
    catch (Exception e){
        JOptionPane.showMessageDialog(null, e);
     
                                                  
    }                            
     finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
                        }    
 }
    private void retailclick2(){
       Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null; 
conn = mysqlconnect.ConnectDb();
    try{
        int row = table2.getSelectedRow();
        String click = (table2.getModel().getValueAt(row, 0).toString());
    String sql = "select ROUND(pricesell*20/100+pricesell,2) from product where name = ?";
    //String sql1 = "select *from product where name = '"+click+"'"
        pst = conn.prepareStatement(sql);
        pst.setString(1, click);
        rs = pst.executeQuery();
        if (rs.next()) {
                String add1 = rs.getString("ROUND(pricesell*20/100+pricesell,2)");
                RetailLabel2.setText(add1);
             /*  String add3 = rs.getString("description");
                typeLabel.setText(add3);
                 String add4 = rs.getString("inthebox");
                boxLabel.setText(add4);*/
            
        }
    
 }
    catch (Exception e){
        JOptionPane.showMessageDialog(null, e);
     
                                                  
    }                            
     finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
                        }    
 }
   private void retailclick1(){
       Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null; 
conn = mysqlconnect.ConnectDb();
    try{
        int row = table1.getSelectedRow();
        String click = (table1.getModel().getValueAt(row, 0).toString());
    String sql = "select ROUND(pricesell*20/100+pricesell,2) from product where name = ?";
    //String sql1 = "select *from product where name = '"+click+"'"
        pst = conn.prepareStatement(sql);
        pst.setString(1, click);
        rs = pst.executeQuery();
        if (rs.next()) {
                String add1 = rs.getString("ROUND(pricesell*20/100+pricesell,2)");
                RetailLabel1.setText(add1);
             /*  String add3 = rs.getString("description");
                typeLabel.setText(add3);
                 String add4 = rs.getString("inthebox");
                boxLabel.setText(add4);*/
            
        }
    
 }
    catch (Exception e){
        JOptionPane.showMessageDialog(null, e);
     
                                                  
    }                            
     finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
                        }    
 }
 private void salesUser() {
         Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
        try {
            // String tmp = (String)customerCombo.getSelectedItem();
            String sql = "select name from reader1";
            pst = conn.prepareStatement(sql);
            // pst.setString(1, salesLabel.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                String add = rs.getString("name");
                salesLabel.setText(add);
            //String add2 = rs.getString("name");
                // nameCode.setText(add2);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
    }
    }
 private void salesUser1() {
         Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
        try {
            // String tmp = (String)customerCombo.getSelectedItem();
            String sql = "select name from reader1";
            pst = conn.prepareStatement(sql);
            // pst.setString(1, salesLabel.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                String add = rs.getString("name");
                salesLabel1.setText(add);
            //String add2 = rs.getString("name");
                // nameCode.setText(add2);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
    }
    }
 private void salesUser2() {
         Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
        try {
            // String tmp = (String)customerCombo.getSelectedItem();
            String sql = "select name from reader1";
            pst = conn.prepareStatement(sql);
            // pst.setString(1, salesLabel.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                String add = rs.getString("name");
                salesLabel2.setText(add);
            //String add2 = rs.getString("name");
                // nameCode.setText(add2);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
    }
    }
  /*  private void invoicegen(){
     //InvoiceGenerator f = new InvoiceGenerator();
    try{
     if ((ordercheck.getText().trim().equals("1") )){
         
         // return;
      }else{
          String invoiceNumber = InvoiceGenerator.generateInvoiceNumber();
        orderid2.setText(invoiceNumber); 
     }
    } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
    }
    }*/
    /* private void invoicegen1(){
     //InvoiceGenerator f = new InvoiceGenerator();
    try{
     if ((ordercheck1.getText().trim().equals("1") )){
         
         // return;
      }else{
          String invoiceNumber = InvoiceGenerator.generateInvoiceNumber();
        orderid3.setText(invoiceNumber); 
     }
    } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
    }
    }*/
   private void orderinsert3() {
  Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
        String sql = "insert into orders (orderdate) values(?)";
String sql2 = "select last_insert_id() as orderid from orders ";
        // String tmp = (String)jComboBox1.getSelectedItem();
        try{
      if ((ordercheck.getText().trim().equals("1") )){
          return;
      }
       else   
          
           pst = conn.prepareStatement(sql);
       // pst.setString(1, tmp);

          pst.setTimestamp(1, getCurrentDate());
        //pst.setString(4, txtage.getText());
            // pst.setString(2,priceName.getText());
            //pst.setTimestamp(4, getCurrentDate());
            //pst.setString(4,dateLabel.getText());
           // pst.setString(2, PhoneField.getText());
            pst.execute();
        pst.close();
        pst = conn.prepareStatement(sql2);
        rs = pst.executeQuery();
        if (rs.next()) {
                String add = rs.getString("orderid");
                orderid2.setText(add);
                    
                }
      
       } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
         
   
  //updatecustomerCombo();
        //FillCombo2();
          
        }
         finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
}
   }
   private void orderinsert4() {
  Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
        String sql = "insert into orders (orderdate) values(?)";
String sql2 = "select last_insert_id() as orderid from orders ";
        // String tmp = (String)jComboBox1.getSelectedItem();
        try{
      if ((ordercheck1.getText().trim().equals("1") )){
          return;
      }
       else   
          
           pst = conn.prepareStatement(sql);
       // pst.setString(1, tmp);

          pst.setTimestamp(1, getCurrentDate());
        //pst.setString(4, txtage.getText());
            // pst.setString(2,priceName.getText());
            //pst.setTimestamp(4, getCurrentDate());
            //pst.setString(4,dateLabel.getText());
           // pst.setString(2, PhoneField.getText());
            pst.execute();
        pst.close();
        pst = conn.prepareStatement(sql2);
        rs = pst.executeQuery();
        if (rs.next()) {
                String add = rs.getString("orderid");
                orderid3.setText(add);
                    
                }
      
       } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
         
   
  //updatecustomerCombo();
        //FillCombo2();
          
        }
         finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
}
   }
    private void customerInput() {
         Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
        String sql = "insert into customer (name) values(?)";

        // String tmp = (String)jComboBox1.getSelectedItem();
        try {
            pst = conn.prepareStatement(sql);
       // pst.setString(1, tmp);

            pst.setString(1, customer.getText());
        //pst.setString(4, txtage.getText());
            // pst.setString(2,priceName.getText());
            //pst.setTimestamp(4, getCurrentDate());
            //pst.setString(4,dateLabel.getText());
           // pst.setString(2, PhoneField.getText());
            pst.execute();
            // UpdateJTable();
        }  catch (SQLException e) {
                if (e.getSQLState().startsWith("23")) {
                         // JOptionPane.showMessageDialog(null, "Duplicate");
          JOptionPane.showMessageDialog(null, "Customer Already Exists Please Use Customer Combo");
            //JOptionPane.showMessageDialog(null, e);
            customer.setText("");
        }
  //updatecustomerCombo();
        //FillCombo2();
        }
         finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
}
        
    }
     private void customerInput1() {
         Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
        String sql = "insert into customer (name) values(?)";

        // String tmp = (String)jComboBox1.getSelectedItem();
        try {
            pst = conn.prepareStatement(sql);
       // pst.setString(1, tmp);

            pst.setString(1, customer1.getText());
        //pst.setString(4, txtage.getText());
            // pst.setString(2,priceName.getText());
            //pst.setTimestamp(4, getCurrentDate());
            //pst.setString(4,dateLabel.getText());
           // pst.setString(2, PhoneField.getText());
            pst.execute();
            // UpdateJTable();
        }  catch (SQLException e) {
                if (e.getSQLState().startsWith("23")) {
                         // JOptionPane.showMessageDialog(null, "Duplicate");
          JOptionPane.showMessageDialog(null, "Customer Already Exists Please Use Customer Combo");
            //JOptionPane.showMessageDialog(null, e);
            customer1.setText("");
        }
  //updatecustomerCombo();
        //FillCombo2();
        }
         finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
}
     }
    private void FillCombo() {
        Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
        try {
            String sql = "select distinct name from product order by name asc";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            nameCombo.removeAllItems();
            while (rs.next()) {
                String name = rs.getString("name");
                
                nameCombo.addItem(name);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
        DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
    }
    private void FillComboinvoice() {
        Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
        try {
            String sql = "select distinct name from product order by name asc";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                nameCombo2.addItem(name);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
        DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
    }
    private void FillCombo1() {
        Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
        try {
            String sql = "select distinct name from product order by name asc";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            nameCombo1.removeAllItems();
            while (rs.next()) {
                String name = rs.getString("name");
                
                nameCombo1.addItem(name);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
        DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
    }
    private void FillCombo2() {
        Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
        try {
            String sql = "select distinct name from product order by name asc";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                nameCombo2.addItem(name);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
        DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
    }
    private void FillCombocust() {
        Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
        try {
            String sql = "select name from customer order by name asc";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            customerCombo.removeAllItems();
            while (rs.next()) {
                String name = rs.getString("name");

                //customerCombo.removeItem(name);
                //customerCombo.setSelectedIndex(-1);
                //customerCombo.setSelectedItem(name);
                //if (customerCombo.getSelectedItem()>-1);{
                customerCombo.addItem(name);
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
        finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
        }
    }
    private void FillCombocust1() {
        Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
        try {
            String sql = "select name from customer order by name asc";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            customerCombo1.removeAllItems();
            while (rs.next()) {
                String name = rs.getString("name");

                //customerCombo.removeItem(name);
                //customerCombo.setSelectedIndex(-1);
                //customerCombo.setSelectedItem(name);
                //if (customerCombo.getSelectedItem()>-1);{
                customerCombo1.addItem(name);
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
        finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
        }
    }
    private void FillCombocustinvoice() {
        Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
        try {
            String sql = "select name from customer order by name asc";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            custCombo.removeAllItems();
            while (rs.next()) {
                String name = rs.getString("name");

                //customerCombo.removeItem(name);
                //customerCombo.setSelectedIndex(-1);
                //customerCombo.setSelectedItem(name);
                //if (customerCombo.getSelectedItem()>-1);{
                custCombo.addItem(name);
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
        finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
        }
    }
   private void SumTotal3() {
         Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
        try {
            String sql = "select ROUND(sum(amount),2) from Till1";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String sum = rs.getString("ROUND(sum(amount),2)");
                //String strDouble = String.format("%.2f;",)
                sumtotal.setText(sum);
              /*   String text1="*****Total******";                              // 20 characters
    String text2="     "+sum+"     ";                              //20 characters
    PrintFirstLine("  "+text1+"  ");
    PrintSecondLine(" "+text2+" ");*/
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
    }
    }   
    private void SumTotal4() {
         Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
        try {
            String sql = "select ROUND(sum(amount),2) from Till2";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String sum = rs.getString("ROUND(sum(amount),2)");
                //String strDouble = String.format("%.2f;",)
                sumtotal1.setText(sum);
               /*  String text1="*****Total******";                              // 20 characters
    String text2="     "+sum+"     ";                              //20 characters
    PrintFirstLine("  "+text1+"  ");
    PrintSecondLine(" "+text2+" ");*/
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
    }
    }   
    private void SumTotal3invoice() {
         Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
        try {
            String sql = "select ROUND(sum(amount),2) from invoicesales";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String sum = rs.getString("ROUND(sum(amount),2)");
                //String strDouble = String.format("%.2f;",)
                sumtotal2.setText(sum);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
    }
    }   
    private void Totals(){
    Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();

    String tmp = (String) customerCombo.getSelectedItem();
    String sql = "insert into totals1 (orderid, total,customername,salesuser,orderdate) values(?,?,?,?,?)";
    try{
     pst = conn.prepareStatement(sql);
            pst.setString(2, sumtotal.getText());
            pst.setString(1,orderid2.getText());
           // if (customerCombo.getSelectedItem().toString() ==""){
                // pst.setString (3, customer.getText());
            //}
           // else
            pst.setString(3,tmp);
    
            pst.setString(4,salesLabel.getText());
            pst.setTimestamp(5, getCurrentDate());
            pst.executeUpdate();


} catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
}
    finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
}
}
    private void Totals1(){
    Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();

    String tmp = (String) customerCombo1.getSelectedItem();
    String sql = "insert into totals11 (orderid, total,customername,salesuser,orderdate) values(?,?,?,?,?)";
    try{
     pst = conn.prepareStatement(sql);
            pst.setString(2, sumtotal1.getText());
            pst.setString(1,orderid3.getText());
           // if (customerCombo.getSelectedItem().toString() ==""){
                // pst.setString (3, customer.getText());
            //}
           // else
            pst.setString(3,tmp);
    
            pst.setString(4,salesLabel1.getText());
            pst.setTimestamp(5, getCurrentDate());
            pst.executeUpdate();


} catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
}
    finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
}
}
    private void Totals2(){
    Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();

//    String tmp = (String) customerCombo2.getSelectedItem();
    String sql = "insert into totals111 (orderid, total,customername,salesuser,orderdate) values(?,?,?,?,?)";
    try{
     pst = conn.prepareStatement(sql);
            pst.setString(2, sumtotal2.getText());
            pst.setString(1,orderid.getText());
           // if (customerCombo.getSelectedItem().toString() ==""){
                // pst.setString (3, customer.getText());
            //}
           // else
            pst.setString(3,custName.getText());
    
            pst.setString(4,salesLabel2.getText());
            pst.setTimestamp(5, getCurrentDate());
            pst.executeUpdate();


} catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
}
    finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
}
}
    private static java.sql.Timestamp getCurrentDate() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Timestamp(today.getTime());

    }
    private void UpdateJTable() {
    Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
        String sql = "select  name, quantity, price, amount  from Till1";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            table.setModel(new salestablemodelold(rs));
            setJTableColumnsWidth(table, 480, 65, 15, 10, 15);
            //table1.setColumnModel(null);
            table.setRowHeight(30);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        DbUtils.closeQuietly(rs);
           DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
    }
    private void UpdateJTable1() {
    Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
        String sql = "select  name, quantity, price, amount  from Till2";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            table1.setModel(new salestablemodelold(rs));
            setJTableColumnsWidth(table1, 480, 65, 15, 10, 15);
            //table1.setColumnModel(null);
            table1.setRowHeight(30);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        DbUtils.closeQuietly(rs);
           DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        clearbutt2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        errormsg = new javax.swing.JLabel();
        error = new javax.swing.JLabel();
        errorclose = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        main = new javax.swing.JPanel();
        tillone = new javax.swing.JPanel();
        nameCombo = new javax.swing.JComboBox<>();
        customer = new javax.swing.JTextField();
        priceLabel = new javax.swing.JLabel();
        instocklabel = new javax.swing.JLabel();
        typeLabel = new javax.swing.JLabel();
        boxLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        sumtotal = new javax.swing.JLabel();
        customerCombo = new javax.swing.JComboBox<>();
        quantityField = new javax.swing.JTextField();
        printbutt = new javax.swing.JLabel();
        savebutton = new javax.swing.JLabel();
        updatebutt = new javax.swing.JLabel();
        clearbutt = new javax.swing.JLabel();
        deletebutt = new javax.swing.JLabel();
        mouseDrag = new javax.swing.JLabel();
        header = new javax.swing.JLabel();
        salesLabel = new javax.swing.JLabel();
        salesicon = new javax.swing.JLabel();
        count = new javax.swing.JLabel();
        RetailLabel = new javax.swing.JLabel();
        invoicepanelview = new javax.swing.JLabel();
        tilltwopanelview = new javax.swing.JLabel();
        tillonepanelview = new javax.swing.JLabel();
        tilltwoclick = new javax.swing.JLabel();
        invoiceclick = new javax.swing.JLabel();
        tilloneclick = new javax.swing.JLabel();
        settingspanelview = new javax.swing.JLabel();
        userpanelview = new javax.swing.JLabel();
        printpanelview = new javax.swing.JLabel();
        refreshpanelview = new javax.swing.JLabel();
        refreshclick = new javax.swing.JLabel();
        savepanel = new javax.swing.JLabel();
        updatepanel = new javax.swing.JLabel();
        clearpanel = new javax.swing.JLabel();
        deletepanel = new javax.swing.JLabel();
        refreshbutt = new javax.swing.JLabel();
        productbutt = new javax.swing.JLabel();
        printerbutt = new javax.swing.JLabel();
        exitbutt = new javax.swing.JLabel();
        changepass = new javax.swing.JLabel();
        createuser = new javax.swing.JLabel();
        productspanel = new javax.swing.JLabel();
        printpanel = new javax.swing.JLabel();
        exitpanel = new javax.swing.JLabel();
        Useron = new javax.swing.JLabel();
        Useroff = new javax.swing.JLabel();
        settingson = new javax.swing.JLabel();
        settingsoff = new javax.swing.JLabel();
        settings = new javax.swing.JLabel();
        oldinvoice1 = new javax.swing.JLabel();
        editlabel = new javax.swing.JTextField();
        editbutt = new javax.swing.JLabel();
        percentage4 = new javax.swing.JComboBox<>();
        check = new javax.swing.JCheckBox();
        disnote = new javax.swing.JLabel();
        gui = new javax.swing.JLabel();
        orderid2 = new javax.swing.JLabel();
        nameCode = new javax.swing.JLabel();
        display = new javax.swing.JLabel();
        pricefortable = new javax.swing.JLabel();
        customerindicator = new javax.swing.JLabel();
        customerid = new javax.swing.JLabel();
        ordercheck = new javax.swing.JLabel();
        instocklimit = new javax.swing.JLabel();
        invoicecounter = new javax.swing.JLabel();
        percentage = new javax.swing.JComboBox<>();
        percenlabel = new javax.swing.JLabel();
        invoicerecord = new javax.swing.JLabel();
        tilltwo = new javax.swing.JPanel();
        nameCombo1 = new javax.swing.JComboBox<>();
        customer1 = new javax.swing.JTextField();
        priceLabel1 = new javax.swing.JLabel();
        instocklabel1 = new javax.swing.JLabel();
        typeLabel1 = new javax.swing.JLabel();
        boxLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        sumtotal1 = new javax.swing.JLabel();
        customerCombo1 = new javax.swing.JComboBox<>();
        quantityField1 = new javax.swing.JTextField();
        printbutt1 = new javax.swing.JLabel();
        savebutton1 = new javax.swing.JLabel();
        updatebutt1 = new javax.swing.JLabel();
        clearbutt1 = new javax.swing.JLabel();
        deletebutt1 = new javax.swing.JLabel();
        header1 = new javax.swing.JLabel();
        salesLabel1 = new javax.swing.JLabel();
        salesicon1 = new javax.swing.JLabel();
        count1 = new javax.swing.JLabel();
        RetailLabel1 = new javax.swing.JLabel();
        invoicepanelview1 = new javax.swing.JLabel();
        tilltwopanelview1 = new javax.swing.JLabel();
        tillonepanelview1 = new javax.swing.JLabel();
        tilltwoclick1 = new javax.swing.JLabel();
        invoiceclick1 = new javax.swing.JLabel();
        tilloneclick1 = new javax.swing.JLabel();
        settingspanelview1 = new javax.swing.JLabel();
        userpanelview1 = new javax.swing.JLabel();
        userclick1 = new javax.swing.JLabel();
        printpanelview1 = new javax.swing.JLabel();
        refreshpanelview1 = new javax.swing.JLabel();
        refreshclick1 = new javax.swing.JLabel();
        savepanel1 = new javax.swing.JLabel();
        updatepanel1 = new javax.swing.JLabel();
        clearpanel1 = new javax.swing.JLabel();
        deletepanel1 = new javax.swing.JLabel();
        refreshbutt1 = new javax.swing.JLabel();
        productbutt1 = new javax.swing.JLabel();
        productspanel1 = new javax.swing.JLabel();
        printpanel1 = new javax.swing.JLabel();
        exitpanel1 = new javax.swing.JLabel();
        exitbutt1 = new javax.swing.JLabel();
        printerbutt1 = new javax.swing.JLabel();
        settings1 = new javax.swing.JLabel();
        settingsoff1 = new javax.swing.JLabel();
        settingson1 = new javax.swing.JLabel();
        oldinvoice = new javax.swing.JLabel();
        editbutt1 = new javax.swing.JLabel();
        editlabel1 = new javax.swing.JTextField();
        percentage5 = new javax.swing.JComboBox<>();
        check1 = new javax.swing.JCheckBox();
        disnote1 = new javax.swing.JLabel();
        gui1 = new javax.swing.JLabel();
        orderid3 = new javax.swing.JLabel();
        display1 = new javax.swing.JLabel();
        ordercheck1 = new javax.swing.JLabel();
        nameCode1 = new javax.swing.JLabel();
        instocklimit1 = new javax.swing.JLabel();
        invoicecounter1 = new javax.swing.JLabel();
        percentage1 = new javax.swing.JComboBox<>();
        percenlabel1 = new javax.swing.JLabel();
        invoicerecord1 = new javax.swing.JLabel();
        customerid1 = new javax.swing.JLabel();
        customerindicator1 = new javax.swing.JLabel();
        pricefortable1 = new javax.swing.JLabel();
        invoice = new javax.swing.JPanel();
        nameCombo2 = new javax.swing.JComboBox<>();
        priceLabel2 = new javax.swing.JLabel();
        instocklabel2 = new javax.swing.JLabel();
        typeLabel2 = new javax.swing.JLabel();
        boxLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        sumtotal2 = new javax.swing.JLabel();
        quantityField2 = new javax.swing.JTextField();
        printbutt2 = new javax.swing.JLabel();
        savebutton2 = new javax.swing.JLabel();
        updatebutt2 = new javax.swing.JLabel();
        deletebutt2 = new javax.swing.JLabel();
        header2 = new javax.swing.JLabel();
        salesLabel2 = new javax.swing.JLabel();
        salesicon2 = new javax.swing.JLabel();
        count2 = new javax.swing.JLabel();
        RetailLabel2 = new javax.swing.JLabel();
        invoicepanelview2 = new javax.swing.JLabel();
        tilltwopanelview2 = new javax.swing.JLabel();
        tillonepanelview2 = new javax.swing.JLabel();
        tilltwoclick2 = new javax.swing.JLabel();
        invoiceclick2 = new javax.swing.JLabel();
        tilloneclick2 = new javax.swing.JLabel();
        settingspanelview2 = new javax.swing.JLabel();
        userpanelview2 = new javax.swing.JLabel();
        userclick2 = new javax.swing.JLabel();
        printpanelview2 = new javax.swing.JLabel();
        refreshpanelview2 = new javax.swing.JLabel();
        refreshclick2 = new javax.swing.JLabel();
        savepanel2 = new javax.swing.JLabel();
        updatepanel2 = new javax.swing.JLabel();
        clearpanel2 = new javax.swing.JLabel();
        deletepanel2 = new javax.swing.JLabel();
        custName = new javax.swing.JLabel();
        custCombo = new javax.swing.JComboBox<>();
        orderid = new javax.swing.JLabel();
        editButton = new javax.swing.JLabel();
        editpanel = new javax.swing.JLabel();
        refreshbutt2 = new javax.swing.JLabel();
        orderField = new javax.swing.JTextField();
        exitpanel2 = new javax.swing.JLabel();
        printpanel2 = new javax.swing.JLabel();
        productspanel2 = new javax.swing.JLabel();
        settingsoff2 = new javax.swing.JLabel();
        settingson2 = new javax.swing.JLabel();
        exitbutt2 = new javax.swing.JLabel();
        printerbutt2 = new javax.swing.JLabel();
        productbutt2 = new javax.swing.JLabel();
        settings2 = new javax.swing.JLabel();
        invoicepercentage = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        gui2 = new javax.swing.JLabel();
        percentage2 = new javax.swing.JComboBox<>();
        customer2 = new javax.swing.JTextField();
        pricefortable2 = new javax.swing.JLabel();
        orderid4 = new javax.swing.JLabel();
        ordercheck2 = new javax.swing.JLabel();
        nameCode2 = new javax.swing.JLabel();
        instocklimit2 = new javax.swing.JLabel();
        invoicecounter2 = new javax.swing.JLabel();
        percenlabel2 = new javax.swing.JLabel();
        invoicerecord2 = new javax.swing.JLabel();
        product = new javax.swing.JPanel();
        sumtotal3 = new javax.swing.JLabel();
        savebutton3 = new javax.swing.JLabel();
        updatebutt3 = new javax.swing.JLabel();
        clearbutt3 = new javax.swing.JLabel();
        deletebutt3 = new javax.swing.JLabel();
        mouseDrag1 = new javax.swing.JLabel();
        header3 = new javax.swing.JLabel();
        salesLabel3 = new javax.swing.JLabel();
        salesicon3 = new javax.swing.JLabel();
        invoicepanelview3 = new javax.swing.JLabel();
        tilltwopanelview3 = new javax.swing.JLabel();
        tillonepanelview3 = new javax.swing.JLabel();
        tilltwoclick3 = new javax.swing.JLabel();
        invoiceclick3 = new javax.swing.JLabel();
        tilloneclick3 = new javax.swing.JLabel();
        settingspanelview3 = new javax.swing.JLabel();
        userpanelview3 = new javax.swing.JLabel();
        userclick3 = new javax.swing.JLabel();
        savepanel3 = new javax.swing.JLabel();
        updatepanel3 = new javax.swing.JLabel();
        clearpanel3 = new javax.swing.JLabel();
        deletepanel3 = new javax.swing.JLabel();
        refreshbutt3 = new javax.swing.JLabel();
        productbutt3 = new javax.swing.JLabel();
        printerbutt3 = new javax.swing.JLabel();
        exitbutt3 = new javax.swing.JLabel();
        productspanel3 = new javax.swing.JLabel();
        printpanel3 = new javax.swing.JLabel();
        exitpanel3 = new javax.swing.JLabel();
        settingson3 = new javax.swing.JLabel();
        settingsoff3 = new javax.swing.JLabel();
        settings3 = new javax.swing.JLabel();
        namefield = new javax.swing.JTextField();
        description = new javax.swing.JTextField();
        piecesinbox = new javax.swing.JTextField();
        buyingprice = new javax.swing.JTextField();
        category = new javax.swing.JComboBox<>();
        sellingprice = new javax.swing.JTextField();
        stock = new javax.swing.JTextField();
        namesearch = new javax.swing.JTextField();
        list = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        gui3 = new javax.swing.JLabel();
        customerindicator2 = new javax.swing.JLabel();
        customerid2 = new javax.swing.JLabel();
        orderid5 = new javax.swing.JLabel();
        ordercheck3 = new javax.swing.JLabel();
        instocklimit3 = new javax.swing.JLabel();
        invoicecounter3 = new javax.swing.JLabel();
        percentage3 = new javax.swing.JComboBox<>();
        percenlabel3 = new javax.swing.JLabel();
        invoicerecord3 = new javax.swing.JLabel();
        productlogin = new javax.swing.JPanel();
        ok = new javax.swing.JLabel();
        success = new javax.swing.JLabel();
        gif = new javax.swing.JLabel();
        error1 = new javax.swing.JLabel();
        playbutton = new javax.swing.JLabel();
        exit = new javax.swing.JLabel();
        errormsg1 = new javax.swing.JLabel();
        error4 = new javax.swing.JLabel();
        errorclose1 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        gui4 = new javax.swing.JLabel();
        ChangePass = new javax.swing.JPanel();
        ok1 = new javax.swing.JLabel();
        success1 = new javax.swing.JLabel();
        gif1 = new javax.swing.JLabel();
        error2 = new javax.swing.JLabel();
        newpass = new javax.swing.JPasswordField();
        oldpass = new javax.swing.JPasswordField();
        eyeoneon = new javax.swing.JLabel();
        savebutt = new javax.swing.JLabel();
        backbutt = new javax.swing.JLabel();
        eyeoneoff = new javax.swing.JLabel();
        eyetwoon = new javax.swing.JLabel();
        eyetwooff = new javax.swing.JLabel();
        gui5 = new javax.swing.JLabel();
        namelabel = new javax.swing.JLabel();
        Createuser = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        newpass1 = new javax.swing.JPasswordField();
        savebutt1 = new javax.swing.JLabel();
        backbutt1 = new javax.swing.JLabel();
        eyetwoon1 = new javax.swing.JLabel();
        eyetwooff1 = new javax.swing.JLabel();
        gui6 = new javax.swing.JLabel();
        ok2 = new javax.swing.JLabel();
        success2 = new javax.swing.JLabel();
        gif2 = new javax.swing.JLabel();
        error3 = new javax.swing.JLabel();
        namelabel1 = new javax.swing.JLabel();

        clearbutt2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                clearbutt2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                clearbutt2MouseExited(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setOpacity(0.0F);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel1MouseDragged(evt);
            }
        });
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 30));

        errormsg.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        errormsg.setForeground(new java.awt.Color(153, 153, 153));
        errormsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(errormsg, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 430, 260, 30));

        error.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/error1.png"))); // NOI18N
        getContentPane().add(error, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 290, -1, -1));

        errorclose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                errorcloseMousePressed(evt);
            }
        });
        getContentPane().add(errorclose, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 470, 70, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_minus_32px.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
        });
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 0, -1, -1));

        main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tillone.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nameCombo.setEditable(true);
        nameCombo.setFont(new java.awt.Font("Open Sans", 0, 16)); // NOI18N
        for (int i = 0; i < nameCombo.getComponentCount(); i++)
        {
            if (nameCombo.getComponent(i) instanceof JComponent) {
                ((JComponent) nameCombo.getComponent(i)).setBorder(new EmptyBorder(0, 0,0,0));
            }

            if (nameCombo.getComponent(i) instanceof AbstractButton) {
                ((AbstractButton) nameCombo.getComponent(i)).setBorderPainted(false);
            }
        }
        nameCombo.setOpaque(false);
        nameCombo.setPreferredSize(new java.awt.Dimension(50, 22));
        nameCombo.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                nameComboPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        tillone.add(nameCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(885, 75, 350, 30));
        ((JComponent) nameCombo.getEditor().getEditorComponent()).setBorder(null);
        apexlink.AutoCompletionold.enable(nameCombo);

        customer.setFont(new java.awt.Font("Open Sans", 0, 16)); // NOI18N
        customer.setBorder(null);
        customer.setOpaque(false);
        customer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                customerKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                customerKeyPressed(evt);
            }
        });
        tillone.add(customer, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 250, 30));

        priceLabel.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        priceLabel.setForeground(new java.awt.Color(0, 102, 255));
        priceLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tillone.add(priceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, 100, 30));

        instocklabel.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        instocklabel.setForeground(new java.awt.Color(0, 102, 255));
        instocklabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tillone.add(instocklabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, 110, 30));

        typeLabel.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        typeLabel.setForeground(new java.awt.Color(0, 102, 255));
        typeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tillone.add(typeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 370, 110, 30));

        boxLabel.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        boxLabel.setForeground(new java.awt.Color(0, 102, 255));
        boxLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tillone.add(boxLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 430, 120, 30));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setOpaque(false);

        table.setFont(new java.awt.Font("Open Sans", 0, 16)); // NOI18N
        table.setModel(new apexlink.salestablemodelold(rs));
        table.setGridColor(new java.awt.Color(255, 255, 255));
        table.setOpaque(false);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        tillone.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 250, 680, 300));

        sumtotal.setFont(new java.awt.Font("Calibri", 0, 48)); // NOI18N
        sumtotal.setForeground(new java.awt.Color(0, 102, 204));
        tillone.add(sumtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 600, 300, 60));

        customerCombo.setEditable(true);
        customerCombo.setFont(new java.awt.Font("Open Sans", 0, 16)); // NOI18N
        customerCombo.setOpaque(false);
        customerCombo.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                customerComboPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        tillone.add(customerCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 75, 295, 30));
        ((JComponent) customerCombo.getEditor().getEditorComponent()).setBorder(null);
        apexlink.AutoCompletionold.enable(customerCombo);

        quantityField.setFont(new java.awt.Font("Open Sans", 0, 16)); // NOI18N
        quantityField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        quantityField.setBorder(null);
        quantityField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quantityFieldMouseClicked(evt);
            }
        });
        quantityField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                quantityFieldKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                quantityFieldKeyTyped(evt);
            }
        });
        tillone.add(quantityField, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 130, 100, 40));

        printbutt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                printbuttMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                printbuttMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                printbuttMousePressed(evt);
            }
        });
        tillone.add(printbutt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 130, 70, 50));

        savebutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                savebuttonMousePressed(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                savebuttonMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                savebuttonMouseEntered(evt);
            }
        });
        tillone.add(savebutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 590, 70, 70));

        updatebutt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                updatebuttMousePressed(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                updatebuttMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                updatebuttMouseEntered(evt);
            }
        });
        tillone.add(updatebutt, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 590, 70, 70));

        clearbutt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                clearbuttMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                clearbuttMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                clearbuttMousePressed(evt);
            }
        });
        tillone.add(clearbutt, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 600, 70, 50));

        deletebutt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                deletebuttMousePressed(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deletebuttMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deletebuttMouseEntered(evt);
            }
        });
        tillone.add(deletebutt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 600, 70, 50));

        mouseDrag.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                mouseDragMouseDragged(evt);
            }
        });
        mouseDrag.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mouseDragMousePressed(evt);
            }
        });
        tillone.add(mouseDrag, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 820, 30));

        header.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        header.setForeground(new java.awt.Color(255, 255, 255));
        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMousePressed(evt);
            }
        });
        tillone.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 110, 30));

        salesLabel.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        salesLabel.setForeground(new java.awt.Color(0, 102, 204));
        tillone.add(salesLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 520, 160, 30));

        salesicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_user_50px.png"))); // NOI18N
        tillone.add(salesicon, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 510, -1, -1));

        count.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        count.setForeground(new java.awt.Color(0, 102, 204));
        count.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        count.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Counter", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 13), new java.awt.Color(0, 102, 204))); // NOI18N
        tillone.add(count, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 600, 80, 70));

        RetailLabel.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        RetailLabel.setForeground(new java.awt.Color(0, 102, 255));
        RetailLabel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 204), 2), "Retail Price", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 12), new java.awt.Color(0, 102, 204))); // NOI18N
        RetailLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                RetailLabelMousePressed(evt);
            }
        });
        tillone.add(RetailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 360, 90, 100));

        invoicepanelview.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Invoicepanel.png"))); // NOI18N
        tillone.add(invoicepanelview, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 230, 70));

        tilltwopanelview.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Invoicepanel.png"))); // NOI18N
        tillone.add(tilltwopanelview, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 230, 70));

        tillonepanelview.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Invoicepanel.png"))); // NOI18N
        tillone.add(tillonepanelview, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 230, 70));

        tilltwoclick.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tilltwoclickMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tilltwoclickMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tilltwoclickMousePressed(evt);
            }
        });
        tillone.add(tilltwoclick, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 210, 50));

        invoiceclick.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                invoiceclickMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                invoiceclickMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                invoiceclickMousePressed(evt);
            }
        });
        tillone.add(invoiceclick, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 210, 50));

        tilloneclick.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tilloneclickMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tilloneclickMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tilloneclickMousePressed(evt);
            }
        });
        tillone.add(tilloneclick, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 210, 60));

        settingspanelview.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/settingspanel.png"))); // NOI18N
        tillone.add(settingspanelview, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 590, 70, 80));

        userpanelview.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/settingspanel.png"))); // NOI18N
        tillone.add(userpanelview, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 590, 70, 80));

        printpanelview.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/settingspanel.png"))); // NOI18N
        tillone.add(printpanelview, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 120, 70, 70));

        refreshpanelview.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/settingspanel.png"))); // NOI18N
        refreshpanelview.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                refreshpanelviewMousePressed(evt);
            }
        });
        tillone.add(refreshpanelview, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 120, 70, 70));

        refreshclick.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                refreshclickMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                refreshclickMouseExited(evt);
            }
        });
        tillone.add(refreshclick, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 130, 60, 50));

        savepanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/savepanel.png"))); // NOI18N
        savepanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                savepanelMouseEntered(evt);
            }
        });
        tillone.add(savepanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 580, 70, 90));

        updatepanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/savepanel.png"))); // NOI18N
        tillone.add(updatepanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 580, 70, 90));

        clearpanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/savepanel.png"))); // NOI18N
        tillone.add(clearpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 580, 70, 90));

        deletepanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/savepanel.png"))); // NOI18N
        tillone.add(deletepanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 580, 70, 90));

        refreshbutt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                refreshbuttMousePressed(evt);
            }
        });
        tillone.add(refreshbutt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 130, 50, 50));

        productbutt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                productbuttMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                productbuttMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                productbuttMousePressed(evt);
            }
        });
        tillone.add(productbutt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 160, 40));

        printerbutt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                printerbuttMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                printerbuttMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                printerbuttMousePressed(evt);
            }
        });
        tillone.add(printerbutt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, 160, 40));

        exitbutt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitbuttMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitbuttMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exitbuttMousePressed(evt);
            }
        });
        tillone.add(exitbutt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 530, 160, 40));

        changepass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                changepassMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                changepassMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                changepassMousePressed(evt);
            }
        });
        tillone.add(changepass, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 180, 40));

        createuser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                createuserMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                createuserMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                createuserMousePressed(evt);
            }
        });
        tillone.add(createuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 180, 40));

        productspanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/productspanel.png"))); // NOI18N
        tillone.add(productspanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 180, 50));

        printpanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/productspanel.png"))); // NOI18N
        tillone.add(printpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, 180, 50));

        exitpanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/productspanel.png"))); // NOI18N
        tillone.add(exitpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, 180, 55));

        Useron.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                UseronMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                UseronMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                UseronMousePressed(evt);
            }
        });
        tillone.add(Useron, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 600, 50, 60));

        Useroff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                UseroffMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                UseroffMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                UseroffMousePressed(evt);
            }
        });
        tillone.add(Useroff, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 600, 50, 60));

        settingson.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                settingsonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                settingsonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                settingsonMousePressed(evt);
            }
        });
        tillone.add(settingson, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 600, 50, 60));

        settingsoff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                settingsoffMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                settingsoffMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                settingsoffMousePressed(evt);
            }
        });
        tillone.add(settingsoff, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 596, 70, 70));

        settings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/User group.png"))); // NOI18N
        settings.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                settingsFocusLost(evt);
            }
        });
        tillone.add(settings, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 395, 230, -1));

        oldinvoice1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_edit_property_48px_1.png"))); // NOI18N
        oldinvoice1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Old Invoice", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 102, 255))); // NOI18N
        oldinvoice1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                oldinvoice1MousePressed(evt);
            }
        });
        tillone.add(oldinvoice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 596, 90, -1));

        editlabel.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        editlabel.setBorder(javax.swing.BorderFactory.createTitledBorder("Edit Price"));
        tillone.add(editlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 120, 90, 50));

        editbutt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_edit_48px.png"))); // NOI18N
        editbutt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Edit Price", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 102, 255))); // NOI18N
        editbutt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                editbuttMousePressed(evt);
            }
        });
        tillone.add(editbutt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1108, 590, 80, 80));

        percentage4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Interest", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 102, 255))); // NOI18N
        tillone.add(percentage4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 240, 80, 50));

        check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkActionPerformed(evt);
            }
        });
        tillone.add(check, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 300, -1, -1));

        disnote.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        disnote.setForeground(new java.awt.Color(0, 102, 255));
        disnote.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        disnote.setText("Wholesale ");
        tillone.add(disnote, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 330, 90, -1));

        gui.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Salesnew.png"))); // NOI18N
        gui.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                guiMousePressed(evt);
            }
        });
        tillone.add(gui, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        tillone.add(orderid2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 100, 20));

        nameCode.setText("jLabel1");
        tillone.add(nameCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 150, 20));

        display.setText("jLabel5");
        tillone.add(display, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 460, -1, -1));
        tillone.add(pricefortable, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, -1, -1));
        tillone.add(customerindicator, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 220, -1, -1));
        tillone.add(customerid, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 260, -1, -1));

        ordercheck.setText("jLabel1");
        tillone.add(ordercheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 590, -1, -1));

        instocklimit.setText("jLabel2");
        tillone.add(instocklimit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 550, -1, -1));

        invoicecounter.setText("jLabel1");
        tillone.add(invoicecounter, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 600, -1, -1));

        percentage.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "100" }));
        tillone.add(percentage, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 590, -1, -1));

        percenlabel.setText("100");
        tillone.add(percenlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 520, -1, -1));

        invoicerecord.setText("jLabel1");
        tillone.add(invoicerecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 590, -1, -1));

        main.add(tillone, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 680));

        tilltwo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nameCombo1.setEditable(true);
        nameCombo1.setFont(new java.awt.Font("Open Sans", 0, 16)); // NOI18N
        nameCombo1.setOpaque(false);
        nameCombo1.setPreferredSize(new java.awt.Dimension(50, 22));
        nameCombo1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                nameCombo1PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        tilltwo.add(nameCombo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(885, 75, 350, 30));
        ((JComponent) nameCombo1.getEditor().getEditorComponent()).setBorder(null);
        apexlink.AutoCompletionold.enable(nameCombo);
        apexlink.AutoCompletionold.enable(nameCombo1);

        customer1.setFont(new java.awt.Font("Open Sans", 0, 16)); // NOI18N
        customer1.setBorder(null);
        customer1.setOpaque(false);
        customer1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                customer1KeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                customer1KeyPressed(evt);
            }
        });
        tilltwo.add(customer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 250, 30));

        priceLabel1.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        priceLabel1.setForeground(new java.awt.Color(0, 102, 255));
        priceLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tilltwo.add(priceLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, 100, 30));

        instocklabel1.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        instocklabel1.setForeground(new java.awt.Color(0, 102, 255));
        instocklabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tilltwo.add(instocklabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, 110, 30));

        typeLabel1.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        typeLabel1.setForeground(new java.awt.Color(0, 102, 255));
        typeLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tilltwo.add(typeLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 370, 110, 30));

        boxLabel1.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        boxLabel1.setForeground(new java.awt.Color(0, 102, 255));
        boxLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tilltwo.add(boxLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 430, 120, 30));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(null);
        jScrollPane2.setOpaque(false);

        table1.setFont(new java.awt.Font("Open Sans", 0, 16)); // NOI18N
        table1.setModel(new apexlink.salestablemodelold(rs));
        table1.setGridColor(new java.awt.Color(255, 255, 255));
        table1.setOpaque(false);
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                table1MousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(table1);

        tilltwo.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 250, 680, 300));

        sumtotal1.setFont(new java.awt.Font("Calibri", 0, 48)); // NOI18N
        sumtotal1.setForeground(new java.awt.Color(0, 102, 204));
        tilltwo.add(sumtotal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 610, 290, 50));

        customerCombo1.setEditable(true);
        customerCombo1.setFont(new java.awt.Font("Open Sans", 0, 16)); // NOI18N
        customerCombo1.setOpaque(false);
        customerCombo1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                customerCombo1PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        tilltwo.add(customerCombo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 75, 295, 30));
        apexlink.AutoCompletionold.enable(customerCombo1);
        ((JComponent) customerCombo1.getEditor().getEditorComponent()).setBorder(null);

        quantityField1.setFont(new java.awt.Font("Open Sans", 0, 16)); // NOI18N
        quantityField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        quantityField1.setBorder(null);
        quantityField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quantityField1MouseClicked(evt);
            }
        });
        quantityField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                quantityField1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                quantityField1KeyTyped(evt);
            }
        });
        tilltwo.add(quantityField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 130, 100, 40));

        printbutt1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                printbutt1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                printbutt1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                printbutt1MousePressed(evt);
            }
        });
        tilltwo.add(printbutt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 130, 70, 50));

        savebutton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                savebutton1MousePressed(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                savebutton1MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                savebutton1MouseEntered(evt);
            }
        });
        tilltwo.add(savebutton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 590, 70, 70));

        updatebutt1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                updatebutt1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                updatebutt1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                updatebutt1MousePressed(evt);
            }
        });
        tilltwo.add(updatebutt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 590, 70, 70));

        clearbutt1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                clearbutt1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                clearbutt1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                clearbutt1MousePressed(evt);
            }
        });
        tilltwo.add(clearbutt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 600, 70, 50));

        deletebutt1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deletebutt1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deletebutt1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                deletebutt1MousePressed(evt);
            }
        });
        tilltwo.add(deletebutt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 600, 70, 50));

        header1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        header1.setForeground(new java.awt.Color(255, 255, 255));
        header1.setText("jLabel1");
        tilltwo.add(header1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 140, -1));

        salesLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        salesLabel1.setForeground(new java.awt.Color(0, 102, 204));
        tilltwo.add(salesLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 530, 140, 30));

        salesicon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_user_50px.png"))); // NOI18N
        tilltwo.add(salesicon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 520, -1, -1));

        count1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        count1.setForeground(new java.awt.Color(0, 102, 204));
        count1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        count1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Counter", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 13), new java.awt.Color(0, 102, 204))); // NOI18N
        tilltwo.add(count1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 600, 80, 70));

        RetailLabel1.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        RetailLabel1.setForeground(new java.awt.Color(0, 102, 255));
        RetailLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 204), 2), "Retail Price", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 12), new java.awt.Color(0, 102, 204))); // NOI18N
        tilltwo.add(RetailLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 360, 90, 100));

        invoicepanelview1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Invoicepanel.png"))); // NOI18N
        tilltwo.add(invoicepanelview1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 230, 70));

        tilltwopanelview1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Invoicepanel.png"))); // NOI18N
        tilltwo.add(tilltwopanelview1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 230, 70));

        tillonepanelview1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Invoicepanel.png"))); // NOI18N
        tilltwo.add(tillonepanelview1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 230, 70));

        tilltwoclick1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tilltwoclick1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tilltwoclick1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tilltwoclick1MousePressed(evt);
            }
        });
        tilltwo.add(tilltwoclick1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 210, 50));

        invoiceclick1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                invoiceclick1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                invoiceclick1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                invoiceclick1MousePressed(evt);
            }
        });
        tilltwo.add(invoiceclick1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 210, 50));

        tilloneclick1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tilloneclick1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tilloneclick1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tilloneclick1MousePressed(evt);
            }
        });
        tilltwo.add(tilloneclick1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 210, 60));

        settingspanelview1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/settingspanel.png"))); // NOI18N
        tilltwo.add(settingspanelview1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 590, 70, 80));

        userpanelview1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/settingspanel.png"))); // NOI18N
        tilltwo.add(userpanelview1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 590, 70, 80));

        userclick1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                userclick1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                userclick1MouseExited(evt);
            }
        });
        tilltwo.add(userclick1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 600, 50, 60));

        printpanelview1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/settingspanel.png"))); // NOI18N
        tilltwo.add(printpanelview1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 120, 70, 70));

        refreshpanelview1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/settingspanel.png"))); // NOI18N
        refreshpanelview1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                refreshpanelview1MousePressed(evt);
            }
        });
        tilltwo.add(refreshpanelview1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 120, 70, 70));

        refreshclick1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                refreshclick1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                refreshclick1MouseExited(evt);
            }
        });
        tilltwo.add(refreshclick1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 130, 60, 50));

        savepanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/savepanel.png"))); // NOI18N
        savepanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                savepanel1MouseEntered(evt);
            }
        });
        tilltwo.add(savepanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 580, 70, 90));

        updatepanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/savepanel.png"))); // NOI18N
        tilltwo.add(updatepanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 580, 70, 90));

        clearpanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/savepanel.png"))); // NOI18N
        tilltwo.add(clearpanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 580, 70, 90));

        deletepanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/savepanel.png"))); // NOI18N
        tilltwo.add(deletepanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 580, 70, 90));

        refreshbutt1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                refreshbutt1MousePressed(evt);
            }
        });
        tilltwo.add(refreshbutt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 130, 50, 50));

        productbutt1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                productbutt1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                productbutt1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                productbutt1MousePressed(evt);
            }
        });
        tilltwo.add(productbutt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 180, 40));

        productspanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/productspanel.png"))); // NOI18N
        productspanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                productspanel1MousePressed(evt);
            }
        });
        tilltwo.add(productspanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 180, 50));

        printpanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/productspanel.png"))); // NOI18N
        tilltwo.add(printpanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, 180, 50));

        exitpanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/productspanel.png"))); // NOI18N
        exitpanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exitpanel1MousePressed(evt);
            }
        });
        tilltwo.add(exitpanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, 180, 55));

        exitbutt1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitbutt1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitbutt1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exitbutt1MousePressed(evt);
            }
        });
        tilltwo.add(exitbutt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 530, 160, 40));

        printerbutt1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                printerbutt1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                printerbutt1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                printerbutt1MousePressed(evt);
            }
        });
        tilltwo.add(printerbutt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, 160, 40));

        settings1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Settings group.png"))); // NOI18N
        tilltwo.add(settings1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 395, 230, -1));

        settingsoff1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                settingsoff1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                settingsoff1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                settingsoff1MousePressed(evt);
            }
        });
        tilltwo.add(settingsoff1, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 596, 70, 70));

        settingson1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                settingson1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                settingson1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                settingson1MousePressed(evt);
            }
        });
        tilltwo.add(settingson1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 600, 50, 60));

        oldinvoice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_edit_property_48px_1.png"))); // NOI18N
        oldinvoice.setBorder(javax.swing.BorderFactory.createTitledBorder("Old Invoice"));
        oldinvoice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                oldinvoiceMousePressed(evt);
            }
        });
        tilltwo.add(oldinvoice, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 595, 90, -1));

        editbutt1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_edit_48px.png"))); // NOI18N
        editbutt1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Edit Price", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 102, 255))); // NOI18N
        editbutt1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                editbutt1MousePressed(evt);
            }
        });
        tilltwo.add(editbutt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1108, 590, 80, 80));

        editlabel1.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        editlabel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Edit Price"));
        tilltwo.add(editlabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 120, 90, 50));

        percentage5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Interest", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 102, 255))); // NOI18N
        tilltwo.add(percentage5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 240, 80, 50));

        check1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check1ActionPerformed(evt);
            }
        });
        tilltwo.add(check1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 300, -1, -1));

        disnote1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        disnote1.setForeground(new java.awt.Color(0, 102, 255));
        disnote1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        disnote1.setText("Wholesale ");
        tilltwo.add(disnote1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 330, 90, -1));

        gui1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Salesnew.png"))); // NOI18N
        tilltwo.add(gui1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        tilltwo.add(orderid3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 150, 20));

        display1.setText("jLabel5");
        tilltwo.add(display1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 460, -1, -1));

        ordercheck1.setText("jLabel1");
        tilltwo.add(ordercheck1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 590, -1, -1));

        nameCode1.setText("jLabel1");
        tilltwo.add(nameCode1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, -1, -1));

        instocklimit1.setText("jLabel2");
        tilltwo.add(instocklimit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 550, -1, -1));

        invoicecounter1.setText("jLabel1");
        tilltwo.add(invoicecounter1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 600, -1, -1));

        percentage1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "100" }));
        tilltwo.add(percentage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 590, -1, -1));

        percenlabel1.setText("100");
        tilltwo.add(percenlabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 520, -1, -1));

        invoicerecord1.setText("jLabel1");
        tilltwo.add(invoicerecord1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 590, -1, -1));

        customerid1.setText("jLabel1");
        tilltwo.add(customerid1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 250, -1, -1));

        customerindicator1.setText("jLabel1");
        tilltwo.add(customerindicator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 300, -1, -1));
        tilltwo.add(pricefortable1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, -1, -1));

        main.add(tilltwo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 680));

        invoice.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nameCombo2.setEditable(true);
        nameCombo2.setFont(new java.awt.Font("Open Sans", 0, 16)); // NOI18N
        nameCombo2.setOpaque(false);
        nameCombo2.setPreferredSize(new java.awt.Dimension(50, 22));
        nameCombo2.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                nameCombo2PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        nameCombo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameCombo2ActionPerformed(evt);
            }
        });
        invoice.add(nameCombo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(885, 75, 350, 30));
        ((JComponent) nameCombo.getEditor().getEditorComponent()).setBorder(null);
        apexlink.AutoCompletionold.enable(nameCombo2);
        ((JComponent) nameCombo2.getEditor().getEditorComponent()).setBorder(null);

        priceLabel2.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        priceLabel2.setForeground(new java.awt.Color(0, 102, 255));
        priceLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        invoice.add(priceLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, 100, 30));

        instocklabel2.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        instocklabel2.setForeground(new java.awt.Color(0, 102, 255));
        instocklabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        invoice.add(instocklabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, 110, 30));

        typeLabel2.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        typeLabel2.setForeground(new java.awt.Color(0, 102, 255));
        typeLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        invoice.add(typeLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 370, 110, 30));

        boxLabel2.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        boxLabel2.setForeground(new java.awt.Color(0, 102, 255));
        boxLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        invoice.add(boxLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 430, 120, 30));

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setBorder(null);
        jScrollPane3.setOpaque(false);

        table2.setFont(new java.awt.Font("Open Sans", 0, 16)); // NOI18N
        table2.setModel(new apexlink.salestablemodelold(rs));
        table2.setGridColor(new java.awt.Color(255, 255, 255));
        table2.setOpaque(false);
        table2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                table2MousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(table2);

        invoice.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 250, 680, 300));

        sumtotal2.setFont(new java.awt.Font("Calibri", 0, 48)); // NOI18N
        sumtotal2.setForeground(new java.awt.Color(0, 102, 204));
        invoice.add(sumtotal2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 600, 270, 60));

        quantityField2.setFont(new java.awt.Font("Open Sans", 0, 16)); // NOI18N
        quantityField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        quantityField2.setBorder(null);
        quantityField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quantityField2MouseClicked(evt);
            }
        });
        quantityField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityField2ActionPerformed(evt);
            }
        });
        quantityField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                quantityField2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                quantityField2KeyTyped(evt);
            }
        });
        invoice.add(quantityField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 130, 100, 40));

        printbutt2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                printbutt2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                printbutt2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                printbutt2MousePressed(evt);
            }
        });
        invoice.add(printbutt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 130, 70, 50));

        savebutton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                savebutton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                savebutton2MouseExited(evt);
            }
        });
        invoice.add(savebutton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 590, 70, 70));

        updatebutt2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                updatebutt2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                updatebutt2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                updatebutt2MousePressed(evt);
            }
        });
        invoice.add(updatebutt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 590, 70, 70));

        deletebutt2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deletebutt2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deletebutt2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                deletebutt2MousePressed(evt);
            }
        });
        invoice.add(deletebutt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 580, 70, 90));

        header2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        header2.setForeground(new java.awt.Color(255, 255, 255));
        header2.setText("jLabel1");
        invoice.add(header2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 140, -1));

        salesLabel2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        salesLabel2.setForeground(new java.awt.Color(0, 102, 204));
        invoice.add(salesLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 510, 140, 40));

        salesicon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_user_50px.png"))); // NOI18N
        invoice.add(salesicon2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 500, -1, -1));

        count2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        count2.setForeground(new java.awt.Color(0, 102, 204));
        count2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        count2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Counter", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 13), new java.awt.Color(0, 102, 204))); // NOI18N
        invoice.add(count2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 600, 80, 70));

        RetailLabel2.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        RetailLabel2.setForeground(new java.awt.Color(0, 102, 255));
        RetailLabel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 204), 2), "Retail Price", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 12), new java.awt.Color(0, 102, 204))); // NOI18N
        invoice.add(RetailLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 330, 90, 100));

        invoicepanelview2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Invoicepanel.png"))); // NOI18N
        invoice.add(invoicepanelview2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 230, 70));

        tilltwopanelview2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Invoicepanel.png"))); // NOI18N
        invoice.add(tilltwopanelview2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 230, 70));

        tillonepanelview2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Invoicepanel.png"))); // NOI18N
        invoice.add(tillonepanelview2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 230, 70));

        tilltwoclick2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tilltwoclick2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tilltwoclick2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tilltwoclick2MousePressed(evt);
            }
        });
        invoice.add(tilltwoclick2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 210, 50));

        invoiceclick2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                invoiceclick2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                invoiceclick2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                invoiceclick2MousePressed(evt);
            }
        });
        invoice.add(invoiceclick2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 210, 50));

        tilloneclick2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tilloneclick2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tilloneclick2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tilloneclick2MousePressed(evt);
            }
        });
        invoice.add(tilloneclick2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 210, 60));

        settingspanelview2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/settingspanel.png"))); // NOI18N
        invoice.add(settingspanelview2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 590, 70, 80));

        userpanelview2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/settingspanel.png"))); // NOI18N
        invoice.add(userpanelview2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 590, 70, 80));

        userclick2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                userclick2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                userclick2MouseExited(evt);
            }
        });
        invoice.add(userclick2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 600, 50, 60));

        printpanelview2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/settingspanel.png"))); // NOI18N
        invoice.add(printpanelview2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 120, 70, 70));

        refreshpanelview2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/settingspanel.png"))); // NOI18N
        refreshpanelview2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                refreshpanelview2MousePressed(evt);
            }
        });
        invoice.add(refreshpanelview2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 120, 70, 70));

        refreshclick2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                refreshclick2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                refreshclick2MouseExited(evt);
            }
        });
        invoice.add(refreshclick2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 130, 60, 50));

        savepanel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/savepanel.png"))); // NOI18N
        savepanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                savepanel2MouseEntered(evt);
            }
        });
        invoice.add(savepanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 580, 70, 90));

        updatepanel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/savepanel.png"))); // NOI18N
        invoice.add(updatepanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 580, 70, 90));

        clearpanel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/savepanel.png"))); // NOI18N
        invoice.add(clearpanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 580, 70, 90));

        deletepanel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/savepanel.png"))); // NOI18N
        invoice.add(deletepanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 580, 70, 90));

        custName.setFont(new java.awt.Font("Open Sans", 0, 16)); // NOI18N
        invoice.add(custName, new org.netbeans.lib.awtextra.AbsoluteConstraints(551, 76, 290, 30));

        custCombo.setEditable(true);
        custCombo.setFont(new java.awt.Font("Open Sans", 0, 16)); // NOI18N
        custCombo.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                custComboPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        invoice.add(custCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 250, 36));
        apexlink.AutoCompletionold.enable(custCombo);
        ((JComponent) custCombo.getEditor().getEditorComponent()).setBorder(null);

        orderid.setFont(new java.awt.Font("Open Sans", 0, 16)); // NOI18N
        invoice.add(orderid, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 130, 120, 30));

        editButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                editButtonMousePressed(evt);
            }
        });
        invoice.add(editButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, 70, 60));

        editpanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/settingspanel.png"))); // NOI18N
        invoice.add(editpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, 70, 60));

        refreshbutt2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                refreshbutt2MousePressed(evt);
            }
        });
        invoice.add(refreshbutt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 130, 50, 50));

        orderField.setFont(new java.awt.Font("Open Sans", 0, 16)); // NOI18N
        orderField.setBorder(null);
        orderField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                orderFieldKeyTyped(evt);
            }
        });
        invoice.add(orderField, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 137, 120, 30));

        exitpanel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/productspanel.png"))); // NOI18N
        exitpanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exitpanel2MousePressed(evt);
            }
        });
        invoice.add(exitpanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, 180, 55));

        printpanel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/productspanel.png"))); // NOI18N
        invoice.add(printpanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, 180, 50));

        productspanel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/productspanel.png"))); // NOI18N
        invoice.add(productspanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 180, 50));

        settingsoff2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                settingsoff2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                settingsoff2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                settingsoff2MousePressed(evt);
            }
        });
        invoice.add(settingsoff2, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 596, 70, 70));

        settingson2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                settingson2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                settingson2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                settingson2MousePressed(evt);
            }
        });
        invoice.add(settingson2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 600, 50, 60));

        exitbutt2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitbutt2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitbutt2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exitbutt2MousePressed(evt);
            }
        });
        invoice.add(exitbutt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 530, 160, 40));

        printerbutt2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                printerbutt2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                printerbutt2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                printerbutt2MousePressed(evt);
            }
        });
        invoice.add(printerbutt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, 160, 40));

        productbutt2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                productbutt2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                productbutt2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                productbutt2MousePressed(evt);
            }
        });
        invoice.add(productbutt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 160, 40));

        settings2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Settings group.png"))); // NOI18N
        invoice.add(settings2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 395, 230, -1));

        invoicepercentage.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "5", "10", "15" }));
        invoice.add(invoicepercentage, new org.netbeans.lib.awtextra.AbsoluteConstraints(1163, 240, 70, -1));

        jLabel4.setForeground(new java.awt.Color(0, 102, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsets/PNG/Orb plus.png"))); // NOI18N
        jLabel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255)), "iForgot", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 102, 255))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel4MousePressed(evt);
            }
        });
        invoice.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 590, -1, 80));

        gui2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/invoice2.png"))); // NOI18N
        invoice.add(gui2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        percentage2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "100" }));
        invoice.add(percentage2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 490, -1, -1));

        customer2.setText("jTextField1");
        customer2.setBorder(null);
        customer2.setOpaque(false);
        invoice.add(customer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 250, 30));

        pricefortable2.setText("jLabel4");
        invoice.add(pricefortable2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 140, -1, -1));

        orderid4.setText("jLabel1");
        invoice.add(orderid4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, -1, -1));

        ordercheck2.setText("jLabel1");
        invoice.add(ordercheck2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 590, -1, -1));
        invoice.add(nameCode2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, -1, -1));

        instocklimit2.setText("jLabel2");
        invoice.add(instocklimit2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 550, -1, -1));

        invoicecounter2.setText("jLabel1");
        invoice.add(invoicecounter2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 600, -1, -1));

        percenlabel2.setText("100");
        invoice.add(percenlabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 520, -1, -1));

        invoicerecord2.setText("jLabel1");
        invoice.add(invoicerecord2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 590, -1, -1));

        main.add(invoice, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 680));

        product.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sumtotal3.setFont(new java.awt.Font("Calibri", 0, 48)); // NOI18N
        sumtotal3.setForeground(new java.awt.Color(0, 102, 204));
        product.add(sumtotal3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 500, 190, 90));

        savebutton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                savebutton3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                savebutton3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                savebutton3MousePressed(evt);
            }
        });
        product.add(savebutton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 590, 70, 70));

        updatebutt3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                updatebutt3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                updatebutt3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                updatebutt3MousePressed(evt);
            }
        });
        product.add(updatebutt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 590, 70, 70));

        clearbutt3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                clearbutt3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                clearbutt3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                clearbutt3MousePressed(evt);
            }
        });
        product.add(clearbutt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 600, 70, 50));

        deletebutt3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deletebutt3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deletebutt3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                deletebutt3MousePressed(evt);
            }
        });
        product.add(deletebutt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 600, 70, 50));

        mouseDrag1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                mouseDrag1MouseDragged(evt);
            }
        });
        mouseDrag1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mouseDrag1MousePressed(evt);
            }
        });
        product.add(mouseDrag1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 820, 30));

        header3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        header3.setForeground(new java.awt.Color(255, 255, 255));
        header3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                header3MouseDragged(evt);
            }
        });
        header3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                header3MousePressed(evt);
            }
        });
        product.add(header3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 110, 30));

        salesLabel3.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        salesLabel3.setForeground(new java.awt.Color(0, 102, 204));
        product.add(salesLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 620, 180, 40));

        salesicon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_user_50px.png"))); // NOI18N
        product.add(salesicon3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 610, -1, -1));

        invoicepanelview3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Invoicepanel.png"))); // NOI18N
        product.add(invoicepanelview3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 230, 70));

        tilltwopanelview3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Invoicepanel.png"))); // NOI18N
        product.add(tilltwopanelview3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 230, 70));

        tillonepanelview3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Invoicepanel.png"))); // NOI18N
        product.add(tillonepanelview3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 230, 70));

        tilltwoclick3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tilltwoclick3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tilltwoclick3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tilltwoclick3MousePressed(evt);
            }
        });
        product.add(tilltwoclick3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 210, 50));

        invoiceclick3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                invoiceclick3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                invoiceclick3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                invoiceclick3MousePressed(evt);
            }
        });
        product.add(invoiceclick3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 210, 50));

        tilloneclick3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tilloneclick3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tilloneclick3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tilloneclick3MousePressed(evt);
            }
        });
        product.add(tilloneclick3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 210, 60));

        settingspanelview3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/settingspanel.png"))); // NOI18N
        product.add(settingspanelview3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 590, 70, 80));

        userpanelview3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/settingspanel.png"))); // NOI18N
        product.add(userpanelview3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 590, 70, 80));

        userclick3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                userclick3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                userclick3MouseExited(evt);
            }
        });
        product.add(userclick3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 600, 50, 60));

        savepanel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/savepanel.png"))); // NOI18N
        savepanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                savepanel3MouseEntered(evt);
            }
        });
        product.add(savepanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 580, 70, 90));

        updatepanel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/savepanel.png"))); // NOI18N
        product.add(updatepanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 580, 70, 90));

        clearpanel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/savepanel.png"))); // NOI18N
        product.add(clearpanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 580, 70, 90));

        deletepanel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/savepanel.png"))); // NOI18N
        product.add(deletepanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 580, 70, 90));

        refreshbutt3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                refreshbutt3MousePressed(evt);
            }
        });
        product.add(refreshbutt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 130, 50, 50));

        productbutt3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                productbutt3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                productbutt3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                productbutt3MousePressed(evt);
            }
        });
        product.add(productbutt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 160, 40));

        printerbutt3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                printerbutt3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                printerbutt3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                printerbutt3MousePressed(evt);
            }
        });
        product.add(printerbutt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, 160, 40));

        exitbutt3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitbutt3MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitbutt3MouseEntered(evt);
            }
        });
        product.add(exitbutt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 530, 160, 40));

        productspanel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/productspanel.png"))); // NOI18N
        product.add(productspanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 180, 50));

        printpanel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/productspanel.png"))); // NOI18N
        product.add(printpanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, 180, 50));

        exitpanel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/productspanel.png"))); // NOI18N
        product.add(exitpanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, 180, 55));

        settingson3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                settingson3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                settingson3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                settingson3MousePressed(evt);
            }
        });
        product.add(settingson3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 600, 50, 60));

        settingsoff3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                settingsoff3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                settingsoff3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                settingsoff3MousePressed(evt);
            }
        });
        product.add(settingsoff3, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 596, 70, 70));

        settings3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Settings group.png"))); // NOI18N
        product.add(settings3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 230, -1));

        namefield.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        namefield.setBorder(null);
        namefield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                namefieldKeyTyped(evt);
            }
        });
        product.add(namefield, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 160, 350, 30));

        description.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        description.setBorder(null);
        product.add(description, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 220, 350, 30));

        piecesinbox.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        piecesinbox.setBorder(null);
        product.add(piecesinbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 290, 350, 30));

        buyingprice.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        buyingprice.setBorder(null);
        product.add(buyingprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 410, 350, 30));

        category.setEditable(true);
        category.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        category.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SYRUP", "TABLET", "DROPS", "CREAM", "INFUSION", "CAPSULES", "CAPLET", "PIILLS", "SOLUTION", "INJECTION", "OTHERS" }));
        category.setSelectedIndex(-1);
        product.add(category, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 350, 350, 30));
        ((JComponent) category.getEditor().getEditorComponent()).setBorder(null);

        sellingprice.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        sellingprice.setBorder(null);
        product.add(sellingprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 470, 350, 30));

        stock.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        stock.setBorder(null);
        product.add(stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 530, 350, 30));

        namesearch.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        namesearch.setBorder(null);
        namesearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                namesearchKeyTyped(evt);
            }
        });
        product.add(namesearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 280, 30));

        list.setBorder(null);
        list.setViewportBorder(new javax.swing.border.LineBorder(new java.awt.Color(54, 113, 235), 2, true));

        jList1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jList1MousePressed(evt);
            }
        });
        list.setViewportView(jList1);

        product.add(list, new org.netbeans.lib.awtextra.AbsoluteConstraints(251, 121, 305, 470));

        gui3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        gui3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Product.png"))); // NOI18N
        product.add(gui3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        product.add(customerindicator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 220, -1, -1));
        product.add(customerid2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 260, -1, -1));
        product.add(orderid5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, -1, -1));

        ordercheck3.setText("jLabel1");
        product.add(ordercheck3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 590, -1, -1));

        instocklimit3.setText("jLabel2");
        product.add(instocklimit3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 550, -1, -1));

        invoicecounter3.setText("jLabel1");
        product.add(invoicecounter3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 600, -1, -1));

        percentage3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "100" }));
        product.add(percentage3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 590, -1, -1));

        percenlabel3.setText("100");
        product.add(percenlabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 520, -1, -1));

        invoicerecord3.setText("jLabel1");
        product.add(invoicerecord3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 590, -1, -1));

        main.add(product, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 680));

        productlogin.setPreferredSize(new java.awt.Dimension(1250, 678));
        productlogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ok.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        ok.setForeground(new java.awt.Color(0, 102, 255));
        ok.setText("OK");
        ok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                okMousePressed(evt);
            }
        });
        productlogin.add(ok, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 380, 60, -1));

        success.setFont(new java.awt.Font("Source Sans Pro Black", 0, 24)); // NOI18N
        success.setForeground(new java.awt.Color(0, 153, 255));
        success.setText("SUCCESS");
        productlogin.add(success, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 340, 120, 30));

        gif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ezgif.com-resize(2).gif"))); // NOI18N
        productlogin.add(gif, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 250, -1, 100));

        error1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/successpanel.png"))); // NOI18N
        productlogin.add(error1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 230, 270, 220));

        playbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                playbuttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                playbuttonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                playbuttonMousePressed(evt);
            }
        });
        productlogin.add(playbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 290, 40, 40));

        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_previous_50px.png"))); // NOI18N
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exitMousePressed(evt);
            }
        });
        productlogin.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 360, -1, -1));

        errormsg1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        errormsg1.setForeground(new java.awt.Color(153, 153, 153));
        errormsg1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        productlogin.add(errormsg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 430, 260, 30));

        error4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/error1.png"))); // NOI18N
        productlogin.add(error4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 290, -1, -1));

        errorclose1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                errorclose1MousePressed(evt);
            }
        });
        productlogin.add(errorclose1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 470, 70, 30));

        password.setBackground(new java.awt.Color(51, 101, 255));
        password.setForeground(new java.awt.Color(255, 255, 255));
        password.setBorder(null);
        password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordKeyPressed(evt);
            }
        });
        productlogin.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 286, 180, 20));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Please Enter Admin Password");
        productlogin.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 320, 190, 30));

        gui4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Productlogin.png"))); // NOI18N
        productlogin.add(gui4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, -4, 1250, 680));

        main.add(productlogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        ChangePass.setPreferredSize(new java.awt.Dimension(1250, 678));
        ChangePass.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ok1.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        ok1.setForeground(new java.awt.Color(0, 102, 255));
        ok1.setText("OK");
        ok1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ok1MousePressed(evt);
            }
        });
        ChangePass.add(ok1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 390, 60, -1));

        success1.setFont(new java.awt.Font("Source Sans Pro Black", 0, 24)); // NOI18N
        success1.setForeground(new java.awt.Color(0, 153, 255));
        success1.setText("SUCCESS");
        ChangePass.add(success1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 360, 120, 30));

        gif1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ezgif.com-resize(2).gif"))); // NOI18N
        ChangePass.add(gif1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 260, 230, 120));

        error2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/successpanel.png"))); // NOI18N
        ChangePass.add(error2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, 250, 200));

        newpass.setBackground(new java.awt.Color(184, 192, 203));
        newpass.setBorder(null);
        ChangePass.add(newpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 335, 210, 30));

        oldpass.setBackground(new java.awt.Color(184, 192, 203));
        oldpass.setBorder(null);
        ChangePass.add(oldpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 280, 210, 25));

        eyeoneon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                eyeoneonMousePressed(evt);
            }
        });
        ChangePass.add(eyeoneon, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 280, 30, 23));

        savebutt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                savebuttMousePressed(evt);
            }
        });
        ChangePass.add(savebutt, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 386, 80, 20));

        backbutt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                backbuttMousePressed(evt);
            }
        });
        ChangePass.add(backbutt, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 380, 90, 30));

        eyeoneoff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                eyeoneoffMousePressed(evt);
            }
        });
        ChangePass.add(eyeoneoff, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 280, 30, 25));

        eyetwoon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                eyetwoonMousePressed(evt);
            }
        });
        ChangePass.add(eyetwoon, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 340, 30, 23));

        eyetwooff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                eyetwooffMousePressed(evt);
            }
        });
        ChangePass.add(eyetwooff, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 340, 30, 20));

        gui5.setBackground(new java.awt.Color(153, 153, 153));
        gui5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Changepassform.png"))); // NOI18N
        ChangePass.add(gui5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        namelabel.setText("jLabel3");
        ChangePass.add(namelabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 250, -1, -1));

        main.add(ChangePass, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Createuser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setBackground(new java.awt.Color(184, 192, 203));
        jTextField1.setBorder(null);
        Createuser.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 265, 240, 25));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Createuser.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 376, 240, 25));

        newpass1.setBackground(new java.awt.Color(184, 192, 203));
        newpass1.setBorder(null);
        Createuser.add(newpass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 320, 210, 30));

        savebutt1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                savebutt1MousePressed(evt);
            }
        });
        Createuser.add(savebutt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 430, 80, 25));

        backbutt1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                backbutt1MousePressed(evt);
            }
        });
        Createuser.add(backbutt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 430, 90, 30));

        eyetwoon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                eyetwoon1MousePressed(evt);
            }
        });
        Createuser.add(eyetwoon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 320, 30, 23));

        eyetwooff1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                eyetwooff1MousePressed(evt);
            }
        });
        Createuser.add(eyetwooff1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 320, 40, 30));

        gui6.setBackground(new java.awt.Color(153, 153, 153));
        gui6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Createform.png"))); // NOI18N
        Createuser.add(gui6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        ok2.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        ok2.setForeground(new java.awt.Color(0, 102, 255));
        ok2.setText("OK");
        ok2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ok2MousePressed(evt);
            }
        });
        Createuser.add(ok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 390, 60, -1));

        success2.setFont(new java.awt.Font("Source Sans Pro Black", 0, 24)); // NOI18N
        success2.setForeground(new java.awt.Color(0, 153, 255));
        success2.setText("SUCCESS");
        Createuser.add(success2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 360, 120, 30));

        gif2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ezgif.com-resize(2).gif"))); // NOI18N
        Createuser.add(gif2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 260, 230, 120));

        error3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/successpanel.png"))); // NOI18N
        Createuser.add(error3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, 250, 200));

        namelabel1.setText("jLabel3");
        Createuser.add(namelabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 250, -1, -1));

        main.add(Createuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 680));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
private void DropTotalsinvoice() throws SQLException {
        Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
Statement stmt =null;
        try {
            conn = mysqlconnect.ConnectDb();
            stmt = conn.createStatement();
            stmt.executeUpdate(DROP_INVOICETOTALS);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
      finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
                        }    
    }
    private void tableselect(){
     Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null; 
conn = mysqlconnect.ConnectDb();
        try{
        int row = table.getSelectedRow();
        String click = (String) (table.getModel().getValueAt(row, 0));
    String sql = "select * from product where `name` = ?";
    //String sql1 = "select *from product where name = '"+click+"'"
        pst = conn.prepareStatement(sql);
        pst.setString(1, click);
        rs = pst.executeQuery();
        if (rs.next()){
            String add = rs.getString("name");
            nameCode.setText(add);
             String add1 = rs.getString("pricesell");
          priceLabel.setText(add1);
             String add3 = rs.getString("description");
                typeLabel.setText(add3);
                 String add4 = rs.getString("inthebox");
                boxLabel.setText(add4);
            String add5 = rs.getString("instock");
                instocklabel.setText(add5);
        }
    
 }
    catch (Exception e){
        JOptionPane.showMessageDialog(null, e);
     
                                                  
    }                                   
   finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
                        }   
        retailclick();
    
}
    private void tableselect2(){
     Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null; 
conn = mysqlconnect.ConnectDb();
        try{
        int row = table2.getSelectedRow();
        String click = (table2.getModel().getValueAt(row, 0).toString());
    String sql = "select * from product where name = ?";
    //String sql1 = "select *from product where name = '"+click+"'"
        pst = conn.prepareStatement(sql);
        pst.setString(1, click);
        rs = pst.executeQuery();
        if (rs.next()){
            String add = rs.getString("name");
            nameCode2.setText(add);
             String add1 = rs.getString("pricesell");
          priceLabel2.setText(add1);
             String add3 = rs.getString("description");
                typeLabel2.setText(add3);
                 String add4 = rs.getString("inthebox");
                boxLabel2.setText(add4);
            String add5 = rs.getString("instock");
                instocklabel2.setText(add5);
        }
    
 }
    catch (Exception e){
        JOptionPane.showMessageDialog(null, e);
     
                                                  
    }                                   
   finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
                        }   
        retailclick2();
    
}
    private void tableselect1(){
     Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null; 
conn = mysqlconnect.ConnectDb();
        try{
        int row = table1.getSelectedRow();
        String click = (table1.getModel().getValueAt(row, 0).toString());
    String sql = "select * from product where name = ?";
    //String sql1 = "select *from product where name = '"+click+"'"
        pst = conn.prepareStatement(sql);
        pst.setString(1, click);
        rs = pst.executeQuery();
        if (rs.next()){
            String add = rs.getString("name");
            nameCode1.setText(add);
             String add1 = rs.getString("pricesell");
          priceLabel1.setText(add1);
             String add3 = rs.getString("description");
                typeLabel1.setText(add3);
                 String add4 = rs.getString("inthebox");
                boxLabel1.setText(add4);
            String add5 = rs.getString("instock");
                instocklabel1.setText(add5);
        }
    
 }
    catch (Exception e){
        JOptionPane.showMessageDialog(null, e);
     
                                                  
    }                                   
   finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
                        }   
        retailclick1();
    
}
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        for (double i = 0.0; i<1.0;i=i+0.1)
        {
            String val =i+"";
            float f = Float.valueOf(val);
            this.setOpacity(f);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Apex.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            {
            
//           Display f = new Display();
      // f.StartDisplay();
                
            
            }
         
          try {
            DropTable();
        } catch (SQLException ex) {
            Logger.getLogger(Apex.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            DropTable1();
        } catch (SQLException ex) {
            Logger.getLogger(Apex.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        try {
            DropTotals();
        } catch (SQLException ex) {
            Logger.getLogger(Apex.class.getName()).log(Level.SEVERE, null, ex);
        }
         try {
            DropTotals1();
        } catch (SQLException ex) {
            Logger.getLogger(Apex.class.getName()).log(Level.SEVERE, null, ex);
        }
        //try {
            //Dropretail();
       // } catch (SQLException ex) {
        //    Logger.getLogger(Jrootappclient1a11.class.getName()).log(Level.SEVERE, null, ex);
      //}
        //Createretail();
      //  createinvoice();
     // timer();
        Create();
        Create1();
        CreateTotals();
        CreateTotals1();
        try {
            //CreateOrders();
            Dropinstock();
        } catch (SQLException ex) {
            Logger.getLogger(Apex.class.getName()).log(Level.SEVERE, null, ex);
        }
         try {
            //CreateOrders();
            Dropinstock1();
        } catch (SQLException ex) {
            Logger.getLogger(Apex.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       Createinstock();
       Createinstock1();
        
        FillCombo();
        FillCombo1();
        FillComboinvoice();

        FillCombocust();
         FillCombocust1();
         FillCombocustinvoice();
        
        //FillCombox();
       customerCombo.setSelectedItem("");
            nameCombo.setSelectedItem("");
            customerCombo1.setSelectedItem("");
            nameCombo1.setSelectedItem("");
            custCombo.setSelectedItem("");
            nameCombo2.setSelectedItem("");
        //stop();
        salesUser();
        salesUser1();
        salesUser2();
        FillInterest();
        FillInterest1();
        CountInvoice();
        CountInvoice1();
Automate();
customerCombo.requestFocus();
customerCombo1.requestFocus();
FillJlist();
//header.setText("TILL ONE");
    }//GEN-LAST:event_formWindowOpened

    private void savepanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_savepanelMouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_savepanelMouseEntered

    private void refreshclickMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshclickMouseExited
        // TODO add your handling code here:
        refreshpanelview.setEnabled(false);
        refreshpanelview.setVisible(false);
    }//GEN-LAST:event_refreshclickMouseExited

    private void refreshclickMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshclickMouseEntered
        // TODO add your handling code here:
        refreshpanelview.setEnabled(true);
        refreshpanelview.setVisible(true);

    }//GEN-LAST:event_refreshclickMouseEntered

    private void tilloneclickMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tilloneclickMousePressed
        // TODO add your handling code here:
       start();
       panelremove();
    }//GEN-LAST:event_tilloneclickMousePressed

    private void tilloneclickMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tilloneclickMouseExited
        // TODO add your handling code here:
        tillonepanelview.setEnabled(false);
        tillonepanelview.setVisible(false);
    }//GEN-LAST:event_tilloneclickMouseExited

    private void tilloneclickMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tilloneclickMouseEntered
        // TODO add your handling code here:
        tillonepanelview.setEnabled(true);
        tillonepanelview.setVisible(true);
    }//GEN-LAST:event_tilloneclickMouseEntered

    private void invoiceclickMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invoiceclickMouseExited
        // TODO add your handling code here:
        invoicepanelview.setEnabled(false);
        invoicepanelview.setVisible(false);
    }//GEN-LAST:event_invoiceclickMouseExited

    private void invoiceclickMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invoiceclickMouseEntered
        // TODO add your handling code here:
        invoicepanelview.setEnabled(true);
        invoicepanelview.setVisible(true);
    }//GEN-LAST:event_invoiceclickMouseEntered

    private void tilltwoclickMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tilltwoclickMousePressed
        // TODO add your handling code here:
     start2();
     panelremove2();
    }//GEN-LAST:event_tilltwoclickMousePressed

    private void tilltwoclickMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tilltwoclickMouseExited
        // TODO add your handling code here:
        tilltwopanelview.setEnabled(false);
        tilltwopanelview.setVisible(false);
    }//GEN-LAST:event_tilltwoclickMouseExited

    private void tilltwoclickMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tilltwoclickMouseEntered
        // TODO add your handling code here:
        tilltwopanelview.setEnabled(true);
        tilltwopanelview.setVisible(true);
    }//GEN-LAST:event_tilltwoclickMouseEntered

    private void deletebuttMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletebuttMouseExited
        // TODO add your handling code here:
        deletepanel.setEnabled(false);
        deletepanel.setVisible(false);
    }//GEN-LAST:event_deletebuttMouseExited

    private void deletebuttMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletebuttMouseEntered
        // TODO add your handling code here:
        deletepanel.setEnabled(true);
        deletepanel.setVisible(true);
    }//GEN-LAST:event_deletebuttMouseEntered

    private void clearbuttMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearbuttMouseExited
        // TODO add your handling code here:
        clearpanel.setEnabled(false);
        clearpanel.setVisible(false);
    }//GEN-LAST:event_clearbuttMouseExited

    private void clearbuttMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearbuttMouseEntered
        // TODO add your handling code here:
        clearpanel.setEnabled(true);
        clearpanel.setVisible(true);
    }//GEN-LAST:event_clearbuttMouseEntered

    private void updatebuttMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatebuttMouseExited
        // TODO add your handling code here:
        updatepanel.setEnabled(false);
        updatepanel.setVisible(false);
    }//GEN-LAST:event_updatebuttMouseExited

    private void updatebuttMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatebuttMouseEntered
        // TODO add your handling code here:
        updatepanel.setEnabled(true);
        updatepanel.setVisible(true);
    }//GEN-LAST:event_updatebuttMouseEntered

    private void savebuttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_savebuttonMouseExited
        // TODO add your handling code here:
        savepanel.setEnabled(false);
        savepanel.setVisible(false);
    }//GEN-LAST:event_savebuttonMouseExited

    private void savebuttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_savebuttonMouseEntered
        // TODO add your handling code here:
        savepanel.setEnabled(true);
        savepanel.setVisible(true);
    }//GEN-LAST:event_savebuttonMouseEntered

    private void printbuttMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printbuttMouseExited
        // TODO add your handling code here:
        printpanelview.setEnabled(false);
        printpanelview.setVisible(false);
    }//GEN-LAST:event_printbuttMouseExited

    private void printbuttMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printbuttMouseEntered
        // TODO add your handling code here:
        printpanelview.setEnabled(true);
        printpanelview.setVisible(true);
    }//GEN-LAST:event_printbuttMouseEntered
private void Dropreload() throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = mysqlconnect.ConnectDb();
            stmt = conn.createStatement();
            stmt.executeUpdate(DROP_RELOAD);
          
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
           DbUtils.closeQuietly(stmt);
    DbUtils.closeQuietly(conn);
        }
    } 
private void reloadinsert() {
         Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
        String sql = "insert into reload (orderid,orderdate,name,quantity,price,customername,salesuser,amount) select orderid,orderdate,name,quantity,price,customername,salesuser,amount from Till1";

        String tmp = (String) nameCombo.getSelectedItem();
        String tmp1 = (String) customerCombo.getSelectedItem();
        try {
            pst = conn.prepareStatement(sql);
       // pst.setString(1, tmp);

         /*   pst.setString(1, orderid.getText());
            pst.setTimestamp(2, getCurrentDate());
            pst.setString(3, tmp);
            pst.setString(4, quantityField.getText());
            pst.setString(5, priceLabel.getText());
          //  if (customerCombo.getSelectedItem().toString() ==""){
                // pst.setString (6, customer.getText());
           // }
           // else
            pst.setString(6, tmp1);
            pst.setString(7, salesLabel.getText());
             pst.setTimestamp(8, getCurrentDate());
            pst.setString(9, productid.getText());*/
            pst.execute();

           // UpdateJTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
}
private void Createreload() {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = mysqlconnect.ConnectDb();
            stmt = conn.createStatement();
            stmt.executeUpdate(RELOAD);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
           DbUtils.closeQuietly(stmt);
    DbUtils.closeQuietly(conn);
        }
    }
    private void print() throws SQLException{
      Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null; 
conn = mysqlconnect.ConnectDb();

Dropreload();
//DbUtils.closeQuietly(conn);
Createreload();
invoicenorminsert();
//insertInvoice();
//reloadinsert();
        Totals();
         try{
             //conn = mysqlconnect.ConnectDb();
        JasperDesign jasperDesign = JRXmlLoader.load("Till1.jrxml");
        String sql = "select * from totals1";
        JRDesignQuery newQuery = new JRDesignQuery();
        newQuery.setText(sql);
        jasperDesign.setQuery(newQuery);
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);   
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, conn);
        //JasperViewer.viewReport(jasperPrint,false);
        JasperPrintManager.printReport(jasperPrint,false);
          
        
    } catch (Exception e){
        JOptionPane.showMessageDialog(null, e);
    }
         finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
         }
        try {
            DropTotals();
        } catch (SQLException ex) {
            Logger.getLogger(Apex.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            removeitems();
        } catch (SQLException ex) {
            Logger.getLogger(Apex.class.getName()).log(Level.SEVERE, null, ex);
        }
         
                           
        CreateTotals();
        // SubtractStock();
         FillInterest();
        // stop2();
       
        orderid2.setText("");
}
    private void print1() throws SQLException{
      Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null; 
conn = mysqlconnect.ConnectDb();

//Dropreload1();
//DbUtils.closeQuietly(conn);
//Createreload1();
invoicenorminsert1();
insertInvoice1();
//reloadinsert();
        Totals1();
         try{
             //conn = mysqlconnect.ConnectDb();
        JasperDesign jasperDesign = JRXmlLoader.load("Till2.jrxml");
        String sql = "select * from totals11";
        JRDesignQuery newQuery = new JRDesignQuery();
        newQuery.setText(sql);
        jasperDesign.setQuery(newQuery);
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);   
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, conn);
        //JasperViewer.viewReport(jasperPrint,false);
        JasperPrintManager.printReport(jasperPrint,false);
          
        
    } catch (Exception e){
        JOptionPane.showMessageDialog(null, e);
    }
         finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
         }
        try {
            DropTotals1();
        } catch (SQLException ex) {
            Logger.getLogger(Apex.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            removeitems1();
        } catch (SQLException ex) {
            Logger.getLogger(Apex.class.getName()).log(Level.SEVERE, null, ex);
        }
         
                           
        CreateTotals1();
        // SubtractStock();
         FillInterest1();
        // stop2();
       
        orderid3.setText("");
}
    private void deletetable(){
      Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
        String sql = "delete from Till1 where name = ?";
        // String tmp = (String)jComboBox1.getSelectedItem();
         //if(errormsg.getText()!=""){
          // return;
      /// }
        try {
              if (nameCode.getText().equals("")){
                 // error();
                 // errormsg.setText("PLEASE SELECT DRUG TO UPDATE");
          //  JOptionPane.showMessageDialog(null, "PLEASE SELECT DRUG TO UPDATE"); 
          UIManager UI=new UIManager();
 UI.put("OptionPane.background", Color.white);
 UI.put("Panel.background", Color.white);

  ImageIcon icon = new ImageIcon(getClass().getResource("/icons/error1.png"));
        JOptionPane.showMessageDialog(null, "PLEASE SELECT PRODUCT TO DELETE.",
                "Error", JOptionPane.INFORMATION_MESSAGE, icon);
            return;
              }
            pst = conn.prepareStatement(sql);
            pst.setString(1, nameCode.getText());
            pst.execute();
            //JOptionPane.showMessageDialog(null, "Deleted");
            UpdateJTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
        }
       // deleteinvoice();
        SumTotal();
CountRecords();
nameCode.setText("");
}
     private void deletetable1(){
      Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
        String sql = "delete from Till2 where name = ?";
        // String tmp = (String)jComboBox1.getSelectedItem();
        // if(errormsg.getText().toString()!=""){
          // return;
       //}
        try {
              if (nameCode1.getText().equals("")){
                 // error();
                 // errormsg.setText("PLEASE SELECT DRUG TO DELETE");
           // JOptionPane.showMessageDialog(null, "PLEASE SELECT DRUG TO DELETE"); 
           UIManager UI=new UIManager();
 UI.put("OptionPane.background", Color.white);
 UI.put("Panel.background", Color.white);

  ImageIcon icon = new ImageIcon(getClass().getResource("/icons/error1.png"));
        JOptionPane.showMessageDialog(null, "PLEASE SELECT PRODUCT TO DELETE.",
                "Error", JOptionPane.INFORMATION_MESSAGE, icon);
            return;
              }
            pst = conn.prepareStatement(sql);
            pst.setString(1, nameCode1.getText());
            pst.execute();
            //JOptionPane.showMessageDialog(null, "Deleted");
            UpdateJTable1();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
        }
       // deleteinvoice();
        SumTotal1();
CountRecords1();
nameCode1.setText("");
}
private void clear(){
    try {
            DropTable();
        } catch (SQLException ex) {
            Logger.getLogger(Apex.class.getName()).log(Level.SEVERE, null, ex);
        }
        Create();
        UpdateJTable();
        try {
            removeitems();
            
        } catch (SQLException ex) {
            Logger.getLogger(Apex.class.getName()).log(Level.SEVERE, null, ex);
        }
}
private void clear1(){
    try {
            DropTable1();
        } catch (SQLException ex) {
            Logger.getLogger(Apex.class.getName()).log(Level.SEVERE, null, ex);
        }
        Create1();
        UpdateJTable1();
        try {
            removeitems1();
            
        } catch (SQLException ex) {
            Logger.getLogger(Apex.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    private void quantityFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityFieldKeyPressed
        // TODO add your handling code here:
       // if(errormsg.getText().toString()!=""){
          //  return;
       // }
      // orderinsert3();
      
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        conn = mysqlconnect.ConnectDb();
        StringBuilder warnings = new StringBuilder();
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
           // invoicegen();
            orderinsert3();
            String sql = "insert into Till1 (name, quantity, price, orderid,salesuser,orderdate,customername) values(?, ?, ?, ?, ?,?,?) ";
            //Statement.RETURN_GENERATED_KEYS);

        String tmp = (String) nameCombo.getSelectedItem();
        String tmp1 = (String) customerCombo.getSelectedItem();

        try {
            pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            // pst.setString(1,customerid.getText());
            pst.setString(1, tmp);
            pst.setString(2, quantityField.getText());
            if (quantityField.getText().startsWith("0")){
               // error();
               // errormsg.setText("PLEASE ENTER A VALID QUANTITY");
               //JOptionPane.showMessageDialog(null, "PLEASE ENTER A VALID QUANTITY");
              //JOptionPane.showMessageDialog(null, "Java Technolgy Dive Log", "Dive", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("icons/gh.png"));
 UIManager UI=new UIManager();
 UI.put("OptionPane.background", Color.white);
 UI.put("Panel.background", Color.white);

  ImageIcon icon = new ImageIcon(getClass().getResource("/icons/error1.png"));
        JOptionPane.showMessageDialog(null, "PLEASE ENTER A VALID QUANTITY.",
                "Error", JOptionPane.INFORMATION_MESSAGE, icon);

                return;
            }
            if (quantityField.getText().isEmpty()){
               // error();
               // errormsg.setText("PLEASE ENTER QUANTITY");
                //JOptionPane.showMessageDialog(null, "PLEASE ENTER QUANTITY");
                 UIManager UI=new UIManager();
 UI.put("OptionPane.background", Color.white);
 UI.put("Panel.background", Color.white);

  ImageIcon icon = new ImageIcon(getClass().getResource("/icons/error1.png"));
        JOptionPane.showMessageDialog(null, "PLEASE ENTER QUANTITY.",
                "Error", JOptionPane.INFORMATION_MESSAGE, icon);
                return;
            }
            //else
            //pst.setString(5, tmp1);
            // if (orderid.getText().isEmpty()){
                pst.setString(4, orderid2.getText());
                // }
            //else{
                //pst.setString(4, orderid.getText());
                // }
            pst.setString(3, pricefortable.getText());
            if (nameCombo.getSelectedItem().toString() == ""){
                // } catch (Exception e) {
                // error();
                //errormsg.setText("PLEASE SELECT DRUG");
                //JOptionPane.showMessageDialog(null, "PLEASE SELECT DRUG");
                 UIManager UI=new UIManager();
 UI.put("OptionPane.background", Color.white);
 UI.put("Panel.background", Color.white);

  ImageIcon icon = new ImageIcon(getClass().getResource("/icons/error1.png"));
        JOptionPane.showMessageDialog(null, "PLEASE SELECT DRUG.",
                "Error", JOptionPane.INFORMATION_MESSAGE, icon);
                return;
            }

            // if (customer.getText().toString() ==""){
                pst.setString(5, salesLabel.getText());
                pst.setTimestamp(6, getCurrentDate());
                pst.setString(7, tmp1);
                /*int result = Integer.parseInt(instocklabel.getText());
                int quantity = Integer.parseInt(quantityField.getText());
                if (instocklabel.getText().equals("0") ){
                    JOptionPane.showMessageDialog(null, "DRUG OUT OF STOCK");
                    return;
                }
                if (result < 0 ){
                    JOptionPane.showMessageDialog(null, "DRUG OUT OF STOCK");
                    return;
                }
                if (quantity > result){
                    JOptionPane.showMessageDialog(null, "QUANTITY SELECTED IS MORE THAN STOCK");
                    return;
                }*/
                pst.execute();
                //  insertInstock();
                DbUtils.closeQuietly(pst);

               // interest();
 interest();
                Amount();
                // insertInvoice();
                Amount2();
               
                
                quantityField.setText("");
                nameCombo.setSelectedItem("");
                //nameCode.setText("");
                // stopstock();
              //  invoicenorminsert();
                UpdateJTable();

                SumTotal3();
                CountRecords();
                nameCombo.requestFocusInWindow();

                //JOptionPane.showMessageDialog(null, "Please Select a Customer");
                // Totals();

                //customerInput();
                //insertInvoice();
                //nameCombo.requestFocusInWindow();
            //} catch (Exception e) {
              //  JOptionPane.showMessageDialog(null, e);
           // }
            } catch (SQLException e) {
             if (e.getSQLState().startsWith("23")){
            
          // JOptionPane.showMessageDialog(null, "DUPLICATE PRODUCT");
                  
                  UIManager UI=new UIManager();
 UI.put("OptionPane.background", Color.white);
 UI.put("Panel.background", Color.white);

  ImageIcon icon = new ImageIcon(getClass().getResource("/icons/error1.png"));
        JOptionPane.showMessageDialog(null, "DUPLICATE PRODUCT.",
                "Error", JOptionPane.INFORMATION_MESSAGE, icon);
        return;
            
            }
            }catch (Exception e) {
               JOptionPane.showMessageDialog(null, e); 
            }

        finally{
            DbUtils.closeQuietly(rs);
            DbUtils.closeQuietly(pst);
            DbUtils.closeQuietly(conn);

        }

        }
    }//GEN-LAST:event_quantityFieldKeyPressed
private void insertInstock(){
    Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
String sql = "insert into instocktemp (name,stock) values (?,?)";
String tmp = (String) nameCombo.getSelectedItem();
 try {
            pst = conn.prepareStatement(sql);
       // pst.setString(1, tmp);

            pst.setString(1, tmp);
            pst.setString(2, quantityField.getText());
            pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
    }   
}
    private void tableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMousePressed
        // TODO add your handling code here:
       tableselect();
    }//GEN-LAST:event_tableMousePressed

    private void nameComboPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_nameComboPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
       // invoicegen();
        productsearch();
    }//GEN-LAST:event_nameComboPopupMenuWillBecomeInvisible

    private void savepanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_savepanel1MouseEntered
        // TODO add your handling code here:
        savepanel1.setEnabled(true);
        savepanel1.setVisible(true);
        
    }//GEN-LAST:event_savepanel1MouseEntered

    private void refreshclick1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshclick1MouseExited
        // TODO add your handling code here:
         refreshpanelview1.setEnabled(false);
        refreshpanelview1.setVisible(false);
    }//GEN-LAST:event_refreshclick1MouseExited

    private void refreshclick1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshclick1MouseEntered
        // TODO add your handling code here:
        refreshpanelview1.setEnabled(true);
        refreshpanelview1.setVisible(true);
    }//GEN-LAST:event_refreshclick1MouseEntered

    private void userclick1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userclick1MouseExited
        // TODO add your handling code here:
        userpanelview1.setEnabled(false);
        userpanelview1.setVisible(false);
    }//GEN-LAST:event_userclick1MouseExited

    private void userclick1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userclick1MouseEntered
        // TODO add your handling code here:
        userpanelview1.setEnabled(true);
        userpanelview1.setVisible(true);
    }//GEN-LAST:event_userclick1MouseEntered

    private void tilloneclick1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tilloneclick1MouseExited
        // TODO add your handling code here:
         tillonepanelview1.setEnabled(false);
        tillonepanelview1.setVisible(false);
    }//GEN-LAST:event_tilloneclick1MouseExited

    private void tilloneclick1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tilloneclick1MouseEntered
        // TODO add your handling code here:
        tillonepanelview1.setEnabled(true);
        tillonepanelview1.setVisible(true);
    }//GEN-LAST:event_tilloneclick1MouseEntered

    private void invoiceclick1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invoiceclick1MouseExited
        // TODO add your handling code here:
         invoicepanelview1.setEnabled(false);
        invoicepanelview1.setVisible(false);
    }//GEN-LAST:event_invoiceclick1MouseExited

    private void invoiceclick1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invoiceclick1MouseEntered
        // TODO add your handling code here:
        invoicepanelview1.setEnabled(true);
        invoicepanelview1.setVisible(true);
    }//GEN-LAST:event_invoiceclick1MouseEntered

    private void tilltwoclick1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tilltwoclick1MouseExited
        // TODO add your handling code here:
        tilltwopanelview1.setEnabled(false);
        tilltwopanelview1.setVisible(false);
    }//GEN-LAST:event_tilltwoclick1MouseExited

    private void tilltwoclick1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tilltwoclick1MouseEntered
        // TODO add your handling code here:
        tilltwopanelview1.setEnabled(true);
        tilltwopanelview1.setVisible(true);
    }//GEN-LAST:event_tilltwoclick1MouseEntered

    private void deletebutt1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletebutt1MouseExited
        // TODO add your handling code here:
        deletepanel1.setEnabled(false);
        deletepanel1.setVisible(false);
    }//GEN-LAST:event_deletebutt1MouseExited

    private void deletebutt1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletebutt1MouseEntered
        // TODO add your handling code here:
        deletepanel1.setEnabled(true);
        deletepanel1.setVisible(true);
    }//GEN-LAST:event_deletebutt1MouseEntered

    private void clearbutt1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearbutt1MouseExited
        // TODO add your handling code here:
         clearpanel1.setEnabled(false);
        clearpanel1.setVisible(false);
    }//GEN-LAST:event_clearbutt1MouseExited

    private void clearbutt1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearbutt1MouseEntered
        // TODO add your handling code here:
        clearpanel1.setEnabled(true);
        clearpanel1.setVisible(true);
    }//GEN-LAST:event_clearbutt1MouseEntered

    private void updatebutt1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatebutt1MouseExited
        // TODO add your handling code here:
          updatepanel1.setEnabled(false);
        updatepanel1.setVisible(false);
    }//GEN-LAST:event_updatebutt1MouseExited

    private void updatebutt1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatebutt1MouseEntered
        // TODO add your handling code here:
        updatepanel1.setEnabled(true);
        updatepanel1.setVisible(true);
    }//GEN-LAST:event_updatebutt1MouseEntered

    private void savebutton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_savebutton1MouseExited
        // TODO add your handling code here:
         savepanel1.setEnabled(false);
        savepanel1.setVisible(false);
    }//GEN-LAST:event_savebutton1MouseExited

    private void savebutton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_savebutton1MouseEntered
        // TODO add your handling code here:
        savepanel1.setEnabled(true);
        savepanel1.setVisible(true);
    }//GEN-LAST:event_savebutton1MouseEntered

    private void printbutt1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printbutt1MouseExited
        // TODO add your handling code here:
         printpanelview1.setEnabled(false);
        printpanelview1.setVisible(false);
    }//GEN-LAST:event_printbutt1MouseExited

    private void printbutt1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printbutt1MouseEntered
        // TODO add your handling code here:
        printpanelview1.setEnabled(true);
        printpanelview1.setVisible(true);
    }//GEN-LAST:event_printbutt1MouseEntered

    private void quantityField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityField1KeyPressed
      //  if(errormsg.getText().toString()!=""){
           // return;
       // }
        // orderinsert4();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        conn = mysqlconnect.ConnectDb();
        StringBuilder warnings = new StringBuilder();
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
           // invoicegen1();
            orderinsert4();
            String sql = "insert into Till2 (name, quantity, price, orderid,salesuser,orderdate,customername) values(?, ?, ?, ?, ?,?,?) ";
            //Statement.RETURN_GENERATED_KEYS);

        String tmp = (String) nameCombo1.getSelectedItem();
        String tmp1 = (String) customerCombo1.getSelectedItem();

        try {
            pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            // pst.setString(1,customerid.getText());
            pst.setString(1, tmp);
            pst.setString(2, quantityField1.getText());
            if (quantityField1.getText().startsWith("0")){
              //  error();
                //errormsg.setText("PLEASE ENTER A VALID QUANTITY");
               //JOptionPane.showMessageDialog(null, "PLEASE ENTER A VALID QUANTITY");
                UIManager UI=new UIManager();
 UI.put("OptionPane.background", Color.white);
 UI.put("Panel.background", Color.white);

  ImageIcon icon = new ImageIcon(getClass().getResource("/icons/error1.png"));
        JOptionPane.showMessageDialog(null, "PLEASE ENTER A VALID QUANTITY.",
                "Error", JOptionPane.INFORMATION_MESSAGE, icon);
                return;
            }
            if (quantityField1.getText().isEmpty()){
                 //error();
                //errormsg.setText("PLEASE ENTER QUANTITY");
                //JOptionPane.showMessageDialog(null, "PLEASE ENTER QUANTITY");
                 UIManager UI=new UIManager();
 UI.put("OptionPane.background", Color.white);
 UI.put("Panel.background", Color.white);

  ImageIcon icon = new ImageIcon(getClass().getResource("/icons/error1.png"));
        JOptionPane.showMessageDialog(null, "PLEASE ENTER QUANTITY.",
                "Error", JOptionPane.INFORMATION_MESSAGE, icon);
                return;
            }
            //else
            //pst.setString(5, tmp1);
            // if (orderid.getText().isEmpty()){
                pst.setString(4, orderid3.getText());
                // }
            //else{
                //pst.setString(4, orderid.getText());
                // }
            pst.setString(3, pricefortable1.getText());
            if (nameCombo1.getSelectedItem().toString() == ""){
                // } catch (Exception e) {
               //  error();
               // errormsg.setText("PLEASE SELECT DRUG");
              // JOptionPane.showMessageDialog(null, "PLEASE SELECT DRUG");
               UIManager UI=new UIManager();
 UI.put("OptionPane.background", Color.white);
 UI.put("Panel.background", Color.white);

  ImageIcon icon = new ImageIcon(getClass().getResource("/icons/error1.png"));
        JOptionPane.showMessageDialog(null, "PLEASE SELECT PRODUCT.",
                "Error", JOptionPane.INFORMATION_MESSAGE, icon);
                return;
            }

            // if (customer.getText().toString() ==""){
                pst.setString(5, salesLabel1.getText());
                pst.setTimestamp(6, getCurrentDate());
                pst.setString(7, tmp1);
                /*int result = Integer.parseInt(instocklabel.getText());
                int quantity = Integer.parseInt(quantityField.getText());
                if (instocklabel.getText().equals("0") ){
                    JOptionPane.showMessageDialog(null, "DRUG OUT OF STOCK");
                    return;
                }
                if (result < 0 ){
                    JOptionPane.showMessageDialog(null, "DRUG OUT OF STOCK");
                    return;
                }
                if (quantity > result){
                    JOptionPane.showMessageDialog(null, "QUANTITY SELECTED IS MORE THAN STOCK");
                    return;
                }*/
                pst.execute();
                //  insertInstock();
                DbUtils.closeQuietly(pst);

               interest1();

                Amount1();
                // insertInvoice();
                //interest2();
               // Amount2();
                quantityField1.setText("");
                nameCombo1.setSelectedItem("");
                //nameCode.setText("");
                // stopstock();
                UpdateJTable1();

                SumTotal4();
                CountRecords1();
                nameCombo1.requestFocusInWindow();

                //JOptionPane.showMessageDialog(null, "Please Select a Customer");
                // Totals();

                //customerInput();
                //insertInvoice();
                //nameCombo.requestFocusInWindow();
            } catch (Exception e) {
              // error();
               // errormsg.setText("PRODUCT IS ALREADY IN QUEUE");
                  
               // JOptionPane.showMessageDialog(null, "DUPLICATE PRODUCT");
                UIManager UI=new UIManager();
 UI.put("OptionPane.background", Color.white);
 UI.put("Panel.background", Color.white);

  ImageIcon icon = new ImageIcon(getClass().getResource("/icons/error1.png"));
        JOptionPane.showMessageDialog(null, "DUPLICATE PRODUCT.",
                "Error", JOptionPane.INFORMATION_MESSAGE, icon);
            }
            // } catch (SQLException e) {
            // if (e.getSQLState().startsWith("23"))
            // JOptionPane.showMessageDialog(null, "Duplicate");
            // JOptionPane.showMessageDialog(null, "Product is already in Queue PLEASE USE UPDATE Button");

            // }

        finally{
            DbUtils.closeQuietly(rs);
            DbUtils.closeQuietly(pst);
            DbUtils.closeQuietly(conn);

        }

        }
    }//GEN-LAST:event_quantityField1KeyPressed

    private void table1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MousePressed
        // TODO add your handling code here:
        tableselect1();
    }//GEN-LAST:event_table1MousePressed

    private void nameCombo1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_nameCombo1PopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        productsearch1();
    }//GEN-LAST:event_nameCombo1PopupMenuWillBecomeInvisible

    private void tilloneclick1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tilloneclick1MousePressed
 start();
        panelremove();
        settingson.setEnabled(true);
        settingson.setVisible(true);
    }//GEN-LAST:event_tilloneclick1MousePressed

    private void tilltwoclick1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tilltwoclick1MousePressed
        // TODO add your handling code here:
        start2();
        panelremove2();
    }//GEN-LAST:event_tilltwoclick1MousePressed

    private void updatebuttMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatebuttMousePressed
        // TODO add your handling code here:
        updatetable();
    }//GEN-LAST:event_updatebuttMousePressed

    private void deletebuttMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletebuttMousePressed
        // TODO add your handling code here:
        deletetable();
    }//GEN-LAST:event_deletebuttMousePressed

    private void clearbuttMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearbuttMousePressed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_clearbuttMousePressed

    private void printbuttMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printbuttMousePressed
      if ((customer.getText().equals("") && customerCombo.getSelectedItem().toString().equals(""))){
          // error();
          // errormsg.setText("PLEASE ENTER CUSTOMER NAME");
           
 //JOptionPane.showMessageDialog(null, "PLEASE ENTER CUSTOMER NAME");
 UIManager UI=new UIManager();
 UI.put("OptionPane.background", Color.white);
 UI.put("Panel.background", Color.white);

  ImageIcon icon = new ImageIcon(getClass().getResource("/icons/error1.png"));
        JOptionPane.showMessageDialog(null, "PLEASE ENTER CUSTOMER NAME.",
                "Error", JOptionPane.INFORMATION_MESSAGE, icon);
   return;
      }
        try {
            // TODO add your handling code here:
            print();
        } catch (SQLException ex) {
            Logger.getLogger(Apex.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_printbuttMousePressed

    private void nameCombo2PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_nameCombo2PopupMenuWillBecomeInvisible
        // TODO add your handling code here:
       productsearchinvoice();
    }//GEN-LAST:event_nameCombo2PopupMenuWillBecomeInvisible

    private void table2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table2MousePressed
       tableselect2();
    }//GEN-LAST:event_table2MousePressed

    private void quantityField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityField2KeyPressed
        // TODO add your handling code here:
         Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
Statement stmt =null;
        conn = mysqlconnect.ConnectDb();
        // if(errormsg.getText().toString()!=""){
          // return;
      // }
          if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
          String sql = "insert into invoicesales (name, quantity, price, orderid, customername, salesuser,orderdate) values(?, ?, ?, ?, ?, ?,?) ";
           //Statement.RETURN_GENERATED_KEYS);     
   String tmp = (String)nameCombo2.getSelectedItem();
   String tmp1 = (String)custCombo.getSelectedItem();
  
    try{
        pst = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
       // pst.setString(1,customerid.getText());
        pst.setString(1, tmp);
        
    
        pst.setString(2, quantityField2.getText());
        if (quantityField2.getText().startsWith("0")){
               // error();
               // errormsg.setText("PLEASE ENTER A VALID QUANTITY");
              //  JOptionPane.showMessageDialog(null, "PLEASE ENTER A VALID QUANTITY");
               UIManager UI=new UIManager();
 UI.put("OptionPane.background", Color.white);
 UI.put("Panel.background", Color.white);

  ImageIcon icon = new ImageIcon(getClass().getResource("/icons/error1.png"));
        JOptionPane.showMessageDialog(null, "PLEASE ENTER A VALID QUANTITY.",
                "Error", JOptionPane.INFORMATION_MESSAGE, icon);
                return;
            }
        if (quantityField2.getText().isEmpty()){
                //error();
                //errormsg.setText("PLEASE ENTER QUANTITY");
               // JOptionPane.showMessageDialog(null, "PLEASE ENTER QUANTITY");
                 UIManager UI=new UIManager();
 UI.put("OptionPane.background", Color.white);
 UI.put("Panel.background", Color.white);

  ImageIcon icon = new ImageIcon(getClass().getResource("/icons/error1.png"));
        JOptionPane.showMessageDialog(null, "PLEASE ENTER QUANTITY.",
                "Error", JOptionPane.INFORMATION_MESSAGE, icon);
                return;
            }
        
        //pst.setString(4, txtage.getText());=
        pst.setString(3,pricefortable2.getText());
         if (nameCombo2.getSelectedItem().toString() == ""){
                  // } catch (Exception e) { 
            // error();
           //  errormsg.setText("PLEASE ENTER PRODUCT");
               // JOptionPane.showMessageDialog(null, "PLEASE ENTER PRODUCT"); 
                UIManager UI=new UIManager();
 UI.put("OptionPane.background", Color.white);
 UI.put("Panel.background", Color.white);

  ImageIcon icon = new ImageIcon(getClass().getResource("/icons/error1.png"));
        JOptionPane.showMessageDialog(null, "PLEASE SELECT PRODUCT.",
                "Error", JOptionPane.INFORMATION_MESSAGE, icon);
        return;
                }
         else
        pst.setString(4,orderid.getText());
        pst.setString(5,tmp1);
         pst.setString(6,salesLabel2.getText());
          pst.setTimestamp(7, getCurrentDate());
        pst.execute(); 
        interestinvoice();
        Amountinvoice();
       insertInvoice2();
       invoicenorminsert2();
       updateamountnorm();
     //  interest2();
       Amount2invoice();
       quantityField2.setText("");
    nameCombo2.setSelectedItem("");
        UpdateJTable2();
        //insertInvoice();
    SumTotal3invoice();
    CountRecordsinvoice();
              nameCombo2.requestFocusInWindow();  
            } catch (SQLException e) {
                if (e.getSQLState().startsWith("23")) {
                         //JOptionPane.showMessageDialog(null, "DUPLICATE PRODUCT");
                         // error();
             //errormsg.setText("PRODUCT IS ALREADY IN QUEUE");
         // JOptionPane.showMessageDialog(null, "Product is already in Queue PLEASE USE UPDATE Button");
                  //JOptionPane.showMessageDialog(null, "Please Select a Customer");
                   UIManager UI=new UIManager();
 UI.put("OptionPane.background", Color.white);
 UI.put("Panel.background", Color.white);

  ImageIcon icon = new ImageIcon(getClass().getResource("/icons/error1.png"));
        JOptionPane.showMessageDialog(null, "DUPLICATE PRODUCT.",
                "Error", JOptionPane.INFORMATION_MESSAGE, icon);
                }
            }
              finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
                            
                          
    }                
    }                                    
    }//GEN-LAST:event_quantityField2KeyPressed
private void insertInvoice2(){
      Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
Statement stmt =null;
      conn= mysqlconnect.ConnectDb();
   String sql = "insert into invoice (orderid, orderdate, productname, quantity, price, customername, salesuser) values (?,?,?,?,?,?,?)";
         
  String tmp = (String)nameCombo2.getSelectedItem();
 //String tmp1 = (String)customerCombo.getSelectedItem();
  try{
        pst = conn.prepareStatement(sql);
       // pst.setString(1, tmp);
    
       pst.setString(1, orderid.getText());
       pst.setTimestamp(2, getCurrentDate());
        pst.setString(3,tmp);
       pst.setString(4, quantityField2.getText());
        pst.setString(5,priceLabel2.getText());
        pst.setString(6,custName.getText());
        pst.setString(7,salesLabel2.getText());
        pst.execute();
       
       // UpdateJTable();
    } catch (Exception e){
       JOptionPane.showMessageDialog(null, e);
    } 
  finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
                        }    
 }

private void updateamountnorm(){
      Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
  String sql = "update amountinvoice inner join quantityinvoice on amountinvoice.name= quantityinvoice.name and amountinvoice.orderid= quantityinvoice.orderid inner join priceinvoice on amountinvoice.name= priceinvoice.name and amountinvoice.orderid= priceinvoice.orderid set amount = ROUND(quantityinvoice.quantity*priceinvoice.price,2) where amountinvoice.name = ? and amountinvoice.orderid = ?";
  String tmp = (String) nameCombo2.getSelectedItem();
  try {
            pst = conn.prepareStatement(sql);
            pst.setString(1,tmp);
            //pst.setString(1,priceLabel.getText());
         pst.setString(2, orderid.getText());
             pst.execute();   
}
       catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
  finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
                        }      
     }
private void updateamountnorm1(){
      Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
  String sql = "update amountinvoice inner join quantityinvoice on amountinvoice.name= quantityinvoice.name and amountinvoice.orderid= quantityinvoice.orderid inner join priceinvoice on amountinvoice.name= priceinvoice.name and amountinvoice.orderid= priceinvoice.orderid set amount = ROUND(quantityinvoice.quantity*priceinvoice.price,2) where amountinvoice.name = ? and amountinvoice.orderid = ?";
  String tmp = (String) nameCombo2.getSelectedItem();
  try {
            pst = conn.prepareStatement(sql);
            pst.setString(1,nameCode2.getText());
            //pst.setString(1,priceLabel.getText());
         pst.setString(2, orderid.getText());
             pst.execute();   
}
       catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
  finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
                        }      
     }
    private void Amount2invoice(){
    Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
Statement stmt =null;
    conn= mysqlconnect.ConnectDb();
  String sql = "update invoice set amount = ROUND(quantity*price,2) where productname = ? and orderid = ?";
 String tmp = (String) nameCombo2.getSelectedItem();
  try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, tmp);
           // pst.setString(1, priceLabel.getText());
            pst.setString(2, orderid.getText());
             pst.execute();   
}
       catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
 finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
                        }    
}
    private void printbutt2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printbutt2MouseEntered
        // TODO add your handling code here:
         printpanelview2.setEnabled(true);
        printpanelview2.setVisible(true);
    }//GEN-LAST:event_printbutt2MouseEntered

    private void printbutt2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printbutt2MouseExited
        // TODO add your handling code here:
        printpanelview2.setEnabled(false);
        printpanelview2.setVisible(false);
    }//GEN-LAST:event_printbutt2MouseExited

    private void savebutton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_savebutton2MouseEntered
        // TODO add your handling code here:
        savepanel2.setEnabled(true);
        savepanel2.setVisible(true);
    }//GEN-LAST:event_savebutton2MouseEntered

    private void savebutton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_savebutton2MouseExited
        // TODO add your handling code here:
        savepanel2.setEnabled(false);
        savepanel2.setVisible(false);
    }//GEN-LAST:event_savebutton2MouseExited

    private void updatebutt2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatebutt2MouseEntered
        // TODO add your handling code here:
         updatepanel2.setEnabled(true);
        updatepanel2.setVisible(true);
    }//GEN-LAST:event_updatebutt2MouseEntered

    private void updatebutt2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatebutt2MouseExited
        // TODO add your handling code here:
        updatepanel2.setEnabled(false);
        updatepanel2.setVisible(false);
    }//GEN-LAST:event_updatebutt2MouseExited

    private void clearbutt2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearbutt2MouseEntered
        // TODO add your handling code here:
        clearpanel2.setEnabled(true);
        clearpanel2.setVisible(true);
    }//GEN-LAST:event_clearbutt2MouseEntered

    private void clearbutt2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearbutt2MouseExited
        // TODO add your handling code here:
        clearpanel2.setEnabled(false);
        clearpanel2.setVisible(false);
    }//GEN-LAST:event_clearbutt2MouseExited

    private void deletebutt2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletebutt2MouseEntered
        // TODO add your handling code here:
        deletepanel2.setEnabled(true);
        deletepanel2.setVisible(true);
    }//GEN-LAST:event_deletebutt2MouseEntered

    private void deletebutt2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletebutt2MouseExited
        // TODO add your handling code here:
        deletepanel2.setEnabled(false);
        deletepanel2.setVisible(false);
    }//GEN-LAST:event_deletebutt2MouseExited

    private void tilltwoclick2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tilltwoclick2MouseEntered
        // TODO add your handling code here:invoicepanelview.setEnabled(false);
        tilltwopanelview2.setEnabled(true);
        tilltwopanelview2.setVisible(true);
    }//GEN-LAST:event_tilltwoclick2MouseEntered

    private void tilltwoclick2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tilltwoclick2MouseExited
        // TODO add your handling code here:
        tilltwopanelview2.setEnabled(false);
        tilltwopanelview2.setVisible(false);
    }//GEN-LAST:event_tilltwoclick2MouseExited

    private void tilltwoclick2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tilltwoclick2MousePressed
        // TODO add your handling code here:
        start2();
        panelremove2();
        
    }//GEN-LAST:event_tilltwoclick2MousePressed

    private void invoiceclick2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invoiceclick2MouseEntered
        // TODO add your handling code here:
        invoicepanelview2.setEnabled(true);
        invoicepanelview2.setVisible(true);
    }//GEN-LAST:event_invoiceclick2MouseEntered

    private void invoiceclick2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invoiceclick2MouseExited
        // TODO add your handling code here:
        invoicepanelview2.setEnabled(false);
        invoicepanelview2.setVisible(false);
    }//GEN-LAST:event_invoiceclick2MouseExited

    private void tilloneclick2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tilloneclick2MouseEntered
        // TODO add your handling code here:
        tillonepanelview2.setEnabled(true);
        tillonepanelview2.setVisible(true);
    }//GEN-LAST:event_tilloneclick2MouseEntered

    private void tilloneclick2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tilloneclick2MouseExited
        // TODO add your handling code here:
        tillonepanelview2.setEnabled(false);
        tillonepanelview2.setVisible(false);
    }//GEN-LAST:event_tilloneclick2MouseExited

    private void tilloneclick2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tilloneclick2MousePressed
        // TODO add your handling code here:
        start();
        panelremove();
        settingson.setEnabled(true);
        settingson.setVisible(true);
    }//GEN-LAST:event_tilloneclick2MousePressed

    private void userclick2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userclick2MouseEntered
        // TODO add your handling code here:
         userpanelview2.setEnabled(true);
        userpanelview2.setVisible(true);
    }//GEN-LAST:event_userclick2MouseEntered

    private void userclick2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userclick2MouseExited
        // TODO add your handling code here:
        userpanelview2.setEnabled(false);
        userpanelview2.setVisible(false);
    }//GEN-LAST:event_userclick2MouseExited

    private void refreshclick2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshclick2MouseEntered
        // TODO add your handling code here:
        refreshpanelview2.setEnabled(true);
        refreshpanelview2.setVisible(true);
    }//GEN-LAST:event_refreshclick2MouseEntered

    private void refreshclick2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshclick2MouseExited
        // TODO add your handling code here:
        refreshpanelview2.setEnabled(false);
        refreshpanelview2.setVisible(false);
    }//GEN-LAST:event_refreshclick2MouseExited

    private void savepanel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_savepanel2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_savepanel2MouseEntered

    private void custComboPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_custComboPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
         Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
Statement stmt =null;
            conn = mysqlconnect.ConnectDb();
        String sql = " select  ordersinvoice.orderid, ordersinvoice.orderdate, productinvoice.name,custinvoice.customername from ordersinvoice  left join productinvoice  on ordersinvoice.id= productinvoice.id  left join custinvoice on ordersinvoice.id= custinvoice.id   where custinvoice.customername = ?  order by ordersinvoice.id desc";
        String tmp = (String)custCombo.getSelectedItem();
    gui2.setIcon(new ImageIcon(getClass().getResource("/images/invoice2.png")));
        try{
        pst = conn.prepareStatement(sql);
        pst.setString(1, tmp);
        rs = pst.executeQuery();
        table2.setModel(new salestablemodel11(rs));
        setJTableColumnsWidth(table2, 480, 10,30,40,20);
           table2.setRowHeight(30);    

         }
    catch (Exception e){
        JOptionPane.showMessageDialog(null, e);
    }
    finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
                        }    
        
      custCombo.transferFocus();
      orderField.setText("");
      custName.setText("");
      orderid.setText("");
      orderField.requestFocusInWindow();
      sumtotal2.setText("");
      count2.setText("");
     
              
    }//GEN-LAST:event_custComboPopupMenuWillBecomeInvisible
private void DropSearch() throws SQLException{
    Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
Statement stmt =null;  
    
    try {
     conn= mysqlconnect.ConnectDb();
      stmt = conn.createStatement();
      stmt.executeUpdate(DROP_INVOICETABLE);
  }
  catch (Exception e){
        JOptionPane.showMessageDialog(null, e);
}
  finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
                        }    
}
private void UpdateJTable2(){
      Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
Statement stmt =null;
      conn= mysqlconnect.ConnectDb();
    String sql = "select name, quantity, price, amount from invoicesales";
    try{
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        table2.setModel(new salestablemodelold(rs));
         setJTableColumnsWidth(table2, 480, 70, 10, 10, 10);
         table2.setRowHeight(30);
       // jTable1.setModel(DbUtils.resultSetToTableModel(rs));
    }
    catch (Exception e){
        JOptionPane.showMessageDialog(null, e);
    }
   finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
                        }    
}  
    private void editButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editButtonMousePressed
        // TODO add your handling code here:
         try {
        // TODO add your handling code here:
        
        DropSearch();
    } catch (SQLException ex) {
        Logger.getLogger(Apex.class.getName()).log(Level.SEVERE, null, ex);
       
    }
    Createinvoice();
    editbutton();
   //  ImageIcon image = new ImageIcon("images/Salesnew.png");
    // gui2.setIcon(image);
   gui2.setIcon(new ImageIcon(getClass().getResource("/images/invoicenew.png")));
   Labeldisplay2();
    Labeldisplay();
    UpdateJTable2();
    SumTotal3invoice();
    CountRecordsinvoice();
     quantityField2.setEnabled(true);
      quantityField2.setVisible(true);
    }//GEN-LAST:event_editButtonMousePressed
private void removeinvoiceitems(){
    try {
        // TODO add your handling code here:
        
        DropSearch();
    } catch (SQLException ex) {
        Logger.getLogger(Apex.class.getName()).log(Level.SEVERE, null, ex);
       
    }  
    Createinvoice();
    UpdateJTable2();
    quantityField2.setText("");
    orderid.setText("");
    orderField.setText("");
    custCombo.setSelectedItem("");
    custName.setText("");
    nameCombo2.setSelectedItem("");
    sumtotal2.setText("");
}
private void iforgot(){
     Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
         String tmp = (String) invoicepercentage.getSelectedItem();
    String sql = "update invoicesales set price = ROUND((price* ?/? + price),2) where orderid = ? ";
    try {
            pst = conn.prepareStatement(sql);
           // pst.setString(1, priceLabel.getText());
            pst.setString(1, tmp);
            pst.setString(2, percenlabel2.getText());
           // pst.setString(4, priceLabel.getText());
            pst.setString(3, orderid.getText());
             pst.execute();   
}
       catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            
            
        }
    finally{
           DbUtils.closeQuietly(rs);
           DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
                                           
       }
    Amount6();
    invoicenormupdate();
   // Amount7();
    SumTotal3invoice();
    //SumTotal2();
    UpdateJTable2();
}
private void Amount7(){
   // String name1= invoicebox.getSelectedItem().toString();
  String sql = "update amountinvoice set amount = ROUND(quantity*price,2) where  orderid = ?";
  Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
  try {
            pst = conn.prepareStatement(sql);
           // pst.setString(2, nameLabel.getText());
           // pst.setString(1, priceLabel.getText());
            pst.setString(1, orderid.getText());
             pst.execute();   
}
       catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
  finally{
           DbUtils.closeQuietly(rs);
           DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
                                           
            }
}
private void Amount6(){
    String sql = "update invoicesales set amount = ROUND(quantity*price,2) where orderid = ?";
    Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
    try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, orderid.getText());
            //pst.setString(2, sumtotal.getText());
             pst.execute();   
    }
       catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    finally{
           DbUtils.closeQuietly(rs);
           DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
                                           
            }
   }
private void timer(){
    Apex frame = new Apex();
   // frame.setVisible( true );
    Action logout = new AbstractAction()
{
    public void actionPerformed(ActionEvent e)
    {
       Apex frame = (Apex)e.getSource();
        dispose();
        Apex s = new Apex();
            s.setVisible(true);
    }
        };
  //  InactivityListener listener = new InactivityListener(frame, logout, 1);
//listener.start();
}
    private void printbutt2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printbutt2MousePressed
        // TODO add your handling code here:
         Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
Statement stmt =null;
           conn = mysqlconnect.ConnectDb();
        Totals2();
       // invoicenorminsert2();
        //Totalsset();
         try{
        JasperDesign jasperDesign = JRXmlLoader.load("invoice.jrxml");
        String sql = "select * from totals111";
        JRDesignQuery newQuery = new JRDesignQuery();
        newQuery.setText(sql);
        jasperDesign.setQuery(newQuery);
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);   
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, conn);
       // JasperViewer.viewReport(jasperPrint,false);
        JasperPrintManager.printReport(jasperPrint,false);
       // removeitems();
        
    } catch (Exception e){
        JOptionPane.showMessageDialog(null, e);
    }
         finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
                        }    
   try {  
        DropTotalsinvoice();
    } catch (SQLException ex) {
        Logger.getLogger(Apex.class.getName()).log(Level.SEVERE, null, ex);
    }
   
     CreateTotalsinvoice(); 
   removeinvoiceitems();
    
   // stop2();
    }//GEN-LAST:event_printbutt2MousePressed

    private void updatebutt2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatebutt2MousePressed
        // TODO add your handling code here:
         Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
Statement stmt =null;
 
        conn = mysqlconnect.ConnectDb();
          String sql = "update invoicesales set  quantity = ? where name = ? ";
       // String tmp = (String) nameCombo.getSelectedItem();
        try {
            pst = conn.prepareStatement(sql);
        //pst.setString(1, txtname.getText());
            //pst.setString(2, txtage.getText());
            if (nameCode2.getText().equals("")){
                 error();
                 errormsg.setText("PLEASE SELECT DRUG TO UPDATE");
                 return;
 }
            if (quantityField2.getText().equals("")){
                 error();
                 errormsg.setText("PLEASE SET QUANTITY ");
                 return;
            }
            pst.setString(1, quantityField2.getText());
           //pst.setString(2, priceLabel.getText());
            pst.setString(2, nameCode2.getText());
            pst.executeUpdate();
           UpdateAmountinvoice();
            UpdateInvoice();
            UpdateAmount2();
            UpdateInvoicenorm();
            updateamountnorm1();
        SumTotal3invoice();
            // JOptionPane.showMessageDialog(null, "Updated");
            UpdateJTable2();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
             
            
        }
        finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
                        }    
quantityField2.setText("");
nameCode2.setText("");
    }//GEN-LAST:event_updatebutt2MousePressed

    private void deletebutt2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletebutt2MousePressed
        // TODO add your handling code here:
        Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
Statement stmt =null;
        conn = mysqlconnect.ConnectDb();
         String sql = "delete from invoicesales where name = ?";
        // String tmp = (String)jComboBox1.getSelectedItem();
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, nameCode2.getText());
            pst.execute();
            //JOptionPane.showMessageDialog(null, "Deleted");
            UpdateJTable2();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
                        }    
        deleteinvoice();
        deleteinvoicenorm();
        SumTotal3invoice();
CountRecordsinvoice();
 
    }//GEN-LAST:event_deletebutt2MousePressed

    private void invoiceclick2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invoiceclick2MousePressed
        // TODO add your handling code here:
        start3();
        panelremove3();
    }//GEN-LAST:event_invoiceclick2MousePressed

    private void refreshbuttMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshbuttMousePressed
        // TODO add your handling code here:
        FillCombo();
        nameCombo.setSelectedItem("");
    }//GEN-LAST:event_refreshbuttMousePressed

    private void refreshbutt1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshbutt1MousePressed
        // TODO add your handling code here:
        FillCombo1();
        nameCombo1.setSelectedItem("");
    }//GEN-LAST:event_refreshbutt1MousePressed

    private void refreshbutt2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshbutt2MousePressed
        // TODO add your handling code here:
        FillCombo2();
        nameCombo2.setSelectedItem("");
    }//GEN-LAST:event_refreshbutt2MousePressed

    private void updatebutt1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatebutt1MousePressed
        // TODO add your handling code here:
        updatetable1();
    }//GEN-LAST:event_updatebutt1MousePressed

    private void customerComboPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_customerComboPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
         Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
        try {
            String tmp = (String) customerCombo.getSelectedItem();
            String sql = "select * from customer where name = ?";

            pst = conn.prepareStatement(sql);
            pst.setString(1, tmp);
            rs = pst.executeQuery();
            if (rs.next()) {
                String add = rs.getString("id");
                customerid.setText(add);
            //String add2 = rs.getString("name");
                // nameCode.setText(add2);
            }
            customerindicator.setText("");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
        }
        customerCombo.transferFocus();
        nameCombo.requestFocusInWindow();
CustomerReplace();
CustomerReplaceInvoice();
        //orderi;nsert();
        //orderiddisplay();
      customer.setText("");
//FillCombo2();

    }//GEN-LAST:event_customerComboPopupMenuWillBecomeInvisible

    private void customerCombo1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_customerCombo1PopupMenuWillBecomeInvisible
        // TODO add your handling code here:
         Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
        try {
            String tmp = (String) customerCombo1.getSelectedItem();
            String sql = "select * from customer where name = ?";

            pst = conn.prepareStatement(sql);
            pst.setString(1, tmp);
            rs = pst.executeQuery();
            if (rs.next()) {
                String add = rs.getString("id");
                customerid1.setText(add);
            //String add2 = rs.getString("name");
                // nameCode.setText(add2);
            }
            customerindicator1.setText("");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
        }
        customerCombo1.transferFocus();
        nameCombo1.requestFocusInWindow();
CustomerReplace1();
CustomerReplaceInvoice1();
        //orderi;nsert();
        //orderiddisplay();
      customer1.setText("");
//FillCombo2();

    }//GEN-LAST:event_customerCombo1PopupMenuWillBecomeInvisible

    private void printbutt1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printbutt1MousePressed
        if ((customer1.getText().equals("") && customerCombo1.getSelectedItem().toString().equals(""))){
            //error();
            //errormsg.setText("PLEASE ENTER CUSTOMER NAME");
            
 //JOptionPane.showMessageDialog(null, "PLEASE ENTER CUSTOMER NAME");
 UIManager UI=new UIManager();
 UI.put("OptionPane.background", Color.white);
 UI.put("Panel.background", Color.white);

  ImageIcon icon = new ImageIcon(getClass().getResource("/icons/error1.png"));
        JOptionPane.showMessageDialog(null, "PLEASE ENTER CUSTOMER NAME.",
                "Error", JOptionPane.INFORMATION_MESSAGE, icon);
   return;
      }
        try {
            // TODO add your handling code here:
            print1();
        } catch (SQLException ex) {
            Logger.getLogger(Apex.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_printbutt1MousePressed

    private void deletebutt1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletebutt1MousePressed
        // TODO add your handling code here:
        deletetable1();
    }//GEN-LAST:event_deletebutt1MousePressed

    private void clearbutt1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearbutt1MousePressed
        // TODO add your handling code here:
        clear1();
    }//GEN-LAST:event_clearbutt1MousePressed

    private void customer1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customer1KeyPressed
        // TODO add your handling code here:
         if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
       customerInput1();  
       FillCombocust1();
        // orderinsert();
        //orderiddisplay();
        
          customerCombo1.requestFocus();
       /* if (customer.getText().toString().equals(""))
            customerCombo.requestFocus();
        else
         customerCombo.setSelectedItem("");
        customerindicator.setText("");*/
        
    }   
        // customerCombo.setSelectedItem("");
    }//GEN-LAST:event_customer1KeyPressed

    private void customerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customerKeyPressed
        // TODO add your handling code here:
         if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
       customerInput();  
       FillCombocust();
        // orderinsert();
        //orderiddisplay();
        
          customerCombo.requestFocus();
       /* if (customer.getText().toString().equals(""))
            customerCombo.requestFocus();
        else
         customerCombo.setSelectedItem("");
        customerindicator.setText("");*/
        
    }   
        // customerCombo.setSelectedItem("");
    }//GEN-LAST:event_customerKeyPressed

    private void quantityFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityFieldKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();        // TODO add your handling code here:
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_quantityFieldKeyTyped

    private void quantityField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityField1KeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();        // TODO add your handling code here:
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_quantityField1KeyTyped

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_headerMousePressed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_headerMouseDragged

    private void mouseDragMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseDragMousePressed
        // TODO add your handling code here:
         
    }//GEN-LAST:event_mouseDragMousePressed

    private void mouseDragMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseDragMouseDragged
        
    }//GEN-LAST:event_mouseDragMouseDragged

    private void jLabel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseDragged
        // TODO add your handling code here:
          int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y -  yMouse);
    }//GEN-LAST:event_jLabel1MouseDragged

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        // TODO add your handling code here:
         xMouse = evt.getX();
       yMouse = evt.getY();
    }//GEN-LAST:event_jLabel1MousePressed

    private void nameCombo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameCombo2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameCombo2ActionPerformed

    private void invoiceclickMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invoiceclickMousePressed
        // TODO add your handling code here:
        start3();
        panelremove3();
    }//GEN-LAST:event_invoiceclickMousePressed

    private void invoiceclick1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invoiceclick1MousePressed
        // TODO add your handling code here:
        start3();
        panelremove3();
    }//GEN-LAST:event_invoiceclick1MousePressed

    private void quantityField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityField2KeyTyped
  char c = evt.getKeyChar();        // TODO add your handling code here:
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_quantityField2KeyTyped

    private void settingsonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsonMousePressed
         settings.setIcon(new ImageIcon(getClass().getResource("/images/Settings group.png")));
        productbutt.setEnabled(true);
        productbutt.setVisible(true);
        printerbutt.setEnabled(true);
        printerbutt.setVisible(true);
        exitbutt.setEnabled(true);
        exitbutt.setVisible(true);
        settings.setEnabled(true);
        settings.setVisible(true);
        settingsoff.setEnabled(true);
        settingsoff.setVisible(true);
        settingson.setEnabled(false);
        settingson.setVisible(false);
    }//GEN-LAST:event_settingsonMousePressed

    private void settingsoffMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsoffMousePressed
         productbutt.setEnabled(false);
        productbutt.setVisible(false);
        printerbutt.setEnabled(false);
        printerbutt.setVisible(false);
        exitbutt.setEnabled(false);
        exitbutt.setVisible(false);
        settings.setEnabled(false);
        settings.setVisible(false);
        settingsoff.setEnabled(false);
        settingsoff.setVisible(false);
        settingson.setEnabled(true);
        settingson.setVisible(true);
    }//GEN-LAST:event_settingsoffMousePressed

    private void settingsonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsonMouseEntered
        // TODO add your handling code here:
        settingspanelview.setEnabled(true);
        settingspanelview.setVisible(true);
    }//GEN-LAST:event_settingsonMouseEntered

    private void settingsonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsonMouseExited
       settingspanelview.setEnabled(false);
        settingspanelview.setVisible(false);
    }//GEN-LAST:event_settingsonMouseExited

    private void settingsoffMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsoffMouseEntered
        settingspanelview.setEnabled(true);
        settingspanelview.setVisible(true);
    }//GEN-LAST:event_settingsoffMouseEntered

    private void settingsoffMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsoffMouseExited
       settingspanelview.setEnabled(false);
        settingspanelview.setVisible(false);
    }//GEN-LAST:event_settingsoffMouseExited

    private void settingsoff1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsoff1MouseEntered
         settingspanelview1.setEnabled(true);
        settingspanelview1.setVisible(true);
    }//GEN-LAST:event_settingsoff1MouseEntered

    private void settingsoff1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsoff1MouseExited
          settingspanelview1.setEnabled(false);
        settingspanelview1.setVisible(false);
    }//GEN-LAST:event_settingsoff1MouseExited

    private void settingsoff1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsoff1MousePressed
          productbutt1.setEnabled(false);
        productbutt1.setVisible(false);
        printerbutt1.setEnabled(false);
        printerbutt1.setVisible(false);
        exitbutt1.setEnabled(false);
        exitbutt1.setVisible(false);
        settings1.setEnabled(false);
        settings1.setVisible(false);
        settingsoff1.setEnabled(false);
        settingsoff1.setVisible(false);
        settingson1.setEnabled(true);
        settingson1.setVisible(true);
    }//GEN-LAST:event_settingsoff1MousePressed

    private void settingson1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingson1MouseEntered
        settingspanelview1.setEnabled(true);
        settingspanelview1.setVisible(true);
    }//GEN-LAST:event_settingson1MouseEntered

    private void settingson1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingson1MouseExited
        settingspanelview1.setEnabled(false);
        settingspanelview1.setVisible(false);
    }//GEN-LAST:event_settingson1MouseExited

    private void settingson1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingson1MousePressed
          productbutt1.setEnabled(true);
        productbutt1.setVisible(true);
        printerbutt1.setEnabled(true);
        printerbutt1.setVisible(true);
        exitbutt1.setEnabled(true);
        exitbutt1.setVisible(true);
        settings1.setEnabled(true);
        settings1.setVisible(true);
        settingsoff1.setEnabled(true);
        settingsoff1.setVisible(true);
        settingson1.setEnabled(false);
        settingson1.setVisible(false);
    }//GEN-LAST:event_settingson1MousePressed

    private void settingsoff2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsoff2MouseEntered
       settingspanelview2.setEnabled(true);
       settingspanelview2.setVisible(true);
    }//GEN-LAST:event_settingsoff2MouseEntered

    private void settingsoff2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsoff2MouseExited
      settingspanelview2.setEnabled(false);
       settingspanelview2.setVisible(false);
    }//GEN-LAST:event_settingsoff2MouseExited

    private void settingsoff2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsoff2MousePressed
         productbutt2.setEnabled(false);
        productbutt2.setVisible(false);
        printerbutt2.setEnabled(false);
        printerbutt2.setVisible(false);
        exitbutt2.setEnabled(false);
        exitbutt2.setVisible(false);
        settings2.setEnabled(false);
        settings2.setVisible(false);
        settingsoff2.setEnabled(false);
        settingsoff2.setVisible(false);
        settingson2.setEnabled(true);
        settingson2.setVisible(true);
    }//GEN-LAST:event_settingsoff2MousePressed

    private void settingson2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingson2MouseEntered
       settingspanelview2.setEnabled(true);
       settingspanelview2.setVisible(true);
    }//GEN-LAST:event_settingson2MouseEntered

    private void settingson2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingson2MouseExited
      settingspanelview2.setEnabled(false);
       settingspanelview2.setVisible(false);   
    }//GEN-LAST:event_settingson2MouseExited

    private void settingson2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingson2MousePressed
       productbutt2.setEnabled(true);
        productbutt2.setVisible(true);
        printerbutt2.setEnabled(true);
        printerbutt2.setVisible(true);
        exitbutt2.setEnabled(true);
        exitbutt2.setVisible(true);
        settings2.setEnabled(true);
        settings2.setVisible(true);
        settingsoff2.setEnabled(true);
        settingsoff2.setVisible(true);
        settingson2.setEnabled(false);
        settingson2.setVisible(false);
    }//GEN-LAST:event_settingson2MousePressed

    private void productbuttMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productbuttMouseEntered
        productspanel.setEnabled(true);
        productspanel.setVisible(true);
    }//GEN-LAST:event_productbuttMouseEntered

    private void productbuttMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productbuttMouseExited
        productspanel.setEnabled(false);
        productspanel.setVisible(false);
    }//GEN-LAST:event_productbuttMouseExited

    private void printerbuttMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printerbuttMouseEntered
        printpanel.setEnabled(true);
        printpanel.setVisible(true);
    }//GEN-LAST:event_printerbuttMouseEntered

    private void printerbuttMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printerbuttMouseExited
         printpanel.setEnabled(false);
        printpanel.setVisible(false);
    }//GEN-LAST:event_printerbuttMouseExited

    private void exitbuttMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitbuttMouseEntered
        exitpanel.setEnabled(true);
        exitpanel.setVisible(true);
    }//GEN-LAST:event_exitbuttMouseEntered

    private void exitbuttMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitbuttMouseExited
        exitpanel.setEnabled(false);
        exitpanel.setVisible(false);
    }//GEN-LAST:event_exitbuttMouseExited

    private void exitbutt1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitbutt1MouseEntered
        exitpanel1.setEnabled(true);
        exitpanel1.setVisible(true);
    }//GEN-LAST:event_exitbutt1MouseEntered

    private void exitbutt1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitbutt1MouseExited
        exitpanel1.setEnabled(false);
        exitpanel1.setVisible(false);
    }//GEN-LAST:event_exitbutt1MouseExited

    private void printerbutt1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printerbutt1MouseEntered
         printpanel1.setEnabled(true);
        printpanel1.setVisible(true);
    }//GEN-LAST:event_printerbutt1MouseEntered

    private void printerbutt1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printerbutt1MouseExited
         printpanel1.setEnabled(false);
        printpanel1.setVisible(false);
    }//GEN-LAST:event_printerbutt1MouseExited

    private void productbutt1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productbutt1MouseEntered
      productspanel1.setEnabled(true);
      productspanel1.setVisible(true);
    }//GEN-LAST:event_productbutt1MouseEntered

    private void productbutt1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productbutt1MouseExited
       productspanel1.setEnabled(false);
      productspanel1.setVisible(false); 
    }//GEN-LAST:event_productbutt1MouseExited

    private void exitbutt1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitbutt1MousePressed
       System.exit(0);
    }//GEN-LAST:event_exitbutt1MousePressed

    private void productbutt1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productbutt1MousePressed
        productlogin();
    }//GEN-LAST:event_productbutt1MousePressed

    private void exitbutt2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitbutt2MouseEntered
       exitpanel2.setEnabled(true);
        exitpanel2.setVisible(true);
    }//GEN-LAST:event_exitbutt2MouseEntered

    private void exitbutt2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitbutt2MouseExited
       exitpanel2.setEnabled(false);
        exitpanel2.setVisible(false);
    }//GEN-LAST:event_exitbutt2MouseExited

    private void printerbutt2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printerbutt2MouseEntered
        printpanel2.setEnabled(true);
        printpanel2.setVisible(true);
    }//GEN-LAST:event_printerbutt2MouseEntered

    private void printerbutt2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printerbutt2MouseExited
      printpanel2.setEnabled(false);
        printpanel2.setVisible(false);
    }//GEN-LAST:event_printerbutt2MouseExited

    private void productbutt2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productbutt2MouseEntered
        productspanel2.setEnabled(true);
        productspanel2.setVisible(true);
    }//GEN-LAST:event_productbutt2MouseEntered

    private void productbutt2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productbutt2MouseExited
         productspanel2.setEnabled(false);
        productspanel2.setVisible(false);
    }//GEN-LAST:event_productbutt2MouseExited

    private void deletebutt3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletebutt3MouseEntered
        deletepanel3.setEnabled(true);
        deletepanel3.setVisible(true);
    }//GEN-LAST:event_deletebutt3MouseEntered

    private void deletebutt3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletebutt3MouseExited
        deletepanel3.setEnabled(false);
        deletepanel3.setVisible(false);
    }//GEN-LAST:event_deletebutt3MouseExited

    private void deletebutt3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletebutt3MousePressed
      Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
  String sql = "delete from product where name = ?";
 try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, namefield.getText());
            pst.execute();
            //JOptionPane.showMessageDialog(null, "Deleted");
           // UpdateJTable();
            JOptionPane.showMessageDialog(null, "PRODUCT DELETED");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
           
        }
 
        finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
        }
 //clear();
 FillJlist();
    }//GEN-LAST:event_deletebutt3MousePressed
private void error(){
      error.setEnabled(true);
          error.setVisible(true);
          errorclose.setEnabled(true);
          errorclose.setVisible(true);
          errormsg.setEnabled(true);
          errormsg.setVisible(true); 
}
private void errorlogin(){
    if (ok.isShowing()){
      error4.setEnabled(false);
          error4.setVisible(false);
          errorclose1.setEnabled(false);
          errorclose1.setVisible(false);
          errormsg1.setEnabled(false);
          errormsg1.setVisible(false);  
    }else{
      error4.setEnabled(true);
          error4.setVisible(true);
          errorclose1.setEnabled(true);
          errorclose1.setVisible(true);
          errormsg1.setEnabled(true);
          errormsg1.setVisible(true); 
}
}
private void error1(){
      error1.setEnabled(true);
          error1.setVisible(true);
          ok.setEnabled(true);
          ok.setVisible(true);
          success.setEnabled(true);
          success.setVisible(true);
          gif.setEnabled(true);
          gif.setVisible(true);
}
private void error2(){
          ok1.setEnabled(true);
          ok1.setVisible(true);
          success1.setEnabled(true);
          success1.setVisible(true);
          gif1.setEnabled(true);
          gif1.setVisible(true);
          error2.setEnabled(true);
          error2.setVisible(true);
}
    private void mouseDrag1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseDrag1MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_mouseDrag1MouseDragged

    private void mouseDrag1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseDrag1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_mouseDrag1MousePressed

    private void header3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_header3MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_header3MouseDragged

    private void header3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_header3MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_header3MousePressed

    private void tilltwoclick3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tilltwoclick3MouseEntered
         tilltwopanelview3.setEnabled(true);
      tilltwopanelview3.setVisible(true);
    }//GEN-LAST:event_tilltwoclick3MouseEntered

    private void tilltwoclick3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tilltwoclick3MouseExited
     tilltwopanelview3.setEnabled(false);
      tilltwopanelview3.setVisible(false);
    }//GEN-LAST:event_tilltwoclick3MouseExited

    private void tilltwoclick3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tilltwoclick3MousePressed
     start2();
     panelremove2();
      settingson1.setEnabled(true);
        settingson1.setVisible(true);
    }//GEN-LAST:event_tilltwoclick3MousePressed

    private void invoiceclick3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invoiceclick3MouseEntered
        invoicepanelview3.setEnabled(true);
        invoicepanelview3.setVisible(true);
    }//GEN-LAST:event_invoiceclick3MouseEntered

    private void invoiceclick3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invoiceclick3MouseExited
        invoicepanelview3.setEnabled(false);
        invoicepanelview3.setVisible(false);
    }//GEN-LAST:event_invoiceclick3MouseExited

    private void invoiceclick3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invoiceclick3MousePressed
       start3();
       panelremove3();
        settingson2.setEnabled(true);
        settingson2.setVisible(true);
    }//GEN-LAST:event_invoiceclick3MousePressed

    private void tilloneclick3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tilloneclick3MouseEntered
       tillonepanelview3.setEnabled(true);
       tillonepanelview3.setVisible(true);
    }//GEN-LAST:event_tilloneclick3MouseEntered

    private void tilloneclick3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tilloneclick3MouseExited
         tillonepanelview3.setEnabled(false);
       tillonepanelview3.setVisible(false);
    }//GEN-LAST:event_tilloneclick3MouseExited

    private void tilloneclick3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tilloneclick3MousePressed
        start2();
        panelremove2();
        settingson.setEnabled(true);
        settingson.setVisible(true);
    }//GEN-LAST:event_tilloneclick3MousePressed

    private void userclick3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userclick3MouseEntered
       userpanelview3.setEnabled(true);
       userpanelview3.setVisible(true);
    }//GEN-LAST:event_userclick3MouseEntered

    private void userclick3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userclick3MouseExited
        userpanelview3.setEnabled(false);
       userpanelview3.setVisible(false);
    }//GEN-LAST:event_userclick3MouseExited

    private void refreshbutt3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshbutt3MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_refreshbutt3MousePressed

    private void productbutt3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productbutt3MouseEntered
        productspanel3.setEnabled(true);
        productspanel3.setVisible(true);
    }//GEN-LAST:event_productbutt3MouseEntered

    private void productbutt3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productbutt3MouseExited
        productspanel3.setEnabled(false);
        productspanel3.setVisible(false);
    }//GEN-LAST:event_productbutt3MouseExited

    private void printerbutt3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printerbutt3MouseEntered
        printpanel3.setEnabled(true);
        printpanel3.setVisible(true);
    }//GEN-LAST:event_printerbutt3MouseEntered

    private void printerbutt3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printerbutt3MouseExited
        printpanel3.setEnabled(false);
        printpanel3.setVisible(false);
    }//GEN-LAST:event_printerbutt3MouseExited

    private void exitbutt3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitbutt3MouseEntered
       exitpanel3.setEnabled(true);
       exitpanel3.setVisible(true);
    }//GEN-LAST:event_exitbutt3MouseEntered

    private void exitbutt3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitbutt3MouseExited
       exitpanel3.setEnabled(false);
       exitpanel3.setVisible(false);
    }//GEN-LAST:event_exitbutt3MouseExited

    private void settingson3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingson3MouseEntered
        settingspanelview3.setEnabled(true);
        settingspanelview3.setVisible(true);
    }//GEN-LAST:event_settingson3MouseEntered

    private void settingson3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingson3MouseExited
       settingspanelview3.setEnabled(false);
        settingspanelview3.setVisible(false);
    }//GEN-LAST:event_settingson3MouseExited

    private void settingson3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingson3MousePressed
         productbutt3.setEnabled(true);
        productbutt3.setVisible(true);
        printerbutt3.setEnabled(true);
        printerbutt3.setVisible(true);
        exitbutt3.setEnabled(true);
        exitbutt3.setVisible(true);
        settings3.setEnabled(true);
        settings3.setVisible(true);
        settingsoff3.setEnabled(true);
        settingsoff3.setVisible(true);
        settingson3.setEnabled(false);
        settingson3.setVisible(false);
    }//GEN-LAST:event_settingson3MousePressed

    private void settingsoff3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsoff3MouseEntered
       settingspanelview3.setEnabled(true);
        settingspanelview3.setVisible(true);
    }//GEN-LAST:event_settingsoff3MouseEntered

    private void settingsoff3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsoff3MouseExited
       settingspanelview3.setEnabled(false);
        settingspanelview3.setVisible(false);
    }//GEN-LAST:event_settingsoff3MouseExited

    private void settingsoff3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsoff3MousePressed
         productbutt3.setEnabled(false);
        productbutt3.setVisible(false);
        printerbutt3.setEnabled(false);
        printerbutt3.setVisible(false);
        exitbutt3.setEnabled(false);
        exitbutt3.setVisible(false);
        settings3.setEnabled(false);
        settings3.setVisible(false);
        settingsoff3.setEnabled(false);
        settingsoff3.setVisible(false);
        settingson3.setEnabled(true);
        settingson3.setVisible(true);
    }//GEN-LAST:event_settingsoff3MousePressed

    private void clearbutt3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearbutt3MousePressed
      
    }//GEN-LAST:event_clearbutt3MousePressed

    private void clearbutt3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearbutt3MouseExited
         clearpanel3.setEnabled(false);
       clearpanel3.setVisible(false);
    }//GEN-LAST:event_clearbutt3MouseExited

    private void clearbutt3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearbutt3MouseEntered
        clearpanel3.setEnabled(true);
       clearpanel3.setVisible(true);
    }//GEN-LAST:event_clearbutt3MouseEntered

    private void updatebutt3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatebutt3MousePressed
       String sql = "update product set  name = ?,description = ?,inthebox=?,category=?, pricebuy = ?, pricesell = ?, instock = ? where name = ? ";
    String tmp = (String)jList1.getSelectedValue();
    Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
String tmp1 = (String) category.getSelectedItem();
//String tmp4 = (String) year.getSelectedItem();
 //   String tmp5 = (String) month.getSelectedItem();
  //  String tmp6 = (String) day.getSelectedItem();
    try{
        pst = conn.prepareStatement(sql);
        //pst.setString(1, txtname.getText());
        //pst.setString(2, txtage.getText());
        pst.setString(1, namefield.getText());
        pst.setString(2, description.getText());
        pst.setString(3, piecesinbox.getText());
        pst.setString(4, tmp1);
        if(buyingprice.getText().equals("")){
            JOptionPane.showMessageDialog(null, "PLEASE ENTER BUY PRICE");
            return;
        }
        pst.setString(5, buyingprice.getText());
        if(sellingprice.getText().equals("")){
            JOptionPane.showMessageDialog(null, "PLEASE ENTER SELL PRICE");
            return;
        }
         pst.setString(6, sellingprice.getText());
         pst.setString(7, stock.getText());
      //   pst.setString(8, tmp6);
       //  pst.setString(8, tmp5);
       //  pst.setString(9, tmp4);
          pst.setString(8, tmp);
         
        pst.executeUpdate();
       JOptionPane.showMessageDialog(null, "PRODUCT UPDATED");
        FillJlist();
       // jButton2.setEnabled(false);
    }
    catch (Exception e){
        JOptionPane.showMessageDialog(null, e);
    }
    finally{
           DbUtils.closeQuietly(rs);
           DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
                                           
            }
    //clear();
    }//GEN-LAST:event_updatebutt3MousePressed

    private void updatebutt3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatebutt3MouseExited
        updatepanel3.setEnabled(false);
        updatepanel3.setVisible(false);
    }//GEN-LAST:event_updatebutt3MouseExited

    private void updatebutt3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatebutt3MouseEntered
        updatepanel3.setEnabled(true);
        updatepanel3.setVisible(true);
    }//GEN-LAST:event_updatebutt3MouseEntered

    private void savepanel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_savepanel3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_savepanel3MouseEntered

    private void savebutton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_savebutton3MouseExited
        savepanel3.setEnabled(false);
        savepanel3.setVisible(false);
    }//GEN-LAST:event_savebutton3MouseExited

    private void savebutton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_savebutton3MouseEntered
         savepanel3.setEnabled(true);
        savepanel3.setVisible(true);
    }//GEN-LAST:event_savebutton3MouseEntered

    private void productbutt3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productbutt3MousePressed
    
          
    
   
    }//GEN-LAST:event_productbutt3MousePressed

    private void productbuttMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productbuttMousePressed
        productlogin();
    }//GEN-LAST:event_productbuttMousePressed

    private void namesearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_namesearchKeyTyped
char keyChar = evt.getKeyChar();
    if (Character.isLowerCase(keyChar)) {
      evt.setKeyChar(Character.toUpperCase(keyChar));
    }
        searchlist();
    }//GEN-LAST:event_namesearchKeyTyped

    private void jList1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MousePressed
               Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
          try{
        String tmp = (String)jList1.getSelectedValue();
    String sql = "select * from product where name = ?";
    
        pst = conn.prepareStatement(sql);
        pst.setString(1, tmp);
        rs = pst.executeQuery();
        if (rs.next()){
            String add = rs.getString("name");
            namefield.setText(add);
            String add2 = rs.getString("description");
            description.setText(add2);
            String add3 = rs.getString("inthebox");
            piecesinbox.setText(add3);
            String add4 = rs.getString("category");
            category.setSelectedItem(add4);
            String add5 = rs.getString("pricebuy");
            buyingprice.setText(add5);
            String add6 = rs.getString("pricesell");
            sellingprice.setText(add6);
            String add7 = rs.getString("instock");
            stock.setText(add7);
          //  String add8 = rs.getString("day");
            //day.setSelectedItem(add8);
          //  String add9 = rs.getString("month");
          //  month.setSelectedItem(add9);
           // String add10 = rs.getString("year");
           // year.setSelectedItem(add10);
            
        }
    
    }
    catch (Exception e){
        JOptionPane.showMessageDialog(null, e);
    }  
          finally{
           DbUtils.closeQuietly(rs);
           DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
                                           
            }
    }//GEN-LAST:event_jList1MousePressed

    private void namefieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_namefieldKeyTyped
        char keyChar = evt.getKeyChar();
    if (Character.isLowerCase(keyChar)) {
      evt.setKeyChar(Character.toUpperCase(keyChar));
    }
    }//GEN-LAST:event_namefieldKeyTyped

    private void savebutton3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_savebutton3MousePressed
       String sql = "insert into product (name, pricebuy, pricesell, category, description, inthebox, instock) values( ?, ?, ?, ?, ?, ?,?) ";
    String tmp = (String)jList1.getSelectedValue();
    String tmp1 = (String) category.getSelectedItem();
    Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
//String tmp4 = (String) year.getSelectedItem();
 //   String tmp5 = (String) month.getSelectedItem();
  //  String tmp6 = (String) day.getSelectedItem();
    try{
        pst = conn.prepareStatement(sql);
        //pst.setString(1, txtname.getText());
        //pst.setString(2, txtage.getText());
        pst.setString(1, namefield.getText());
        if (buyingprice.getText().equals("")){
         JOptionPane.showMessageDialog(null, "PLEASE ENTER BUY PRICE"); 
         return;
        }
        pst.setString(2, buyingprice.getText());
        if(sellingprice.getText().equals("")){
            JOptionPane.showMessageDialog(null, "PLEASE ENTER SELL PRICE");
            return;
        }
         pst.setString(3, sellingprice.getText());
          pst.setString(4, tmp1);
           pst.setString(5, description.getText());
         pst.setString(6, piecesinbox.getText());
         pst.setString(7, stock.getText());
       //   pst.setString(8, tmp6);
         // pst.setString(8, tmp5);
       //  pst.setString(9, tmp4);
         clear();
         JOptionPane.showMessageDialog(null, "PRODUCT SAVED");
        pst.executeUpdate();
       // JOptionPane.showMessageDialog(null, "Updated");
       jList1.removeAll(); 
        FillJlist();
       // jButton2.setEnabled(false);
    }
    catch (Exception e){
        JOptionPane.showMessageDialog(null, e);
    }
    finally{
           DbUtils.closeQuietly(rs);
           DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
                                           
            }
    }//GEN-LAST:event_savebutton3MousePressed

    private void playbuttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playbuttonMouseEntered
         if (errormsg.getText()!=""){
           return;
       
    }else{
        gui4.setIcon(new ImageIcon(getClass().getResource("/images/Productlogin2.png")));
         }
        
    }//GEN-LAST:event_playbuttonMouseEntered

    private void playbuttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playbuttonMouseExited
       if (errormsg.getText()!=""){
           return;
       
    }else{
        gui4.setIcon(new ImageIcon(getClass().getResource("/images/Productlogin.png")));     
       }
        
       
       
        
        
               
    }//GEN-LAST:event_playbuttonMouseExited

    private void exitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMousePressed
       if (errormsg.getText()!=""){
           return;
       }
        start();
        panelremove();
        settingson.setEnabled(true);
        settingson.setVisible(true);
        settingson1.setEnabled(true);
        settingson1.setVisible(true);
        settingson2.setEnabled(true);
        settingson2.setVisible(true);
        
    }//GEN-LAST:event_exitMousePressed

    private void passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyPressed
          // TODO add your handling code here:
        
    }//GEN-LAST:event_passwordKeyPressed

    private void playbuttonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playbuttonMousePressed
 //    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
  if (errormsg1.getText()!=""){
      JOptionPane.showMessageDialog(null, "error working");
           return;
       
    }
              Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
            String sql = "select * from applogin where type = 'admin' and password = ?";
            try{
                pst = conn.prepareStatement(sql);
                //pst.setString(1, nameLabel.getText());
                pst.setString(1, password.getText());
                rs=pst.executeQuery();
                if (rs.next()){
                 //  password.setEnabled(false);
                 //  password.setVisible(false);
                 //  playbutton.setEnabled(false);
                  // playbutton.setVisible(false);
                //  playbutton.requestFocusInWindow();
                   // gui4.setIcon(new ImageIcon(getClass().getResource("/images/Productlogin3.png")));
                   
                    error1();
                   // start();
                    //errormsg.setText("SYSTEM READY");
                   // JOptionPane.showMessageDialog(null, "SYSTEM READY");
                   // newProduct cpass = new newProduct();
                    //cpass.setVisible(true);
                    //pad();
                   // dispose();
                   // start4();
                    //panelremove4();
                   
                    password.setText("");
                }
                else{
               
                password.setText("");
                error();
errormsg.setText("INVALID PASSWORD");
            
            }
            }
            catch (Exception e){
                     
            }
            finally{
           DbUtils.closeQuietly(rs);
           DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
                                           
       }


 // start();                         
    }//GEN-LAST:event_playbuttonMousePressed
private void productloginerror(){
    
     password.setText("");
                errorlogin();
errormsg1.setText("INVALID PASSWORD");
}
    private void errorcloseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_errorcloseMousePressed
       error.setEnabled(false);
       error.setVisible(false);
       errormsg.setEnabled(false);
       errormsg.setVisible(false);
       errorclose.setEnabled(false);
       errorclose.setVisible(false);
       errormsg.setText("");
       
    }//GEN-LAST:event_errorcloseMousePressed

    private void productspanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productspanel1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_productspanel1MousePressed

    private void productbutt2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productbutt2MousePressed
       productlogin();
    }//GEN-LAST:event_productbutt2MousePressed

    private void settingsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_settingsFocusLost
     // settings.setEnabled(false);
     // settings.setVisible(false);  
    }//GEN-LAST:event_settingsFocusLost

    private void guiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guiMousePressed
     // settings.setEnabled(false);
     //settings.setVisible(false);
    }//GEN-LAST:event_guiMousePressed

    private void okMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_okMousePressed
      start4();
                    panelremove4();
                   error1.setEnabled(false);
                    error1.setVisible(false);
                    ok.setEnabled(false);
                    ok.setVisible(false);
                    success.setEnabled(false);
                    success.setVisible(false);
                    gif.setEnabled(false);
                    gif.setVisible(false);
    }//GEN-LAST:event_okMousePressed

    private void printerbutt3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printerbutt3MousePressed
       PrinterJob pj = PrinterJob.getPrinterJob();
// Ask user for page format (e.g., portrait/landscape)
//PageFormat pf = job.pageDialog(job.defaultPage());
 if (pj.printDialog()) {
        try {pj.print();}
        catch (PrinterException exc) {
            System.out.println(exc);
         }
     }   
    }//GEN-LAST:event_printerbutt3MousePressed

    private void printerbutt2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printerbutt2MousePressed
       PrinterJob pj = PrinterJob.getPrinterJob();
// Ask user for page format (e.g., portrait/landscape)
//PageFormat pf = job.pageDialog(job.defaultPage());
 if (pj.printDialog()) {
        try {pj.print();}
        catch (PrinterException exc) {
            System.out.println(exc);
         }
     }   
    }//GEN-LAST:event_printerbutt2MousePressed

    private void printerbutt1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printerbutt1MousePressed
      PrinterJob pj = PrinterJob.getPrinterJob();
// Ask user for page format (e.g., portrait/landscape)
//PageFormat pf = job.pageDialog(job.defaultPage());
 if (pj.printDialog()) {
        try {pj.print();}
        catch (PrinterException exc) {
            System.out.println(exc);
         }
     }   
    }//GEN-LAST:event_printerbutt1MousePressed

    private void printerbuttMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printerbuttMousePressed
      PrinterJob pj = PrinterJob.getPrinterJob();
// Ask user for page format (e.g., portrait/landscape)
//PageFormat pf = job.pageDialog(job.defaultPage());
 if (pj.printDialog()) {
        try {pj.print();}
        catch (PrinterException exc) {
            System.out.println(exc);
         }
     }   
    }//GEN-LAST:event_printerbuttMousePressed

    private void exitbuttMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitbuttMousePressed
     System.exit(0);
    }//GEN-LAST:event_exitbuttMousePressed

    private void UseronMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UseronMouseEntered
         userpanelview.setEnabled(true);
        userpanelview.setVisible(true);
    }//GEN-LAST:event_UseronMouseEntered

    private void UseronMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UseronMouseExited
         userpanelview.setEnabled(false);
        userpanelview.setVisible(false);
    }//GEN-LAST:event_UseronMouseExited

    private void UseroffMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UseroffMouseEntered
       userpanelview.setEnabled(true);
        userpanelview.setVisible(true);
    }//GEN-LAST:event_UseroffMouseEntered

    private void UseroffMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UseroffMouseExited
        userpanelview.setEnabled(false);
        userpanelview.setVisible(false);
    }//GEN-LAST:event_UseroffMouseExited

    private void UseronMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UseronMousePressed
         settings.setIcon(new ImageIcon(getClass().getResource("/images/User group.png")));
        productbutt.setEnabled(false);
        productbutt.setVisible(false);
        printerbutt.setEnabled(false);
        printerbutt.setVisible(false);
        exitbutt.setEnabled(false);
        exitbutt.setVisible(false);
        settings.setEnabled(true);
        settings.setVisible(true);
        createuser.setEnabled(true);
        createuser.setVisible(true);
        changepass.setEnabled(true);
        changepass.setVisible(true);
        Useroff.setEnabled(true);
        Useroff.setVisible(true);
        Useron.setEnabled(false);
        Useron.setVisible(false);
    }//GEN-LAST:event_UseronMousePressed

    private void UseroffMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UseroffMousePressed
          settings.setIcon(new ImageIcon(getClass().getResource("/images/User group.png")));
        productbutt.setEnabled(false);
        productbutt.setVisible(false);
        printerbutt.setEnabled(false);
        printerbutt.setVisible(false);
        exitbutt.setEnabled(false);
        exitbutt.setVisible(false);
        settings.setEnabled(false);
        settings.setVisible(false);
        createuser.setEnabled(false);
        createuser.setVisible(false);
        changepass.setEnabled(false);
        changepass.setVisible(false);
        Useroff.setEnabled(false);
        Useroff.setVisible(false);
        Useron.setEnabled(true);
        Useron.setVisible(true);
    }//GEN-LAST:event_UseroffMousePressed

    private void createuserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createuserMouseEntered
      printpanel.setEnabled(true);
      printpanel.setVisible(true);
    }//GEN-LAST:event_createuserMouseEntered

    private void createuserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createuserMouseExited
       printpanel.setEnabled(false);
      printpanel.setVisible(false);
    }//GEN-LAST:event_createuserMouseExited

    private void changepassMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changepassMouseEntered
        productspanel.setEnabled(true);
        productspanel.setVisible(true);
    }//GEN-LAST:event_changepassMouseEntered

    private void changepassMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changepassMouseExited
        productspanel.setEnabled(false);
        productspanel.setVisible(false);
    }//GEN-LAST:event_changepassMouseExited

    private void eyeoneonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eyeoneonMousePressed
    //  int defaultt = oldpass.getEchoChar(); 
//System.out.println(defaultt);
        oldpass.setEchoChar((char) 0);
      eyeoneoff.setEnabled(true);
      eyeoneoff.setVisible(true);
      eyeoneon.setEnabled(false);
      eyeoneon.setVisible(false);
    }//GEN-LAST:event_eyeoneonMousePressed
/*public void PrintSecondLine(String text){
    try{
    outputStream.write(ESCPOS.SELECT_DISPLAY);
    outputStream.write(ESCPOS.Down_Line);
    outputStream.write(ESCPOS.Left_Line);
    if(text.length()>20)
        text=text.substring(0,20);
        outputStream.write(text.getBytes());
        outputStream.flush();
    }
    catch(IOException y){
        System.out.println("Failed to print second line because of :"+y);
    }
}
public void PrintSecondLine1(String text){
    try{
    outputStream.write(ESCPOS.SELECT_DISPLAY);
    outputStream.write(ESCPOS.Down_Line);
    outputStream.write(ESCPOS.Left_Line);
    if(text.length()>20)
        text=text.substring(0,20);
        outputStream.write(text.getBytes());
        outputStream.flush();
    }
    catch(IOException y){
        System.out.println("Failed to print second line because of :"+y);
    }
}
    public void ClearDisplay(){
        try{
    outputStream.write(ESCPOS.SELECT_DISPLAY);
        outputStream.write(ESCPOS.VISOR_CLEAR);
        outputStream.write(ESCPOS.VISOR_HOME);
        outputStream.flush();
        }
        catch(IOException e){
        
        }
}
        public void PrintFirstLine(String text){
    try{
    ClearDisplay();
    if(text.length()>20)            //Display can hold only 20 characters per line.Most of displays have 2 lines.
        text=text.substring(0,20);
    outputStream.write(text.getBytes());
    outputStream.flush();
   
    }
    catch(IOException r){
    }
    
}
        public void PrintFirstLine1(String text){
    try{
    ClearDisplay();
    if(text.length()>20)            //Display can hold only 20 characters per line.Most of displays have 2 lines.
        text=text.substring(0,20);
    outputStream.write(text.getBytes());
    outputStream.flush();
   
    }
    catch(IOException r){
    }
    
}*/

    private void eyeoneoffMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eyeoneoffMousePressed
   // int defaultt = oldpass.getEchoChar(); 
//System.out.println(defaultt);
oldpass.setEchoChar((char)8226);
      eyeoneoff.setEnabled(false);
      eyeoneoff.setVisible(false);
      eyeoneon.setEnabled(true);
      eyeoneon.setVisible(true);
    }//GEN-LAST:event_eyeoneoffMousePressed

    private void changepassMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changepassMousePressed
       Changepass();
    }//GEN-LAST:event_changepassMousePressed

    private void eyetwoonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eyetwoonMousePressed
         newpass.setEchoChar((char) 0);
      eyetwooff.setEnabled(true);
      eyetwooff.setVisible(true);
      eyetwoon.setEnabled(false);
      eyetwoon.setVisible(false);
    }//GEN-LAST:event_eyetwoonMousePressed

    private void eyetwooffMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eyetwooffMousePressed
        newpass.setEchoChar((char)8226);
      eyetwooff.setEnabled(false);
      eyetwooff.setVisible(false);
      eyetwoon.setEnabled(true);
      eyetwoon.setVisible(true);
    }//GEN-LAST:event_eyetwooffMousePressed

    private void ok1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ok1MousePressed
 error2.setEnabled(false);
                    error2.setVisible(false);
                    ok1.setEnabled(false);
                    ok1.setVisible(false);
                    success1.setEnabled(false);
                    success1.setVisible(false);
                    gif1.setEnabled(false);
                    gif1.setVisible(false);       
    }//GEN-LAST:event_ok1MousePressed

    private void savebuttMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_savebuttMousePressed
     Insert();
    }//GEN-LAST:event_savebuttMousePressed

    private void backbuttMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backbuttMousePressed
       start();
       panelremove();
       Useron.setEnabled(true);
       Useron.setVisible(true);
    }//GEN-LAST:event_backbuttMousePressed

    private void editButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editButtonMouseEntered
       editpanel.setEnabled(true);
       editpanel.setVisible(true);
    }//GEN-LAST:event_editButtonMouseEntered

    private void editButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editButtonMouseExited
       editpanel.setEnabled(false);
       editpanel.setVisible(false);
    }//GEN-LAST:event_editButtonMouseExited

    private void orderFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_orderFieldKeyTyped
      char c = evt.getKeyChar();        // TODO add your handling code here:
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_orderFieldKeyTyped

    private void quantityField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quantityField2MouseClicked
        if (nameCode2.getText().toString()!=""){
            nameCombo2.setSelectedItem("");
        }
    }//GEN-LAST:event_quantityField2MouseClicked

    private void quantityFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quantityFieldMouseClicked
      //  if (nameCode.getText().toString()!=""){
          //  nameCombo.setSelectedItem("");
       // }
    }//GEN-LAST:event_quantityFieldMouseClicked

    private void quantityField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quantityField1MouseClicked
      
    }//GEN-LAST:event_quantityField1MouseClicked

    private void ok2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ok2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_ok2MousePressed

    private void savebutt1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_savebutt1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_savebutt1MousePressed

    private void backbutt1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backbutt1MousePressed
      start();
       panelremove();
       Useron.setEnabled(true);
       Useron.setVisible(true);
       settingson.setEnabled(true);
       settingson.setVisible(true);
       
    }//GEN-LAST:event_backbutt1MousePressed

    private void eyetwoon1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eyetwoon1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_eyetwoon1MousePressed

    private void eyetwooff1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eyetwooff1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_eyetwooff1MousePressed

    private void createuserMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createuserMousePressed
     
          try{
           main.removeAll();
          main.repaint();
           main.revalidate();
           main.add(Createuser);
           main.repaint();
           main.revalidate();
       }catch(Exception e){
       
       }  
    }//GEN-LAST:event_createuserMousePressed

    private void errorclose1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_errorclose1MousePressed
        error4.setEnabled(false);
       error4.setVisible(false);
       errormsg1.setEnabled(false);
       errormsg1.setVisible(false);
       errorclose1.setEnabled(false);
       errorclose1.setVisible(false);
       errormsg1.setText("");
    }//GEN-LAST:event_errorclose1MousePressed

    private void exitbutt2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitbutt2MousePressed
      System.exit(0);
    }//GEN-LAST:event_exitbutt2MousePressed

    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
       this.setExtendedState( this.ICONIFIED );
    }//GEN-LAST:event_jLabel3MousePressed

    private void oldinvoice1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_oldinvoice1MousePressed
       Searchclient1 s = new Searchclient1();
            s.setVisible(true);
    }//GEN-LAST:event_oldinvoice1MousePressed

    private void editbuttMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editbuttMousePressed
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        conn= mysqlconnect.ConnectDb();
        String sql = "update Till1 set price = ROUND((price+?),2) where name = ?";
        try{
            pst = conn.prepareStatement(sql);

            //pst.setString(1, txtname.getText());
            //pst.setString(2, txtage.getText());
            //pst.setString(1, priceLabel.getText());
            pst.setString(1, editlabel.getText());
            pst.setString(2, nameCode.getText());
            // pst.setString(3,orderid.getText());
            pst.executeUpdate();
            //pst.executeUpdate();

            /* while (rs.next()){
                String add = rs.getString("price");
                priceLabel.setText(add);
            }*/
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
        finally{
            DbUtils.closeQuietly(rs);
            DbUtils.closeQuietly(pst);
            DbUtils.closeQuietly(conn);
        }
        // PriceChange();

        Amount5();
        SumTotal3();
        SumTotal2();
        UpdateInvoice2();
        // Amount3();
        //Amount3();
        UpdateJTable();
        editlabel.setText("");
        nameCode.setText("");

    }//GEN-LAST:event_editbuttMousePressed

    private void exitpanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitpanel1MousePressed
       System.exit(0);
    }//GEN-LAST:event_exitpanel1MousePressed

    private void exitpanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitpanel2MousePressed
        System.exit(0);
    }//GEN-LAST:event_exitpanel2MousePressed

    private void quantityField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityField2ActionPerformed

    private void refreshpanelview2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshpanelview2MousePressed
FillCombo2();        // TODO add your handling code here:
    }//GEN-LAST:event_refreshpanelview2MousePressed

    private void refreshpanelview1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshpanelview1MousePressed
FillCombo1();        // TODO add your handling code here:
    }//GEN-LAST:event_refreshpanelview1MousePressed

    private void refreshpanelviewMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshpanelviewMousePressed
FillCombo();        // TODO add your handling code here:
    }//GEN-LAST:event_refreshpanelviewMousePressed

    private void oldinvoiceMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_oldinvoiceMousePressed
Searchclient1 s = new Searchclient1();
            s.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_oldinvoiceMousePressed

    private void customerKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customerKeyTyped
char keyChar = evt.getKeyChar();
    if (Character.isLowerCase(keyChar)) {
      evt.setKeyChar(Character.toUpperCase(keyChar));  
    }      // TODO add your handling code here:
    }//GEN-LAST:event_customerKeyTyped

    private void customer1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customer1KeyTyped
char keyChar = evt.getKeyChar();
    if (Character.isLowerCase(keyChar)) {
      evt.setKeyChar(Character.toUpperCase(keyChar));
    }                                         // TODO add your handling code here:
    }//GEN-LAST:event_customer1KeyTyped

    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed
iforgot();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MousePressed

    private void savebutton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_savebutton1MousePressed
if ((customer1.getText().equals("") && customerCombo1.getSelectedItem().toString().equals(""))){
            //error();
            //errormsg.setText("PLEASE ENTER CUSTOMER NAME");
            
 //JOptionPane.showMessageDialog(null, "PLEASE ENTER CUSTOMER NAME");
 UIManager UI=new UIManager();
 UI.put("OptionPane.background", Color.white);
 UI.put("Panel.background", Color.white);

  ImageIcon icon = new ImageIcon(getClass().getResource("/icons/error1.png"));
        JOptionPane.showMessageDialog(null, "PLEASE ENTER CUSTOMER NAME.",
                "Error", JOptionPane.INFORMATION_MESSAGE, icon);
   return;
         } 
        invoicenorminsert1();
insertInvoice1();
//reloadinsert();
        Totals1();
 try {
            DropTotals1();
        } catch (SQLException ex) {
            Logger.getLogger(Apex.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            removeitems1();
        } catch (SQLException ex) {
            Logger.getLogger(Apex.class.getName()).log(Level.SEVERE, null, ex);
        }
         
                           
        CreateTotals1();
        // SubtractStock();
         FillInterest1();
        // stop2();
       
        orderid3.setText("");       // TODO add your handling code here:
    }//GEN-LAST:event_savebutton1MousePressed

    private void savebuttonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_savebuttonMousePressed
if ((customer.getText().equals("") && customerCombo.getSelectedItem().toString().equals(""))){
            //error();
            //errormsg.setText("PLEASE ENTER CUSTOMER NAME");
            
 //JOptionPane.showMessageDialog(null, "PLEASE ENTER CUSTOMER NAME");
 UIManager UI=new UIManager();
 UI.put("OptionPane.background", Color.white);
 UI.put("Panel.background", Color.white);

  ImageIcon icon = new ImageIcon(getClass().getResource("/icons/error1.png"));
        JOptionPane.showMessageDialog(null, "PLEASE ENTER CUSTOMER NAME.",
                "Error", JOptionPane.INFORMATION_MESSAGE, icon);
   return;
         } 
        invoicenorminsert();
insertInvoice();
//reloadinsert();
        Totals();
 try {
            DropTotals();
        } catch (SQLException ex) {
            Logger.getLogger(Apex.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            removeitems();
        } catch (SQLException ex) {
            Logger.getLogger(Apex.class.getName()).log(Level.SEVERE, null, ex);
        }
         
                           
        CreateTotals();
        // SubtractStock();
         FillInterest();
        // stop2();
       
        orderid2.setText("");       // TODO add your handling code here:
    }//GEN-LAST:event_savebuttonMousePressed

    private void editbutt1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editbutt1MousePressed
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        conn= mysqlconnect.ConnectDb();
        String sql = "update Till2 set price = ROUND((price+?),2) where name = ?";
        try{
            pst = conn.prepareStatement(sql);

            //pst.setString(1, txtname.getText());
            //pst.setString(2, txtage.getText());
            //pst.setString(1, priceLabel.getText());
            pst.setString(1, editlabel1.getText());
            pst.setString(2, nameCode1.getText());
            // pst.setString(3,orderid.getText());
            pst.executeUpdate();
            //pst.executeUpdate();

            /* while (rs.next()){
                String add = rs.getString("price");
                priceLabel.setText(add);
            }*/
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
        finally{
            DbUtils.closeQuietly(rs);
            DbUtils.closeQuietly(pst);
            DbUtils.closeQuietly(conn);
        }
        // PriceChange();

        Amount51();
        SumTotal4();
        SumTotal21();
        // UpdateInvoice2();
        // Amount3();
        //Amount3();
        UpdateJTable1();
        editlabel1.setText("");
        nameCode1.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_editbutt1MousePressed

    private void RetailLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RetailLabelMousePressed

        
        
       // String text1=priceLabel.getText();                              // 20 characters
    //String text2=nameCode.getText();                              //20 characters
//    PrintFirstLine1("  "+text1+"  ");
  //  PrintSecondLine1(" "+text2+" ");        // TODO add your handling code here:
    }//GEN-LAST:event_RetailLabelMousePressed

    private void checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkActionPerformed
check=(JCheckBox) evt.getSource();
if (check.isSelected()){
    check.setSelected(true);
    display.setText("1"); 
    disnote.setForeground(Color.red);
    disnote.setText("Retail Display");
}else{
    
display.setText("0");
disnote.setForeground(Color.blue);
disnote.setText("Wholesale");
}

// TODO add your handling code here:
    }//GEN-LAST:event_checkActionPerformed

    private void check1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check1ActionPerformed
  check1=(JCheckBox) evt.getSource();
if (check1.isSelected()){
    check1.setSelected(true);
    display1.setText("1"); 
     disnote1.setForeground(Color.red);
    disnote1.setText("Retail Display");
}else{
    
display1.setText("0");
 disnote1.setForeground(Color.blue);
    disnote1.setText("Wholesale");
}      // TODO add your handling code here:
    }//GEN-LAST:event_check1ActionPerformed
 private void SumTotal2() {
         Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
        try {
            String sql = "select price from Till1 where name = ?";
            pst = conn.prepareStatement(sql);
             pst.setString(1, nameCode.getText());
            rs = pst.executeQuery();
            while (rs.next()) {
                String sum = rs.getString("price");
                //String strDouble = String.format("%.2f;",)
                priceLabel.setText(sum);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
        }   
    }
 private void SumTotal21() {
         Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
        try {
            String sql = "select price from Till2 where name = ?";
            pst = conn.prepareStatement(sql);
             pst.setString(1, nameCode1.getText());
            rs = pst.executeQuery();
            while (rs.next()) {
                String sum = rs.getString("price");
                //String strDouble = String.format("%.2f;",)
                priceLabel1.setText(sum);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
        }   
    }
    
    private void Amount5(){
         Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
    String sql = "update Till1 set amount = ROUND(quantity*price,2) where name = ?";
    try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, nameCode.getText());
           // pst.setString(1, priceLabel.getText());
             pst.execute();   
    }
       catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
                        }    
   }
    private void Amount51(){
         Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
    String sql = "update Till2 set amount = ROUND(quantity*price,2) where name = ?";
    try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, nameCode1.getText());
           // pst.setString(1, priceLabel.getText());
             pst.execute();   
    }
       catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
                        }    
   }
    private void editbutton(){
     Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
Statement stmt =null;
     String sql = "insert into invoicesales (idrow,orderid,name,price,quantity,amount,customername,salesuser) select ordersinvoice.id, ordersinvoice.orderid,productinvoice.name,priceinvoice.price,quantityinvoice.quantity,amountinvoice.amount,custinvoice.customername,salesperson.salesuser from ordersinvoice inner join productinvoice on ordersinvoice.id=productinvoice.id inner join priceinvoice on ordersinvoice.id=priceinvoice.id inner join quantityinvoice on ordersinvoice.id=quantityinvoice.id inner join amountinvoice on ordersinvoice.id=amountinvoice.id inner join custinvoice on ordersinvoice.id=custinvoice.id inner join salesperson on ordersinvoice.id=salesperson.id where ordersinvoice.orderid=?";
         // String tmp = (String)nameCombo.getSelectedItem();
         
    try{
         conn= mysqlconnect.ConnectDb();
        pst = conn.prepareStatement(sql);
        pst.setString(1, orderField.getText());
        pst.executeUpdate();
        //jTable1.setModel(DbUtils.resultSetToTableModel(rs));
       
    }
    catch (Exception e){
        JOptionPane.showMessageDialog(null, e);
    
}
   finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
                        }    
 }
private void updatetable(){
    Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
        String sql = "update Till1 set quantity = ? where name = ? ";
       
       // String tmp = (String) nameCombo.getSelectedItem();
     //  if(errormsg.getText().toString()!=""){
           //return;
     //  }
        try {
             if (nameCode.getText().equals("")){
                // error();
                // errormsg.setText("PLEASE SELECT DRUG TO UPDATE");
                UIManager UI=new UIManager();
 UI.put("OptionPane.background", Color.white);
 UI.put("Panel.background", Color.white);

  ImageIcon icon = new ImageIcon(getClass().getResource("/icons/error1.png"));
        JOptionPane.showMessageDialog(null, "PLEASE SELECT PRODUCT TO UPDATE.",
                "Error", JOptionPane.INFORMATION_MESSAGE, icon);
                 
           // JOptionPane.showMessageDialog(null, "PLEASE SELECT DRUG TO UPDATE"); 
            return;
             }
            pst = conn.prepareStatement(sql);
        //pst.setString(1, txtname.getText());
            //pst.setString(2, txtage.getText());
            pst.setString(1, quantityField.getText());
            //pst.setString(2, priceLabel.getText());
            pst.setString(2, nameCode.getText());
            pst.executeUpdate();
            UpdateAmount();
           // UpdateInvoice();
           // UpdateAmount2();           // JOptionPane.showMessageDialog(null, "Updated");
            UpdateJTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            
        }
        finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
}
        
        SumTotal3();
quantityField.setText("");
nameCode.setText("");
    





}
private void updatetable2(){
    Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
        String sql = "update invoicesales set quantity = ? where name = ? ";
       
       // String tmp = (String) nameCombo.getSelectedItem();
       if(errormsg.getText().toString()!=""){
           return;
       }
        try {
             if (nameCode.getText().equals("")){
                 error();
                 errormsg.setText("PLEASE SELECT DRUG TO UPDATE");
                 
           // JOptionPane.showMessageDialog(null, "PLEASE SELECT DRUG TO UPDATE"); 
            return;
             }
            pst = conn.prepareStatement(sql);
        //pst.setString(1, txtname.getText());
            //pst.setString(2, txtage.getText());
            pst.setString(1, quantityField.getText());
            //pst.setString(2, priceLabel.getText());
            pst.setString(2, nameCode.getText());
            pst.executeUpdate();
            UpdateAmount();
           // UpdateInvoice();
           // UpdateAmount2();           // JOptionPane.showMessageDialog(null, "Updated");
            UpdateJTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            
        }
        finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
}
        
        SumTotal3();
quantityField.setText("");
nameCode.setText("");
    





}
private void display(){
     Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
Statement stmt =null;
conn = mysqlconnect.ConnectDb();
    String sql = "select name from reader";
    
     try{
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        if (rs.next()){
            String add = rs.getString("name");
            namelabel.setText(add);
            //String add2 = rs.getString("name");
           // nameCode.setText(add2);
        }
    
    }
    catch (Exception e){
        JOptionPane.showMessageDialog(null, e);
    }  
}
private void Insert(){
      Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
Statement stmt =null;
conn = mysqlconnect.ConnectDb();
  String sql = "select * from applogin where password = ? and name =?"; 
   try{
        pst = conn.prepareStatement(sql);
        //pst.setString(1, txtusername.getText());
        pst.setString(1, new String( oldpass.getPassword()));
        pst.setString(2, salesLabel.getText());
        rs = pst.executeQuery();
        if (rs.next()){
            String sql1 = "update applogin  set password = ? where name = ?";
            pst = conn.prepareStatement(sql1);
             pst.setString(1,new String (newpass.getPassword()));
              pst.setString(2, salesLabel.getText());
             pst.executeUpdate();
           // JOptionPane.showMessageDialog(null, "Password Changed");
           error2();
            namelabel.requestFocusInWindow();
        }
        else
            JOptionPane.showMessageDialog(null, "error");     
       // getContentPane().remove(newPassword1);
     // initComponents();
      
    }
    catch (Exception e){
        JOptionPane.showMessageDialog(null, e);
    }
     oldpass.setText("");
        newpass.setText("");
        namelabel.requestFocusInWindow();
}
private void updatetable1(){
    Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
        String sql = "update Till2 set quantity = ? where name = ? ";
       
       // String tmp = (String) nameCombo.getSelectedItem();
       // if(errormsg.getText().toString()!=""){
         //  return;
     //  }
        try {
             if (nameCode1.getText().equals("")){
                 //error();
                 //errormsg.setText("PLEASE SELECT DRUG TO UPDATE");
           // JOptionPane.showMessageDialog(null, "PLEASE SELECT DRUG TO UPDATE"); 
           UIManager UI=new UIManager();
 UI.put("OptionPane.background", Color.white);
 UI.put("Panel.background", Color.white);

  ImageIcon icon = new ImageIcon(getClass().getResource("/icons/error1.png"));
        JOptionPane.showMessageDialog(null, "PLEASE SELECT PRODUCT TO UPDATE.",
                "Error", JOptionPane.INFORMATION_MESSAGE, icon);
            return;
             }
            pst = conn.prepareStatement(sql);
        //pst.setString(1, txtname.getText());
            //pst.setString(2, txtage.getText());
            pst.setString(1, quantityField1.getText());
            //pst.setString(2, priceLabel.getText());
            pst.setString(2, nameCode1.getText());
            pst.executeUpdate();
            UpdateAmount1();
            UpdateInvoice();
            UpdateAmount2();           // JOptionPane.showMessageDialog(null, "Updated");
            UpdateJTable1();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            
        }
        finally{
            DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
}
        
        SumTotal4();
quantityField1.setText("");
nameCode1.setText("");
    





}
    private void CountInvoice(){
    Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
    try {
            String sql = "select count(*)from invoice";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String name = rs.getString("count(*)");
                invoicerecord.setText(name);
                //ordercheck.setText("1");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e); 
} 
    DbUtils.closeQuietly(rs);
           DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
}
    private void CountInvoice1(){
    Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
    try {
            String sql = "select count(*)from invoice";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String name = rs.getString("count(*)");
                invoicerecord1.setText(name);
                //ordercheck.setText("1");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e); 
} 
    DbUtils.closeQuietly(rs);
           DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
}
    private void Renametable(){
    Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
String name1 = invoicecounter.getText();
    try {
            String sql = "rename table invoice to invoice"+name1+"";
            pst = conn.prepareStatement(sql);
            pst.executeUpdate();
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e); 
} 
    DbUtils.closeQuietly(rs);
           DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
}
private void createinvoice1(){
         Connection conn = null;
        Statement stmt = null;
        try {
            conn = mysqlconnect.ConnectDb();
            stmt = conn.createStatement();
            stmt.executeUpdate(INVOICE1_TABLE);
          
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
           DbUtils.closeQuietly(stmt);
    DbUtils.closeQuietly(conn);
        }
}
    private void Automate(){
     int result = Integer.parseInt(invoicerecord.getText());
     if(result > 200000){
         
         
     
     invoiceinsert();
     Renametable();
  createinvoice1();
  JOptionPane.showMessageDialog(null, "INVOICE IS FULL...SYSTEM WILL EXIT PLEASE RESTART");
  System.exit(0);
     }
     
 else{
        return;  
          }
 }
    private void FillInterest(){
        Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
      try{
        String sql = "select percentage from interest";
         pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        while(rs.next()){
            String name =rs.getString("percentage");
            percentage4.removeItem(name);
            percentage4.addItem(name);
        }
    }  catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
        
    }
      DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
 }    
    private void FillInterest1(){
        Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
      try{
        String sql = "select percentage from interest";
         pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        while(rs.next()){
            String name =rs.getString("percentage");
            percentage5.removeItem(name);
            percentage5.addItem(name);
        }
    }  catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
        
    }
      DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
 }  
     private void FillJlist(){
    DefaultListModel s = new DefaultListModel();
    Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
    try{
    String sql = "select name from product order by name asc";
    pst = conn.prepareStatement(sql);
    //pst.setString(1, txtusername.getText());
    rs = pst.executeQuery();
    while(rs.next()){
            String name =rs.getString("name");
            s.addElement(name);
             }
   
    jList1.setModel(s);
    
     }
    catch (Exception e){
        JOptionPane.showMessageDialog(null, e);
    }  
    finally{
           DbUtils.closeQuietly(rs);
           DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
                                           
            }
    }
     private void searchlist(){
    DefaultListModel s = new DefaultListModel();
    Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
conn = mysqlconnect.ConnectDb();
    try{
    String sql = " select * from product where name like ?";
    pst = conn.prepareStatement(sql);
    pst.setString(1, namesearch.getText()+ "%");
    rs = pst.executeQuery();
    while(rs.next()){
            String name =rs.getString("name");
            s.addElement(name);
             }
    jList1.setModel(s);
    
     }
    catch (Exception e){
        JOptionPane.showMessageDialog(null, e);
    }  
    finally{
           DbUtils.closeQuietly(rs);
           DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
                                           
            }
     }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                   // com.jtattoo.plaf.fast.FastLookAndFeel.setTheme("Green");
                     UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
                     DecorationHelper.decorateWindows(false);
      //  this.undecorated(true);
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Apex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Apex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Apex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Apex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Apex().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ChangePass;
    private javax.swing.JPanel Createuser;
    private javax.swing.JLabel RetailLabel;
    private javax.swing.JLabel RetailLabel1;
    private javax.swing.JLabel RetailLabel2;
    private javax.swing.JLabel Useroff;
    private javax.swing.JLabel Useron;
    private javax.swing.JLabel backbutt;
    private javax.swing.JLabel backbutt1;
    private javax.swing.JLabel boxLabel;
    private javax.swing.JLabel boxLabel1;
    private javax.swing.JLabel boxLabel2;
    private javax.swing.JTextField buyingprice;
    private javax.swing.JComboBox<String> category;
    private javax.swing.JLabel changepass;
    private javax.swing.JCheckBox check;
    private javax.swing.JCheckBox check1;
    private javax.swing.JLabel clearbutt;
    private javax.swing.JLabel clearbutt1;
    private javax.swing.JLabel clearbutt2;
    private javax.swing.JLabel clearbutt3;
    private javax.swing.JLabel clearpanel;
    private javax.swing.JLabel clearpanel1;
    private javax.swing.JLabel clearpanel2;
    private javax.swing.JLabel clearpanel3;
    private javax.swing.JLabel count;
    private javax.swing.JLabel count1;
    private javax.swing.JLabel count2;
    private javax.swing.JLabel createuser;
    private javax.swing.JComboBox<String> custCombo;
    private javax.swing.JLabel custName;
    private javax.swing.JTextField customer;
    private javax.swing.JTextField customer1;
    private javax.swing.JTextField customer2;
    private javax.swing.JComboBox<String> customerCombo;
    private javax.swing.JComboBox<String> customerCombo1;
    private javax.swing.JLabel customerid;
    private javax.swing.JLabel customerid1;
    private javax.swing.JLabel customerid2;
    private javax.swing.JLabel customerindicator;
    private javax.swing.JLabel customerindicator1;
    private javax.swing.JLabel customerindicator2;
    private javax.swing.JLabel deletebutt;
    private javax.swing.JLabel deletebutt1;
    private javax.swing.JLabel deletebutt2;
    private javax.swing.JLabel deletebutt3;
    private javax.swing.JLabel deletepanel;
    private javax.swing.JLabel deletepanel1;
    private javax.swing.JLabel deletepanel2;
    private javax.swing.JLabel deletepanel3;
    private javax.swing.JTextField description;
    private javax.swing.JLabel disnote;
    private javax.swing.JLabel disnote1;
    private javax.swing.JLabel display;
    private javax.swing.JLabel display1;
    private javax.swing.JLabel editButton;
    private javax.swing.JLabel editbutt;
    private javax.swing.JLabel editbutt1;
    private javax.swing.JTextField editlabel;
    private javax.swing.JTextField editlabel1;
    private javax.swing.JLabel editpanel;
    private javax.swing.JLabel error;
    private javax.swing.JLabel error1;
    private javax.swing.JLabel error2;
    private javax.swing.JLabel error3;
    private javax.swing.JLabel error4;
    private javax.swing.JLabel errorclose;
    private javax.swing.JLabel errorclose1;
    private javax.swing.JLabel errormsg;
    private javax.swing.JLabel errormsg1;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel exitbutt;
    private javax.swing.JLabel exitbutt1;
    private javax.swing.JLabel exitbutt2;
    private javax.swing.JLabel exitbutt3;
    private javax.swing.JLabel exitpanel;
    private javax.swing.JLabel exitpanel1;
    private javax.swing.JLabel exitpanel2;
    private javax.swing.JLabel exitpanel3;
    private javax.swing.JLabel eyeoneoff;
    private javax.swing.JLabel eyeoneon;
    private javax.swing.JLabel eyetwooff;
    private javax.swing.JLabel eyetwooff1;
    private javax.swing.JLabel eyetwoon;
    private javax.swing.JLabel eyetwoon1;
    private javax.swing.JLabel gif;
    private javax.swing.JLabel gif1;
    private javax.swing.JLabel gif2;
    private javax.swing.JLabel gui;
    private javax.swing.JLabel gui1;
    private javax.swing.JLabel gui2;
    private javax.swing.JLabel gui3;
    private javax.swing.JLabel gui4;
    private javax.swing.JLabel gui5;
    private javax.swing.JLabel gui6;
    private javax.swing.JLabel header;
    private javax.swing.JLabel header1;
    private javax.swing.JLabel header2;
    private javax.swing.JLabel header3;
    private javax.swing.JLabel instocklabel;
    private javax.swing.JLabel instocklabel1;
    private javax.swing.JLabel instocklabel2;
    private javax.swing.JLabel instocklimit;
    private javax.swing.JLabel instocklimit1;
    private javax.swing.JLabel instocklimit2;
    private javax.swing.JLabel instocklimit3;
    private javax.swing.JPanel invoice;
    private javax.swing.JLabel invoiceclick;
    private javax.swing.JLabel invoiceclick1;
    private javax.swing.JLabel invoiceclick2;
    private javax.swing.JLabel invoiceclick3;
    private javax.swing.JLabel invoicecounter;
    private javax.swing.JLabel invoicecounter1;
    private javax.swing.JLabel invoicecounter2;
    private javax.swing.JLabel invoicecounter3;
    private javax.swing.JLabel invoicepanelview;
    private javax.swing.JLabel invoicepanelview1;
    private javax.swing.JLabel invoicepanelview2;
    private javax.swing.JLabel invoicepanelview3;
    private javax.swing.JComboBox<String> invoicepercentage;
    private javax.swing.JLabel invoicerecord;
    private javax.swing.JLabel invoicerecord1;
    private javax.swing.JLabel invoicerecord2;
    private javax.swing.JLabel invoicerecord3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JScrollPane list;
    private javax.swing.JPanel main;
    private javax.swing.JLabel mouseDrag;
    private javax.swing.JLabel mouseDrag1;
    private javax.swing.JLabel nameCode;
    private javax.swing.JLabel nameCode1;
    private javax.swing.JLabel nameCode2;
    private javax.swing.JComboBox<String> nameCombo;
    private javax.swing.JComboBox<String> nameCombo1;
    private javax.swing.JComboBox<String> nameCombo2;
    private javax.swing.JTextField namefield;
    private javax.swing.JLabel namelabel;
    private javax.swing.JLabel namelabel1;
    private javax.swing.JTextField namesearch;
    private javax.swing.JPasswordField newpass;
    private javax.swing.JPasswordField newpass1;
    private javax.swing.JLabel ok;
    private javax.swing.JLabel ok1;
    private javax.swing.JLabel ok2;
    private javax.swing.JLabel oldinvoice;
    private javax.swing.JLabel oldinvoice1;
    private javax.swing.JPasswordField oldpass;
    private javax.swing.JTextField orderField;
    private javax.swing.JLabel ordercheck;
    private javax.swing.JLabel ordercheck1;
    private javax.swing.JLabel ordercheck2;
    private javax.swing.JLabel ordercheck3;
    private javax.swing.JLabel orderid;
    private javax.swing.JLabel orderid2;
    private javax.swing.JLabel orderid3;
    private javax.swing.JLabel orderid4;
    private javax.swing.JLabel orderid5;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel percenlabel;
    private javax.swing.JLabel percenlabel1;
    private javax.swing.JLabel percenlabel2;
    private javax.swing.JLabel percenlabel3;
    private javax.swing.JComboBox<String> percentage;
    private javax.swing.JComboBox<String> percentage1;
    private javax.swing.JComboBox<String> percentage2;
    private javax.swing.JComboBox<String> percentage3;
    private javax.swing.JComboBox<String> percentage4;
    private javax.swing.JComboBox<String> percentage5;
    private javax.swing.JTextField piecesinbox;
    private javax.swing.JLabel playbutton;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JLabel priceLabel1;
    private javax.swing.JLabel priceLabel2;
    private javax.swing.JLabel pricefortable;
    private javax.swing.JLabel pricefortable1;
    private javax.swing.JLabel pricefortable2;
    private javax.swing.JLabel printbutt;
    private javax.swing.JLabel printbutt1;
    private javax.swing.JLabel printbutt2;
    private javax.swing.JLabel printerbutt;
    private javax.swing.JLabel printerbutt1;
    private javax.swing.JLabel printerbutt2;
    private javax.swing.JLabel printerbutt3;
    private javax.swing.JLabel printpanel;
    private javax.swing.JLabel printpanel1;
    private javax.swing.JLabel printpanel2;
    private javax.swing.JLabel printpanel3;
    private javax.swing.JLabel printpanelview;
    private javax.swing.JLabel printpanelview1;
    private javax.swing.JLabel printpanelview2;
    private javax.swing.JPanel product;
    private javax.swing.JLabel productbutt;
    private javax.swing.JLabel productbutt1;
    private javax.swing.JLabel productbutt2;
    private javax.swing.JLabel productbutt3;
    private javax.swing.JPanel productlogin;
    private javax.swing.JLabel productspanel;
    private javax.swing.JLabel productspanel1;
    private javax.swing.JLabel productspanel2;
    private javax.swing.JLabel productspanel3;
    private javax.swing.JTextField quantityField;
    private javax.swing.JTextField quantityField1;
    private javax.swing.JTextField quantityField2;
    private javax.swing.JLabel refreshbutt;
    private javax.swing.JLabel refreshbutt1;
    private javax.swing.JLabel refreshbutt2;
    private javax.swing.JLabel refreshbutt3;
    private javax.swing.JLabel refreshclick;
    private javax.swing.JLabel refreshclick1;
    private javax.swing.JLabel refreshclick2;
    private javax.swing.JLabel refreshpanelview;
    private javax.swing.JLabel refreshpanelview1;
    private javax.swing.JLabel refreshpanelview2;
    private javax.swing.JLabel salesLabel;
    private javax.swing.JLabel salesLabel1;
    private javax.swing.JLabel salesLabel2;
    private javax.swing.JLabel salesLabel3;
    private javax.swing.JLabel salesicon;
    private javax.swing.JLabel salesicon1;
    private javax.swing.JLabel salesicon2;
    private javax.swing.JLabel salesicon3;
    private javax.swing.JLabel savebutt;
    private javax.swing.JLabel savebutt1;
    private javax.swing.JLabel savebutton;
    private javax.swing.JLabel savebutton1;
    private javax.swing.JLabel savebutton2;
    private javax.swing.JLabel savebutton3;
    private javax.swing.JLabel savepanel;
    private javax.swing.JLabel savepanel1;
    private javax.swing.JLabel savepanel2;
    private javax.swing.JLabel savepanel3;
    private javax.swing.JTextField sellingprice;
    private javax.swing.JLabel settings;
    private javax.swing.JLabel settings1;
    private javax.swing.JLabel settings2;
    private javax.swing.JLabel settings3;
    private javax.swing.JLabel settingsoff;
    private javax.swing.JLabel settingsoff1;
    private javax.swing.JLabel settingsoff2;
    private javax.swing.JLabel settingsoff3;
    private javax.swing.JLabel settingson;
    private javax.swing.JLabel settingson1;
    private javax.swing.JLabel settingson2;
    private javax.swing.JLabel settingson3;
    private javax.swing.JLabel settingspanelview;
    private javax.swing.JLabel settingspanelview1;
    private javax.swing.JLabel settingspanelview2;
    private javax.swing.JLabel settingspanelview3;
    private javax.swing.JTextField stock;
    private javax.swing.JLabel success;
    private javax.swing.JLabel success1;
    private javax.swing.JLabel success2;
    private javax.swing.JLabel sumtotal;
    private javax.swing.JLabel sumtotal1;
    private javax.swing.JLabel sumtotal2;
    private javax.swing.JLabel sumtotal3;
    private javax.swing.JTable table;
    private javax.swing.JTable table1;
    private javax.swing.JTable table2;
    private javax.swing.JPanel tillone;
    private javax.swing.JLabel tilloneclick;
    private javax.swing.JLabel tilloneclick1;
    private javax.swing.JLabel tilloneclick2;
    private javax.swing.JLabel tilloneclick3;
    private javax.swing.JLabel tillonepanelview;
    private javax.swing.JLabel tillonepanelview1;
    private javax.swing.JLabel tillonepanelview2;
    private javax.swing.JLabel tillonepanelview3;
    private javax.swing.JPanel tilltwo;
    private javax.swing.JLabel tilltwoclick;
    private javax.swing.JLabel tilltwoclick1;
    private javax.swing.JLabel tilltwoclick2;
    private javax.swing.JLabel tilltwoclick3;
    private javax.swing.JLabel tilltwopanelview;
    private javax.swing.JLabel tilltwopanelview1;
    private javax.swing.JLabel tilltwopanelview2;
    private javax.swing.JLabel tilltwopanelview3;
    private javax.swing.JLabel typeLabel;
    private javax.swing.JLabel typeLabel1;
    private javax.swing.JLabel typeLabel2;
    private javax.swing.JLabel updatebutt;
    private javax.swing.JLabel updatebutt1;
    private javax.swing.JLabel updatebutt2;
    private javax.swing.JLabel updatebutt3;
    private javax.swing.JLabel updatepanel;
    private javax.swing.JLabel updatepanel1;
    private javax.swing.JLabel updatepanel2;
    private javax.swing.JLabel updatepanel3;
    private javax.swing.JLabel userclick1;
    private javax.swing.JLabel userclick2;
    private javax.swing.JLabel userclick3;
    private javax.swing.JLabel userpanelview;
    private javax.swing.JLabel userpanelview1;
    private javax.swing.JLabel userpanelview2;
    private javax.swing.JLabel userpanelview3;
    // End of variables declaration//GEN-END:variables
}
