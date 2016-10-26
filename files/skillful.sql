/*
Navicat MySQL Data Transfer

Source Server         : self
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : skillful

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2016-10-26 14:12:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for base_material
-- ----------------------------
DROP TABLE IF EXISTS `base_material`;
CREATE TABLE `base_material` (
  `material_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '物资id',
  `order_no` int(11) DEFAULT NULL COMMENT '序号',
  `code` varchar(24) DEFAULT NULL COMMENT '编码',
  `material_code` varchar(32) NOT NULL COMMENT '物资编码',
  `material_name` varchar(32) NOT NULL COMMENT '物资名称',
  `material_spec` varchar(32) DEFAULT NULL COMMENT '物资规格',
  `mnemonic_code` varchar(32) NOT NULL COMMENT '助记码',
  `material_unit` varchar(32) DEFAULT NULL COMMENT '物资单位',
  `class_code` varchar(24) NOT NULL COMMENT '物资分类编码',
  `class_name` varchar(32) NOT NULL COMMENT '物资分类名称',
  `planting_sys_code` varchar(24) DEFAULT NULL COMMENT '种植系统编码',
  `planting_sys_name` varchar(32) DEFAULT NULL COMMENT '种植系统名称',
  `status` smallint(6) NOT NULL COMMENT '状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间',
  `parent_hospital_id` int(11) NOT NULL COMMENT '总院id',
  PRIMARY KEY (`material_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='基本物资表';

-- ----------------------------
-- Records of base_material
-- ----------------------------
INSERT INTO `base_material` VALUES ('1', '1', '01', '01', '物资1', '23', '23', '单1', '01', '物资类别1', null, null, '1', '2016-10-26 14:05:53', '2016-10-26 14:05:53', '1');
INSERT INTO `base_material` VALUES ('2', '2', '023', '023', '物资2', '23', '2334', '67', '02', '物资类别2', null, null, '1', '2016-10-26 14:06:43', '2016-10-26 14:06:43', '1');

-- ----------------------------
-- Table structure for base_material_class
-- ----------------------------
DROP TABLE IF EXISTS `base_material_class`;
CREATE TABLE `base_material_class` (
  `class_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '物资类别id',
  `class_name` varchar(32) NOT NULL COMMENT '物资分类名称',
  `class_code` varchar(24) NOT NULL COMMENT '物资分类编码',
  `parent_hospital_id` int(11) NOT NULL COMMENT '总院id',
  `parent_class_code` varchar(24) DEFAULT NULL COMMENT '父编码',
  `order_no` int(11) NOT NULL COMMENT '序号',
  `class_status` smallint(6) NOT NULL COMMENT '状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间',
  PRIMARY KEY (`class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='物资类别表';

-- ----------------------------
-- Records of base_material_class
-- ----------------------------
INSERT INTO `base_material_class` VALUES ('1', '物资类别1', '01', '1', '1', '1', '1', '2016-10-26 13:54:25', '2016-10-26 13:54:26');
INSERT INTO `base_material_class` VALUES ('2', '物资类别2', '02', '1', '1', '2', '1', '2016-10-26 13:54:38', '2016-10-26 13:54:38');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `modify_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` int(2) NOT NULL,
  `num` decimal(6,2) NOT NULL,
  `team_id` int(8) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_1` (`team_id`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`team_id`) REFERENCES `team` (`team_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------

-- ----------------------------
-- Table structure for team
-- ----------------------------
DROP TABLE IF EXISTS `team`;
CREATE TABLE `team` (
  `team_id` int(8) NOT NULL AUTO_INCREMENT,
  `team_name` varchar(100) NOT NULL,
  `status` int(2) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `modify_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`team_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of team
-- ----------------------------

-- ----------------------------
-- Table structure for t_privilege
-- ----------------------------
DROP TABLE IF EXISTS `t_privilege`;
CREATE TABLE `t_privilege` (
  `privilege_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `privilege_code` varchar(40) NOT NULL COMMENT '权限编码',
  `privilege_name` varchar(40) NOT NULL COMMENT '权限名称',
  `url` varchar(100) DEFAULT NULL COMMENT 'url',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间',
  PRIMARY KEY (`privilege_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of t_privilege
-- ----------------------------
INSERT INTO `t_privilege` VALUES ('1', '4', '用户管理', '/user/list.htm', null, '2016-10-25 14:56:56', '2016-10-25 14:56:53');
INSERT INTO `t_privilege` VALUES ('2', '5', '角色管理', '/role/list.htm', null, '2016-10-25 14:56:58', '2016-10-25 14:56:56');
INSERT INTO `t_privilege` VALUES ('3', '6', '权限管理', '/privilege/list.htm', null, '2016-10-25 14:57:01', '2016-10-25 14:56:59');
INSERT INTO `t_privilege` VALUES ('4', '7', '新增', '', null, '2016-10-25 15:06:24', '2016-10-25 15:01:06');
INSERT INTO `t_privilege` VALUES ('5', '1', '首页', '/index.htm', '', '2016-10-25 15:16:53', '2016-10-25 15:16:53');
INSERT INTO `t_privilege` VALUES ('6', '8', '修改', '', '', '2016-10-25 15:17:26', '2016-10-25 15:17:26');
INSERT INTO `t_privilege` VALUES ('7', '9', '删除', '', '', '2016-10-25 15:17:35', '2016-10-25 15:17:35');
INSERT INTO `t_privilege` VALUES ('8', '2', '物资分类', '/baseMaterialClass/defaultList.htm', '', '2016-10-25 15:20:01', '2016-10-25 15:20:01');
INSERT INTO `t_privilege` VALUES ('9', '3', '物资', '/baseMaterial/defaultList.htm', '', '2016-10-25 15:20:29', '2016-10-25 15:20:29');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(40) NOT NULL COMMENT '角色名称',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', '管理员', null, '2016-10-25 14:58:06', '2016-10-25 14:58:09');
INSERT INTO `t_role` VALUES ('5', '普通用户', '', '2016-10-26 13:53:43', '2016-10-26 13:53:43');

-- ----------------------------
-- Table structure for t_role_privilege
-- ----------------------------
DROP TABLE IF EXISTS `t_role_privilege`;
CREATE TABLE `t_role_privilege` (
  `record_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色权限id',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `privilege_code` varchar(40) NOT NULL COMMENT '权限id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='角色权限表';

-- ----------------------------
-- Records of t_role_privilege
-- ----------------------------
INSERT INTO `t_role_privilege` VALUES ('1', '1', '1', '2016-10-25 14:56:42', '2016-10-25 14:56:39');
INSERT INTO `t_role_privilege` VALUES ('2', '1', '2', '2016-10-25 14:56:45', '2016-10-25 14:56:43');
INSERT INTO `t_role_privilege` VALUES ('3', '1', '3', '2016-10-25 14:56:50', '2016-10-25 14:56:47');
INSERT INTO `t_role_privilege` VALUES ('4', '1', '4', '2016-10-25 15:21:48', '2016-10-18 15:21:43');
INSERT INTO `t_role_privilege` VALUES ('5', '1', '5', '2016-10-25 15:21:57', '2016-10-25 15:22:00');
INSERT INTO `t_role_privilege` VALUES ('6', '1', '6', '2016-10-25 15:46:07', '2016-10-25 15:46:11');
INSERT INTO `t_role_privilege` VALUES ('7', '1', '7', '2016-10-25 15:46:39', '2016-10-25 15:46:36');
INSERT INTO `t_role_privilege` VALUES ('8', '1', '8', '2016-10-25 15:46:46', '2016-10-25 15:46:48');
INSERT INTO `t_role_privilege` VALUES ('9', '1', '9', '2016-10-25 15:46:59', '2016-10-25 15:47:01');
INSERT INTO `t_role_privilege` VALUES ('10', '5', '7', '2016-10-26 13:53:43', '2016-10-26 13:53:43');
INSERT INTO `t_role_privilege` VALUES ('11', '5', '1', '2016-10-26 13:53:43', '2016-10-26 13:53:43');
INSERT INTO `t_role_privilege` VALUES ('12', '5', '8', '2016-10-26 13:53:43', '2016-10-26 13:53:43');
INSERT INTO `t_role_privilege` VALUES ('13', '5', '9', '2016-10-26 13:53:43', '2016-10-26 13:53:43');
INSERT INTO `t_role_privilege` VALUES ('14', '5', '2', '2016-10-26 13:53:43', '2016-10-26 13:53:43');
INSERT INTO `t_role_privilege` VALUES ('15', '5', '3', '2016-10-26 13:53:43', '2016-10-26 13:53:43');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户名id',
  `user_name` varchar(40) NOT NULL COMMENT '用户名',
  `password` int(11) NOT NULL COMMENT '密码',
  `enable` smallint(6) NOT NULL COMMENT '是否使用',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `role_name` varchar(40) NOT NULL COMMENT '角色名称',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户 表';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', '123456', '1', '1', '管理员', '2016-10-25 14:57:35', '2016-10-25 14:57:39', null);
INSERT INTO `t_user` VALUES ('2', 'user', '123456', '1', '5', '普通用户', '2016-10-26 13:54:00', '2016-10-26 13:54:00', null);
