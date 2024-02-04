/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Jframe;

import java.awt.Color;
import java.awt.Image;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author nirma
 */
public class AddBookPage extends javax.swing.JFrame {

    /**
     * Creates new form AddBookPage
     */
    
    String imagePath = "";
    byte[] img = null;
    int positionX = 0, positionY = 0;
    
    public AddBookPage() {
        
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
        
        bookidLabel.setVisible(false);
        bookTitleLabel.setVisible(false);
        genreListLabel.setVisible(false);
        bookAutLabel.setVisible(false);
        bookSynLabel.setVisible(false);
        bookCoverLabel.setVisible(false);
    }
    
    public void AddBook(){
        
        //Get record data from UI
        String bookid = txt_bookid.getText();
        String bookTitle = txt_bookTitle.getText();
        String bookGenre = genreList.getSelectedItem().toString();
        String bookAuthor = txt_bookAuthor.getText();
        String bookSyn = txt_bookSyn1.getText();
        byte[] img = null;
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date = new Date();

        String frmtdDate = dateFormat.format(date);
        
        
        ResultSet rs;
        PreparedStatement ps;

        String query = "INSERT INTO book_data(book_id, book_genre, book_title, book_author, book_synopsis, book_photo, time) VALUES (?,?,?,?,?,?,?)";
        
        // <editor-fold defaultstate="collapsed" desc="Empty Field Allert Text">
        if (bookid.trim().equals("")){
            bookidLabel.setVisible(true);
        }else{
            bookidLabel.setVisible(false);
        }
        
        if(bookTitle.trim().equals("")){
            bookTitleLabel.setVisible(true);
        }else{
            bookTitleLabel.setVisible(false);
        }
        
        if(bookGenre.trim().equals("")){
            genreListLabel.setVisible(true);
        }else{
            genreListLabel.setVisible(false);
        }
        
        if(bookAuthor.trim().equals("")){
            bookAutLabel.setVisible(true);
        }else{
            bookAutLabel.setVisible(false);
        }
        
        if(bookSyn.trim().equals("")){
            bookSynLabel.setVisible(true);
        }else{
            bookSynLabel.setVisible(false);
        }
        
        if(imagePath.trim().equals("")){
            bookCoverLabel.setVisible(true);
        }else{
            bookCoverLabel.setVisible(false);
        }
        //</editor-fold>
        
        if (!bookid.trim().equals("")&&
            !bookTitle.trim().equals("") &&
            !bookGenre.trim().equals("") &&
            !bookAuthor.trim().equals("") &&
            !bookSyn.trim().equals("") &&
            imagePath != null){
            
            try {
                
                Path path = Paths.get(imagePath);
                img = Files.readAllBytes(path);
                
                try {
                    ps = database.getConnection().prepareStatement(query);
                    ps.setString(1, bookid);
                    ps.setString(2, bookGenre);
                    ps.setString(3, bookTitle);
                    ps.setString(4, bookAuthor);
                    ps.setString(5, bookSyn);
                    ps.setBytes(6, img);
                    ps.setString(7, frmtdDate);



                   if(ps.executeUpdate() != 0){
                     System.out.println("YES");
                     
                     JOptionPane.showMessageDialog(this, "Book Successfully Added");
                     
                   }else{
                       
                     JOptionPane.showMessageDialog(this, "Add Book Failed");
                     
                   }
                   
                } catch (java.sql.SQLException ex) {
                    java.util.logging.Logger.getLogger(RegisterPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(BookManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
        jLabel3 = new javax.swing.JLabel();
        txt_bookid = new javax.swing.JTextField();
        bookidLabel = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_bookTitle = new javax.swing.JTextField();
        bookTitleLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        genreList = new javax.swing.JComboBox<>();
        genreListLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_bookAuthor = new javax.swing.JTextField();
        bookAutLabel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_bookSyn1 = new javax.swing.JTextArea();
        bookSynLabel = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        bookCover = new javax.swing.JLabel();
        bookCoverBtn = new javax.swing.JButton();
        editBookBtn = new javax.swing.JButton();
        bookCoverLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        minimize_button = new javax.swing.JButton();
        exit_button = new javax.swing.JButton();
        back_button = new javax.swing.JButton();
        bookCoverPath = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(226, 241, 247));
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

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 102, 102));
        jLabel3.setText("Book ID");

        bookidLabel.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        bookidLabel.setForeground(new java.awt.Color(255, 153, 51));
        bookidLabel.setText("* You need to enter the book ID");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 102, 102));
        jLabel11.setText("Title");

        txt_bookTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookTitleActionPerformed(evt);
            }
        });

        bookTitleLabel.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        bookTitleLabel.setForeground(new java.awt.Color(255, 153, 51));
        bookTitleLabel.setText("* You need to enter the book title");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 102, 102));
        jLabel5.setText("Genre");

        genreList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Academic", "Action & Adventure", "Classics", "Comic Book", "Detective and Mystery", "Fantasy", "Historical Fiction", "Horror", "Literary Fiction", "Romance", "Science Fiction (Sci-Fi)", "Short Stories", "Suspense and Thrillers", "Women's Fiction", "Biographies and Autobiographies", "Cookbooks", "Essays", "History", "Memoir", "Poetry ", "Self-Help", "True Crime" }));

        genreListLabel.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        genreListLabel.setForeground(new java.awt.Color(255, 153, 51));
        genreListLabel.setText("* You need to select the book genre");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 102, 102));
        jLabel6.setText("Author");

        bookAutLabel.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        bookAutLabel.setForeground(new java.awt.Color(255, 153, 51));
        bookAutLabel.setText("* You need to enter the book author");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 102, 102));
        jLabel8.setText("Book Synopsis");

        txt_bookSyn1.setColumns(20);
        txt_bookSyn1.setLineWrap(true);
        txt_bookSyn1.setRows(5);
        jScrollPane2.setViewportView(txt_bookSyn1);

        bookSynLabel.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        bookSynLabel.setForeground(new java.awt.Color(255, 153, 51));
        bookSynLabel.setText("* You need to enter the book synopsis");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 102, 102));
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

        editBookBtn.setBackground(new java.awt.Color(255, 153, 153));
        editBookBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        editBookBtn.setForeground(new java.awt.Color(255, 255, 255));
        editBookBtn.setText("Add Book");
        editBookBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editBookBtnMouseClicked(evt);
            }
        });
        editBookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBookBtnActionPerformed(evt);
            }
        });

        bookCoverLabel.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        bookCoverLabel.setForeground(new java.awt.Color(255, 153, 51));
        bookCoverLabel.setText("* You need to select a book cover");

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));

        jLabel9.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyAsset/moon.png"))); // NOI18N
        jLabel9.setText("Book Management - Add Book");
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

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 102, 102));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyAsset/reload.png"))); // NOI18N
        jButton1.setText("  Reset Form");
        jButton1.setActionCommand(" Reset Form");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_bookAuthor)
                                .addComponent(bookAutLabel)
                                .addComponent(jLabel11)
                                .addComponent(bookTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bookidLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_bookTitle)
                                .addComponent(txt_bookid, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(genreListLabel)
                            .addComponent(genreList, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(235, 235, 235)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bookCoverLabel)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(bookCoverPath, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bookCoverBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))))
                    .addComponent(editBookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap(418, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(bookSynLabel)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bookCover, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(46, 46, 46)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_bookid, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bookidLabel)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_bookTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(bookTitleLabel)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bookCoverPath))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genreList, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bookCoverBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genreListLabel)
                    .addComponent(bookCoverLabel))
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_bookAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bookAutLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(editBookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(79, 79, 79)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(bookSynLabel)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(bookCover, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(159, Short.MAX_VALUE)))
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

    private void txt_bookTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookTitleActionPerformed

    private void bookCoverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookCoverBtnActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);

        File fImage = fileChooser.getSelectedFile();
        imagePath = fImage.getAbsolutePath();

        ImageIcon imageIcon = new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(bookCover.getWidth(), bookCover.getHeight(), Image.SCALE_SMOOTH));
        bookCover.setIcon(imageIcon);

        
        
    }//GEN-LAST:event_bookCoverBtnActionPerformed

    private void editBookBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editBookBtnMouseClicked

        
    }//GEN-LAST:event_editBookBtnMouseClicked

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

    private void editBookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBookBtnActionPerformed
        
        String bookidEntry = txt_bookid.getText();
        
        try{
            Connection conn = database.getConnection();
            String query = "SELECT * FROM `book_data` WHERE book_id = '" + bookidEntry + "';" ;
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            if(rs.next()){
                
                JOptionPane.showMessageDialog(this, "Book ID already exist, please check through the book data again", "Error Message", 2);
                
            } else {
                
                AddBook();
                
            }
            
            
        } catch (java.sql.SQLException ex) {
            java.util.logging.Logger.getLogger(BookList_bookMgt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        AddBook();
    }//GEN-LAST:event_editBookBtnActionPerformed

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        positionX = evt.getX();
        positionY = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        setLocation(evt.getXOnScreen()-positionX, evt.getYOnScreen()-positionY);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        txt_bookid.setText("");
        txt_bookTitle.setText("");
        genreList.setSelectedIndex(0);
        txt_bookAuthor.setText("");
        txt_bookSyn1.setText("");
        bookCover.setIcon(null);
        imagePath = null;
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(AddBookPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddBookPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddBookPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddBookPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddBookPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_button;
    private javax.swing.JLabel bookAutLabel;
    private javax.swing.JLabel bookCover;
    private javax.swing.JButton bookCoverBtn;
    private javax.swing.JLabel bookCoverLabel;
    private javax.swing.JLabel bookCoverPath;
    private javax.swing.JLabel bookSynLabel;
    private javax.swing.JLabel bookTitleLabel;
    private javax.swing.JLabel bookidLabel;
    private javax.swing.JButton editBookBtn;
    private javax.swing.JButton exit_button;
    private javax.swing.JComboBox<String> genreList;
    private javax.swing.JLabel genreListLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton minimize_button;
    private javax.swing.JTextField txt_bookAuthor;
    private javax.swing.JTextArea txt_bookSyn1;
    private javax.swing.JTextField txt_bookTitle;
    private javax.swing.JTextField txt_bookid;
    // End of variables declaration//GEN-END:variables
}
