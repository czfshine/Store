package cn.czfshine.app.store.service.impl;

import cn.czfshine.app.store.dao.OrderItemServiceMapper;
import cn.czfshine.app.store.dao.OrdersMapper;
import cn.czfshine.app.store.dao.OrdersServiceMapper;
import cn.czfshine.app.store.dao.ProductServiceMapper;
import cn.czfshine.app.store.model.dto.OrderInfoDO;
import cn.czfshine.app.store.model.pojo.OrderItem;
import cn.czfshine.app.store.model.pojo.Orders;
import cn.czfshine.app.store.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
//    @Autowired
//    private OrdersRepository ordersRepository;
//    @Autowired
//    private OrderItemRepository orderItemRepository;

    @Autowired
    private OrdersServiceMapper ordersServiceMapper;

    @Override
    public List<OrderInfoDO> getAllOrder() {
        List<HashMap<String, Object>> allOrders = ordersServiceMapper.getAllOrders();
        System.out.println(allOrders.size());

        ArrayList<OrderInfoDO> res = new ArrayList<>();
        for (HashMap<String,Object> hm:allOrders
             ) {
            OrderInfoDO orderInfoDO = new OrderInfoDO();
            orderInfoDO.setCount((Integer.parseInt(hm.get("count").toString())) );
            if(hm.getOrDefault("ordertime",null) == null){
                orderInfoDO.setCreateTime(String.valueOf(new Date()));
            }else{
                orderInfoDO.setCreateTime(hm.get("ordertime").toString());
            }
            orderInfoDO.setId((Integer) hm.get("id"));
            orderInfoDO.setTotalPrice(BigDecimal.valueOf(Double.parseDouble(hm.get("total").toString())));
            res.add(orderInfoDO);
        }

        return res;
    }

    @Override
    public Orders getOrderById(Integer id) {
        return ordersServiceMapper.getOrderById(id);
    }

    @Override
    public void returnProducts(Integer orderId, List<Integer> productIds) {
//        //del order
//        Orders one = ordersRepository.getOne(orderId);
//        one.setDel(true);
//        ordersRepository.save(one);
//        ordersRepository.saveAndFlush(one);
//        ArrayList<OrderItem> newList = new ArrayList<>();
//
//        Orders orders = new Orders();
//        orders.setCustomer(one.getCustomer());
//        orders.setOrdertime(new Date());
//        orders.setItems(newList);
//        Orders save = ordersRepository.saveAndFlush(orders);
//
//        List<OrderItem> items = save.getItems();
//        for (OrderItem oi:one.getItems()
//             ) {
//            if (!productIds.contains(oi.getId())) {
//
//                OrderItem one1 = orderItemRepository.getOne(oi.getId());
//                items.add(one1);
//            }
//        }
//
//        ordersRepository.saveAndFlush(save);

    }

    @Autowired
    private ProductServiceMapper productServiceMapper;
    @Autowired
    private OrderItemServiceMapper orderItemServiceMapper;
    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    @Transient
    //todo 判断数量
    public void addOrder(HashMap<String, Object> json) {
        List<HashMap<String, Object>> list = (List<HashMap<String, Object>>)
                (((HashMap) json.get("data")).get("data"));

        ArrayList<OrderItem> orderItems = new ArrayList<>();
        for (Object b : list
        ) {
            HashMap<String, Object> b1 = (HashMap<String, Object>) b;
            Object ean = b1.get("EAN");
            HashMap<String, Object> productByGan = productServiceMapper.getProductByGan((Integer) ean);
            Object pricing = b1.get("pricing");
            Object count = b1.get("count");
            productServiceMapper.downCount((Integer)productByGan.get("id"), (Integer) count);
            OrderItem orderItem = new OrderItem();
            orderItem.setCount(Double.parseDouble(count.toString()));
            orderItem.setProductId((Integer) productByGan.get("id"));
            orderItem.setPricing(BigDecimal.valueOf(Double.parseDouble(pricing.toString())) );
            orderItemServiceMapper.insertAndGetIdInplace(orderItem);
            orderItems.add(orderItem);
        }

        Orders orders = new Orders();
        orders.setCustomerId(0);
        orders.setDel(false);
        orders.setOrdertime(new Date());

        ordersServiceMapper.insert(orders);
        for (OrderItem oi :orderItems
             ) {
            orderItemServiceMapper.insertOrderItems(orders.getId(),oi.getId());
        }
        orderItemServiceMapper.call(orders.getId());

    }
}
