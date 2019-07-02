package cn.czfshine.app.store.service;

import cn.czfshine.app.store.model.pojo.Sale;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;


public interface ProductService {
    List<Integer> getAllGan();
    HashMap<String,Object> getProductByGan(Integer gan);

    Sale getSaleInfo(Integer productId, Integer storeId);
}
