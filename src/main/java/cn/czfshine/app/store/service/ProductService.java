package cn.czfshine.app.store.service;

import java.util.HashMap;
import java.util.List;


public interface ProductService {
    List<Integer> getAllGan();

    HashMap<String, Object> getProductByGan(Integer gan);

    List<HashMap<String, Object>> getSaleInfo(Integer productId, Integer storeId);

    List<HashMap<String, Object>> getNotSale();
}
