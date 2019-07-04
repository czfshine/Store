-- DROP DATABASE if exists `storev2`;
-- CREATE SCHEMA `storev2` DEFAULT CHARACTER SET utf8mb4 ;
 use `storev2`	;
 
 
 
 
 DROP TABLE  if exists `sold`;
 DROP TABLE  if exists `vendor`;
 DROP TABLE  if exists `orders_items`;
 DROP TABLE  if exists `orders`;
 DROP TABLE   if exists `order_item`;
 DROP TABLE   if exists `storage`;
 
 DROP TABLE   if exists `sale`;
 DROP TABLE  if exists  `store`;
DROP TABLE   if exists `product`;
DROP TABLE  if exists `inst_product`;
DROP TABLE  if exists `type`;

-- 类型

CREATE TABLE `type` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) DEFAULT NULL,
  `parent_type_id` int(11) DEFAULT NULL,

  PRIMARY KEY (`id`),
  foreign key (`parent_type_id` ) references `type`(`id`)
);

-- 商品原型 可乐，薯片等

CREATE TABLE `inst_product` (
  `id` int(11) NOT NULL auto_increment,
  `productname` varchar(255) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,

  PRIMARY KEY (`id`),
  foreign key (`type_id` ) references `type`(`id`)
) ;

-- 商品

CREATE TABLE `product` (
  `id` int(11) NOT NULL auto_increment,
  `gan` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `size` varchar(255) DEFAULT NULL,
  `instid` int(11) DEFAULT NULL,

  PRIMARY KEY (`id`),
  foreign key (`instid` ) references `inst_product`(`id`)
);

-- 商店

CREATE TABLE `store` (
  `id` int(11) NOT NULL,
  `local` varchar(255) DEFAULT NULL,
  `storename` varchar(255) DEFAULT NULL,
  `turnover` decimal(19,2) default 0,
  PRIMARY KEY (`id`)
) ;

-- 销售信息

CREATE TABLE `sale` (
  `id` int(11) NOT NULL auto_increment,
  `pricing` decimal(19,2) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `store_id` int(11) DEFAULT NULL,

  PRIMARY KEY (`id`),
  foreign key (`product_id` ) references `product`(`id`),
  foreign key (`store_id` ) references `store`(`id`)
) ;

-- 库存信息

CREATE TABLE `storage` (
  `id` int(11) NOT NULL auto_increment,
  `count` int(11) NOT NULL,
  `product_id` int(11) DEFAULT NULL,
  `store_id` int(11) default 1,
  PRIMARY KEY (`id`),
  foreign key (`product_id` ) references `product`(`id`),
  foreign key (`store_id` ) references `store`(`id`)
) ;

-- 订单项

CREATE TABLE `order_item` (
  `id` int(11) NOT NULL auto_increment,
  `count` double DEFAULT NULL,
  `pricing` decimal(19,2) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  foreign key (`product_id` ) references `product`(`id`)
);


-- DROP TABLE `customer`;
-- CREATE TABLE `customer` (
--   `id` int(11) NOT NULL,
--   `address` varchar(255) DEFAULT NULL,
--   `name` varchar(255) DEFAULT NULL,
--   `telephone` varchar(255) DEFAULT NULL,
--   PRIMARY KEY (`id`)
-- );

-- 订单

CREATE TABLE `orders` (
  `id` int(11) NOT NULL auto_increment,
  `del` bit(1) DEFAULT NULL,
  `ordertime` datetime DEFAULT NULL,
  
  `store_id` int(11) default 1, 
  -- `customer_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  foreign key (`store_id` ) references `store`(`id`)
) ;


-- 订单和订单项多对多的关系

CREATE TABLE `orders_items` (
  `orders_id` int(11) NOT NULL,
  `items_id` int(11) NOT NULL,
	primary key (`orders_id`,`items_id`),
foreign key (`orders_id` ) references `orders`(`id`),
foreign key (`items_id` ) references `order_item`(`id`)
) ;

-- 供应商

CREATE TABLE `vendor` (
  `id` int(11) NOT NULL auto_increment,
  `location` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

-- 进货信息

CREATE TABLE `sold` (
  `id` int(11) NOT NULL auto_increment,
  `count` int(11) NOT NULL,
  `pricing` decimal(19,2) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `store_id` int(11) DEFAULT NULL,
  `vendor_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),

  foreign key (`product_id` ) references `product`(`id`),
  foreign key (`store_id` ) references `store`(`id`),
  foreign key (`vendor_id` ) references `vendor`(`id`)
) ;