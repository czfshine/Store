package cn.czfshine.app.store.web.controller;

import cn.czfshine.app.store.repository.StoreRepository;
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
    @Autowired
    private StoreRepository storeRepository;

    @GetMapping("/api/store/firstid")
    public int getid(){
        return storeRepository.findAll().get(0).getId();
    }
}
