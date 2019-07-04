package cn.czfshine.app.store.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface ProductServiceMapper {

    @Select("select gan from product")
    List<Integer> getAllGan();

    @Select("select * from product where gan = #{ganid} limit 1")
    HashMap<String,Object> getProductByGan(@Param("ganid") Integer ganid);

    @Select("select gan,`name`,pricing,size from (sale left join product on sale.product_id=product.id ) where gan=#{productId}")
    List<HashMap<String,Object>> getSaleInfo(@Param("productId") Integer productId, @Param("storeId") Integer storeId);

    @Update("update storage set count = count-#{downCount} where product_id=#{productId};")
    void downCount(Integer productId,Integer downCount);
}
