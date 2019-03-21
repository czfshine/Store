package cn.czfshine.app.store.repository;

import cn.czfshine.app.store.model.InstProduct;
import org.springframework.data.jpa.repository.JpaRepository;

/**商品原型的持久化层
 * @author:czfshine
 * @date:2019/3/21 19:58
 */

public interface InstProductRepository extends JpaRepository<InstProduct,Integer> {
}
