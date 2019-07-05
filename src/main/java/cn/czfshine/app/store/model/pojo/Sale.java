package cn.czfshine.app.store.model.pojo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Sale {
    private Integer id;
    private BigDecimal pricing;
    private Integer productId;
    private Integer storeId;
}