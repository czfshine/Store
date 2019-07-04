package cn.czfshine.app.store.web.controller;

import cn.czfshine.app.store.service.SoldService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@Slf4j
public class SoldController {

    @Autowired
    private SoldService soldService;
    @GetMapping("/api/sold/list")
    public List<HashMap<String,Object>> list(@RequestParam(value = "searchStr",required = false) String searchStr){
        if (searchStr==null){
            searchStr="";
        }
        return soldService.list(searchStr);
    }
}
