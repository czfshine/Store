package cn.czfshine.app.store.service.impl;

import cn.czfshine.app.store.dao.ProductServiceMapper;
import cn.czfshine.app.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductServiceMapper productServiceMapper;
    @Override
    public List<Integer> getAllGan() {
        return productServiceMapper.getAllGan();
    }

    @Override
    public HashMap<String, Object> getProductByGan(Integer gan) {
        return productServiceMapper.getProductByGan(gan);
    }
}
