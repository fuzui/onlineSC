/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50558
Source Host           : localhost:3306
Source Database       : selc

Target Server Type    : MYSQL
Target Server Version : 50558
File Encoding         : 65001

Date: 2018-07-06 16:46:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `Aname` varchar(12) NOT NULL,
  `Apassword` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`Aname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('admin', 'admin');

-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `Cid` char(4) NOT NULL DEFAULT '',
  `Cname` varchar(5) NOT NULL,
  `Cintroduction` varchar(100) DEFAULT NULL,
  `Type` varchar(15) DEFAULT NULL,
  `belongcoll` varchar(15) DEFAULT NULL,
  `belongpro` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`Cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('0001', '网络编程', 'java  web应用程序', '必修', '计算机学院', '网络工程');
INSERT INTO `course` VALUES ('0010', '软件工程', '123', '必修', '计算机学院', '软件工程');
INSERT INTO `course` VALUES ('0011', '汉语', '123', '必修', '人文学院', '历史');
INSERT INTO `course` VALUES ('0012', '日语', '123', '选修', '外国语学院', '日语');
INSERT INTO `course` VALUES ('0013', '英语', '123', '必修', '外国语学院', '英语');
INSERT INTO `course` VALUES ('1000', '操作系统', 'OS', '必修', '计算机学院', '网络工程');

-- ----------------------------
-- Table structure for `courseplan`
-- ----------------------------
DROP TABLE IF EXISTS `courseplan`;
CREATE TABLE `courseplan` (
  `Courseclass` varchar(12) NOT NULL,
  `coursetime` varchar(12) DEFAULT NULL,
  `courseweek` varchar(12) DEFAULT NULL,
  `cid` char(4) DEFAULT NULL,
  `tid` char(4) DEFAULT NULL,
  `classroom` varchar(6) DEFAULT NULL,
  `credits` int(11) DEFAULT NULL,
  `period` int(11) DEFAULT NULL,
  `Totalnum` int(11) DEFAULT NULL,
  PRIMARY KEY (`Courseclass`),
  KEY `cid` (`cid`),
  KEY `tid` (`tid`),
  CONSTRAINT `courseplan_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `course` (`Cid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `courseplan_ibfk_2` FOREIGN KEY (`tid`) REFERENCES `teacher` (`Tid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of courseplan
-- ----------------------------
INSERT INTO `courseplan` VALUES ('javaweb1', '12', '2,4,5', '0001', '0002', '30508', '3', '40', '35');
INSERT INTO `courseplan` VALUES ('OS一般', '12', '4,5', '1000', '0002', '30508', '3', '40', '50');
INSERT INTO `courseplan` VALUES ('英语1', '12', '1', '0013', '1000', '20205', '2', '25', '35');

-- ----------------------------
-- Table structure for `sc`
-- ----------------------------
DROP TABLE IF EXISTS `sc`;
CREATE TABLE `sc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cid` char(4) DEFAULT NULL,
  `sid` char(12) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cid` (`cid`),
  KEY `sid` (`sid`),
  CONSTRAINT `sc_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `course` (`Cid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sc_ibfk_2` FOREIGN KEY (`sid`) REFERENCES `student` (`Sid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sc
-- ----------------------------
INSERT INTO `sc` VALUES ('3', '0001', '201507024125');
INSERT INTO `sc` VALUES ('4', '0001', '201507024131');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `Sid` char(12) NOT NULL DEFAULT '',
  `Sname` varchar(8) NOT NULL,
  `Sidcard` char(18) NOT NULL,
  `Ssex` enum('男','女') DEFAULT NULL,
  `Spassword` varchar(12) NOT NULL,
  `Sage` char(2) NOT NULL,
  `Classr` varchar(15) DEFAULT NULL,
  `profession` varchar(15) DEFAULT NULL,
  `college` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`Sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('201507024125', '王泽', '140581199610126211', '男', '000000', '22', '网络B151', '网络工程', '计算机学院');
INSERT INTO `student` VALUES ('201507024126', '高乾', '123456123456123123', '男', '000000', '23', '网络B151', '网络工程', '计算机学院');
INSERT INTO `student` VALUES ('201507024131', '宋星星', '111222333111222333', '女', '000000', '18', '汉语B171', '汉语', '人文学院');
INSERT INTO `student` VALUES ('201702044122', '李晓燕', '140581199706211698', '女', '123456', '22', '汉语B172', '汉语', '人文学院');

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `Tid` char(4) NOT NULL DEFAULT '',
  `Tname` varchar(8) NOT NULL,
  `Tpassword` varchar(12) NOT NULL,
  `Tsex` enum('男','女') DEFAULT NULL,
  `Introduction` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('0002', '王艳', '123123', '女', '孜孜不倦，有问必答');
INSERT INTO `teacher` VALUES ('0003', '宋地球', '000000', '男', '');
INSERT INTO `teacher` VALUES ('1000', '李浩', '123456', '男', '勿忘初心');
INSERT INTO `teacher` VALUES ('1001', '吴娇', '123456', '女', '耐心');
INSERT INTO `teacher` VALUES ('1002', '李鹏', '123456', '男', '严厉');
INSERT INTO `teacher` VALUES ('1003', '任图', '123456', '女', '博士后');
