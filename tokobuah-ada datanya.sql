-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 21, 2021 at 02:36 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.5.37

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tokobuah`
--

-- --------------------------------------------------------

--
-- Table structure for table `akun`
--

CREATE TABLE `akun` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `akun`
--

INSERT INTO `akun` (`username`, `password`) VALUES
('admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `detail_penjualan`
--

CREATE TABLE `detail_penjualan` (
  `id_penjualan` int(5) DEFAULT NULL,
  `kode_produk` int(5) DEFAULT NULL,
  `jml_item` int(10) DEFAULT NULL,
  `harga_item` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `detail_penjualan`
--

INSERT INTO `detail_penjualan` (`id_penjualan`, `kode_produk`, `jml_item`, `harga_item`) VALUES
(1260, 146, 3, 30000),
(1260, 147, 2, 25000),
(1260, 148, 5, 10000),
(1261, 146, 5, 30000),
(1261, 147, 2, 25000),
(1262, 147, 1, 25000),
(1262, 147, 4, 25000),
(1262, 146, 7, 30000);

--
-- Triggers `detail_penjualan`
--
DELIMITER $$
CREATE TRIGGER `stok_penjualan` AFTER INSERT ON `detail_penjualan` FOR EACH ROW BEGIN
 UPDATE produk SET stok=stok-NEW.jml_item
 WHERE kode_produk = NEW.kode_produk;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `detail_produk_masuk`
--

CREATE TABLE `detail_produk_masuk` (
  `id_masuk` int(5) DEFAULT NULL,
  `kode_produk` int(5) DEFAULT NULL,
  `jumlah_stok_masuk` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `detail_produk_masuk`
--

INSERT INTO `detail_produk_masuk` (`id_masuk`, `kode_produk`, `jumlah_stok_masuk`) VALUES
(1257, 146, 20),
(1258, 147, 30),
(1258, 148, 40),
(1259, 148, 5),
(1260, 148, 5);

--
-- Triggers `detail_produk_masuk`
--
DELIMITER $$
CREATE TRIGGER `produk_masuk` AFTER INSERT ON `detail_produk_masuk` FOR EACH ROW BEGIN
 UPDATE produk SET stok=stok+NEW.jumlah_stok_masuk
 WHERE kode_produk = NEW.kode_produk;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `penjualan`
--

CREATE TABLE `penjualan` (
  `id_penjualan` int(5) NOT NULL,
  `tanggal` date DEFAULT NULL,
  `jumlah_total` int(5) DEFAULT NULL,
  `harga_total` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `penjualan`
--

INSERT INTO `penjualan` (`id_penjualan`, `tanggal`, `jumlah_total`, `harga_total`) VALUES
(1260, '2021-12-19', 10, 190000),
(1261, '2021-12-19', 7, 200000),
(1262, '2021-12-21', 12, 335000),
(1263, '2021-12-21', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `produk`
--

CREATE TABLE `produk` (
  `kode_produk` int(5) NOT NULL,
  `nama_produk` varchar(50) NOT NULL,
  `harga` int(10) NOT NULL,
  `stok` int(5) DEFAULT NULL,
  `kategori` enum('Buah Lokal','Buah Import') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `produk`
--

INSERT INTO `produk` (`kode_produk`, `nama_produk`, `harga`, `stok`, `kategori`) VALUES
(146, 'Apel', 30000, 5, 'Buah Lokal'),
(147, 'Jeruk', 25000, 21, 'Buah Lokal'),
(148, 'Mangga', 10000, 42, 'Buah Lokal');

-- --------------------------------------------------------

--
-- Table structure for table `produk_keluar`
--

CREATE TABLE `produk_keluar` (
  `id_keluar` int(5) NOT NULL,
  `kode_produk` int(5) DEFAULT NULL,
  `keterangan` varchar(20) DEFAULT NULL,
  `stok_keluar` int(3) DEFAULT NULL,
  `tanggal` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `produk_keluar`
--

INSERT INTO `produk_keluar` (`id_keluar`, `kode_produk`, `keterangan`, `stok_keluar`, `tanggal`) VALUES
(470, 148, 'Buah Busuk', 3, '2021-12-19');

--
-- Triggers `produk_keluar`
--
DELIMITER $$
CREATE TRIGGER `produk_keluar` AFTER INSERT ON `produk_keluar` FOR EACH ROW BEGIN
 UPDATE produk SET stok=stok-NEW.stok_keluar
 WHERE kode_produk = NEW.kode_produk;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `produk_masuk`
--

CREATE TABLE `produk_masuk` (
  `id_masuk` int(5) NOT NULL,
  `jumlah_stok_total` int(3) NOT NULL,
  `tanggal` date DEFAULT NULL,
  `id_supplier` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `produk_masuk`
--

INSERT INTO `produk_masuk` (`id_masuk`, `jumlah_stok_total`, `tanggal`, `id_supplier`) VALUES
(1257, 20, '2021-12-19', 150),
(1258, 70, '2021-12-19', 151),
(1259, 5, '2021-12-21', 150),
(1260, 5, '2021-12-21', 151),
(1261, 0, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `id_supplier` int(5) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `alamat` varchar(50) DEFAULT NULL,
  `status` enum('Aktif','Tidak Aktif') DEFAULT NULL,
  `keterangan` varchar(30) DEFAULT NULL,
  `no_hp` char(12) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`id_supplier`, `nama`, `alamat`, `status`, `keterangan`, `no_hp`) VALUES
(150, 'Bapak Imam', 'Nganjuk', 'Aktif', 'Penjual Apel', '085735652322'),
(151, 'Bapak Izul', 'Nganjuk', 'Aktif', 'Penjual Jeruk', '098737849283'),
(152, 'Bapak Ipin', 'Kediri', 'Aktif', 'Penjual Mangga', '086271872831');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `akun`
--
ALTER TABLE `akun`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `detail_penjualan`
--
ALTER TABLE `detail_penjualan`
  ADD KEY `id_penjualan` (`id_penjualan`),
  ADD KEY `kode_produk` (`kode_produk`);

--
-- Indexes for table `detail_produk_masuk`
--
ALTER TABLE `detail_produk_masuk`
  ADD KEY `id_masuk` (`id_masuk`),
  ADD KEY `kode_produk` (`kode_produk`);

--
-- Indexes for table `penjualan`
--
ALTER TABLE `penjualan`
  ADD PRIMARY KEY (`id_penjualan`);

--
-- Indexes for table `produk`
--
ALTER TABLE `produk`
  ADD PRIMARY KEY (`kode_produk`);

--
-- Indexes for table `produk_keluar`
--
ALTER TABLE `produk_keluar`
  ADD PRIMARY KEY (`id_keluar`),
  ADD KEY `kode_produk` (`kode_produk`);

--
-- Indexes for table `produk_masuk`
--
ALTER TABLE `produk_masuk`
  ADD PRIMARY KEY (`id_masuk`),
  ADD KEY `id_supplier` (`id_supplier`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`id_supplier`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `penjualan`
--
ALTER TABLE `penjualan`
  MODIFY `id_penjualan` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1264;
--
-- AUTO_INCREMENT for table `produk`
--
ALTER TABLE `produk`
  MODIFY `kode_produk` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=149;
--
-- AUTO_INCREMENT for table `produk_keluar`
--
ALTER TABLE `produk_keluar`
  MODIFY `id_keluar` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=471;
--
-- AUTO_INCREMENT for table `produk_masuk`
--
ALTER TABLE `produk_masuk`
  MODIFY `id_masuk` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1262;
--
-- AUTO_INCREMENT for table `supplier`
--
ALTER TABLE `supplier`
  MODIFY `id_supplier` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=153;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `detail_penjualan`
--
ALTER TABLE `detail_penjualan`
  ADD CONSTRAINT `detail_penjualan_ibfk_1` FOREIGN KEY (`id_penjualan`) REFERENCES `penjualan` (`id_penjualan`),
  ADD CONSTRAINT `detail_penjualan_ibfk_2` FOREIGN KEY (`kode_produk`) REFERENCES `produk` (`kode_produk`);

--
-- Constraints for table `detail_produk_masuk`
--
ALTER TABLE `detail_produk_masuk`
  ADD CONSTRAINT `detail_produk_masuk_ibfk_1` FOREIGN KEY (`id_masuk`) REFERENCES `produk_masuk` (`id_masuk`),
  ADD CONSTRAINT `detail_produk_masuk_ibfk_2` FOREIGN KEY (`kode_produk`) REFERENCES `produk` (`kode_produk`);

--
-- Constraints for table `produk_keluar`
--
ALTER TABLE `produk_keluar`
  ADD CONSTRAINT `produk_keluar_ibfk_1` FOREIGN KEY (`kode_produk`) REFERENCES `produk` (`kode_produk`);

--
-- Constraints for table `produk_masuk`
--
ALTER TABLE `produk_masuk`
  ADD CONSTRAINT `produk_masuk_ibfk_2` FOREIGN KEY (`id_supplier`) REFERENCES `supplier` (`id_supplier`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
