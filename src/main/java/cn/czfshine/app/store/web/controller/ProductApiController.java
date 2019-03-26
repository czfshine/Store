package cn.czfshine.app.store.web.controller;

import cn.czfshine.app.store.model.Product;
import cn.czfshine.app.store.model.dto.AllGan;
import cn.czfshine.app.store.repository.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:czfshine
 * @date:2019/3/25 23:30
 */

@RestController
public class ProductApiController {
    private final ProductRepository repository;

    public ProductApiController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/api/getallgan")
    public AllGan getAllGan(){
        AllGan res = new AllGan();
        ArrayList<Long> longs = new ArrayList<>();

        List<Product> all = repository.findAll();
        for(Product p:all){
            longs.add(p.getGan());
        }
        res.setData(longs);
        return res;
    }
}
