-- MySQL dump 10.13  Distrib 5.5.20, for solaris10 (i386)
--
-- Host: localhost    Database: project_db
-- ------------------------------------------------------
-- Server version   5.5.20-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Contact`
--

DROP TABLE IF EXISTS `Contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Contact` (
  `Contact_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Last_name` varchar(25) DEFAULT NULL,
  `First_name` varchar(25) DEFAULT NULL,
  `Email` varchar(30) NOT NULL,
  `Phone` varchar(12) DEFAULT NULL,
  `Password` varchar(45) DEFAULT NULL,
  `Role` int(11) NOT NULL,
  PRIMARY KEY (`Contact_ID`),
  UNIQUE KEY `email_UNIQUE` (`Email`),
  KEY `fk_Role` (`Role`),
  CONSTRAINT `fk_Contact` FOREIGN KEY (`Role`) REFERENCES `Role` (`Role_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Contact`
--

LOCK TABLES `Contact` WRITE;
/*!40000 ALTER TABLE `Contact` DISABLE KEYS */;
/*!40000 ALTER TABLE `Contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Game`
--

DROP TABLE IF EXISTS `Game`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Game` (
  `Game_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Date` date NOT NULL,
  `Time` time NOT NULL,
  `Home_team` int(11) NOT NULL,
  `Away_team` int(11) NOT NULL,
  `Location` int(11) DEFAULT NULL,
  `Home_score` int(10) unsigned zerofill DEFAULT NULL,
  `Away_score` int(10) unsigned zerofill DEFAULT NULL,
  PRIMARY KEY (`Game_ID`),
  KEY `fk_Game_1` (`Home_team`),
  KEY `fk_Game_2` (`Away_team`),
  KEY `fk_Game_3` (`Location`),
  CONSTRAINT `fk_Game_1` FOREIGN KEY (`Home_team`) REFERENCES `Team` (`Team_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Game_2` FOREIGN KEY (`Away_team`) REFERENCES `Team` (`Team_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Game_3` FOREIGN KEY (`Location`) REFERENCES `Location` (`Location_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Game`
--

LOCK TABLES `Game` WRITE;
/*!40000 ALTER TABLE `Game` DISABLE KEYS */;
/*!40000 ALTER TABLE `Game` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `League`
--

DROP TABLE IF EXISTS `League`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `League` (
  `League_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  `Year` year(4) NOT NULL,
  `Season` varchar(6) NOT NULL,
  `Admin` int(11) NOT NULL,
  PRIMARY KEY (`League_ID`),
  KEY `fk_League` (`Admin`),
  CONSTRAINT `fk_League` FOREIGN KEY (`Admin`) REFERENCES `Contact` (`Contact_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `League`
--

LOCK TABLES `League` WRITE;
/*!40000 ALTER TABLE `League` DISABLE KEYS */;
/*!40000 ALTER TABLE `League` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Location`
--

DROP TABLE IF EXISTS `Location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Location` (
  `Location_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Field_name` varchar(30) NOT NULL,
  `Street` varchar(30) NOT NULL,
  `City` varchar(30) NOT NULL,
  `Zip_code` varchar(10) NOT NULL,
  `Contact` int(11) NOT NULL,
  PRIMARY KEY (`Location_ID`),
  KEY `fk_Location_1` (`Contact`),
  CONSTRAINT `fk_Location_1` FOREIGN KEY (`Contact`) REFERENCES `Contact` (`Contact_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Location`
--

LOCK TABLES `Location` WRITE;
/*!40000 ALTER TABLE `Location` DISABLE KEYS */;
/*!40000 ALTER TABLE `Location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Player`
--

DROP TABLE IF EXISTS `Player`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Player` (
  `Player_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Age` int(11) DEFAULT NULL,
  `Position` varchar(10) DEFAULT NULL,
  `Contact` int(11) NOT NULL,
  `Team` int(11) NOT NULL,
  PRIMARY KEY (`Player_ID`),
  KEY `fk_Player_1` (`Contact`),
  KEY `fk_Player_2` (`Team`),
  CONSTRAINT `fk_Player_1` FOREIGN KEY (`Contact`) REFERENCES `Contact` (`Contact_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Player_2` FOREIGN KEY (`Team`) REFERENCES `Team` (`Team_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Player`
--

LOCK TABLES `Player` WRITE;
/*!40000 ALTER TABLE `Player` DISABLE KEYS */;
/*!40000 ALTER TABLE `Player` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Role`
--

DROP TABLE IF EXISTS `Role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Role` (
  `Role_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Type` varchar(25) NOT NULL,
  PRIMARY KEY (`Role_ID`),
  UNIQUE KEY `Type_UNIQUE` (`Type`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Role`
--

LOCK TABLES `Role` WRITE;
/*!40000 ALTER TABLE `Role` DISABLE KEYS */;
/*!40000 ALTER TABLE `Role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Team`
--

DROP TABLE IF EXISTS `Team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Team` (
  `Team_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  `League` int(11) NOT NULL,
  `Coach` int(11) NOT NULL,
  PRIMARY KEY (`Team_ID`),
  KEY `fk_Team_1` (`League`),
  KEY `fk_Team_2` (`Coach`),
  CONSTRAINT `fk_Team_1` FOREIGN KEY (`League`) REFERENCES `League` (`League_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Team_2` FOREIGN KEY (`Coach`) REFERENCES `Contact` (`Contact_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Team`
--

LOCK TABLES `Team` WRITE;
/*!40000 ALTER TABLE `Team` DISABLE KEYS */;
/*!40000 ALTER TABLE `Team` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-09-19 12:52:47
