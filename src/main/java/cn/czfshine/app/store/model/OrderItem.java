package cn.czfshine.app.store.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 订单项
 */
@Data
@Entity
public class OrderItem {
    private @Id
    @GeneratedValue
    int id;

    private Integer oid;//该订单项属于哪笔订单
    private Integer pid;//所购买商品的id
    private Double count;//购买数量,有可能是几斤几两,故类型定为Double
    private Double subtotal;//小计

    //提供有参构造方法 (id属性排除在外)
    public OrderItem(Integer oid, Integer pid, Double count, Double subtotal) {
        this.oid = oid;
        this.pid = pid;
        this.count = count;
        this.subtotal = subtotal;
    }

    private OrderItem() {
    }
}
