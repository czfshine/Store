package cn.czfshine.app.store.dao;

import cn.czfshine.app.store.model.pojo.Vendor;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface VendorServiceMapper {

    @Select("select id,location,name from vendor where location like '%${sstr}%' or name like '%${sstr}%';")
    List<Vendor> getAllVendor(@Param("sstr") String sstr);

    @Select("select * from vendor where  name='${name}';")
    List<Vendor> getVendorByName(@Param("name") String name);

    @Insert("insert into vendor (location, name ) values ( #{location,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR});")
    void insert(Vendor vendor);
}
