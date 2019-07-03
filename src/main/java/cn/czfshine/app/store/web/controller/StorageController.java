package cn.czfshine.app.store.web.controller;

import cn.czfshine.app.store.model.pojo.Storage;
import cn.czfshine.app.store.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("storage")
public class StorageController {

    @Autowired
    private StorageService storageService;

    // 获取库存列表
    @GetMapping("/list")
    public List<Storage> getAllStorage() {
        return storageService.getAllStorage();
    }
}
