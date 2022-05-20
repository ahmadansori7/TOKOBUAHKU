package Menu;

import Inputan.InputPenjualan;
import java.awt.Toolkit; // add
import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
/**
 *
 * @author fikrimuzakky24
 */
public class Penjualan extends javax.swing.JFrame {

    private Toolkit tk = Toolkit.getDefaultToolkit(); // add
    private final int LEBAR = (int) tk.getScreenSize().getWidth(), TINGGI = (int) tk.getScreenSize().getHeight(); // add
    
    public Penjualan() {
        initComponents();
        this.setSize(LEBAR, TINGGI); // add
        this.setLocationRelativeTo(null); //add
        ImageIcon icon = new ImageIcon("src/IMAGE/logo.png");
        setIconImage(icon.getImage());
        load_table();
    }
    
    private void tampildata() {
                // TODO add your handling code here:
        
                //membuat tampilan model tabel
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id Penjualan");
        model.addColumn("Nama Produk");
        model.addColumn("Jumlah Item");
        model.addColumn("Harga Item");
        model.addColumn("Tanggal");

        //menampilkan data database ke table
        try {
          
            String tanggal = ((JTextField) jDateChooser1.getDateEditor().getUiComponent()).getText();
            String tanggal2 = ((JTextField) jDateChooser2.getDateEditor().getUiComponent()).getText();
            
            String sql = "SELECT detail_penjualan.id_penjualan, "
                    + "produk.nama_produk, detail_penjualan.jml_item, detail_penjualan.harga_item, "
                    + "penjualan.tanggal FROM detail_penjualan JOIN penjualan "
                    + "ON detail_penjualan.id_penjualan=penjualan.id_penjualan "
                    + "JOIN produk ON detail_penjualan.kode_produk=produk.kode_produk WHERE penjualan.tanggal BETWEEN '"+tanggal+"' AND '"+tanggal2+"' ORDER BY penjualan.tanggal DESC";
            java.sql.Connection conn = (Connection) koneksi.koneksi();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                model.addRow(new Object[]{res.getString(1),
                    res.getString(2), res.getString(3), res.getString(4),
                    res.getString(5)});
            }
            jTable1.setModel(model);
        } catch (SQLException e) {

        }
        
    }

    private void load_table() {

        //membuat tampilan model tabel
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id Penjualan");
        model.addColumn("Nama Produk");
        model.addColumn("Jumlah Item");
        model.addColumn("Harga Item");
        model.addColumn("Tanggal");

        //menampilkan data database ke table
        try {
          
            String sql = "SELECT detail_penjualan.id_penjualan, "
                    + "produk.nama_produk, detail_penjualan.jml_item, detail_penjualan.harga_item, "
                    + "penjualan.tanggal FROM detail_penjualan JOIN penjualan "
                    + "ON detail_penjualan.id_penjualan=penjualan.id_penjualan "
                    + "JOIN produk ON detail_penjualan.kode_produk=produk.kode_produk ORDER BY penjualan.tanggal DESC";
            java.sql.Connection conn = (Connection) koneksi.koneksi();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                model.addRow(new Object[]{res.getString(1),
                    res.getString(2), res.getString(3), res.getString(4),
                    res.getString(5)});
            }
            jTable1.setModel(model);
        } catch (SQLException e) {

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jButton3 = new javax.swing.JButton();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        label4 = new java.awt.Label();
        label5 = new java.awt.Label();
        label6 = new java.awt.Label();
        label1 = new java.awt.Label();
        label7 = new java.awt.Label();
        btn_tambah = new javax.swing.JButton();
        btn_export = new javax.swing.JButton();
        label8 = new java.awt.Label();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Penjualan");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(1920, 1080));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 250, 1500, 800));

        jDateChooser1.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, 210, 40));

        jDateChooser2.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 170, 190, 40));

        jButton3.setText("Tampilkan");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 170, 130, 40));

        label2.setBackground(new java.awt.Color(255, 255, 255));
        label2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label2.setForeground(new java.awt.Color(204, 204, 204));
        label2.setText("Home");
        label2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label2MouseClicked(evt);
            }
        });
        jPanel1.add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 170, 50));

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
        jPanel1.add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 170, 50));

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
        jPanel1.add(label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 170, 50));

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
        jPanel1.add(label5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, 170, 50));

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
        jPanel1.add(label6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 400, 170, 50));

        label1.setBackground(new java.awt.Color(255, 255, 255));
        label1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label1.setForeground(new java.awt.Color(0, 0, 0));
        label1.setText("Penjualan");
        label1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label1MouseClicked(evt);
            }
        });
        jPanel1.add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 480, 170, 50));

        label7.setBackground(new java.awt.Color(255, 255, 255));
        label7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label7.setText("Logout");
        label7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label7MouseClicked(evt);
            }
        });
        jPanel1.add(label7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 950, 170, 50));

        btn_tambah.setBackground(new java.awt.Color(99, 88, 220));
        btn_tambah.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btn_tambah.setForeground(new java.awt.Color(255, 255, 255));
        btn_tambah.setText("+ Tambahkan Data");
        btn_tambah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });
        jPanel1.add(btn_tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 140, 280, 70));

        btn_export.setBackground(new java.awt.Color(99, 88, 220));
        btn_export.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btn_export.setForeground(new java.awt.Color(255, 255, 255));
        btn_export.setText("Export");
        btn_export.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_export.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exportActionPerformed(evt);
            }
        });
        jPanel1.add(btn_export, new org.netbeans.lib.awtextra.AbsoluteConstraints(1580, 140, 280, 70));

        label8.setBackground(new java.awt.Color(255, 255, 255));
        label8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label8.setText("TO");
        jPanel1.add(label8, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 180, 20, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/PENJUALAN.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -40, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
tampildata();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void label2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label2MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Dashboard().setVisible(true);
    }//GEN-LAST:event_label2MouseClicked

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

    private void label7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label7MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Login().setVisible(true);
    }//GEN-LAST:event_label7MouseClicked

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        // TODO add your handling code here:
        new InputPenjualan().setVisible(true);
                try {
            String sql = "INSERT INTO penjualan VALUES (NULL, CURDATE(), NULL, NULL)";
            java.sql.Connection conn = (Connection) koneksi.koneksi();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_exportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exportActionPerformed

        //digunakan untuk mengeksport data dari jtable1 ke xls / excel

        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        jTable1.setModel(model);
        try{
            WritableWorkbook write = Workbook.createWorkbook(new File("C:\\Users\\ASUS\\Downloads\\export-penjualan.xls"));
            WritableSheet sheet = write.createSheet("program_cetak_excel",0);
            sheet.addCell(new Label(0,0,"Id Masuk"));
            sheet.addCell(new Label(1,0,"Nama Produk"));
            sheet.addCell(new Label(2,0,"Stok Masuk (KG)"));
            sheet.addCell(new Label(3,0,"Tanggal"));
            sheet.addCell(new Label(4,0,"Pemasok"));
            for (int i = 0; i < model.getColumnCount(); i++) {
                Label column = new Label(i, 0, model.getColumnName(i));
                sheet.addCell(column);
            }
            int j = 0;
            for (int i = 0; i < model.getRowCount(); i++) {
                for (j = 0; j < model.getColumnCount(); j++) {
                    Label row = new Label(j, i + 1,
                        model.getValueAt(i, j).toString());
                    sheet.addCell(row);
                }
            }
            write.write();
            write.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan Ke Excel");
        }catch(HeadlessException | IOException | WriteException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan!!!"+e.toString());
        }
    }//GEN-LAST:event_btn_exportActionPerformed

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
            java.util.logging.Logger.getLogger(Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Penjualan().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_export;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JButton jButton3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label label6;
    private java.awt.Label label7;
    private java.awt.Label label8;
    // End of variables declaration//GEN-END:variables
}
