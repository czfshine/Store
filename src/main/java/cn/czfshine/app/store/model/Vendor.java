package cn.czfshine.app.store.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * 供应商
 */
@Data
@Entity
public class Vendor {
    private @Id
    @GeneratedValue
    int id;

    private String name;//供应商名字
    private String location;//供应商所在地

    @OneToMany
    private List<Sold> solds;//供应商向商店的供货列表

    //提供有参构造方法 (id属性排除在外)
    public Vendor(String name, String location, List<Sold> solds) {
        this.name = name;
        this.location = location;
        this.solds = solds;
    }

    private Vendor() {
    }
}
