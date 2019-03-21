package cn.czfshine.app.store.repository;

import cn.czfshine.app.store.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author:czfshine
 * @date:2019/3/21 22:12
 */

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
}