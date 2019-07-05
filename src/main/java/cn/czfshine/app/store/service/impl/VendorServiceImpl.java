package cn.czfshine.app.store.service.impl;

import cn.czfshine.app.store.dao.ProductServiceMapper;
import cn.czfshine.app.store.dao.SoldServiceMapper;
import cn.czfshine.app.store.dao.StorageServiceMapper;
import cn.czfshine.app.store.dao.VendorServiceMapper;
import cn.czfshine.app.store.model.pojo.Product;
import cn.czfshine.app.store.model.pojo.Sold;
import cn.czfshine.app.store.model.pojo.Storage;
import cn.czfshine.app.store.model.pojo.Vendor;
import cn.czfshine.app.store.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

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
    private static Random random = new Random();

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

            Integer prid = 0;


            if (productByNameAndSize.size() == 0) {
                //商品不存在
                Product product = new Product();
                int i = random.nextInt();
                if (i < 0) i = -i;
                product.setGan(i);
                product.setInstid(1);
                product.setName(proname.toString());
                product.setSize(proszie.toString());
                productServiceMapper.insert(product);
                prid = product.getId();

                Storage storage = new Storage();
                storage.setCount(Integer.parseInt(count.toString()));
                storage.setStoreId(1);
                storage.setProductId(prid);
                storageServiceMapper.insert(storage);
            } else {
                HashMap<String, Object> stringObjectHashMap = productByNameAndSize.get(0);
                prid = (Integer) stringObjectHashMap.get("id");
            }

            sold.setProductId(prid);
            sold.setStoreId(1);

            List<Vendor> vendorByName = vendorServiceMapper.getVendorByName(label.toString());
            Integer id = vendorByName.get(0).getId();
            sold.setVendorId(id);
            soldServiceMapper.insert(sold);
            productServiceMapper.upCount(prid, Integer.parseInt(count.toString()));


        }

    }
}
