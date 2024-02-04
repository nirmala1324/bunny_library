/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Jframe;

import java.awt.Color;
import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

/**
 *
 * @author nirma
 */
public class MemberList_memberMgt extends javax.swing.JFrame {

    DefaultTableModel model;
    int positionX = 0, positionY = 0;
    
    public MemberList_memberMgt() {
        setUndecorated(true);
        initComponents();
        setLocation(80, 200);
        
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
        
        JTableHeader tableHeader = member_table.getTableHeader();
        tableHeader.setForeground(Color.red); 
        setMemberDetailsToTable();
        memberid_ttext.setVisible(false);
    }

    public void setMemberDetailsToTable(){
        
        try{
            Connection conn = database.getConnection();
            String query = "SELECT * FROM member";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()){
            String memberid = rs.getString("id");
            String membername = rs.getString("fullName");
            String memberusername = rs.getString("username");
            String memberemail = rs.getString("email");
                
                Object[] obj = {memberid, membername, memberusername, memberemail};
                model = (DefaultTableModel)member_table.getModel();
                model.addRow(obj);
                member_table.setShowVerticalLines(true);
                member_table.setShowHorizontalLines(true);
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        MultiLineJTable renderer = new MultiLineJTable();
        
        //set table cell renderer into a specified JTable column class
        member_table.setDefaultRenderer(String[].class, renderer);
        
    }
    public void clearTable(){
        DefaultTableModel model = (DefaultTableModel) member_table.getModel();
        model.setRowCount(0);
    }
    
    public boolean DeleteMember(){
        
        boolean isDeleted = false;
        
        int rowNo = member_table.getSelectedRow();
        
        String memberid = model.getValueAt(rowNo, 0).toString();
        
        try {
                    
               Connection dbconnect = database.getConnection();
               String sql = "DELETE FROM member WHERE id = ?";
               PreparedStatement ps = dbconnect.prepareStatement(sql);
               ps.setString(1, memberid);
               
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
        jPanel3 = new javax.swing.JPanel();
        memberName_ttext = new javax.swing.JTextField();
        editBookBtn = new javax.swing.JButton();
        deleteBookBtn = new javax.swing.JButton();
        memberDetailsBtn = new javax.swing.JButton();
        memberid_ttext = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        member_table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

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
        jLabel9.setText("Member Management");

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(8, 8, 8))
        );

        jPanel3.setBackground(new java.awt.Color(255, 102, 102));

        memberName_ttext.setFont(new java.awt.Font("STFangsong", 0, 14)); // NOI18N
        memberName_ttext.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        memberName_ttext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberName_ttextActionPerformed(evt);
            }
        });

        editBookBtn.setFont(new java.awt.Font("STFangsong", 1, 14)); // NOI18N
        editBookBtn.setForeground(new java.awt.Color(255, 0, 0));
        editBookBtn.setText("Edit Member");
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

        deleteBookBtn.setFont(new java.awt.Font("STFangsong", 1, 14)); // NOI18N
        deleteBookBtn.setForeground(new java.awt.Color(255, 0, 0));
        deleteBookBtn.setText("Delete Member");
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

        memberDetailsBtn.setBackground(new java.awt.Color(255, 204, 204));
        memberDetailsBtn.setFont(new java.awt.Font("STFangsong", 1, 16)); // NOI18N
        memberDetailsBtn.setForeground(new java.awt.Color(255, 51, 51));
        memberDetailsBtn.setText("Member Details");
        memberDetailsBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                memberDetailsBtnMouseClicked(evt);
            }
        });
        memberDetailsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberDetailsBtnActionPerformed(evt);
            }
        });

        memberid_ttext.setFont(new java.awt.Font("STFangsong", 0, 14)); // NOI18N
        memberid_ttext.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        memberid_ttext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberid_ttextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(memberid_ttext, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(editBookBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteBookBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(memberDetailsBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(memberName_ttext, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(memberid_ttext, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(memberName_ttext, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(editBookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteBookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(memberDetailsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );

        member_table.setBackground(new java.awt.Color(255, 204, 204));
        member_table.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        member_table.setForeground(new java.awt.Color(102, 102, 102));
        member_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "member ID", "member Name", "Username", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        member_table.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        member_table.setGridColor(new java.awt.Color(255, 255, 255));
        member_table.setRowHeight(40);
        member_table.setSelectionBackground(new java.awt.Color(255, 153, 153));
        member_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                member_tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(member_table);
        if (member_table.getColumnModel().getColumnCount() > 0) {
            member_table.getColumnModel().getColumn(0).setMinWidth(80);
            member_table.getColumnModel().getColumn(0).setMaxWidth(80);
            member_table.getColumnModel().getColumn(2).setMinWidth(100);
            member_table.getColumnModel().getColumn(2).setMaxWidth(100);
        }

        jLabel1.setFont(new java.awt.Font("Yu Mincho", 1, 21)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Member Data List");
        jLabel1.setMaximumSize(new java.awt.Dimension(138, 40));
        jLabel1.setMinimumSize(new java.awt.Dimension(138, 40));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void memberName_ttextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberName_ttextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_memberName_ttextActionPerformed

    private void editBookBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editBookBtnMouseClicked
        
        
        String memberid = memberid_ttext.getText();

        if(!memberid.trim().equals("")){

            try {
                new EditMemberPage(memberid).setVisible(true);
            } catch (ParseException ex) {
                Logger.getLogger(MemberList_memberMgt.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.dispose();
            

        } else {

            JOptionPane.showMessageDialog(null, "Please input or click specified member that need to be edited", "Empty Field", 2);

        }
        
    }//GEN-LAST:event_editBookBtnMouseClicked

    private void editBookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBookBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editBookBtnActionPerformed

    private void deleteBookBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBookBtnMouseClicked

        
        String memberid = memberid_ttext.getText();

        

            if(memberid.trim().equals("")){
                JOptionPane.showMessageDialog(this, "Click member data you want to delete");
            }
                else {
                
                try{
            Connection conn = database.getConnection();
            String query = "SELECT * FROM `member` WHERE id = '" + memberid + "';" ;
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            rs.next();
            String delMemberName = rs.getString("fullName");
                if (DeleteMember() == true){
                    JOptionPane.showMessageDialog(this, delMemberName +" is succesfully deleted");
                    clearTable();
                    setMemberDetailsToTable();
                    memberName_ttext.setText("");
                }else{
                    JOptionPane.showMessageDialog(this, "Failed to delete member " + delMemberName);
                }
            } catch (SQLException ex) {
                Logger.getLogger(MemberList_memberMgt.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
    }//GEN-LAST:event_deleteBookBtnMouseClicked

    private void deleteBookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBookBtnActionPerformed
        // TODO add your handling code here:
        

    }//GEN-LAST:event_deleteBookBtnActionPerformed

    private void memberDetailsBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_memberDetailsBtnMouseClicked

        
        String memberID = memberid_ttext.getText();

        if(memberID.trim().equals("")){

            JOptionPane.showMessageDialog(null, "Please input or click specified member that need to be edited", "Empty Field", 2);

        } else {

            new MemberDetails(memberID).setVisible(true);

        }
    }//GEN-LAST:event_memberDetailsBtnMouseClicked

    private void memberDetailsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberDetailsBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_memberDetailsBtnActionPerformed

    private void member_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_member_tableMouseClicked
        int rowNo = member_table.getSelectedRow();
        TableModel model = member_table.getModel();

        String memberID = model.getValueAt(rowNo, 0).toString();
        memberid_ttext.setText(memberID);
        
        String memberName = model.getValueAt(rowNo, 1).toString();
        memberName_ttext.setText(memberName);

    }//GEN-LAST:event_member_tableMouseClicked

    private void memberid_ttextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberid_ttextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_memberid_ttextActionPerformed

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
            java.util.logging.Logger.getLogger(MemberList_memberMgt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MemberList_memberMgt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MemberList_memberMgt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MemberList_memberMgt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MemberList_memberMgt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_button;
    private javax.swing.JButton deleteBookBtn;
    private javax.swing.JButton editBookBtn;
    private javax.swing.JButton exit_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton memberDetailsBtn;
    private javax.swing.JTextField memberName_ttext;
    private javax.swing.JTable member_table;
    private javax.swing.JTextField memberid_ttext;
    private javax.swing.JButton minimize_button;
    // End of variables declaration//GEN-END:variables
}