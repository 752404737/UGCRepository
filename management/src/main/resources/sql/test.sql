/*
 Navicat Premium Data Transfer

 Source Server         : czy
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 06/08/2019 14:01:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `question` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `writer` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `date` date DEFAULT NULL,
  `state` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `priority` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `dept` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `pm` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `dev` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `tester` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `lastsaved` date DEFAULT NULL,
  `uptime` date DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 44 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES (1, '移动端ios修改', '修改', '移动端ios问题', '苏宸', '2019-07-11', '开发中', '中', '研发部', '陈伟', '陈伟', '陈伟', NULL, NULL);
INSERT INTO `question` VALUES (2, '移动端ios修改', '修改', '移动端ios问题', '陈伟', '2019-07-12', '开发中', '低', '研发部', '陈伟', '陈伟', '陈伟', NULL, NULL);
INSERT INTO `question` VALUES (3, '项目重构', '修改', '移动端ios问题', '苏宸', '2019-07-13', '待开发', '高', '研发部', '陈伟', '陈伟', '陈伟', NULL, NULL);
INSERT INTO `question` VALUES (4, '安卓端测试', '修改', '移动端安卓问题', '杭杭', '2019-07-14', '测试中', '中', '研发部', '陈伟', '陈伟', '陈伟', NULL, NULL);
INSERT INTO `question` VALUES (5, '安卓代码验收', '修改', '移动端安卓问题', '凯特', '2019-07-15', '等待上线', '高', '研发部', '陈伟', '陈伟', '陈伟', NULL, '2019-08-26');
INSERT INTO `question` VALUES (6, 'hadoop环境bug修复', '修改', '大数据研发问题', '子威', '2019-07-16', '开发中', '高', '研发部', '陈伟', '陈伟', '陈伟', NULL, NULL);
INSERT INTO `question` VALUES (7, '物联网平台开发', '修改', '物联网研发问题', '冉彤', '2019-07-17', '等待上线', '低', '研发部', '陈伟', '陈伟', '陈伟', NULL, '2019-08-30');
INSERT INTO `question` VALUES (8, '移动端ios重构', '修改', '移动端ios问题', '佳美', '2019-07-18', '已完成', '中', '研发部', '陈伟', '陈伟', '陈伟', NULL, '2019-08-30');
INSERT INTO `question` VALUES (9, '移动端ios修改', '修改', '移动端ios问题', '苏宸', '2019-07-19', '未开始', '中', '研发部', '陈伟', '陈伟', '陈伟', NULL, NULL);
INSERT INTO `question` VALUES (10, '移动端ios修改', '修改', '移动端ios问题', '苏宸', '2019-07-20', '项目规划中', '中', '研发部', '陈伟', '陈伟', '陈伟', NULL, NULL);
INSERT INTO `question` VALUES (11, '移动端ios修改', '修改', '移动端ios问题', '苏宸', '2019-07-21', '待开发', '中', '研发部', '陈伟', '陈伟', '陈伟', NULL, NULL);
INSERT INTO `question` VALUES (12, '移动端ios修改', '修改', '移动端ios问题', '苏宸', '2019-07-22', '待验收', '中', '研发部', '陈伟', '陈伟', '陈伟', NULL, NULL);
INSERT INTO `question` VALUES (13, '移动端ios修改', '修改', '移动端ios问题', '苏宸', '2019-07-23', '等待测试', '中', '研发部', '陈伟', '陈伟', '陈伟', NULL, NULL);
INSERT INTO `question` VALUES (14, '移动端ios修改', '修改', '移动端ios问题', '苏宸', '2019-07-24', '线上测试中', '中', '研发部', '陈伟', '陈伟', '陈伟', NULL, NULL);
INSERT INTO `question` VALUES (42, '安卓代码验收', '修改', '移动端安卓问题', '凯特', '2019-08-06', '等待上线', '高', '研发部', '陈伟', '陈伟', '陈伟', NULL, '2019-08-26');
INSERT INTO `question` VALUES (43, 'IOS代码验收', '修改', '移动端安卓问题', '凯特', '2019-08-06', '等待上线', '高', '研发部', '陈伟', '陈伟', '陈伟', NULL, '2019-08-26');

SET FOREIGN_KEY_CHECKS = 1;
