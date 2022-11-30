-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mer. 31 mars 2021 à 01:22
-- Version du serveur :  8.0.18
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `projet3a`
--

-- --------------------------------------------------------

--
-- Structure de la table `abonnement`
--

DROP TABLE IF EXISTS `abonnement`;
CREATE TABLE IF NOT EXISTS `abonnement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_promo` int(11) NOT NULL,
  `id_associe` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `type` varchar(50) NOT NULL,
  `price` int(11) NOT NULL,
  `rating` int(11) NOT NULL,
  `nRating` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `associe`
--

DROP TABLE IF EXISTS `associe`;
CREATE TABLE IF NOT EXISTS `associe` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `nom` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `prenom` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `longitude` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `latitude` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `contactTel` int(11) DEFAULT NULL,
  `contactMail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `nbreMaxClientParJour` int(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `associe`
--

INSERT INTO `associe` (`id`, `userId`, `nom`, `prenom`, `type`, `description`, `longitude`, `latitude`, `contactTel`, `contactMail`, `nbreMaxClientParJour`) VALUES
(8, 33, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `nom` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `prenom` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `dateDeNaissance` date DEFAULT NULL,
  `numeroTel` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`id`, `userId`, `nom`, `prenom`, `dateDeNaissance`, `numeroTel`) VALUES
(20, 32, 'sa', 'amine', '2021-03-01', 123456498);

-- --------------------------------------------------------

--
-- Structure de la table `commentaire`
--

DROP TABLE IF EXISTS `commentaire`;
CREATE TABLE IF NOT EXISTS `commentaire` (
  `idcommentaire` int(11) NOT NULL AUTO_INCREMENT,
  `clientid` int(20) NOT NULL,
  `contenucommentaire` varchar(250) NOT NULL,
  `datecommentaire` varchar(20) NOT NULL,
  PRIMARY KEY (`idcommentaire`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `commentaire`
--

INSERT INTO `commentaire` (`idcommentaire`, `clientid`, `contenucommentaire`, `datecommentaire`) VALUES
(1, 1, 'Bonjour', '05/09/2021'),
(2, 2, 'salut', '05/09/2021'),
(3, 1, 'incroyable coach', '08/03/2021'),
(4, 1, 'incroyable coach', '08/03/2021'),
(5, 1, 'top la seance', '08/03/2021'),
(6, 1, 'bonne continuation', '08/03/2021'),
(7, 20, 'bonne continuation', '08/03/2021'),
(8, 20, 'meilleurs coachs', '08/03/2021'),
(11, 20, 'aaaaaaaaaaaaaaaaaaa', '31/03/2021');

-- --------------------------------------------------------

--
-- Structure de la table `facturepaiement`
--

DROP TABLE IF EXISTS `facturepaiement`;
CREATE TABLE IF NOT EXISTS `facturepaiement` (
  `idf` int(11) NOT NULL AUTO_INCREMENT,
  `idRdv` int(11) NOT NULL,
  `clientid` int(11) NOT NULL,
  `montant` float NOT NULL,
  `datef` varchar(50) NOT NULL,
  `datefacture` date DEFAULT NULL,
  PRIMARY KEY (`idf`),
  KEY `idRdv` (`idRdv`),
  KEY `clientid` (`clientid`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `paiement`
--

DROP TABLE IF EXISTS `paiement`;
CREATE TABLE IF NOT EXISTS `paiement` (
  `idRdv` int(15) NOT NULL,
  `montant` float NOT NULL,
  `datep` date NOT NULL,
  PRIMARY KEY (`idRdv`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `promotion`
--

DROP TABLE IF EXISTS `promotion`;
CREATE TABLE IF NOT EXISTS `promotion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `value` int(11) NOT NULL,
  `date` date NOT NULL,
  `nDays` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `rdv`
--

DROP TABLE IF EXISTS `rdv`;
CREATE TABLE IF NOT EXISTS `rdv` (
  `idRdv` int(11) NOT NULL AUTO_INCREMENT,
  `clientid` int(15) NOT NULL,
  `associeid` int(15) NOT NULL,
  `date` varchar(35) NOT NULL,
  `etat` varchar(20) NOT NULL,
  `Typepaiement` varchar(20) NOT NULL,
  `dater` date NOT NULL,
  PRIMARY KEY (`idRdv`),
  KEY `clientid` (`clientid`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `rubrique`
--

DROP TABLE IF EXISTS `rubrique`;
CREATE TABLE IF NOT EXISTS `rubrique` (
  `associeid` int(20) NOT NULL,
  `titre` varchar(20) NOT NULL,
  `descriptionbreve` varchar(50) NOT NULL,
  `descriptiondetaille` varchar(250) NOT NULL,
  PRIMARY KEY (`associeid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `rubrique`
--

INSERT INTO `rubrique` (`associeid`, `titre`, `descriptionbreve`, `descriptiondetaille`) VALUES
(2, 'acuponcture', 'aiguilles', 'appaise les muscles'),
(1, 'massage', 'huile et creme', 'prendre soin de soi'),
(88, 'm;', 'bk', 'jbjl'),
(3, 'massage', 'spa', 'eau thermique et esthetisienne'),
(4, 'yoga', 'relax', 'relax'),
(5, 'meditation', 'isolation', 'visiter la nature'),
(6, 'yoga', 'sport', 'tres belle experiience'),
(111, 'hhh', 'ggg', 'ggg');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` enum('client','admin','associe') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `hashDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `hash` varchar(255) DEFAULT NULL,
  `forgetPasswordCode` int(11) DEFAULT NULL,
  `isValid` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`id`, `email`, `password`, `role`, `hashDate`, `hash`, `forgetPasswordCode`, `isValid`) VALUES
(16, '1', '$2a$12$o5kom/iexHal1X07KWNwveDlJjcu6ZBImdHY89IPGOUnRKG0rNYPC', 'admin', '2021-03-10 11:47:24', NULL, NULL, 0),
(33, 'test.test@test.test', '$2a$12$fF0nljRsTR8wr.EyBQQW8uBERrbIKWI7vIzLonDZIpcQLnK56unBm', 'associe', '2021-03-31 02:20:25', NULL, NULL, 0),
(32, 'amine.saidi@isticbc.org', '$2a$12$cicvtLteTgUoJtdWXaJdoeeHfrLCi6Tk6EztgJyDGxO.DG/oQjOLm', 'client', '2021-03-30 23:07:38', '$2a$12$UZ9BufZtmw.XP8DX/Ji.cua2Bv4lQWp71oMRyFmTwW9Yw7yD39Zmq', NULL, 0);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
