
delimiter $$
CREATE PROCEDURE update_store_turnover (in inorders integer)
BEGIN
update store
set store.turnover = store.turnover +
(select sum(order_item.pricing) from order_item
where order_item.id
in (select orders_items.items_id from orders_items where orders_id =  inorders))
where store.id = (select orders.store_id from orders where orders.id =  inorders);
END$$