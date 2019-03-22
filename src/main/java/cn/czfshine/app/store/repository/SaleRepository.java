package cn.czfshine.app.store.repository;

import cn.czfshine.app.store.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author:czfshine
 * @date:2019/3/22 15:09
 */

public interface SaleRepository extends JpaRepository<Sale,Integer> {
}
