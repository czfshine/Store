package cn.czfshine.app.store.model.pojo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Sold {
    private Integer id;
    private Integer count;
    private BigDecimal pricing;
    private Integer productId;
    private Integer storeId;
    private Integer vendorId;
}