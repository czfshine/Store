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

    //添加这一句之后,web页面查看orderses这个表,看不到数据.
    private boolean isDeleted = false;

    public Orders( Customer customer, Date ordertime, List<OrderItem> items) {
        this.customer = customer;
        this.ordertime = ordertime;
        this.items = items;
    }

    /*将访问修饰符由private改为public*/
//    修改原因:OrderController类的ordersRepository.getOne(133);执行出错,查看控制台的错误信息
//    发现它说的是没有默认的无参构造方法,于是修改,修改后通过.
    public Orders() {
    }
}
