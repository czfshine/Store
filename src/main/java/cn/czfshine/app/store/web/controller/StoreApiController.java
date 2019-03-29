package cn.czfshine.app.store.web.controller;

import cn.czfshine.app.store.repository.StoreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商店相关的api
 */

@RestController
@Slf4j
public class StoreApiController {
    private final StoreRepository storeRepository;

    public StoreApiController(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @GetMapping("/api/store/firstid")
    public int getid(){
        return storeRepository.findAll().get(0).getId();
    }
}
