package cn.czfshine.app.store.service.impl;

import cn.czfshine.app.store.dao.OrdersServiceMapper;
import cn.czfshine.app.store.model.dto.OrderInfoDO;
import cn.czfshine.app.store.model.pojo.Orders;
import cn.czfshine.app.store.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        HashMap<String, Object> stringObjectHashMap = allOrders.get(0);
        for (String key:stringObjectHashMap.keySet()
             ) {

            System.out.println(key);
            System.out.println(stringObjectHashMap.get(key).getClass());

        }
        System.out.println("aaa");
//        List<Orders> all = ordersRepository.findAll();
//
//        LinkedList<OrderInfoDO> res = new LinkedList<>();
//
//        for (Orders order :
//                all) {
//            if(order == null || order.getDel()){
//                continue;
//            }
//            int id = order.getId();
//            Date createTime = order.getOrdertime();
//            BigDecimal totalprice = new BigDecimal("0.0");
//            int count =0;
//            for (OrderItem oi:order.getItems()
//                 ) {
//                totalprice = totalprice.add(oi.getPricing());
//                count ++;
//            }
//            OrderInfoDO orderList = new OrderInfoDO();
//            orderList.setId(id);
//            orderList.setCount(count);
//            orderList.setCreateTime(createTime.toString());
//            orderList.setTotalPrice(totalprice);
//            res.add(orderList);
//        }

        return null;
    }

    @Override
    public Orders getOrderById(Integer orderId) {
        return null;
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
}
