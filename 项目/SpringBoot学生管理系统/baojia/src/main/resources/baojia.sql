CREATE TABLE `sys_user`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_name` varchar(30) NOT NULL COMMENT '用户名',
  `real_name` varchar(30) NULL COMMENT '真实名',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `sex` tinyint(2) NOT NULL DEFAULT 10 COMMENT '性别10:男;11:女;12:其他',
  `avatar` varchar(100) NULL COMMENT '头像地址',
  `introduction` varchar(100) NULL COMMENT '简介',
  `status` tinyint(2) NOT NULL DEFAULT 10 COMMENT '账号状态10:正常;20:锁定;30:注销',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标识0(true):未删除;1(false):已删除',
  `create_by` varchar(30) NULL COMMENT '创建者',
  `create_time` timestamp NULL COMMENT '创建时间',
  `update_by` varchar(30) NULL COMMENT '更新者',
  `update_time` timestamp NULL COMMENT '更新时间',
  `remark` varchar(100) NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表';
INSERT INTO baojia.sys_user (user_name,real_name,password,sex,avatar,introduction,status,del_flag,create_user,create_time,update_user,update_time,remark) VALUES
('admin','admin','123456',30,'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif','I am a super administrator',10,0,'admin',NULL,'admin',NULL,NULL);

CREATE TABLE `sys_role`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `role_code` varchar(20) NOT NULL COMMENT '角色编号',
  `role_name` varchar(30) NULL COMMENT '角色名称',
  `status` tinyint(2) NOT NULL DEFAULT 10 COMMENT '角色状态10:正常;20:锁定;30:注销',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标识0(true):未删除;1(false):已删除',
  `create_by` varchar(30) NULL COMMENT '创建者',
  `create_time` timestamp NULL COMMENT '创建时间',
  `update_by` varchar(30) NULL COMMENT '更新者',
  `update_time` timestamp NULL COMMENT '更新时间',
  `remark` varchar(100) NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表';
INSERT INTO baojia.sys_role (role_code,role_name,status,del_flag,create_user,create_time,update_user,update_time,remark) VALUES
('admin','超级管理员',10,0,'admin',NULL,'admin',NULL,NULL);

CREATE TABLE `sys_menu`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `menu_name` varchar(30) NULL DEFAULT 0 COMMENT '菜单名称',
  `parent_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '父级菜单ID',
  `order_num` tinyint(2) NOT NULL DEFAULT 1 COMMENT '显示顺序',
  `url` varchar(100) NOT NULL DEFAULT '#' COMMENT '请求地址',
  `menu_type` tinyint(2) NULL COMMENT '菜单类型10:目录;20:菜单;30:按钮',
  `visible` tinyint(2) NOT NULL DEFAULT 10 COMMENT '菜单状态10:显示;20:隐藏',
  `perms` varchar(100) NULL COMMENT '权限标识',
  `icon` varchar(100) NOT NULL DEFAULT '#' COMMENT '菜单图标',
  `create_by` varchar(30) NULL COMMENT '创建者',
  `create_time` timestamp NULL COMMENT '创建时间',
  `update_by` varchar(30) NULL COMMENT '更新者',
  `update_time` timestamp NULL COMMENT '更新时间',
  `remark` varchar(100) NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单权限表';

CREATE TABLE `sys_user_role`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` bigint(20) UNSIGNED NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) UNSIGNED NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色关联表';
INSERT INTO baojia.sys_user_role (user_id,role_id) VALUES (1,1);
CREATE TABLE `sys_role_menu`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `role_id` bigint(20) UNSIGNED NOT NULL COMMENT '角色ID',
  `mene_id` bigint(20) UNSIGNED NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色菜单关联表';