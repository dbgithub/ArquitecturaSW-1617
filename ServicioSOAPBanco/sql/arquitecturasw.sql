-- MySQL dump 10.13  Distrib 5.7.16, for Linux (x86_64)
--
-- Host: localhost    Database: ArquitecturaSW
-- ------------------------------------------------------
-- Server version	5.7.16-0ubuntu0.16.04.1

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `DNI` varchar(45) NOT NULL,
  `Nombre` varchar(45) DEFAULT NULL,
  `Apellidos` varchar(45) DEFAULT NULL,
  `Direccion` varchar(45) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `Movil` int(11) DEFAULT NULL,
  `Empleado` bit(1) DEFAULT NULL,
  `PIN` int(11) DEFAULT NULL,
  PRIMARY KEY (`DNI`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES ('123456789','PRUEBA NOMBRE','PRUEBA APELLIDOS','PRUEBA DIR','prueba@gmail.prueba',79797979,'',5665),('8656565','Pepe','Perez','C:\\mayor1','pepe.perez@pepe.com',69696,'\0',1234),('9898989','Danielo','Guzman','Colegio mayor Deusto','d.g@hola.com',69455454,'\0',9876);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuenta`
--

DROP TABLE IF EXISTS `cuenta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cuenta` (
  `IBAN` int(11) NOT NULL,
  `SWIFT` varchar(45) DEFAULT NULL,
  `FechaApertura` varchar(45) DEFAULT NULL,
  `Activa` bit(1) DEFAULT NULL,
  `SaldoActual` float DEFAULT NULL,
  `Interes` float DEFAULT NULL,
  `Cliente` varchar(45) NOT NULL,
  PRIMARY KEY (`IBAN`),
  KEY `fk_DNIcliente_idx` (`Cliente`),
  CONSTRAINT `fk_DNIcliente` FOREIGN KEY (`Cliente`) REFERENCES `cliente` (`DNI`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuenta`
--

LOCK TABLES `cuenta` WRITE;
/*!40000 ALTER TABLE `cuenta` DISABLE KEYS */;
INSERT INTO `cuenta` VALUES (454545,'SXXKUTXA-09','3916-12-17','',2122,0.7,'9898989');
/*!40000 ALTER TABLE `cuenta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `operacion`
--

DROP TABLE IF EXISTS `operacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `operacion` (
  `ID` int(11) NOT NULL,
  `Fecha` varchar(45) DEFAULT NULL,
  `Tipo` enum('Ingreso','Extraccion') DEFAULT NULL,
  `Importe` float DEFAULT NULL,
  `Cuenta` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_IBANcuenta_idx` (`Cuenta`),
  CONSTRAINT `fk_IBANcuenta` FOREIGN KEY (`Cuenta`) REFERENCES `cuenta` (`IBAN`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operacion`
--

LOCK TABLES `operacion` WRITE;
/*!40000 ALTER TABLE `operacion` DISABLE KEYS */;
INSERT INTO `operacion` VALUES (1,'2016-10-28T11:40:53.711+02:00','Ingreso',250,454545),(2,'2016-10-28T11:40:43.711+02:00','Ingreso',100,454545),(3,'2016-10-28T11:41:02.211+02:00','Ingreso',150,454545);
/*!40000 ALTER TABLE `operacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tarjeta`
--

DROP TABLE IF EXISTS `tarjeta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tarjeta` (
  `Numero` int(11) NOT NULL,
  `LimiteExtraccion` int(11) DEFAULT NULL,
  `FechaCaducidad` varchar(45) DEFAULT NULL,
  `Proveedor` enum('Visa','Mastercard','AmericanExpress') DEFAULT NULL,
  `Tipo` enum('Debito','Credito') DEFAULT NULL,
  `FechaExpedicion` varchar(45) DEFAULT NULL,
  `Cuenta` int(11) DEFAULT NULL,
  PRIMARY KEY (`Numero`),
  KEY `fk_Tarjeta_1_idx` (`Cuenta`),
  CONSTRAINT `fk_Tarjeta_1` FOREIGN KEY (`Cuenta`) REFERENCES `cuenta` (`IBAN`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarjeta`
--

LOCK TABLES `tarjeta` WRITE;
/*!40000 ALTER TABLE `tarjeta` DISABLE KEYS */;
INSERT INTO `tarjeta` VALUES (555556,1300,'2017-11-18','AmericanExpress','Credito','2016-11-17',454545);
/*!40000 ALTER TABLE `tarjeta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-04 20:34:41
