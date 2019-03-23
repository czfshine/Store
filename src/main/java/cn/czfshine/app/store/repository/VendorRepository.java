package cn.czfshine.app.store.repository;

import cn.czfshine.app.store.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * wrote by xuming.
 * 依葫芦画瓢
 * 刚刚添加的5个实体类没有在repository包下创建相应接口
 * 现在补上
 */
public interface VendorRepository extends JpaRepository<Vendor,Integer> {
}
