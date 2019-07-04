package cn.czfshine.app.store.service.impl;

import cn.czfshine.app.store.dao.ProductServiceMapper;
import cn.czfshine.app.store.dao.SoldServiceMapper;
import cn.czfshine.app.store.dao.StorageServiceMapper;
import cn.czfshine.app.store.dao.VendorServiceMapper;
import cn.czfshine.app.store.model.pojo.*;
import cn.czfshine.app.store.service.StorageService;
import cn.czfshine.app.store.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class VendorServiceImpl implements VendorService {

    @Autowired
    private VendorServiceMapper vendorServiceMapper;


    @Override
    public List<Vendor> getAllVendor(String str) {
        return vendorServiceMapper.getAllVendor(str);
    }

    @Autowired
    private ProductServiceMapper productServiceMapper;
    @Autowired
    private SoldServiceMapper soldServiceMapper;

    @Autowired
    private StorageServiceMapper storageServiceMapper;
    @Override
    @Transient
    public void postImport(HashMap<String, Object> json) {

        List<HashMap<String, Object>> list = (List<HashMap<String, Object>>)
                (((HashMap) json.get("data")).get("data"));

        for (Object b : list
        ) {
            HashMap<String, Object> b1 = (HashMap<String, Object>) b;

            Object pricing = b1.get("pricing");
            Object count = b1.get("count");
            Object proname = b1.get("productName");
            Object proszie = b1.get("productSize");
            HashMap<String, Object> vendorName = (HashMap<String, Object>) b1.get("vendorName");
            Object label = vendorName.get("label");

            Sold sold = new Sold();
            sold.setCount(Integer.parseInt(count.toString()));
            sold.setPricing(BigDecimal.valueOf(Double.parseDouble(pricing.toString())));
            List<HashMap<String, Object>> productByNameAndSize = productServiceMapper.getProductByNameAndSize(proname.toString(), proszie.toString());

            Integer prid=0;


            if(productByNameAndSize.size() == 0){
                //todo
            }else{
                HashMap<String, Object> stringObjectHashMap = productByNameAndSize.get(0);
                prid = (Integer) stringObjectHashMap.get("id");
            }

            sold.setProductId(prid);
            sold.setStoreId(1);

            List<Vendor> vendorByName = vendorServiceMapper.getVendorByName(label.toString());
            Integer id = vendorByName.get(0).getId();
            sold.setVendorId(id);
            soldServiceMapper.insert(sold);
            productServiceMapper.upCount(prid,Integer.parseInt(count.toString()));


        }

    }
}
