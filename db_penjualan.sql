-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 13 Bulan Mei 2019 pada 03.57
-- Versi server: 10.1.31-MariaDB
-- Versi PHP: 7.2.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_penjualan`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `log_harga_produk`
--

CREATE TABLE `log_harga_produk` (
  `log_id` int(11) NOT NULL,
  `kode_produk` varchar(6) DEFAULT NULL,
  `harga_lama` int(11) DEFAULT NULL,
  `harga_baru` int(11) DEFAULT NULL,
  `waktu_perubahan` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `log_harga_produk`
--

INSERT INTO `log_harga_produk` (`log_id`, `kode_produk`, `harga_lama`, `harga_baru`, `waktu_perubahan`) VALUES
(1, 'BR001', 12000000, 9000000, '2019-05-12 13:36:46'),
(2, 'BR003', 4000000, 2000000, '2019-05-12 13:40:27'),
(3, 'BR002', 8000000, 8000000, '2019-05-13 08:53:06'),
(4, 'BR002', 8000000, 1000000, '2019-05-13 08:54:10');

-- --------------------------------------------------------

--
-- Struktur dari tabel `produk`
--

CREATE TABLE `produk` (
  `kode_produk` varchar(6) NOT NULL,
  `nama_produk` varchar(20) DEFAULT NULL,
  `harga` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `produk`
--

INSERT INTO `produk` (`kode_produk`, `nama_produk`, `harga`) VALUES
('BR001', 'Sepatu Sultan', 9000000),
('BR002', 'Baju Sultan', 1000000),
('BR003', 'Gelas SUltan', 2000000);

--
-- Trigger `produk`
--
DELIMITER $$
CREATE TRIGGER `before_produk_update` BEFORE UPDATE ON `produk` FOR EACH ROW BEGIN
    INSERT INTO log_harga_produk
    set kode_produk = OLD.kode_produk,
    harga_baru=new.harga,
    harga_lama=old.harga,
    waktu_perubahan = NOW(); 
END
$$
DELIMITER ;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `log_harga_produk`
--
ALTER TABLE `log_harga_produk`
  ADD PRIMARY KEY (`log_id`);

--
-- Indeks untuk tabel `produk`
--
ALTER TABLE `produk`
  ADD PRIMARY KEY (`kode_produk`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `log_harga_produk`
--
ALTER TABLE `log_harga_produk`
  MODIFY `log_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
