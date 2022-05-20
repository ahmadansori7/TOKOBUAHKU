/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inputan;

import Menu.ProdukKeluar;
import Menu.koneksi;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class InputProdukKeluar extends javax.swing.JFrame {

    /**
     * Creates new form InputProdukKeluar
     */
    public InputProdukKeluar() {
        initComponents();
              ImageIcon icon = new ImageIcon("src/IMAGE/logo.png");
        setIconImage(icon.getImage());
        tampilproduk();
       
    }
    
    
    //menampilkan nama produk dari database ke combobox2
     private void tampilproduk() {
   
      try
        {
            String sql = "select nama_produk from produk order by nama_produk ASC";
           java.sql.Connection conn=(Connection)koneksi.koneksi();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet rs= pst.executeQuery(sql);
            while(rs.next())
            {
                jComboBox2.addItem(rs.getString("nama_produk"));
                
            }
        }
        catch(SQLException ex)
        {
            
        }
      
     }

        //menampilkan kode produk dari database sesuai data combobox2
       private void tampildataproduk() {
   
      try
        {
            String sql = "select kode_produk from produk where nama_produk='"+jComboBox2.getSelectedItem()+"'";
           java.sql.Connection conn=(Connection)koneksi.koneksi();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet rs= pst.executeQuery(sql);
            while(rs.next())
            {
   
                txt_kodeproduk.setText(rs.getString("kode_produk"));
                txt_kodeproduk.setEditable(false);
            }
        }
        catch(SQLException ex)
        {
            
        }
     }
       
           //menampilkan stok dari table produk
        private int getStok(String text){
              try {
                    String sql = "SELECT stok FROM produk WHERE kode_produk='"+text+"'";
                    java.sql.Connection conn=(Connection)koneksi.koneksi();
                    java.sql.PreparedStatement pst=conn.prepareStatement(sql);
                    java.sql.ResultSet rs= pst.executeQuery(sql);
                    if(rs.next()) {
                    
                        return rs.getInt("stok");
                    }
                }
                catch(SQLException ex){
                        System.out.println(ex.getMessage());
                }
              
                return -1;
        }
        
         private void kosong() {
jComboBox2.setSelectedItem(this);
txt_kodeproduk.setText(null);
txt_keterangan.setText(null);
txt_stokkeluar.setText(null);
  
}
       
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_stokkeluar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_keterangan = new javax.swing.JTextField();
        btn_simpan = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        btn_kembali = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        txt_kodeproduk = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Montserrat Medium", 0, 24)); // NOI18N
        jLabel1.setText("Input Data Produk Keluar");

        jLabel3.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel3.setText("Nama Produk");

        jLabel4.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel4.setText("Stok Keluar (KG)");

        jLabel7.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel7.setText("Keterangan");

        btn_simpan.setBackground(new java.awt.Color(99, 88, 220));
        btn_simpan.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        btn_simpan.setForeground(new java.awt.Color(255, 255, 255));
        btn_simpan.setText("Simpan");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });

        btn_reset.setBackground(new java.awt.Color(99, 88, 220));
        btn_reset.setForeground(new java.awt.Color(255, 255, 255));
        btn_reset.setText("Reset");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        btn_kembali.setBackground(new java.awt.Color(99, 88, 220));
        btn_kembali.setForeground(new java.awt.Color(255, 255, 255));
        btn_kembali.setText("Kembali");
        btn_kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kembaliActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- pilih -" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_kembali, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_keterangan, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_stokkeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_kodeproduk)))
                .addContainerGap(102, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(262, 262, 262))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_kodeproduk, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(jComboBox2))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_stokkeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_keterangan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_kembali, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(827, 542));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
      try {
                    Date now = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String tgl = simpleDateFormat.format(now);
                        
                    //validasi kolom tidak kosong
                    if(txt_kodeproduk.getText().equals("") || txt_stokkeluar.getText().equals("") || txt_keterangan.getText().equals("")){
                            JOptionPane.showMessageDialog(this, "Data Anda ada yang kosong!");
                    }else{
                    int stokInput = Integer.parseInt(txt_stokkeluar.getText()),
                                stok = getStok(txt_kodeproduk.getText());
                    
                            // jika input stok > stok
                            if(stokInput > stok){
                             
                                    JOptionPane.showMessageDialog(this, "Stok Buah Kurang!");
                            }
                            // jika input stok < stok
                            else if(stokInput <= stok){
                                String sql = "INSERT INTO `produk_keluar`(`id_keluar`, `kode_produk`, `keterangan`, `stok_keluar`, `tanggal`) VALUES (NULL,'" + txt_kodeproduk.getText() + "','" + txt_keterangan.getText() + "',"
                                + "'" + txt_stokkeluar.getText() + "','" +tgl+ "')";

                                java.sql.Connection conn = (Connection) koneksi.koneksi();
                                java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                                pst.execute();
                                JOptionPane.showMessageDialog(this, "Penyimpanan data berhasil");
                           
                            }
                    }
      
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, e.getMessage());
                }
                kosong();
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        kosong();
    }//GEN-LAST:event_btn_resetActionPerformed

    private void btn_kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kembaliActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new ProdukKeluar().setVisible(true);
    }//GEN-LAST:event_btn_kembaliActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        tampildataproduk();
    }//GEN-LAST:event_jComboBox2ActionPerformed

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
            java.util.logging.Logger.getLogger(InputProdukKeluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InputProdukKeluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InputProdukKeluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InputProdukKeluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InputProdukKeluar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_kembali;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txt_keterangan;
    private javax.swing.JTextField txt_kodeproduk;
    private javax.swing.JTextField txt_stokkeluar;
    // End of variables declaration//GEN-END:variables
}