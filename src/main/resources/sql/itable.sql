/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50626
Source Host           : 127.0.0.1:3306
Source Database       : itable

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2018-09-17 11:04:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for behavior
-- ----------------------------
DROP TABLE IF EXISTS `behavior`;
CREATE TABLE `behavior` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '行为id',
  `name` varchar(255) NOT NULL COMMENT '行为名称',
  `createtime` datetime NOT NULL COMMENT '创建时间',
  `updatetime` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=111509 DEFAULT CHARSET=utf8 COMMENT='行为表';

-- ----------------------------
-- Records of behavior
-- ----------------------------
INSERT INTO `behavior` VALUES ('111488', '画画', '2018-08-25 09:20:21', '2018-08-28 16:53:03');
INSERT INTO `behavior` VALUES ('111489', '懂礼貌', '2018-08-25 09:21:21', '2018-08-25 09:21:21');
INSERT INTO `behavior` VALUES ('111490', '帮忙干家务', '2018-08-25 09:22:21', '2018-08-25 09:22:21');
INSERT INTO `behavior` VALUES ('111491', '按时睡觉', '2018-08-25 09:25:21', '2018-08-25 09:25:21');
INSERT INTO `behavior` VALUES ('111507', '书法', '2018-08-28 17:54:57', '2018-08-30 13:43:46');

-- ----------------------------
-- Table structure for behavior_score
-- ----------------------------
DROP TABLE IF EXISTS `behavior_score`;
CREATE TABLE `behavior_score` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `behaviorId` varchar(64) NOT NULL COMMENT '行为id',
  `score` varchar(4) NOT NULL COMMENT '行为得分',
  `date` date NOT NULL COMMENT '当前日期',
  `createtime` datetime NOT NULL COMMENT '创建时间',
  `updatetime` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=111533 DEFAULT CHARSET=utf8 COMMENT='行为评分表';

-- ----------------------------
-- Records of behavior_score
-- ----------------------------
INSERT INTO `behavior_score` VALUES ('111490', '111488', 'A', '2018-08-23', '2018-08-23 09:20:21', '2018-08-23 09:20:21');
INSERT INTO `behavior_score` VALUES ('111491', '111488', 'B', '2018-08-22', '2018-08-22 09:20:21', '2018-08-22 09:20:21');
INSERT INTO `behavior_score` VALUES ('111493', '111488', 'B', '2018-08-20', '2018-08-20 09:20:21', '2018-08-20 09:20:21');
INSERT INTO `behavior_score` VALUES ('111494', '111488', 'A', '2018-08-19', '2018-08-19 09:20:21', '2018-08-19 09:20:21');
INSERT INTO `behavior_score` VALUES ('111495', '111488', 'C', '2018-08-18', '2018-08-18 09:20:21', '2018-08-18 09:20:21');
INSERT INTO `behavior_score` VALUES ('111496', '111488', 'C', '2018-08-17', '2018-08-17 09:20:21', '2018-08-17 09:20:21');
INSERT INTO `behavior_score` VALUES ('111514', '111488', 'A', '2018-08-28', '2018-08-28 10:34:59', '2018-08-28 10:34:59');
INSERT INTO `behavior_score` VALUES ('111515', '111489', 'B', '2018-08-28', '2018-08-28 10:35:57', '2018-08-28 10:35:57');
INSERT INTO `behavior_score` VALUES ('111516', '111490', 'A', '2018-08-28', '2018-08-28 10:37:05', '2018-08-28 10:38:54');
INSERT INTO `behavior_score` VALUES ('111517', '111491', 'A', '2018-08-28', '2018-08-28 10:37:46', '2018-08-28 10:41:51');
INSERT INTO `behavior_score` VALUES ('111518', '111489', 'A', '2018-08-27', '2018-08-28 10:42:31', '2018-08-28 10:42:31');
INSERT INTO `behavior_score` VALUES ('111519', '111488', 'B', '2018-08-27', '2018-08-28 10:50:35', '2018-08-28 10:50:35');
INSERT INTO `behavior_score` VALUES ('111520', '111490', 'C', '2018-08-27', '2018-08-28 10:53:30', '2018-08-28 10:53:30');
INSERT INTO `behavior_score` VALUES ('111521', '111488', 'A', '2018-08-26', '2018-08-28 10:54:30', '2018-08-28 10:54:30');
INSERT INTO `behavior_score` VALUES ('111522', '111489', 'B', '2018-08-26', '2018-08-28 10:54:37', '2018-08-28 10:54:37');
INSERT INTO `behavior_score` VALUES ('111523', '111490', 'C', '2018-08-26', '2018-08-28 10:54:42', '2018-08-28 10:54:47');
INSERT INTO `behavior_score` VALUES ('111524', '111491', 'D', '2018-08-26', '2018-08-28 10:55:01', '2018-08-28 10:55:01');
INSERT INTO `behavior_score` VALUES ('111525', '111491', 'D', '2018-08-27', '2018-08-28 10:59:46', '2018-08-28 10:59:46');
INSERT INTO `behavior_score` VALUES ('111526', '111488', 'C', '2018-08-29', '2018-08-28 10:59:52', '2018-08-28 16:52:49');
INSERT INTO `behavior_score` VALUES ('111527', '111489', 'C', '2018-08-29', '2018-08-28 13:45:11', '2018-08-28 13:45:11');
INSERT INTO `behavior_score` VALUES ('111529', '111507', 'A', '2018-08-26', '2018-08-28 17:55:15', '2018-08-28 17:55:15');
INSERT INTO `behavior_score` VALUES ('111530', '111490', 'D', '2018-08-29', '2018-08-30 13:43:28', '2018-08-30 13:43:28');
INSERT INTO `behavior_score` VALUES ('111531', '111488', 'A', '2018-09-17', '2018-09-17 11:00:58', '2018-09-17 11:00:58');
INSERT INTO `behavior_score` VALUES ('111532', '111489', 'B', '2018-09-17', '2018-09-17 11:01:04', '2018-09-17 11:01:04');
