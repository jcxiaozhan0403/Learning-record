CREATE TABLE `user` (
    `id` int(10) NOT NULL AUTO_INCREMENT,
    `username` varchar(20) NOT NULL,
    `sex` int(1) DEFAULT NULL,
    `age` int(3) DEFAULT NULL,
    `birthday` date DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;