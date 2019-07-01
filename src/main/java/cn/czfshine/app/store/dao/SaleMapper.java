package cn.czfshine.app.store.dao;

import cn.czfshine.app.store.pojo.Sale;
import cn.czfshine.app.store.pojo.SaleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SaleMapper {
    int countByExample(SaleExample example);

    int deleteByExample(SaleExample example);

    int insert(Sale record);

    int insertSelective(Sale record);

    List<Sale> selectByExample(SaleExample example);

    int updateByExampleSelective(@Param("record") Sale record, @Param("example") SaleExample example);

    int updateByExample(@Param("record") Sale record, @Param("example") SaleExample example);
}