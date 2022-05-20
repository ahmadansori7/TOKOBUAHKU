/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inputan;
import Menu.ProdukMasuk;
import Menu.koneksi;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class InputProdukMasuk extends javax.swing.JFrame {
 
    public InputProdukMasuk() {
        initComponents();
        ImageIcon icon = new ImageIcon("src/IMAGE/logo.png");
        setIconImage(icon.getImage());
        tampilidmasuk();
        tampil_comboproduk();
        tampil_combopemasok();
        tidakbisadirubah();
        tampilpemasok();
        tampilproduk();
       hitungstokmasuk();
        load_table();
      
    }
    
        private void tampilidmasuk() {
        try {
            String sql = "SELECT id_masuk FROM produk_masuk ORDER BY id_masuk desc limit 1";
            java.sql.Connection conn = (Connection) koneksi.koneksi();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet res = pst.executeQuery(sql);
            while (res.next()) {
                txt_idmasukproduk.setText(res.getString("id_masuk"));
            }
        } catch (SQLException ex) {
 JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        
    }

    private void load_table(){
        
        //membuat tampilan model tabel
        DefaultTableModel model = new DefaultTableModel();
      
        model.addColumn("ID Masuk");
        model.addColumn("Nama Produk");
        model.addColumn("Stok Produk (+)");
        model.addColumn("Pemasok");
        
        
        //menampilkan data database ke table
        try {
         
            String sql = "select produk_masuk.id_masuk, produk.nama_produk, detail_produk_masuk.jumlah_stok_masuk, supplier.nama from produk join detail_produk_masuk on produk.kode_produk = detail_produk_masuk.kode_produk join produk_masuk on produk_masuk.id_masuk = detail_produk_masuk.id_masuk join supplier on supplier.id_supplier = produk_masuk.id_supplier where produk_masuk.id_masuk='"+txt_idmasukproduk.getText() +"'";
           java.sql.Connection conn=(Connection)koneksi.koneksi();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            while(res.next()) {
                model.addRow(new Object[]
               {res.getString(1),res.getString(2),res.getString(3),res.getString(4)});
            }
            Model_Data.setModel(model);

        } catch (SQLException e) {
         JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
         private void kosong() {
txt_stokmasuk.setText(null);
  
}
      
 
     private void tidakbisadirubah() {
        txt_idmasukproduk.setEditable(false);
	txt_namaproduk.setEditable(false);
        txt_idsuppiler.setEditable(false);

    }

     
    private void tampil_comboproduk() {
   
      try
        {
            String sql = "select nama_produk from produk order by nama_produk ASC";
           java.sql.Connection conn=(Connection)koneksi.koneksi();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet res= pst.executeQuery(sql);
            while(res.next())
            {
            combobox_namaproduk.addItem(res.getString("nama_produk"));
            }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
      load_table();
     }

    
    private void tampilproduk() {
        try {
            String sql = "select kode_produk from produk where nama_produk='" + combobox_namaproduk.getSelectedItem() + "'";
            java.sql.Connection conn = (Connection) koneksi.koneksi();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery(sql);
            while (rs.next()) {
                txt_namaproduk.setText(rs.getString("kode_produk"));
            }
        } catch (SQLException ex) {

        }

    }
    private void tampilpemasok() {
        try {
            String sql = "select id_supplier from supplier where nama='" + combobox_pemasok.getSelectedItem() + "'";
            java.sql.Connection conn = (Connection) koneksi.koneksi();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery(sql);
            while (rs.next()) {
                txt_idsuppiler.setText(rs.getString("id_supplier"));
            }
        } catch (SQLException ex) {
        }
       
    }

   
    
    
          private void tampil_combopemasok() {
   
      try
        {
            String sql = "select nama from supplier order by nama asc";
           java.sql.Connection conn=(Connection)koneksi.koneksi();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet res= pst.executeQuery(sql);
            while(res.next())
            {
                combobox_pemasok.addItem(res.getString("nama"));
            }
        }
        catch(SQLException ex)
        {
       
        }
     }
 
     private void hitungstokmasuk() {
   
      try
        {
            String sql = "select sum(jumlah_stok_masuk) as total from detail_produk_masuk where id_masuk='"+ txt_idmasukproduk.getText() +"' ";
           java.sql.Connection conn=(Connection)koneksi.koneksi();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet res= pst.executeQuery(sql);
            while(res.next())
            {
             txt_jumlahtotalstok.setText(res.getString("total"));
            }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
     }
     
     
                 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_stokmasuk = new javax.swing.JTextField();
        combobox_namaproduk = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        btn_hitung = new javax.swing.JButton();
        combobox_pemasok = new javax.swing.JComboBox();
        txt_idmasukproduk = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_jumlahtotalstok = new javax.swing.JTextField();
        btn_simpan = new javax.swing.JButton();
        btn_tambah = new javax.swing.JButton();
        txt_idsuppiler = new javax.swing.JTextField();
        txt_namaproduk = new javax.swing.JTextField();
        btn_kembali = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Model_Data = new javax.swing.JTable();

        jTextField1.setText("jTextField1");

        jTextField2.setText("jTextField2");

        jLabel6.setText("jLabel6");

        jLabel7.setText("jLabel7");

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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel2.setText("NAMA PRODUK");

        jLabel3.setText("STOK MASUK (+)");

        jLabel5.setText("PEMASOK");

        txt_stokmasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_stokmasukActionPerformed(evt);
            }
        });

        combobox_namaproduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobox_namaprodukActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel8.setText("Total Produk Masuk");

        btn_hitung.setBackground(new java.awt.Color(99, 88, 220));
        btn_hitung.setForeground(new java.awt.Color(255, 255, 255));
        btn_hitung.setText("HITUNG");
        btn_hitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hitungActionPerformed(evt);
            }
        });

        combobox_pemasok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobox_pemasokActionPerformed(evt);
            }
        });

        jLabel9.setText("ID Masuk Ke -");

        jLabel10.setText("Jumlah Total Stok Masuk");

        btn_simpan.setBackground(new java.awt.Color(99, 88, 220));
        btn_simpan.setForeground(new java.awt.Color(255, 255, 255));
        btn_simpan.setText("SIMPAN");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });

        btn_tambah.setBackground(new java.awt.Color(99, 88, 220));
        btn_tambah.setForeground(new java.awt.Color(255, 255, 255));
        btn_tambah.setText("TAMBAHKAN");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });

        txt_idsuppiler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idsuppilerActionPerformed(evt);
            }
        });

        txt_namaproduk.setEnabled(false);

        btn_kembali.setBackground(new java.awt.Color(99, 88, 220));
        btn_kembali.setForeground(new java.awt.Color(255, 255, 255));
        btn_kembali.setText("Kembali");
        btn_kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kembaliActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Montserrat Medium", 0, 24)); // NOI18N
        jLabel1.setText("Input Produk Masuk");

        Model_Data.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Model_Data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Masuk", "Nama Produk", "Stok Masuk (+)", "Pemasok"
            }
        ));
        Model_Data.setEnabled(false);
        Model_Data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Model_DataMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Model_Data);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(txt_idmasukproduk, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_stokmasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(combobox_pemasok, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_idsuppiler))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(combobox_namaproduk, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_namaproduk, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3))))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(60, 60, 60)
                                        .addComponent(btn_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_jumlahtotalstok, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btn_hitung, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                    .addComponent(btn_kembali, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(42, 42, 42))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_hitung, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_jumlahtotalstok, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(61, 61, 61)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_kembali, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(97, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_idmasukproduk, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combobox_namaproduk, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_namaproduk, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_stokmasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combobox_pemasok, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_idsuppiler, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setSize(new java.awt.Dimension(899, 619));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_stokmasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_stokmasukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_stokmasukActionPerformed

    private void txt_idsuppilerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idsuppilerActionPerformed
       
    }//GEN-LAST:event_txt_idsuppilerActionPerformed

    private void combobox_pemasokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobox_pemasokActionPerformed
       tampilpemasok();
    }//GEN-LAST:event_combobox_pemasokActionPerformed

    private void combobox_namaprodukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobox_namaprodukActionPerformed
        tampilproduk();
    }//GEN-LAST:event_combobox_namaprodukActionPerformed

    private void Model_DataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Model_DataMouseClicked
                                             
        // TODO add your handling code here:
        int baris = Model_Data.rowAtPoint(evt.getPoint());
        String ID_Masuk = Model_Data.getValueAt(baris,1).toString();
        txt_idmasukproduk.setText(ID_Masuk);
        txt_idmasukproduk.disable();
        if (Model_Data.getValueAt(baris, 2)== null) {
            combobox_namaproduk.setSelectedItem(this);
        } else{
         combobox_namaproduk.setSelectedItem(Model_Data.getValueAt(baris, 2).toString());
         }
        if (Model_Data.getValueAt(baris, 3)==null){
         txt_stokmasuk.setText("");
        } else{
            txt_stokmasuk.setText(Model_Data.getValueAt(baris, 3).toString());
        if (Model_Data.getValueAt(baris, 4)== null) {
            combobox_pemasok.setSelectedItem(this);
        } else{
         combobox_pemasok.setSelectedItem(Model_Data.getValueAt(baris, 4).toString());    
        }
        }
    }//GEN-LAST:event_Model_DataMouseClicked

    private void btn_hitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hitungActionPerformed

        
        hitungstokmasuk();
    }//GEN-LAST:event_btn_hitungActionPerformed

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        // TODO add your handling code here:
          try {
              
                 Date now = new Date();
        SimpleDateFormat simpleDateFormat = 
        new SimpleDateFormat("yyyy-MM-dd");
        String tgl = simpleDateFormat.format(now);
        
            String sql = "UPDATE produk_masuk SET jumlah_stok_total = '"
                    + txt_jumlahtotalstok.getText() + "', tanggal = '"+tgl+"' WHERE id_masuk = '"
                    + txt_idmasukproduk.getText() + "'";
            java.sql.Connection conn = (Connection) koneksi.koneksi();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Penyimpanan data berhasil");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
          
          
    
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed

        try {
            
             if(txt_stokmasuk.getText().equals("") ){
                JOptionPane.showMessageDialog(this, "Data Anda ada yang kosong!");
            }else{
             Date now = new Date();
        SimpleDateFormat simpleDateFormat = 
        new SimpleDateFormat("yyyy-MM-dd");
        String tgl = simpleDateFormat.format(now);
        
            String sql = "INSERT INTO detail_produk_masuk VALUES ('"
            + txt_idmasukproduk.getText() + "','"
            + txt_namaproduk.getText() + "','"
            + txt_stokmasuk.getText() + "')";
            
            String sqll = "UPDATE produk_masuk SET id_supplier = '"
                    +txt_idsuppiler.getText()+"', tanggal = '"+tgl+"' WHERE id_masuk = '"
                    + txt_idmasukproduk.getText()+"'";
            java.sql.Connection conn = (Connection) koneksi.koneksi();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
             java.sql.PreparedStatement pstl = conn.prepareStatement(sqll);
            pst.execute();
              pstl.execute();
            DefaultTableModel model = (DefaultTableModel) Model_Data.getModel();
            model.setRowCount(0);
          
             }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());

        }
        load_table();
        kosong();
      
        
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kembaliActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new ProdukMasuk().setVisible(true);
    }//GEN-LAST:event_btn_kembaliActionPerformed

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
            java.util.logging.Logger.getLogger(InputProdukMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InputProdukMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InputProdukMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InputProdukMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InputProdukMasuk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Model_Data;
    private javax.swing.JButton btn_hitung;
    private javax.swing.JButton btn_kembali;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JComboBox combobox_namaproduk;
    private javax.swing.JComboBox combobox_pemasok;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField txt_idmasukproduk;
    private javax.swing.JTextField txt_idsuppiler;
    private javax.swing.JTextField txt_jumlahtotalstok;
    private javax.swing.JTextField txt_namaproduk;
    private javax.swing.JTextField txt_stokmasuk;
    // End of variables declaration//GEN-END:variables

 

    
    }

  

