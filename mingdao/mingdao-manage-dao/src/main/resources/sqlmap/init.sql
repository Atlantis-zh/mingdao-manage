
DROP TABLE IF EXISTS `userinfo`;
/*用户注册*/
CREATE TABLE `userinfo` (
`password`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`nickname`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`usercode`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`username`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`status`  smallint(1) NULL DEFAULT NULL ,
`phone`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`email`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`creator`  bigint(20) NULL DEFAULT NULL ,
`modifiedtime`  datetime NULL DEFAULT NULL ,
`modifier`  bigint(20) NULL DEFAULT NULL ,
`createtime`  datetime NULL DEFAULT NULL ,
`shop`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=2
ROW_FORMAT=COMPACT
;

DROP TABLE IF EXISTS `store`;
/*门店*/
CREATE TABLE store (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`tel1`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`tel2`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`tel3`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`address`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`iswxshow`  tinyint(1) NULL DEFAULT NULL ,
`iswxdefault`  tinyint(1) NULL DEFAULT NULL ,
`isheadstore`  tinyint(1) NULL DEFAULT NULL ,
`creator`  bigint(20) NULL DEFAULT NULL ,
`createtime`  datetime NULL DEFAULT NULL ,
`modifier`  bigint(20) NULL DEFAULT NULL ,
`modifiedtime`  datetime NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1
ROW_FORMAT=COMPACT
;

