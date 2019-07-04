package cn.czfshine.app.store.service.impl;

import cn.czfshine.app.store.dao.StorageServiceMapper;
import cn.czfshine.app.store.dao.VendorServiceMapper;
import cn.czfshine.app.store.model.pojo.Storage;
import cn.czfshine.app.store.model.pojo.Vendor;
import cn.czfshine.app.store.service.StorageService;
import cn.czfshine.app.store.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorServiceImpl implements VendorService {

    @Autowired
    private VendorServiceMapper vendorServiceMapper;


    @Override
    public List<Vendor> getAllVendor(String str) {
        return vendorServiceMapper.getAllVendor(str);
    }
}
