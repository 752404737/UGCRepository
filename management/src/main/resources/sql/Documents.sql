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
-- Table structure for table `func`
--

DROP TABLE IF EXISTS `func`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `func` (
  `func_id` int(11) NOT NULL AUTO_INCREMENT,
  `privilege_id` varchar(45) COLLATE utf8_bin NOT NULL,
  `func_name` varchar(45) COLLATE utf8_bin DEFAULT '功能名称',
  `func_event_name` varchar(45) COLLATE utf8_bin DEFAULT '事件名称',
  `func_ico` varchar(45) COLLATE utf8_bin DEFAULT '图标链接',
  PRIMARY KEY (`func_id`,`privilege_id`),
  KEY `fk_func_1` (`privilege_id`),
  CONSTRAINT `fk_func_1` FOREIGN KEY (`privilege_id`) REFERENCES `privilege` (`privilege_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `func`
--

LOCK TABLES `func` WRITE;
/*!40000 ALTER TABLE `func` DISABLE KEYS */;
INSERT INTO `func` VALUES (1,'edit_problem_pool','编辑','editProblemPool()','/imgs/editProblemPool.png'),(2,'link_task','链接任务','linkTask()','/imgs/linkTask.png'),(3,'start_project','开始项目','startProject()','/imgs/startProject.png'),(4,'plan_complete','规划完成','planComplete()','/imgs/planComplete.png'),(5,'start_develop','开始开发','startDevelop()','/imgs/startDevelop.png'),(6,'develop_complete','开发完成','developComplete()','/imgs/developComplete.png'),(7,'acceptance_complete','验收完成','acceptanceComplete()','/imgs/acceptanceComplete.png'),(8,'start_test','开始测试','startTest()','/imgs/startTest.png'),(9,'test_complete','测试完成','testComplete()','/imgs/testComplete.png'),(10,'project_online','项目已上线','projectOnline()','/imgs/projectOnline.png'),(11,'project_test_complete','项目测试通过','projectTestComplete()','/imgs/projectTestComplete.png'),(12,'task_complete','完成任务','taskComplete()','/imgs/taskComplete.png'),(13,'run_acceptance','开始验收','runAcceptance()','/imgs/runAcceptance.png'),(14,'close_project','关闭项目','closeProject()','/imgs/closeProject.png');
/*!40000 ALTER TABLE `func` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hello_world`
--

DROP TABLE IF EXISTS `hello_world`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hello_world` (
  `id` int(11) NOT NULL,
  `hello_world` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hello_world`
--

LOCK TABLES `hello_world` WRITE;
/*!40000 ALTER TABLE `hello_world` DISABLE KEYS */;
INSERT INTO `hello_world` VALUES (1,'Hello World');
/*!40000 ALTER TABLE `hello_world` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT,
  `privilege_id` varchar(45) COLLATE utf8_bin NOT NULL,
  `menu_parent` int(11) DEFAULT NULL,
  `menu_name` varchar(256) COLLATE utf8_bin DEFAULT '菜单名称',
  `menu_url` varchar(45) COLLATE utf8_bin DEFAULT '/index',
  `menu_ico` varchar(45) COLLATE utf8_bin DEFAULT '/imgs/menu.ico',
  `menu_is_leaf` bit(1) DEFAULT b'0',
  `menu_level` int(11) DEFAULT '0',
  `menu_description` varchar(256) COLLATE utf8_bin DEFAULT '菜单',
  PRIMARY KEY (`menu_id`,`privilege_id`),
  KEY `fk_menu_1` (`privilege_id`),
  KEY `fk_menu_2_idx` (`menu_parent`),
  CONSTRAINT `fk_menu_1` FOREIGN KEY (`privilege_id`) REFERENCES `privilege` (`privilege_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,'apply_right',0,'申请权限','/applyRight','/imgs/applyRight.png',_binary '\0',0,'申请权限菜单页'),(2,'forum',0,'论坛','/forum','/imgs/default.png',_binary '\0',0,'论坛菜单页'),(3,'issue_list',0,'问题池','/issueList','/imgs/issueList.png',_binary '\0',0,'问题池菜单页'),(4,'work_surface',0,'工作面板','/workSurface','/imgs/workSurface.png',_binary '\0',0,'工作面板菜单页');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu_func`
--

DROP TABLE IF EXISTS `menu_func`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu_func` (
  `menu_id` int(11) NOT NULL,
  `func_id` int(11) NOT NULL,
  PRIMARY KEY (`menu_id`,`func_id`),
  KEY `fk_menu_func_menu_idx` (`menu_id`),
  KEY `fk_menu_func_func_idx` (`func_id`),
  CONSTRAINT `fk_menu_func_func` FOREIGN KEY (`func_id`) REFERENCES `func` (`func_id`),
  CONSTRAINT `fk_menu_func_menu` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu_func`
--

LOCK TABLES `menu_func` WRITE;
/*!40000 ALTER TABLE `menu_func` DISABLE KEYS */;
INSERT INTO `menu_func` VALUES (3,1),(3,2),(3,3),(3,4),(3,5),(3,6),(3,7),(3,8),(3,9),(3,10),(3,11),(3,12),(3,13);
/*!40000 ALTER TABLE `menu_func` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `privilege`
--

DROP TABLE IF EXISTS `privilege`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `privilege` (
  `privilege_id` varchar(45) COLLATE utf8_bin NOT NULL,
  `privilege_description` varchar(45) COLLATE utf8_bin DEFAULT 'PrivilegeDescription',
  PRIMARY KEY (`privilege_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `privilege`
--

LOCK TABLES `privilege` WRITE;
/*!40000 ALTER TABLE `privilege` DISABLE KEYS */;
INSERT INTO `privilege` VALUES ('acceptance_complete','验收完成（产品经理）'),('apply_right','申请权限 （所有角色）'),('close_project','关闭项目  (产品经理）'),('develop_complete','开发完成（研发人员）'),('edit_problem_pool','编辑问题池（产品经理）'),('forum','论坛 （所有角色）'),('issue_list','问题池（所有角色）'),('link_task','链接任务'),('plan_complete','规划完成 (产品经理）'),('project_online','项目以上线 （产品经理）'),('project_test_complete','项目测试通过（产品经理）'),('run_acceptance','开始验收 （产品经理）'),('start_develop','开始开发（研发人员）'),('start_project','开始项目（产品经理）'),('start_test','开始测试 （测试人员）'),('task_complete','完成任务（产品经理）'),('test_complete','测试完成（测试人员）'),('work_surface','工作面板（所有角色）');
/*!40000 ALTER TABLE `privilege` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `role_id` varchar(45) COLLATE utf8_bin NOT NULL DEFAULT 'usr',
  `role_name` varchar(45) COLLATE utf8_bin DEFAULT 'usr',
  `role_description` varchar(45) COLLATE utf8_bin DEFAULT 'I am usr',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES ('admin','管理员','管理员'),('pm','产品经理','产品经理'),('rd','研发人员','研发人员'),('test','测试人员','测试人员');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_privilege`
--

DROP TABLE IF EXISTS `role_privilege`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role_privilege` (
  `role_id` varchar(45) COLLATE utf8_bin NOT NULL,
  `privilege_id` varchar(45) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`role_id`,`privilege_id`),
  KEY `fk_role_privilege_privilege_idx` (`privilege_id`),
  CONSTRAINT `fk_role_privilege_1` FOREIGN KEY (`privilege_id`) REFERENCES `privilege` (`privilege_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_privilege`
--

LOCK TABLES `role_privilege` WRITE;
/*!40000 ALTER TABLE `role_privilege` DISABLE KEYS */;
INSERT INTO `role_privilege` VALUES ('pm','acceptance_complete'),('admin','apply_right'),('pm','apply_right'),('rd','apply_right'),('test','apply_right'),('pm','close_project'),('rd','develop_complete'),('pm','edit_problem_pool'),('admin','forum'),('pm','forum'),('rd','forum'),('test','forum'),('admin','issue_list'),('pm','issue_list'),('rd','issue_list'),('test','issue_list'),('pm','link_task'),('rd','link_task'),('test','link_task'),('pm','plan_complete'),('pm','project_online'),('pm','project_test_complete'),('pm','run_acceptance'),('rd','start_develop'),('pm','start_project'),('test','start_test'),('pm','task_complete'),('test','test_complete'),('admin','work_surface'),('pm','work_surface'),('rd','work_surface'),('test','work_surface');
/*!40000 ALTER TABLE `role_privilege` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usr`
--

DROP TABLE IF EXISTS `usr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usr` (
  `usr_account` varchar(45) COLLATE utf8_bin NOT NULL,
  `usr_name` varchar(45) COLLATE utf8_bin DEFAULT 'usr',
  `usr_password` varchar(45) COLLATE utf8_bin DEFAULT '123456',
  `usr_headportrait_url` varchar(45) COLLATE utf8_bin DEFAULT '/imgs/usr.png',
  PRIMARY KEY (`usr_account`),
  UNIQUE KEY `usr_account_UNIQUE` (`usr_account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin KEY_BLOCK_SIZE=1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usr`
--

LOCK TABLES `usr` WRITE;
/*!40000 ALTER TABLE `usr` DISABLE KEYS */;
INSERT INTO `usr` VALUES ('cjm','陈佳美','73c1a82624481d64a8b3d609b9ced8cf','/imgs/cjm.png'),('czy','陈珍益','78e868f607c769e71fcebafd8df23218','/imgs/czy.png'),('hjb','黄锦波','72415504df088de884918faa75fba85c','/imgs/hjb.png'),('hq','何倩','d18691623379de9147652a62fa01c056','/imgs/hq.png'),('sc','苏宸','aa1b4bb2e14e90fd811d46a77f7646d2','/imgs/sc.png'),('waichan','陈伟','69df0445fe8bd32d28be5d25bd7da292','/imgs/waichan.png'),('wpp','吴萍萍','f73b4abc40be9bf9d05de06d45457d34','/imgs/wpp.png'),('wzw','王子威','1bafaa1a994ff173b904385340d10974','/imgs/wzw.png'),('xkt','徐凯特','7386fe274b8622f347f041409070b82e','/imgs/xkt.png'),('xls','谢鲁圣','376b883035588bbedd6f9b01db38c6eb','/imgs/xls.png'),('yhh','易杭杭','a6ae6453381fd25fa8d765f0bcf2e0c4','/imgs/yhh.png'),('zrt','诸冉彤','d0f599b545216396113aa5601b625df3','/imgs/zrt.png');
/*!40000 ALTER TABLE `usr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usr_role`
--

DROP TABLE IF EXISTS `usr_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usr_role` (
  `usr_account` varchar(45) COLLATE utf8_bin NOT NULL,
  `role_id` varchar(45) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`usr_account`,`role_id`),
  KEY `fk_usr_role_usr_idx` (`usr_account`),
  KEY `fk_usr_role_role` (`role_id`),
  CONSTRAINT `fk_usr_role_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usr_role`
--

LOCK TABLES `usr_role` WRITE;
/*!40000 ALTER TABLE `usr_role` DISABLE KEYS */;
INSERT INTO `usr_role` VALUES ('cjm','admin'),('czy','rd'),('hjb','admin'),('hq','rd'),('sc','admin'),('waichan','rd'),('wpp','test'),('wzw','admin'),('xkt','rd'),('xls','pm'),('yhh','test'),('zrt','pm');
/*!40000 ALTER TABLE `usr_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-06 13:48:16
