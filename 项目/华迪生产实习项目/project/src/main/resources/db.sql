/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : zxjy

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 04/09/2022 11:30:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for collect
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一主键',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `curriculum_id` int(11) NOT NULL COMMENT '课程ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of collect
-- ----------------------------
INSERT INTO `collect` VALUES (2, 1, 5);

-- ----------------------------
-- Table structure for curriculum
-- ----------------------------
DROP TABLE IF EXISTS `curriculum`;
CREATE TABLE `curriculum`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一主键',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程名',
  `sketch` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程简述',
  `cover` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程封面',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程资源地址',
  `lecturer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程讲师',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of curriculum
-- ----------------------------
INSERT INTO `curriculum` VALUES (1, '精足不思淫，气足不思食，神足不思眠”，老祖宗的养生之道', '暂无', 'https://s1.328888.xyz/2022/09/04/1bes7.jpg', '//player.bilibili.com/player.html?aid=513782183&bvid=BV1Mg411f7xC&cid=782808976&page=1', '国学秘籍', '科普');
INSERT INTO `curriculum` VALUES (3, '养肝护肝不用吃药打针，一杯茶就能帮您清肝火，解肝郁', '暂无', 'https://s1.328888.xyz/2022/09/04/1wnoR.jpg', '//player.bilibili.com/player.html?aid=37052374&bvid=BV1ot411Q7Uy&cid=65107664&page=1', '正君堂食疗坊', '科普');
INSERT INTO `curriculum` VALUES (4, '脾胃虚弱，常吃两物，脾胃慢慢变好！', '脾胃为人体气血生化之源！脾虚了，常吃它，脾胃慢慢变好！', 'https://s1.328888.xyz/2022/09/04/1wAeP.jpg', '//player.bilibili.com/player.html?aid=65407780&bvid=BV18441167uk&cid=113512009&page=1', '城哥说副业', '科普');
INSERT INTO `curriculum` VALUES (5, '医学基础知识', '【医学基础知识】【解剖学】 医学基础知识药学医疗卫生机构事业单位招聘备考学习生理学视频', 'https://s1.328888.xyz/2022/09/04/1wddj.jpg', '//player.bilibili.com/player.html?aid=426768246&bvid=BV1x3411P7Mu&cid=725946266&page=1', '贫尼虚竹', '专业课程');

-- ----------------------------
-- Table structure for mycourse
-- ----------------------------
DROP TABLE IF EXISTS `mycourse`;
CREATE TABLE `mycourse`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一主键ID',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `curriculum_id` int(11) NOT NULL COMMENT '课程ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of mycourse
-- ----------------------------
INSERT INTO `mycourse` VALUES (15, 1, 1);
INSERT INTO `mycourse` VALUES (16, 1, 1);
INSERT INTO `mycourse` VALUES (17, 1, 1);
INSERT INTO `mycourse` VALUES (18, 1, 1);
INSERT INTO `mycourse` VALUES (20, 1, 1);
INSERT INTO `mycourse` VALUES (22, 1, 4);
INSERT INTO `mycourse` VALUES (23, 1, 1);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一主键',
  `identity` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份名',
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份编码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '超级管理员', 'ADMIN');
INSERT INTO `role` VALUES (2, '普通用户', 'USER');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识符',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '唯一用户名',
  `pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `age` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '年龄',
  `sex` int(11) NULL DEFAULT NULL COMMENT '性别(0：女，1：男)',
  `mailbox` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `unmber` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `autograph` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '个性签名',
  `birthday` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生日日期',
  `time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '注册时间',
  `role` int(11) NULL DEFAULT 2 COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'JohnCena', '111111', '25', 1, '349636607@qq.com', '18982379506', '代码书写人生', '2001-4-3', '2021-11-6', 1);

SET FOREIGN_KEY_CHECKS = 1;
