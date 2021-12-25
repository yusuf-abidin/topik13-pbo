-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 25 Des 2021 pada 15.04
-- Versi server: 10.4.20-MariaDB
-- Versi PHP: 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `makanan_favorit_pbo`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `makanan`
--

CREATE TABLE `makanan` (
  `id` int(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `jenis` varchar(10) NOT NULL,
  `rating` int(1) NOT NULL,
  `jumlah_kalori` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `makanan`
--

INSERT INTO `makanan` (`id`, `nama`, `jenis`, `rating`, `jumlah_kalori`) VALUES
(1, 'Bakso Wonogiri', 'Makanan', 3, 200),
(3, 'Nila Bakar', 'Makanan', 3, 2000),
(5, 'Cilok Goreng', 'Cemilan', 3, 200),
(7, 'Ayam Panggang', 'Cemilan', 1, 222),
(8, 'Nasi Pecel', 'Makanan', 3, 223),
(9, 'Klepon', 'Cemilan', 3, 100),
(10, 'Sosis Bakar', 'Cemilan', 2, 100),
(11, 'Kebab', 'Cemilan', 2, 200),
(12, 'Mie lidi', 'Cemilan', 3, 100),
(13, 'bakso goreng asin', 'Makanan', 3, 200);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `makanan`
--
ALTER TABLE `makanan`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `makanan`
--
ALTER TABLE `makanan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
