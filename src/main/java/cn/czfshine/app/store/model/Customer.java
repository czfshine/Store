package cn.czfshine.app.store.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 顾客信息
 */
@Data
@Entity
public class Customer {
    private @Id
    @GeneratedValue
    int id;

    private String name;//顾客姓名
    private String address;//顾客住址
    private String telephone;//顾客电话

    //提供有参构造方法 (id属性排除在外)
    public Customer(String name, String address, String telephone) {
        this.name = name;
        this.address = address;
        this.telephone = telephone;
    }

    private Customer() {
    }
}
