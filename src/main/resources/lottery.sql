
/*创建lottery数据库*/
CREATE DATABASE IF NOT EXISTS lottery DEFAULT CHARSET 'utf8';

/*使用数据库lottery*/
use lottery;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) DEFAULT NULL,
  `number` VARCHAR(30) DEFAULT NULL,
  `phone` varchar(150) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `isValid` enum('0','1') DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `prize`;
CREATE TABLE `prize` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `prizeName` VARCHAR(50) DEFAULT NULL,
  `prizeNumber` VARCHAR(30) DEFAULT NULL,
  `tag` varchar(150) DEFAULT NULL,
  `isValid` enum('0','1') DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(50) DEFAULT NULL,
  `password` VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT into admin(username,password) VALUES("admin","admin");
