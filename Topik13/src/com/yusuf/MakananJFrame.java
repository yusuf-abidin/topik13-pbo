/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.yusuf;

import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;


/**
 *
 * @author yusuf
 */
public class MakananJFrame extends javax.swing.JFrame {
    
    private final static DefaultTableModel model = new DefaultTableModel();
    private final static TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>(model);
    
    
    private void kosongkanForm() {
        txtNama.setText(null);
        buttonGroupJenis.clearSelection();
        comboRating.setSelectedIndex(0);
        txtKalori.setText(null);
        txtSearch.setText(null);
    }
    
    private void tampilkanData(){
        
        try {
            int no = 1;
            Connection conn = Koneksi.getConnection();
            String queri = "SELECT * FROM makanan";
            
            PreparedStatement ps = conn.prepareStatement(queri);

            ResultSet res = ps.executeQuery();
            
            while(res.next()){
                model.addRow(new Object[]{res.getString("id"), no++, res.getString("nama"), res.getInt("rating")});
            }
            
            
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private static void search(String text){
        RowFilter<DefaultTableModel, Object> sorter = null;
        if (text.trim().length() == 0) {
        rowSorter.setRowFilter(null);
        } else {
        rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        }
    }

    /**
     * Creates new form MakananJFrame
     */
    public MakananJFrame() {
        initComponents();
        model.addColumn("ID");
        model.addColumn("No. ");
        model.addColumn("Nama");
        model.addColumn("Rating");
        tabelMakanan.setModel(model);
        tabelMakanan.setRowSorter(rowSorter);
        
//      Sembunyikan tombol ID
        tabelMakanan.getColumnModel().getColumn(0).setWidth(0);
        tabelMakanan.getColumnModel().getColumn(0).setMinWidth(0);
        tabelMakanan.getColumnModel().getColumn(0).setMaxWidth(0); 
        
//      Mengatur size NO
        tabelMakanan.getColumnModel().getColumn(1).setMaxWidth(40);
        
//      Mengatur size Rating
        tabelMakanan.getColumnModel().getColumn(3).setMaxWidth(100);
        tampilkanData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupJenis = new javax.swing.ButtonGroup();
        labelJudul = new javax.swing.JLabel();
        labelNama = new javax.swing.JLabel();
        labelJenis = new javax.swing.JLabel();
        labelRating = new javax.swing.JLabel();
        labelKalori = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        radioMakanan = new javax.swing.JRadioButton();
        radioMinuman = new javax.swing.JRadioButton();
        radioCemilan = new javax.swing.JRadioButton();
        comboRating = new javax.swing.JComboBox<>();
        txtKalori = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelMakanan = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        btnDetail = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(34, 87, 126));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        labelJudul.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        labelJudul.setText("APLIKASI MAKANAN FAVORIT");

        labelNama.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        labelNama.setText("Nama");

        labelJenis.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        labelJenis.setText("Jenis");

        labelRating.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        labelRating.setText("Rating");

        labelKalori.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        labelKalori.setText("Jumlah Kalori");

        txtNama.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        buttonGroupJenis.add(radioMakanan);
        radioMakanan.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        radioMakanan.setText("Makanan");

        buttonGroupJenis.add(radioMinuman);
        radioMinuman.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        radioMinuman.setText("Minuman");
        radioMinuman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioMinumanActionPerformed(evt);
            }
        });

        buttonGroupJenis.add(radioCemilan);
        radioCemilan.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        radioCemilan.setText("Cemilan");

        comboRating.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        comboRating.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));

        txtKalori.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        tabelMakanan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabelMakanan);

        txtSearch.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtSearch.setForeground(new java.awt.Color(153, 153, 153));
        txtSearch.setText("Search");
        txtSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearchFocusLost(evt);
            }
        });
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        btnDetail.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btnDetail.setText("Detail");
        btnDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailActionPerformed(evt);
            }
        });

        btnSimpan.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelNama, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(labelRating, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addComponent(labelKalori, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(radioMakanan)
                        .addGap(18, 18, 18)
                        .addComponent(radioMinuman)
                        .addGap(18, 18, 18)
                        .addComponent(radioCemilan))
                    .addComponent(comboRating, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKalori, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(105, 105, 105))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(labelJudul))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDetail)))))
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSimpan)
                .addGap(216, 216, 216))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(labelJudul)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNama)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelJenis)
                    .addComponent(radioMakanan)
                    .addComponent(radioMinuman)
                    .addComponent(radioCemilan))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelRating)
                    .addComponent(comboRating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelKalori)
                    .addComponent(txtKalori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(btnSimpan)
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDetail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void radioMinumanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioMinumanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioMinumanActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        String nama = txtNama.getText();
        String jenis;
        if (radioMakanan.isSelected()) {
            jenis = radioMakanan.getText();
            
        }else if (radioMinuman.isSelected()){
            jenis = radioMinuman.getText();
        }else{
            jenis = radioCemilan.getText();
        }
        
        String rating = comboRating.getSelectedItem().toString();
        String jumlah_kalori = txtKalori.getText();

        try{
            String queri = "INSERT INTO makanan (nama, jenis, rating, jumlah_kalori) VALUES ('"+nama+"', '"+jenis+"', '"+rating+"', '"+jumlah_kalori+"')";
            Connection conn = Koneksi.getConnection();
            PreparedStatement ps = conn.prepareStatement(queri);
            
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Makanan Berhasil Disimpan");
            tampilkanData();
            kosongkanForm();
            
            
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
  
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
            // TODO add your handling code here:
        
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
         String text = txtSearch.getText();
      
        search(text);
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailActionPerformed
        // TODO add your handling code here:
        
     
            int select = tabelMakanan.getSelectedRow();
            String id = tabelMakanan.getValueAt(select, 0).toString();
          

            String queri = "SELECT * FROM makanan WHERE id = ?";


            try {
                Connection conn = Koneksi.getConnection();

                PreparedStatement ps = conn.prepareStatement(queri);
                ps.setString(1, id);

                ResultSet res = ps.executeQuery();

                while(res.next()){
                    String nama = res.getString("nama");
                    String jenis = res.getString("jenis");
                    String rating = res.getString("rating");
                    String kalori = res.getString("jumlah_kalori");

                    String detail = "Nama : " +nama +"\nJenis : " +jenis + "\nRating : " +rating +"\nKalori : " +kalori;

                    JOptionPane.showMessageDialog(this, detail);
                }



            } catch(HeadlessException | SQLException e){
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        

    }//GEN-LAST:event_btnDetailActionPerformed

    private void txtSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusGained
        // TODO add your handling code here:
        if(txtSearch.getText().equals("Search")){
        txtSearch.setText("");
        txtSearch.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtSearchFocusGained

    private void txtSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusLost
        // TODO add your handling code here:
        if (txtSearch.getText().equals("")) {
            txtSearch.setText("Search");
            txtSearch.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtSearchFocusLost

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        // TODO add your handling code here:

            txtSearch.setForeground(new Color(0,0,0));

    }//GEN-LAST:event_txtSearchKeyPressed

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
            java.util.logging.Logger.getLogger(MakananJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MakananJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MakananJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MakananJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MakananJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetail;
    private javax.swing.JButton btnSimpan;
    private javax.swing.ButtonGroup buttonGroupJenis;
    private javax.swing.JComboBox<String> comboRating;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelJenis;
    private javax.swing.JLabel labelJudul;
    private javax.swing.JLabel labelKalori;
    private javax.swing.JLabel labelNama;
    private javax.swing.JLabel labelRating;
    private javax.swing.JRadioButton radioCemilan;
    private javax.swing.JRadioButton radioMakanan;
    private javax.swing.JRadioButton radioMinuman;
    private javax.swing.JTable tabelMakanan;
    private javax.swing.JTextField txtKalori;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}