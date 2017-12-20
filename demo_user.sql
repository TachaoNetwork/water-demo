SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `demo_user`
-- ----------------------------
DROP TABLE IF EXISTS `demo_user`;
CREATE TABLE `demo_user` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `USER_CODE` varchar(256) DEFAULT NULL COMMENT '用户编码',
  `USER_NICKNAME` varchar(256) DEFAULT NULL COMMENT '用户昵称',
  `USER_AGE` int(11) DEFAULT NULL COMMENT '用户描述',
  `LOGIN_TIME` datetime DEFAULT NULL COMMENT '登陆时间',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_ID` varchar(50) DEFAULT NULL COMMENT '创建者',
  `MODIFY_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `MODIFY_ID` varchar(50) DEFAULT NULL COMMENT '修改者',
  `DELETE_FLAG` char(1) DEFAULT NULL COMMENT '删除标志',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='云谱用户信息表';

-- ----------------------------
--  Records of `demo_user`
-- ----------------------------
BEGIN;
INSERT INTO `demo_user` VALUES ('1', 'qwerqwer', '昵称', '21', '2017-11-09 10:42:49', '2017-11-01 10:51:33', null, '2017-12-15 16:48:38', null, '0');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
