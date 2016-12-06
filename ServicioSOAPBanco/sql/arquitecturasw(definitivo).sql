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
INSERT INTO `cliente` VALUES ('15155551','Juan','Perez Perez','Calle menor','juan@juan.es',65266262,'\0',26222),('1660000','Daniel','Guzmán Castroviejo','Calle mayor 12','daniel@daniel.es',600000000,'',121212),('22000000','Antonio','Lopez','Calle Barcelona','antonio@antonio.es',61015457,'\0',123),('2525252','Pepe','Perez','Calle','pepe',123,'\0',123),('58485442','Aitor','DB','Calle DB','aitor@gmail.com',6978554,'\0',25784);
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
INSERT INTO `cuenta` VALUES (141414,'TT-XXBNK','2002-02-02','\0',540,0.1,'15155551'),(5555555,'SWT-OUX','2003-02-18','\0',4988,0.03,'1660000'),(15151515,'SS-TC','2001-02-06','',325,0.07,'2525252');
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
INSERT INTO `operacion` VALUES (1,'2016-02-03','Ingreso',300,141414),(2,'2016-01-01','Extraccion',100,5555555),(3,'2016-03-03','Ingreso',1200,5555555);
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
INSERT INTO `tarjeta` VALUES (166162,20,'2001-01-01','Visa','Debito','2002-02-22',141414),(1616626,28282,'2002-02-02','Visa','Credito','2001-01-01',15151515),(2525252,3000,'2222-02-22','Mastercard','Debito','2222-01-21',15151515),(25255525,2552,'2554-04-04','AmericanExpress','Credito','2554-03-03',141414);
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

-- Dump completed on 2016-12-06 11:15:33
