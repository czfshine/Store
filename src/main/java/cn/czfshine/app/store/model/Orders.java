package cn.czfshine.app.store.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * 订单
 */
@Data
@Entity
public class Orders {
    private @Id
    @GeneratedValue
    int id;

    @OneToOne
    private Customer customer;
    private Date ordertime;//下单时间
    //提供有参构造方法 (id属性排除在外)
    @OneToMany
    private List<OrderItem> items;

    public Orders( Customer customer, Date ordertime, List<OrderItem> items) {
        this.customer = customer;
        this.ordertime = ordertime;
        this.items = items;
    }

    private Orders() {
    }
}
