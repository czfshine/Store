package cn.czfshine.app.store.dao;

import cn.czfshine.app.store.model.pojo.Orders;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
@Mapper
public interface OrdersServiceMapper {


    @Select("select orders.id as id, sum(pricing) as total,count(product_id) as `count`,ordertime  from (orders left join orders_items on orders_id=orders.id) left join order_item on items_id = order_item.id Group by orders.id;")
    List<HashMap<String, Object>> getAllOrders();


    @Select("SELECT name,size,count,pricing,orders_id,items_id ,product_id as productId FROM ((orders left join orders_items on orders.id = orders_items.orders_id) left join order_item on orders_items.items_id = order_item.id) left join product on product_id =product.id where orders.id = #{id};")
    List<HashMap<String, Object>> getOrderById(Integer id);

    @Insert(" insert into orders (del, ordertime) values ( #{del,jdbcType=BIT}, #{ordertime,jdbcType=TIMESTAMP})")
    @SelectKey(statement = "select LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = int.class)
    void insert(Orders orders);

    @Delete("DELETE FROM orders_items where orders_id = #{orderId} and items_id = #{itemId};")
    void delItems(Integer orderId, Integer itemId);
}
