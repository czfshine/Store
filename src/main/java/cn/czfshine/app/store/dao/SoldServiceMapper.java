package cn.czfshine.app.store.dao;

import cn.czfshine.app.store.model.pojo.Sold;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
@Mapper
public interface SoldServiceMapper {

    @Insert("insert into sold ( count, pricing, \n" +
            "      product_id, store_id,vendor_id)\n" +
            "    values (#{count,jdbcType=INTEGER}, #{pricing,jdbcType=DECIMAL}, \n" +
            "      #{productId,jdbcType=INTEGER}, #{storeId,jdbcType=INTEGER}, #{vendorId,jdbcType=INTEGER})")
    void insert(Sold sold);


    @Select("select product.name as proname,size,vendor.name as vendorname, count,pricing from " +
            "(sold left join product on product_id=product.id) " +
            "left join vendor on vendor_id=vendor.id " +
            "where product.name like '%${str}%' " +
            "or size like '%${str}%' " +
            "or vendor.name like '%${str}%' " +
            "or cast(count as char) like '%${str}%' " +
            "or cast(pricing as char) like '%${str}%'  ")
    List<HashMap<String, Object>> list(@Param("str") String str);

    @Select("SELECT product_id,gan,name,size,count,pricing FROM nosale left join sold on nosale.id =sold.product_id;")
    List<HashMap<String, Object>> getNoSaleProduct();
}
