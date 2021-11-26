/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : student-manager

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 31/10/2021 08:51:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for clazz
-- ----------------------------
DROP TABLE IF EXISTS `clazz`;
CREATE TABLE `clazz`  (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `grade` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `clazz` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `headTeacher` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `totalStudent` int(10) NOT NULL,
  `currentTotalStudent` int(10) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of clazz
-- ----------------------------
INSERT INTO `clazz` VALUES (1, '大一', '软件21-1', '张三', 60, 0);
INSERT INTO `clazz` VALUES (2, '大一', '软件21-2', '李四', 60, 0);
INSERT INTO `clazz` VALUES (3, '大一', '软件21-3', '王五', 60, 0);
INSERT INTO `clazz` VALUES (4, '大一', '软件21-4', '赵六', 60, 0);
INSERT INTO `clazz` VALUES (5, '大二', '软件20-1', '张三', 60, 0);
INSERT INTO `clazz` VALUES (6, '大二', '软件20-2', '张三', 60, 2);
INSERT INTO `clazz` VALUES (7, '大二', '软件20-3', '张三', 60, 1);
INSERT INTO `clazz` VALUES (9, '大三', '软件19-1', '张俊晖', 60, 3);
INSERT INTO `clazz` VALUES (10, '大三', '软件19-2', '廖若飞', 60, 0);
INSERT INTO `clazz` VALUES (11, '大三', '软件19-3', '张光辉', 60, 1);
INSERT INTO `clazz` VALUES (12, '大三', '软件19-4', '刘云', 1, 0);
INSERT INTO `clazz` VALUES (13, '大三', '软件19-5', '王森', 2, 0);
INSERT INTO `clazz` VALUES (14, '大三', '计网19-1', '张三', 60, 0);
INSERT INTO `clazz` VALUES (15, '大三', '计网19-2', '李四', 60, 0);
INSERT INTO `clazz` VALUES (16, '大三', '计网19-3', '王五', 60, 0);
INSERT INTO `clazz` VALUES (17, '大三', '数媒19-1', '李爽', 60, 0);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `age` int(3) NOT NULL,
  `sex` int(1) NOT NULL,
  `num` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `grade` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `clazz` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `address` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `num`(`num`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, '李爽', 20, 1, '19604076', '大三', '软件19-1', '四川省攀枝花市东区');
INSERT INTO `student` VALUES (2, '杨继顺', 20, 1, '19405076', '大三', '软件19-1', '四川省巴中市');
INSERT INTO `student` VALUES (6, '陈思源', 21, 1, '19402222', '大三', '软件19-1', '四川省广安市');
INSERT INTO `student` VALUES (7, '张三', 22, 1, '19604055', '大三', '软件19-3', '成都');
INSERT INTO `student` VALUES (8, '李四', 23, 1, '19604456', '大二', '软件20-3', '四川');
INSERT INTO `student` VALUES (9, '二妞', 22, 0, '19347265', '大二', '软件20-2', '四川省成都');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `age` int(3) NOT NULL,
  `sex` int(1) NOT NULL,
  `num` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `course` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `num`(`num`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1, '张三', 30, 1, '10000', 'Java程序设计');
INSERT INTO `teacher` VALUES (2, '张老师', 45, 1, '10086', 'C++');
INSERT INTO `teacher` VALUES (3, '李老师', 20, 1, '19604076', 'Java程序设计');
INSERT INTO `teacher` VALUES (4, '周奇墨', 45, 1, '10928364', 'Java程序设计');
INSERT INTO `teacher` VALUES (5, '袁进', 40, 1, '88888888', 'HTML静态网页设计');
INSERT INTO `teacher` VALUES (6, '尤雨溪', 30, 1, '66666666', 'Vue从入门到实战');
INSERT INTO `teacher` VALUES (8, '廖雪峰', 30, 1, '66666667', 'Javascript编程艺术');

-- ----------------------------
-- Table structure for token
-- ----------------------------
DROP TABLE IF EXISTS `token`;
CREATE TABLE `token`  (
  `token` varchar(225) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `user_id` int(9) NOT NULL,
  PRIMARY KEY (`token`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `token_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of token
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'JohnCena', '123456', '李爽', 'http://r0zy8iurz.hd-bkt.clouddn.com/Java文章图标.jpg');
INSERT INTO `user` VALUES (2, 'Admin', '123456', '张三', 'http://r0zy8iurz.hd-bkt.clouddn.com/Java文章图标.jpg');

SET FOREIGN_KEY_CHECKS = 1;
