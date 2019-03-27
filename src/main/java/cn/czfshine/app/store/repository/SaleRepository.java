package cn.czfshine.app.store.repository;

import cn.czfshine.app.store.model.Product;
import cn.czfshine.app.store.model.Sale;
import cn.czfshine.app.store.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Table;
import java.util.List;

/**
 * @author:czfshine
 * @date:2019/3/22 15:09
 */

public interface SaleRepository extends JpaRepository<Sale,Integer> {

    //List<Sale> findAllByStoreIs(Store store);
    Sale findByProductAndStore(Product product,Store store);
}
