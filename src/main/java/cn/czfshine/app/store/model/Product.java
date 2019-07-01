package cn.czfshine.app.store.model;

import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;
import java.util.Random;

/**商品对象
 * @author:czfshine
 * @date:2019/3/21 22:02
 */

@Data
@Entity
public class Product {

    private @Id @GeneratedValue int proid;


    private String name;//名称
    private String size;//规格

    private int gan; //商品唯一识别码
    @ManyToOne
    @JoinColumn(name="id")
    private InstProduct inst;

    public Product(String name, String size, InstProduct inst) {
        this.gan = Math.abs(new Random().nextInt());
        this.name = name;
        this.size = size;
        this.inst = inst;
    }

    public Product(String name, String size, int gan, InstProduct inst) {
        this.name = name;
        this.size = size;
        this.gan = gan;
        this.inst = inst;
    }

    private Product(){}
}
