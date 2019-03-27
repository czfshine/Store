package cn.czfshine.app.store.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.math.BigDecimal;
import javax.persistence.*;
/**
 * 售卖信息
 * @author:czfshine
 * @date:2019/3/22 15:03
 */

@Data
@Entity
@Table(name="sale")
public class Sale {
    @Id
    @GeneratedValue
    private int id;
    private BigDecimal pricing;//价格
    @ManyToOne
    private Product product;
    @ManyToOne
    private Store store;
    public Sale(BigDecimal pricing, Product product, Store store) {
        this.pricing = pricing;
        this.product = product;
        this.store = store;
    }

    private Sale(){}
}
