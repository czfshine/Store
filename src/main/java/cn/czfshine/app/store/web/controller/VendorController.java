package cn.czfshine.app.store.web.controller;

import cn.czfshine.app.store.model.pojo.Vendor;
import cn.czfshine.app.store.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("vendor")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    // 获取供应商列表
    @GetMapping("/list")
    public List<Vendor> getAllVendor() {
        return vendorService.getAllVendor();
    }
}
