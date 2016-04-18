DROP DATABASE IF EXISTS databaseWeb;	-- 如果存在，则删除模式 databaseWeb
CREATE DATABASE databaseWeb CHARACTER SET utf8;	-- 创建模式 databaseWeb。使用 utf8 编码

USE databaseWeb;	-- 切换到模式 databaseWeb，以下操作均在 databaseWeb 下

set NAMES 'gbk';	-- 控制台使用 gbk 编码

DROP TABLE IF EXISTS tb_person;	-- 如果存在，删除表 tb_person
CREATE TABLE tb_person (		-- 创建表
  id INTEGER AUTO_INCREMENT COMMENT 'id',
  name VARCHAR(45) COMMENT '姓名',
  english_name VARCHAR(45) COMMENT '英文名',
  age INTEGER UNSIGNED COMMENT '年龄',
  sex VARCHAR(45) COMMENT '性别',
  birthday DATE COMMENT '出生日期',
  description TEXT COMMENT '备注',
  create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP() COMMENT '创建时间',
  PRIMARY KEY (id)
);

INSERT INTO tb_person 	-- 插入数据
( name, english_name, age, sex, birthday, description ) values
( '刘京华', 'Helloweenvsfei', '25', '男', '1982-08-09', '无备注' );

INSERT INTO tb_person 
( name, english_name, age, sex, birthday, description ) values
( '科特柯本', 'Kurt Cobain', '27', '男', '1967-02-20', 'Nirvana' );

INSERT INTO tb_person 
( name, english_name, age, sex, birthday, description ) values
( '王菲', 'Faye', '31', '女', '1969-08-08', '狮子座' );

INSERT INTO tb_person 
( name, english_name, age, sex, birthday, description ) values
( '艾薇儿', 'Avril Lavigne', '24', '女', '1984-09-27', '星座：天秤座' );

INSERT INTO tb_person 
( name, english_name, age, sex, birthday, description ) values
( 'W. AXL ROSE', 'W. AXL ROSE', '45', '男', '1962-02-06', 'GNR' );

INSERT INTO tb_person 
( name, english_name, age, sex, birthday, description ) values
( '柯蒂斯', 'Ian Curtis', '50', '男', '1956-07-15', 'Joy Division' );

INSERT INTO tb_person 
( name, english_name, age, sex, birthday, description ) values
( '巴菲特', 'Warren Buffett', '78', '女', '1930-08-30', 'Stock' );

INSERT INTO tb_person 
( name, english_name, age, sex, birthday, description ) values
( '比尔盖茨', 'Bill Gates', '18', '女', '1955-10-28', 'Microsoft' );


DROP TABLE IF EXISTS tb_book;	-- 如果存在，删除表 tb_person

CREATE TABLE tb_book (		-- 创建表
  id INTEGER AUTO_INCREMENT COMMENT 'id',
  person_id INTEGER, 
  name VARCHAR(45) COMMENT '数目',
  publish_date DATE COMMENT '出版日期',
  description TEXT COMMENT '备注',
  create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP() COMMENT '创建时间',
  PRIMARY KEY (id)
);

