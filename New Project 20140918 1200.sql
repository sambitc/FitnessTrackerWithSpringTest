-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.8


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema fitnesstracker2
--

CREATE DATABASE IF NOT EXISTS fitnesstracker2;
USE fitnesstracker2;

--
-- Definition of table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `authority_id` int(10) unsigned NOT NULL,
  `user_id_fk` int(10) unsigned NOT NULL,
  `role_id_fk` int(10) unsigned NOT NULL,
  PRIMARY KEY (`authority_id`),
  UNIQUE KEY `Index_1` (`authority_id`,`user_id_fk`) USING BTREE,
  KEY `FK_authorities_2` (`user_id_fk`),
  CONSTRAINT `FK_authorities_1` FOREIGN KEY (`user_id_fk`) REFERENCES `users` (`user_id`),
  CONSTRAINT `FK_authorities_2` FOREIGN KEY (`user_id_fk`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `authorities`
--

/*!40000 ALTER TABLE `authorities` DISABLE KEYS */;
INSERT INTO `authorities` (`authority_id`,`user_id_fk`,`role_id_fk`) VALUES 
 (1,1,1),
 (2,1,2),
 (3,2,3),
 (4,3,2);
/*!40000 ALTER TABLE `authorities` ENABLE KEYS */;


--
-- Definition of table `company`
--

DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `company_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `company`
--

/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` (`company_id`,`name`) VALUES 
 (1,'mind'),
 (2,'tcs'),
 (3,'mindtree');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;


--
-- Definition of table `exercise`
--

DROP TABLE IF EXISTS `exercise`;
CREATE TABLE `exercise` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activity` varchar(255) NOT NULL,
  `minutes` int(11) NOT NULL,
  `goal_GOAL_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7E6B65F8D41F62F5` (`goal_GOAL_ID`),
  CONSTRAINT `FK7E6B65F8D41F62F5` FOREIGN KEY (`goal_GOAL_ID`) REFERENCES `goals` (`GOAL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `exercise`
--

/*!40000 ALTER TABLE `exercise` DISABLE KEYS */;
/*!40000 ALTER TABLE `exercise` ENABLE KEYS */;


--
-- Definition of table `goal`
--

DROP TABLE IF EXISTS `goal`;
CREATE TABLE `goal` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `minutes` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `goal`
--

/*!40000 ALTER TABLE `goal` DISABLE KEYS */;
/*!40000 ALTER TABLE `goal` ENABLE KEYS */;


--
-- Definition of table `goals`
--

DROP TABLE IF EXISTS `goals`;
CREATE TABLE `goals` (
  `GOAL_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `MINUTES` int(11) DEFAULT NULL,
  PRIMARY KEY (`GOAL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `goals`
--

/*!40000 ALTER TABLE `goals` DISABLE KEYS */;
/*!40000 ALTER TABLE `goals` ENABLE KEYS */;


--
-- Definition of table `permissions`
--

DROP TABLE IF EXISTS `permissions`;
CREATE TABLE `permissions` (
  `permission_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `target` varchar(45) NOT NULL,
  `permission` varchar(45) NOT NULL,
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `permissions`
--

/*!40000 ALTER TABLE `permissions` DISABLE KEYS */;
INSERT INTO `permissions` (`permission_id`,`target`,`permission`) VALUES 
 (1,'com.pluralsight.model.Goal','createGoal');
/*!40000 ALTER TABLE `permissions` ENABLE KEYS */;


--
-- Definition of table `persistent_logins`
--

DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `persistent_logins`
--

/*!40000 ALTER TABLE `persistent_logins` DISABLE KEYS */;
/*!40000 ALTER TABLE `persistent_logins` ENABLE KEYS */;


--
-- Definition of table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role`
--

/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`role_id`,`role`) VALUES 
 (1,'ROLE_ADMIN'),
 (2,'ROLE_USER'),
 (3,'BAD_USER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;


--
-- Definition of table `user_company`
--

DROP TABLE IF EXISTS `user_company`;
CREATE TABLE `user_company` (
  `user_company_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id_fk` int(10) unsigned NOT NULL,
  `company_id_fk` int(10) unsigned NOT NULL,
  PRIMARY KEY (`user_company_id`),
  KEY `FK_user_company_1` (`user_id_fk`),
  KEY `FK_user_company_2` (`company_id_fk`),
  CONSTRAINT `FK_user_company_1` FOREIGN KEY (`user_id_fk`) REFERENCES `users` (`user_id`),
  CONSTRAINT `FK_user_company_2` FOREIGN KEY (`company_id_fk`) REFERENCES `company` (`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_company`
--

/*!40000 ALTER TABLE `user_company` DISABLE KEYS */;
INSERT INTO `user_company` (`user_company_id`,`user_id_fk`,`company_id_fk`) VALUES 
 (1,1,1),
 (2,2,2),
 (3,3,3);
/*!40000 ALTER TABLE `user_company` ENABLE KEYS */;


--
-- Definition of table `user_permissions`
--

DROP TABLE IF EXISTS `user_permissions`;
CREATE TABLE `user_permissions` (
  `user_permission_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id_fk` int(10) unsigned NOT NULL,
  `permission_id_fk` int(10) unsigned NOT NULL,
  PRIMARY KEY (`user_permission_id`),
  KEY `FK_user_permissions_1` (`user_id_fk`),
  KEY `FK_user_permissions_2` (`permission_id_fk`),
  CONSTRAINT `FK_user_permissions_1` FOREIGN KEY (`user_id_fk`) REFERENCES `users` (`user_id`),
  CONSTRAINT `FK_user_permissions_2` FOREIGN KEY (`permission_id_fk`) REFERENCES `permissions` (`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_permissions`
--

/*!40000 ALTER TABLE `user_permissions` DISABLE KEYS */;
INSERT INTO `user_permissions` (`user_permission_id`,`user_id_fk`,`permission_id_fk`) VALUES 
 (1,1,1);
/*!40000 ALTER TABLE `user_permissions` ENABLE KEYS */;


--
-- Definition of table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(45) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 PACK_KEYS=1;

--
-- Dumping data for table `users`
--

/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`username`,`password`,`enabled`,`user_id`) VALUES 
 ('prasady','6876f31c02ad2082dd2f7c3fb0b90b90',1,1),
 ('ronalil','6876f31c02ad2082dd2f7c3fb0b90b90',1,2),
 ('sambitc','6876f31c02ad2082dd2f7c3fb0b90b90',1,3);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
