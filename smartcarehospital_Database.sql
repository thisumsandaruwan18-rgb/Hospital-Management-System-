-- MySQL dump 10.13  Distrib 8.0.46, for Win64 (x86_64)
--
-- Host: localhost    Database: smartcarehospital
-- ------------------------------------------------------
-- Server version	8.0.46

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
-- Table structure for table `admission`
--

DROP TABLE IF EXISTS `admission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admission` (
  `Ad_ID` int NOT NULL,
  `Ad_Status` varchar(100) DEFAULT NULL,
  `Bed_Number` int DEFAULT NULL,
  `Admit_Date` date DEFAULT NULL,
  `Discharge_Date` date DEFAULT NULL,
  `Pa_ID` int DEFAULT NULL,
  `Ro_ID` int DEFAULT NULL,
  PRIMARY KEY (`Ad_ID`),
  KEY `Pa_ID` (`Pa_ID`),
  KEY `Ro_ID` (`Ro_ID`),
  CONSTRAINT `admission_ibfk_1` FOREIGN KEY (`Pa_ID`) REFERENCES `patient` (`Pa_ID`),
  CONSTRAINT `admission_ibfk_2` FOREIGN KEY (`Ro_ID`) REFERENCES `room` (`Ro_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admission`
--

LOCK TABLES `admission` WRITE;
/*!40000 ALTER TABLE `admission` DISABLE KEYS */;
INSERT INTO `admission` VALUES (1,'Admitted',101,'2026-08-10','2026-08-15',1,2),(2,'Admitted',102,'2026-08-11','2026-08-16',3,3),(3,'Admitted',103,'2026-08-05','2026-08-08',5,1),(4,'Admitted',104,'2026-08-12','2026-08-18',7,4),(5,'Admitted',105,'2026-08-13','2026-08-20',9,5),(6,'Admitted',102,'2026-08-10','2026-08-15',3,2);
/*!40000 ALTER TABLE `admission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `appointment`
--

DROP TABLE IF EXISTS `appointment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appointment` (
  `Ap_ID` int NOT NULL,
  `Ap_Date` date DEFAULT NULL,
  `ConsultationRoom` varchar(30) DEFAULT NULL,
  `Ap_Status` varchar(30) DEFAULT NULL,
  `Ap_Time` time DEFAULT NULL,
  `Do_ID` int DEFAULT NULL,
  `Pa_ID` int DEFAULT NULL,
  PRIMARY KEY (`Ap_ID`),
  KEY `Do_ID` (`Do_ID`),
  KEY `Pa_ID` (`Pa_ID`),
  CONSTRAINT `appointment_ibfk_1` FOREIGN KEY (`Do_ID`) REFERENCES `doctor` (`Do_ID`),
  CONSTRAINT `appointment_ibfk_2` FOREIGN KEY (`Pa_ID`) REFERENCES `patient` (`Pa_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointment`
--

LOCK TABLES `appointment` WRITE;
/*!40000 ALTER TABLE `appointment` DISABLE KEYS */;
INSERT INTO `appointment` VALUES (1,'2026-08-10','Room 101','Completed','09:00:00',102,1),(2,'2026-08-10','Room 102','Pending','10:00:00',102,2),(3,'2026-08-10','Room 103','Completed','11:00:00',103,3),(4,'2026-08-11','Room 104','Pending','09:30:00',104,4),(5,'2026-08-11','Room 105','Completed','10:30:00',105,5),(6,'2026-08-12','Room 101','Completed','09:00:00',101,6),(7,'2026-08-12','Room 102','Cancelled','10:00:00',102,7),(8,'2026-08-12','Room 103','Completed','11:00:00',103,8),(9,'2026-08-13','Room 104','Pending','09:30:00',104,9),(10,'2026-08-13','Room 105','Completed','10:30:00',105,10),(11,'2026-08-14','Room 101','Completed','11:30:00',101,2),(12,'2026-08-14','Room 102','Completed','12:00:00',102,3),(13,'2026-08-15','Room 103','Pending','01:00:00',103,4),(14,'2026-08-15','Room 104','Completed','02:00:00',104,5),(15,'2026-08-15','Room 105','Completed','03:00:00',105,6),(16,'2026-08-10','Room 102','pendding','01:00:00',102,5);
/*!40000 ALTER TABLE `appointment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `billing`
--

DROP TABLE IF EXISTS `billing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `billing` (
  `Bill_ID` int NOT NULL,
  `Bill_Date` date DEFAULT NULL,
  `TotalAmount` decimal(10,2) DEFAULT NULL,
  `PaymentStatus` varchar(30) DEFAULT NULL,
  `PaymentMethod` varchar(30) DEFAULT NULL,
  `Pa_ID` int DEFAULT NULL,
  PRIMARY KEY (`Bill_ID`),
  KEY `Pa_ID` (`Pa_ID`),
  CONSTRAINT `billing_ibfk_1` FOREIGN KEY (`Pa_ID`) REFERENCES `patient` (`Pa_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `billing`
--

LOCK TABLES `billing` WRITE;
/*!40000 ALTER TABLE `billing` DISABLE KEYS */;
INSERT INTO `billing` VALUES (1,'2026-08-10',5000.00,'Paid','Cash',1),(2,'2026-08-10',6500.00,'Paid','Card',2),(3,'2026-08-11',4200.00,'Pending','Cash',3),(4,'2026-08-11',7800.00,'Paid','Card',4),(5,'2026-08-12',9000.00,'Pending','Online',5),(6,'2026-08-12',5500.00,'Paid','Cash',6),(7,'2026-08-13',6100.00,'Pending','Card',7),(8,'2026-08-13',4800.00,'Paid','Cash',8),(9,'2026-08-14',7300.00,'Paid','Online',9),(10,'2026-08-14',5200.00,'Pending','Card',10),(11,'2026-08-20',4500.00,'Pending','Cash',1);
/*!40000 ALTER TABLE `billing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `billingdetailsview`
--

DROP TABLE IF EXISTS `billingdetailsview`;
/*!50001 DROP VIEW IF EXISTS `billingdetailsview`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `billingdetailsview` AS SELECT 
 1 AS `Full_Name`,
 1 AS `Bill_Date`,
 1 AS `TotalAmount`,
 1 AS `PaymentStatus`,
 1 AS `PaymentMethod`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department` (
  `De_ID` int NOT NULL,
  `De_Name` varchar(100) DEFAULT NULL,
  `Location` varchar(100) DEFAULT NULL,
  `HeadDoctor` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`De_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'Cardiology','Building A','Dr. Silva'),(2,'Neurology','Building B','Dr. Perera'),(3,'Pediatrics','Building C','Dr. Fernando'),(4,'Orthopedics','Building D','Dr. Jayasuriya'),(5,'Radiology','Building E','Dr. Nimal');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctor` (
  `Do_ID` int NOT NULL,
  `Do_Name` varchar(100) DEFAULT NULL,
  `Specialization` varchar(255) DEFAULT NULL,
  `Qualification` varchar(255) DEFAULT NULL,
  `Consultation_Fee` decimal(10,2) DEFAULT NULL,
  `Contact_No` varchar(15) DEFAULT NULL,
  `De_ID` int DEFAULT NULL,
  PRIMARY KEY (`Do_ID`),
  KEY `De_ID` (`De_ID`),
  CONSTRAINT `doctor_ibfk_1` FOREIGN KEY (`De_ID`) REFERENCES `department` (`De_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor`
--

LOCK TABLES `doctor` WRITE;
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` VALUES (101,'Dr. Silva','Cardiology','MBBS',5000.00,'0712345678',1),(102,'Dr. Perera','Neurology','MD',6000.00,'0723456789',2),(103,'Dr. Fernando','Pediatrics','MBBS',4500.00,'0734567890',3),(104,'Dr. Jayasuriya','Orthopedics','MS',7000.00,'0745678901',4),(105,'Dr. Nimal','Radiology','MD',5500.00,'0756789012',5);
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `laboratory`
--

DROP TABLE IF EXISTS `laboratory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `laboratory` (
  `Test_ID` int NOT NULL,
  `Test_Name` varchar(100) DEFAULT NULL,
  `Test_Date` date DEFAULT NULL,
  `Test_Result` varchar(100) DEFAULT NULL,
  `TechnicianName` varchar(100) DEFAULT NULL,
  `Test_Status` varchar(30) DEFAULT NULL,
  `Pa_ID` int DEFAULT NULL,
  `Do_ID` int DEFAULT NULL,
  PRIMARY KEY (`Test_ID`),
  KEY `Pa_ID` (`Pa_ID`),
  KEY `Do_ID` (`Do_ID`),
  CONSTRAINT `laboratory_ibfk_1` FOREIGN KEY (`Pa_ID`) REFERENCES `patient` (`Pa_ID`),
  CONSTRAINT `laboratory_ibfk_2` FOREIGN KEY (`Do_ID`) REFERENCES `doctor` (`Do_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `laboratory`
--

LOCK TABLES `laboratory` WRITE;
/*!40000 ALTER TABLE `laboratory` DISABLE KEYS */;
INSERT INTO `laboratory` VALUES (1,'Blood Test','2026-08-10','Normal','Kasun','Completed',1,101),(2,'MRI','2026-08-10','Normal','Amal','Completed',2,102),(3,'Urine Test','2026-08-11','Normal','Nuwan','Completed',3,103),(4,'CT Scan','2026-08-11','Abnormal','Ruwan','Pending',4,104),(5,'X-Ray','2026-08-12','Normal','Saman','Completed',5,105),(6,'Blood Test','2026-08-12','High Sugar','Kasun','Completed',6,101),(7,'ECG','2026-08-13','Normal','Amal','Completed',7,101),(8,'Blood Test','2026-08-13','Low HB','Nuwan','Pending',8,102),(9,'MRI','2026-08-14','Normal','Ruwan','Completed',9,103),(10,'CT Scan','2026-08-14','Normal','Saman','Completed',10,104);
/*!40000 ALTER TABLE `laboratory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient` (
  `Pa_ID` int NOT NULL,
  `Full_Name` varchar(100) DEFAULT NULL,
  `DOB` date DEFAULT NULL,
  `Gender` varchar(10) DEFAULT NULL,
  `Address` varchar(255) DEFAULT NULL,
  `Contact_No` varchar(15) DEFAULT NULL,
  `BloodGroup` varchar(5) DEFAULT NULL,
  `EmergencyContact` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`Pa_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (1,'Chathura Jayaneth','1998-06-10','Female','Colombo','0771112222','A-','071111222'),(2,'Kamal Silva','1995-03-12','Male','Kandy','0772222222','B+','0722222222'),(3,'Saman Kumara','2000-07-18','Male','Galle','0773333333','O+','0733333333'),(4,'Kasuni Fernando','1999-11-22','Female','Matara','0774444444','AB+','0744444444'),(5,'Dilani Perera','1997-02-15','Female','Kurunegala','0775555555','A-','0755555555'),(6,'Amila Jayasinghe','1996-09-05','Male','Negombo','0776666666','B-','0766666666'),(7,'Tharushi Silva','2001-01-30','Female','Jaffna','0777777777','O-','0777777770'),(8,'Ruwan Fernando','1994-08-25','Male','Badulla','0778888888','AB-','0788888888'),(9,'Sachini Kumari','2002-06-16','Female','Ratnapura','0779999999','A+','0799999999'),(10,'Sujiwa Sampath','2002-06-16','Male','Ratnapura','0779999999','A+','0799999999'),(11,'Pasidu Chathuranga','1988-08-09','Male','Kolonnawa','0771112223','A','071111223'),(12,'Pemitha Jayaneth','1998-06-10','Male','Colombo','0771000002','A+','0710000022');
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `patientappointmentview`
--

DROP TABLE IF EXISTS `patientappointmentview`;
/*!50001 DROP VIEW IF EXISTS `patientappointmentview`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `patientappointmentview` AS SELECT 
 1 AS `Pa_ID`,
 1 AS `Full_Name`,
 1 AS `Do_Name`,
 1 AS `Ap_Date`,
 1 AS `Ap_Time`,
 1 AS `Ap_Status`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room` (
  `Ro_ID` int NOT NULL,
  `RoomCategory` varchar(50) DEFAULT NULL,
  `Ro_Status` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`Ro_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (1,'General Ward','Occupied'),(2,'Private Room','Occupied'),(3,'ICU','Occupied'),(4,'General Ward','Available'),(5,'Private Room','Available');
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `treatment`
--

DROP TABLE IF EXISTS `treatment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `treatment` (
  `Treat_ID` int NOT NULL,
  `Diagnosis` varchar(255) DEFAULT NULL,
  `PrescriptionDetails` text,
  `Treat_Notes` text,
  `Treat_Date` date DEFAULT NULL,
  `Pa_ID` int DEFAULT NULL,
  `Do_ID` int DEFAULT NULL,
  PRIMARY KEY (`Treat_ID`),
  KEY `Pa_ID` (`Pa_ID`),
  KEY `Do_ID` (`Do_ID`),
  CONSTRAINT `treatment_ibfk_1` FOREIGN KEY (`Pa_ID`) REFERENCES `patient` (`Pa_ID`),
  CONSTRAINT `treatment_ibfk_2` FOREIGN KEY (`Do_ID`) REFERENCES `doctor` (`Do_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `treatment`
--

LOCK TABLES `treatment` WRITE;
/*!40000 ALTER TABLE `treatment` DISABLE KEYS */;
INSERT INTO `treatment` VALUES (1,'Heart Disease','Medicine A','Stable','2026-08-10',1,101),(2,'Migraine','Medicine B','Improving','2026-08-10',2,102),(3,'Fever','Medicine C','Recovered','2026-08-11',3,103),(4,'Fracture','Medicine D','Under Observation','2026-08-11',4,104),(5,'X-Ray Review','Medicine E','Completed','2026-08-12',5,105),(6,'Asthma','Medicine F','Stable','2026-08-12',6,103),(7,'Diabetes','Medicine G','Monitoring','2026-08-13',7,101),(8,'Back Pain','Medicine H','Improving','2026-08-13',8,104),(9,'Allergy','Medicine I','Recovered','2026-08-14',9,102),(10,'Flu','Medicine J','Completed','2026-08-14',10,103);
/*!40000 ALTER TABLE `treatment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `billingdetailsview`
--

/*!50001 DROP VIEW IF EXISTS `billingdetailsview`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `billingdetailsview` AS select `p`.`Full_Name` AS `Full_Name`,`b`.`Bill_Date` AS `Bill_Date`,`b`.`TotalAmount` AS `TotalAmount`,`b`.`PaymentStatus` AS `PaymentStatus`,`b`.`PaymentMethod` AS `PaymentMethod` from (`billing` `b` join `patient` `p` on((`b`.`Pa_ID` = `p`.`Pa_ID`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `patientappointmentview`
--

/*!50001 DROP VIEW IF EXISTS `patientappointmentview`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `patientappointmentview` AS select `p`.`Pa_ID` AS `Pa_ID`,`p`.`Full_Name` AS `Full_Name`,`d`.`Do_Name` AS `Do_Name`,`a`.`Ap_Date` AS `Ap_Date`,`a`.`Ap_Time` AS `Ap_Time`,`a`.`Ap_Status` AS `Ap_Status` from ((`patient` `p` join `appointment` `a` on((`p`.`Pa_ID` = `a`.`Pa_ID`))) join `doctor` `d` on((`a`.`Do_ID` = `d`.`Do_ID`))) */;
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

-- Dump completed on 2026-08-22 21:50:36
