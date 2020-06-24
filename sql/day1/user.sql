/*
Navicat MySQL Data Transfer

Source Server         : 192.168.31.33
Source Server Version : 50718
Source Host           : 192.168.31.33:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2020-06-24 15:18:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `create_user` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `modify_user` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2', '刘先生', '未知', '123456', '18800001234', null, null, '2020-06-24 07:15:20', null);
INSERT INTO `user` VALUES ('3', 'lwl', '?', '123456', '18888888888', null, null, null, null);
INSERT INTO `user` VALUES ('5', '帅气的劉先生', '男', '66666666666', '18888888888', null, null, null, null);
INSERT INTO `user` VALUES ('6', '刘先生66666', '未知', '66666666666', '18800006666', null, null, '2020-06-24 07:17:12', null);
