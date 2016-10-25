-- MySQL dump 10.13  Distrib 5.7.15, for Linux (x86_64)
--
-- Host: localhost    Database: ArquitecturaSW
-- ------------------------------------------------------
-- Server version	5.7.15-0ubuntu0.16.04.1

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
-- Table structure for table `Cliente`
--

DROP TABLE IF EXISTS `Cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Cliente` (
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
-- Dumping data for table `Cliente`
--

LOCK TABLES `Cliente` WRITE;
/*!40000 ALTER TABLE `Cliente` DISABLE KEYS */;
INSERT INTO `Cliente` VALUES ('8656565','Pepe','Perez','C:\\mayor1','pepe.perez@pepe.com',69696,'\0',1234),('9898989','Daniel','Guzman','ColegioMayor','d.g@hola.com',45545445,'\0',4321);
/*!40000 ALTER TABLE `Cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Cuenta`
--

DROP TABLE IF EXISTS `Cuenta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Cuenta` (
  `IBAN` int(11) NOT NULL,
  `SWIFT` varchar(45) DEFAULT NULL,
  `FechaApertura` varchar(45) DEFAULT NULL,
  `Activa` bit(1) DEFAULT NULL,
  `SaldoActual` float DEFAULT NULL,
  `Interes` float DEFAULT NULL,
  `Cliente` varchar(45) DEFAULT NULL,
  `Tarjeta` int(11) DEFAULT NULL,
  PRIMARY KEY (`IBAN`),
  KEY `fk_DNIcliente_idx` (`Cliente`),
  KEY `fk_NumTarjeta_idx` (`Tarjeta`),
  CONSTRAINT `fk_DNIcliente` FOREIGN KEY (`Cliente`) REFERENCES `Cliente` (`DNI`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_NumTarjeta` FOREIGN KEY (`Tarjeta`) REFERENCES `Tarjeta` (`Numero`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Cuenta`
--

LOCK TABLES `Cuenta` WRITE;
/*!40000 ALTER TABLE `Cuenta` DISABLE KEYS */;
/*!40000 ALTER TABLE `Cuenta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Operacion`
--

DROP TABLE IF EXISTS `Operacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Operacion` (
  `ID` int(11) NOT NULL,
  `Fecha` varchar(45) DEFAULT NULL,
  `Tipo` enum('Ingreso','Extraccion') DEFAULT NULL,
  `Importe` float DEFAULT NULL,
  `Cuenta` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_IBANcuenta_idx` (`Cuenta`),
  CONSTRAINT `fk_IBANcuenta` FOREIGN KEY (`Cuenta`) REFERENCES `Cuenta` (`IBAN`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Operacion`
--

LOCK TABLES `Operacion` WRITE;
/*!40000 ALTER TABLE `Operacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `Operacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Tarjeta`
--

DROP TABLE IF EXISTS `Tarjeta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Tarjeta` (
  `Numero` int(11) NOT NULL,
  `LimiteExtraccion` int(11) DEFAULT NULL,
  `FechaCaducidad` varchar(45) DEFAULT NULL,
  `Proveedor` enum('Visa','Mastercard','AmericanExpress') DEFAULT NULL,
  `Tipo` enum('Debito','Credito') DEFAULT NULL,
  `FechaExpedicion` varchar(45) DEFAULT NULL,
  `Cuenta` int(11) DEFAULT NULL,
  PRIMARY KEY (`Numero`),
  KEY `fk_Tarjeta_1_idx` (`Cuenta`),
  CONSTRAINT `fk_Tarjeta_1` FOREIGN KEY (`Cuenta`) REFERENCES `Cuenta` (`IBAN`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Tarjeta`
--

LOCK TABLES `Tarjeta` WRITE;
/*!40000 ALTER TABLE `Tarjeta` DISABLE KEYS */;
/*!40000 ALTER TABLE `Tarjeta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-10-25 10:02:17
