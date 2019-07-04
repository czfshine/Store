package cn.czfshine.app.store.dao;

import cn.czfshine.app.store.model.pojo.Orders;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface OrdersServiceMapper {


    @Select("select orders.id as id, sum(pricing) as total,count(product_id) as `count`,ordertime  from (orders left join orders_items on orders_id=orders.id) left join order_item on items_id = order_item.id Group by orders.id;")
    List<HashMap<String, Object>> getAllOrders();

    @Select("select id,del,ordertime from orders where id=#{id}")
    Orders getOrderById(Integer id);

    @Insert(" insert into orders (del, ordertime) values ( #{del,jdbcType=BIT}, #{ordertime,jdbcType=TIMESTAMP})")
    @SelectKey(statement = "select LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = int.class)
    void insert(Orders orders);
}
