package cn.czfshine.app.store.service;

import cn.czfshine.app.store.model.pojo.Vendor;

import java.util.HashMap;
import java.util.List;

public interface VendorService {
    List<Vendor> getAllVendor(String str);

    void postImport(HashMap<String, Object> json);
}
