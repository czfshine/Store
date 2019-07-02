package cn.czfshine.app.store.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface OrdersServiceMapper {
    @Select("select * from product;")
    List<HashMap<String,Object>> getAllOrders();
}
