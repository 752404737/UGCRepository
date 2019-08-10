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

 Date: 10/08/2019 15:36:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for question_handle
-- ----------------------------
DROP TABLE IF EXISTS `question_handle`;
CREATE TABLE `question_handle`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `usr_account` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `questionid` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of question_handle
-- ----------------------------
INSERT INTO `question_handle` VALUES (1, 'czy', '新问题', 'IP-001', '2019-07-11');
INSERT INTO `question_handle` VALUES (2, 'czy', '新问题', 'IP-001', '2019-07-11');
INSERT INTO `question_handle` VALUES (3, 'czy', '解决问题', 'IP-001', '2019-07-11');
INSERT INTO `question_handle` VALUES (4, 'czy', '关闭问题', 'IP-001', '2019-07-11');
INSERT INTO `question_handle` VALUES (5, 'czy', '关闭问题', 'IP-001', '2019-07-11');
INSERT INTO `question_handle` VALUES (6, 'czy', '新问题', 'IP-001', '2019-07-12');
INSERT INTO `question_handle` VALUES (7, 'czy', '解决问题', 'IP-001', '2019-07-13');
INSERT INTO `question_handle` VALUES (8, 'czy', '关闭问题', 'IP-001', '2019-07-14');
INSERT INTO `question_handle` VALUES (9, 'czy', '新问题', 'IP-001', '2019-07-15');
INSERT INTO `question_handle` VALUES (10, 'czy', '解决问题', 'IP-001', '2019-07-16');
INSERT INTO `question_handle` VALUES (11, 'czy', '关闭问题', 'IP-001', '2019-07-17');
INSERT INTO `question_handle` VALUES (12, 'czy', '新问题', 'IP-001', '2019-07-18');
INSERT INTO `question_handle` VALUES (13, 'czy', '解决问题', 'IP-001', '2019-07-19');
INSERT INTO `question_handle` VALUES (14, 'czy', '关闭问题', 'IP-001', '2019-07-20');
INSERT INTO `question_handle` VALUES (15, 'czy', '新问题', 'IP-001', '2019-07-21');
INSERT INTO `question_handle` VALUES (16, 'czy', '新问题', 'IP-001', '2019-07-21');
INSERT INTO `question_handle` VALUES (17, 'czy', '新问题', 'IP-001', '2019-07-21');
INSERT INTO `question_handle` VALUES (18, 'czy', '解决问题', 'IP-001', '2019-07-21');
INSERT INTO `question_handle` VALUES (19, 'czy', '解决问题', 'IP-001', '2019-07-21');
INSERT INTO `question_handle` VALUES (20, 'czy', '关闭问题', 'IP-001', '2019-07-21');
INSERT INTO `question_handle` VALUES (21, 'czy', '关闭问题', 'IP-001', '2019-07-21');
INSERT INTO `question_handle` VALUES (22, 'czy', '关闭问题', 'IP-001', '2019-07-21');
INSERT INTO `question_handle` VALUES (23, 'czy', '新问题', 'IP-001', '2019-07-22');
INSERT INTO `question_handle` VALUES (24, 'czy', '关闭问题', 'IP-001', '2019-07-24');
INSERT INTO `question_handle` VALUES (25, 'czy', '解决问题', 'IP-001', '2019-07-25');
INSERT INTO `question_handle` VALUES (26, 'czy', '开始项目', 'IP-016', '2019-07-25');
INSERT INTO `question_handle` VALUES (27, 'czy', '规划完成', 'IP-016', '2019-07-26');
INSERT INTO `question_handle` VALUES (28, 'czy', '开始开发', 'IP-016', '2019-07-27');
INSERT INTO `question_handle` VALUES (29, 'czy', '开始完成', 'IP-016', '2019-07-28');
INSERT INTO `question_handle` VALUES (30, 'czy', '开始验收', 'IP-016', '2019-07-29');
INSERT INTO `question_handle` VALUES (31, 'czy', '验收完成', 'IP-016', '2019-07-30');
INSERT INTO `question_handle` VALUES (32, 'czy', '开始测试', 'IP-016', '2019-07-31');
INSERT INTO `question_handle` VALUES (33, 'czy', '测试完成', 'IP-016', '2019-08-01');
INSERT INTO `question_handle` VALUES (34, 'czy', '项目已上线', 'IP-016', '2019-08-02');
INSERT INTO `question_handle` VALUES (35, 'czy', '线上测试通过', 'IP-016', '2019-08-03');

SET FOREIGN_KEY_CHECKS = 1;
