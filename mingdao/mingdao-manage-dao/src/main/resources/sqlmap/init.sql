CREATE TABLE `store` (
`id`  bigint(20) NOT NULL ,
`code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`tel1`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`tel2`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`tel3`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`address`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
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
ROW_FORMAT=COMPACT
;