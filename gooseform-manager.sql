-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Gen 03, 2023 alle 09:33
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
-- Struttura della tabella `goose_cache`
--

CREATE TABLE `goose_cache` (
  `formId` varchar(255) NOT NULL,
  `content` longtext NOT NULL
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
  `requiredMark` tinyint(1) NOT NULL,
  `ordination` int(10) NOT NULL DEFAULT 1
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
  `idComponentB` varchar(255) DEFAULT NULL,
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
  `componentId` varchar(255) DEFAULT NULL,
  `url` varchar(512) NOT NULL,
  `method` varchar(25) NOT NULL,
  `body` varchar(1024) NOT NULL,
  `typeSpecific` varchar(255) NOT NULL COMMENT 'SUBMIT-DATA'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `goose_kv_component`
--

CREATE TABLE `goose_kv_component` (
  `formId` varchar(255) NOT NULL,
  `componentId` varchar(255) NOT NULL,
  `k` varchar(255) NOT NULL,
  `v` varchar(255) NOT NULL,
  `ordination` int(10) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `goose_kv_http_request`
--

CREATE TABLE `goose_kv_http_request` (
  `pkHttp` int(10) NOT NULL,
  `k` varchar(255) NOT NULL,
  `v` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `goose_k_control`
--

CREATE TABLE `goose_k_control` (
  `pkControl` int(10) NOT NULL,
  `k` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `goose_popup`
--

CREATE TABLE `goose_popup` (
  `pk` int(10) NOT NULL,
  `formId` varchar(255) NOT NULL,
  `componentId` varchar(255) DEFAULT NULL,
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
  `pk` int(10) NOT NULL,
  `formId` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `typeSpecific` varchar(255) NOT NULL,
  `idComponentA` varchar(255) NOT NULL,
  `idComponentB` varchar(255) NOT NULL,
  `idComponentC` varchar(255) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `goose_tooltip`
--

CREATE TABLE `goose_tooltip` (
  `pk` int(10) NOT NULL,
  `formId` varchar(255) NOT NULL,
  `componentId` varchar(255) DEFAULT NULL,
  `icon` varchar(255) NOT NULL,
  `tooltip` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `t_component_specific`
--

CREATE TABLE `t_component_specific` (
  `type` varchar(255) NOT NULL,
  `k` varchar(255) NOT NULL,
  `v` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `t_control`
--

CREATE TABLE `t_control` (
  `type` varchar(255) NOT NULL,
  `k` varchar(255) NOT NULL,
  `description` varchar(1024) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `t_placeholder`
--

CREATE TABLE `t_placeholder` (
  `type` varchar(255) NOT NULL,
  `placeholder` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `t_render`
--

CREATE TABLE `t_render` (
  `type` varchar(255) NOT NULL,
  `k` varchar(255) NOT NULL,
  `description` varchar(1024) NOT NULL
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
-- Indici per le tabelle `goose_cache`
--
ALTER TABLE `goose_cache`
  ADD PRIMARY KEY (`formId`);

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
-- Indici per le tabelle `goose_kv_component`
--
ALTER TABLE `goose_kv_component`
  ADD PRIMARY KEY (`formId`,`componentId`,`k`);

--
-- Indici per le tabelle `goose_popup`
--
ALTER TABLE `goose_popup`
  ADD PRIMARY KEY (`pk`);

--
-- Indici per le tabelle `goose_render`
--
ALTER TABLE `goose_render`
  ADD PRIMARY KEY (`pk`);

--
-- Indici per le tabelle `goose_tooltip`
--
ALTER TABLE `goose_tooltip`
  ADD PRIMARY KEY (`pk`);

--
-- Indici per le tabelle `t_component_specific`
--
ALTER TABLE `t_component_specific`
  ADD PRIMARY KEY (`type`,`k`);

--
-- Indici per le tabelle `t_control`
--
ALTER TABLE `t_control`
  ADD PRIMARY KEY (`type`,`k`);

--
-- Indici per le tabelle `t_placeholder`
--
ALTER TABLE `t_placeholder`
  ADD PRIMARY KEY (`type`);

--
-- Indici per le tabelle `t_render`
--
ALTER TABLE `t_render`
  ADD PRIMARY KEY (`type`,`k`);

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

--
-- AUTO_INCREMENT per la tabella `goose_popup`
--
ALTER TABLE `goose_popup`
  MODIFY `pk` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `goose_render`
--
ALTER TABLE `goose_render`
  MODIFY `pk` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `goose_tooltip`
--
ALTER TABLE `goose_tooltip`
  MODIFY `pk` int(10) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
