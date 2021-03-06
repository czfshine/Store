package cn.czfshine.app.store.service.impl;

import cn.czfshine.app.store.dao.ProductServiceMapper;
import cn.czfshine.app.store.dao.SoldServiceMapper;
import cn.czfshine.app.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductServiceMapper productServiceMapper;
    @Autowired
    private SoldServiceMapper soldServiceMapper;

    @Override
    public List<Integer> getAllGan() {
        return productServiceMapper.getAllGan();
    }

    @Override
    public HashMap<String, Object> getProductByGan(Integer gan) {
        return productServiceMapper.getProductByGan(gan);
    }

    @Override
    public List<HashMap<String, Object>> getSaleInfo(Integer productId, Integer storeId) {
        return productServiceMapper.getSaleInfo(productId, storeId);
    }

    @Override
    public List<HashMap<String, Object>> getNotSale() {
        return soldServiceMapper.getNoSaleProduct();
    }
}
