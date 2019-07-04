package cn.czfshine.app.store.web.controller;

import cn.czfshine.app.store.model.pojo.Vendor;
import cn.czfshine.app.store.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class VendorController {

    @Autowired
    private VendorService vendorService;

    // 获取供应商列表
    @GetMapping("/api/vendor/list")
    public List<Vendor> getAllVendor(@RequestParam(value = "searchStr",required = false) String searchStr ){
        if (searchStr==null){
            searchStr="";
        }
        return vendorService.getAllVendor(searchStr);
    }

    @PostMapping("/api/vendor/post")
    public void postImport(@RequestBody HashMap<String,Object> json){
        vendorService.postImport(json);
    }

}
