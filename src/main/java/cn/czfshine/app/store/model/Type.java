package cn.czfshine.app.store.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
    private Type parentType;//一个type只有一个parentType,一个parentType下有多个type,因此是ManyToOne

    public Type(String name, Type parentType) {
        this.name = name;
        this.parentType = parentType;
    }

    public Type(String name) {
        this.name = name;
    }
    private Type(){};
}
