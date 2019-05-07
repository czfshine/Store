package cn.czfshine.app.store.web.controller;

import cn.czfshine.app.store.model.Customer;
import cn.czfshine.app.store.model.OrderItem;
import cn.czfshine.app.store.model.Orders;
import cn.czfshine.app.store.model.Product;
import cn.czfshine.app.store.repository.CustomerRepository;
import cn.czfshine.app.store.repository.OrderItemRepository;
import cn.czfshine.app.store.repository.OrdersRepository;
import cn.czfshine.app.store.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

@RestController
@Slf4j
public class OderPostController {

    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/api/oder/post")
    public void recvPost(@RequestBody String json) {
        try {
            JsonParser jsonParser = JsonParserFactory.getJsonParser();
            Map<String, Object> stringObjectMap = jsonParser.parseMap(json);
            Map<String, Object> data = (Map<String, Object>) stringObjectMap.get("data");
            ArrayList<Object> a = (ArrayList<Object>) data.get("data");
            ArrayList<OrderItem> orderItems = new ArrayList<>();
            for (Object b : a
            ) {
                Map<String, Object> b1 = (Map<String, Object>) b;
                Object ean = b1.get("EAN");
                Product firstByGan = productRepository.findFirstByGan((Integer) ean);
                if (firstByGan == null) {
                    //todo
                }
                Object pricing = b1.get("pricing");
                Object count = b1.get("count");
                OrderItem orderItem = new OrderItem(firstByGan, Double.parseDouble(((Integer) count).toString()), new BigDecimal((double) pricing));
                orderItemRepository.save(orderItem);
                orderItems.add(orderItem);
            }
            Customer customer = customerRepository.findAll().get(0);
            Orders orders = new Orders(customer, new Date(), orderItems);
            ordersRepository.save(orders);
            log.info(orders.toString());
        } catch (Exception e) {
            System.out.println(e);
            return;
        }

    }
}
