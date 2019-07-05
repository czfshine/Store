package cn.czfshine.app.store.web.controller;

import cn.czfshine.app.store.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/storage")
public class StorageController {

    @Autowired
    private StorageService storageService;

    // 获取库存列表
    @GetMapping("/list")
    public List<HashMap<String, Object>> getAllStorage(@RequestParam(value = "searchStr", required = false) String searchStr) {
        if (searchStr == null) {
            searchStr = "";
        }
        return storageService.getAllStorage(searchStr);
    }

    @PostMapping("/check")
    public List<HashMap<String, Object>> check(@RequestBody HashMap<String, Object> json) {
        System.out.println(json);
        ArrayList<HashMap<String, Object>> res = new ArrayList<>();
        List<HashMap<String, Object>> list = (List<HashMap<String, Object>>) (((HashMap) json.get("data")).get("data"));
        for (HashMap hashMap : list
        ) {
            int gan = (int) hashMap.get("EAN");

            int count = Integer.parseInt(hashMap.get("count").toString());
            Integer count1 = storageService.getCount(gan);
            if (count != count1) {
                HashMap<String, Object> re = new HashMap<>();
                re.put("name", hashMap.get("productname"));
                re.put("recount", count1);
                res.add(re);
            }
        }
        return res;
    }
}
