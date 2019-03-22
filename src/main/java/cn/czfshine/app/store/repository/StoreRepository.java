package cn.czfshine.app.store.repository;

import cn.czfshine.app.store.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 商店持久化层
 * @author:czfshine
 * @date:2019/3/22 14:52
 */

public interface StoreRepository extends JpaRepository<Store,Integer> {
}
