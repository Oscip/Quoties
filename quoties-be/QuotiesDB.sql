-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: db
-- Generation Time: May 27, 2025 at 07:06 AM
-- Server version: 9.1.0
-- PHP Version: 8.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `QuotiesDB`
--

-- --------------------------------------------------------

--
-- Table structure for table `quoties`
--

CREATE TABLE `quoties` (
  `id` bigint NOT NULL,
  `word` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `word_translated` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `definition` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `definition_translated` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `quote` varchar(255) NOT NULL,
  `quote_translated` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `quoties`
--

INSERT INTO `quoties` (`id`, `word`, `word_translated`, `definition`, `definition_translated`, `quote`, `quote_translated`) VALUES
(1, 'ashamed', NULL, 'To feel shame; to be ashamed.', NULL, 'Example quote about ashamed', NULL),
(2, 'scheme', NULL, 'A systematic plan of future action.', 'Beispiel für scheme', 'Example quote about scheme', NULL),
(3, 'squire', NULL, 'A shield-bearer or armor-bearer who attended a knight.', 'Beispiel für squire', 'Example quote about squire', NULL),
(4, 'dismantle', NULL, 'To divest, strip of dress or covering.', 'Beispiel für dismantle', 'Example quote about dismantle', NULL),
(5, 'poncho', NULL, 'A simple garment, made from a rectangle of cloth, with a slit in the middle for the head.', 'Beispiel für poncho', 'Example quote about poncho', NULL),
(6, 'posh', NULL, 'Fragments produced by an impact', 'Beispiel für posh', 'Example quote about posh', NULL),
(7, 'move', NULL, 'The act of moving; a movement.', 'Beispiel für move', 'Example quote about move', NULL),
(8, 'judge', NULL, 'A public official whose duty it is to administer the law, especially by presiding over trials and rendering judgments; a justice.', 'Beispiel für judge', 'Error fetching quote: api.quotable.io', NULL),
(9, 'squeeze', NULL, 'A close or tight fit.', 'Beispiel für squeeze', 'Error fetching quote: PKIX path building failed: sun.security.provider.certpath.SunCertPathBuilderException: unable to find valid certification path to requested target', NULL),
(10, 'abdomen', NULL, 'The fat surrounding the belly.', 'Beispiel für abdomen', 'Error fetching quote: PKIX path building failed: sun.security.provider.certpath.SunCertPathBuilderException: unable to find valid certification path to requested target', NULL),
(11, 'blah', NULL, 'Nonsense; drivel; idle, meaningless talk.', 'Beispiel für blah', '[]', NULL),
(12, 'armoire', NULL, 'A type of cupboard, cabinet, or wardrobe - originally used for storing weapons.', 'Beispiel für armoire', '[]', NULL),
(13, 'blame', NULL, 'Censure.', 'Beispiel für blame', '[]', NULL),
(14, 'backless', NULL, 'Having no back, said of things that typically have backs, such as chairs or dresses', 'Beispiel für backless', '{\"__info__\":{\"$search\":{\"queryString\":{\"query\":\"backless\",\"defaultPath\":\"content\"}}},\"count\":0,\"totalCount\":0,\"page\":1,\"totalPages\":0,\"results\":[]}', NULL),
(15, 'dreaded', NULL, 'To fear greatly.', 'Beispiel für dreaded', '{\"__info__\":{\"$search\":{\"queryString\":{\"query\":\"dreaded\",\"defaultPath\":\"content\"}}},\"count\":0,\"totalCount\":0,\"page\":1,\"totalPages\":0,\"results\":[]}', NULL),
(16, 'duke', NULL, 'The male ruler of a duchy (female equivalent: duchess).', 'Beispiel für duke', '{\"__info__\":{\"$search\":{\"queryString\":{\"query\":\"duke\",\"defaultPath\":\"content\"}}},\"count\":0,\"totalCount\":0,\"page\":1,\"totalPages\":0,\"results\":[]}', NULL),
(17, 'covenant', NULL, 'An agreement to do or not do a particular thing.', 'Beispiel für covenant', '\"The compact which exists between the North and the South is a covenant with death and an agreement with hell.\" — William Lloyd Garrison', NULL),
(18, 'durable', NULL, 'A durable thing, one useful over more than one period, especially a year.', 'langlebig', '\"With honesty of purpose, balance, a respect for tradition, courage, and, above all, a philosophy of life, any young person who embraces the historical profession will find it rich in rewards and durable in satisfaction.\" — Samuel E. Morison', NULL),
(19, 'trailing', 'angehängt', 'To follow behind (someone or something); to tail (someone or something).', '(jemandem oder etwas) zu folgen; (jemandem oder etwas) zu folgen.', '\"A jellyfish is little more than a pulsating bell, a tassel of trailing tentacles and a single digestive opening through which it both eats and excretes - as regrettable an example of economy of design as ever was.\" — Jeffrey Kluger', '„Eine Qualle ist kaum mehr als eine pulsierende Glocke, eine Quaste aus nachlaufenden Tentakeln und eine einzige Verdauungsöffnung, durch die sie sowohl frisst als auch ausscheidet - ein bedauerliches Beispiel für Designökonomie wie eh und je.\" — Jeffrey Kluger'),
(20, 'hemstitch', 'saumstich', 'An embroidery stitch in which parallel threads are drawn together in groups', 'Ein Stickstich, bei dem parallele Fäden gruppenweise zusammengezogen werden', '\"No quotes found\" — ', 'Keine Angebote gefunden'),
(21, 'overrule', 'Überstimmung', 'To rule over; to govern or determine by superior authority.', 'Zu herrschen; zu regieren oder durch überlegene Autorität zu bestimmen.', '\"No quotes found\" — ', 'Keine Angebote gefunden');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `quoties`
--
ALTER TABLE `quoties`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `quoties`
--
ALTER TABLE `quoties`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
