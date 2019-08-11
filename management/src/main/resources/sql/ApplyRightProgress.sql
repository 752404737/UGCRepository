-- MySQL dump 10.13  Distrib 8.0.17, for Linux (x86_64)
--
-- Host: localhost    Database: sbframework
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `apply_right_progress`
--

DROP TABLE IF EXISTS `apply_right_progress`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `apply_right_progress` (
  `usr_account` varchar(45) COLLATE utf8_bin NOT NULL,
  `apply_role_id` varchar(45) COLLATE utf8_bin NOT NULL COMMENT '用户申请的角色权限ID',
  `apply_role_name` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `apply_usr_account` varchar(45) COLLATE utf8_bin DEFAULT NULL COMMENT '申请人的账号',
  `apply_usr_name` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `apply_state_name` varchar(45) COLLATE utf8_bin DEFAULT '申请中' COMMENT '权限的申请状态名称',
  `apply_state` int(11) DEFAULT '0' COMMENT '申请状态-2:权限失效、-1:申请失败、0:申请中、1:申请成功 ',
  `create_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`usr_account`,`apply_role_id`),
  KEY `fk_apply_right_progress_2` (`apply_usr_account`),
  KEY `fk_apply_right_progress_1` (`apply_role_id`),
  CONSTRAINT `fk_apply_right_progress_1` FOREIGN KEY (`apply_role_id`) REFERENCES `role` (`role_id`),
  CONSTRAINT `fk_apply_right_progress_2` FOREIGN KEY (`apply_usr_account`) REFERENCES `usr` (`usr_account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apply_right_progress`
--

LOCK TABLES `apply_right_progress` WRITE;
/*!40000 ALTER TABLE `apply_right_progress` DISABLE KEYS */;
INSERT INTO `apply_right_progress` VALUES ('waichan','pm','产品经理','cjm','陈佳美','权限失效',-2,'2019-08-09 13:41:34'),('waichan','test','测试人员','cjm','陈佳美','申请中',1,'2019-08-09 08:27:58');
/*!40000 ALTER TABLE `apply_right_progress` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-09 21:49:40
