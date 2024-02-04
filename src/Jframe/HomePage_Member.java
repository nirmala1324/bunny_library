/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Jframe;

import static Jframe.BookCollection.usernameshow;
import static Jframe.BookShelf.unameshow;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

/**
 *
 * @author nirma
 */
public class HomePage_Member extends javax.swing.JFrame {

    // button border
    int positionX = 0, positionY = 0;
    Border buttonBorder = BorderFactory.createMatteBorder(0, 0, 1 , 0 , Color.white);
    Border buttonBorder0 = BorderFactory.createMatteBorder(1, 1, 1 , 1 , new Color (255,153,153));
    /**
     * Creates new form HomePage
     */
    public HomePage_Member() {
        
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
        
        addBorders();
        
        // display image
        displayImage();
        
        // add border to panel header
        Border panelHeaderBorder = BorderFactory.createMatteBorder(0, 0, 1 , 0 , Color.white);
        jPanel_header.setBorder(panelHeaderBorder);
    }
    
    // create a function to display image in jlabel
    public void displayImage(){
        // get the image
        ImageIcon imgicon = new ImageIcon(getClass().getResource("/MyAsset/book.png"));
        
        // make the image fit the jlabel
        Image img = imgicon.getImage().getScaledInstance(homepage_logo.getWidth(), homepage_logo.getHeight(), Image.SCALE_SMOOTH);
        
        // set the image to the jlabel
        homepage_logo.setIcon(new ImageIcon(img));
        // call hover effect function
        
        addBorders();
        
        buttonsHover();
    }
    
    // adding border to the menu panel button
    public void addBorders(){
        // get all component inside jpanel menu
        Component[] compss = jPanel_menu.getComponents();
        
        for(Component compp : compss)
        {
            // check if component is a button
            if(compp instanceof JButton buttonn){
                
                // add border
                buttonn.setBorder(buttonBorder0);
            }
        }            
    }
    
    // function to add a hover effect on navigation bar
    public void buttonsHover(){
       Component[] comps = jPanel_menu.getComponents();
       
       for(Component comp : comps)
       {
          // check if the component is a button
           if(comp instanceof JButton button)
           {
               
               // add the action we want to the button
               button.addMouseListener(new MouseAdapter() {
                   
                   @Override
                   public void mouseEntered(MouseEvent evt)
                   {
                       button.setBorder(buttonBorder);
                   }
                   
                   @Override
                   public void mouseExited(MouseEvent evt)
                   {
                       button.setBorder(buttonBorder0);
                   }
               });
           }
       }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel_menu = new javax.swing.JPanel();
        jPanel_header = new javax.swing.JPanel();
        homepage_logo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        bookShelf = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        bookCollectionBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        minimize_button = new javax.swing.JButton();
        exit_button = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        jPanel_menu.setBackground(new java.awt.Color(255, 153, 153));

        jPanel_header.setBackground(new java.awt.Color(254, 103, 110));

        jLabel1.setFont(new java.awt.Font("Lucida Fax", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Bunny Library");

        javax.swing.GroupLayout jPanel_headerLayout = new javax.swing.GroupLayout(jPanel_header);
        jPanel_header.setLayout(jPanel_headerLayout);
        jPanel_headerLayout.setHorizontalGroup(
            jPanel_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_headerLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(homepage_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel_headerLayout.setVerticalGroup(
            jPanel_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_headerLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_headerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(homepage_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 102, 102));

        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyAsset/book2.png"))); // NOI18N
        jButton5.setText("HomePage");
        jButton5.setContentAreaFilled(false);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bookShelf.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bookShelf.setForeground(new java.awt.Color(255, 255, 255));
        bookShelf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyAsset/book2.png"))); // NOI18N
        bookShelf.setText("My Book Shelf");
        bookShelf.setContentAreaFilled(false);
        bookShelf.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bookShelf.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bookShelf.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        bookShelf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookShelfMouseClicked(evt);
            }
        });
        bookShelf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookShelfActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Features");

        bookCollectionBtn.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bookCollectionBtn.setForeground(new java.awt.Color(255, 255, 255));
        bookCollectionBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyAsset/book2.png"))); // NOI18N
        bookCollectionBtn.setText("Book Collection");
        bookCollectionBtn.setContentAreaFilled(false);
        bookCollectionBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bookCollectionBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bookCollectionBtn.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        bookCollectionBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookCollectionBtnMouseClicked(evt);
            }
        });
        bookCollectionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookCollectionBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_menuLayout = new javax.swing.GroupLayout(jPanel_menu);
        jPanel_menu.setLayout(jPanel_menuLayout);
        jPanel_menuLayout.setHorizontalGroup(
            jPanel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_menuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(bookShelf, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                        .addComponent(bookCollectionBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(33, 33, 33))
        );
        jPanel_menuLayout.setVerticalGroup(
            jPanel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_menuLayout.createSequentialGroup()
                .addComponent(jPanel_header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel8)
                .addGap(36, 36, 36)
                .addComponent(bookCollectionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bookShelf, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 70, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));

        jLabel9.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyAsset/moon.png"))); // NOI18N
        jLabel9.setText("Library Home Page");

        minimize_button.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        minimize_button.setForeground(new java.awt.Color(255, 51, 51));
        minimize_button.setText("-");
        minimize_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minimize_buttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minimize_buttonMouseExited(evt);
            }
        });
        minimize_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimize_buttonActionPerformed(evt);
            }
        });

        exit_button.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        exit_button.setForeground(new java.awt.Color(255, 51, 51));
        exit_button.setText("X");
        exit_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exit_buttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exit_buttonMouseExited(evt);
            }
        });
        exit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(minimize_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exit_button)
                .addGap(9, 9, 9))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(minimize_button)
                    .addComponent(exit_button)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        usernamee.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        usernamee.setForeground(new java.awt.Color(255, 51, 51));
        usernamee.setText("jLabel2");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("Hello,");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernamee, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(240, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(usernamee)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(jPanel_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void minimize_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimize_buttonMouseEntered
        // Mouse entered event change button background color
        minimize_button.setBackground(Color.red);
        minimize_button.setForeground(Color.white);
    }//GEN-LAST:event_minimize_buttonMouseEntered

    private void minimize_buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimize_buttonMouseExited
        // Mouse Exited even
        minimize_button.setBackground(new Color(255,255,255));
        minimize_button.setForeground(Color.red);
    }//GEN-LAST:event_minimize_buttonMouseExited

    private void minimize_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimize_buttonActionPerformed
        // Minimize button click event
        // Minimize JFrame WIndow
        setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_minimize_buttonActionPerformed

    private void exit_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_buttonMouseEntered
        exit_button.setBackground(Color.red);
        exit_button.setForeground(Color.white);
    }//GEN-LAST:event_exit_buttonMouseEntered

    private void exit_buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_buttonMouseExited
        exit_button.setBackground(new Color(255,255,255));
        exit_button.setForeground(Color.red);
    }//GEN-LAST:event_exit_buttonMouseExited

    private void exit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_buttonActionPerformed
        dispose();
    }//GEN-LAST:event_exit_buttonActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void bookCollectionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookCollectionBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookCollectionBtnActionPerformed

    private void bookShelfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookShelfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookShelfActionPerformed

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        // TODO add your handling code here:
        // GetX and Y coordinate values
        positionX = evt.getX();
        positionY = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        // JFrame MouseListener event-MouseDragged
        // set JFrame Location
        setLocation(evt.getXOnScreen()-positionX, evt.getYOnScreen()-positionY);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void bookCollectionBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookCollectionBtnMouseClicked
        String username = usernamee.getText();
        ResultSet rs ;
        PreparedStatement ps;
        
        String query = "SELECT * FROM `member` WHERE `username` = ?";
        
        try {
                ps = database.getConnection().prepareStatement(query);
                ps.setString(1, username);
                rs = ps.executeQuery();
                
                //Check if the user is exist
                if(rs.next()){ //If the user exist
                    
                    // Call book collection page
                    BookCollection book_col = new BookCollection();
                    book_col.setVisible(true);
                    usernameshow.setText(rs.getString("username"));
        
                    //close the home page
                    this.dispose();
                    
                }
            } catch (java.sql.SQLException ex) {
                Logger.getLogger(HomePage_Member.class.getName()).log(Level.SEVERE, null, ex);
            }
                    
    }//GEN-LAST:event_bookCollectionBtnMouseClicked

    private void bookShelfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookShelfMouseClicked
        // TODO add your handling code here:
        String username = usernamee.getText();
        ResultSet rs ;
        PreparedStatement ps;
        
        String query = "SELECT * FROM `member` WHERE `username` = ?";
        
        try {
                ps = database.getConnection().prepareStatement(query);
                ps.setString(1, username);
                rs = ps.executeQuery();
                
                //Check if the user is exist
                if(rs.next()){ //If the user exist
                    
                    // Call book collection page
                    BookShelf bookshelf = new BookShelf();
                    bookshelf.setVisible(true);
                    unameshow.setText(rs.getString("username"));
        
                    //close the home page
                    this.dispose();
                    
                }
            } catch (java.sql.SQLException ex) {
                Logger.getLogger(HomePage_Member.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_bookShelfMouseClicked

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomePage_Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage_Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage_Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage_Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage_Member().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bookCollectionBtn;
    private javax.swing.JButton bookShelf;
    private javax.swing.JButton exit_button;
    private javax.swing.JLabel homepage_logo;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel_header;
    private javax.swing.JPanel jPanel_menu;
    private javax.swing.JButton minimize_button;
    public static final javax.swing.JLabel usernamee = new javax.swing.JLabel();
    // End of variables declaration//GEN-END:variables
}
