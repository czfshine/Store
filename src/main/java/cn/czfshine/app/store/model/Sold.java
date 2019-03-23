package cn.czfshine.app.store.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 供应商向商店供货
 */
@Data
@Entity
public class Sold {
    private @Id
    @GeneratedValue
    int id;


    private Integer sid;//供给哪个商店 sid以为store_id
    private Integer pid;//供了什么货 pid意为product_id
    //再添加一个属性 : 供货数量 ?

    public Sold(Integer sid, Integer pid) {
        this.sid = sid;
        this.pid = pid;
    }


    //提供有参构造方法 (id属性排除在外)

    private Sold() {
    }


}
