package cn.czfshine.app.store.web.controller;

import cn.czfshine.app.store.service.SoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class SaleController {
    @Autowired
    private SoldService soldService;

    @PostMapping("/api/sale/post")
    public void postImport(@RequestBody HashMap<String, Object> json) {
        soldService.post(json);
    }
}
