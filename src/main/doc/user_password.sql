/*
Navicat MySQL Data Transfer

Source Server         : 王智芳
Source Server Version : 50648
Source Host           : localhost:3306
Source Database       : miaosha

Target Server Type    : MYSQL
Target Server Version : 50648
File Encoding         : 65001

Date: 2020-12-30 15:46:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user_password`
-- ----------------------------
DROP TABLE IF EXISTS `user_password`;
CREATE TABLE `user_password` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '密码id',
  `encrpt_password` varchar(128) NOT NULL DEFAULT '' COMMENT '加密后的id',
  `user_id` int(11) NOT NULL DEFAULT '0' COMMENT '关联用户的id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user_password
-- ----------------------------
