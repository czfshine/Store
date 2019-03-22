package cn.czfshine.app.store.repository;

import cn.czfshine.app.store.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 商品类别持久化层
 * @author:czfshine
 * @date:2019/3/22 14:23
 */

public interface TypeRepository extends JpaRepository<Type,Integer> {
}
