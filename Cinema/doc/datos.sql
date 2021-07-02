CREATE DATABASE  IF NOT EXISTS `bd_cinema` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bd_cinema`;
-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: cine.mysql.database.azure.com    Database: bd_cinema
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `asiento_funcion`
--

DROP TABLE IF EXISTS `asiento_funcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asiento_funcion` (
  `fila` char(1) COLLATE utf8mb4_spanish_ci NOT NULL,
  `posicion` int NOT NULL,
  `funcion_id` int NOT NULL,
  `funcion_fecha` datetime NOT NULL,
  `funcion_sala_cinema_id` int NOT NULL,
  `funcion_sala_numero` int NOT NULL,
  `ocupado` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`fila`,`posicion`,`funcion_id`,`funcion_fecha`,`funcion_sala_cinema_id`,`funcion_sala_numero`),
  KEY `fk_asiento_funcion_funcion1_idx` (`funcion_id`,`funcion_fecha`,`funcion_sala_cinema_id`,`funcion_sala_numero`),
  CONSTRAINT `fk_asiento_funcion_funcion1` FOREIGN KEY (`funcion_id`, `funcion_fecha`, `funcion_sala_cinema_id`, `funcion_sala_numero`) REFERENCES `funcion` (`id_funcion`, `fecha`, `sala_cinema_id`, `sala_numero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asiento_funcion`
--

LOCK TABLES `asiento_funcion` WRITE;
/*!40000 ALTER TABLE `asiento_funcion` DISABLE KEYS */;
INSERT INTO `asiento_funcion` VALUES ('a',1,1,'2017-06-15 00:00:00',1,32,0),('a',1,2,'2021-06-13 00:00:00',1,20,0),('a',1,3,'2021-06-21 00:00:00',1,1,0),('a',1,9,'2021-06-30 12:30:00',1,1,1),('a',2,1,'2017-06-15 00:00:00',1,32,0),('a',2,2,'2021-06-13 00:00:00',1,20,0),('a',2,3,'2021-06-21 00:00:00',1,1,0),('a',2,9,'2021-06-30 12:30:00',1,1,0),('a',3,1,'2017-06-15 00:00:00',1,32,0),('a',3,2,'2021-06-13 00:00:00',1,20,0),('a',3,3,'2021-06-21 00:00:00',1,1,0),('a',3,9,'2021-06-30 12:30:00',1,1,0),('a',4,1,'2017-06-15 00:00:00',1,32,0),('a',4,2,'2021-06-13 00:00:00',1,20,0),('a',4,3,'2021-06-21 00:00:00',1,1,0),('a',4,9,'2021-06-30 12:30:00',1,1,0),('a',5,1,'2017-06-15 00:00:00',1,32,0),('a',5,2,'2021-06-13 00:00:00',1,20,0),('a',5,3,'2021-06-21 00:00:00',1,1,0),('a',5,9,'2021-06-30 12:30:00',1,1,0),('a',6,2,'2021-06-13 00:00:00',1,20,0),('a',6,3,'2021-06-21 00:00:00',1,1,0),('a',6,9,'2021-06-30 12:30:00',1,1,0),('a',7,2,'2021-06-13 00:00:00',1,20,0),('a',7,3,'2021-06-21 00:00:00',1,1,0),('a',7,9,'2021-06-30 12:30:00',1,1,0),('a',8,2,'2021-06-13 00:00:00',1,20,0),('a',8,3,'2021-06-21 00:00:00',1,1,0),('a',8,9,'2021-06-30 12:30:00',1,1,0),('a',9,2,'2021-06-13 00:00:00',1,20,0),('a',9,3,'2021-06-21 00:00:00',1,1,0),('a',9,9,'2021-06-30 12:30:00',1,1,0),('a',10,2,'2021-06-13 00:00:00',1,20,0),('a',10,3,'2021-06-21 00:00:00',1,1,0),('a',10,9,'2021-06-30 12:30:00',1,1,0),('b',1,1,'2017-06-15 00:00:00',1,32,0),('b',1,2,'2021-06-13 00:00:00',1,20,0),('b',1,3,'2021-06-21 00:00:00',1,1,0),('b',1,9,'2021-06-30 12:30:00',1,1,0),('b',2,1,'2017-06-15 00:00:00',1,32,0),('b',2,2,'2021-06-13 00:00:00',1,20,0),('b',2,3,'2021-06-21 00:00:00',1,1,0),('b',2,9,'2021-06-30 12:30:00',1,1,0),('b',3,1,'2017-06-15 00:00:00',1,32,0),('b',3,2,'2021-06-13 00:00:00',1,20,0),('b',3,3,'2021-06-21 00:00:00',1,1,0),('b',3,9,'2021-06-30 12:30:00',1,1,0),('b',4,1,'2017-06-15 00:00:00',1,32,0),('b',4,2,'2021-06-13 00:00:00',1,20,0),('b',4,3,'2021-06-21 00:00:00',1,1,0),('b',4,9,'2021-06-30 12:30:00',1,1,0),('b',5,1,'2017-06-15 00:00:00',1,32,0),('b',5,2,'2021-06-13 00:00:00',1,20,0),('b',5,3,'2021-06-21 00:00:00',1,1,0),('b',5,9,'2021-06-30 12:30:00',1,1,0),('b',6,2,'2021-06-13 00:00:00',1,20,0),('b',6,3,'2021-06-21 00:00:00',1,1,0),('b',6,9,'2021-06-30 12:30:00',1,1,0),('b',7,2,'2021-06-13 00:00:00',1,20,0),('b',7,3,'2021-06-21 00:00:00',1,1,0),('b',7,9,'2021-06-30 12:30:00',1,1,0),('b',8,2,'2021-06-13 00:00:00',1,20,0),('b',8,3,'2021-06-21 00:00:00',1,1,0),('b',8,9,'2021-06-30 12:30:00',1,1,0),('b',9,2,'2021-06-13 00:00:00',1,20,0),('b',9,3,'2021-06-21 00:00:00',1,1,0),('b',9,9,'2021-06-30 12:30:00',1,1,0),('b',10,2,'2021-06-13 00:00:00',1,20,0),('b',10,3,'2021-06-21 00:00:00',1,1,0),('b',10,9,'2021-06-30 12:30:00',1,1,0),('c',1,1,'2017-06-15 00:00:00',1,32,0),('c',1,2,'2021-06-13 00:00:00',1,20,0),('c',2,1,'2017-06-15 00:00:00',1,32,0),('c',2,2,'2021-06-13 00:00:00',1,20,0),('c',3,1,'2017-06-15 00:00:00',1,32,0),('c',3,2,'2021-06-13 00:00:00',1,20,0),('c',4,1,'2017-06-15 00:00:00',1,32,0),('c',4,2,'2021-06-13 00:00:00',1,20,0),('c',5,1,'2017-06-15 00:00:00',1,32,0),('c',5,2,'2021-06-13 00:00:00',1,20,0),('c',6,2,'2021-06-13 00:00:00',1,20,0),('c',7,2,'2021-06-13 00:00:00',1,20,0),('c',8,2,'2021-06-13 00:00:00',1,20,0),('c',9,2,'2021-06-13 00:00:00',1,20,0),('c',10,2,'2021-06-13 00:00:00',1,20,0),('d',1,1,'2017-06-15 00:00:00',1,32,0),('d',2,1,'2017-06-15 00:00:00',1,32,0),('d',3,1,'2017-06-15 00:00:00',1,32,0),('d',4,1,'2017-06-15 00:00:00',1,32,0),('d',5,1,'2017-06-15 00:00:00',1,32,0);
/*!40000 ALTER TABLE `asiento_funcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cinema`
--

DROP TABLE IF EXISTS `cinema`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cinema` (
  `id_cinema` int NOT NULL,
  `nombre` varchar(45) COLLATE utf8mb4_spanish_ci NOT NULL,
  `direccion` varchar(45) COLLATE utf8mb4_spanish_ci NOT NULL,
  PRIMARY KEY (`id_cinema`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cinema`
--

LOCK TABLES `cinema` WRITE;
/*!40000 ALTER TABLE `cinema` DISABLE KEYS */;
INSERT INTO `cinema` VALUES (1,'CineMark','Heredia');
/*!40000 ALTER TABLE `cinema` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `usuario_id_usuario` varchar(45) COLLATE utf8mb4_spanish_ci NOT NULL,
  `id_cliente` varchar(45) COLLATE utf8mb4_spanish_ci NOT NULL,
  `apellidos` varchar(45) COLLATE utf8mb4_spanish_ci NOT NULL,
  `nombre` varchar(45) COLLATE utf8mb4_spanish_ci NOT NULL,
  `telefono` varchar(45) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `tarjeta_pago` varchar(45) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`usuario_id_usuario`,`id_cliente`),
  KEY `fk_cliente_usuario1_idx` (`usuario_id_usuario`),
  CONSTRAINT `fk_cliente_usuario1` FOREIGN KEY (`usuario_id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES ('123456789','321','Carvajal','Alejandro','321','213'),('a','1','a','a','1','1'),('jeanka143','402500956','Jimenez','Jean Carlo','87864884','568415458641'),('luis','ale','fallas','luis','123','aaa');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `factura`
--

DROP TABLE IF EXISTS `factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `factura` (
  `seq_factura` int NOT NULL AUTO_INCREMENT,
  `fecha` datetime NOT NULL,
  `tarjeta_pago` varchar(45) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `cliente_usuario_id_usuario` varchar(45) COLLATE utf8mb4_spanish_ci NOT NULL,
  `cliente_id_cliente` varchar(45) COLLATE utf8mb4_spanish_ci NOT NULL,
  PRIMARY KEY (`seq_factura`),
  KEY `fk_factura_cliente1_idx` (`cliente_usuario_id_usuario`,`cliente_id_cliente`),
  CONSTRAINT `fk_factura_cliente1` FOREIGN KEY (`cliente_usuario_id_usuario`, `cliente_id_cliente`) REFERENCES `cliente` (`usuario_id_usuario`, `id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factura`
--

LOCK TABLES `factura` WRITE;
/*!40000 ALTER TABLE `factura` DISABLE KEYS */;
INSERT INTO `factura` VALUES (32,'2021-06-28 23:22:33','1','a','1'),(33,'2021-06-28 23:22:35','1','a','1'),(34,'2021-06-28 23:23:06','1','a','1'),(35,'2021-06-28 23:24:50','1','a','1'),(36,'2021-06-28 23:24:54','1','a','1'),(37,'2021-06-28 23:25:02','1','a','1'),(38,'2021-06-28 23:27:51','1','a','1'),(39,'2021-06-28 23:28:58','1','a','1'),(40,'2021-06-28 23:29:34','1','a','1'),(41,'2021-06-28 23:31:22','1','a','1'),(42,'2021-06-28 23:31:25','1','a','1'),(43,'2021-06-28 23:31:47','1','a','1');
/*!40000 ALTER TABLE `factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcion`
--

DROP TABLE IF EXISTS `funcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcion` (
  `id_funcion` int NOT NULL AUTO_INCREMENT,
  `fecha` datetime NOT NULL,
  `sala_cinema_id` int NOT NULL,
  `sala_numero` int NOT NULL,
  `pelicula_id` varchar(45) COLLATE utf8mb4_spanish_ci NOT NULL,
  PRIMARY KEY (`id_funcion`,`fecha`,`sala_cinema_id`,`sala_numero`),
  KEY `fk_funcion_pelicula_idx` (`pelicula_id`),
  KEY `fk_funcion_sala` (`sala_cinema_id`,`sala_numero`),
  CONSTRAINT `fk_funcion_pelicula` FOREIGN KEY (`pelicula_id`) REFERENCES `pelicula` (`id_pelicula`),
  CONSTRAINT `fk_funcion_sala` FOREIGN KEY (`sala_cinema_id`, `sala_numero`) REFERENCES `sala` (`cinema_id`, `numero`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcion`
--

LOCK TABLES `funcion` WRITE;
/*!40000 ALTER TABLE `funcion` DISABLE KEYS */;
INSERT INTO `funcion` VALUES (1,'2017-06-15 00:00:00',1,32,'337404'),(9,'2021-06-30 12:30:00',1,1,'717192'),(2,'2021-06-13 00:00:00',1,20,'726429'),(3,'2021-06-21 00:00:00',1,1,'726429'),(8,'2021-06-20 23:03:00',1,1,'726429');
/*!40000 ALTER TABLE `funcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pelicula`
--

DROP TABLE IF EXISTS `pelicula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pelicula` (
  `id_pelicula` varchar(45) COLLATE utf8mb4_spanish_ci NOT NULL,
  `titulo` varchar(45) COLLATE utf8mb4_spanish_ci NOT NULL,
  `poster_path` varchar(100) COLLATE utf8mb4_spanish_ci NOT NULL,
  `movie_data` varchar(1000) COLLATE utf8mb4_spanish_ci NOT NULL,
  `cartelera` int NOT NULL,
  PRIMARY KEY (`id_pelicula`,`titulo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pelicula`
--

LOCK TABLES `pelicula` WRITE;
/*!40000 ALTER TABLE `pelicula` DISABLE KEYS */;
INSERT INTO `pelicula` VALUES ('337404','cruella','/rTh4K5uw9HypmpGslcKd4QfHl93.jpg','In 1970s London amidst the punk rock revolution, a young grifter named Estella is determined to make a name for herself with her designs',1),('399566','godzilla vs. kong','/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg','n a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet',1),('423108','the conjuring: the devil made me do it','/xbSuFiJbbBWCkyCCKIMfuDCA4yV.jpg','Paranormal investigators Ed and Lorraine Warren encounter what would become one of the most sensational cases from their files.',1),('460465','mortal kombat','/nkayOAUBUu4mMvyNf9iHSUiPjF1.jpg','Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung\'s best warrior, Sub-Zero, seeks out and trains with Earth\'s greatest champions',1),('503736','army of the dead','/z8CExJekGrEThbpMXAmCFvvgoJR.jpg','Following a zombie outbreak in Las Vegas, a group of mercenaries take the ultimate gamble: venturing into the quarantine zone to pull off the greatest heist ever attempted',1),('637649','wrath of man','/M7SUK85sKjaStg4TKhlAVyGlz3.jpg','A cold and mysterious new security guard for a Los Angeles cash truck company surprises his co-workers when he unleashes precision skills during a heist',0),('69738','AAA: la película','/qV84RKWrCCWefCPeRLCrPQLu3ka.jpg','On the night that Parka pried the championship from Abismo Negro\'s hands, the master of darkness\' long lasting resentments resurge, thus threatening AAA\'s stability. With the help of Chesman, Charly Manson, and Cybernético, Abismo plots his revenge. Not even Octagón, AAA\'s spiritual leader, can stop the evil turn of events. When Kenzo Suzuki and Yonatan, Parka\'s younger brother, are kidnapped, it\'s quite clear the war has begun. Parka, helped by Gronda, Mascarita, Faby Apache, and Octagón, will fight to their very last breath to overcome the obstacles. The sudden appearance of a long lost evil, Triple A\'s ancestral enemy, rises the odds even more. An abandoned insane asylum, murderous cyborgs, gigantic dragonflies, ancient armies, and time travel are just the beginning of the adventure. The most spectacular lucha libre match ever is about to begin...',1),('717192','ferry','/w6n1pu9thpCVHILejsuhKf3tNCV.jpg','Before he built a drug empire, Ferry Bouman returns to his hometown on a revenge mission that finds his loyalty tested — and a love that alters his life',0),('726429','xtremo','/cwUhVcDeMYYeu8fq5q1OPOoSbZ7.jpg','Two years after the murder of his son and father, a retired hitman sets in motion a carefully crafted revenge plan against the killer: his own brother',0),('804435','vanquish','/AoWY1gkcNzabh229Icboa1Ff0BM.jpg','Victoria is a young mother trying to put her dark past as a Russian drug courier behind her, but retired cop Damon forces Victoria to do his bidding by holding her daughter',0),('817451','endangered species','/ccsSqbpEqr2KK9eMvoeF8ERFCd5.jpg','Jack Halsey takes his wife, their adult kids, and a friend for a dream vacation in Kenya',0);
/*!40000 ALTER TABLE `pelicula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sala`
--

DROP TABLE IF EXISTS `sala`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sala` (
  `cinema_id` int NOT NULL,
  `numero` int NOT NULL,
  `capacidad` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`cinema_id`,`numero`),
  CONSTRAINT `fk_sala_cinema` FOREIGN KEY (`cinema_id`) REFERENCES `cinema` (`id_cinema`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sala`
--

LOCK TABLES `sala` WRITE;
/*!40000 ALTER TABLE `sala` DISABLE KEYS */;
INSERT INTO `sala` VALUES (1,1,20),(1,20,30),(1,23,38),(1,32,88),(1,38,20),(1,57,13),(1,66,3),(1,89,9);
/*!40000 ALTER TABLE `sala` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tiquete`
--

DROP TABLE IF EXISTS `tiquete`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tiquete` (
  `id_tiquete` int NOT NULL AUTO_INCREMENT,
  `factura_seq` int NOT NULL,
  `monto` double NOT NULL,
  `asiento_funcion_fila` char(1) COLLATE utf8mb4_spanish_ci NOT NULL,
  `asiento_funcion_posicion` int NOT NULL,
  `asiento_funcion_funcion_id` int NOT NULL,
  `asiento_funcion_funcion_fecha` datetime NOT NULL,
  `asiento_funcion_funcion_sala_cinema_id` int NOT NULL,
  `asiento_funcion_funcion_sala_numero` int NOT NULL,
  PRIMARY KEY (`id_tiquete`),
  KEY `fk_tiquete_factura_idx` (`factura_seq`),
  KEY `fk_tiquete_asiento_funcion1_idx` (`asiento_funcion_fila`,`asiento_funcion_posicion`,`asiento_funcion_funcion_id`,`asiento_funcion_funcion_fecha`,`asiento_funcion_funcion_sala_cinema_id`,`asiento_funcion_funcion_sala_numero`),
  CONSTRAINT `fk_tiquete_asiento_funcion1` FOREIGN KEY (`asiento_funcion_fila`, `asiento_funcion_posicion`, `asiento_funcion_funcion_id`, `asiento_funcion_funcion_fecha`, `asiento_funcion_funcion_sala_cinema_id`, `asiento_funcion_funcion_sala_numero`) REFERENCES `asiento_funcion` (`fila`, `posicion`, `funcion_id`, `funcion_fecha`, `funcion_sala_cinema_id`, `funcion_sala_numero`),
  CONSTRAINT `fk_tiquete_factura` FOREIGN KEY (`factura_seq`) REFERENCES `factura` (`seq_factura`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tiquete`
--

LOCK TABLES `tiquete` WRITE;
/*!40000 ALTER TABLE `tiquete` DISABLE KEYS */;
INSERT INTO `tiquete` VALUES (1,32,5000,'a',1,9,'2021-06-30 12:30:00',1,1);
/*!40000 ALTER TABLE `tiquete` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id_usuario` varchar(45) COLLATE utf8mb4_spanish_ci NOT NULL,
  `clave` varchar(45) COLLATE utf8mb4_spanish_ci NOT NULL,
  `rol` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES ('123456789','b',1),('a','a',2),('jeanka143','1234',2),('luis','a',1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-01 20:29:27
