package cn.czfshine.app.store.web.controller;

import cn.czfshine.app.store.exception.ApiResourceNotFoundException;
import cn.czfshine.app.store.model.dto.AllGan;
import cn.czfshine.app.store.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @author:czfshine
 * @date:2019/3/25 23:30
 */

@RestController
@Slf4j
public class ProductApiController {


    @Autowired
    private ProductService productService;
    /** 获取当前数据库中的所有商品唯一识别码
     * @return
     */
    @GetMapping("/api/getallgan")
    public AllGan getAllGan() {
        AllGan res = new AllGan();
        List<Integer> allGan = productService.getAllGan();
        res.setData(allGan);
        return res;
    }

    /**
     * 根据商品的唯一识别码获取商品信息
     * @param gan
     * @return 对应的商品信息
     * @throws ApiResourceNotFoundException
     */
    @GetMapping("/api/Product/gan/{gan}")
    public HashMap<String,Object> getByGan(@PathVariable int gan) throws ApiResourceNotFoundException {
        return productService.getProductByGan(gan);
    }


    /**取对应商店的对应商品的销售信息
     * @param proId
     * @param storeId
     * @return
     * @throws ApiResourceNotFoundException
     */
    @GetMapping("/api/sale")
    public void getSaleInfo(@RequestParam("productid") int proId,
                            @RequestParam("storeid") int storeId) throws ApiResourceNotFoundException {
//        Optional<Store> byId = storeRepository.findById(storeId);
//        if(!byId.isPresent()){
//
//            throw new ApiResourceNotFoundException("store id="+storeId+"不存在");
//        }
//        Store store = byId.get();
//        Product product=productRepository.findFirstByGan(proId);
//        if(product==null){
//            throw new ApiResourceNotFoundException("product id="+proId+"不存在");
//        }
//        Sale byProductAndStore = saleRepository.findByProductAndStore(product, store);
//        if(byProductAndStore==null){
//            throw new ApiResourceNotFoundException("商店没有销售该商品");
//        }
//        return byProductAndStore;
    }
}

