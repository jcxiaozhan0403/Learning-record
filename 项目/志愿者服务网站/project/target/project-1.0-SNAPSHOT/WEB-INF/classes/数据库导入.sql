/*
MySQL Backup
Database: webapp1901
Backup Time: 2021-06-29 16:16:12
*/

SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `webapp1901`.`image`;
DROP TABLE IF EXISTS `webapp1901`.`log`;
DROP TABLE IF EXISTS `webapp1901`.`manager`;
DROP TABLE IF EXISTS `webapp1901`.`signin`;
DROP TABLE IF EXISTS `webapp1901`.`student`;
DROP TABLE IF EXISTS `webapp1901`.`user`;
CREATE TABLE `image` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(200) DEFAULT NULL,
  `name` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
CREATE TABLE `log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `time` datetime NOT NULL,
  `loginId` varchar(20) NOT NULL,
  `event` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `loginId` (`loginId`),
  CONSTRAINT `log_ibfk_1` FOREIGN KEY (`loginId`) REFERENCES `manager` (`loginId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;
CREATE TABLE `manager` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loginId` varchar(20) NOT NULL,
  `realName` varchar(10) DEFAULT NULL,
  `pwd` varchar(200) DEFAULT NULL,
  `loginCount` int(11) DEFAULT NULL,
  `lastLoginDt` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `manager_index1` (`loginId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
CREATE TABLE `signin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studentId` varchar(8) NOT NULL,
  `signDatetime` datetime NOT NULL,
  `signDate` date NOT NULL,
  `temperature` decimal(18,1) DEFAULT NULL,
  `working` int(11) NOT NULL,
  `hadTravel` int(11) NOT NULL,
  `address` varchar(100) DEFAULT NULL,
  `jkt` int(11) NOT NULL,
  `jktColor` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `signIn_index` (`studentId`,`signDate`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studentId` varchar(8) NOT NULL,
  `pwd` varchar(100) DEFAULT NULL,
  `name` varchar(20) NOT NULL,
  `gender` int(11) NOT NULL,
  `birthday` date NOT NULL,
  `mobile` char(11) NOT NULL,
  `address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `student_index1` (`studentId`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `mobile` char(11) NOT NULL,
  PRIMARY KEY (`id`,`userName`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
BEGIN;
LOCK TABLES `webapp1901`.`image` WRITE;
DELETE FROM `webapp1901`.`image`;
INSERT INTO `webapp1901`.`image` (`id`,`url`,`name`) VALUES (1, 'http://qv75p5139.hd-bkt.clouddn.com/bg1.jpg', 'page1'),(2, 'http://qv75p5139.hd-bkt.clouddn.com/bg2.jpg', 'page2'),(3, 'http://qv75p5139.hd-bkt.clouddn.com/bg3.jpg', 'page3'),(4, 'http://qv75p5139.hd-bkt.clouddn.com/bg4.jpg', 'login');
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `webapp1901`.`log` WRITE;
DELETE FROM `webapp1901`.`log`;
INSERT INTO `webapp1901`.`log` (`id`,`time`,`loginId`,`event`) VALUES (1, '2021-06-28 14:33:39', 'JohnCena', '创建log表'),(7, '2021-06-28 16:32:29', 'JohnCena', '添加用户'),(8, '2021-06-28 16:36:29', 'JohnCena', '修改用户Admin1'),(9, '2021-06-28 16:58:40', 'JohnCena', '修改用户Admin1'),(10, '2021-06-28 17:00:51', 'JohnCena', '添加新用户'),(11, '2021-06-28 17:15:18', 'JohnCena', '删除用户admin001'),(12, '2021-06-29 13:59:42', 'JohnCena', '修改文明川信背景图'),(13, '2021-06-29 13:59:55', 'JohnCena', '修改文明川信背景图');
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `webapp1901`.`manager` WRITE;
DELETE FROM `webapp1901`.`manager`;
INSERT INTO `webapp1901`.`manager` (`id`,`loginId`,`realName`,`pwd`,`loginCount`,`lastLoginDt`) VALUES (1, 'JohnCena', '李爽', 'd5477920f46f1b30f259cff2b1e25c04', 375, '2021-06-29 16:09:31'),(2, 'Admin1', '管理员', 'd5477920f46f1b30f259cff2b1e25c04', 11, '2021-05-26 08:10:00');
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `webapp1901`.`signin` WRITE;
DELETE FROM `webapp1901`.`signin`;
INSERT INTO `webapp1901`.`signin` (`id`,`studentId`,`signDatetime`,`signDate`,`temperature`,`working`,`hadTravel`,`address`,`jkt`,`jktColor`) VALUES (1, '19604076', '2021-04-14 16:10:38', '2021-04-14', NULL, 1, 0, NULL, 1, NULL);
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `webapp1901`.`student` WRITE;
DELETE FROM `webapp1901`.`student`;
INSERT INTO `webapp1901`.`student` (`id`,`studentId`,`pwd`,`name`,`gender`,`birthday`,`mobile`,`address`) VALUES (1, '19404025', NULL, '王坤', 1, '2001-01-01', '15390466220', NULL),(2, '19301147', NULL, '李家志', 1, '2001-01-01', '17745096571', NULL),(3, '19301079', NULL, '马昆', 1, '2001-01-01', '19960796404', NULL),(4, '19301152', NULL, '胡元鑫', 1, '2001-01-01', '17790409784', NULL),(5, '19301057', NULL, '郑健军', 1, '2001-01-01', '13608130135', NULL),(6, '19301156', NULL, '陶勇', 1, '2001-01-01', '18383189948', NULL),(7, '19301051', NULL, '刘芮豪', 1, '2001-01-01', '16608012037', NULL),(8, '19301144', NULL, '周圳南', 1, '2001-01-01', '18423068622', NULL),(9, '19301160', NULL, '廖希', 1, '2001-01-01', '17628639137', NULL),(10, '19604076', 'lishuang001219', '李爽', 1, '2001-01-01', '18982379506', NULL),(11, '19415010', NULL, '周强', 1, '2001-01-01', '17721995859', NULL),(12, '19301024', NULL, '袁杨', 1, '2001-01-01', '18349284026', NULL),(13, '19301058', NULL, '罗海人', 1, '2001-01-01', '13540549866', NULL),(14, '19301142', NULL, '余磊', 1, '2001-01-01', '18382458947', NULL),(15, '19301157', NULL, '陈泓如', 1, '2001-01-01', '18090984062', NULL),(16, '19301143', NULL, '汪怀玉', 1, '2001-01-01', '17345222716', NULL),(17, '19301070', NULL, '徐代藩', 1, '2001-01-01', '17666563520', NULL),(18, '19301204', NULL, '邓阳', 2, '2001-01-01', '13350433242', NULL),(19, '19404041', NULL, '李伟', 1, '2001-01-01', '15775726217', NULL),(20, '19405155', NULL, '陈思源', 1, '2001-01-01', '13458907615', NULL),(21, '19405076', NULL, '杨继顺', 1, '2001-01-01', '18090445117', NULL),(22, '19301021', NULL, '何雨林', 1, '2001-01-01', '13648067552', NULL),(23, '19301016', NULL, '朱锴', 1, '2001-01-01', '17745094117', NULL),(24, '19301017', NULL, '罗乙财', 1, '2001-01-01', '15756593857', NULL),(25, '19301205', NULL, '罗文贤', 1, '2001-01-01', '15828142923', NULL),(26, '19301176', NULL, '廖贤龙', 1, '2001-01-01', '17780483314', NULL),(27, '19301001', NULL, '江亨龙', 1, '2001-01-01', '18280424101', NULL),(28, '19301116', NULL, '郑伦攀', 1, '2001-01-01', '13648119034', NULL),(29, '19301072', NULL, '叶小春', 1, '2001-01-01', '18608249624', NULL),(30, '19301132', NULL, '王涛', 1, '2001-01-01', '17628627515', NULL),(31, '19301005', NULL, '李磊', 1, '2001-01-01', '18980540076', NULL),(32, '19131067', NULL, '杨国辉', 1, '2001-01-01', '17683297124', NULL),(33, '19206219', NULL, '彭明远', 1, '2001-01-01', '17628483471', NULL),(34, '19301015', NULL, '廖章涛', 1, '2001-01-01', '18380139716', NULL),(35, '19301041', NULL, '向贵敏', 1, '2001-01-01', '13419171453', NULL),(36, '19510003', NULL, '梁古强', 1, '2001-01-01', '17760032344', NULL),(37, '19510005', NULL, '王龙云', 1, '2001-01-01', '13086482808', NULL),(38, '19302028', NULL, '谢玲星', 2, '2001-01-01', '18081652389', NULL),(39, '19302076', NULL, '杨超', 1, '2001-01-01', '17581735542', NULL),(40, '19302152', NULL, '王红', 1, '2001-01-01', '17790409320', NULL),(41, '19401150', NULL, '廖超国', 1, '2001-01-01', '17398823925', NULL),(42, '19302155', NULL, '蒋经师', 1, '2001-01-01', '15381845143', NULL);
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `webapp1901`.`user` WRITE;
DELETE FROM `webapp1901`.`user`;
INSERT INTO `webapp1901`.`user` (`id`,`userName`,`name`,`mobile`) VALUES (1, 'JohnCena', '王五', '15984267843'),(2, 'Lose', '张三', '13684280806'),(3, 'Admin001', '李四', '13685247624');
UNLOCK TABLES;
COMMIT;
