/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inputan;

import Menu.Penjualan;
import Menu.Supplier;
import Menu.koneksi;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class InputPenjualan extends javax.swing.JFrame {

    /**
     * Creates new form InputPenjualan
     */
    public InputPenjualan() {
        ImageIcon icon = new ImageIcon("src/IMAGE/logo.png");
        setIconImage(icon.getImage());
        initComponents();
        tampilidpenjualan();
        tampilproduk();
        tampilkodeproduk();
        tampilharga();
        load_table();
        auto_sum();
        tampilhargatotal();
        tampiltotalbarang();
        txt_kodeproduk.setEditable(false);
        txt_idpenjualan.setEditable(false);
    }

    private void tampilidpenjualan() {
        try {
            String sql = "SELECT id_penjualan FROM penjualan ORDER BY id_penjualan DESC LIMIT 1";
            java.sql.Connection conn = (Connection) koneksi.koneksi();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery(sql);
            while (rs.next()) {
                txt_idpenjualan.setText(rs.getString("id_penjualan"));
            }
        } catch (SQLException ex) {

        }
    }

    private void tampilkodeproduk() {
        try {
            String sql = "select kode_produk from produk where nama_produk='" + JComboBox.getSelectedItem() + "'";
            java.sql.Connection conn = (Connection) koneksi.koneksi();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery(sql);
            while (rs.next()) {
                txt_kodeproduk.setText(rs.getString("kode_produk"));
            }
        } catch (SQLException ex) {

        }
    }

    private void tampilharga() {
        try {
            String sql = "select harga from produk where nama_produk='" + JComboBox.getSelectedItem() + "'";
            java.sql.Connection conn = (Connection) koneksi.koneksi();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery(sql);
            while (rs.next()) {
                txt_hargaitem.setText(rs.getString("harga"));
            }
        } catch (SQLException ex) {

        }
    }

    private void tampilhargatotal() {
        try {
            String sql = "SELECT SUM(jml_item*harga_item) FROM detail_penjualan WHERE id_penjualan = '"
                    + txt_idpenjualan.getText() + "'";
            java.sql.Connection conn = (Connection) koneksi.koneksi();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery(sql);
            while (rs.next()) {
                txt_jumlahbayar.setText(rs.getString("SUM(jml_item*harga_item)"));
            }
        } catch (SQLException ex) {

        }
    }

    private void tampiltotalbarang() {
        try {
            String sql = "SELECT SUM(jml_item) FROM detail_penjualan WHERE id_penjualan = '"
                    + txt_idpenjualan.getText() + "'";
            java.sql.Connection conn = (Connection) koneksi.koneksi();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery(sql);
            while (rs.next()) {
                txt_totalbarang.setText(rs.getString("SUM(jml_item)"));
            }
        } catch (SQLException ex) {

        }
    }

    private void tampilproduk() {
        try {
            String sql = "select nama_produk from produk order by nama_produk ASC";
            java.sql.Connection conn = (Connection) koneksi.koneksi();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery(sql);
            while (rs.next()) {
                JComboBox.addItem(rs.getString("nama_produk"));
                tampilkodeproduk();
                tampilharga();
            }
        } catch (SQLException ex) {

        }
    }

    private void load_table() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id penjualan");
        model.addColumn("Nama Produk");
        model.addColumn("Jumlah Item");
        model.addColumn("Harga per KG");
        model.addColumn("Harga Total");
        // menampilkan database ke dalam table
        try {
            String sql = "SELECT detail_penjualan.id_penjualan, produk.nama_produk, "
                    + "detail_penjualan.jml_item, detail_penjualan.harga_item, "
                    + "(detail_penjualan.jml_item*detail_penjualan.harga_item) AS jumlah_harga "
                    + "FROM detail_penjualan JOIN produk ON detail_penjualan.kode_produk=produk.kode_produk "
                    + "WHERE detail_penjualan.id_penjualan = '"
                    + txt_idpenjualan.getText() + "' GROUP BY produk.nama_produk";
            java.sql.Connection conn = (Connection) koneksi.koneksi();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                model.addRow(new Object[]{res.getString(1),
                    res.getString(2), res.getString(3), res.getString(4), res.getString(5)});
            }
            jTable1.setModel(model);
        } catch (Exception e) {

        }
    }
    
    private int getStok(String text){
              try {
                    String sql = "SELECT stok FROM produk WHERE kode_produk='"+JComboBox.getSelectedItem()+"'";
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

    public final void auto_sum() {
        int sum = 0;
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            sum = sum + Integer.parseInt(jTable1.getValueAt(i, 3).toString());
        }
        txt_jumlahbayar.setText(Integer.toString(sum));
    }

    private static class object {

        public object() {
        }
    }

    public class AutoComplete extends JComboBox<object> {

        String[] keyWord = null;
        Vector vec = new Vector();

        public AutoComplete(String[] keyWord) {
            this.keyWord = keyWord;
            setModel(new DefaultComboBoxModel<>(vec));
            setSelectedIndex(-1);
            setEditable(true);
            JTextField text = (JTextField) getEditor().getEditorComponent();
            text.setFocusable(true);
            text.setText("");
            text.addKeyListener(new ComboListener(this, vec));
            setMyVector();
            setSelectedIndex(0);
        }

        private void setMyVector() {
            int a;
            for (a = 0; a < keyWord.length; a++) {
                vec.add(keyWord[a]);
            }
        }
    }

    class ComboListener extends KeyAdapter {

        JComboBox cblistener;
        Vector vec;

        public ComboListener(JComboBox cblistener, Vector vec) {
            this.cblistener = cblistener;
            this.vec = vec;
        }

        @Override
        public void keyReleased(KeyEvent e) {
            String text = ((JTextField) e.getSource()).getText();
            cblistener.setModel(new DefaultComboBoxModel(getFilteredList(text)));
            cblistener.setSelectedIndex(-1);
            ((JTextField) cblistener.getEditor().getEditorComponent()).setText(text);
            cblistener.showPopup();
        }

        public Vector getFilteredList(String text) {
            Vector v = new Vector();
            for (int i = 0; i < vec.size(); i++) {
                if (vec.get(i).toString().startsWith(text)) {
                    v.add(vec.get(i).toString());
                } else if (vec.get(i).toString().startsWith(text.toLowerCase())) {
                    v.add(vec.get(i).toString());
                } else if (vec.get(i).toString().startsWith(text.toUpperCase())) {
                    v.add(vec.get(i).toString());
                }
            }
            return v;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_jumlahitem = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_hargaitem = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        btn_tambah = new javax.swing.JButton();
        btn_hitung = new javax.swing.JButton();
        JComboBox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txt_idpenjualan = new javax.swing.JTextField();
        txt_kodeproduk = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_jumlahbayar = new javax.swing.JTextField();
        txt_totalbarang = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btn_simpan = new javax.swing.JButton();
        btn_kembali = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Input Data Penjualan");

        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setPreferredSize(new java.awt.Dimension(1920, 1080));

        jLabel1.setFont(new java.awt.Font("Montserrat Medium", 0, 24)); // NOI18N
        jLabel1.setText("Input Data Penjualan");

        txt_jumlahitem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_jumlahitemActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel2.setText("Nama produk");

        jLabel3.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel3.setText("Jumlah item");

        txt_hargaitem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hargaitemActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel4.setText("Harga per  item");

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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel8.setFont(new java.awt.Font("Montserrat Medium", 0, 20)); // NOI18N
        jLabel8.setText("Total pembelian");

        btn_tambah.setBackground(new java.awt.Color(99, 88, 220));
        btn_tambah.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        btn_tambah.setForeground(new java.awt.Color(255, 255, 255));
        btn_tambah.setText("Tambahkan");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });

        btn_hitung.setBackground(new java.awt.Color(99, 88, 220));
        btn_hitung.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        btn_hitung.setForeground(new java.awt.Color(255, 255, 255));
        btn_hitung.setText("Hitung");
        btn_hitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hitungActionPerformed(evt);
            }
        });

        JComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Pilih produk -" }));
        JComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JComboBoxActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel5.setText("Penjualan ke-");

        txt_idpenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idpenjualanActionPerformed(evt);
            }
        });

        txt_kodeproduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_kodeprodukActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel6.setText("Kode produk");

        jLabel9.setFont(new java.awt.Font("Montserrat Medium", 0, 18)); // NOI18N
        jLabel9.setText("Jumlah yang harus dibayar");

        txt_jumlahbayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_jumlahbayarActionPerformed(evt);
            }
        });

        txt_totalbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalbarangActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Montserrat Medium", 0, 18)); // NOI18N
        jLabel10.setText("Total barang");

        btn_simpan.setBackground(new java.awt.Color(99, 88, 220));
        btn_simpan.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        btn_simpan.setForeground(new java.awt.Color(255, 255, 255));
        btn_simpan.setText("Simpan");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3)
                                .addComponent(txt_jumlahitem)
                                .addComponent(JComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_hargaitem)
                                .addComponent(txt_idpenjualan)
                                .addComponent(jLabel6)
                                .addComponent(txt_kodeproduk, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(63, 63, 63)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_hitung, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(455, 455, 455))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(txt_jumlahbayar, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(txt_totalbarang, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_kembali, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(455, 455, 455)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_idpenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_kodeproduk, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(txt_jumlahbayar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_jumlahitem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(36, 36, 36)
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_hargaitem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btn_hitung, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10)
                            .addGap(18, 18, 18)
                            .addComponent(txt_totalbarang, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_kembali, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1336, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1354, 772));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_jumlahitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_jumlahitemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_jumlahitemActionPerformed

    private void JComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JComboBoxActionPerformed
        tampilharga();
        tampilkodeproduk();
    }//GEN-LAST:event_JComboBoxActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        try {
            if (txt_jumlahitem.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Data Anda ada yang kosong!");
            } else {
                Date now = new Date();
                SimpleDateFormat simpleDateFormat
                        = new SimpleDateFormat("yyyy-MM-dd");
                String tgl = simpleDateFormat.format(now);
                //validasi kolom tidak kosong
                if (txt_jumlahitem.getText().equals("") || txt_hargaitem.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Data Anda ada yang kosong!");
                } else {
                    int stokInput = Integer.parseInt(txt_jumlahitem.getText()),
                            stok = getStok(txt_kodeproduk.getText());

                    // jika input stok > stok
                    if (stokInput > stok) {

                        JOptionPane.showMessageDialog(this, "Stok Buah Kurang!");
                    } // jika input stok < stok
                    else if (stokInput <= stok) {
                        String sql = "INSERT INTO detail_penjualan VALUES ('"
                                + txt_idpenjualan.getText() + "','"
                                + txt_kodeproduk.getText() + "','"
                                + txt_jumlahitem.getText() + "','" + txt_hargaitem.getText() + "')";
                        java.sql.Connection conn = (Connection) koneksi.koneksi();
                        java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                        pst.execute();
                        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                        model.setRowCount(0);
                        load_table();
                    }
                }
            }
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void txt_idpenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idpenjualanActionPerformed
        tampilidpenjualan();
    }//GEN-LAST:event_txt_idpenjualanActionPerformed

    private void txt_hargaitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hargaitemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hargaitemActionPerformed

    private void txt_kodeprodukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_kodeprodukActionPerformed


    }//GEN-LAST:event_txt_kodeprodukActionPerformed

    private void btn_hitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hitungActionPerformed

        tampilhargatotal();
        tampiltotalbarang();
    }//GEN-LAST:event_btn_hitungActionPerformed

    private void txt_jumlahbayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_jumlahbayarActionPerformed

    }//GEN-LAST:event_txt_jumlahbayarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
//        int harga_total;
//        int hargaTotal = (int) jTable1.getValueAt(jTable1.getSelectedRow(), harga_total);
//
//        txt_jumlahbayar.setText(String.format("%,d", hargaTotal));
    }//GEN-LAST:event_jTable1MouseClicked

    private void txt_totalbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalbarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalbarangActionPerformed

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        try {
            String sql = "UPDATE penjualan SET jumlah_total = '"
                    + txt_totalbarang.getText() + "', harga_total = '"
                    + txt_jumlahbayar.getText() + "' WHERE id_penjualan = '"
                    + txt_idpenjualan.getText() + "'";
            java.sql.Connection conn = (Connection) koneksi.koneksi();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Penyimpanan data berhasil");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }


    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kembaliActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new Penjualan().setVisible(true);
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
            java.util.logging.Logger.getLogger(InputPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InputPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InputPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InputPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InputPenjualan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JComboBox;
    private javax.swing.JButton btn_hitung;
    private javax.swing.JButton btn_kembali;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txt_hargaitem;
    private javax.swing.JTextField txt_idpenjualan;
    private javax.swing.JTextField txt_jumlahbayar;
    private javax.swing.JTextField txt_jumlahitem;
    private javax.swing.JTextField txt_kodeproduk;
    private javax.swing.JTextField txt_totalbarang;
    // End of variables declaration//GEN-END:variables
}
