package cn.czfshine.app.store.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * 商店
 * @author:czfshine
 * @date:2019/3/22 14:49
 */

@Data
@Entity
public class Store {
    @Id
    @GeneratedValue
    private int id;

    private String storename;

    private String local;//位置

    @OneToMany
    private List<Storage> storages;//库存列表

    //@OneToMany
    //private List<Sale> sales;//价格列表

    public Store(String storename, String local, List<Storage> storages) {
        this.storename = storename;
        this.local = local;
        this.storages = storages;
    }

    public Store(String storename, String local) {
        this.storename = storename;
        this.local = local;
    }
    private Store(){}
}

