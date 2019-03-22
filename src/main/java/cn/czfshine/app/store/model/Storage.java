package cn.czfshine.app.store.model;

import com.sun.javafx.beans.IDProperty;
import lombok.Data;

import javax.persistence.*;

/**库存
 * @author:czfshine
 * @date:2019/3/22 14:38
 */

@Data
@Entity
public class Storage {
    @Id
    @GeneratedValue
    private  int id;
    @ManyToOne
    private Product product; //库存的商品
    private int count;       //库存的数量

    private Storage(){}
    public Storage(Product product, int count) {
        this.product = product;
        this.count = count;
    }
}
