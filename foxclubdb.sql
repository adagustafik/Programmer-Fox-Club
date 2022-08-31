-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: foxclub
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `action`
--

use heroku_31705f72b824a92;

DROP TABLE IF EXISTS `action`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `action` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `added` datetime(6) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `fox_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKope0cnhntbaiht7k5gmhbprcw` (`fox_id`),
  CONSTRAINT `FKope0cnhntbaiht7k5gmhbprcw` FOREIGN KEY (`fox_id`) REFERENCES `fox` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `action`
--

LOCK TABLES `action` WRITE;
/*!40000 ALTER TABLE `action` DISABLE KEYS */;
/*!40000 ALTER TABLE `action` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fox`
--

DROP TABLE IF EXISTS `fox`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fox` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `drink` varchar(255) DEFAULT NULL,
  `food` varchar(255) DEFAULT NULL,
  `name` varchar(16) NOT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_goskx1jrdm0cuhbs3wh58vi7k` (`name`),
  KEY `FK3wd6wcvnq4hjo5is9ov9h6ubb` (`user_id`),
  CONSTRAINT `FK3wd6wcvnq4hjo5is9ov9h6ubb` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fox`
--

LOCK TABLES `fox` WRITE;
/*!40000 ALTER TABLE `fox` DISABLE KEYS */;
INSERT INTO `fox` VALUES (1,'WATER','BREAD','Some',1);
/*!40000 ALTER TABLE `fox` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fox_tricks`
--

DROP TABLE IF EXISTS `fox_tricks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fox_tricks` (
  `fox_id` bigint NOT NULL,
  `tricks` varchar(255) DEFAULT NULL,
  KEY `FKe7fi904xibkfjwymmsq8frl66` (`fox_id`),
  CONSTRAINT `FKe7fi904xibkfjwymmsq8frl66` FOREIGN KEY (`fox_id`) REFERENCES `fox` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fox_tricks`
--

LOCK TABLES `fox_tricks` WRITE;
/*!40000 ALTER TABLE `fox_tricks` DISABLE KEYS */;
/*!40000 ALTER TABLE `fox_tricks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `enabled` bit(1) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,_binary '','$2a$10$2kmgWxJC6.V5zXqZKIxLX.desBUY39/razlRPNYYhZNeRwSqOQPh6','ada');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-09 13:27:55
