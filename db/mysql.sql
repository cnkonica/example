CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
  `name` varchar(20) DEFAULT NULL COMMENT '名字' ,
  `age` int(3) DEFAULT NULL COMMENT '年龄' ,
  `salary` decimal(6,2) DEFAULT NULL COMMENT '工资' ,
  `deleted` tinyint(02) DEFAULT '0' COMMENT '删除标志' ,
  `creator` varchar(20) DEFAULT 'system' COMMENT '创建人' ,
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
  `updator` varchar(20) DEFAULT 'system' COMMENT '更行人' ,
  `gmt_updated` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间' ,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB ;
