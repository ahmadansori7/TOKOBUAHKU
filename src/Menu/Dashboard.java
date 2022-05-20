/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ASUS
 */
public class Dashboard extends javax.swing.JFrame {


    
 
    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
                 ImageIcon icon = new ImageIcon("src/IMAGE/logo.png");
        setIconImage(icon.getImage());
        barangmasuk();
        barangkeluar();
        histori();
        penjualanhariiiniteks();
        barangmasukteks();
        ProdukTerjualteks();
        BarangKeluarTeks();

    }
    
        //digunakan untuk menampilkan stok total penjualan yang terjual hari ini
    
       private void ProdukTerjualteks() {
         try {
 
        String sql = "select sum(jumlah_total) as total from penjualan where tanggal=CURDATE()";      
         java.sql.Connection conn=(Connection)koneksi.koneksi();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet rs= pst.executeQuery(sql);                             
        while(rs.next()){
               String data = rs.getString("total");
             if(data == null){
                ProdukTerjual.setText("0 KG");   
            }else{
                ProdukTerjual.setText(data +" KG");   
            }                                
        }
        } catch (SQLException e) {
           
            System.out.println(e.getMessage());
        }
       }
         
         
         //digunakan untuk menampilkan total stok produk keluar pada hari ini
       
         private void BarangKeluarTeks() {
         try {
 
        String sql = "select sum(produk_keluar.stok_keluar) as total from produk_keluar WHERE tanggal=CURDATE() AND not keterangan ='Terjual'";      
         java.sql.Connection conn=(Connection)koneksi.koneksi();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet rs= pst.executeQuery(sql);                             
        while(rs.next()){
        String data = rs.getString("total");
             if(data == null){
                BarangKeluarTeks.setText("0 KG");   
            }else{
                BarangKeluarTeks.setText(data +" KG");   
            }                                        
        }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
       }
         
         //digunakan untuk menampilkan total stok produk masuk pada hari ini
         
     private void barangmasukteks() {
         try {
 
        String sql = "select sum(jumlah_stok_masuk) as stok from detail_produk_masuk join produk_masuk on detail_produk_masuk.id_masuk = produk_masuk.id_masuk where produk_masuk.tanggal=CURDATE()";      
         java.sql.Connection conn=(Connection)koneksi.koneksi();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet rs= pst.executeQuery(sql);                             
        while(rs.next()){
            String data = rs.getString("stok");
             if(data == null){
                BarangMasuk.setText("0 KG");   
            }else{
                BarangMasuk.setText(data +" KG");   
            }                       
        }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
       }
     
     //digunakan untuk menampilkan total penjualan hari ini.
    private void penjualanhariiiniteks() {
        try {
 
        String sql = "select sum(detail_penjualan.jml_item * detail_penjualan.harga_item) as harga_total from detail_penjualan join penjualan on detail_penjualan.id_penjualan = penjualan.id_penjualan where penjualan.tanggal=CURDATE()";      
        java.sql.Connection conn=(Connection)koneksi.koneksi();
        java.sql.PreparedStatement pst=conn.prepareStatement(sql);
        java.sql.ResultSet rs= pst.executeQuery(sql);           
                 
        while(rs.next()){
            String data = rs.getString("harga_total");
            if(data == null){
                PenjualanHariIni.setText("Rp. 0.00");   
            }else{
                PenjualanHariIni.setText(String.format("Rp. %,d", Integer.parseInt(data)));
            }           
        }
                 
     } catch (SQLException e) {
            System.out.println(e.getMessage());
     }
}
    
    //menampilkan data dari detail penjualan ke jtabel1

       private void histori() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nama Produk");
          model.addColumn("Jumlah (KG)");
        model.addColumn("Harga Total");
         model.addColumn("Tanggal");
        
        try {
            
            String sql = "Select produk.nama_produk, detail_penjualan.jml_item, sum(detail_penjualan.jml_item * detail_penjualan.harga_item), penjualan.tanggal from produk join detail_penjualan on produk.kode_produk = detail_penjualan.kode_produk join penjualan on detail_penjualan.id_penjualan = penjualan.id_penjualan where penjualan.tanggal=CURDATE() group by produk.nama_produk, detail_penjualan.jml_item";
           java.sql.Connection conn=(Connection)koneksi.koneksi();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet rs= pst.executeQuery(sql);
            while(rs.next()) {
                model.addRow(new Object[] 
                {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)});
            }
            jTable1.setModel(model);

        } catch (SQLException e) {
        
        }
       }
        
       //digunakan untuk menampilkan data dari table produk masuk ke jtable2
       private void barangmasuk() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nama Produk");
        model.addColumn("Jumlah Masuk (KG)");
         model.addColumn("Tanggal");
        
        try {
            
            String sql = "Select produk.nama_produk, detail_produk_masuk.jumlah_stok_masuk, produk_masuk.tanggal from produk join detail_produk_masuk on produk.kode_produk = detail_produk_masuk.kode_produk  join produk_masuk on produk_masuk.id_masuk = detail_produk_masuk.id_masuk where produk_masuk.tanggal=CURDATE() group by produk.nama_produk, detail_produk_masuk.jumlah_stok_masuk, produk_masuk.tanggal";
           java.sql.Connection conn=(Connection)koneksi.koneksi();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet rs= pst.executeQuery(sql);
            while(rs.next()) {
                model.addRow(new Object[] 
                {rs.getString(1),"+ "+ rs.getString(2),rs.getString(3)});
            }
            jTable2.setModel(model);

        } catch (SQLException e) {
        
        }
       }
       
       //digunakan untuk menampilkan data dari table produk keluar ke jtable3
         private void barangkeluar() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nama Produk");
        model.addColumn("Jumlah Keluar (KG)");
         model.addColumn("Tanggal");
        
        try {
            
            String sql = "select produk.nama_produk, produk_keluar.stok_keluar, produk_keluar.tanggal from produk join produk_keluar on produk.kode_produk = produk_keluar.kode_produk  WHERE produk_keluar.tanggal=CURDATE() AND not produk_keluar.keterangan ='Terjual' group by produk.nama_produk, produk_keluar.stok_keluar order by produk_keluar.tanggal desc";
           java.sql.Connection conn=(Connection)koneksi.koneksi();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet rs= pst.executeQuery(sql);
            while(rs.next()) {
                model.addRow(new Object[] 
                {rs.getString(1),"- "+ rs.getString(2),rs.getString(3)});
            }
            jTable3.setModel(model);

        } catch (SQLException e) {
        
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

        viewdetail3 = new javax.swing.JButton();
        viewdetail2 = new javax.swing.JButton();
        PenjualanHariIni = new java.awt.Label();
        label1 = new java.awt.Label();
        ProdukTerjual = new java.awt.Label();
        BarangMasuk = new java.awt.Label();
        BarangKeluarTeks = new java.awt.Label();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        viewdetail1 = new javax.swing.JButton();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        label4 = new java.awt.Label();
        label5 = new java.awt.Label();
        label6 = new java.awt.Label();
        label7 = new java.awt.Label();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dashboard");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        viewdetail3.setBackground(new java.awt.Color(255, 255, 255));
        viewdetail3.setForeground(new java.awt.Color(102, 102, 255));
        viewdetail3.setText("View details");
        viewdetail3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        viewdetail3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewdetail3MouseClicked(evt);
            }
        });
        viewdetail3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewdetail3ActionPerformed(evt);
            }
        });
        getContentPane().add(viewdetail3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1710, 580, 120, 30));

        viewdetail2.setBackground(new java.awt.Color(255, 255, 255));
        viewdetail2.setForeground(new java.awt.Color(102, 102, 255));
        viewdetail2.setText("View details");
        viewdetail2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        viewdetail2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewdetail2MouseClicked(evt);
            }
        });
        viewdetail2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewdetail2ActionPerformed(evt);
            }
        });
        getContentPane().add(viewdetail2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1710, 50, 120, -1));

        PenjualanHariIni.setBackground(new java.awt.Color(255, 255, 255));
        PenjualanHariIni.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        PenjualanHariIni.setText("1.000.00");
        PenjualanHariIni.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                PenjualanHariIniComponentHidden(evt);
            }
        });
        getContentPane().add(PenjualanHariIni, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, 240, 40));

        label1.setBackground(new java.awt.Color(255, 255, 255));
        label1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label1.setForeground(new java.awt.Color(204, 204, 204));
        label1.setText("Penjualan");
        label1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label1MouseClicked(evt);
            }
        });
        getContentPane().add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 470, 170, 50));

        ProdukTerjual.setBackground(new java.awt.Color(255, 255, 255));
        ProdukTerjual.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        ProdukTerjual.setText("50");
        getContentPane().add(ProdukTerjual, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 150, 140, -1));

        BarangMasuk.setBackground(new java.awt.Color(255, 255, 255));
        BarangMasuk.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        BarangMasuk.setText("30");
        getContentPane().add(BarangMasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 380, 160, 40));

        BarangKeluarTeks.setBackground(new java.awt.Color(255, 255, 255));
        BarangKeluarTeks.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        BarangKeluarTeks.setText("20");
        getContentPane().add(BarangKeluarTeks, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 370, 160, -1));

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.setEnabled(false);
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setRowHeight(20);
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 640, 740, 300));

        jTable2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.setEnabled(false);
        jTable2.setRowHeight(20);
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 120, 580, 380));

        jTable3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable3.setEnabled(false);
        jTable3.setRowHeight(20);
        jScrollPane3.setViewportView(jTable3);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 640, 590, 300));

        viewdetail1.setBackground(new java.awt.Color(255, 255, 255));
        viewdetail1.setForeground(new java.awt.Color(102, 102, 255));
        viewdetail1.setText("View details");
        viewdetail1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        viewdetail1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewdetail1MouseClicked(evt);
            }
        });
        viewdetail1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewdetail1ActionPerformed(evt);
            }
        });
        getContentPane().add(viewdetail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 570, 120, -1));

        label2.setBackground(new java.awt.Color(255, 255, 255));
        label2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label2.setText("Logout");
        label2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label2MouseClicked(evt);
            }
        });
        getContentPane().add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 940, 170, 50));

        label3.setBackground(new java.awt.Color(255, 255, 255));
        label3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label3.setForeground(new java.awt.Color(204, 204, 204));
        label3.setText("Barang");
        label3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label3MouseClicked(evt);
            }
        });
        getContentPane().add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 170, 50));

        label4.setBackground(new java.awt.Color(255, 255, 255));
        label4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label4.setForeground(new java.awt.Color(204, 204, 204));
        label4.setText("Laporan");
        label4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label4MouseClicked(evt);
            }
        });
        getContentPane().add(label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 170, 50));

        label5.setBackground(new java.awt.Color(255, 255, 255));
        label5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label5.setForeground(new java.awt.Color(204, 204, 204));
        label5.setText("Transit");
        label5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label5MouseClicked(evt);
            }
        });
        getContentPane().add(label5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, 170, 50));

        label6.setBackground(new java.awt.Color(255, 255, 255));
        label6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label6.setForeground(new java.awt.Color(204, 204, 204));
        label6.setText("Supplier");
        label6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label6MouseClicked(evt);
            }
        });
        getContentPane().add(label6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, 170, 50));

        label7.setBackground(new java.awt.Color(255, 255, 255));
        label7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label7.setText("Home");
        label7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label7MouseClicked(evt);
            }
        });
        getContentPane().add(label7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 170, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/DASHBOARD.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -50, -1, -1));

        setSize(new java.awt.Dimension(1887, 1076));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void PenjualanHariIniComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_PenjualanHariIniComponentHidden

    }//GEN-LAST:event_PenjualanHariIniComponentHidden

    private void viewdetail1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewdetail1ActionPerformed
        // TODO add your handling code here:
          this.setVisible(false);
            new Penjualan().setVisible(true);
       
    }//GEN-LAST:event_viewdetail1ActionPerformed

    private void viewdetail2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewdetail2ActionPerformed
        // TODO add your handling code here:
                  this.setVisible(false);
            new ProdukMasuk().setVisible(true);
    }//GEN-LAST:event_viewdetail2ActionPerformed

    private void viewdetail3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewdetail3ActionPerformed
        // TODO add your handling code here:
                           this.setVisible(false);
            new ProdukKeluar().setVisible(true);
    }//GEN-LAST:event_viewdetail3ActionPerformed

    private void viewdetail1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewdetail1MouseClicked
        // TODO add your handling code here:
           
    }//GEN-LAST:event_viewdetail1MouseClicked

    private void viewdetail2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewdetail2MouseClicked
        // TODO add your handling code here:
          
    }//GEN-LAST:event_viewdetail2MouseClicked

    private void viewdetail3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewdetail3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_viewdetail3MouseClicked

    private void label3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label3MouseClicked
        // TODO add your handling code here:
           this.setVisible(false);
            new Barang().setVisible(true);
    }//GEN-LAST:event_label3MouseClicked

    private void label4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label4MouseClicked
        // TODO add your handling code here:
                this.setVisible(false);
            new Laporan().setVisible(true);
    }//GEN-LAST:event_label4MouseClicked

    private void label5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label5MouseClicked
        // TODO add your handling code here:
                this.setVisible(false);
            new ProdukMasuk().setVisible(true);
    }//GEN-LAST:event_label5MouseClicked

    private void label6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label6MouseClicked
        // TODO add your handling code here:
                this.setVisible(false);
            new Supplier().setVisible(true);
    }//GEN-LAST:event_label6MouseClicked

    private void label1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label1MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
            new Penjualan().setVisible(true);
    }//GEN-LAST:event_label1MouseClicked

    private void label2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label2MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
            new Login().setVisible(true);
    }//GEN-LAST:event_label2MouseClicked

    private void label7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label7MouseClicked
        // TODO add your handling code here:
            this.setVisible(false);
        new Dashboard().setVisible(true);
    }//GEN-LAST:event_label7MouseClicked

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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Label BarangKeluarTeks;
    private java.awt.Label BarangMasuk;
    private java.awt.Label PenjualanHariIni;
    private java.awt.Label ProdukTerjual;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label label6;
    private java.awt.Label label7;
    private javax.swing.JButton viewdetail1;
    private javax.swing.JButton viewdetail2;
    private javax.swing.JButton viewdetail3;
    // End of variables declaration//GEN-END:variables


}
