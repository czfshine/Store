package cn.czfshine.app.store.dao;

import cn.czfshine.app.store.model.pojo.Storage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StorageServiceMapper {

    @Select("select id,count,product_id,store_id from storage")
    List<Storage> getAllStorage();
}
