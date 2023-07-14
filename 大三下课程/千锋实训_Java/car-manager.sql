/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : car-manager

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 05/07/2023 13:19:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `money` double NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('jerry', 1000);
INSERT INTO `account` VALUES ('tom', 1000);

-- ----------------------------
-- Table structure for bus_car
-- ----------------------------
DROP TABLE IF EXISTS `bus_car`;
CREATE TABLE `bus_car`  (
  `carnumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '车牌',
  `cartype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车辆类型',
  `color` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '颜色',
  `price` double(10, 2) NULL DEFAULT NULL COMMENT '车辆价格',
  `rentprice` double(10, 2) NULL DEFAULT NULL COMMENT '车辆租金',
  `deposit` double NULL DEFAULT NULL COMMENT '押金',
  `isrenting` int(11) NULL DEFAULT NULL COMMENT '是否租出(0未租出 1已租出)',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `carimg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车辆图片',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`carnumber`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bus_car
-- ----------------------------
INSERT INTO `bus_car` VALUES ('京A0000', 'suv', '红⾊', 300000.00, 800.00, 2000, 0, '宝⻢', '2023-07-04/202307041114344666770.jpg', '2022-11-13 11:40:50');
INSERT INTO `bus_car` VALUES ('京A66666', 'SUV', '红⾊', 280000.00, 500.00, 5000, 0, '宝⻢X1', 'images/001.png', '2022-11-07 14:52:15');
INSERT INTO `bus_car` VALUES ('京A77777', 'SUV', '⽩⾊', 350000.00, 1500.00, 12000, 0, '宝⻢X3', 'images/002.png', '2022-11-07 14:52:15');
INSERT INTO `bus_car` VALUES ('沪A88888', '轿⻋', '⿊⾊', 880000.00, 1000.00, 10000, 0, '保时捷 卡宴', 'images/003.png', '2022-11-07 14:52:15');

-- ----------------------------
-- Table structure for bus_check
-- ----------------------------
DROP TABLE IF EXISTS `bus_check`;
CREATE TABLE `bus_check`  (
  `checkid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `checkdate` datetime(0) NULL DEFAULT NULL,
  `checkdesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `problem` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `paymoney` double(255, 0) NULL DEFAULT NULL,
  `opername` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `rentid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createtime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`checkid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bus_check
-- ----------------------------
INSERT INTO `bus_check` VALUES ('JC_20220322_142814_147_8624', '2022-03-22 14:28:14', '222', '11', 100, '超级管理员', 'CZ_20220320_141553_303_8141', '2022-05-07 14:55:30');
INSERT INTO `bus_check` VALUES ('JC_20220611_111021_41215259', '2022-06-11 11:10:21', '没有1', '无1', 0, '超级管理员', 'CZ_20220611_094617_32192683', '2022-06-11 11:10:32');
INSERT INTO `bus_check` VALUES ('JC_20220718_091454_0191_93480', '2022-07-18 00:00:00', '无', '无', 0, '王五', 'CZ_20220718_091206_0365_62161', '2022-05-07 14:55:30');
INSERT INTO `bus_check` VALUES ('JC_20220727_173816_738_26810', '2022-07-27 17:38:16', '无1', '无1', 1, '超级管理员', 'CZ_20220727_152634_863_83662', '2022-07-27 17:38:24');
INSERT INTO `bus_check` VALUES ('JC_20220812_172559_0323_71959', '2022-06-13 00:00:00', '无', '无', 0, '王五', 'CZ_20220812_164747_0573_26177', '2022-05-07 14:55:30');
INSERT INTO `bus_check` VALUES ('JC_20220820_142450_572_41589', '2022-08-20 14:24:50', '正常', '无问题', 0, '千锋', 'CZ_20220820_142327_400_51213', '2022-08-20 14:25:10');
INSERT INTO `bus_check` VALUES ('JC_20220825_214343_455_88043', '2022-08-25 21:43:43', '123', '无', 0, '千锋', 'CZ_20220820_212458_083_86680', '2022-08-25 21:43:57');
INSERT INTO `bus_check` VALUES ('JC_20221024_170206_355_7589', '2022-10-24 17:02:06', '无', '无', 0, '超级管理员', 'CZ_20221024_102327_735_9111', '2022-05-07 14:55:30');
INSERT INTO `bus_check` VALUES ('JC_20221201_105333_218_89516', '2022-12-02 00:00:00', '1231321', '111122', 200, '超级管理员', 'CZ_20220812_164808_0385_37625', '2022-05-07 14:55:30');
INSERT INTO `bus_check` VALUES ('JC_20221201_111951_947_77152', '2022-12-03 00:00:00', '无', '无', 0, '超级管理员', 'CZ_20221201_111936_383_31565', '2022-05-07 14:55:30');
INSERT INTO `bus_check` VALUES ('JC_2022_0901_175053_57325085', '2022-09-01 00:00:00', '在G50 1127-1130段超速20%未达50%', '有违章未处理', 500, '超级管理员', 'CZ_2022_0901_175000_97637709', '2022-05-07 14:55:30');
INSERT INTO `bus_check` VALUES ('JC_20230704_162008_175_68939', '2023-07-04 16:20:08', '磨损', '磨损', 200, '千锋', 'CZ_20230704_113033_354_85127', '2023-07-04 16:20:20');
INSERT INTO `bus_check` VALUES ('JC_20230705_130833_771_94290', '2023-07-05 13:08:33', '剐蹭', '剐蹭', 100, '千锋', 'CZ_20220820_142535_142_33930', '2023-07-05 13:08:59');

-- ----------------------------
-- Table structure for bus_customer
-- ----------------------------
DROP TABLE IF EXISTS `bus_customer`;
CREATE TABLE `bus_customer`  (
  `identity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `custname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sex` double NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `career` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `createtime` datetime(0) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bus_customer
-- ----------------------------
INSERT INTO `bus_customer` VALUES ('421087133414144412', '张小明', 1, '北京', '13456788987', '程序员', '2022-11-07 14:52:24');
INSERT INTO `bus_customer` VALUES ('43131334113331131', '王小五', 1, '武汉', '13888888888', '科长', '2022-11-07 14:52:24');
INSERT INTO `bus_customer` VALUES ('431321199291331131', '张三', 1, '南京', '13431334113', '程序员', '2022-11-07 14:52:24');
INSERT INTO `bus_customer` VALUES ('431321199291331132', '孙策', 1, '长沙', '18982356242', '组长', '2022-11-07 14:52:24');
INSERT INTO `bus_customer` VALUES ('431341134191311314', '王小明', 1, '郑州', '13413131113', 'CEO', '2022-11-11 14:52:24');

-- ----------------------------
-- Table structure for bus_rent
-- ----------------------------
DROP TABLE IF EXISTS `bus_rent`;
CREATE TABLE `bus_rent`  (
  `rentid` varchar(765) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `price` double NULL DEFAULT NULL,
  `begindate` datetime(0) NULL DEFAULT NULL,
  `returndate` datetime(0) NULL DEFAULT NULL,
  `rentflag` double NULL DEFAULT NULL,
  `identity` varchar(765) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `carnumber` varchar(765) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `opername` varchar(765) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `createtime` datetime(0) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bus_rent
-- ----------------------------
INSERT INTO `bus_rent` VALUES ('CZ_20220820_142535_142_33930', 1111, '2022-08-20 14:25:35', '2022-08-17 00:00:00', 1, '421087133414144412', '京A0000', '千锋', '2022-08-20 14:25:44');
INSERT INTO `bus_rent` VALUES ('CZ_20220820_152207_989_73622', 800, '2022-08-20 15:22:07', '2022-08-17 00:00:00', 0, '43131334113331131', '京A0000', '千锋', '2022-08-20 15:22:15');
INSERT INTO `bus_rent` VALUES ('CZ_20220820_152221_620_78063', 800, '2022-08-20 15:22:21', '2022-08-24 00:00:00', 0, '421087133414144412', '京A66666', '千锋', '2022-08-20 15:22:27');
INSERT INTO `bus_rent` VALUES ('CZ_20220820_152231_076_51761', 3000, '2022-08-20 15:22:31', '2022-08-10 00:00:00', 0, '421087133414144412', '沪A99999', '千锋', '2022-08-20 15:22:36');
INSERT INTO `bus_rent` VALUES ('CZ_20220820_152249_892_77610', 2000, '2022-08-28 15:22:49', '2022-08-31 00:00:00', 0, '421087133414144412', '沪A88888', '千锋', '2022-08-20 15:23:10');

-- ----------------------------
-- Table structure for sys_log_login
-- ----------------------------
DROP TABLE IF EXISTS `sys_log_login`;
CREATE TABLE `sys_log_login`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loginname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `loginip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `logintime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 47 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of sys_log_login
-- ----------------------------
INSERT INTO `sys_log_login` VALUES (5, '超级管理员-admin', '127.0.0.1', '2022-12-10 10:18:31');
INSERT INTO `sys_log_login` VALUES (6, '超级管理员-admin', '127.0.0.1', '2022-12-10 10:21:26');
INSERT INTO `sys_log_login` VALUES (7, '超级管理员-admin', '127.0.0.1', '2022-12-10 10:22:20');
INSERT INTO `sys_log_login` VALUES (8, '超级管理员-admin', '127.0.0.1', '2022-12-10 11:01:47');
INSERT INTO `sys_log_login` VALUES (9, '超级管理员-admin', '127.0.0.1', '2022-12-10 11:12:34');
INSERT INTO `sys_log_login` VALUES (10, '超级管理员-admin', '127.0.0.1', '2022-12-10 14:42:41');
INSERT INTO `sys_log_login` VALUES (11, '超级管理员-admin', '127.0.0.1', '2022-12-10 14:53:57');
INSERT INTO `sys_log_login` VALUES (12, '超级管理员-admin', '127.0.0.1', '2022-12-10 15:35:46');
INSERT INTO `sys_log_login` VALUES (13, '超级管理员-admin', '127.0.0.1', '2022-12-10 15:35:51');
INSERT INTO `sys_log_login` VALUES (14, '超级管理员-admin', '127.0.0.1', '2022-12-10 15:41:25');
INSERT INTO `sys_log_login` VALUES (15, '超级管理员-admin', '127.0.0.1', '2022-12-10 16:15:34');
INSERT INTO `sys_log_login` VALUES (16, '超级管理员-admin', '127.0.0.1', '2022-12-10 16:38:44');
INSERT INTO `sys_log_login` VALUES (17, '超级管理员-admin', '127.0.0.1', '2022-12-10 16:53:20');
INSERT INTO `sys_log_login` VALUES (18, '超级管理员-admin', '127.0.0.1', '2022-12-11 09:19:33');
INSERT INTO `sys_log_login` VALUES (19, '超级管理员-admin', '127.0.0.1', '2022-12-11 09:41:54');
INSERT INTO `sys_log_login` VALUES (20, '超级管理员-admin', '127.0.0.1', '2022-12-11 10:57:54');
INSERT INTO `sys_log_login` VALUES (21, '超级管理员-admin', '127.0.0.1', '2022-12-11 11:07:57');
INSERT INTO `sys_log_login` VALUES (22, '超级管理员-admin', '127.0.0.1', '2022-12-11 11:10:04');
INSERT INTO `sys_log_login` VALUES (23, '超级管理员-admin', '127.0.0.1', '2022-12-11 11:30:00');
INSERT INTO `sys_log_login` VALUES (24, '超级管理员-admin', '127.0.0.1', '2022-12-11 11:38:28');
INSERT INTO `sys_log_login` VALUES (25, '超级管理员-admin', '127.0.0.1', '2022-12-11 14:22:43');
INSERT INTO `sys_log_login` VALUES (26, '超级管理员-admin', '127.0.0.1', '2022-12-11 14:37:13');
INSERT INTO `sys_log_login` VALUES (28, 'qianfeng', '0:0:0:0:0:0:0:1', '2023-07-04 16:50:23');
INSERT INTO `sys_log_login` VALUES (29, 'qianfeng', '0:0:0:0:0:0:0:1', '2023-07-04 17:02:14');
INSERT INTO `sys_log_login` VALUES (30, 'qianfeng', '0:0:0:0:0:0:0:1', '2023-07-05 09:13:56');
INSERT INTO `sys_log_login` VALUES (31, 'qianfeng', '0:0:0:0:0:0:0:1', '2023-07-05 09:27:05');
INSERT INTO `sys_log_login` VALUES (32, 'qianfeng', '0:0:0:0:0:0:0:1', '2023-07-05 09:30:16');
INSERT INTO `sys_log_login` VALUES (33, 'qianfeng', '0:0:0:0:0:0:0:1', '2023-07-05 10:00:58');
INSERT INTO `sys_log_login` VALUES (34, 'qianfeng', '0:0:0:0:0:0:0:1', '2023-07-05 10:15:09');
INSERT INTO `sys_log_login` VALUES (35, 'qianfeng', '0:0:0:0:0:0:0:1', '2023-07-05 10:21:43');
INSERT INTO `sys_log_login` VALUES (36, 'qianfeng', '0:0:0:0:0:0:0:1', '2023-07-05 10:23:52');
INSERT INTO `sys_log_login` VALUES (37, 'qianfeng', '0:0:0:0:0:0:0:1', '2023-07-05 10:37:05');
INSERT INTO `sys_log_login` VALUES (38, 'qianfeng', '0:0:0:0:0:0:0:1', '2023-07-05 10:41:53');
INSERT INTO `sys_log_login` VALUES (39, 'qianfeng', '0:0:0:0:0:0:0:1', '2023-07-05 10:53:58');
INSERT INTO `sys_log_login` VALUES (40, 'qianfeng', '0:0:0:0:0:0:0:1', '2023-07-05 11:18:01');
INSERT INTO `sys_log_login` VALUES (41, 'qianfeng', '0:0:0:0:0:0:0:1', '2023-07-05 11:24:48');
INSERT INTO `sys_log_login` VALUES (42, 'qianfeng', '0:0:0:0:0:0:0:1', '2023-07-05 11:32:09');
INSERT INTO `sys_log_login` VALUES (43, 'qianfeng', '0:0:0:0:0:0:0:1', '2023-07-05 11:34:06');
INSERT INTO `sys_log_login` VALUES (44, 'qianfeng', '0:0:0:0:0:0:0:1', '2023-07-05 11:52:39');
INSERT INTO `sys_log_login` VALUES (45, 'qianfeng', '0:0:0:0:0:0:0:1', '2023-07-05 12:03:03');
INSERT INTO `sys_log_login` VALUES (46, 'qianfeng', '0:0:0:0:0:0:0:1', '2023-07-05 13:05:46');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `href` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `spread` int(255) NULL DEFAULT NULL COMMENT '0不展开1展开',
  `target` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `available` int(255) NULL DEFAULT NULL COMMENT '0不可⽤1可⽤',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, 0, '汽车出租系统', NULL, 1, NULL, '&#xe68e;', 1);
INSERT INTO `sys_menu` VALUES (2, 1, '基础管理', '', 1, '', '&#xe653;', 1);
INSERT INTO `sys_menu` VALUES (3, 1, '业务管理', '', 1, '', '&#xe663;', 1);
INSERT INTO `sys_menu` VALUES (4, 1, '系统管理', '', 0, '', '&#xe716;', 1);
INSERT INTO `sys_menu` VALUES (6, 2, '客户管理', '../bus/toCustomerManager.action', 0, '', '&#xe770;', 1);
INSERT INTO `sys_menu` VALUES (7, 2, '车辆管理', '../bus/toCarManager.action', 0, '', '&#xe657;', 1);
INSERT INTO `sys_menu` VALUES (8, 3, '汽车出租', '../bus/toRentCarManager.action', 1, '', '&#xe65b;', 1);
INSERT INTO `sys_menu` VALUES (9, 3, '出租单管理', '../bus/toRentManager.action', 0, '', '&#xe6b2;', 1);
INSERT INTO `sys_menu` VALUES (10, 3, '汽车入库', '../bus/toCheckCarManager.action', 0, '', '&#xe65a;', 1);
INSERT INTO `sys_menu` VALUES (11, 3, '检查单管理', '../bus/toCheckManager.action', 1, '', '&#xe705;', 1);
INSERT INTO `sys_menu` VALUES (12, 4, '菜单管理', '../sys/toMenuManager.action', 0, NULL, '&#xe60f;', 1);
INSERT INTO `sys_menu` VALUES (13, 4, '角色管理', '../sys/toRoleManager.action', 0, '', '&#xe66f;', 1);
INSERT INTO `sys_menu` VALUES (14, 4, '用户管理', '../sys/toUserManager.action', 0, '', '&#xe770;', 1);
INSERT INTO `sys_menu` VALUES (15, 4, '日志管理', '../sys/toLogInfoManager.action', 0, '', '&#xe655;', 1);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `roleid` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `rolename` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `roledesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  `available` int(11) NULL DEFAULT NULL COMMENT '是否可用',
  PRIMARY KEY (`roleid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '超级管理员', '拥有所有菜单权限', 1);
INSERT INTO `sys_role` VALUES (2, '业务管理员', '拥有所以业务菜单', 1);
INSERT INTO `sys_role` VALUES (3, '系统管理员', '管理系统', 1);
INSERT INTO `sys_role` VALUES (4, '数据统计管理员', '数据统计管理员', 1);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `rid` int(11) NOT NULL COMMENT '角色id',
  `mid` int(11) NOT NULL COMMENT '菜单id',
  PRIMARY KEY (`rid`, `mid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (1, 1);
INSERT INTO `sys_role_menu` VALUES (1, 2);
INSERT INTO `sys_role_menu` VALUES (1, 3);
INSERT INTO `sys_role_menu` VALUES (1, 4);
INSERT INTO `sys_role_menu` VALUES (1, 5);
INSERT INTO `sys_role_menu` VALUES (1, 6);
INSERT INTO `sys_role_menu` VALUES (1, 7);
INSERT INTO `sys_role_menu` VALUES (1, 8);
INSERT INTO `sys_role_menu` VALUES (1, 9);
INSERT INTO `sys_role_menu` VALUES (1, 10);
INSERT INTO `sys_role_menu` VALUES (1, 11);
INSERT INTO `sys_role_menu` VALUES (1, 12);
INSERT INTO `sys_role_menu` VALUES (1, 13);
INSERT INTO `sys_role_menu` VALUES (1, 14);
INSERT INTO `sys_role_menu` VALUES (1, 15);
INSERT INTO `sys_role_menu` VALUES (1, 16);
INSERT INTO `sys_role_menu` VALUES (1, 17);
INSERT INTO `sys_role_menu` VALUES (1, 18);
INSERT INTO `sys_role_menu` VALUES (1, 19);
INSERT INTO `sys_role_menu` VALUES (1, 20);
INSERT INTO `sys_role_menu` VALUES (2, 1);
INSERT INTO `sys_role_menu` VALUES (2, 2);
INSERT INTO `sys_role_menu` VALUES (2, 3);
INSERT INTO `sys_role_menu` VALUES (2, 6);
INSERT INTO `sys_role_menu` VALUES (2, 7);
INSERT INTO `sys_role_menu` VALUES (2, 8);
INSERT INTO `sys_role_menu` VALUES (2, 9);
INSERT INTO `sys_role_menu` VALUES (2, 10);
INSERT INTO `sys_role_menu` VALUES (2, 11);
INSERT INTO `sys_role_menu` VALUES (3, 1);
INSERT INTO `sys_role_menu` VALUES (3, 4);
INSERT INTO `sys_role_menu` VALUES (3, 12);
INSERT INTO `sys_role_menu` VALUES (3, 13);
INSERT INTO `sys_role_menu` VALUES (3, 14);
INSERT INTO `sys_role_menu` VALUES (3, 15);
INSERT INTO `sys_role_menu` VALUES (3, 16);
INSERT INTO `sys_role_menu` VALUES (3, 17);
INSERT INTO `sys_role_menu` VALUES (4, 1);
INSERT INTO `sys_role_menu` VALUES (4, 5);
INSERT INTO `sys_role_menu` VALUES (4, 18);
INSERT INTO `sys_role_menu` VALUES (4, 19);
INSERT INTO `sys_role_menu` VALUES (4, 20);

-- ----------------------------
-- Table structure for sys_role_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_user`;
CREATE TABLE `sys_role_user`  (
  `uid` int(11) NOT NULL,
  `rid` int(11) NOT NULL,
  PRIMARY KEY (`uid`, `rid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of sys_role_user
-- ----------------------------
INSERT INTO `sys_role_user` VALUES (3, 1);
INSERT INTO `sys_role_user` VALUES (4, 2);
INSERT INTO `sys_role_user` VALUES (5, 3);
INSERT INTO `sys_role_user` VALUES (6, 4);
INSERT INTO `sys_role_user` VALUES (7, 3);
INSERT INTO `sys_role_user` VALUES (7, 4);
INSERT INTO `sys_role_user` VALUES (8, 1);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `userid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `loginname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录名称',
  `identity` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号码',
  `realname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `sex` int(255) NULL DEFAULT NULL COMMENT '性别(0女1男)',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话号码',
  `pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码(密文)',
  `position` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位',
  `type` int(255) NULL DEFAULT 2 COMMENT '1，超级管理员,2，系统用户',
  `available` int(255) NULL DEFAULT NULL COMMENT '是否可用(1可用 0不可用)',
  PRIMARY KEY (`userid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'qianfeng', '4313341334413', '千锋', 1, '北京通州', '13520109202', 'e10adc3949ba59abbe56e057f20f883e', 'CEO', 1, 1);
INSERT INTO `sys_user` VALUES (2, 'lisi', '43311341311314341', '李四', 1, '武汉', '1341314113131', 'e10adc3949ba59abbe56e057f20f883e', '保洁', 2, 1);
INSERT INTO `sys_user` VALUES (3, 'wangwu', '4313133131331312', '王五', 1, '武汉', '13413131131', 'e10adc3949ba59abbe56e057f20f883e', '领导', 2, 1);
INSERT INTO `sys_user` VALUES (4, 'xiaoming', '45113141331131131', '小明', 0, '武昌', '13451333131', 'e10adc3949ba59abbe56e057f20f883e', '职员', 2, 1);
INSERT INTO `sys_user` VALUES (5, 'laowang', '41113113331133', '老王', 1, '北京', '13511333113', 'e10adc3949ba59abbe56e057f20f883e', '总裁', 2, 1);

SET FOREIGN_KEY_CHECKS = 1;
