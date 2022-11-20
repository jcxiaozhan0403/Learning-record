/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : courseware

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 11/08/2021 23:38:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cw_courseware
-- ----------------------------
DROP TABLE IF EXISTS `cw_courseware`;
CREATE TABLE `cw_courseware`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` decimal(10, 2) NOT NULL DEFAULT 0.00,
  `count` int(0) NULL DEFAULT 0,
  `url` varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `cover` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `is_carousel` int(0) NULL DEFAULT 0,
  `carousel_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cw_courseware
-- ----------------------------
INSERT INTO `cw_courseware` VALUES (1, 'JAVA核心面试知识整理', 0.99, 1, '/courseware/resource/JAVA核心面试知识整理.pdf ', '2021-02-18 13:55:11', '/courseware/cover/java_hexin.png', 1, '/courseware/carousel/1.jpg');
INSERT INTO `cw_courseware` VALUES (4, '2021Java面试题大全', 0.99, 0, '/courseware/resource/Java面试题大全（2021年）.pdf', '2021-02-18 13:55:11', '/courseware/cover/java_ms.png', 2, '/courseware/carousel/2.jpg');
INSERT INTO `cw_courseware` VALUES (20, '深入理解MySQL核心技术', 0.99, 0, '/courseware/resource/[深入理解MySQL核心技术].pdf', '2021-02-20 21:56:14', '/courseware/cover/mysql.jpg', 3, '/courseware/carousel/3.jpg');
INSERT INTO `cw_courseware` VALUES (21, '软件设计师考点精炼', 0.99, 0, '/courseware/resource/软件设计师考点精炼.pdf', '2021-08-07 17:57:52', '/courseware/cover/ruan.jpg', 0, '');

SET FOREIGN_KEY_CHECKS = 1;
