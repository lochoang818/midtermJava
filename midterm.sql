CREATE DATABASE  IF NOT EXISTS `midjava` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `midjava`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: midjava
-- ------------------------------------------------------
-- Server version	8.1.0

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
-- Table structure for table `brand`
--

DROP TABLE IF EXISTS `brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `brand` (
  `brand_id` int NOT NULL AUTO_INCREMENT,
  `brand_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`brand_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brand`
--

LOCK TABLES `brand` WRITE;
/*!40000 ALTER TABLE `brand` DISABLE KEYS */;
INSERT INTO `brand` VALUES (1,'Nike'),(2,'Adidas'),(3,'Puma'),(4,'Balenciaga');
/*!40000 ALTER TABLE `brand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `cate_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cate_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Walking Shoes'),(2,'Running Shoes'),(3,'Basketball Shoes'),(4,'Retro Shoes');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `color`
--

DROP TABLE IF EXISTS `color`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `color` (
  `color_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`color_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `color`
--

LOCK TABLES `color` WRITE;
/*!40000 ALTER TABLE `color` DISABLE KEYS */;
INSERT INTO `color` VALUES (1,'Red'),(2,'Blue'),(3,'Green'),(4,'Black'),(5,'White');
/*!40000 ALTER TABLE `color` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `order_id` varchar(255) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `total_price` double NOT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `FKel9kyl84ego2otj2accfd8mr7` (`user_id`),
  CONSTRAINT `FKel9kyl84ego2otj2accfd8mr7` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES ('52100@student.tdtu.edu.vn1','0853355396','125 tân bình','In Progress',392,5),('52100@student.tdtu.edu.vn2','0853355396','125 tphcm','In Progress',1464,5),('52100818@student.tdtu.edu.vn1','0853355396','125 tân bình','In Progress',208,4),('loc@gmail.com1','123123','abcqưeqweqwe','In Progress',467,1),('loc@gmail.com2','123123','abc','Ordering',0,1),('lochoang@gmail.com1','0853355396','125 Hoàng Hoa Thám','In Progress',874,10),('lochoangtdt@gmail.com1','0853355396','123 Tân Bình','In Progress',796,12);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shoes`
--

DROP TABLE IF EXISTS `shoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shoes` (
  `category` int DEFAULT NULL,
  `color` int DEFAULT NULL,
  `price` double NOT NULL,
  `shoes_id` int NOT NULL AUTO_INCREMENT,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `brand` int DEFAULT NULL,
  PRIMARY KEY (`shoes_id`),
  KEY `FKks8cugwl7x2paa504ik71ot5j` (`category`),
  KEY `FK5g0x6wc6ktawmyohjtpv4cmth` (`color`),
  KEY `FKp2b92cyvphm3d3pxnywntnh2o` (`brand`),
  CONSTRAINT `FK5g0x6wc6ktawmyohjtpv4cmth` FOREIGN KEY (`color`) REFERENCES `color` (`color_id`),
  CONSTRAINT `FKks8cugwl7x2paa504ik71ot5j` FOREIGN KEY (`category`) REFERENCES `category` (`cate_id`),
  CONSTRAINT `FKp2b92cyvphm3d3pxnywntnh2o` FOREIGN KEY (`brand`) REFERENCES `brand` (`brand_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shoes`
--

LOCK TABLES `shoes` WRITE;
/*!40000 ALTER TABLE `shoes` DISABLE KEYS */;
INSERT INTO `shoes` VALUES (1,1,20,1,'/img/product/red1.jpg','Nike Air Max',1),(1,1,25,2,'/img/product/red1.jpg','Nike React',1),(2,3,50,3,'/img/product/green1.jpg','Nike Zoom',1),(3,4,90,4,'/img/product/p3.jpg','Paul George 4',1),(2,2,37,5,'/img/product/blue1.jpg','Adidas 1',2),(2,3,28,6,'/img/product/green2.jpg','Adidas 2018',2),(2,5,135,7,'/img/product/p1.jpg','NMD R1',2),(3,5,97,8,'/img/product/p5.jpg','Pegasus Turbo',1),(3,3,113,9,'/img/product/green3.jpg','Cortez',4),(4,2,184,10,'/img/product/blue2.jpg','Futurecraft 4D',3),(1,5,136,11,'/img/product/p1.jpg','LeBron NXXT Gen',3),(3,5,61,12,'/img/product/p2.jpg','Yeezy Boost 350',3),(2,1,120,13,'/img/product/p6.jpg','Superstar',2),(2,5,123,14,'/img/product/p1.jpg','Air Max 97',1),(4,4,61,15,'/img/product/p3.jpg','RS-X',4),(2,1,132,16,'/img/product/red2.jpg','Air Presto',3),(3,4,152,17,'/img/product/black1.jpg','Epic React Flyknit',2),(2,2,78,18,'/img/product/blue3.jpg','Old Skool',2),(3,5,184,19,'/img/product/p2.jpg','Zoom Fly',4),(1,4,150,20,'/img/product/black2.jpg','Classic Leather',3);
/*!40000 ALTER TABLE `shoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shoes_order`
--

DROP TABLE IF EXISTS `shoes_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shoes_order` (
  `order_id` varchar(255) NOT NULL,
  `shoes_id` int NOT NULL,
  `price` double NOT NULL,
  `quantity` int NOT NULL,
  PRIMARY KEY (`order_id`,`shoes_id`),
  KEY `FKby7h41ea0x1jst4sudbgu933f` (`shoes_id`),
  CONSTRAINT `FKby7h41ea0x1jst4sudbgu933f` FOREIGN KEY (`shoes_id`) REFERENCES `shoes` (`shoes_id`),
  CONSTRAINT `FKp0ky5hamrwxrb9b915xbfrgd7` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shoes_order`
--

LOCK TABLES `shoes_order` WRITE;
/*!40000 ALTER TABLE `shoes_order` DISABLE KEYS */;
INSERT INTO `shoes_order` VALUES ('52100@student.tdtu.edu.vn1',1,80,4),('52100@student.tdtu.edu.vn1',18,312,4),('52100@student.tdtu.edu.vn2',11,544,4),('52100@student.tdtu.edu.vn2',19,920,5),('52100818@student.tdtu.edu.vn1',4,180,2),('52100818@student.tdtu.edu.vn1',6,28,1),('loc@gmail.com1',1,40,2),('loc@gmail.com1',2,100,4),('loc@gmail.com1',3,250,5),('loc@gmail.com1',4,180,2),('loc@gmail.com1',5,37,1),('loc@gmail.com2',4,90,1),('lochoang@gmail.com1',3,250,5),('lochoang@gmail.com1',18,624,8),('lochoangtdt@gmail.com1',10,552,3),('lochoangtdt@gmail.com1',12,244,4);
/*!40000 ALTER TABLE `shoes_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enable` bit(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `verification_code` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'abc','loc@gmail.com',_binary '','loc hoang','1234567','123123','user','1',NULL),(4,'125 tân bình','52100818@student.tdtu.edu.vn',_binary '\0',NULL,'$2a$10$xFMAdL/2kNq8u/8z3OKQcuaSkoNe0WsgsDSc34HkT4v/Tv0l/EtZK','0853355396','user',NULL,'ro'),(5,'125 tân bình','52100@student.tdtu.edu.vn',_binary '\0',NULL,'$2a$10$Qy6E75c.I8XjZPhcBSUvz.jZjxH6Rg5AcUajsouWayOxK0KteIsgy','0853355396','user',NULL,'Phú Lộc'),(10,'125 tân bình','lochoang@gmail.com',_binary '\0',NULL,'$2a$10$11wIv83/h.cs4Drv.rwRvuCFT5lCE5q82zTt/nw9DGet6gq6eq5sS','0853355396','user',NULL,'Phú Lộc'),(11,'123 Trường Chinh','loctdt@gmail.com',_binary '\0',NULL,'$2a$10$YNY5mWh4MQ/IWC5/Tb.GDe5M/dFNkIDV9qWoASPmKclyE69sauZnO','0853355396','user',NULL,'Phú Lộc'),(12,'123 Trường Chinh','lochoangtdt@gmail.com',_binary '\0',NULL,'$2a$10$n0WQe3l92lSONoVbAQRrd.CYrGM03Wkt5Ab2CSWTb8Wkn7Oe9d0zu','0853355396','user',NULL,'Phú Lộc');
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

-- Dump completed on 2023-11-30 13:18:52
