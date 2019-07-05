package cn.czfshine.app.store.dao;


import cn.czfshine.app.store.model.pojo.Product;
import cn.czfshine.app.store.model.pojo.Sale;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
@Mapper
public interface ProductServiceMapper {

    @Select("select gan from product")
    List<Integer> getAllGan();

    @Select("select * from product where gan = #{ganid} limit 1")
    HashMap<String, Object> getProductByGan(@Param("ganid") Integer ganid);

    @Select("select gan,`name`,pricing,size from (sale left join product on sale.product_id=product.id ) where gan=#{productId}")
    List<HashMap<String, Object>> getSaleInfo(@Param("productId") Integer productId, @Param("storeId") Integer storeId);

    @Update("update storage set count = count-#{downCount} where product_id=#{productId};")
    void downCount(Integer productId, Integer downCount);

    @Update("update storage set count = count+#{downCount} where product_id=#{productId};")
    void upCount(Integer productId, Integer downCount);


    @Select("select * from product where name = #{name} and size= #{size}")
    List<HashMap<String, Object>> getProductByNameAndSize(@Param("name") String name, @Param("size") String size);

    @Insert("  insert into product (gan, name, \n" +
            "      size, instid)\n" +
            "    values ( #{gan,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, \n" +
            "      #{size,jdbcType=VARCHAR}, 1)")
    @SelectKey(statement = "select LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = int.class)
    void insert(Product product);

    @Insert(" insert into sale ( pricing, product_id, \n" +
            "      store_id)\n" +
            "    values ( #{pricing,jdbcType=DECIMAL}, #{productId,jdbcType=INTEGER}, \n" +
            "      #{storeId,jdbcType=INTEGER})")
    void insertSale(Sale sale);
}
