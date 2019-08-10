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

 Date: 10/08/2019 15:35:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
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
  `connect` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES ('IP-001', '移动端ios修改', '修改', '移动端ios问题', '苏宸', '2019-07-11', '开发中', '中', '研发部', '陈伟', '陈伟', '陈伟', NULL, NULL, NULL);
INSERT INTO `question` VALUES ('IP-002', '移动端ios修改', '修改', '移动端ios问题', '苏宸', '2019-07-12', '项目规划中', '中', '研发部', '陈伟', '陈伟', '陈伟', NULL, NULL, NULL);
INSERT INTO `question` VALUES ('IP-003', '移动端ios修改', '修改', '移动端ios问题', '苏宸', '2019-07-13', '待开发', '中', '研发部', '陈伟', '陈伟', '陈伟', NULL, NULL, NULL);
INSERT INTO `question` VALUES ('IP-004', '移动端ios修改', '修改', '移动端ios问题', '苏宸', '2019-07-14', '待验收', '中', '研发部', '陈伟', '陈伟', '陈伟', NULL, NULL, NULL);
INSERT INTO `question` VALUES ('IP-005', '移动端ios修改', '修改', '移动端ios问题', '苏宸', '2019-07-15', '等待测试', '中', '研发部', '陈伟', '陈伟', '陈伟', NULL, NULL, NULL);
INSERT INTO `question` VALUES ('IP-006', '移动端ios修改', '修改', '移动端ios问题', '苏宸', '2019-07-16', '线上测试中', '中', '研发部', '陈伟', '陈伟', '陈伟', NULL, NULL, NULL);
INSERT INTO `question` VALUES ('IP-007', '移动端ios修改', '修改', '移动端ios问题', '陈伟', '2019-07-17', '开发中', '低', '研发部', '陈伟', '陈伟', '陈伟', NULL, NULL, NULL);
INSERT INTO `question` VALUES ('IP-008', '项目重构', '修改', '移动端ios问题', '苏宸', '2019-07-18', '待开发', '高', '研发部', '陈伟', '陈伟', '陈伟', NULL, NULL, NULL);
INSERT INTO `question` VALUES ('IP-009', '安卓端测试', '修改', '移动端安卓问题', '杭杭', '2019-07-19', '测试中', '中', '研发部', '陈伟', '陈伟', '陈伟', NULL, NULL, NULL);
INSERT INTO `question` VALUES ('IP-010', '安卓代码验收', '修改', '移动端安卓问题', '凯特', '2019-07-20', '等待上线', '高', '研发部', '陈伟', '陈伟', '陈伟', NULL, '2019-08-26', NULL);
INSERT INTO `question` VALUES ('IP-011', 'IOS代码验收', '修改', '移动端安卓问题', '凯特', '2019-07-21', '等待上线', '高', '研发部', '陈伟', '陈伟', '陈伟', NULL, '2019-08-26', NULL);
INSERT INTO `question` VALUES ('IP-012', '安卓代码验收', '修改', '移动端安卓问题', '凯特', '2019-07-22', '等待上线', '高', '研发部', '陈伟', '陈伟', '陈伟', NULL, '2019-08-26', NULL);
INSERT INTO `question` VALUES ('IP-013', 'hadoop环境bug修复', '修改', '大数据研发问题', '子威', '2019-07-23', '开发中', '高', '研发部', '陈伟', '陈伟', '陈伟', NULL, NULL, NULL);
INSERT INTO `question` VALUES ('IP-014', '物联网平台开发', '修改', '物联网研发问题', '冉彤', '2019-07-24', '等待上线', '低', '研发部', '陈伟', '陈伟', '陈伟', NULL, '2019-08-30', NULL);
INSERT INTO `question` VALUES ('IP-015', '移动端ios重构', '修改', '移动端ios问题', '佳美', '2019-07-25', '已完成', '中', '研发部', '陈伟', '陈伟', '陈伟', NULL, '2019-08-30', NULL);
INSERT INTO `question` VALUES ('IP-016', '移动端ios修改', '修改', '移动端ios问题', '苏宸', '2019-07-26', '未开始', '中', '研发部', '陈伟', '陈伟', '陈伟', NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
