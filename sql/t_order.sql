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

/*Table structure for table `t_order` */

DROP TABLE IF EXISTS `t_order`;

CREATE TABLE `t_order` (
  `id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL COMMENT 'id',
  `bookid` int(11) NOT NULL COMMENT 'id',
  `sum` int(11) NOT NULL DEFAULT '1',
  `send_check` int(2) NOT NULL DEFAULT '0',
  `upload_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `t_order` */

insert  into `t_order`(`id`,`userid`,`bookid`,`sum`,`send_check`,`upload_time`) values (1,1,1,1,0,'2018-01-10 14:41:19'),(5,1,2,1,0,'2018-01-11 15:13:03'),(6,1,1,1,0,'2018-01-11 15:13:03'),(9,5,2,1,0,'2021-11-24 12:21:23');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
