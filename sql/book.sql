/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.7.35 : Database - hm
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hm` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `hm`;

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `typeId` int(11) NOT NULL DEFAULT '1' COMMENT 'id',
  `bookname` varchar(255) NOT NULL,
  `author` varchar(255) NOT NULL,
  `publisher` varchar(255) DEFAULT NULL,
  `publish_time` timestamp NULL DEFAULT NULL,
  `price` double NOT NULL,
  `priceoff` double DEFAULT '0',
  `ISBN` varchar(255) DEFAULT NULL,
  `description` text,
  `catalog` text,
  `img` varchar(255) DEFAULT 'assets/images/book-covers/05.jpg',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `book` */

insert  into `book`(`id`,`typeId`,`bookname`,`author`,`publisher`,`publish_time`,`price`,`priceoff`,`ISBN`,`description`,`catalog`,`img`) values (1,1,'Chinese','yanyibin','ceshi','1970-11-20 11:25:21',14,14.4,'123123','this is chinese text book','31221','assets/images/book-covers/04.jpg'),(2,1,'Math','luohao','2','2018-11-10 21:20:15',11,22,'wawewewe','this is math text book',NULL,'assets/images/book-covers/05.jpg'),(3,1,'CSDN','yyb','people',NULL,11,10.5,NULL,'technology book',NULL,'assets/images/book-covers/01.jpg'),(4,1,'CSDN pro','linus','people',NULL,11,10.5,NULL,'technology book',NULL,'assets/images/book-covers/02.jpg'),(5,1,'CSDN light','linus','people',NULL,15,10.7,NULL,'technology book',NULL,'assets/images/book-covers/03.jpg'),(14,2,'English','luxun','213123','2017-12-28 08:00:00',123,132,'12313213','this is english text book',' ','assets/images/book-covers/05.jpg');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
