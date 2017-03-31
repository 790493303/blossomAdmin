/*
Navicat MySQL Data Transfer

Source Server         : blossom_3306
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : blossomweb

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2017-03-30 22:37:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_authorty
-- ----------------------------
DROP TABLE IF EXISTS `tb_authorty`;
CREATE TABLE `tb_authorty` (
  `authorId` int(11) NOT NULL COMMENT '权限编号',
  `parentAuthorId` int(11) DEFAULT NULL COMMENT '父权限ID',
  `authorName` varchar(50) DEFAULT NULL COMMENT '权限名称',
  `authorDescription` varchar(100) DEFAULT NULL COMMENT '权限描述',
  `authorUrl` varchar(200) DEFAULT NULL COMMENT '权限URL',
  PRIMARY KEY (`authorId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限';

-- ----------------------------
-- Table structure for tb_data_params
-- ----------------------------
DROP TABLE IF EXISTS `tb_data_params`;
CREATE TABLE `tb_data_params` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `dataType` int(11) NOT NULL COMMENT '数据库类型',
  `dataName` varchar(40) NOT NULL COMMENT '数据库名称',
  `dataAddress` varchar(50) NOT NULL,
  `port` varchar(4) NOT NULL COMMENT '端口号',
  `userName` varchar(32) NOT NULL COMMENT '用户名',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `url` varchar(150) DEFAULT NULL COMMENT '连接地址',
  `driver` varchar(100) DEFAULT NULL COMMENT '驱动',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_group
-- ----------------------------
DROP TABLE IF EXISTS `tb_group`;
CREATE TABLE `tb_group` (
  `groupId` int(11) NOT NULL COMMENT '组ID',
  `groupName` varchar(50) DEFAULT NULL COMMENT '组名称',
  `parentGroupId` int(11) DEFAULT NULL COMMENT '父组ID',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `groupDescription` varchar(100) DEFAULT NULL COMMENT '组描述',
  PRIMARY KEY (`groupId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组';

-- ----------------------------
-- Table structure for tb_group_authorty
-- ----------------------------
DROP TABLE IF EXISTS `tb_group_authorty`;
CREATE TABLE `tb_group_authorty` (
  `groupAuthortyId` int(11) NOT NULL COMMENT '组权限ID',
  `groupId` int(11) DEFAULT NULL COMMENT '组ID',
  `authorId` int(11) DEFAULT NULL COMMENT '权限ID',
  `authorType` int(11) DEFAULT NULL COMMENT '权限类型',
  PRIMARY KEY (`groupAuthortyId`),
  KEY `groupId` (`groupId`),
  KEY `authortyId` (`authorId`),
  CONSTRAINT `tb_group_authorty_ibfk_1` FOREIGN KEY (`groupId`) REFERENCES `tb_group` (`groupId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tb_group_authorty_ibfk_2` FOREIGN KEY (`authorId`) REFERENCES `tb_authorty` (`authorId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组权限';

-- ----------------------------
-- Table structure for tb_group_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_group_role`;
CREATE TABLE `tb_group_role` (
  `groupRoleId` int(11) NOT NULL COMMENT '组角色ID',
  `groupId` int(11) DEFAULT NULL COMMENT '组ID',
  `roleId` int(11) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`groupRoleId`),
  KEY `groupId` (`groupId`),
  KEY `roleId` (`roleId`),
  CONSTRAINT `tb_group_role_ibfk_1` FOREIGN KEY (`groupId`) REFERENCES `tb_group` (`groupId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tb_group_role_ibfk_2` FOREIGN KEY (`roleId`) REFERENCES `tb_role` (`roleId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组角色';

-- ----------------------------
-- Table structure for tb_handle_log
-- ----------------------------
DROP TABLE IF EXISTS `tb_handle_log`;
CREATE TABLE `tb_handle_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `handleType` int(11) DEFAULT NULL COMMENT '操作类型',
  `handleTime` datetime DEFAULT NULL COMMENT '操作时间',
  `userName` varchar(30) DEFAULT NULL COMMENT '操作用户',
  `description` text COMMENT '操作描述',
  `tableName` varchar(20) DEFAULT NULL COMMENT '表名',
  `params` text COMMENT '参数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='系统操作日志表';

-- ----------------------------
-- Table structure for tb_originization
-- ----------------------------
DROP TABLE IF EXISTS `tb_originization`;
CREATE TABLE `tb_originization` (
  `organizationId` int(11) NOT NULL COMMENT '组织编号',
  `parentOrganizationId` int(11) DEFAULT NULL COMMENT '父组织ID',
  `organizationName` varchar(20) DEFAULT NULL COMMENT '组织名称',
  `organizationDescription` varchar(100) DEFAULT NULL COMMENT '组织描述',
  PRIMARY KEY (`organizationId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组织';

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
  `roleId` int(11) NOT NULL COMMENT '角色ID',
  `parentRoleId` int(11) DEFAULT NULL COMMENT '父角色ID',
  `roleName` varchar(50) DEFAULT NULL COMMENT '角色名称',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `roleDescription` varchar(100) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Table structure for tb_role_authorty
-- ----------------------------
DROP TABLE IF EXISTS `tb_role_authorty`;
CREATE TABLE `tb_role_authorty` (
  `id` int(11) NOT NULL COMMENT '角色权限ID',
  `authorId` int(11) NOT NULL COMMENT '权限ID',
  `roleId` int(11) NOT NULL COMMENT '角色ID',
  `authorType` int(11) DEFAULT NULL COMMENT '权限类型',
  PRIMARY KEY (`id`),
  KEY `authortyId` (`authorId`),
  KEY `roleId` (`roleId`),
  CONSTRAINT `tb_role_authorty_ibfk_1` FOREIGN KEY (`authorId`) REFERENCES `tb_authorty` (`authorId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tb_role_authorty_ibfk_2` FOREIGN KEY (`roleId`) REFERENCES `tb_role` (`roleId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限关联';

-- ----------------------------
-- Table structure for tb_system_log
-- ----------------------------
DROP TABLE IF EXISTS `tb_system_log`;
CREATE TABLE `tb_system_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '系统日志编号',
  `className` varchar(200) DEFAULT NULL COMMENT '操作类',
  `methodName` varchar(100) DEFAULT NULL COMMENT '执行方法',
  `createTime` datetime DEFAULT NULL COMMENT '打印时间',
  `loglevel` varchar(50) DEFAULT NULL COMMENT '日志级别',
  `message` text COMMENT '日志内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=740 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `userId` int(11) NOT NULL COMMENT '用户ID',
  `organizationId` int(11) DEFAULT NULL COMMENT '组织ID',
  `loginAccount` varchar(16) DEFAULT NULL COMMENT '登录账号',
  `loginPassword` varchar(18) DEFAULT NULL COMMENT '登录密码',
  `userName` varchar(16) DEFAULT NULL COMMENT '用户名',
  `telephone` varchar(11) DEFAULT NULL COMMENT '手机号',
  `email` varchar(30) DEFAULT NULL COMMENT '电子邮件',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `loginTime` datetime DEFAULT NULL COMMENT '登录时间',
  `lastLoginTime` datetime DEFAULT NULL COMMENT '上次登录时间',
  `loginCount` int(11) DEFAULT NULL COMMENT '登录次数',
  PRIMARY KEY (`userId`),
  KEY `organizationId` (`organizationId`),
  CONSTRAINT `tb_user_ibfk_1` FOREIGN KEY (`organizationId`) REFERENCES `tb_originization` (`organizationId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户';

-- ----------------------------
-- Table structure for tb_user_authorty
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_authorty`;
CREATE TABLE `tb_user_authorty` (
  `userAuthorId` int(11) NOT NULL COMMENT '用户权限ID',
  `userId` int(11) DEFAULT NULL COMMENT '用户Id',
  `authorId` int(11) DEFAULT NULL COMMENT '权限Id',
  `authorType` varchar(50) DEFAULT NULL COMMENT '权限类型',
  PRIMARY KEY (`userAuthorId`),
  KEY `userId` (`userId`),
  KEY `authortyId` (`authorId`),
  CONSTRAINT `tb_user_authorty_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `tb_user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tb_user_authorty_ibfk_2` FOREIGN KEY (`authorId`) REFERENCES `tb_authorty` (`authorId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户权限';

-- ----------------------------
-- Table structure for tb_user_group
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_group`;
CREATE TABLE `tb_user_group` (
  `userGroupId` int(11) NOT NULL COMMENT '用户组ID',
  `userId` int(11) DEFAULT NULL COMMENT '用户ID',
  `groupId` int(11) DEFAULT NULL COMMENT '组ID',
  PRIMARY KEY (`userGroupId`),
  KEY `userId` (`userId`),
  KEY `groupId` (`groupId`),
  CONSTRAINT `tb_user_group_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `tb_user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tb_user_group_ibfk_2` FOREIGN KEY (`groupId`) REFERENCES `tb_group` (`groupId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色组';

-- ----------------------------
-- Table structure for tb_user_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_role`;
CREATE TABLE `tb_user_role` (
  `userRoleId` int(11) NOT NULL COMMENT '用户角色ID',
  `userId` int(11) DEFAULT NULL COMMENT '用户ID',
  `roleId` int(11) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`userRoleId`),
  KEY `userId` (`userId`),
  KEY `roleId` (`roleId`),
  CONSTRAINT `tb_user_role_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `tb_user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tb_user_role_ibfk_2` FOREIGN KEY (`roleId`) REFERENCES `tb_role` (`roleId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色';

-- ----------------------------
-- Table structure for tb_visit_log
-- ----------------------------
DROP TABLE IF EXISTS `tb_visit_log`;
CREATE TABLE `tb_visit_log` (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '唯一标识',
  `httpUrl` text,
  `httpMethod` varchar(50) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `method` varchar(200) DEFAULT NULL COMMENT '方法名称',
  `requestIp` varchar(22) DEFAULT NULL COMMENT '请求IP',
  `params` varchar(200) DEFAULT NULL COMMENT '参数',
  `userName` varchar(32) DEFAULT NULL COMMENT '用户名称',
  `createDate` varchar(50) DEFAULT NULL COMMENT '发生时间',
  `broswer` varchar(100) DEFAULT NULL COMMENT '客户的浏览器',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='记录日志信息存储';
