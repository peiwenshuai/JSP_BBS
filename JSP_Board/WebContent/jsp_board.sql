/*
 Navicat Premium Data Transfer

 Source Server         : localhost_mariaDB
 Source Server Type    : MariaDB
 Source Server Version : 100118
 Source Host           : localhost:3306
 Source Schema         : jsp_board

 Target Server Type    : MariaDB
 Target Server Version : 100118
 File Encoding         : 65001

 Date: 18/09/2017 10:06:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bbs_info
-- ----------------------------
DROP TABLE IF EXISTS `bbs_info`;
CREATE TABLE `bbs_info`  (
  `board_idx` int(11) NOT NULL AUTO_INCREMENT,
  `user_idx` int(11) NOT NULL,
  `user_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `board_regi_date` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `board_title` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `board_content` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `view_cnt` int(11) DEFAULT NULL,
  PRIMARY KEY (`board_idx`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 43 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `user_idx` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_pwd` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_age` int(11) DEFAULT NULL,
  `user_gender` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_regi_date` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`user_idx`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
