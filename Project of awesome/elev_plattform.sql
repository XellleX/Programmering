-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Värd: localhost
-- Skapad: 09 jun 2014 kl 13:47
-- Serverversion: 5.5.16
-- PHP-version: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Databas: `elev_plattform`
--

-- --------------------------------------------------------

--
-- Tabellstruktur `comments`
--

CREATE TABLE IF NOT EXISTS `comments` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `comment_text` text CHARACTER SET utf8mb4 NOT NULL,
  `date` datetime NOT NULL,
  `user_id` int(11) NOT NULL,
  `summary_id` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `user_id` (`user_id`),
  KEY `summary_id` (`summary_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumpning av Data i tabell `comments`
--

INSERT INTO `comments` (`ID`, `comment_text`, `date`, `user_id`, `summary_id`) VALUES
(1, 'Yes we can!', '2014-06-07 10:07:18', 6, 28),
(2, 'Text!', '2014-06-07 10:18:36', 5, 32),
(3, 'provar runt lite :)', '2014-06-08 19:33:19', 2, 32),
(5, 'VARFÖR HAR INGEN KOMMENTERAT PÅ MIN SAMMANFATTNING!??!? D: Jag har inga vänner... :&#39;( ', '2014-06-08 19:46:09', 3, 31);

-- --------------------------------------------------------

--
-- Tabellstruktur `courses`
--

CREATE TABLE IF NOT EXISTS `courses` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8mb4 NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Dumpning av Data i tabell `courses`
--

INSERT INTO `courses` (`ID`, `name`) VALUES
(1, 'Matematik 3c'),
(2, 'Fysik 1'),
(3, 'Engelska 6'),
(4, 'Idrott och hälsa 1'),
(5, 'Matematik 1c'),
(6, 'Matematik 2c'),
(7, 'Engelska 7'),
(8, 'Fysik 2'),
(9, 'Gränssnitt 1'),
(10, 'Teknik 1'),
(11, 'Svenska 2'),
(12, 'Webutveckling 1');

-- --------------------------------------------------------

--
-- Tabellstruktur `summary`
--

CREATE TABLE IF NOT EXISTS `summary` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(64) CHARACTER SET utf8mb4 NOT NULL,
  `content` text CHARACTER SET utf8mb4 NOT NULL,
  `date` datetime NOT NULL,
  `course_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `subject_id` (`course_id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=35 ;

--
-- Dumpning av Data i tabell `summary`
--

INSERT INTO `summary` (`ID`, `title`, `content`, `date`, `course_id`, `user_id`) VALUES
(1, 'asd', 'asd', '2014-04-30 12:48:12', 3, 3),
(2, 'a', 's', '2014-04-30 12:50:40', 3, 3),
(3, 'Hej', 'Testing it out!', '2014-04-30 13:02:17', 10, 2),
(6, 'Kom igen!', 'Det här ska ni veta :)', '2014-04-30 13:07:02', 3, 2),
(7, 'hgg', 'AA', '2014-04-30 14:05:50', 3, 3),
(9, 'hgg', 'AA', '2014-04-30 14:06:28', 3, 3),
(10, 'Jag', 'har', '2014-04-30 14:09:26', 10, 2),
(11, 'Jag', 'har', '2014-04-30 14:09:30', 10, 2),
(12, 'fff', 'fff', '2014-04-30 14:19:36', 9, 3),
(13, 'fff', 'fff', '2014-04-30 14:19:39', 9, 3),
(14, 'mm', 'MMMMMARBOU', '2014-04-30 14:24:32', 7, 2),
(15, 'a', 'a', '2014-04-30 14:26:36', 7, 3),
(16, 't', 't', '2014-04-30 14:34:09', 3, 2),
(17, 'Ja', 'Nej', '2014-05-06 12:10:09', 7, 2),
(18, 'Gravitation', 'g = 9,82', '2014-05-06 12:16:10', 2, 3),
(19, 'jska hdkjash dkjhsakjhdaksj hdkjash dkjhsa dkjhas kjdaskjhd kjas', 'Test', '2014-05-07 13:31:11', 7, 2),
(20, ' adkfjh sdakjhf kjdsahfkj ahsdkjf hjkasdh fkjhdsak hfkjdsah fjda', 'Nej', '2014-05-07 13:32:32', 2, 3),
(21, 'Nu ska det funka bra :D', 'YAY/:(', '2014-05-07 14:00:55', 9, 4),
(22, 'sdadfdgfhgf hjgfghfhj                                   k', 'aj :&#39;(', '2014-05-13 13:52:01', 2, 3),
(23, 'dfgh hjggg hgg hg hg gh hg  jjgh   fdf fd fdf df  r rr r t y', 'Fail!', '2014-05-13 13:52:34', 3, 3),
(24, 'HEJ GUBBS', 'HEJ', '2014-05-13 13:58:51', 12, 4),
(25, 'FEL', 'Rätt!', '2014-05-20 12:41:52', 10, 6),
(26, 'Paddling', 'När ni paddlar så ska man alltid ha kakor med sig!\r\n\r\nProv på detta imorn :)', '2014-05-27 12:21:00', 4, 6),
(27, 'Funkar detta', 'Test!\r\n\r\nTest!', '2014-05-27 12:53:28', 7, 2),
(28, 'Trigonometri', 'Det kan vara bra att veta att sin=motstånede katet/hypotenusan och cos=närliggande katet/hypotenusan och tan=motstående katet/närliggande katet. \r\n\r\nLycka till på provet allihopa! :D', '2014-05-27 16:32:26', 1, 3),
(29, 'Test', 'SHIT VA MÅNGA TESTS DET SKULLE VA DÅ', '2014-05-27 18:49:07', 9, 5),
(30, 'Svåra tider...', 'Man ska nu kunna vad acceleration är för något :S', '2014-06-04 12:44:58', 8, 4),
(31, 'Test e kul!', 'HIHIHI\r\n\r\nHej', '2014-06-06 19:00:13', 9, 3),
(32, 'PLZZ', 'Hoppas detta funkar...\r\n\r\nOm detta e på en ny rad funkade det :D', '2014-06-06 19:01:20', 11, 6),
(33, 'mm', 'def', '2014-06-09 10:49:25', 8, 4),
(34, 'Jaha...', 'Hej!\r\n', '2014-06-09 11:45:09', 5, 7);

-- --------------------------------------------------------

--
-- Tabellstruktur `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(32) CHARACTER SET utf8mb4 NOT NULL,
  `lastname` varchar(32) CHARACTER SET utf8mb4 NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumpning av Data i tabell `users`
--

INSERT INTO `users` (`ID`, `firstname`, `lastname`) VALUES
(2, 'Elias', 'Axelsson'),
(3, 'Anton', 'Pettersson'),
(4, 'Erik', 'Källberg'),
(5, 'Johanna', 'Rasmussen'),
(6, 'fel', 'fel'),
(7, 'edvin', 'Johansson');

--
-- Restriktioner för dumpade tabeller
--

--
-- Restriktioner för tabell `comments`
--
ALTER TABLE `comments`
  ADD CONSTRAINT `comments_ibfk_3` FOREIGN KEY (`user_id`) REFERENCES `users` (`ID`),
  ADD CONSTRAINT `comments_ibfk_4` FOREIGN KEY (`summary_id`) REFERENCES `summary` (`ID`);

--
-- Restriktioner för tabell `summary`
--
ALTER TABLE `summary`
  ADD CONSTRAINT `summary_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `courses` (`ID`),
  ADD CONSTRAINT `summary_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
