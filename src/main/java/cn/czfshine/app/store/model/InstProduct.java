package cn.czfshine.app.store.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 商品原型
 * @author:czfshine
 * @date:2019/3/21 19:52
 */

@Data
@Entity
public class InstProduct {
    private @Id @GeneratedValue
    int id;
    private String productname;

    public InstProduct(String productname) {
        this.productname = productname;
    }

    public InstProduct() {
    }
}
