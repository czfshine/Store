package cn.czfshine.app.store.model;

import com.sun.javafx.beans.IDProperty;
import lombok.Data;

import javax.persistence.*;

/**
 * 商品类别
 * @author:czfshine
 * @date:2019/3/22 14:20
 */

@Data
@Entity
public class Type {

    private @Id @GeneratedValue int id;

    private String name;

    @ManyToOne
    private Type parentType;

    public Type(String name, Type parentType) {
        this.name = name;
        this.parentType = parentType;
    }

    public Type(String name) {
        this.name = name;
    }
    private Type(){};
}
