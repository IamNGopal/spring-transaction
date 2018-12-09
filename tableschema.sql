/*
Navicat MySQL Data Transfer

Source Server         : Gopal
Source Server Version : 50721
Source Host           : 127.0.0.1:3306
Source Database       : spring-transaction

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-12-09 09:22:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `customer_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`customer_id`),
  UNIQUE KEY `account_id` (`customer_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=COMPRESSED;

-- ----------------------------
-- Table structure for customer_contact
-- ----------------------------
DROP TABLE IF EXISTS `customer_contact`;
CREATE TABLE `customer_contact` (
  `contact_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `contact_customer_id` int(10) NOT NULL DEFAULT '0',
  `contact_fname` varchar(255) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `contact_lname` varchar(255) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`contact_id`),
  UNIQUE KEY `contact_id` (`contact_id`) USING BTREE,
  KEY `contact_account_id` (`contact_customer_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=COMPRESSED;

-- ----------------------------
-- Table structure for sales_oppr
-- ----------------------------
DROP TABLE IF EXISTS `sales_oppr`;
CREATE TABLE `sales_oppr` (
  `oppr_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `oppr_no` int(10) NOT NULL DEFAULT '0',
  `oppr_customer_id` int(10) NOT NULL DEFAULT '0',
  `oppr_contact_id` int(10) NOT NULL DEFAULT '0',
  `oppr_title` varchar(255) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `oppr_desc` varchar(255) COLLATE utf8_unicode_ci DEFAULT '',
  `oppr_date` datetime DEFAULT NULL,
  PRIMARY KEY (`oppr_id`),
  UNIQUE KEY `oppr_id` (`oppr_id`) USING BTREE,
  KEY `oppr_account_id` (`oppr_customer_id`) USING BTREE,
  KEY `oppr_contact_id` (`oppr_contact_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for sales_oppr_history
-- ----------------------------
DROP TABLE IF EXISTS `sales_oppr_history`;
CREATE TABLE `sales_oppr_history` (
  `history_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `history_oppr_id` bigint(20) unsigned NOT NULL DEFAULT '0',
  `history_datetime` datetime DEFAULT NULL,
  `history_actiontype` varchar(255) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `history_oldvalue` text COLLATE utf8_unicode_ci,
  `history_newvalue` text COLLATE utf8_unicode_ci,
  PRIMARY KEY (`history_id`),
  UNIQUE KEY `history_id` (`history_id`) USING BTREE,
  KEY `history_oppr_id` (`history_oppr_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
