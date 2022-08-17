CREATE DATABASE `test08` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;

USE `test08`;


DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(25) COLLATE utf8mb4_bin DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;


insert  into `user`(`id`,`username`,`age`) values (2,'张三',26);
