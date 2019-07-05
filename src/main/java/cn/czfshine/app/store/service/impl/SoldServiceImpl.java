package cn.czfshine.app.store.service.impl;

import cn.czfshine.app.store.dao.ProductServiceMapper;
import cn.czfshine.app.store.dao.SoldServiceMapper;
import cn.czfshine.app.store.model.pojo.Sale;
import cn.czfshine.app.store.service.SoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

@Service
public class SoldServiceImpl implements SoldService {


    @Autowired
    private SoldServiceMapper soldServiceMapper;
    @Autowired
    private ProductServiceMapper productServiceMapper;

    @Override
    public List<HashMap<String, Object>> list(String str) {
        return soldServiceMapper.list(str);
    }

    @Override
    public void post(HashMap<String, Object> json) {

        List<HashMap<String, Object>> list = (List<HashMap<String, Object>>)
                (((HashMap) json.get("data")).get("data"));

        for (Object b : list
        ) {
            HashMap<String, Object> b1 = (HashMap<String, Object>) b;

            Object proid = b1.get("product_id");
            Object newpricing = b1.get("outPricing");
            if (proid != null && newpricing != null) {
                Sale sale = new Sale();
                sale.setPricing(BigDecimal.valueOf(Double.parseDouble(newpricing.toString())));
                sale.setProductId(Integer.parseInt(proid.toString()));
                sale.setStoreId(1);
                productServiceMapper.insertSale(sale);
            }
        }

    }


}
