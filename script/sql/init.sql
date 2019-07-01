INSERT INTO `storev2`.`type` (`id`, `name`, `parent_type_id`) VALUES ('1', '食品', NULL);
INSERT INTO `storev2`.`type` (`id`, `name`) VALUES ('2', '日用品');
INSERT INTO `storev2`.`type` (`id`, `name`) VALUES ('3', '文具');
INSERT INTO `storev2`.`type` (`id`, `name`, `parent_type_id`) VALUES ('4', '薯片', '1');
INSERT INTO `storev2`.`type` (`id`, `name`, `parent_type_id`) VALUES ('5', '饮料', '1');
INSERT INTO `storev2`.`type` (`id`, `name`, `parent_type_id`) VALUES ('6', '洗发水', '2');
INSERT INTO `storev2`.`type` (`id`, `name`, `parent_type_id`) VALUES ('7', '牙膏', '2');
INSERT INTO `storev2`.`type` (`id`, `name`, `parent_type_id`) VALUES ('8', '笔', '3');
INSERT INTO `storev2`.`type` (`id`, `name`, `parent_type_id`) VALUES ('9', '本子', '3');

INSERT INTO `storev2`.`inst_product` (`id`, `productname`, `type_id`) VALUES ('1', '可乐', '5');
INSERT INTO `storev2`.`inst_product` (`id`, `productname`, `type_id`) VALUES ('2', '薯片', '4');
INSERT INTO `storev2`.`inst_product` (`id`, `productname`, `type_id`) VALUES ('3', '铅笔', '8');
INSERT INTO `storev2`.`inst_product` (`id`, `productname`, `type_id`) VALUES ('4', '圆珠笔', '8');
INSERT INTO `storev2`.`inst_product` (`id`, `productname`, `type_id`) VALUES ('5', '草稿本', '9');
INSERT INTO `storev2`.`inst_product` (`id`, `productname`, `type_id`) VALUES ('6', '作业本', '9');
INSERT INTO `storev2`.`inst_product` (`id`, `productname`, `type_id`) VALUES ('7', '牙膏', '7');
INSERT INTO `storev2`.`inst_product` (`id`, `productname`, `type_id`) VALUES ('8', '洗发水', '6');
INSERT INTO `storev2`.`inst_product` (`id`, `productname`, `type_id`) VALUES ('9', '哇哈哈', '5');
INSERT INTO `storev2`.`inst_product` (`id`, `productname`, `type_id`) VALUES ('10', '脉动', '5');


INSERT INTO `storev2`.`product` (`id`, `gan`, `name`, `size`, `instid`) VALUES ('1', '123456', '可口可乐', '330ml', '1');
INSERT INTO `storev2`.`product` (`id`, `gan`, `name`, `size`, `instid`) VALUES ('2', '654321', '可口可乐', '500ml', '1');
INSERT INTO `storev2`.`product` (`id`, `gan`, `name`, `size`, `instid`) VALUES ('3', '147852', '可口可乐', '1L', '1');
INSERT INTO `storev2`.`product` (`id`, `gan`, `name`, `size`, `instid`) VALUES ('4', '963258', '飘柔洗发水', '1kg', '8');
INSERT INTO `storev2`.`product` (`id`, `gan`, `name`, `size`, `instid`) VALUES ('5', '789654', '去屑洗发水', '1kg', '8');
INSERT INTO `storev2`.`product` (`id`, `gan`, `name`, `size`, `instid`) VALUES ('6', '123698', '小瓶哇哈哈', '500ml', '9');
INSERT INTO `storev2`.`product` (`id`, `gan`, `name`, `size`, `instid`) VALUES ('7', '852147', '大瓶哇哈哈', '1L', '9');
INSERT INTO `storev2`.`product` (`id`, `gan`, `name`, `size`, `instid`) VALUES ('8', '785214', '自动铅笔', '1', '3');
INSERT INTO `storev2`.`product` (`id`, `gan`, `name`, `size`, `instid`) VALUES ('9', '951357', '传统铅笔', '1', '3');
INSERT INTO `storev2`.`product` (`id`, `gan`, `name`, `size`, `instid`) VALUES ('10', '842651', '可比克薯片', '50g', '4');
INSERT INTO `storev2`.`product` (`id`, `gan`, `name`, `size`, `instid`) VALUES ('11', '147253', '好吃薯片', '100g', '4');

INSERT INTO `storev2`.`store` (`id`, `local`, `storename`) VALUES ('1', '华南农业大学泰山区学生宿舍', '泰山超市');
INSERT INTO `storev2`.`store` (`id`, `local`, `storename`) VALUES ('2', '华南农业大学华山区学生宿舍', '华山超市');
INSERT INTO `storev2`.`store` (`id`, `local`, `storename`) VALUES ('3', '华南农业大学燕山区学生宿舍', '燕山超市');

INSERT INTO `storev2`.`sale` (`id`, `pricing`, `product_id`, `store_id`) VALUES ('1', '3.5', '1', '1');
INSERT INTO `storev2`.`sale` (`id`, `pricing`, `product_id`, `store_id`) VALUES ('2', '5', '2', '1');
INSERT INTO `storev2`.`sale` (`id`, `pricing`, `product_id`, `store_id`) VALUES ('3', '7', '3', '1');
INSERT INTO `storev2`.`sale` (`id`, `pricing`, `product_id`, `store_id`) VALUES ('4', '50', '4', '1');
INSERT INTO `storev2`.`sale` (`id`, `pricing`, `product_id`, `store_id`) VALUES ('5', '55', '5', '1');
INSERT INTO `storev2`.`sale` (`id`, `pricing`, `product_id`, `store_id`) VALUES ('6', '4', '6', '1');
INSERT INTO `storev2`.`sale` (`id`, `pricing`, `product_id`, `store_id`) VALUES ('7', '8', '7', '1');
INSERT INTO `storev2`.`sale` (`id`, `pricing`, `product_id`, `store_id`) VALUES ('8', '2', '8', '1');
INSERT INTO `storev2`.`sale` (`id`, `pricing`, `product_id`, `store_id`) VALUES ('9', '1', '9', '1');
INSERT INTO `storev2`.`sale` (`id`, `pricing`, `product_id`, `store_id`) VALUES ('10', '10.5', '10', '1');
INSERT INTO `storev2`.`sale` (`id`, `pricing`, `product_id`, `store_id`) VALUES ('11', '21.5', '11', '1');

INSERT INTO `storev2`.`storage` (`id`, `count`, `product_id`, `store_id`) VALUES ('1', '20', '1', '1');
INSERT INTO `storev2`.`storage` (`id`, `count`, `product_id`, `store_id`) VALUES ('2', '30', '2', '1');
INSERT INTO `storev2`.`storage` (`id`, `count`, `product_id`, `store_id`) VALUES ('3', '40', '3', '1');
INSERT INTO `storev2`.`storage` (`id`, `count`, `product_id`, `store_id`) VALUES ('4', '50', '4', '1');
INSERT INTO `storev2`.`storage` (`id`, `count`, `product_id`, `store_id`) VALUES ('5', '60', '5', '1');
INSERT INTO `storev2`.`storage` (`id`, `count`, `product_id`, `store_id`) VALUES ('6', '70', '6', '1');
INSERT INTO `storev2`.`storage` (`id`, `count`, `product_id`, `store_id`) VALUES ('7', '80', '7', '1');
INSERT INTO `storev2`.`storage` (`id`, `count`, `product_id`, `store_id`) VALUES ('8', '90', '8', '1');
INSERT INTO `storev2`.`storage` (`id`, `count`, `product_id`, `store_id`) VALUES ('9', '10', '9', '1');
INSERT INTO `storev2`.`storage` (`id`, `count`, `product_id`, `store_id`) VALUES ('10', '20', '10', '1');
INSERT INTO `storev2`.`storage` (`id`, `count`, `product_id`, `store_id`) VALUES ('11', '30', '11', '1');

INSERT INTO `storev2`.`vendor` (`id`, `location`, `name`) VALUES ('1', '广州', '第一经销商');
INSERT INTO `storev2`.`vendor` (`id`, `location`, `name`) VALUES ('2', '北京', '最棒经销商');
INSERT INTO `storev2`.`vendor` (`id`, `location`, `name`) VALUES ('3', '上海', '最好经销商');
INSERT INTO `storev2`.`vendor` (`id`, `location`, `name`) VALUES ('4', '深圳', '最大经销商');
INSERT INTO `storev2`.`vendor` (`id`, `location`, `name`) VALUES ('5', '美国', '最远经销商');

INSERT INTO `storev2`.`sold` (`id`, `count`, `pricing`, `product_id`, `store_id`, `vendor_id`) VALUES ('1', '20', '3', '1', '1', '1');
INSERT INTO `storev2`.`sold` (`id`, `count`, `pricing`, `product_id`, `store_id`, `vendor_id`) VALUES ('2', '30', '4', '2', '1', '2');
INSERT INTO `storev2`.`sold` (`id`, `count`, `pricing`, `product_id`, `store_id`, `vendor_id`) VALUES ('3', '40', '6', '3', '1', '3');
INSERT INTO `storev2`.`sold` (`id`, `count`, `pricing`, `product_id`, `store_id`, `vendor_id`) VALUES ('4', '50', '45', '4', '1', '4');
INSERT INTO `storev2`.`sold` (`id`, `count`, `pricing`, `product_id`, `store_id`, `vendor_id`) VALUES ('5', '60', '50', '5', '1', '1');
INSERT INTO `storev2`.`sold` (`id`, `count`, `pricing`, `product_id`, `store_id`, `vendor_id`) VALUES ('6', '70', '3', '6', '1', '2');
INSERT INTO `storev2`.`sold` (`id`, `count`, `pricing`, `product_id`, `store_id`, `vendor_id`) VALUES ('7', '80', '7', '7', '1', '3');
INSERT INTO `storev2`.`sold` (`id`, `count`, `pricing`, `product_id`, `store_id`, `vendor_id`) VALUES ('8', '90', '1.5', '8', '1', '4');
INSERT INTO `storev2`.`sold` (`id`, `count`, `pricing`, `product_id`, `store_id`, `vendor_id`) VALUES ('9', '10', '0.5', '9', '1', '1');
INSERT INTO `storev2`.`sold` (`id`, `count`, `pricing`, `product_id`, `store_id`, `vendor_id`) VALUES ('10', '20', '10', '10', '1', '2');
INSERT INTO `storev2`.`sold` (`id`, `count`, `pricing`, `product_id`, `store_id`, `vendor_id`) VALUES ('11', '30', '21', '11', '1', '3');
