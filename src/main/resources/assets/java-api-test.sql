/*
 Navicat Premium Data Transfer

 Source Server         : MYSQL DB
 Source Server Type    : MySQL
 Source Server Version : 100418
 Source Host           : 127.0.0.1:3306
 Source Schema         : java-api-test

 Target Server Type    : MySQL
 Target Server Version : 100418
 File Encoding         : 65001

 Date: 16/07/2021 23:56:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for master_menu
-- ----------------------------
DROP TABLE IF EXISTS `master_menu`;
CREATE TABLE `master_menu` (
  `menu_id` varchar(255) NOT NULL,
  `menu_name` varchar(255) DEFAULT NULL,
  `menu_description` longtext DEFAULT NULL,
  `url_image` longtext DEFAULT NULL,
  `created_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `modified_date` timestamp NULL DEFAULT current_timestamp(),
  `is_deleted` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of master_menu
-- ----------------------------
BEGIN;
INSERT INTO `master_menu` VALUES ('03514b40-c4ed-451f-a03b-a4e982c2e104', 'COMMUNITY', 'this is community menu', 'https://placeimg.com/640/480/any', '2021-07-16 22:48:41', NULL, 0);
INSERT INTO `master_menu` VALUES ('263f12d2-2b5a-4fc0-9d7d-b9aee206511e', 'COMPANY', 'this is company menu', 'https://placeimg.com/640/480/any', '2021-07-16 22:47:31', NULL, 0);
INSERT INTO `master_menu` VALUES ('9272e46e-e277-483e-9839-9d824c7cbc9f', 'EDUCATION', 'this is education menu', 'https://placeimg.com/640/480/any', '2021-07-16 22:49:10', '2021-07-16 23:39:19', 0);
COMMIT;

-- ----------------------------
-- Table structure for master_sub_menu
-- ----------------------------
DROP TABLE IF EXISTS `master_sub_menu`;
CREATE TABLE `master_sub_menu` (
  `sub_menu_id` varchar(255) NOT NULL,
  `menu_id` varchar(255) NOT NULL,
  `sub_menu_name` varchar(255) DEFAULT NULL,
  `sub_menu_description` longtext DEFAULT NULL,
  `url_image` longtext DEFAULT NULL,
  `created_date` timestamp NULL DEFAULT current_timestamp(),
  `modified_date` timestamp NULL DEFAULT current_timestamp(),
  `is_deleted` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`sub_menu_id`),
  KEY `FK_SUB_MENU_REF_MENU` (`menu_id`),
  CONSTRAINT `FK_SUB_MENU_REF_MENU` FOREIGN KEY (`menu_id`) REFERENCES `master_menu` (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of master_sub_menu
-- ----------------------------
BEGIN;
INSERT INTO `master_sub_menu` VALUES ('0ee9a8ce-6057-4476-ad29-7a7ef2395887', '9272e46e-e277-483e-9839-9d824c7cbc9f', 'EDUCATION E', 'Libero eros. Tempor non lorem Non. Elementum vehicula netus risus massa et ante rhoncus ipsum, sociis sollicitudin quisque tempor cursus.', 'https://placeimg.com/640/480/any', '2021-07-16 23:29:43', '2021-07-16 23:39:03', 0);
INSERT INTO `master_sub_menu` VALUES ('1957286e-a844-4d83-bfea-84f5f4cbab39', '263f12d2-2b5a-4fc0-9d7d-b9aee206511e', 'COMPANY E', 'Libero eros. Tempor non lorem Non. Elementum vehicula netus risus massa et ante rhoncus ipsum, sociis sollicitudin quisque tempor cursus.', 'https://placeimg.com/640/480/any', '2021-07-16 23:28:39', NULL, 0);
INSERT INTO `master_sub_menu` VALUES ('244e59c6-6847-463a-9ec9-d5e3e0a95e54', '263f12d2-2b5a-4fc0-9d7d-b9aee206511e', 'COMPANY B', 'Congue platea in, sem blandit integer placerat laoreet adipiscing Fermentum, erat sociosqu habitasse mollis suspendisse mattis ultricies adipiscing vitae. Accumsan.', 'https://placeimg.com/640/480/any', '2021-07-16 23:21:46', '2021-07-16 23:27:25', 0);
INSERT INTO `master_sub_menu` VALUES ('3a37a463-90b0-4279-941c-e49d0c2617d5', '03514b40-c4ed-451f-a03b-a4e982c2e104', 'COMMUNITY E', 'Libero eros. Tempor non lorem Non. Elementum vehicula netus risus massa et ante rhoncus ipsum, sociis sollicitudin quisque tempor cursus.', 'https://placeimg.com/640/480/any', '2021-07-16 23:32:09', NULL, 0);
INSERT INTO `master_sub_menu` VALUES ('3b7bac9f-2225-4f5b-b680-39746d633447', '263f12d2-2b5a-4fc0-9d7d-b9aee206511e', 'COMPANY C', 'Mi aliquet tristique elementum aptent tempus mollis nisi risus iaculis curae; morbi euismod conubia faucibus sit hendrerit aptent potenti. Etiam.', 'https://placeimg.com/640/480/any', '2021-07-16 23:28:12', NULL, 0);
INSERT INTO `master_sub_menu` VALUES ('4e84009c-65e6-4268-abfc-c1b1bbcdaa78', '263f12d2-2b5a-4fc0-9d7d-b9aee206511e', 'COMPANY A', 'Good created their over greater be beginning you\'ll deep can\'t male thing so wherein. Won\'t. Own hath dry heaven creeping', 'https://placeimg.com/640/480/any', '2021-07-16 23:21:26', NULL, 0);
INSERT INTO `master_sub_menu` VALUES ('5b81a559-6014-4328-8f33-d968706b14df', '03514b40-c4ed-451f-a03b-a4e982c2e104', 'COMMUNITY C', 'Mi aliquet tristique elementum aptent tempus mollis nisi risus iaculis curae; morbi euismod conubia faucibus sit hendrerit aptent potenti. Etiam.', 'https://placeimg.com/640/480/any', '2021-07-16 23:31:53', NULL, 0);
INSERT INTO `master_sub_menu` VALUES ('5e389c63-3544-491d-baf3-6513fda2f6df', '9272e46e-e277-483e-9839-9d824c7cbc9f', 'EDUCATION A', 'Good created their over greater be beginning you\'ll deep can\'t male thing so wherein. Won\'t. Own hath dry heaven creeping', 'https://placeimg.com/640/480/any', '2021-07-16 23:29:54', '2021-07-16 23:39:03', 0);
INSERT INTO `master_sub_menu` VALUES ('6523b8c0-c6f4-4a13-abf1-c462819edfcd', '03514b40-c4ed-451f-a03b-a4e982c2e104', 'COMMUNITY B', 'Congue platea in, sem blandit integer placerat laoreet adipiscing Fermentum, erat sociosqu habitasse mollis suspendisse mattis ultricies adipiscing vitae. Accumsan.', 'https://placeimg.com/640/480/any', '2021-07-16 23:31:45', NULL, 0);
INSERT INTO `master_sub_menu` VALUES ('6b756615-51a4-4f7b-9286-27be764127c8', '03514b40-c4ed-451f-a03b-a4e982c2e104', 'COMMUNITY A', 'Good created their over greater be beginning you\'ll deep can\'t male thing so wherein. Won\'t. Own hath dry heaven creeping', 'https://placeimg.com/640/480/any', '2021-07-16 23:31:26', NULL, 0);
INSERT INTO `master_sub_menu` VALUES ('709beee3-1ceb-4ed2-860e-90efbcd555f3', '9272e46e-e277-483e-9839-9d824c7cbc9f', 'EDUCATION C', 'Mi aliquet tristique elementum aptent tempus mollis nisi risus iaculis curae; morbi euismod conubia faucibus sit hendrerit aptent potenti. Etiam.', 'https://placeimg.com/640/480/any', '2021-07-16 23:30:14', '2021-07-16 23:39:03', 0);
INSERT INTO `master_sub_menu` VALUES ('897867c9-07a6-4c66-9bc4-449b1ef2d7c6', '263f12d2-2b5a-4fc0-9d7d-b9aee206511e', 'COMPANY D', 'Libero congue porttitor praesent feugiat. Pretium Mus purus habitant rhoncus, integer est mus bibendum nonummy. Magnis nascetur auctor vitae nisl.', 'https://placeimg.com/640/480/any', '2021-07-16 23:28:24', NULL, 0);
INSERT INTO `master_sub_menu` VALUES ('8c8293df-2b3c-40e2-95db-bce9fb661091', '9272e46e-e277-483e-9839-9d824c7cbc9f', 'EDUCATION D', 'Libero congue porttitor praesent feugiat. Pretium Mus purus habitant rhoncus, integer est mus bibendum nonummy. Magnis nascetur auctor vitae nisl.', 'https://placeimg.com/640/480/any', '2021-07-16 23:30:20', '2021-07-16 23:39:03', 0);
INSERT INTO `master_sub_menu` VALUES ('b641ee84-f592-4b0b-9dd6-a94f64b206f9', '9272e46e-e277-483e-9839-9d824c7cbc9f', 'EDUCATION B', 'Congue platea in, sem blandit integer placerat laoreet adipiscing Fermentum, erat sociosqu habitasse mollis suspendisse mattis ultricies adipiscing vitae. Accumsan.', 'https://placeimg.com/640/480/any', '2021-07-16 23:30:03', '2021-07-16 23:39:03', 0);
INSERT INTO `master_sub_menu` VALUES ('ef2775b9-f612-484b-b671-11f87e42230f', '03514b40-c4ed-451f-a03b-a4e982c2e104', 'COMMUNITY D', 'Libero congue porttitor praesent feugiat. Pretium Mus purus habitant rhoncus, integer est mus bibendum nonummy. Magnis nascetur auctor vitae nisl.', 'https://placeimg.com/640/480/any', '2021-07-16 23:32:01', NULL, 0);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
