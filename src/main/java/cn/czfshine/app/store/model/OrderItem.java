package cn.czfshine.app.store.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

/**
 * 订单项
 */
@Data
@Entity
public class OrderItem {
    private @Id
    @GeneratedValue
    int id;

    //private Integer oid;//该订单项属于哪笔订单

    public OrderItem(Product product, Double count, BigDecimal pricing) {
        this.product = product;
        this.count = count;
        this.pricing = pricing;
    }

    @OneToOne
    private Product product;//所购买商品
    private Double count;//购买数量,有可能是几斤几两,故类型定为Double
    private BigDecimal  pricing ;//单价


    //提供有参构造方法 (id属性排除在外)

    private OrderItem() {
    }
}
