package cn.czfshine.app.store.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

/**
 * 供应商向商店供货
 */
@Data
@Entity
public class Sold {
    private @Id
    @GeneratedValue
    int id;
    @OneToOne
    private Store store;//供给哪个商店
    @OneToOne
    private Product product;
    private BigDecimal pricing;

    private int count;
    //提供有参构造方法 (id属性排除在外)

    public Sold(Store store, Product product, BigDecimal pricing, int count) {
        this.store = store;
        this.product = product;
        this.pricing = pricing;
        this.count = count;
    }

    private Sold() {
    }


}
