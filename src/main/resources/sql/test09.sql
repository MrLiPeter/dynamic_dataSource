CREATE DATABASE IF NOT EXISTS `test09`  DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;

USE `test09`;



DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(25) COLLATE utf8mb4_bin DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;



insert  into `user`(`id`,`username`,`age`) values (1,'李四',28);


