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

 Date: 13/08/2019 08:17:48
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
INSERT INTO `question` VALUES ('IP-001', '移动端ios代码修改', '代码修改', '移动端ios问题', '苏宸', '2019-07-11', '待测试', '中', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', '2019-08-12', NULL, 'IP-005');
INSERT INTO `question` VALUES ('IP-002', '移动端ios接口修改', '代码修改', '移动端ios问题', '苏宸', '2019-07-12', '待研发', '中', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, NULL, 'IP-001');
INSERT INTO `question` VALUES ('IP-003', '移动端ios配置修改', '代码修改', '移动端ios问题', '苏宸', '2019-07-13', '研发中', '中', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, NULL, NULL);
INSERT INTO `question` VALUES ('IP-004', '移动端ios重构', '代码修改', '移动端ios问题', '苏宸', '2019-07-14', '待测试', '中', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, NULL, NULL);
INSERT INTO `question` VALUES ('IP-005', '移动端ios代码优化', '代码修改', '移动端ios问题', '苏宸', '2019-07-15', '待测试', '中', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, NULL, NULL);
INSERT INTO `question` VALUES ('IP-006', '移动端ios框架配置', '代码修改', '移动端ios问题', '苏宸', '2019-07-16', '已完成', '中', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, NULL, NULL);
INSERT INTO `question` VALUES ('IP-007', '移动端ios修改', '代码修改', '移动端ios问题', '陈伟', '2019-07-17', '开发中', '低', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, NULL, NULL);
INSERT INTO `question` VALUES ('IP-008', '项目重构', '代码修改', '移动端ios问题', '苏宸', '2019-07-18', '待开发', '高', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, NULL, NULL);
INSERT INTO `question` VALUES ('IP-009', '安卓端测试', '代码修改', '移动端安卓问题', '杭杭', '2019-07-19', '测试中', '中', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, NULL, NULL);
INSERT INTO `question` VALUES ('IP-010', '安卓代码验收', '代码修改', '移动端安卓问题', '凯特', '2019-07-20', '已完成', '高', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, '2019-08-26', NULL);
INSERT INTO `question` VALUES ('IP-011', 'IOS代码验收', '代码修改', '移动端安卓问题', '凯特', '2019-07-21', '已完成', '高', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, '2019-08-26', NULL);
INSERT INTO `question` VALUES ('IP-012', '安卓代码验收', '代码修改', '移动端安卓问题', '凯特', '2019-07-22', '已完成', '高', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, '2019-08-26', NULL);
INSERT INTO `question` VALUES ('IP-013', 'hadoop环境bug修复', '代码修改', '大数据研发问题', '子威', '2019-07-23', '开发中', '高', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, NULL, NULL);
INSERT INTO `question` VALUES ('IP-014', '物联网平台开发', '代码修改', '物联网研发问题', '冉彤', '2019-07-24', '等待上线中', '低', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, '2019-08-30', NULL);
INSERT INTO `question` VALUES ('IP-015', '移动端ios重构', '代码修改', '移动端ios问题', '佳美', '2019-07-25', '已完成', '中', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, '2019-08-30', NULL);
INSERT INTO `question` VALUES ('IP-016', '安卓端测试', '代码修改', '移动端安卓问题', '易杭杭', '2019-07-19', '测试中', '中', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, NULL, NULL);
INSERT INTO `question` VALUES ('IP-017', '安卓代码验收', '代码修改', '移动端安卓问题', '苏宸', '2019-07-20', '已完成', '高', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, '2019-08-26', NULL);
INSERT INTO `question` VALUES ('IP-018', 'IOS代码验收', '代码修改', '移动端安卓问题', '谢鲁圣', '2019-07-21', '等待上线中', '低', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, '2019-08-26', NULL);
INSERT INTO `question` VALUES ('IP-019', '安卓代码验收', '代码修改', '移动端安卓问题', '徐凯特', '2019-07-22', '已完成', '高', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, '2019-08-26', NULL);
INSERT INTO `question` VALUES ('IP-020', '安卓端测试', '代码修改', '移动端安卓问题', '易杭杭', '2019-07-19', '测试中', '中', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, NULL, NULL);
INSERT INTO `question` VALUES ('IP-021', '安卓代码验收', '代码修改', '移动端安卓问题', '陈珍益', '2019-07-20', '等待上线中', '低', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, '2019-08-26', NULL);
INSERT INTO `question` VALUES ('IP-022', 'IOS代码验收', '代码修改', '移动端安卓问题', '王子威', '2019-07-21', '已完成', '高', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, '2019-08-26', NULL);
INSERT INTO `question` VALUES ('IP-023', '安卓代码验收', '代码修改', '移动端安卓问题', '徐凯特', '2019-07-22', '等待上线中', '中', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, '2019-08-26', NULL);
INSERT INTO `question` VALUES ('IP-024', '移动端ios代码修改', '代码修改', '移动端ios问题', '易杭杭', '2019-07-11', '研发中', '高', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, NULL, NULL);
INSERT INTO `question` VALUES ('IP-025', '移动端ios接口修改', '代码修改', '移动端ios问题', '苏宸', '2019-07-12', '待研发', '中', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, NULL, NULL);
INSERT INTO `question` VALUES ('IP-026', '移动端ios配置修改', '代码修改', '移动端ios问题', '谢鲁圣', '2019-07-13', '待开发', '低', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, NULL, NULL);
INSERT INTO `question` VALUES ('IP-027', '移动端ios重构', '代码修改', '移动端ios问题', '徐凯特', '2019-07-14', '待测试', '中', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, NULL, NULL);
INSERT INTO `question` VALUES ('IP-028', '移动端ios代码优化', '代码修改', '移动端ios问题', '陈珍益', '2019-07-15', '等待测试中', '低', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, NULL, NULL);
INSERT INTO `question` VALUES ('IP-029', '移动端ios框架配置', '代码修改', '移动端ios问题', '王子威', '2019-07-16', '已完成', '高', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, NULL, NULL);
INSERT INTO `question` VALUES ('IP-030', '移动端ios修改', '代码修改', '移动端ios问题', '徐凯特', '2019-07-17', '开发中', '低', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, NULL, NULL);
INSERT INTO `question` VALUES ('IP-031', '项目重构', '代码修改', '移动端ios问题', '易杭杭', '2019-07-18', '待开发', '高', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, NULL, NULL);
INSERT INTO `question` VALUES ('IP-032', '移动端ios代码修改', '代码修改', '移动端ios问题', '王子威', '2019-07-11', '研发中', '低', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, NULL, NULL);
INSERT INTO `question` VALUES ('IP-033', '移动端ios接口修改', '代码修改', '移动端ios问题', '陈珍益', '2019-07-12', '待研发', '高', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, NULL, NULL);
INSERT INTO `question` VALUES ('IP-034', '移动端ios配置修改', '代码修改', '移动端ios问题', '谢鲁圣', '2019-07-13', '待开发', '中', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, NULL, NULL);
INSERT INTO `question` VALUES ('IP-035', '移动端ios重构', '代码修改', '移动端ios问题', '易杭杭', '2019-07-14', '待测试', '低', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, NULL, NULL);
INSERT INTO `question` VALUES ('IP-036', '移动端ios代码优化', '代码修改', '移动端ios问题', '陈珍益', '2019-07-15', '等待测试中', '中', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, NULL, NULL);
INSERT INTO `question` VALUES ('IP-037', '移动端ios框架配置', '代码修改', '移动端ios问题', '苏宸', '2019-07-16', '已完成', '高', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, NULL, NULL);
INSERT INTO `question` VALUES ('IP-038', '移动端ios修改', '代码修改', '移动端ios问题', '徐凯特', '2019-07-17', '开发中', '低', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, NULL, NULL);
INSERT INTO `question` VALUES ('IP-039', '项目重构', '代码修改', '移动端ios问题', '易杭杭', '2019-07-18', '待开发', '高', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, NULL, NULL);
INSERT INTO `question` VALUES ('IP-040', 'hadoop环境bug修复', '代码修改', '大数据研发问题', '王子威', '2019-07-23', '开发中', '高', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, NULL, NULL);
INSERT INTO `question` VALUES ('IP-041', 'hadoop环境bug修复', '代码修改', '大数据研发问题', '吴萍萍', '2019-07-24', '开发中', '中', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, NULL, NULL);
INSERT INTO `question` VALUES ('IP-042', 'hadoop环境bug修复', '代码修改', '大数据研发问题', '诸冉彤', '2019-08-23', '开发中', '低', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, NULL, NULL);
INSERT INTO `question` VALUES ('IP-043', 'hadoop环境bug修复', '代码修改', '大数据研发问题', '谢鲁圣', '2019-07-29', '开发中', '高', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, NULL, NULL);
INSERT INTO `question` VALUES ('IP-044', 'hadoop环境bug修复', '代码修改', '大数据研发问题', '陈珍益', '2019-09-02', '开发中', '中', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, NULL, NULL);
INSERT INTO `question` VALUES ('IP-045', 'hadoop环境bug修复', '代码修改', '大数据研发问题', '王子威', '2019-10-11', '开发中', '低', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, NULL, NULL);
INSERT INTO `question` VALUES ('IP-046', 'hadoop环境bug修复', '代码修改', '大数据研发问题', '陈伟', '2019-07-21', '开发中', '高', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, NULL, NULL);
INSERT INTO `question` VALUES ('IP-047', 'hadoop环境bug修复', '代码修改', '大数据研发问题', '吴萍萍', '2019-12-23', '开发中', '高', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, NULL, NULL);
INSERT INTO `question` VALUES ('IP-048', 'hadoop环境bug修复', '代码修改', '大数据研发问题', '陈珍益', '2019-11-23', '开发中', '中', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, NULL, NULL);
INSERT INTO `question` VALUES ('IP-049', 'hadoop环境bug修复', '代码修改', '大数据研发问题', '诸冉彤', '2019-09-23', '开发中', '低', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, NULL, NULL);
INSERT INTO `question` VALUES ('IP-050', '物联网平台开发', '代码修改', '物联网研发问题', '王子威', '2019-07-23', '已完成', '高', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, '2019-08-30', NULL);
INSERT INTO `question` VALUES ('IP-051', '物联网平台开发', '代码修改', '物联网研发问题', '吴萍萍', '2019-07-24', '已完成', '中', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, '2019-08-30', NULL);
INSERT INTO `question` VALUES ('IP-052', '物联网平台开发', '代码修改', '物联网研发问题', '诸冉彤', '2019-08-23', '等待上线中', '低', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, '2019-08-30', NULL);
INSERT INTO `question` VALUES ('IP-053', '物联网平台开发', '代码修改', '物联网研发问题', '谢鲁圣', '2019-07-29', '已完成', '高', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, '2019-08-30', NULL);
INSERT INTO `question` VALUES ('IP-054', '物联网平台开发', '代码修改', '物联网研发问题', '陈珍益', '2019-09-02', '已完成', '中', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, '2019-08-30', NULL);
INSERT INTO `question` VALUES ('IP-055', '物联网平台开发', '代码修改', '物联网研发问题', '王子威', '2019-10-11', '等待上线中', '低', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, '2019-08-30', NULL);
INSERT INTO `question` VALUES ('IP-056', '物联网平台开发', '代码修改', '物联网研发问题', '陈佳美', '2019-07-23', '已完成', '高', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, '2019-08-30', NULL);
INSERT INTO `question` VALUES ('IP-057', '物联网平台开发', '代码修改', '物联网研发问题', '王子威', '2019-07-24', '等待上线中', '中', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, '2019-08-30', NULL);
INSERT INTO `question` VALUES ('IP-058', '物联网平台开发', '代码修改', '物联网研发问题', '吴萍萍', '2019-07-23', '等待上线中', '低', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, '2019-08-30', NULL);
INSERT INTO `question` VALUES ('IP-059', '物联网平台开发', '代码修改', '物联网研发问题', '诸冉彤', '2019-07-24', '已完成', '高', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, '2019-08-30', NULL);
INSERT INTO `question` VALUES ('IP-060', '物联网平台开发', '代码修改', '物联网研发问题', '谢鲁圣', '2019-08-23', '等待上线中', '中', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, '2019-08-30', NULL);
INSERT INTO `question` VALUES ('IP-061', '物联网平台开发', '代码修改', '物联网研发问题', '陈珍益', '2019-07-29', '等待上线中', '低', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, '2019-08-30', NULL);
INSERT INTO `question` VALUES ('IP-062', '物联网平台开发', '代码修改', '物联网研发问题', '王子威', '2019-09-02', '线上测试中', '高', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, '2019-08-30', NULL);
INSERT INTO `question` VALUES ('IP-063', '物联网平台开发', '代码修改', '物联网研发问题', '陈佳美', '2019-07-23', '等待上线中', '中', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, '2019-08-30', NULL);
INSERT INTO `question` VALUES ('IP-064', '物联网平台开发', '代码修改', '物联网研发问题', '王子威', '2019-07-24', '等待上线中', '低', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, '2019-08-30', NULL);
INSERT INTO `question` VALUES ('IP-065', '物联网平台开发', '代码修改', '物联网研发问题', '吴萍萍', '2019-08-23', '等待上线中', '高', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, '2019-08-30', NULL);
INSERT INTO `question` VALUES ('IP-066', '物联网平台开发', '代码修改', '物联网研发问题', '诸冉彤', '2019-07-29', '等待上线中', '中', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, '2019-08-30', NULL);
INSERT INTO `question` VALUES ('IP-067', '物联网平台开发', '代码修改', '物联网研发问题', '谢鲁圣', '2019-09-02', '等待上线中', '低', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, '2019-08-30', NULL);
INSERT INTO `question` VALUES ('IP-068', '物联网平台开发', '代码修改', '物联网研发问题', '陈珍益', '2019-10-11', '等待上线中', '高', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, '2019-08-30', NULL);
INSERT INTO `question` VALUES ('IP-069', '物联网平台开发', '代码修改', '物联网研发问题', '王子威', '2019-07-23', '等待上线中', '中', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, '2019-08-30', NULL);
INSERT INTO `question` VALUES ('IP-070', '物联网平台开发', '代码修改', '物联网研发问题', '陈佳美', '2019-07-24', '等待上线中', '低', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, '2019-08-30', NULL);
INSERT INTO `question` VALUES ('IP-071', '物联网平台开发', '代码修改', '物联网研发问题', '王子威', '2019-07-23', '等待上线中', '高', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, '2019-08-30', NULL);
INSERT INTO `question` VALUES ('IP-072', '物联网平台开发', '代码修改', '物联网研发问题', '吴萍萍', '2019-07-24', '等待上线中', '中', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, '2019-08-30', NULL);
INSERT INTO `question` VALUES ('IP-073', '物联网平台开发', '代码修改', '物联网研发问题', '诸冉彤', '2019-08-23', '等待上线中', '低', '研发部', '谢鲁圣', '陈伟;徐凯特', '易杭杭', NULL, '2019-08-30', NULL);

SET FOREIGN_KEY_CHECKS = 1;
