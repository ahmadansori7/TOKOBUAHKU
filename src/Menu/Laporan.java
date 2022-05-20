/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class Laporan extends javax.swing.JFrame {

    /**
     * Creates new form Laporan
     */
    public Laporan() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
         ImageIcon icon = new ImageIcon("src/IMAGE/logo.png");
        setIconImage(icon.getImage());
         penjualan();
         pengeluaran();
         penjualantabel();
         pengeluarantabel();
        // pendapatanBersih();
         totalpendapatantahunlalu();
         getTotalPendapatan();
         totalpendapatan();
         data_januari();
         data_februari();
         data_maret();
         data_april();
         data_mei();
          data_juni();
          data_juli();
          data_agustus();
          data_september();
          data_oktober();
          data_november();
          data_desember();
    }

     //digunakan untuk menampilkan total pendapatan pada bulan januari
    
    private void data_januari(){
         try {
             
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = 
        new SimpleDateFormat("yyyy");
        String tgl = simpleDateFormat.format(now);
        
        String sql = "SELECT sum(harga_total) as harga_total from penjualan WHERE YEAR(tanggal) = '"+tgl+"' AND MONTH(tanggal) = '01'";      
         java.sql.Connection conn=(Connection)koneksi.koneksi();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet rs= pst.executeQuery(sql);                             
        while(rs.next()){
             String data = rs.getString("harga_total");
            if(data == null){
                data_januari.setText("Rp. 0.00");   
            }else{
                 int pendTotal = getTotalPendapatan(),
                  penBulanIni = Integer.parseInt(data),
                presentase = (penBulanIni * 100) / pendTotal;
                jProgressBar2.setMinimum(0);
                jProgressBar2.setMaximum(100);
                jProgressBar2.setValue(presentase); 
                data_januari.setText(String.format("Rp. %,d", Integer.parseInt(data))); 
            }                                                     
        }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
         //digunakan untuk menampilkan total pendapatan pada bulan februari
    
    private void data_februari(){
         try {
             
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = 
        new SimpleDateFormat("yyyy");
        String tgl = simpleDateFormat.format(now);
        
        String sql = "SELECT sum(harga_total) as harga_total from penjualan WHERE YEAR(tanggal) = '"+tgl+"' AND MONTH(tanggal) = '02'";      
         java.sql.Connection conn=(Connection)koneksi.koneksi();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet rs= pst.executeQuery(sql);                             
        while(rs.next()){
             String data = rs.getString("harga_total");
            if(data == null){
                data_feb.setText("Rp. 0.00");   
            }else{
                 int pendTotal = getTotalPendapatan(),
                  penBulanIni = Integer.parseInt(data),
                presentase = (penBulanIni * 100) / pendTotal;
                jProgressBar3.setMinimum(0);
                jProgressBar3.setMaximum(100);
                jProgressBar3.setValue(presentase); 
                data_feb.setText(String.format("Rp. %,d", Integer.parseInt(data))); 
            }                                                     
        }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
     //digunakan untuk menampilkan total pendapatan pada bulan maret
    private void data_maret(){
         try {
             
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = 
        new SimpleDateFormat("yyyy");
        String tgl = simpleDateFormat.format(now);
        
        String sql = "SELECT sum(harga_total) as harga_total from penjualan WHERE YEAR(tanggal) = '"+tgl+"' AND MONTH(tanggal) = '03'";      
         java.sql.Connection conn=(Connection)koneksi.koneksi();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet rs= pst.executeQuery(sql);                             
        while(rs.next()){
             String data = rs.getString("harga_total");
            if(data == null){
                data_mar.setText("Rp. 0.00");   
            }else{
                 int pendTotal = getTotalPendapatan(),
                  penBulanIni = Integer.parseInt(data),
                presentase = (penBulanIni * 100) / pendTotal;
                jProgressBar4.setMinimum(0);
                jProgressBar4.setMaximum(100);
                jProgressBar4.setValue(presentase); 
                data_mar.setText(String.format("Rp. %,d", Integer.parseInt(data))); 
            }                                                     
        }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
         //digunakan untuk menampilkan total pendapatan pada bulan april
    private void data_april(){
         try {
             
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = 
        new SimpleDateFormat("yyyy");
        String tgl = simpleDateFormat.format(now);
        
        String sql = "SELECT sum(harga_total) as harga_total from penjualan WHERE YEAR(tanggal) = '"+tgl+"' AND MONTH(tanggal) = '04'";      
         java.sql.Connection conn=(Connection)koneksi.koneksi();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet rs= pst.executeQuery(sql);                             
        while(rs.next()){
             String data = rs.getString("harga_total");
            if(data == null){
                data_april.setText("Rp. 0.00");   
            }else{
                 int pendTotal = getTotalPendapatan(),
                  penBulanIni = Integer.parseInt(data),
                presentase = (penBulanIni * 100) / pendTotal;
                jProgressBar6.setMinimum(0);
                jProgressBar6.setMaximum(100);
                jProgressBar6.setValue(presentase); 
                data_april.setText(String.format("Rp. %,d", Integer.parseInt(data))); 
            }                                                     
        }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
     //digunakan untuk menampilkan total pendapatan pada bulan mei
    private void data_mei(){
         try {
             
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = 
        new SimpleDateFormat("yyyy");
        String tgl = simpleDateFormat.format(now);
        
        String sql = "SELECT sum(harga_total) as harga_total from penjualan WHERE YEAR(tanggal) = '"+tgl+"' AND MONTH(tanggal) = '05'";      
         java.sql.Connection conn=(Connection)koneksi.koneksi();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet rs= pst.executeQuery(sql);                             
        while(rs.next()){
             String data = rs.getString("harga_total");
            if(data == null){
                data_mei.setText("Rp. 0.00");   
            }else{
                 int pendTotal = getTotalPendapatan(),
                  penBulanIni = Integer.parseInt(data),
                presentase = (penBulanIni * 100) / pendTotal;
                jProgressBar1.setMinimum(0);
                jProgressBar1.setMaximum(100);
                jProgressBar1.setValue(presentase); 
                data_mei.setText(String.format("Rp. %,d", Integer.parseInt(data))); 
            }                                                     
        }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
         //digunakan untuk menampilkan total pendapatan pada bulan juni
    private void data_juni(){
         try {
             
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = 
        new SimpleDateFormat("yyyy");
        String tgl = simpleDateFormat.format(now);
        
        String sql = "SELECT sum(harga_total) as harga_total from penjualan WHERE YEAR(tanggal) = '"+tgl+"' AND MONTH(tanggal) = '06'";      
         java.sql.Connection conn=(Connection)koneksi.koneksi();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet rs= pst.executeQuery(sql);                             
        while(rs.next()){
             String data = rs.getString("harga_total");
            if(data == null){
                data_jun.setText("Rp. 0.00");   
            }else{
                 int pendTotal = getTotalPendapatan(),
                  penBulanIni = Integer.parseInt(data),
                presentase = (penBulanIni * 100) / pendTotal;
                jProgressBar7.setMinimum(0);
                jProgressBar7.setMaximum(100);
                jProgressBar7.setValue(presentase); 
                data_jun.setText(String.format("Rp. %,d", Integer.parseInt(data))); 
            }                                                     
        }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
             //digunakan untuk menampilkan total pendapatan pada bulan juli
    private void data_juli(){
         try {
             
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = 
        new SimpleDateFormat("yyyy");
        String tgl = simpleDateFormat.format(now);
        
        String sql = "SELECT sum(harga_total) as harga_total from penjualan WHERE YEAR(tanggal) = '"+tgl+"' AND MONTH(tanggal) = '07'";      
         java.sql.Connection conn=(Connection)koneksi.koneksi();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet rs= pst.executeQuery(sql);                             
        while(rs.next()){
             String data = rs.getString("harga_total");
            if(data == null){
                data_jul.setText("Rp. 0.00");   
            }else{
                 int pendTotal = getTotalPendapatan(),
                  penBulanIni = Integer.parseInt(data),
                presentase = (penBulanIni * 100) / pendTotal;
                jProgressBar8.setMinimum(0);
                jProgressBar8.setMaximum(100);
                jProgressBar8.setValue(presentase); 
                data_jul.setText(String.format("Rp. %,d", Integer.parseInt(data))); 
            }                                                     
        }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
                 //digunakan untuk menampilkan total pendapatan pada bulan agustus
    private void data_agustus(){
         try {
             
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = 
        new SimpleDateFormat("yyyy");
        String tgl = simpleDateFormat.format(now);
        
        String sql = "SELECT sum(harga_total) as harga_total from penjualan WHERE YEAR(tanggal) = '"+tgl+"' AND MONTH(tanggal) = '08'";      
         java.sql.Connection conn=(Connection)koneksi.koneksi();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet rs= pst.executeQuery(sql);                             
        while(rs.next()){
             String data = rs.getString("harga_total");
            if(data == null){
                data_agustus.setText("Rp. 0.00");   
            }else{
                 int pendTotal = getTotalPendapatan(),
                  penBulanIni = Integer.parseInt(data),
                presentase = (penBulanIni * 100) / pendTotal;
                jProgressBar5.setMinimum(0);
                jProgressBar5.setMaximum(100);
                jProgressBar5.setValue(presentase); 
                data_agustus.setText(String.format("Rp. %,d", Integer.parseInt(data))); 
            }                                                     
        }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
                   //digunakan untuk menampilkan total pendapatan pada bulan september
    private void data_september(){
         try {
             
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = 
        new SimpleDateFormat("yyyy");
        String tgl = simpleDateFormat.format(now);
        
        String sql = "SELECT sum(harga_total) as harga_total from penjualan WHERE YEAR(tanggal) = '"+tgl+"' AND MONTH(tanggal) = '09'";      
         java.sql.Connection conn=(Connection)koneksi.koneksi();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet rs= pst.executeQuery(sql);                             
        while(rs.next()){
             String data = rs.getString("harga_total");
            if(data == null){
                data_sep.setText("Rp. 0.00");   
            }else{
                
                 int pendTotal = getTotalPendapatan(),
                  penBulanIni = Integer.parseInt(data),
                presentase = (penBulanIni * 100) / pendTotal;
                jProgressBar9.setMinimum(0);
                jProgressBar9.setMaximum(100);
                jProgressBar9.setValue(presentase); 
                data_sep.setText(String.format("Rp. %,d", Integer.parseInt(data))); 
            }                                                     
        }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
                     //digunakan untuk menampilkan total pendapatan pada bulan oktober
    private void data_oktober(){
         try {
             
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = 
        new SimpleDateFormat("yyyy");
        String tgl = simpleDateFormat.format(now);
        
        String sql = "SELECT sum(harga_total) as harga_total from penjualan WHERE YEAR(tanggal) = '"+tgl+"' AND MONTH(tanggal) = '10'";      
         java.sql.Connection conn=(Connection)koneksi.koneksi();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet rs= pst.executeQuery(sql);                             
        while(rs.next()){
             String data = rs.getString("harga_total");
            if(data == null){
                data_oktober.setText("Rp. 0.00");   
            }else{
                 int pendTotal = getTotalPendapatan(),
                  penBulanIni = Integer.parseInt(data),
                presentase = (penBulanIni * 100) / pendTotal;
                jProgressBar10.setMinimum(0);
                jProgressBar10.setMaximum(100);
                jProgressBar10.setValue(presentase); 
                data_oktober.setText(String.format("Rp. %,d", Integer.parseInt(data))); 
            }                                                     
        }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
                    //digunakan untuk menampilkan total pendapatan pada bulan november
    private void data_november(){
         try {
             
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = 
        new SimpleDateFormat("yyyy");
        String tgl = simpleDateFormat.format(now);
        
        String sql = "SELECT sum(harga_total) as harga_total from penjualan WHERE YEAR(tanggal) = '"+tgl+"' AND MONTH(tanggal) = '11'";      
         java.sql.Connection conn=(Connection)koneksi.koneksi();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet rs= pst.executeQuery(sql);                             
        while(rs.next()){
             String data = rs.getString("harga_total");
            if(data == null){
                data_nov.setText("Rp. 0.00");   
            }else{
           int pendTotal = getTotalPendapatan(),
                  penBulanIni = Integer.parseInt(data),
                presentase = (penBulanIni * 100) / pendTotal;
                jProgressBar11.setMinimum(0);
                jProgressBar11.setMaximum(100);
                jProgressBar11.setValue(presentase); 
                
                data_nov.setText(String.format("Rp. %,d", Integer.parseInt(data))); 
            }                                                     
        }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    
 //digunakan untuk menampilkan total pendapatan pada bulan desember
private void data_desember(){
         try {
             
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = 
        new SimpleDateFormat("yyyy");
        String tgl = simpleDateFormat.format(now);
        String sql = "SELECT sum(harga_total) as harga_total from penjualan WHERE YEAR(tanggal) = '"+tgl+"' AND MONTH(tanggal) = '12'"; 
                 
        java.sql.Connection conn=(Connection)koneksi.koneksi();
        java.sql.PreparedStatement pst=conn.prepareStatement(sql);
        java.sql.ResultSet rs= pst.executeQuery(sql);   
                 
        while(rs.next()){
            String data = rs.getString("harga_total");
            if(data == null){
                data_desember.setText("Rp. 0.00");   
            }else{
              int pendTotal = getTotalPendapatan(),
                  penBulanIni = Integer.parseInt(data),
                presentase = (penBulanIni * 100) / pendTotal;
                jProgressBar12.setMinimum(0);
                jProgressBar12.setMaximum(100);
                jProgressBar12.setValue(presentase); 
                data_desember.setText(String.format("Rp. %,d", Integer.parseInt(data))); 
            }                                                     
        }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

//digunakan untuk menampilkan jumlah total pendapatan selama 1 tahun dilabel totalpendapatan
    private int getTotalPengeluaran() {
         try {
             
                Date now = new Date();
                SimpleDateFormat simpleDateFormat = 
                new SimpleDateFormat("yyyy");
                String tgl = simpleDateFormat.format(now), data;

                String sql = "select sum(produk_keluar.stok_keluar * produk.harga) as jml_total from produk_keluar join produk on produk_keluar.kode_produk = produk.kode_produk where not produk_keluar.keterangan='terjual' AND YEAR(produk_keluar.tanggal) = '"+tgl+"'";      
                java.sql.Connection conn=(Connection)koneksi.koneksi();
                java.sql.PreparedStatement pst=conn.prepareStatement(sql);
                java.sql.ResultSet rs= pst.executeQuery(sql);                             

                while(rs.next()){
                    data = rs.getString("jml_total");
                    if(data == null){
                        return 0;
                    }else{
                        return Integer.parseInt(data);
                    }                                                     
                }
                 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
           return -1;
       }
        
    
  //digunakan untuk menampilkan jumlah total pendapatan selama 1 tahun dilabel totalpendapatan
    private int getTotalPendapatan() {
         try {
             
                Date now = new Date();
                SimpleDateFormat simpleDateFormat = 
                new SimpleDateFormat("yyyy");
                String tgl = simpleDateFormat.format(now), data;

                String sql = "SELECT sum(harga_total) as harga_total from penjualan WHERE YEAR(tanggal) = '"+tgl+"'";      
                java.sql.Connection conn=(Connection)koneksi.koneksi();
                java.sql.PreparedStatement pst=conn.prepareStatement(sql);
                java.sql.ResultSet rs= pst.executeQuery(sql);                             

                while(rs.next()){
                    data = rs.getString("harga_total");
                    if(data == null){
                        return 0;
                    }else{
                        return Integer.parseInt(data);
                    }                                                     
                }
                 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
           return -1;
       }
    
    
//    private void pendapatanBersih () {
//         int pendkotor = getTotalPendapatan(),
//             totalpengeluaran= getTotalPengeluaran(),
//             pendbersih =  pendkotor - totalpengeluaran;
//             String data = String.valueOf(pendbersih);
//             totalpendapatan.setText(String.format("Rp. %,d", Integer.parseInt(data))); 
//    }
    

    //digunakan untuk menampilkan jumlah total pendapatan selama 1 tahun dilabel totalpendapatan

    private void totalpendapatan() {
         try {
             
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = 
        new SimpleDateFormat("yyyy");
        String tgl = simpleDateFormat.format(now);
        
        String sql = "SELECT sum(harga_total) as harga_total from penjualan WHERE YEAR(tanggal) = '"+tgl+"'";      
         java.sql.Connection conn=(Connection)koneksi.koneksi();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet rs= pst.executeQuery(sql);                             
        while(rs.next()){
             String data = rs.getString("harga_total");
            if(data == null){
                totalpendapatan.setText("Rp. 0.00");   
            }else{
                totalpendapatan.setText(String.format("Rp. %,d", Integer.parseInt(data))); 
            }                                                     
        }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
       }
    
     //digunakan untuk menampilkan jumlah total pendapatan tahun lalu dilabel pendapatantahunlalu
    private void totalpendapatantahunlalu() {
         try {
             
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = 
        new SimpleDateFormat("yyyy");
        String tgl = simpleDateFormat.format(now);
        int tgllama = Integer.parseInt(tgl) - 1;
    
        String sql = "SELECT sum(harga_total) as harga_total from penjualan WHERE YEAR(tanggal) = '"+tgllama+"'";      
         java.sql.Connection conn=(Connection)koneksi.koneksi();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet rs= pst.executeQuery(sql);                             
        while(rs.next()){
             String data = rs.getString("harga_total");
            if(data == null){
                pendapatantahunlalu.setText("Rp. 0.00");   
            }else{
                pendapatantahunlalu.setText(String.format("Rp. %,d", Integer.parseInt(data)));
            }                                                     
        }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
       }
    
    //digunakan untuk menampilkan jumlah total penjualan dilabel penjualan
     private void penjualan() {
         try {
             
              Date now = new Date();
        SimpleDateFormat simpleDateFormat = 
        new SimpleDateFormat("yyyy");
        String tgl = simpleDateFormat.format(now);
        
        String sql = "select sum(harga_total) as jml_total from penjualan WHERE YEAR(tanggal) = '"+tgl+"'";      
         java.sql.Connection conn=(Connection)koneksi.koneksi();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet rs= pst.executeQuery(sql);                             
        while(rs.next()){
             String data = rs.getString("jml_total");
            if(data == null){
                penjualan.setText("Rp. 0.00");   
            }else{
                penjualan.setText(String.format("Rp. %,d", Integer.parseInt(data))); 
            }                                                     
        }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
       }
     
     //digunakan untuk menampilkan jumlah total pengeluaran ke label pengeluaran
      private void pengeluaran() {
         try {
 
                 Date now = new Date();
        SimpleDateFormat simpleDateFormat = 
        new SimpleDateFormat("yyyy");
        String tgl = simpleDateFormat.format(now);
        
        String sql = "select sum(produk_keluar.stok_keluar * produk.harga) as jml_total from produk_keluar join produk on produk_keluar.kode_produk = produk.kode_produk where not produk_keluar.keterangan='terjual' AND YEAR(produk_keluar.tanggal) = '"+tgl+"'";      
         java.sql.Connection conn=(Connection)koneksi.koneksi();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet rs= pst.executeQuery(sql);                             
        while(rs.next()){
              String data = rs.getString("jml_total");
            if(data == null){
                pengeluaran.setText("Rp. 0.00");   
            }else{
                pengeluaran.setText(String.format("Rp. %,d", Integer.parseInt(data)));
            }           
        }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
       }
      
      //digunakan untuk menampilkan data penjualan ke jtable1
private void penjualantabel() {
          DefaultTableModel model = new DefaultTableModel();
          model.addColumn("Id Penjualan");
        model.addColumn("Nama Produk");
          model.addColumn("Jumlah (KG)");
        model.addColumn("Harga Total");
         model.addColumn("Tanggal");
        try {
         
            String sql = "Select detail_penjualan.id_penjualan, produk.nama_produk, detail_penjualan.jml_item, (detail_penjualan.jml_item * detail_penjualan.harga_item) as total, penjualan.tanggal from produk join detail_penjualan on produk.kode_produk = detail_penjualan.kode_produk join penjualan on detail_penjualan.id_penjualan = penjualan.id_penjualan order by penjualan.tanggal desc";
           java.sql.Connection conn=(Connection)koneksi.koneksi();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet rs= pst.executeQuery(sql);
             
            while(rs.next()) {
                model.addRow(new Object[] 
               {rs.getString(1),rs.getString(2),rs.getString(3),("+ " +rs.getString(4)),rs.getString(5)});
 
            }
            jTable1.setModel(model);

        } catch (SQLException e) {
        
        }
       }

        //digunakan untuk menampilkan data pengeluaran ke jtable2

          private void pengeluarantabel() {
        DefaultTableModel model = new DefaultTableModel();
          model.addColumn("Id Pengeluaran");
        model.addColumn("Nama Produk");
          model.addColumn("Jumlah (KG)");
        model.addColumn("Harga Total");
         model.addColumn("Tanggal");
        
        try {
       
            String sql = "select produk_keluar.id_keluar, produk.nama_produk, produk_keluar.stok_keluar, (produk_keluar.stok_keluar * produk.harga) as total, produk_keluar.tanggal from produk join produk_keluar on produk.kode_produk = produk_keluar.kode_produk  WHERE not produk_keluar.keterangan ='Terjual' group by produk.nama_produk, produk_keluar.stok_keluar order by produk_keluar.tanggal desc";
           java.sql.Connection conn=(Connection)koneksi.koneksi();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet rs= pst.executeQuery(sql);
            while(rs.next()) {
                model.addRow(new Object[] 
              {rs.getString(1),rs.getString(2),rs.getString(3),("- " +rs.getString(4)),rs.getString(5)});
            }
            jTable2.setModel(model);

        } catch (SQLException e) {
        
        }
       }
          
          
           //digunakan untuk menampilkan data penjualan ke jtable1  menurut jdatechooser
private void penjualantabel1() {
          DefaultTableModel model = new DefaultTableModel();
           model.addColumn("Id Penjualan");
        model.addColumn("Nama Produk");
          model.addColumn("Jumlah (KG)");
        model.addColumn("Harga Total");
         model.addColumn("Tanggal");
        try {
               String tanggal = ((JTextField)txt_tgl1.getDateEditor().getUiComponent()).getText();
                  String tanggal2 = ((JTextField)txt_tgl2.getDateEditor().getUiComponent()).getText();
                  
            String sql = "Select detail_penjualan.id_penjualan, produk.nama_produk, detail_penjualan.jml_item, (detail_penjualan.jml_item * detail_penjualan.harga_item) as total, penjualan.tanggal from produk join detail_penjualan on produk.kode_produk = detail_penjualan.kode_produk join penjualan on detail_penjualan.id_penjualan = penjualan.id_penjualan WHERE penjualan.tanggal BETWEEN '"+tanggal+"' AND '"+tanggal2+"' order by penjualan.tanggal desc";
           java.sql.Connection conn=(Connection)koneksi.koneksi();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet rs= pst.executeQuery(sql);
             
            while(rs.next()) {
                model.addRow(new Object[] 
                {rs.getString(1),rs.getString(2),rs.getString(3),("+ " +rs.getString(4)),rs.getString(5)});
 
            }
            jTable1.setModel(model);

        } catch (SQLException e) {
        
        }
       }

        //digunakan untuk menampilkan data pengeluaran ke jtable2 menurut jdatechooser

          private void pengeluarantabel1() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id Pengeluaran");
        model.addColumn("Nama Produk");
          model.addColumn("Jumlah (KG)");
        model.addColumn("Harga Total");
         model.addColumn("Tanggal");
        
        try {
             String tanggal = ((JTextField)txt_tgl1.getDateEditor().getUiComponent()).getText();
                  String tanggal2 = ((JTextField)txt_tgl2.getDateEditor().getUiComponent()).getText();
            String sql = "select produk_keluar.id_keluar, produk.nama_produk, produk_keluar.stok_keluar, (produk_keluar.stok_keluar * produk.harga) as total, produk_keluar.tanggal from produk join produk_keluar on produk.kode_produk = produk_keluar.kode_produk  WHERE produk_keluar.tanggal BETWEEN '"+tanggal+"' AND '"+tanggal2+"' AND not produk_keluar.keterangan ='Terjual' order by produk_keluar.tanggal desc";
           java.sql.Connection conn=(Connection)koneksi.koneksi();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet rs= pst.executeQuery(sql);
            while(rs.next()) {
                model.addRow(new Object[] 
              {rs.getString(1),rs.getString(2),rs.getString(3),("- " +rs.getString(4)),rs.getString(5)});
            }
            jTable2.setModel(model);

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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txt_tgl2 = new com.toedter.calendar.JDateChooser();
        txt_tgl1 = new com.toedter.calendar.JDateChooser();
        btn_tampil = new javax.swing.JButton();
        penjualan = new java.awt.Label();
        pengeluaran = new java.awt.Label();
        label3 = new java.awt.Label();
        label4 = new java.awt.Label();
        label5 = new java.awt.Label();
        label6 = new java.awt.Label();
        label7 = new java.awt.Label();
        label8 = new java.awt.Label();
        label10 = new java.awt.Label();
        label11 = new java.awt.Label();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        label12 = new java.awt.Label();
        label9 = new java.awt.Label();
        label13 = new java.awt.Label();
        label2 = new java.awt.Label();
        totalpendapatan = new java.awt.Label();
        label121 = new java.awt.Label();
        pendapatantahunlalu = new java.awt.Label();
        jProgressBar1 = new javax.swing.JProgressBar();
        jProgressBar2 = new javax.swing.JProgressBar();
        jProgressBar3 = new javax.swing.JProgressBar();
        jProgressBar5 = new javax.swing.JProgressBar();
        jProgressBar4 = new javax.swing.JProgressBar();
        jProgressBar6 = new javax.swing.JProgressBar();
        Label123 = new java.awt.Label();
        data_agustus = new java.awt.Label();
        data_mar = new java.awt.Label();
        data_april = new java.awt.Label();
        data_mei = new java.awt.Label();
        jProgressBar7 = new javax.swing.JProgressBar();
        data_jun = new java.awt.Label();
        data_jul = new java.awt.Label();
        jProgressBar8 = new javax.swing.JProgressBar();
        data_sep = new java.awt.Label();
        jProgressBar9 = new javax.swing.JProgressBar();
        data_oktober = new java.awt.Label();
        jProgressBar10 = new javax.swing.JProgressBar();
        label1 = new java.awt.Label();
        data_nov = new java.awt.Label();
        jProgressBar11 = new javax.swing.JProgressBar();
        data_desember = new java.awt.Label();
        jProgressBar12 = new javax.swing.JProgressBar();
        data_feb = new java.awt.Label();
        data_januari = new java.awt.Label();
        Label124 = new java.awt.Label();
        Label125 = new java.awt.Label();
        Label126 = new java.awt.Label();
        Label127 = new java.awt.Label();
        Label128 = new java.awt.Label();
        Label129 = new java.awt.Label();
        Label130 = new java.awt.Label();
        Label131 = new java.awt.Label();
        Label132 = new java.awt.Label();
        Label133 = new java.awt.Label();
        Label134 = new java.awt.Label();
        label14 = new java.awt.Label();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Laporan");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jTable1.setDragEnabled(true);
        jTable1.setEnabled(false);
        jTable1.setRowHeight(20);
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 480, 780, 210));

        txt_tgl2.setDateFormatString("yyyy-MM-dd");
        txt_tgl2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                txt_tgl2AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        txt_tgl2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_tgl2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_tgl2MouseEntered(evt);
            }
        });
        getContentPane().add(txt_tgl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 380, 120, 50));

        txt_tgl1.setDateFormatString("yyyy-MM-dd");
        txt_tgl1.setMinSelectableDate(new java.util.Date(-62135791119000L));
        txt_tgl1.setMinimumSize(new java.awt.Dimension(10, 225));
        txt_tgl1.setOpaque(false);
        txt_tgl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_tgl1MouseClicked(evt);
            }
        });
        getContentPane().add(txt_tgl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 380, 130, 50));

        btn_tampil.setBackground(new java.awt.Color(99, 88, 220));
        btn_tampil.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btn_tampil.setForeground(new java.awt.Color(255, 255, 255));
        btn_tampil.setText("Tampilkan");
        btn_tampil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_tampil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tampilActionPerformed(evt);
            }
        });
        getContentPane().add(btn_tampil, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 380, 130, 50));

        penjualan.setBackground(new java.awt.Color(255, 255, 255));
        penjualan.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        penjualan.setText("label1");
        getContentPane().add(penjualan, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, 260, -1));

        pengeluaran.setBackground(new java.awt.Color(255, 255, 255));
        pengeluaran.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        pengeluaran.setText("label2");
        getContentPane().add(pengeluaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 130, 270, -1));

        label3.setBackground(new java.awt.Color(255, 255, 255));
        label3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        label3.setText("TO");
        getContentPane().add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 390, 30, 40));

        label4.setBackground(new java.awt.Color(255, 255, 255));
        label4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label4.setForeground(new java.awt.Color(204, 204, 204));
        label4.setText("Home");
        label4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label4MouseClicked(evt);
            }
        });
        getContentPane().add(label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 170, 50));

        label5.setBackground(new java.awt.Color(255, 255, 255));
        label5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label5.setForeground(new java.awt.Color(204, 204, 204));
        label5.setText("Barang");
        label5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label5MouseClicked(evt);
            }
        });
        getContentPane().add(label5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 170, 50));

        label6.setBackground(new java.awt.Color(255, 255, 255));
        label6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label6.setForeground(new java.awt.Color(0, 0, 0));
        label6.setText("Laporan");
        label6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label6MouseClicked(evt);
            }
        });
        getContentPane().add(label6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 170, 50));

        label7.setBackground(new java.awt.Color(255, 255, 255));
        label7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label7.setForeground(new java.awt.Color(204, 204, 204));
        label7.setText("Transit");
        label7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label7MouseClicked(evt);
            }
        });
        getContentPane().add(label7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, 170, 50));

        label8.setBackground(new java.awt.Color(255, 255, 255));
        label8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label8.setForeground(new java.awt.Color(204, 204, 204));
        label8.setText("Supplier");
        label8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label8MouseClicked(evt);
            }
        });
        getContentPane().add(label8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 170, 50));

        label10.setBackground(new java.awt.Color(255, 255, 255));
        label10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label10.setText("Logout");
        label10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label10MouseClicked(evt);
            }
        });
        getContentPane().add(label10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 930, 170, 50));

        label11.setBackground(new java.awt.Color(255, 255, 255));
        label11.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        label11.setText("Pengeluaran");
        getContentPane().add(label11, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 720, 110, 30));

        jTable2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable2.setEnabled(false);
        jTable2.setRowHeight(20);
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 750, 780, 200));

        label12.setBackground(new java.awt.Color(255, 255, 255));
        label12.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        label12.setText("Penjualan");
        getContentPane().add(label12, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 450, 90, 30));

        label9.setBackground(new java.awt.Color(255, 255, 255));
        label9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label9.setForeground(new java.awt.Color(204, 204, 204));
        label9.setText("Penjualan");
        label9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label9MouseClicked(evt);
            }
        });
        getContentPane().add(label9, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 450, 100, 50));

        label13.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(label13, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 720, 670, -1));

        label2.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(378, 960, 770, 50));

        totalpendapatan.setBackground(new java.awt.Color(255, 255, 255));
        totalpendapatan.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        totalpendapatan.setText("label14");
        getContentPane().add(totalpendapatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 80, 350, 50));

        label121.setBackground(new java.awt.Color(255, 255, 255));
        label121.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        label121.setForeground(new java.awt.Color(153, 153, 153));
        label121.setText("Dibandingkan tahun lalu");
        getContentPane().add(label121, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 140, 210, -1));

        pendapatantahunlalu.setBackground(new java.awt.Color(255, 255, 255));
        pendapatantahunlalu.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        pendapatantahunlalu.setForeground(new java.awt.Color(102, 102, 102));
        pendapatantahunlalu.setText("label14");
        getContentPane().add(pendapatantahunlalu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1500, 140, 150, -1));
        getContentPane().add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 490, 490, -1));
        getContentPane().add(jProgressBar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 250, 490, -1));
        getContentPane().add(jProgressBar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 310, 490, -1));
        getContentPane().add(jProgressBar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 670, 490, -1));
        getContentPane().add(jProgressBar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 370, 490, -1));
        getContentPane().add(jProgressBar6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 430, 490, -1));

        Label123.setBackground(new java.awt.Color(255, 255, 255));
        Label123.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Label123.setForeground(new java.awt.Color(102, 102, 102));
        Label123.setText("Desember");
        getContentPane().add(Label123, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 880, 180, -1));

        data_agustus.setAlignment(java.awt.Label.RIGHT);
        data_agustus.setBackground(new java.awt.Color(255, 255, 255));
        data_agustus.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        data_agustus.setForeground(new java.awt.Color(102, 102, 102));
        data_agustus.setText("agu");
        getContentPane().add(data_agustus, new org.netbeans.lib.awtextra.AbsoluteConstraints(1610, 640, 180, -1));

        data_mar.setAlignment(java.awt.Label.RIGHT);
        data_mar.setBackground(new java.awt.Color(255, 255, 255));
        data_mar.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        data_mar.setForeground(new java.awt.Color(102, 102, 102));
        data_mar.setText("mar");
        getContentPane().add(data_mar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1610, 340, 180, -1));

        data_april.setAlignment(java.awt.Label.RIGHT);
        data_april.setBackground(new java.awt.Color(255, 255, 255));
        data_april.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        data_april.setForeground(new java.awt.Color(102, 102, 102));
        data_april.setText("apr");
        getContentPane().add(data_april, new org.netbeans.lib.awtextra.AbsoluteConstraints(1610, 400, 180, -1));

        data_mei.setAlignment(java.awt.Label.RIGHT);
        data_mei.setBackground(new java.awt.Color(255, 255, 255));
        data_mei.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        data_mei.setForeground(new java.awt.Color(102, 102, 102));
        data_mei.setText("mei");
        getContentPane().add(data_mei, new org.netbeans.lib.awtextra.AbsoluteConstraints(1610, 460, 180, -1));
        getContentPane().add(jProgressBar7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 550, 490, -1));

        data_jun.setAlignment(java.awt.Label.RIGHT);
        data_jun.setBackground(new java.awt.Color(255, 255, 255));
        data_jun.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        data_jun.setForeground(new java.awt.Color(102, 102, 102));
        data_jun.setText("jun");
        getContentPane().add(data_jun, new org.netbeans.lib.awtextra.AbsoluteConstraints(1610, 520, 180, -1));

        data_jul.setAlignment(java.awt.Label.RIGHT);
        data_jul.setBackground(new java.awt.Color(255, 255, 255));
        data_jul.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        data_jul.setForeground(new java.awt.Color(102, 102, 102));
        data_jul.setText("jul");
        getContentPane().add(data_jul, new org.netbeans.lib.awtextra.AbsoluteConstraints(1610, 580, 180, -1));
        getContentPane().add(jProgressBar8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 610, 490, -1));

        data_sep.setAlignment(java.awt.Label.RIGHT);
        data_sep.setBackground(new java.awt.Color(255, 255, 255));
        data_sep.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        data_sep.setForeground(new java.awt.Color(102, 102, 102));
        data_sep.setText("sep");
        getContentPane().add(data_sep, new org.netbeans.lib.awtextra.AbsoluteConstraints(1610, 700, 180, -1));
        getContentPane().add(jProgressBar9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 730, 490, -1));

        data_oktober.setAlignment(java.awt.Label.RIGHT);
        data_oktober.setBackground(new java.awt.Color(255, 255, 255));
        data_oktober.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        data_oktober.setForeground(new java.awt.Color(102, 102, 102));
        data_oktober.setText("oct");
        getContentPane().add(data_oktober, new org.netbeans.lib.awtextra.AbsoluteConstraints(1610, 760, 180, -1));
        getContentPane().add(jProgressBar10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 790, 490, -1));

        label1.setBackground(new java.awt.Color(255, 255, 255));
        label1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        label1.setText("Total Pendapatan Tahun Ini");
        getContentPane().add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 40, -1, 50));

        data_nov.setAlignment(java.awt.Label.RIGHT);
        data_nov.setBackground(new java.awt.Color(255, 255, 255));
        data_nov.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        data_nov.setForeground(new java.awt.Color(102, 102, 102));
        data_nov.setText("nov");
        getContentPane().add(data_nov, new org.netbeans.lib.awtextra.AbsoluteConstraints(1610, 820, 180, -1));
        getContentPane().add(jProgressBar11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 850, 490, -1));

        data_desember.setAlignment(java.awt.Label.RIGHT);
        data_desember.setBackground(new java.awt.Color(255, 255, 255));
        data_desember.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        data_desember.setForeground(new java.awt.Color(102, 102, 102));
        data_desember.setText("des");
        getContentPane().add(data_desember, new org.netbeans.lib.awtextra.AbsoluteConstraints(1610, 880, 180, -1));
        getContentPane().add(jProgressBar12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 910, 490, -1));

        data_feb.setAlignment(java.awt.Label.RIGHT);
        data_feb.setBackground(new java.awt.Color(255, 255, 255));
        data_feb.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        data_feb.setForeground(new java.awt.Color(102, 102, 102));
        data_feb.setText("feb");
        getContentPane().add(data_feb, new org.netbeans.lib.awtextra.AbsoluteConstraints(1610, 280, 180, -1));

        data_januari.setAlignment(java.awt.Label.RIGHT);
        data_januari.setBackground(new java.awt.Color(255, 255, 255));
        data_januari.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        data_januari.setForeground(new java.awt.Color(102, 102, 102));
        data_januari.setText("jan");
        getContentPane().add(data_januari, new org.netbeans.lib.awtextra.AbsoluteConstraints(1610, 220, 180, -1));

        Label124.setBackground(new java.awt.Color(255, 255, 255));
        Label124.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Label124.setForeground(new java.awt.Color(102, 102, 102));
        Label124.setText("Januari");
        getContentPane().add(Label124, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 220, 180, -1));

        Label125.setBackground(new java.awt.Color(255, 255, 255));
        Label125.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Label125.setForeground(new java.awt.Color(102, 102, 102));
        Label125.setText("Februari");
        getContentPane().add(Label125, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 280, 180, -1));

        Label126.setBackground(new java.awt.Color(255, 255, 255));
        Label126.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Label126.setForeground(new java.awt.Color(102, 102, 102));
        Label126.setText("Maret");
        getContentPane().add(Label126, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 340, 180, -1));

        Label127.setBackground(new java.awt.Color(255, 255, 255));
        Label127.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Label127.setForeground(new java.awt.Color(102, 102, 102));
        Label127.setText("April");
        getContentPane().add(Label127, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 400, 180, -1));

        Label128.setBackground(new java.awt.Color(255, 255, 255));
        Label128.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Label128.setForeground(new java.awt.Color(102, 102, 102));
        Label128.setText("Mei");
        getContentPane().add(Label128, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 460, 180, -1));

        Label129.setBackground(new java.awt.Color(255, 255, 255));
        Label129.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Label129.setForeground(new java.awt.Color(102, 102, 102));
        Label129.setText("Juni");
        getContentPane().add(Label129, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 520, 180, -1));

        Label130.setBackground(new java.awt.Color(255, 255, 255));
        Label130.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Label130.setForeground(new java.awt.Color(102, 102, 102));
        Label130.setText("Juli");
        getContentPane().add(Label130, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 580, 180, -1));

        Label131.setBackground(new java.awt.Color(255, 255, 255));
        Label131.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Label131.setForeground(new java.awt.Color(102, 102, 102));
        Label131.setText("Agustus");
        getContentPane().add(Label131, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 640, 180, -1));

        Label132.setBackground(new java.awt.Color(255, 255, 255));
        Label132.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Label132.setForeground(new java.awt.Color(102, 102, 102));
        Label132.setText("September");
        getContentPane().add(Label132, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 700, 180, -1));

        Label133.setBackground(new java.awt.Color(255, 255, 255));
        Label133.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Label133.setForeground(new java.awt.Color(102, 102, 102));
        Label133.setText("Oktober");
        getContentPane().add(Label133, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 760, 180, -1));

        Label134.setBackground(new java.awt.Color(255, 255, 255));
        Label134.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        Label134.setForeground(new java.awt.Color(102, 102, 102));
        Label134.setText("November");
        getContentPane().add(Label134, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 820, 180, -1));

        label14.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(label14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 390, 110, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/LAPORAN KEUANGAN.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -80, 1975, 1110));

        setSize(new java.awt.Dimension(1887, 1071));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void label4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label4MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Dashboard().setVisible(true);
    }//GEN-LAST:event_label4MouseClicked

    private void label5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label5MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Barang().setVisible(true);
    }//GEN-LAST:event_label5MouseClicked

    private void label6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label6MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Laporan().setVisible(true);
    }//GEN-LAST:event_label6MouseClicked

    private void label7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label7MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new ProdukMasuk().setVisible(true);
    }//GEN-LAST:event_label7MouseClicked

    private void label8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label8MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Supplier().setVisible(true);
    }//GEN-LAST:event_label8MouseClicked

    private void label9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label9MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Penjualan().setVisible(true);
    }//GEN-LAST:event_label9MouseClicked

    private void label10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label10MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Login().setVisible(true);
    }//GEN-LAST:event_label10MouseClicked

    private void txt_tgl2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_tgl2MouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_tgl2MouseEntered

    private void txt_tgl2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_tgl2MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_tgl2MouseClicked

    private void txt_tgl2AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_txt_tgl2AncestorAdded
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_tgl2AncestorAdded

    private void btn_tampilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tampilActionPerformed
        // TODO add your handling code here:
        pengeluarantabel1();
        penjualantabel1();
    }//GEN-LAST:event_btn_tampilActionPerformed

    private void txt_tgl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_tgl1MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_tgl1MouseClicked

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
            java.util.logging.Logger.getLogger(Laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Laporan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Label Label123;
    private java.awt.Label Label124;
    private java.awt.Label Label125;
    private java.awt.Label Label126;
    private java.awt.Label Label127;
    private java.awt.Label Label128;
    private java.awt.Label Label129;
    private java.awt.Label Label130;
    private java.awt.Label Label131;
    private java.awt.Label Label132;
    private java.awt.Label Label133;
    private java.awt.Label Label134;
    private javax.swing.JButton btn_tampil;
    private java.awt.Label data_agustus;
    private java.awt.Label data_april;
    private java.awt.Label data_desember;
    private java.awt.Label data_feb;
    private java.awt.Label data_januari;
    private java.awt.Label data_jul;
    private java.awt.Label data_jun;
    private java.awt.Label data_mar;
    private java.awt.Label data_mei;
    private java.awt.Label data_nov;
    private java.awt.Label data_oktober;
    private java.awt.Label data_sep;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar10;
    private javax.swing.JProgressBar jProgressBar11;
    private javax.swing.JProgressBar jProgressBar12;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JProgressBar jProgressBar3;
    private javax.swing.JProgressBar jProgressBar4;
    private javax.swing.JProgressBar jProgressBar5;
    private javax.swing.JProgressBar jProgressBar6;
    private javax.swing.JProgressBar jProgressBar7;
    private javax.swing.JProgressBar jProgressBar8;
    private javax.swing.JProgressBar jProgressBar9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private java.awt.Label label1;
    private java.awt.Label label10;
    private java.awt.Label label11;
    private java.awt.Label label12;
    private java.awt.Label label121;
    private java.awt.Label label13;
    private java.awt.Label label14;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label label6;
    private java.awt.Label label7;
    private java.awt.Label label8;
    private java.awt.Label label9;
    private java.awt.Label pendapatantahunlalu;
    private java.awt.Label pengeluaran;
    private java.awt.Label penjualan;
    private java.awt.Label totalpendapatan;
    private com.toedter.calendar.JDateChooser txt_tgl1;
    private com.toedter.calendar.JDateChooser txt_tgl2;
    // End of variables declaration//GEN-END:variables

  
}
