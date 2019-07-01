package cn.czfshine.app.store.dao;

import cn.czfshine.app.store.pojo.Vendor;
import cn.czfshine.app.store.pojo.VendorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VendorMapper {
    int countByExample(VendorExample example);

    int deleteByExample(VendorExample example);

    int insert(Vendor record);

    int insertSelective(Vendor record);

    List<Vendor> selectByExample(VendorExample example);

    int updateByExampleSelective(@Param("record") Vendor record, @Param("example") VendorExample example);

    int updateByExample(@Param("record") Vendor record, @Param("example") VendorExample example);
}