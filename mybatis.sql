/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2020-05-28 10:38:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(255) DEFAULT NULL,
  `book_page` int(11) DEFAULT NULL,
  `book_price` double DEFAULT NULL,
  `book_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', 'Java编程思想', '1000', '79.4', '1');
INSERT INTO `book` VALUES ('2', 'jk', '600', '90', '1');
INSERT INTO `book` VALUES ('3', 'time selecter', '900', '900', '2');
INSERT INTO `book` VALUES ('4', 'c++', '800', '89.9', '2');
INSERT INTO `book` VALUES ('5', 'C', '500', '89.5', '2');
INSERT INTO `book` VALUES ('8', 'time simple', '1400', '86', '2');
INSERT INTO `book` VALUES ('9', 'python', '500', '50', '1');
INSERT INTO `book` VALUES ('10', 'Oracle', '200', '30', '2');
INSERT INTO `book` VALUES ('12', 'C--', '500', '50', '2');
INSERT INTO `book` VALUES ('13', 'test', '200', '80', '2');
INSERT INTO `book` VALUES ('14', 'C--', '500', null, null);

-- ----------------------------
-- Table structure for `book_type`
-- ----------------------------
DROP TABLE IF EXISTS `book_type`;
CREATE TABLE `book_type` (
  `id` int(11) NOT NULL DEFAULT '0',
  `type_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book_type
-- ----------------------------
INSERT INTO `book_type` VALUES ('1', 'literature');
INSERT INTO `book_type` VALUES ('2', 'calculator');
