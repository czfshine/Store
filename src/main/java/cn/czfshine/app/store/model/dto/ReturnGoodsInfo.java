package cn.czfshine.app.store.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class ReturnGoodsInfo {

    private Integer orderId;
    private List<Integer> productIds;
}

