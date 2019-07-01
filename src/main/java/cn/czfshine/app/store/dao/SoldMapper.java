package cn.czfshine.app.store.dao;

import cn.czfshine.app.store.pojo.Sold;
import cn.czfshine.app.store.pojo.SoldExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SoldMapper {
    int countByExample(SoldExample example);

    int deleteByExample(SoldExample example);

    int insert(Sold record);

    int insertSelective(Sold record);

    List<Sold> selectByExample(SoldExample example);

    int updateByExampleSelective(@Param("record") Sold record, @Param("example") SoldExample example);

    int updateByExample(@Param("record") Sold record, @Param("example") SoldExample example);
}