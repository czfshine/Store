package cn.czfshine.app.store.dao;

import cn.czfshine.app.store.model.pojo.Sale;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface ProductServiceMapper {

    @Select("select gan from product")
    List<Integer> getAllGan();

    @Select("select * from product where gan = #{ganid} limit 1")
    HashMap<String,Object> getProductByGan(@Param("ganid") Integer ganid);

    @Select("select id,pricing,product_id,store_id from sale where product_id=#{productId} " +
            "and store_id=#{storeId}")
    Sale getSaleInfo(@Param("productId") Integer productId, @Param("storeId") Integer storeId);
}
