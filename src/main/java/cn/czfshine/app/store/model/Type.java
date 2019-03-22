package cn.czfshine.app.store.model;

import com.sun.javafx.beans.IDProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

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

    @ManyToMany
    private Type parentType;
}
