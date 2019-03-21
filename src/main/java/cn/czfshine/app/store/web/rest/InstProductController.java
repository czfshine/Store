package cn.czfshine.app.store.web.rest;

import cn.czfshine.app.store.exception.InstProductNotFoundException;
import cn.czfshine.app.store.model.InstProduct;
import cn.czfshine.app.store.repository.InstProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 提供InstProduct相关的rest api
 * @author:czfshine
 * @date:2019/3/21 20:15
 */

@RestController
public class InstProductController {
    private final InstProductRepository repository;

    public InstProductController(InstProductRepository repository) {
        this.repository = repository;
    }

    /** 列出所有
     * @return
     */
    @GetMapping("/data/instproducts")
    List<InstProduct> all(){
        return repository.findAll();
    }

    /**
     * 新建
     * @param instProduct
     * @return
     */
    @PostMapping("/data/instproducts")
    InstProduct newInstProduct(@RequestBody InstProduct instProduct) {
        return repository.save(instProduct);
    }

    /** 根据id查询
     * @param id
     * @return
     * @throws InstProductNotFoundException
     */
    @GetMapping("/data/instproducts/{id}")
    InstProduct one(@PathVariable Integer id) throws InstProductNotFoundException {

        return repository.findById(id)
                .orElseThrow(() -> new InstProductNotFoundException(id));
    }
    //不需要修改，所以不用map put请求

    /** 根据id删除
     * @param id
     */
    @DeleteMapping("/data/instproducts/{id}")
    void deleteInstProduct(@PathVariable Integer id) {
        repository.deleteById(id);
    }

}
