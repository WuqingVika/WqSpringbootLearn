/*
Navicat MySQL Data Transfer

Source Server         : test1
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : springbootdb0314

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2018-03-14 16:52:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE "user" (
  "name" varchar(255) COLLATE utf8_bin DEFAULT NULL,
  "age" int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('吴庆values(\'\')', '2');
INSERT INTO `user` VALUES ('吴庆3', '3');
INSERT INTO `user` VALUES ('吴庆5', '4');
