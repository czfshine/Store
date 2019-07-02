DROP DATABASE if exists `storev2`;
CREATE SCHEMA `storev2` DEFAULT CHARACTER SET utf8mb4 ;
use `storev2`	;

-- 类型
DROP TABLE  if exists `type`;
CREATE TABLE `type` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `parent_type_id` int(11) DEFAULT NULL,

  PRIMARY KEY (`id`),
  foreign key (`parent_type_id` ) references `type`(`id`)
);

-- 商品原型 可乐，薯片等
DROP TABLE  if exists `inst_product`;
CREATE TABLE `inst_product` (
  `id` int(11) NOT NULL,
  `productname` varchar(255) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,

  PRIMARY KEY (`id`),
  foreign key (`type_id` ) references `type`(`id`)
) ;

-- 商品
DROP TABLE   if exists `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `gan` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `size` varchar(255) DEFAULT NULL,
  `instid` int(11) DEFAULT NULL,

  PRIMARY KEY (`id`),
  foreign key (`instid` ) references `inst_product`(`id`)
);

-- 商店
DROP TABLE  if exists  `store`;
CREATE TABLE `store` (
  `id` int(11) NOT NULL,
  `local` varchar(255) DEFAULT NULL,
  `storename` varchar(255) DEFAULT NULL,
  `turnover` decimal(19,2) default 0,
  PRIMARY KEY (`id`)
) ;

-- 销售信息
DROP TABLE   if exists `sale`;
CREATE TABLE `sale` (
  `id` int(11) NOT NULL,
  `pricing` decimal(19,2) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `store_id` int(11) DEFAULT NULL,

  PRIMARY KEY (`id`),
  foreign key (`product_id` ) references `product`(`id`),
  foreign key (`store_id` ) references `store`(`id`)
) ;

-- 库存信息
DROP TABLE   if exists `storage`;
CREATE TABLE `storage` (
  `id` int(11) NOT NULL,
  `count` int(11) NOT NULL,
  `product_id` int(11) DEFAULT NULL,
  `store_id` int(11) default 1,
  PRIMARY KEY (`id`),
  foreign key (`product_id` ) references `product`(`id`),
  foreign key (`store_id` ) references `store`(`id`)
) ;

-- 订单项
DROP TABLE   if exists `order_item`;
CREATE TABLE `order_item` (
  `id` int(11) NOT NULL,
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
DROP TABLE  if exists `orders`;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL,
  `del` bit(1) DEFAULT NULL,
  `ordertime` datetime DEFAULT NULL,
  
  `store_id` int(11) default null, 
  -- `customer_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  foreign key (`store_id` ) references `store`(`id`)
) ;


-- 订单和订单项多对多的关系
DROP TABLE  if exists `orders_items`;
CREATE TABLE `orders_items` (
  `orders_id` int(11) NOT NULL,
  `items_id` int(11) NOT NULL,
	primary key (`orders_id`,`items_id`),
foreign key (`orders_id` ) references `orders`(`id`),
foreign key (`items_id` ) references `order_item`(`id`)
) ;

-- 供应商
DROP TABLE  if exists `vendor`;
CREATE TABLE `vendor` (
  `id` int(11) NOT NULL,
  `location` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

-- 进货信息
DROP TABLE  if exists `sold`;
CREATE TABLE `sold` (
  `id` int(11) NOT NULL,
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