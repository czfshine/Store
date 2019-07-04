package cn.czfshine.app.store.web.controller;

import cn.czfshine.app.store.dao.StorageServiceMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商店相关的api
 */

@RestController
@Slf4j
public class StoreApiController {
    @GetMapping("/api/store/firstid")
    public int getid(){
        return 1;
    }

    @Autowired
    StorageServiceMapper storageServiceMapper;
    @GetMapping("/api/store/turnover")
    public double getTurnover(){
        return storageServiceMapper.getTurnover();
    }
}
