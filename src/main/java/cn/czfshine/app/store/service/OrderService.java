package cn.czfshine.app.store.service;


import cn.czfshine.app.store.model.dto.OrderInfoDO;

import java.util.HashMap;
import java.util.List;


public interface OrderService {
    List<OrderInfoDO> getAllOrder();

    List<HashMap<String, Object>> getOrderById(Integer id);

    void returnProducts(Integer orderId, List<Integer> itemsIds);

    void addOrder(HashMap<String, Object> json);
}
