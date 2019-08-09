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
-- Table structure for table `forum_answer`
--

DROP TABLE IF EXISTS `forum_answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `forum_answer` (
  `forum_answer_id` int(11) NOT NULL AUTO_INCREMENT,
  `forum_content_id` int(11) DEFAULT NULL,
  `usr_account` varchar(45) COLLATE utf8_bin DEFAULT NULL COMMENT '评论人账号',
  `answer_count` int(11) DEFAULT '0',
  `answer_content` text COLLATE utf8_bin COMMENT '问题回答内容',
  `like_count` int(11) DEFAULT '0' COMMENT '对回答问题的点赞数量',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '问题回答的创建时间',
  PRIMARY KEY (`forum_answer_id`),
  KEY `fk_forum_answer_1` (`usr_account`),
  KEY `fk_forum_answer_2_idx` (`forum_content_id`),
  CONSTRAINT `fk_forum_answer_1` FOREIGN KEY (`usr_account`) REFERENCES `usr` (`usr_account`),
  CONSTRAINT `fk_forum_answer_2` FOREIGN KEY (`forum_content_id`) REFERENCES `forum_content` (`forum_content_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forum_answer`
--

LOCK TABLES `forum_answer` WRITE;
/*!40000 ALTER TABLE `forum_answer` DISABLE KEYS */;
INSERT INTO `forum_answer` VALUES (1,1,'waichan',9,'还需要完成扫码注册的功能',9,'2019-08-08 07:01:50'),(2,1,'waichan',0,'还需要完成扫码注册的功能',0,'2019-08-08 07:18:49'),(3,1,'waichan',0,'还需要完成扫码注册的功能',0,'2019-08-08 07:57:49'),(4,1,'waichan',0,'还需要完成扫码注册的功能',0,'2019-08-08 07:57:50'),(5,1,'waichan',0,'还需要完成扫码注册的功能',0,'2019-08-08 07:57:51'),(6,1,'waichan',0,'还需要完成扫码注册的功能',0,'2019-08-08 07:57:51'),(7,1,'waichan',0,'还需要完成扫码注册的功能',0,'2019-08-08 07:57:52'),(8,1,'waichan',0,'还需要完成扫码注册的功能',0,'2019-08-08 07:57:53'),(9,1,'waichan',0,'还需要完成扫码注册的功能',0,'2019-08-08 07:57:54'),(10,1,'waichan',0,'还需要完成扫码注册的功能',0,'2019-08-08 07:57:54'),(11,1,'waichan',0,'还需要完成扫码注册的功能',0,'2019-08-08 07:57:55'),(12,1,'waichan',0,'还需要完成扫码注册的功能',0,'2019-08-08 07:57:56'),(13,1,'waichan',0,'还需要完成扫码注册的功能',0,'2019-08-08 07:57:56'),(14,1,'waichan',0,'还需要完成扫码注册的功能',0,'2019-08-08 07:57:57'),(15,1,'waichan',0,'还需要完成扫码注册的功能',0,'2019-08-08 07:57:58'),(16,1,'waichan',0,'还需要完成扫码注册的功能',0,'2019-08-08 07:57:59'),(17,1,'waichan',0,'还需要完成扫码注册的功能',0,'2019-08-09 01:48:00'),(18,1,'waichan',0,'还需要完成扫码注册的功能',0,'2019-08-09 01:55:29'),(19,1,'waichan',0,'还需要完成扫码注册的功能',0,'2019-08-09 01:55:55');
/*!40000 ALTER TABLE `forum_answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `forum_comment`
--

DROP TABLE IF EXISTS `forum_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `forum_comment` (
  `forum_comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `forum_answer_id` int(11) DEFAULT NULL,
  `usr_account` varchar(45) COLLATE utf8_bin DEFAULT NULL COMMENT '评论的用户id',
  `forum_comment` varchar(45) COLLATE utf8_bin DEFAULT 'Hello World' COMMENT '评论',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '回答的id',
  PRIMARY KEY (`forum_comment_id`),
  KEY `fk_forum_comment_1_idx` (`forum_answer_id`),
  CONSTRAINT `fk_forum_comment_1` FOREIGN KEY (`forum_answer_id`) REFERENCES `forum_answer` (`forum_answer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forum_comment`
--

LOCK TABLES `forum_comment` WRITE;
/*!40000 ALTER TABLE `forum_comment` DISABLE KEYS */;
INSERT INTO `forum_comment` VALUES (1,1,'waichan','你回答的很好','2019-08-08 10:24:01'),(2,1,'waichan','你回答的很好','2019-08-08 10:24:03'),(3,1,'waichan','你回答的很好','2019-08-08 10:24:04'),(4,1,'waichan','你回答的很好','2019-08-08 10:24:05'),(5,1,'waichan','你回答的很好','2019-08-08 10:24:06'),(6,1,'waichan','你回答的很好','2019-08-08 10:24:07'),(7,1,'waichan','你回答的很好','2019-08-08 10:24:08'),(8,1,'waichan','你回答的很好','2019-08-09 02:19:30'),(9,1,'waichan','你回答的很好','2019-08-09 02:19:48'),(10,1,'waichan','你回答的很好','2019-08-09 02:19:49'),(11,1,'waichan','你回答的很好','2019-08-09 02:19:49'),(12,1,'waichan','你回答的很好','2019-08-09 02:19:50'),(13,1,'waichan','你回答的很好','2019-08-09 02:19:50'),(14,1,'waichan','你回答的很好','2019-08-09 02:19:51'),(15,1,'waichan','你回答的很好','2019-08-09 02:19:52'),(16,1,'waichan','你回答的很好','2019-08-09 02:20:03');
/*!40000 ALTER TABLE `forum_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `forum_content`
--

DROP TABLE IF EXISTS `forum_content`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `forum_content` (
  `forum_content_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '论坛内容主键',
  `forum_content_title` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `forum_content` text COLLATE utf8_bin,
  `usr_account` varchar(45) COLLATE utf8_bin DEFAULT NULL COMMENT '用户账号',
  `answer_count` int(11) DEFAULT '0' COMMENT '对问题的回答数量',
  `view_count` int(11) DEFAULT '0' COMMENT '浏览阅读量',
  `link_task_id` varchar(45) COLLATE utf8_bin DEFAULT NULL COMMENT '链接任务id，为问题池表的外键',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '论坛问题的创建时间',
  PRIMARY KEY (`forum_content_id`),
  KEY `fk_forum_content_1` (`usr_account`),
  CONSTRAINT `fk_forum_content_1` FOREIGN KEY (`usr_account`) REFERENCES `usr` (`usr_account`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forum_content`
--

LOCK TABLES `forum_content` WRITE;
/*!40000 ALTER TABLE `forum_content` DISABLE KEYS */;
INSERT INTO `forum_content` VALUES (1,'手机营业厅的基础业务逻辑还有什么可以优化的呢','优化手机营业厅的基础业务逻辑','waichan',1,24,'IP-009','2019-08-07 13:00:13'),(2,'手机营业厅的基础业务逻辑还有什么可以优化的呢','优化手机营业厅的基础业务逻辑','waichan',0,0,'IP-009','2019-08-07 13:01:43'),(3,'手机营业厅的基础业务逻辑还有什么可以优化的呢','优化手机营业厅的基础业务逻辑','waichan',0,0,'IP-009','2019-08-07 13:02:37'),(4,'手机营业厅的基础业务逻辑还有什么可以优化的呢','优化手机营业厅的基础业务逻辑','waichan',0,0,'IP-009','2019-08-07 13:08:33'),(5,'手机营业厅的基础业务逻辑还有什么可以优化的呢','优化手机营业厅的基础业务逻辑','waichan',0,0,'IP-009','2019-08-07 13:08:35'),(6,'手机营业厅的基础业务逻辑还有什么可以优化的呢','优化手机营业厅的基础业务逻辑','waichan',0,0,'IP-009','2019-08-07 13:13:26'),(7,'手机营业厅的基础业务逻辑还有什么可以优化的呢','优化手机营业厅的基础业务逻辑','waichan',0,0,'IP-009','2019-08-07 13:14:33'),(8,'手机营业厅的基础业务逻辑还有什么可以优化的呢','优化手机营业厅的基础业务逻辑','waichan',0,0,'IP-009','2019-08-07 13:14:34'),(9,'手机营业厅的基础业务逻辑还有什么可以优化的呢','优化手机营业厅的基础业务逻辑','waichan',0,0,'IP-009','2019-08-07 13:14:34'),(10,'手机营业厅的基础业务逻辑还有什么可以优化的呢','优化手机营业厅的基础业务逻辑','waichan',0,0,'IP-009','2019-08-07 13:14:35'),(11,'手机营业厅的基础业务逻辑还有什么可以优化的呢','优化手机营业厅的基础业务逻辑','waichan',0,0,'IP-009','2019-08-07 13:14:35'),(12,'手机营业厅的基础业务逻辑还有什么可以优化的呢','优化手机营业厅的基础业务逻辑','waichan',0,0,'IP-009','2019-08-07 13:14:36'),(13,'手机营业厅的基础业务逻辑还有什么可以优化的呢','优化手机营业厅的基础业务逻辑','waichan',0,0,'IP-009','2019-08-07 13:14:37'),(14,'手机营业厅的基础业务逻辑还有什么可以优化的呢','优化手机营业厅的基础业务逻辑','waichan',0,0,'IP-009','2019-08-07 13:14:37'),(15,'手机营业厅的基础业务逻辑还有什么可以优化的呢','优化手机营业厅的基础业务逻辑','waichan',0,0,'IP-009','2019-08-07 13:17:20'),(16,'手机营业厅的基础业务逻辑还有什么可以优化的呢','优化手机营业厅的基础业务逻辑','waichan',0,0,'IP-009','2019-08-09 00:59:32');
/*!40000 ALTER TABLE `forum_content` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-09 10:57:21
