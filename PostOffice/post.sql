-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Хост: localhost
-- Время создания: Май 31 2015 г., 22:41
-- Версия сервера: 5.6.19-0ubuntu0.14.04.1
-- Версия PHP: 5.5.9-1ubuntu4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `post`
--

-- --------------------------------------------------------

--
-- Структура таблицы `Adress`
--

CREATE TABLE IF NOT EXISTS `Adress` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `idTown` int(10) unsigned NOT NULL,
  `idStreet` int(10) unsigned NOT NULL,
  `house` int(10) unsigned NOT NULL,
  `flat` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idTown` (`idTown`,`idStreet`),
  KEY `idStreet` (`idStreet`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=49 ;

--
-- Дамп данных таблицы `Adress`
--

INSERT INTO `Adress` (`id`, `idTown`, `idStreet`, `house`, `flat`) VALUES
(34, 15, 50, 41, 123),
(37, 16, 53, 5, 190),
(43, 15, 60, 4, 20);

-- --------------------------------------------------------

--
-- Структура таблицы `Country`
--

CREATE TABLE IF NOT EXISTS `Country` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `countryName` varchar(20) NOT NULL,
  `sngParam` tinyint(1) NOT NULL DEFAULT '0',
  `idAdress` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idAdress` (`idAdress`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=57 ;

--
-- Дамп данных таблицы `Country`
--

INSERT INTO `Country` (`id`, `countryName`, `sngParam`, `idAdress`) VALUES
(41, 'Russia', 1, 34),
(56, 'Беларусь', 1, 34);

-- --------------------------------------------------------

--
-- Структура таблицы `FromWho`
--

CREATE TABLE IF NOT EXISTS `FromWho` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `lastName` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `surName` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=47 ;

--
-- Дамп данных таблицы `FromWho`
--

INSERT INTO `FromWho` (`id`, `lastName`, `name`, `surName`) VALUES
(1, 'Dosta', 'Dmitrii', 'Sergeevich'),
(32, 'Kulbey', 'Olga', 'Vyacheslavovna'),
(33, 'Rusakovich', 'Maksim', 'Igorevich'),
(34, 'Kuzmin', 'Vladislav', 'Evgenievich'),
(40, 'Rusakovich', 'Maksim', 'Igorevich'),
(41, 'asd', 'asd', 'sda'),
(42, 'asd', 'asd', 'sda'),
(43, 'asd', 'asd', 'sda'),
(44, 'Доста', 'Дмитрий', 'Сергеевич');

-- --------------------------------------------------------

--
-- Структура таблицы `Post`
--

CREATE TABLE IF NOT EXISTS `Post` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `idTo` int(10) unsigned NOT NULL,
  `idFrom` int(10) unsigned NOT NULL,
  `idCountry` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idTo` (`idTo`),
  KEY `idFrom` (`idFrom`),
  KEY `idCountry` (`idCountry`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=42 ;

--
-- Дамп данных таблицы `Post`
--

INSERT INTO `Post` (`id`, `name`, `idTo`, `idFrom`, `idCountry`) VALUES
(41, 'Конфеты', 1, 1, 56);

-- --------------------------------------------------------

--
-- Структура таблицы `Street`
--

CREATE TABLE IF NOT EXISTS `Street` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=68 ;

--
-- Дамп данных таблицы `Street`
--

INSERT INTO `Street` (`id`, `name`) VALUES
(49, 'Yakuba Kolasa'),
(50, 'Leninskaya'),
(51, 'Логойский тракт'),
(53, 'Lenina'),
(60, 'Lenina'),
(61, ''),
(62, 'asd'),
(63, 'asd'),
(64, 'asd'),
(65, 'Логойский тракт');

-- --------------------------------------------------------

--
-- Структура таблицы `ToWho`
--

CREATE TABLE IF NOT EXISTS `ToWho` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `lastName` varchar(20) CHARACTER SET utf8 NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 NOT NULL,
  `surName` varchar(20) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=44 ;

--
-- Дамп данных таблицы `ToWho`
--

INSERT INTO `ToWho` (`id`, `lastName`, `name`, `surName`) VALUES
(1, 'Rusakovich', 'Maksim', 'Igorevich'),
(32, 'Nikituk', 'Roman', 'Adolfovich'),
(33, 'Moroz', 'Arsenii', 'Aleksandrovich'),
(34, 'Rusakovich', 'Maksimm', 'Igorevich'),
(40, 'Dosta', 'Dmitrii', 'Sergeevich'),
(41, 'Русакович', 'Максим', 'Игоревич');

-- --------------------------------------------------------

--
-- Структура таблицы `Town`
--

CREATE TABLE IF NOT EXISTS `Town` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=18 ;

--
-- Дамп данных таблицы `Town`
--

INSERT INTO `Town` (`id`, `name`) VALUES
(12, 'Пинск'),
(13, 'Grodno'),
(14, 'Brest'),
(15, 'Moscow'),
(16, 'Saint-Petersburg'),
(17, 'Минск');

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `Adress`
--
ALTER TABLE `Adress`
  ADD CONSTRAINT `Adress_ibfk_1` FOREIGN KEY (`idTown`) REFERENCES `Town` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Adress_ibfk_2` FOREIGN KEY (`idStreet`) REFERENCES `Street` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ограничения внешнего ключа таблицы `Country`
--
ALTER TABLE `Country`
  ADD CONSTRAINT `Country_ibfk_1` FOREIGN KEY (`idAdress`) REFERENCES `Adress` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ограничения внешнего ключа таблицы `Post`
--
ALTER TABLE `Post`
  ADD CONSTRAINT `Post_ibfk_1` FOREIGN KEY (`idTo`) REFERENCES `ToWho` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Post_ibfk_2` FOREIGN KEY (`idFrom`) REFERENCES `FromWho` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Post_ibfk_3` FOREIGN KEY (`idCountry`) REFERENCES `Country` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
