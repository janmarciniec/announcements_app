-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 01 Lut 2022, 15:34
-- Wersja serwera: 10.4.13-MariaDB
-- Wersja PHP: 7.3.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `projekt_pai`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `announcements`
--

CREATE TABLE `announcements` (
  `announcementid` int(4) NOT NULL,
  `title` varchar(256) NOT NULL,
  `description` varchar(256) NOT NULL,
  `price` int(11) NOT NULL,
  `location` varchar(100) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `userid` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `announcements`
--

INSERT INTO `announcements` (`announcementid`, `title`, `description`, `price`, `location`, `phone`, `userid`) VALUES
(24, 'Szafa Brimnes 3 drzwi', 'Sprzedam trzydrzwiową szafę IKEA Brimnes w kolorze białym. Wymiary 117 x 50 x 190 cm. Używana, lecz w bardzo dobrym stanie. Ma jedynie kilka drobnych rys, wynikających z użytkowania.', 400, 'Warszawa', '517556327', 23),
(25, 'Konsola PS5', 'Sprzedam konsolę Play Station 5. Jest to nietrafiony prezent, zatem jest zupełnie nowa i zapakowana fabrycznie. W zestawie pad. Cena nie podlega negocjacji.', 2800, 'Warszawa', '517556327', 23);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(35);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `users`
--

CREATE TABLE `users` (
  `userId` int(4) NOT NULL,
  `name` varchar(20) NOT NULL,
  `surname` varchar(30) NOT NULL,
  `login` varchar(30) NOT NULL,
  `password` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `users`
--

INSERT INTO `users` (`userId`, `name`, `surname`, `login`, `password`) VALUES
(23, 'Ania', 'Annowska', 'ania', '$2a$10$jRqQdLPG8fW7IOiYgOfgUOWczl40MsW.AjqW87xcp9X/UsM0CN9Za');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `announcements`
--
ALTER TABLE `announcements`
  ADD PRIMARY KEY (`announcementid`);

--
-- Indeksy dla tabeli `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`userId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `announcements`
--
ALTER TABLE `announcements`
  MODIFY `announcementid` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT dla tabeli `users`
--
ALTER TABLE `users`
  MODIFY `userId` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
