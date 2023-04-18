CREATE DATABASE  IF NOT EXISTS `gamesstorebd` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `gamesstorebd`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: gamesstorebd
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Temporary view structure for view `allgames`
--

DROP TABLE IF EXISTS `allgames`;
/*!50001 DROP VIEW IF EXISTS `allgames`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `allgames` AS SELECT 
 1 AS `tituloGame`,
 1 AS `tamanhoGame`,
 1 AS `precoGame`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `aventuragames`
--

DROP TABLE IF EXISTS `aventuragames`;
/*!50001 DROP VIEW IF EXISTS `aventuragames`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `aventuragames` AS SELECT 
 1 AS `tituloGame`,
 1 AS `tamanhoGame`,
 1 AS `precoGame`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `desenvolvedora`
--

DROP TABLE IF EXISTS `desenvolvedora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `desenvolvedora` (
  `idDesenvolvedora` int NOT NULL AUTO_INCREMENT,
  `nomeDesenvolvedora` varchar(40) NOT NULL,
  PRIMARY KEY (`idDesenvolvedora`),
  UNIQUE KEY `nomeDesenvolvedora_UNIQUE` (`nomeDesenvolvedora`),
  KEY `idx_nomeDesenvolvedora` (`nomeDesenvolvedora`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `desenvolvedora`
--

LOCK TABLES `desenvolvedora` WRITE;
/*!40000 ALTER TABLE `desenvolvedora` DISABLE KEYS */;
INSERT INTO `desenvolvedora` VALUES (3,'CD Projekt RED'),(4,'Dice'),(5,'Mojang'),(6,'Remedy'),(1,'Rockstar'),(2,'Ubisoft');
/*!40000 ALTER TABLE `desenvolvedora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `endereco` (
  `idEndereco` int NOT NULL AUTO_INCREMENT,
  `ruaEndereco` varchar(60) NOT NULL,
  `numeroEndereco` int NOT NULL,
  `cepEndereco` int NOT NULL,
  PRIMARY KEY (`idEndereco`),
  KEY `idx_ruaEndereco` (`ruaEndereco`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endereco`
--

LOCK TABLES `endereco` WRITE;
/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
INSERT INTO `endereco` VALUES (2,'Rua n1',123,88333777),(3,'Rua n2',73,58339777),(4,'Rua n3',4153,46733700),(5,'Rua n4',24,47002159),(6,'Avenida n1',658,88333777);
/*!40000 ALTER TABLE `endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `fpsgames`
--

DROP TABLE IF EXISTS `fpsgames`;
/*!50001 DROP VIEW IF EXISTS `fpsgames`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `fpsgames` AS SELECT 
 1 AS `tituloGame`,
 1 AS `tamanhoGame`,
 1 AS `precoGame`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `game`
--

DROP TABLE IF EXISTS `game`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `game` (
  `idGame` int NOT NULL AUTO_INCREMENT,
  `tituloGame` varchar(40) NOT NULL,
  `generoGame` varchar(40) DEFAULT NULL,
  `tamanhoGame` decimal(6,2) NOT NULL,
  `precoGame` decimal(6,2) NOT NULL,
  `Desenvolvedora_idDesenvolvedora` int NOT NULL,
  PRIMARY KEY (`idGame`,`Desenvolvedora_idDesenvolvedora`),
  UNIQUE KEY `tituloGame_UNIQUE` (`tituloGame`),
  KEY `fk_Game_Desenvolvedora1_idx` (`Desenvolvedora_idDesenvolvedora`),
  KEY `idx_tituloGame` (`tituloGame`),
  CONSTRAINT `fk_Game_Desenvolvedora1` FOREIGN KEY (`Desenvolvedora_idDesenvolvedora`) REFERENCES `desenvolvedora` (`idDesenvolvedora`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game`
--

LOCK TABLES `game` WRITE;
/*!40000 ALTER TABLE `game` DISABLE KEYS */;
INSERT INTO `game` VALUES (1,'The Witcher 3','RPG',54.24,50.00,3),(2,'Cyberpunk 2077','RPG',72.08,200.00,3),(3,'Battlefield 4','FPS',32.60,199.99,4),(4,'The Crew 2','Corrida',58.20,150.00,2),(5,'Grand Auto Theft V','Aventura',106.64,70.00,1);
/*!40000 ALTER TABLE `game` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `rpggames`
--

DROP TABLE IF EXISTS `rpggames`;
/*!50001 DROP VIEW IF EXISTS `rpggames`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `rpggames` AS SELECT 
 1 AS `tituloGame`,
 1 AS `tamanhoGame`,
 1 AS `precoGame`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `cpfUsuario` int NOT NULL,
  `nomeUsuario` varchar(40) NOT NULL,
  `sobrenomeUsuario` varchar(40) DEFAULT NULL,
  `loginUsuario` varchar(40) NOT NULL,
  `senhaUsuario` varchar(40) NOT NULL,
  `admUsuario` tinyint NOT NULL DEFAULT '0',
  `Endereco_idEndereco` int NOT NULL,
  PRIMARY KEY (`cpfUsuario`,`Endereco_idEndereco`),
  UNIQUE KEY `cpfUsuario_UNIQUE` (`cpfUsuario`),
  KEY `fk_Usuario_Endereco_idx` (`Endereco_idEndereco`),
  KEY `idx_nomeUsuario` (`nomeUsuario`),
  CONSTRAINT `fk_Usuario_Endereco` FOREIGN KEY (`Endereco_idEndereco`) REFERENCES `endereco` (`idEndereco`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Lucas Andre','Munhoz','LucasAdmApp','admin123',1,2),(152,'Willker','Santana','Dollysauro','1001001',0,4),(164,'Lucas','Munhoz','Luc4s_de','batata123',0,2),(258,'Gustavo','Martins','Finlin','flamengo',0,3),(478,'Danilson','Junior','jmatsushita07','070707',0,6),(987,'Joao Victor','dos Anjos','Jhonoaru','coxinha123',0,5);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_possui_game`
--

DROP TABLE IF EXISTS `usuario_possui_game`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario_possui_game` (
  `Usuario_cpfUsuario` int NOT NULL,
  `Usuario_Endereco_idEndereco` int NOT NULL,
  `Game_idGame` int NOT NULL,
  `Game_Desenvolvedora_idDesenvolvedora` int NOT NULL,
  `chaveAtivacaoGame` int DEFAULT NULL,
  PRIMARY KEY (`Usuario_cpfUsuario`,`Usuario_Endereco_idEndereco`,`Game_idGame`,`Game_Desenvolvedora_idDesenvolvedora`),
  KEY `fk_Usuario_has_Game_Game1_idx` (`Game_idGame`,`Game_Desenvolvedora_idDesenvolvedora`),
  KEY `fk_Usuario_has_Game_Usuario1_idx` (`Usuario_cpfUsuario`,`Usuario_Endereco_idEndereco`),
  CONSTRAINT `fk_Usuario_has_Game_Game1` FOREIGN KEY (`Game_idGame`, `Game_Desenvolvedora_idDesenvolvedora`) REFERENCES `game` (`idGame`, `Desenvolvedora_idDesenvolvedora`),
  CONSTRAINT `fk_Usuario_has_Game_Usuario1` FOREIGN KEY (`Usuario_cpfUsuario`, `Usuario_Endereco_idEndereco`) REFERENCES `usuario` (`cpfUsuario`, `Endereco_idEndereco`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_possui_game`
--

LOCK TABLES `usuario_possui_game` WRITE;
/*!40000 ALTER TABLE `usuario_possui_game` DISABLE KEYS */;
INSERT INTO `usuario_possui_game` VALUES (152,4,2,3,26548),(164,2,1,3,33674),(164,2,2,3,98215),(258,3,5,1,26487),(478,6,1,3,15985),(987,5,1,3,72967),(987,5,3,4,95780),(987,5,4,2,45882);
/*!40000 ALTER TABLE `usuario_possui_game` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'gamesstorebd'
--

--
-- Dumping routines for database 'gamesstorebd'
--

--
-- Final view structure for view `allgames`
--

/*!50001 DROP VIEW IF EXISTS `allgames`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `allgames` AS select `game`.`tituloGame` AS `tituloGame`,`game`.`tamanhoGame` AS `tamanhoGame`,`game`.`precoGame` AS `precoGame` from `game` order by `game`.`tituloGame` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `aventuragames`
--

/*!50001 DROP VIEW IF EXISTS `aventuragames`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `aventuragames` AS select `game`.`tituloGame` AS `tituloGame`,`game`.`tamanhoGame` AS `tamanhoGame`,`game`.`precoGame` AS `precoGame` from `game` where (`game`.`generoGame` = 'Aventura') order by `game`.`tituloGame` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `fpsgames`
--

/*!50001 DROP VIEW IF EXISTS `fpsgames`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `fpsgames` AS select `game`.`tituloGame` AS `tituloGame`,`game`.`tamanhoGame` AS `tamanhoGame`,`game`.`precoGame` AS `precoGame` from `game` where (`game`.`generoGame` = 'FPS') order by `game`.`tituloGame` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `rpggames`
--

/*!50001 DROP VIEW IF EXISTS `rpggames`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `rpggames` AS select `game`.`tituloGame` AS `tituloGame`,`game`.`tamanhoGame` AS `tamanhoGame`,`game`.`precoGame` AS `precoGame` from `game` where (`game`.`generoGame` = 'RPG') order by `game`.`tituloGame` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-06 12:50:49
