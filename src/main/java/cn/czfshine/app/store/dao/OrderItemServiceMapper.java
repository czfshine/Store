package cn.czfshine.app.store.dao;

import cn.czfshine.app.store.model.pojo.OrderItem;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

@Mapper
public interface OrderItemServiceMapper {

    @Insert("insert into order_item (count,pricing,product_id) values (#{count},#{pricing},#{productId})")
    @SelectKey(statement="select LAST_INSERT_ID()", keyProperty="id", before=false, resultType=int.class)
    void insertAndGetIdInplace(OrderItem orderItem);
    @Insert("insert into orders_items values (#{orderid},#{itemid})")
    void insertOrderItems(int orderid,int itemid);
    @Select("call update_store_turnover(#{orderid})")
    void call(Integer orderid);

}
