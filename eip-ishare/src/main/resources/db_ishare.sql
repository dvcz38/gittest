/*
Navicat MySQL Data Transfer

Source Server         :  
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : fordream

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-11-12 10:55:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dbs_admin_info
-- ----------------------------
DROP TABLE IF EXISTS `dbs_admin_info`;
CREATE TABLE `dbs_admin_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `joinDate` date DEFAULT NULL,
  `role` varchar(10) DEFAULT NULL,
  `state` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dbs_admin_info
-- ----------------------------
INSERT INTO `dbs_admin_info` VALUES ('1', 'admin', '48a3a35b46696f9a99d835267e6ae0af', 'admin@qq.com', '8550296011', '2017-10-02', '管理员', '1');

-- ----------------------------
-- Table structure for db_level_menu
-- ----------------------------
DROP TABLE IF EXISTS `db_level_menu`;
CREATE TABLE `db_level_menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_code` varchar(255) DEFAULT NULL,
  `icon_class` varchar(255) DEFAULT NULL,
  `menu_state` int(255) DEFAULT NULL,
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of db_level_menu
-- ----------------------------
INSERT INTO `db_level_menu` VALUES ('1', 'USERCENTER', 'icon-user', '0');
INSERT INTO `db_level_menu` VALUES ('2', 'COMMENT', 'icon-comments', '0');
INSERT INTO `db_level_menu` VALUES ('3', 'NEWS', 'icon-edit', '0');
INSERT INTO `db_level_menu` VALUES ('4', 'PHOTO', 'icon-picture', '0');
INSERT INTO `db_level_menu` VALUES ('5', 'PRODUCT', 'icon-beaker', '0');
INSERT INTO `db_level_menu` VALUES ('6', 'MAINPAGE', 'icon-paste', '0');
INSERT INTO `db_level_menu` VALUES ('7', 'FINANCE', 'icon-credit-card', '0');
INSERT INTO `db_level_menu` VALUES ('8', 'SYSTEM', 'icon-bar-chart', '0');
INSERT INTO `db_level_menu` VALUES ('9', 'ADMIN', 'icon-key', '0');
INSERT INTO `db_level_menu` VALUES ('10', 'SYSTEM', 'icon-cogs', '0');

-- ----------------------------
-- Table structure for db_two_level_menu
-- ----------------------------
DROP TABLE IF EXISTS `db_two_level_menu`;
CREATE TABLE `db_two_level_menu` (
  `sec_id` int(11) NOT NULL AUTO_INCREMENT,
  `sec_code` varchar(255) DEFAULT NULL,
  `sec_icon` varchar(255) DEFAULT NULL,
  `code` int(11) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sec_id`),
  KEY `FKF3F46EEA2AFC027` (`code`),
  CONSTRAINT `FK_evnjfd61offmmfuwoh2jk4i46` FOREIGN KEY (`code`) REFERENCES `db_level_menu` (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of db_two_level_menu
-- ----------------------------
INSERT INTO `db_two_level_menu` VALUES ('1', 'USERMANAGEMENT', ' icon-group_gear', '1', '/index/user.do');
INSERT INTO `db_two_level_menu` VALUES ('2', 'DELETE-USER', 'icon-group_delete', '1', '/index/delUser.do');
INSERT INTO `db_two_level_menu` VALUES ('3', 'BLACKLIST单', 'icon-lock_delete', '1', '/index/blackList.do');
INSERT INTO `db_two_level_menu` VALUES ('4', 'BROUWSEING HISTORY', ' icon-web', '1', '/index/browseLog.do');
INSERT INTO `db_two_level_menu` VALUES ('5', 'FTP LIST', 'icon-door', '1', '/index/ftp.do');
INSERT INTO `db_two_level_menu` VALUES ('6', 'RSS', ' icon-group_gear', '1', '/index/subscribe.do');
INSERT INTO `db_two_level_menu` VALUES ('7', 'COMMONT', ' icon-group_gear', '2', null);
INSERT INTO `db_two_level_menu` VALUES ('8', 'FEEBACK', ' icon-group_gear', '2', null);
INSERT INTO `db_two_level_menu` VALUES ('9', 'CATOLOG', ' icon-group_gear', '3', null);
INSERT INTO `db_two_level_menu` VALUES ('10', 'NEWS', 'icon-phone_link', '3', null);
INSERT INTO `db_two_level_menu` VALUES ('11', '分类管理', 'icon-door_out', '4', null);
INSERT INTO `db_two_level_menu` VALUES ('12', 'PHOTO', ' icon-group_gear', '4', null);
INSERT INTO `db_two_level_menu` VALUES ('13', '品牌管理', ' icon-group_gear', '5', null);
INSERT INTO `db_two_level_menu` VALUES ('14', '分类管理', 'icon-door', '5', null);
INSERT INTO `db_two_level_menu` VALUES ('15', '产品管理', ' icon-group_gear', '5', null);
INSERT INTO `db_two_level_menu` VALUES ('16', '首页管理', ' icon-group_gear', '6', null);
INSERT INTO `db_two_level_menu` VALUES ('17', '友情链接', ' icon-group_gear', '6', null);
INSERT INTO `db_two_level_menu` VALUES ('18', '订单列表', ' icon-group_gear', '7', '/index/order.do');
INSERT INTO `db_two_level_menu` VALUES ('19', '充值管理', ' icon-group_gear', '7', null);
INSERT INTO `db_two_level_menu` VALUES ('20', '发票管理', ' icon-group_gear', '7', null);
INSERT INTO `db_two_level_menu` VALUES ('21', '统计列表', ' icon-group_gear', '8', null);
INSERT INTO `db_two_level_menu` VALUES ('22', '角色管理', 'icon-user_b', '9', null);
INSERT INTO `db_two_level_menu` VALUES ('23', '权限管理', ' icon-user_go', '9', null);
INSERT INTO `db_two_level_menu` VALUES ('24', '管理员列表', 'icon-user', '9', null);
INSERT INTO `db_two_level_menu` VALUES ('25', '管理员列表', 'icon-user', '10', null);
INSERT INTO `db_two_level_menu` VALUES ('26', '栏目设置', ' icon-group_gear', '10', null);
INSERT INTO `db_two_level_menu` VALUES ('27', '数据字典', ' icon-group_gear', '10', null);
INSERT INTO `db_two_level_menu` VALUES ('28', '屏蔽词', ' icon-group_gear', '10', null);
INSERT INTO `db_two_level_menu` VALUES ('29', '系统日志', 'icon-laptop_link', '10', null);
