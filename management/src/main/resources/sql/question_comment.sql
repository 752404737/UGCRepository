/*
 Navicat Premium Data Transfer

 Source Server         : czy
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : sbframework

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 11/08/2019 17:50:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for question_comment
-- ----------------------------
DROP TABLE IF EXISTS `question_comment`;
CREATE TABLE `question_comment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `usr_account` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `date` date DEFAULT NULL,
  `questionid` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of question_comment
-- ----------------------------
INSERT INTO `question_comment` VALUES (1, 'sc', '很好', '2019-08-10', 'IP-001');
INSERT INTO `question_comment` VALUES (2, 'sc', '很好', '2019-08-10', 'IP-001');
INSERT INTO `question_comment` VALUES (3, 'sc', '很好', '2019-08-10', 'IP-002');
INSERT INTO `question_comment` VALUES (4, 'sc', '很好', '2019-08-10', 'IP-003');
INSERT INTO `question_comment` VALUES (5, 'sc', '很好', '2019-08-10', 'IP-004');
INSERT INTO `question_comment` VALUES (6, 'sc', '很好', '2019-08-10', 'IP-005');
INSERT INTO `question_comment` VALUES (8, 'zrt', '非常好', '2019-08-11', 'IP-001');

SET FOREIGN_KEY_CHECKS = 1;
