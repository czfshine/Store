package cn.czfshine.app.store.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * 订单
 */
@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Orders {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private Customer customer;
    private Date ordertime;//下单时间
    private Boolean del;

    @ManyToMany
    private List<OrderItem> items;


    public Orders( Customer customer, Date ordertime, List<OrderItem> items) {
        this.customer = customer;
        this.ordertime = ordertime;
        this.items = items;
        del=false;
    }

    public Orders() {
        del=false;
    }
}
