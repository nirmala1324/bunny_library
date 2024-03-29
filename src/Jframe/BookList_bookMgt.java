/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Jframe;

import java.sql.Blob;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

/**
 *
 * @author nirma
 */
public class BookList_bookMgt extends javax.swing.JFrame {

    /**
     * Creates new form BookList_bookMgt
     */
    
    DefaultTableModel model;
    int positionX = 0, positionY = 0;
    
    public BookList_bookMgt() {
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
        
        JTableHeader tableHeader = book_table.getTableHeader();
        tableHeader.setForeground(Color.red); 
        setBookDetailsToTable();
    }
    
    private ImageIcon RImage(ImageIcon imagePath){
        Image img = imagePath.getImage();
        Image newImage = img.getScaledInstance(label_bookCover.getWidth(), label_bookCover.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        return image;
    }
    
    public void setBookDetailsToTable(){
        
        try{
            Connection conn = database.getConnection();
            String query = "SELECT * FROM book_data";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()){
                String bookid = rs.getString("book_id");
                String booktitle = rs.getString("book_title");
                String bookcat = rs.getString("book_genre");
                String bookauthor = rs.getString("book_author");
                
                Object[] obj = {bookid, booktitle, bookcat, bookauthor};
                model = (DefaultTableModel)book_table.getModel();
                model.addRow(obj);
                book_table.setShowVerticalLines(true);
                book_table.setShowHorizontalLines(true);
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        MultiLineJTable renderer = new MultiLineJTable();
        
        //set table cell renderer into a specified JTable column class
        book_table.setDefaultRenderer(String[].class, renderer);
        
    }
    
    public void clearTable(){
        DefaultTableModel model = (DefaultTableModel) book_table.getModel();
        model.setRowCount(0);
    }
    
    public boolean DeleteBook(){
        
        boolean isDeleted = false;
        
        String bookid = bookid_ttext.getText();
        
        try {
                    
               Connection dbconnect = database.getConnection();
               String sql = "DELETE FROM book_data WHERE book_id = ?";
               PreparedStatement ps = dbconnect.prepareStatement(sql);
               ps.setString(1, bookid);
               
               int rowCount = ps.executeUpdate();
               
               if (rowCount >0){
                   isDeleted = true;
               }else {
                   isDeleted = false;
               }
               
        }   catch (Exception e) {
            e.printStackTrace();
        }
        
        return isDeleted;
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
        jPanel2 = new javax.swing.JPanel();
        minimize_button = new javax.swing.JButton();
        exit_button = new javax.swing.JButton();
        back_button = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        book_table = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        label_bookCover = new javax.swing.JLabel();
        bookid_ttext = new javax.swing.JTextField();
        editBookBtn = new javax.swing.JButton();
        deleteBookBtn = new javax.swing.JButton();
        addBookBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

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

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));

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

        back_button.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        back_button.setForeground(new java.awt.Color(255, 51, 51));
        back_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyAsset/back.png"))); // NOI18N
        back_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                back_buttonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                back_buttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                back_buttonMouseExited(evt);
            }
        });
        back_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_buttonActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyAsset/moon.png"))); // NOI18N
        jLabel9.setText("Book Management");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(back_button, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                    .addComponent(back_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(8, 8, 8))
        );

        book_table.setBackground(new java.awt.Color(255, 204, 204));
        book_table.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        book_table.setForeground(new java.awt.Color(102, 102, 102));
        book_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book ID", "Book Title", "Book Genre", "Book Author"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        book_table.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        book_table.setGridColor(new java.awt.Color(255, 255, 255));
        book_table.setRowHeight(50);
        book_table.setSelectionBackground(new java.awt.Color(255, 153, 153));
        book_table.setSelectionForeground(new java.awt.Color(255, 255, 255));
        book_table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        book_table.setShowGrid(true);
        book_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                book_tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(book_table);
        if (book_table.getColumnModel().getColumnCount() > 0) {
            book_table.getColumnModel().getColumn(0).setMinWidth(80);
            book_table.getColumnModel().getColumn(0).setMaxWidth(80);
            book_table.getColumnModel().getColumn(1).setMinWidth(400);
            book_table.getColumnModel().getColumn(1).setMaxWidth(400);
            book_table.getColumnModel().getColumn(2).setMinWidth(90);
            book_table.getColumnModel().getColumn(2).setMaxWidth(90);
        }

        jPanel3.setBackground(new java.awt.Color(255, 102, 102));

        label_bookCover.setBackground(new java.awt.Color(255, 255, 255));

        bookid_ttext.setFont(new java.awt.Font("STFangsong", 0, 12)); // NOI18N
        bookid_ttext.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bookid_ttext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookid_ttextActionPerformed(evt);
            }
        });

        editBookBtn.setFont(new java.awt.Font("STFangsong", 1, 14)); // NOI18N
        editBookBtn.setForeground(new java.awt.Color(255, 0, 0));
        editBookBtn.setText("Edit Book");
        editBookBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editBookBtnMouseClicked(evt);
            }
        });

        deleteBookBtn.setFont(new java.awt.Font("STFangsong", 1, 14)); // NOI18N
        deleteBookBtn.setForeground(new java.awt.Color(255, 0, 0));
        deleteBookBtn.setText("Delete Book");
        deleteBookBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteBookBtnMouseClicked(evt);
            }
        });
        deleteBookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBookBtnActionPerformed(evt);
            }
        });

        addBookBtn.setBackground(new java.awt.Color(255, 204, 204));
        addBookBtn.setFont(new java.awt.Font("STFangsong", 1, 16)); // NOI18N
        addBookBtn.setForeground(new java.awt.Color(255, 51, 51));
        addBookBtn.setText("Add Book");
        addBookBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addBookBtnMouseClicked(evt);
            }
        });
        addBookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBookBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(editBookBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                            .addComponent(deleteBookBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addBookBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(39, 39, 39))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(label_bookCover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bookid_ttext, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
                        .addGap(55, 55, 55))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(label_bookCover, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bookid_ttext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(editBookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deleteBookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(addBookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        jLabel1.setFont(new java.awt.Font("Yu Mincho", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Book Data List");
        jLabel1.setMaximumSize(new java.awt.Dimension(138, 40));
        jLabel1.setMinimumSize(new java.awt.Dimension(138, 40));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 806, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

    private void back_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_buttonMouseClicked
        // TODO add your handling code here:
        // Call register member page
        HomePage homep = new HomePage();
        homep.setVisible(true);

        //close the login page
        this.dispose();
    }//GEN-LAST:event_back_buttonMouseClicked

    private void back_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_buttonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_back_buttonMouseEntered

    private void back_buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_buttonMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_back_buttonMouseExited

    private void back_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_back_buttonActionPerformed

    private void deleteBookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBookBtnActionPerformed
        // TODO add your handling code here:
        
        String bookid = bookid_ttext.getText();
        
        try{
            Connection conn = database.getConnection();
            String query = "SELECT * FROM `book_data` WHERE book_id = '" + bookid + "';" ;
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            rs.next();
            String delBookTitle = rs.getString("book_title");

        
        if(!bookid.trim().equals("")){
            if (DeleteBook() == true){
               JOptionPane.showMessageDialog(this, delBookTitle +" is succesfully deleted");
               clearTable();
               setBookDetailsToTable();
               label_bookCover.setIcon(null);
               bookid_ttext.setText("");
            }else{
               JOptionPane.showMessageDialog(this, "Failed to delete book " + delBookTitle);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Click book data you want to delete");
        }
        
        } catch (SQLException ex) {
            Logger.getLogger(BookList_bookMgt.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_deleteBookBtnActionPerformed

    private void bookid_ttextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookid_ttextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookid_ttextActionPerformed

    private void addBookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBookBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addBookBtnActionPerformed

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        positionX = evt.getX();
        positionY = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        setLocation(evt.getXOnScreen()-positionX, evt.getYOnScreen()-positionY);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void book_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_book_tableMouseClicked
        
        int rowNo = book_table.getSelectedRow();
        TableModel model = book_table.getModel();
        
        
        String bookid = model.getValueAt(rowNo, 0).toString();
        
        bookid_ttext.setText(bookid);
        
        try{
            Connection conn = database.getConnection();
            String query = "SELECT * FROM `book_data` WHERE book_id = '" + bookid + "';" ;
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            byte[] imgData = null;
            
            rs.next();
            Blob image2 = rs.getBlob("book_photo");
            imgData = image2.getBytes(1, (int)image2.length());
            BufferedImage im = ImageIO.read(new ByteArrayInputStream(imgData));
            ImageIcon newImage = new ImageIcon(im);
            label_bookCover.setIcon(RImage(newImage));

        } catch (SQLException ex) {
            Logger.getLogger(BookList_bookMgt.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BookList_bookMgt.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_book_tableMouseClicked

    private void editBookBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editBookBtnMouseClicked
        // TODO add your handling code here:
        
        String txtBookId = bookid_ttext.getText();
        
        if(txtBookId.trim().equals("")){
            
            JOptionPane.showMessageDialog(null, "Please input or click specified book that need to be edited", "Empty Field", 2);
        
        } else {
            
            new EditBookPage(txtBookId).setVisible(true);
            this.dispose();
            
        }
        
    }//GEN-LAST:event_editBookBtnMouseClicked

    private void addBookBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBookBtnMouseClicked
       
        AddBookPage addBook = new AddBookPage();
        
        addBook.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_addBookBtnMouseClicked

    private void deleteBookBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBookBtnMouseClicked

    }//GEN-LAST:event_deleteBookBtnMouseClicked

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
            java.util.logging.Logger.getLogger(BookList_bookMgt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookList_bookMgt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookList_bookMgt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookList_bookMgt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookList_bookMgt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBookBtn;
    private javax.swing.JButton back_button;
    private javax.swing.JTable book_table;
    private javax.swing.JTextField bookid_ttext;
    private javax.swing.JButton deleteBookBtn;
    private javax.swing.JButton editBookBtn;
    private javax.swing.JButton exit_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label_bookCover;
    private javax.swing.JButton minimize_button;
    // End of variables declaration//GEN-END:variables
    private static class ImageRender extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JLabel jlabel = new JLabel();
            byte[] bytes = (byte[]) value;
            ImageIcon imageIcon = new ImageIcon(
                    new ImageIcon(bytes).getImage().getScaledInstance(165, 280, Image.SCALE_DEFAULT)
            );
            jlabel.setIcon(imageIcon);
            return jlabel;
        }
    }

}


