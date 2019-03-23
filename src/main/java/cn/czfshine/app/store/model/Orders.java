package cn.czfshine.app.store.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 订单
 */
@Data
@Entity
public class Orders {
    private @Id
    @GeneratedValue
    int id;

    private Double total;//订单总金额
    private Integer cid;//订单属于哪位顾客 cid意为customer_id
    private Date ordertime;//下单时间

    //提供有参构造方法 (id属性排除在外)


    public Orders(Double total, Integer cid, Date ordertime) {
        this.total = total;
        this.cid = cid;
        this.ordertime = ordertime;
    }

    private Orders() {
    }
}
