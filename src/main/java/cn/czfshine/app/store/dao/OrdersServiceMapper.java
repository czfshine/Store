package cn.czfshine.app.store.dao;

import cn.czfshine.app.store.model.pojo.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface OrdersServiceMapper {
    @Select("select * from product;")
    List<HashMap<String,Object>> getAllOrders();

    @Select("select id,del,ordertime from orders where id=#{id}")
    Orders getOrderById(Integer id);
}
