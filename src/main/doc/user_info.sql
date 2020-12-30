/*
Navicat MySQL Data Transfer

Source Server         : 王智芳
Source Server Version : 50648
Source Host           : localhost:3306
Source Database       : miaosha

Target Server Type    : MYSQL
Target Server Version : 50648
File Encoding         : 65001

Date: 2020-12-30 15:46:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `name` varchar(64) DEFAULT '' COMMENT '用户名',
  `gender` tinyint(4) DEFAULT '0' COMMENT '性别1:代表男性；2代表女性',
  `age` int(11) DEFAULT '0' COMMENT '年龄',
  `telphone` varchar(255) DEFAULT '' COMMENT '电话号码',
  `register_mode` varchar(255) DEFAULT '' COMMENT '注册方式：byphone,bywechat,byalipay',
  `third_party_id` varchar(64) DEFAULT '' COMMENT '三方凭证ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user_info
-- ----------------------------
