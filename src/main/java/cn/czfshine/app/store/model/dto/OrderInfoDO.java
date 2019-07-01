package cn.czfshine.app.store.model.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单基本信息
 */
@Data
public class OrderInfoDO {

    private Integer id;
    private String createTime;
    private Integer count;
    //总价
    private BigDecimal totalPrice;
}
