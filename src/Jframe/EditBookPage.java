/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Jframe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nirma
 */
public class EditBookPage extends javax.swing.JFrame {

    /**
     * Creates new form EditBookPage
     */
    
    String imagePath = "";
    byte[] img = null;
    DefaultTableModel model;
    int positionX = 0, positionY = 0;
     
    public EditBookPage() {
        initComponents();
    }
    
    public EditBookPage(String bookid) {

        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
        //Set labels unvisible
        
        SetBookEditData(bookid);
        
        UIManager.put("OptionPane.minimumSize",new Dimension(400,100)); 
        
    }
    
    private ImageIcon RImage(ImageIcon imagePath){
        Image img = imagePath.getImage();
        Image newImage = img.getScaledInstance(bookCover.getWidth(), bookCover.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        return image;
    }
    
    public void SetBookEditData(String idbook) {
        try{
            
            //Fetch data from database
            Connection conn = database.getConnection();
            String query = "SELECT * FROM `book_data` WHERE book_id = '" + idbook + "';";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            byte[] imgData = null;
            
            // Set data to target text field and label 
            rs.next();
            
            txt_bookid.setText(rs.getString("book_id"));
            txt_bookTitle.setText(rs.getString("book_title"));
            genreList.setSelectedItem(rs.getString("book_genre"));
            txt_bookAuthor.setText(rs.getString("book_author"));
            txt_bookSyn1.setText(rs.getString("book_synopsis"));
            
            Blob image2 = rs.getBlob("book_photo");
            imgData = image2.getBytes(1, (int)image2.length());
            BufferedImage im = ImageIO.read(new ByteArrayInputStream(imgData));
            ImageIcon newImage = new ImageIcon(im);
            bookCover.setIcon(RImage(newImage));

        } catch (java.sql.SQLException ex) {
            Logger.getLogger(BookList_bookMgt.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BookList_bookMgt.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public boolean editBook(){
        // Get record data from UI
        boolean isUpdated = false;
        String bookID = txt_bookid.getText();
        String bookTitle = txt_bookTitle.getText();
        String bookGenre = genreList.getSelectedItem().toString();
        String bookAuthor = txt_bookAuthor.getText();
        String bookSynopsis = txt_bookSyn1.getText();  
        
        PreparedStatement ps;
        
    
        try{
                
                Path path = Paths.get(imagePath);
                img = Files.readAllBytes(path);
                
                
                
                
                try {
                    String query1 = "UPDATE book_data SET book_genre = ?, book_title = ?, book_author = ?, book_synopsis = ?, book_photo = ? WHERE book_id = ?";
                    ps = database.getConnection().prepareStatement(query1);
                    
                    ps.setString(1, bookGenre);
                    ps.setString(2, bookTitle);
                    ps.setString(3, bookAuthor);
                    ps.setString(4, bookSynopsis);
                    ps.setBytes (5, img);
                    ps.setString(6, bookID);
                    
                    int rowCount = ps.executeUpdate();
                    
                    if(rowCount > 0){
                        isUpdated = true;
                    } else {
                        isUpdated = false;
                    }
                   
                } catch (java.sql.SQLException ex) {
                    Logger.getLogger(RegisterPage.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (IOException ex) {
                Logger.getLogger(BookManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return isUpdated;
    } 
    
    public boolean editBook2(){
        // Get record data from UI
        boolean isUpdated = false;
        String bookID = txt_bookid.getText();
        String bookTitle = txt_bookTitle.getText();
        String bookGenre = genreList.getSelectedItem().toString();
        String bookAuthor = txt_bookAuthor.getText();
        String bookSynopsis = txt_bookSyn1.getText();  
        
        PreparedStatement ps;
        
    
     
                
                try {
                    String query1 = "UPDATE book_data SET book_genre = ?, book_title = ?, book_author = ?, book_synopsis = ? WHERE book_id = ?";
                    ps = database.getConnection().prepareStatement(query1);
                    
                    ps.setString(1, bookGenre);
                    ps.setString(2, bookTitle);
                    ps.setString(3, bookAuthor);
                    ps.setString(4, bookSynopsis);
                    ps.setString(5, bookID);
                    
                    int rowCount = ps.executeUpdate();
                    
                    if(rowCount > 0){
                        isUpdated = true;
                    } else {
                        isUpdated = false;
                    }
                   
                } catch (java.sql.SQLException ex) {
                    Logger.getLogger(RegisterPage.class.getName()).log(Level.SEVERE, null, ex);
                }
           
        
        return isUpdated;
    } 
    
    
        /**
     * 
     * 
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_bookSyn = new javax.swing.JTextArea();
        bookSynLabel = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        minimize_button = new javax.swing.JButton();
        exit_button = new javax.swing.JButton();
        back_button = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt_bookid = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        genreList = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txt_bookAuthor = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_bookSyn1 = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        bookCover = new javax.swing.JLabel();
        bookCoverLabel = new javax.swing.JLabel();
        bookCoverBtn = new javax.swing.JButton();
        editBookBtn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_bookTitle = new javax.swing.JTextArea();

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Book Synopsis");

        txt_bookSyn.setColumns(20);
        txt_bookSyn.setRows(5);
        jScrollPane1.setViewportView(txt_bookSyn);

        bookSynLabel.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        bookSynLabel.setForeground(new java.awt.Color(255, 255, 0));
        bookSynLabel.setText("* You need to enter the book author");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Book Cover");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));
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

        jLabel9.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyAsset/moon.png"))); // NOI18N
        jLabel9.setText("Book Management - Edit Book");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(back_button)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(minimize_button)
                        .addComponent(exit_button)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Book ID");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Title");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Genre");

        genreList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Genre", "Academic", "Action & Adventure", "Biographies and Autobiographies", "Classics", "Comic Book", "Cookbooks", "Detective and Mystery", "Essays", "Fantasy", "Fiction", "Historical Fiction", "History", "Horror", "Literary Fiction", "Memoir", "Non Fiction", "Poetry ", "Romance", "Science Fiction (Sci-Fi)", "Self-Help", "Short Stories", "Suspense and Thrillers", "True Crime", "Women's Fiction" }));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Author");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Book Synopsis");

        txt_bookSyn1.setColumns(20);
        txt_bookSyn1.setLineWrap(true);
        txt_bookSyn1.setRows(5);
        jScrollPane2.setViewportView(txt_bookSyn1);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Book Cover");

        bookCover.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        bookCoverBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bookCoverBtn.setForeground(new java.awt.Color(102, 102, 102));
        bookCoverBtn.setText("Select Book Cover");
        bookCoverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookCoverBtnActionPerformed(evt);
            }
        });

        editBookBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        editBookBtn.setForeground(new java.awt.Color(255, 51, 51));
        editBookBtn.setText("Edit Book");
        editBookBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editBookBtnMouseClicked(evt);
            }
        });

        txt_bookTitle.setColumns(20);
        txt_bookTitle.setLineWrap(true);
        txt_bookTitle.setRows(5);
        jScrollPane3.setViewportView(txt_bookTitle);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(editBookBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_bookAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(genreList, javax.swing.GroupLayout.Alignment.LEADING, 0, 297, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_bookid, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(bookCover, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(bookCoverLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addComponent(bookCoverBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(47, 47, 47))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_bookid, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(bookCover, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(32, 32, 32)
                            .addComponent(bookCoverLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(bookCoverBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(genreList, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_bookAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)))
                .addGap(44, 44, 44)
                .addComponent(editBookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 48, Short.MAX_VALUE))
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

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel9MouseClicked

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

    private void bookCoverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookCoverBtnActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        
        File fImage = fileChooser.getSelectedFile();
        imagePath = fImage.getAbsolutePath();
        
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(bookCover.getWidth(), bookCover.getHeight(), Image.SCALE_SMOOTH));
        bookCover.setIcon(imageIcon);
        
        try{
            File image = new File(imagePath);
            FileInputStream fis = new FileInputStream(image);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            
            for(int readNum; (readNum = fis.read(buf)) != -1;){
                bos.write(buf, 0, readNum);           
            }
            
            img = bos.toByteArray();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EditBookPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EditBookPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bookCoverBtnActionPerformed

    private void editBookBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editBookBtnMouseClicked
       
        String bookid = txt_bookid.getText();
        
        try{
            Connection conn = database.getConnection();
            String query = "SELECT * FROM `book_data` WHERE book_id = '" + bookid + "';" ;
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            rs.next();
            String editBookTitle = rs.getString("book_title");
            
        if (imagePath.trim().equals("")){ 
           
            
           if (editBook2() == true){
            
            JOptionPane.showMessageDialog(this, editBookTitle + " is edited successfuly");
            
            } else {
            
            JOptionPane.showMessageDialog(this, "Failed to edit book " + editBookTitle);
            
            }
           
                    
       } else {
           
           if (editBook() == true){
            
           JOptionPane.showMessageDialog(this, editBookTitle + " is edited successfuly");
            
           } else {
            
            JOptionPane.showMessageDialog(this, "Failed to edit book " + editBookTitle);
            
            }
           
       }    
        
       } catch (SQLException ex) {
            Logger.getLogger(BookList_bookMgt.class.getName()).log(Level.SEVERE, null, ex);
       }
        
    }//GEN-LAST:event_editBookBtnMouseClicked

    private void back_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_buttonMouseClicked
        // TODO add your handling code here:
        // Call register member page
        BookList_bookMgt bookMgt = new  BookList_bookMgt();
        bookMgt.setVisible(true);

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

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        // TODO add your handling code here:
        positionX = evt.getX();
        positionY = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        setLocation(evt.getXOnScreen()-positionX, evt.getYOnScreen()-positionY);
    }//GEN-LAST:event_jPanel1MouseDragged

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
            java.util.logging.Logger.getLogger(EditBookPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditBookPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditBookPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditBookPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditBookPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_button;
    private javax.swing.JLabel bookCover;
    private javax.swing.JButton bookCoverBtn;
    private javax.swing.JLabel bookCoverLabel;
    private javax.swing.JLabel bookSynLabel;
    private javax.swing.JButton editBookBtn;
    private javax.swing.JButton exit_button;
    private javax.swing.JComboBox<String> genreList;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton minimize_button;
    private javax.swing.JTextField txt_bookAuthor;
    private javax.swing.JTextArea txt_bookSyn;
    private javax.swing.JTextArea txt_bookSyn1;
    private javax.swing.JTextArea txt_bookTitle;
    private javax.swing.JTextField txt_bookid;
    // End of variables declaration//GEN-END:variables
}
