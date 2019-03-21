package cn.czfshine.app.store.model;

import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;

/**商品对象
 * @author:czfshine
 * @date:2019/3/21 22:02
 */

@Data
@Entity
public class Product {
    private @Id @GeneratedValue int proid;
    private String name;
    private String size;
    @ManyToOne
    @JoinColumn(name="id")
    private InstProduct inst;

    public Product(String name, String size, InstProduct inst) {
        this.name = name;
        this.size = size;
        this.inst = inst;
    }
    private Product(){}
}
