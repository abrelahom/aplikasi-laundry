-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 21 Feb 2019 pada 05.47
-- Versi server: 10.1.34-MariaDB
-- Versi PHP: 7.2.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_laundry3`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_ambil`
--

CREATE TABLE `tbl_ambil` (
  `no_antrian` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `no_telp` varchar(13) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `j_pewangi` varchar(10) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `harga` int(11) NOT NULL,
  `tanggal` date NOT NULL,
  `total` int(11) NOT NULL,
  `bayar` int(11) NOT NULL,
  `kembali` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbl_ambil`
--

INSERT INTO `tbl_ambil` (`no_antrian`, `nama`, `no_telp`, `alamat`, `j_pewangi`, `jumlah`, `harga`, `tanggal`, `total`, `bayar`, `kembali`) VALUES
(3, 'mila', '087770432050', 'cicurug', 'Bubuk', 1, 13000, '2018-05-26', 13000, 20000, 7000),
(3, 'mila', '087770432050', 'cicurug', 'Bubuk', 1, 13000, '2018-05-26', 13000, 20000, 7000),
(7, 'Taufik', '0824080', 'gugunung', 'Pilih', 2, 10000, '2019-01-23', 10000, 50000, 40000),
(8, 'Epri', '08212323', 'Banjarsari', 'Cair', 30, 40000, '2019-01-23', 40000, 800000, 760000),
(9, 'Rahman', '083979', 'gugunung', 'Cair', 2, 23000, '2019-01-23', 23000, 100000, 77000),
(10, 'Dede', '9798798', 'guguung', 'Cair', 2, 25000, '2019-01-23', 25000, 50000, 25000),
(12, 'Arjuna', '809284098', 'Banjarsari', 'Bubuk', 3, 33000, '2019-01-24', 33000, 50000, 17000),
(14, 'Tebew', '083232', 'gugunung', 'Cair', 4, 45000, '2019-01-24', 45000, 50000, 5000),
(15, 'Gifin', '0875', 'cicurug', 'Bubuk', 4, 43000, '2019-01-25', 43000, 50000, 7000),
(16, 'a', '08568760963', 'ciawi', 'Bubuk', 45, 453000, '2019-01-25', 453000, 500000, 47000),
(17, 'b', '085811964025', 'cibarengkok', 'Cair', 23, 235000, '2019-01-25', 235000, 300000, 65000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_login`
--

CREATE TABLE `tbl_login` (
  `user` varchar(20) NOT NULL,
  `pass` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbl_login`
--

INSERT INTO `tbl_login` (`user`, `pass`) VALUES
('aniseu', '1234'),
('Taufik', 'rahman'),
('gifin', 'abre');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_pesan`
--

CREATE TABLE `tbl_pesan` (
  `no_antrian` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `no_telp` varchar(13) NOT NULL,
  `alamat` text NOT NULL,
  `j_pewangi` varchar(5) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `harga` int(11) NOT NULL,
  `tanggal` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbl_pesan`
--

INSERT INTO `tbl_pesan` (`no_antrian`, `nama`, `no_telp`, `alamat`, `j_pewangi`, `jumlah`, `harga`, `tanggal`) VALUES
(18, 'c', '67', 'a', 'Cair', 1, 15000, '2019-01-25');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tbl_pesan`
--
ALTER TABLE `tbl_pesan`
  ADD PRIMARY KEY (`no_antrian`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `tbl_pesan`
--
ALTER TABLE `tbl_pesan`
  MODIFY `no_antrian` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
