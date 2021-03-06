package cn.czfshine.app.store.dao;

import cn.czfshine.app.store.model.pojo.Storage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
@Mapper
public interface StorageServiceMapper {

    //todo sql 注入攻击
    @Select("select name,size,gan,count from " +
            "storage left join product on storage.product_id=product.id " +
            "where name like '%${str}%' " +
            "or size like '%${str}%' " +
            "or cast(gan as char) like '%${str}%' " +
            "or cast(count as char) like '%${str}%' ")
    List<HashMap<String, Object>> getAllStorage(@Param("str") String str);

    @Select("select count from storage left join product on storage.product_id=product.id where gan = #{gan}")
    Integer getCount(Integer gan);

    @Select("select turnover from store where id = 1 limit 1;")
    Double getTurnover();

    @Insert("insert into storage (store_id, count, product_id\n" +
            "      )\n" +
            "    values (#{storeId,jdbcType=INTEGER}, #{count,jdbcType=INTEGER}, #{productId,jdbcType=INTEGER}\n" +
            "      )")
    void insert(Storage storage);
}
