package cn.czfshine.app.store.dao;

import cn.czfshine.app.store.model.pojo.Vendor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface VendorServiceMapper {

    @Select("select id,location,name from vendor")
    List<Vendor> getAllVendor();

}
