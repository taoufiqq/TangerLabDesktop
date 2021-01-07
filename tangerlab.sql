-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  jeu. 07 jan. 2021 à 20:57
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
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `employe`
--

INSERT INTO `employe` (`id`, `nom`, `prenom`, `age`, `service`, `date_entree_service`, `prix_unitaire`, `salaire`) VALUES
(9, 'Belcaid', 'Abderrahim', 24, 'Representant', '2019/01/10', 2000, 2900),
(14, 'SSSSSSSS', 'SSSSS', 12, 'Representant', '22222', 22, 2504.4),
(15, 'ZZZZ', 'ZZZZ22', 22, 'Representant', '222', 22, 2504.4),
(16, '2222', 'EEE', 22, 'Producteur', '111', 111, 555),
(17, '3333', '2222', 33, 'Vendeur', '4444', 555, 1611);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
