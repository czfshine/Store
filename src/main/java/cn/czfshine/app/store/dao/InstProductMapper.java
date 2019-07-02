package cn.czfshine.app.store.dao;



import cn.czfshine.app.store.model.pojo.InstProduct;
import cn.czfshine.app.store.model.pojo.InstProductExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InstProductMapper {
    int countByExample(InstProductExample example);

    int deleteByExample(InstProductExample example);

    int insert(InstProduct record);

    int insertSelective(InstProduct record);

    List<InstProduct> selectByExample(InstProductExample example);

    int updateByExampleSelective(@Param("record") InstProduct record, @Param("example") InstProductExample example);

    int updateByExample(@Param("record") InstProduct record, @Param("example") InstProductExample example);
}