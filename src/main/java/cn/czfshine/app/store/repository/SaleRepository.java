package cn.czfshine.app.store.repository;

import cn.czfshine.app.store.model.Product;
import cn.czfshine.app.store.model.Sale;
import cn.czfshine.app.store.model.Store;
import cn.czfshine.app.store.model.dto.SaleInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Table;
import java.util.List;

/**
 * @author:czfshine
 * @date:2019/3/22 15:09
 */

public interface SaleRepository extends JpaRepository<Sale,Integer> {
    //List<Sale> findAllByStoreIs(Store store);
    Sale findByProductAndStore(Product product,Store store);
    @Query(value = "select name,`size`,prcing from sale join sale.product p where p.proid = :proid ",nativeQuery = true)
    List<SaleInfo> findAllSaleInfo();
}
