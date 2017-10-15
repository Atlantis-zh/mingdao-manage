
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

DROP TABLE IF EXISTS `wechatinfo`;
/*微信关注列表*/
CREATE TABLE wechatinfo (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`mnname`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`storeid`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`tel`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`address`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`relationcust`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`status`  smallint(1) NULL DEFAULT NULL ,
`sex`  smallint(1) NULL DEFAULT NULL ,
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

/*客户基本信息*/
CREATE TABLE `customer` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`storeid`  bigint(20) NULL DEFAULT NULL ,
`name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`code`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`wxnickname`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`birthday`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`phone`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`identityid`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`custsource`  int(11) NULL DEFAULT NULL ,
`custtypeid`  bigint(20) NULL DEFAULT NULL ,
`lpr`  tinyint(4) NULL DEFAULT NULL ,
`sex`  int(11) NULL DEFAULT NULL ,
`address`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
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

/*车辆信息*/
CREATE TABLE `car_info` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`customerid`  bigint(20) NULL DEFAULT NULL ,
`plannumber`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`carprice`  double NULL DEFAULT NULL ,
`annualexpiration`  datetime NULL DEFAULT NULL ,
`addressofperson`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`nextservicecyc`  double NULL DEFAULT NULL ,
`vin`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`buycartime`  datetime NULL DEFAULT NULL ,
`brandid`  bigint(20) NULL DEFAULT NULL ,
`insurecompany`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`insureexpir`  datetime NULL DEFAULT NULL ,
`precyc`  double NULL DEFAULT NULL ,
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







