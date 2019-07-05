package cn.czfshine.app.store.model.pojo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItem {
    private Integer id;
    private Double count;
    private BigDecimal pricing;
    private Integer productId;
}