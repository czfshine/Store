package cn.czfshine.app.store.service;


import cn.czfshine.app.store.model.dto.OrderInfoDO;
import cn.czfshine.app.store.model.pojo.Orders;

import java.util.HashMap;
import java.util.List;


public interface OrderService {
    List<OrderInfoDO> getAllOrder();
    Orders getOrderById(Integer id);
    void returnProducts(Integer orderId, List<Integer> productIds);
    void addOrder(HashMap<String,Object> json);
}
