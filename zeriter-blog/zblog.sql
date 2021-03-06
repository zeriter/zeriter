/*
 Navicat Premium Data Transfer

 Source Server         : 本机
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : zblog

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 15/06/2020 18:02:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog`  (
  `blog_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '唯一主键',
  `blog_title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '博客标题',
  `blog_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '博客正文',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `show_sts` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '1隐藏，0显示',
  `delete_sts` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '0正常，1删除',
  `tag_id` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '标签id，多个标签则用；号隔开',
  `delete_date` datetime(0) NULL DEFAULT NULL COMMENT '删除时间',
  `click` int(0) NULL DEFAULT NULL COMMENT '点击量',
  `blog_type` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '1原创，2转载，3翻译',
  `group_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分组id，',
  PRIMARY KEY (`blog_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES ('blog_00001', '测试标题', '测试内容', '2020-05-11 22:42:47', '2020-06-10 16:45:40', '0', '0', 'tag_1', NULL, 1, '1', 'group_1');
INSERT INTO `blog` VALUES ('blog_00002', '20200511测试', '20200511测试', '2020-06-10 16:02:22', '2020-06-10 16:45:38', '0', '0', 'tag_1', NULL, 40, '2', 'group_1');
INSERT INTO `blog` VALUES ('blog_120441513290', 'zeriter20200528', 'zeriter20200528', '2020-05-28 15:13:30', '2020-05-28 15:13:31', '0', '0', 'tag_1', NULL, 20, '3', 'group_2');
INSERT INTO `blog` VALUES ('blog_120511619460', '佛挡杀佛', 'name%20%7C%20%E4%BB%B7%E6%A0%BC%20%7C%20%20%E6%95%B0%E9%87%8F%0A-%7C-%7C-%0A%E9%A6%99%E8%95%89%20%7C%20%241%20%7C%205%20%0A%E8%8B%B9%E6%9E%9C%20%7C%20%241%20%7C%206%20%0A%E8%8D%89%E8%8E%93%20%7C%20%241%20%7C%207%20', '2020-06-15 16:19:47', NULL, '0', '0', 'tag_2;', NULL, 1, '3', 'blog_12051156450');
INSERT INTO `blog` VALUES ('blog_120511619580', '佛挡杀佛', 'name%20%7C%20%E4%BB%B7%E6%A0%BC%20%7C%20%20%E6%95%B0%E9%87%8F%0A-%7C-%7C-%0A%E9%A6%99%E8%95%89%20%7C%20%241%20%7C%205%20%0A%E8%8B%B9%E6%9E%9C%20%7C%20%241%20%7C%206%20%0A%E8%8D%89%E8%8E%93%20%7C%20%241%20%7C%207%20', '2020-06-15 16:19:58', NULL, '0', '0', 'tag_120511421520;tag_2;', NULL, 1, '3', 'blog_12051156450');
INSERT INTO `blog` VALUES ('blog_12051164180', '佛挡杀佛', 'name%20%7C%20%E4%BB%B7%E6%A0%BC%20%7C%20%20%E6%95%B0%E9%87%8F%0A-%7C-%7C-%0A%E9%A6%99%E8%95%89%20%7C%20%241%20%7C%205%20%0A%E8%8B%B9%E6%9E%9C%20%7C%20%241%20%7C%206%20%0A%E8%8D%89%E8%8E%93%20%7C%20%241%20%7C%207%20', '2020-06-15 16:04:18', NULL, '0', '0', 'tag_120511421520;', NULL, 1, '3', 'blog_12051156450');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `comment_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评论唯一主见',
  `comment_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论者的姓名',
  `Comment_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '评论内容',
  `parent_Comment_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论父级id，如果本身是父级为0',
  `blog_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '博客id',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `delete_date` datetime(0) NULL DEFAULT NULL COMMENT '删除时间',
  `delete_sts` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否删除，0删除，1未删除',
  `author_sts` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否是作者，0不是作者，1是作者',
  `show_sts` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否展示，0展示，1不展示',
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('comment_120441513480', 'zeriter', NULL, '0', 'blog_120441513290', '2020-05-28 15:13:49', NULL, '1', '1', '0');
INSERT INTO `comment` VALUES ('comment_120511619460', NULL, NULL, '0', 'blog_120511619460', '2020-06-15 16:19:47', NULL, '1', NULL, '1');
INSERT INTO `comment` VALUES ('comment_120511619580', NULL, NULL, '0', 'blog_120511619580', '2020-06-15 16:19:58', NULL, '1', NULL, '1');
INSERT INTO `comment` VALUES ('comment_12051164180', NULL, NULL, '0', 'blog_12051164180', '2020-06-15 16:04:19', NULL, '1', NULL, '1');

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag`  (
  `tag_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标签唯一主键',
  `tag_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标签名称',
  `create_date` datetime(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`tag_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tag
-- ----------------------------
INSERT INTO `tag` VALUES ('tag_1', '默认标签', '2020-05-11 23:59:08');
INSERT INTO `tag` VALUES ('tag_120511421520', 'spring', '2020-06-15 14:21:53');
INSERT INTO `tag` VALUES ('tag_2', '最强标签', '2020-06-09 17:34:40');

-- ----------------------------
-- Table structure for zgroup
-- ----------------------------
DROP TABLE IF EXISTS `zgroup`;
CREATE TABLE `zgroup`  (
  `group_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标签唯一主键',
  `group_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标签名称',
  `create_date` datetime(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`group_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zgroup
-- ----------------------------
INSERT INTO `zgroup` VALUES ('blog_12051156450', '读者笔记', '2020-06-15 15:06:46');
INSERT INTO `zgroup` VALUES ('group_1', '默认分组', '2020-05-11 23:59:08');
INSERT INTO `zgroup` VALUES ('group_2', '开发者笔记', '2020-06-09 17:34:40');

SET FOREIGN_KEY_CHECKS = 1;
