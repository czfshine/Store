package cn.czfshine.app.store.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * 商品原型
 * @author:czfshine
 * @date:2019/3/21 19:52
 */

@Data
@Entity
public class InstProduct {
    private @Id @GeneratedValue int id;
    private String productname;

    @ManyToOne //一个商品对应一种类型，一种类型对应多个商品
    private Type type;
    private InstProduct(){}
    public InstProduct(String productname, Type type) {
        this.productname = productname;
        this.type = type;
    }
}
