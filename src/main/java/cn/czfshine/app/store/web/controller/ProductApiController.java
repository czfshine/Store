package cn.czfshine.app.store.web.controller;

import cn.czfshine.app.store.exception.ApiResourceNotFoundException;
import cn.czfshine.app.store.model.Product;
import cn.czfshine.app.store.model.Sale;
import cn.czfshine.app.store.model.Store;
import cn.czfshine.app.store.model.dto.AllGan;
import cn.czfshine.app.store.repository.ProductRepository;
import cn.czfshine.app.store.repository.SaleRepository;
import cn.czfshine.app.store.repository.StoreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author:czfshine
 * @date:2019/3/25 23:30
 */

@RestController
@Slf4j
public class ProductApiController {
    private final ProductRepository productRepository;
    private final StoreRepository storeRepository;
    private final SaleRepository saleRepository;
    public ProductApiController(ProductRepository productRepository, StoreRepository storeRepository, SaleRepository saleRepository) {
        this.productRepository = productRepository;
        this.storeRepository = storeRepository;
        this.saleRepository = saleRepository;
    }

    /** 获取当前数据库中的所有商品唯一识别码
     * @return
     */
    @GetMapping("/api/getallgan")
    public AllGan getAllGan() {

        AllGan res = new AllGan();
        ArrayList<Long> longs = new ArrayList<>();

        List<Product> all = productRepository.findAll();
        for (Product p : all) {
            longs.add(p.getGan());
        }

        res.setData(longs);
        log.info("get all gan number: size=" + longs.size());
        return res;
    }

    /**
     * 根据商品的唯一识别码获取商品信息
     * @param gan
     * @return 对应的商品信息
     * @throws ApiResourceNotFoundException
     */
    @GetMapping("/api/Product/gan/{gan}")
    public Product getByGan(@PathVariable Long gan) throws ApiResourceNotFoundException {
        Product firstByGan = productRepository.findFirstByGan(gan);
        if(firstByGan==null)
            throw new ApiResourceNotFoundException("");
        return firstByGan;
    }


    /**取对应商店的对应商品的销售信息
     * @param proId
     * @param storeId
     * @return
     * @throws ApiResourceNotFoundException
     */
    @GetMapping("/api/sale")
    public Sale getSaleInfo(@RequestParam("productid") int proId,
                            @RequestParam("storeid") int storeId) throws ApiResourceNotFoundException {
        Optional<Store> byId = storeRepository.findById(storeId);
        if(!byId.isPresent()){
            throw new ApiResourceNotFoundException("store id="+storeId+"不存在");
        }
        Store store = byId.get();
        Optional<Product> productid=productRepository.findById(proId);
        if(!productid.isPresent()){
            throw new ApiResourceNotFoundException("product id="+productid+"不存在");
        }
        Product product = productid.get();
        Sale byProductAndStore = saleRepository.findByProductAndStore(product, store);
        if(byProductAndStore==null){
            throw new ApiResourceNotFoundException("商店没有销售该商品");
        }
        return byProductAndStore;
    }
}

