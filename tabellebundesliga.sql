-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 29. Jun 2023 um 20:07
-- Server-Version: 10.4.28-MariaDB
-- PHP-Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `bundesligatabelle`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `tabelle`
--

CREATE TABLE `tabelle` (
  `Verein` varchar(15) NOT NULL,
  `Spiele` int(11) NOT NULL,
  `Siege` int(15) NOT NULL,
  `Niederlagen` int(11) NOT NULL,
  `Unentschieden` int(15) NOT NULL,
  `Tore` int(15) NOT NULL,
  `Gegentore` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Daten für Tabelle `tabelle`
--

INSERT INTO `tabelle` (`Verein`, `Spiele`, `Siege`, `Niederlagen`, `Unentschieden`, `Tore`, `Gegentore`) VALUES
('Niederrad', 10, 8, 1, 2, 28, 12),
('SC Weiss-Blau', 9, 5, 4, 0, 20, 17);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
