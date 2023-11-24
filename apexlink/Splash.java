/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apexlink;

import com.jtattoo.plaf.DecorationHelper;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import org.apache.commons.dbutils.DbUtils;

/**
 *
 * @author Leafyheader
 */
public class Splash extends javax.swing.JFrame {
protected int minValue = 0;

    protected int maxValue = 100;

    protected int counter = 0;
  private static final String CREATE_TABLE = "CREATE TABLE reader1 (name VARCHAR(45))";
private static final String DROP_TABLE = "DROP TABLE reader1"; 
   // protected JProgressBar progressBar;

    /**
     * Creates new form Splash
     */
    public Splash() {
        initComponents();
        setIcon();
       // start();
       password.setEnabled(false);
       password.setVisible(false);
       username.setEnabled(false);
username.setVisible(false);
        splash();
    }
  private void Dropreader() {
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
private void Createreload() {
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
    private void setIcon(){
     setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icons/logo.png")));
}
private void start(){
    Splash  Splash = new Splash();
       Splash.setVisible(true);
       try{
           for (int i=0;i<=100;i++){
               Thread.sleep(70);
               Splash.loadingnumber.setText(Integer.toString(i)+"%");
               Splash.loadingbar.setValue(i);
              
               }
             if (loadingnumber.getText()=="99"){
                    new Apexold().setVisible(true);
       }
    
}catch(Exception e){
    
            }
         
}

public void splash(){
    Thread runner = new Thread() {
                    public void run() {
                        counter = minValue;
                        while (counter <= maxValue) {
                            Runnable runme = new Runnable() {
                                public void run() {
                                    loadingnumber.setText(Integer.toString(counter));
                                    loadingbar.setValue(counter);
                                }
                            };
                            SwingUtilities.invokeLater(runme);
                            counter++;
                            try {
                                Thread.sleep(60);
                            } catch (Exception ex) {
                            }
                        }
                         if (counter ==101){
                     gui.setIcon(new ImageIcon(getClass().getResource("/images/login 2.png")));
loadingbar.setEnabled(false);
loadingbar.setVisible(false);
password.setEnabled(true);
password.setVisible(true);
username.setEnabled(true);
username.setVisible(true);
username.requestFocus();
                      //dispose();
                    
                }
                    }
                };
                runner.start();
               
            }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loadingbar = new javax.swing.JProgressBar();
        password = new javax.swing.JPasswordField();
        username = new javax.swing.JTextField();
        login = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        gui = new javax.swing.JLabel();
        loadingnumber = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loadingbar.setBackground(new java.awt.Color(50, 105, 196));
        loadingbar.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(loadingbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 330, 5));

        password.setBackground(new java.awt.Color(0, 52, 113));
        password.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        password.setForeground(new java.awt.Color(255, 255, 255));
        password.setBorder(null);
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 268, 250, 28));

        username.setBackground(new java.awt.Color(0, 52, 113));
        username.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        username.setForeground(new java.awt.Color(255, 255, 255));
        username.setBorder(null);
        username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                usernameKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                usernameKeyTyped(evt);
            }
        });
        getContentPane().add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 192, 260, 30));

        login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                loginMousePressed(evt);
            }
        });
        getContentPane().add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 240, 30));

        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_delete_32px.png"))); // NOI18N
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                closeMousePressed(evt);
            }
        });
        getContentPane().add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, -1, -1));

        gui.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/splash.png"))); // NOI18N
        getContentPane().add(gui, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        loadingnumber.setBackground(new java.awt.Color(255, 255, 255));
        loadingnumber.setForeground(new java.awt.Color(255, 255, 255));
        loadingnumber.setText("99");
        getContentPane().add(loadingnumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 350, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseEntered
      gui.setIcon(new ImageIcon(getClass().getResource("/images/login1.png")));

    }//GEN-LAST:event_loginMouseEntered

    private void loginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseExited
         gui.setIcon(new ImageIcon(getClass().getResource("/images/login 2.png")));
    }//GEN-LAST:event_loginMouseExited

    private void usernameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameKeyTyped
        char keyChar = evt.getKeyChar();
    if (Character.isLowerCase(keyChar)) {
      evt.setKeyChar(Character.toUpperCase(keyChar));
    }//GEN-LAST:event_usernameKeyTyped
    }
    private void usernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameKeyPressed
       if (evt.getKeyCode() == KeyEvent.VK_ENTER){
             password.requestFocusInWindow();
         }     
    }//GEN-LAST:event_usernameKeyPressed

    private void loginMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMousePressed
       Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
        conn= mysqlconnect.ConnectDb();
        
        String sql = "select * from applogin where name = ? and password = ? ";
    try{
        pst = conn.prepareStatement(sql);
        pst.setString(1, username.getText());
        pst.setString(2, new String( password.getPassword()));
        rs = pst.executeQuery();
        if (rs.next()){
            String sql1 = "insert into reader1 (name) values(?)";
            pst = conn.prepareStatement(sql1);
             pst.setString(1, username.getText());
             pst.execute();
        //    JOptionPane.showMessageDialog(null, "SYSTEM READY");
            Apex
                    s = new Apex();
            s.setVisible(true);
             dispose();
        }
        else
            JOptionPane.showMessageDialog(null, "Invalid username or password");     
        
    }
    catch (Exception e){
        JOptionPane.showMessageDialog(null, e);
       
         }
    finally{
               
    DbUtils.closeQuietly(rs);
    DbUtils.closeQuietly(pst);
    DbUtils.closeQuietly(conn);
        }
           
    }//GEN-LAST:event_loginMousePressed

    private void closeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMousePressed
       System.exit(0);
    }//GEN-LAST:event_closeMousePressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
Dropreader();
        Createreload();  

     
    }//GEN-LAST:event_formWindowOpened

   /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        UIManager.put("loadingbar.selectionBackground", Color.black);
        UIManager.put("loadingbar.selectionForeground", Color.white);
        UIManager.put("loadingbar.foreground", new Color(255, 255, 255));
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
            java.util.logging.Logger.getLogger(Apexold.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Apexold.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Apexold.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Apexold.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Splash().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel close;
    private javax.swing.JLabel gui;
    private javax.swing.JProgressBar loadingbar;
    private javax.swing.JLabel loadingnumber;
    private javax.swing.JLabel login;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
