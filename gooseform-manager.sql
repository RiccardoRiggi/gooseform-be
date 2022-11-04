-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Nov 04, 2022 alle 06:36
-- Versione del server: 10.4.20-MariaDB
-- Versione PHP: 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gooseform-manager`
--
CREATE DATABASE IF NOT EXISTS `gooseform-manager` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `gooseform-manager`;

-- --------------------------------------------------------

--
-- Struttura della tabella `goose_button`
--

CREATE TABLE `goose_button` (
  `formId` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL COMMENT 'RESET/SEND',
  `title` varchar(255) NOT NULL,
  `icon` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `goose_component`
--

CREATE TABLE `goose_component` (
  `formId` varchar(255) NOT NULL,
  `id` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `label` varchar(255) NOT NULL,
  `widthXl` varchar(10) NOT NULL,
  `widthLg` varchar(10) NOT NULL,
  `widthMd` varchar(10) NOT NULL,
  `widthSm` varchar(10) NOT NULL,
  `width` varchar(10) NOT NULL,
  `requiredMark` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `goose_component_specific`
--

CREATE TABLE `goose_component_specific` (
  `formId` varchar(255) NOT NULL,
  `id` varchar(255) NOT NULL,
  `nomeAttributo` varchar(255) NOT NULL,
  `valoreAttributo` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `goose_control`
--

CREATE TABLE `goose_control` (
  `pk` int(10) NOT NULL,
  `formId` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `typeSpecific` varchar(255) NOT NULL,
  `idComponentA` varchar(255) NOT NULL,
  `idComponentB` varchar(255) NOT NULL,
  `idComponentC` varchar(255) DEFAULT NULL,
  `referenceValue` varchar(512) DEFAULT NULL,
  `errorMessage` varchar(512) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `goose_form`
--

CREATE TABLE `goose_form` (
  `formId` varchar(255) NOT NULL,
  `title` varchar(512) NOT NULL,
  `icon` varchar(255) NOT NULL,
  `description` varchar(1024) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `goose_http_request`
--

CREATE TABLE `goose_http_request` (
  `pk` int(10) NOT NULL,
  `formId` varchar(255) NOT NULL,
  `componentId` varchar(255) NOT NULL,
  `url` varchar(512) NOT NULL,
  `method` varchar(25) NOT NULL,
  `body` varchar(1024) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `goose_kv_component`
--

CREATE TABLE `goose_kv_component` (
  `id` varchar(255) NOT NULL,
  `k` varchar(255) NOT NULL,
  `v` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `goose_kv_http_request`
--

CREATE TABLE `goose_kv_http_request` (
  `pk` int(10) NOT NULL,
  `k` varchar(255) NOT NULL,
  `v` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `goose_k_control`
--

CREATE TABLE `goose_k_control` (
  `pk` int(10) NOT NULL,
  `k` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `goose_popup`
--

CREATE TABLE `goose_popup` (
  `formId` varchar(255) NOT NULL,
  `componentId` varchar(255) NOT NULL,
  `icon` varchar(255) NOT NULL,
  `textTooltip` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  `description` varchar(512) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `goose_render`
--

CREATE TABLE `goose_render` (
  `formId` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `typeSpecific` varchar(255) NOT NULL,
  `idComponentA` varchar(255) NOT NULL,
  `idComponentB` varchar(255) NOT NULL,
  `idComponentC` varchar(255) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `goose_button`
--
ALTER TABLE `goose_button`
  ADD PRIMARY KEY (`formId`,`type`);

--
-- Indici per le tabelle `goose_component`
--
ALTER TABLE `goose_component`
  ADD PRIMARY KEY (`formId`,`id`);

--
-- Indici per le tabelle `goose_component_specific`
--
ALTER TABLE `goose_component_specific`
  ADD PRIMARY KEY (`formId`,`id`,`nomeAttributo`);

--
-- Indici per le tabelle `goose_control`
--
ALTER TABLE `goose_control`
  ADD PRIMARY KEY (`pk`);

--
-- Indici per le tabelle `goose_form`
--
ALTER TABLE `goose_form`
  ADD PRIMARY KEY (`formId`);

--
-- Indici per le tabelle `goose_http_request`
--
ALTER TABLE `goose_http_request`
  ADD PRIMARY KEY (`pk`);

--
-- Indici per le tabelle `goose_popup`
--
ALTER TABLE `goose_popup`
  ADD PRIMARY KEY (`formId`,`componentId`);

--
-- Indici per le tabelle `goose_render`
--
ALTER TABLE `goose_render`
  ADD PRIMARY KEY (`formId`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `goose_control`
--
ALTER TABLE `goose_control`
  MODIFY `pk` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `goose_http_request`
--
ALTER TABLE `goose_http_request`
  MODIFY `pk` int(10) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
