-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  ven. 08 jan. 2021 à 11:15
-- Version du serveur :  10.4.10-MariaDB
-- Version de PHP :  7.4.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `tangerlab`
--

-- --------------------------------------------------------

--
-- Structure de la table `employe`
--

DROP TABLE IF EXISTS `employe`;
CREATE TABLE IF NOT EXISTS `employe` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `age` int(11) NOT NULL,
  `service` varchar(255) NOT NULL,
  `date_entree_service` varchar(255) NOT NULL,
  `prix_unitaire` int(11) NOT NULL,
  `salaire` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `employe`
--

INSERT INTO `employe` (`id`, `nom`, `prenom`, `age`, `service`, `date_entree_service`, `prix_unitaire`, `salaire`) VALUES
(20, 'CHERKAOUI', 'Yassine', 22, 'Vendeur', '20/11/2018', 1200, 1740),
(21, 'ELAIDI', 'Abdelah', 25, 'Producteur', '10/10/2018', 200, 1000),
(22, 'ABOULFATEH', 'Zakaria', 25, 'ProducteurARisque', '20/04/2019', 160, 1000),
(18, 'EL HANCHAOUI', 'Taoufiq', 25, 'Producteur', '08/01/2019', 200, 1000),
(19, 'OUBOHIA', 'Mohammed', 26, 'Representant', '08/05/2017', 2000, 2900),
(23, 'SAIDI', 'Hanane', 23, 'Representant', '10/02/2010', 3000, 3100),
(24, 'SABIRI', 'Hajar', 24, 'Manutentionnaire', '10/11/2020', 50, 2500),
(25, 'KARIMI', 'Hassan', 22, 'ManutentionnaireARisque', '20/02/2017', 45, 2450),
(26, 'ELMAHFODI', 'Ikram', 32, 'Vendeur', '02/03/2018', 2100, 1920);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
