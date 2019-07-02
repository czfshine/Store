package cn.czfshine.app.store.web.controller;

import cn.czfshine.app.store.model.Customer;
import cn.czfshine.app.store.model.OrderItem;
import cn.czfshine.app.store.model.Orders;
import cn.czfshine.app.store.model.Product;
import cn.czfshine.app.store.model.constant.StatusCode;
import cn.czfshine.app.store.model.dto.BasicResponse;
import cn.czfshine.app.store.repository.CustomerRepository;
import cn.czfshine.app.store.repository.OrderItemRepository;
import cn.czfshine.app.store.repository.OrdersRepository;
import cn.czfshine.app.store.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

/**
 * 订单相关的控制器
 */
@RestController
@Slf4j
public class OrderController {

    private final OrderItemRepository orderItemRepository;
    private final OrdersRepository ordersRepository;
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;

    public OrderController(OrderItemRepository orderItemRepository, OrdersRepository ordersRepository, ProductRepository productRepository, CustomerRepository customerRepository) {
        this.orderItemRepository = orderItemRepository;
        this.ordersRepository = ordersRepository;
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
    }

    /**
     * 上传一个新的订单
     * todo json 自动生成对象或者hashmap，不要手动解析
     * todo  提取逻辑成service
     *
     * @param json
     */
    @PostMapping("/api/order/post")
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
            log.warn(e.getMessage());
            return;
        }
    }

    /**
     * wrote by xuming
     * @date:2019/06/01 14:14
     * 现在要实现 删除订单 功能;我们将该功能细分为两个子功能:
     * 1.订单从哪来?==>取随机订单信息
     * 2.拿到指定的订单信息后,删除它.
     * @return
     * 经postman测试通过,符合我们的预期。
     */
    @GetMapping("/api/getRandomOrder")
    public BasicResponse getRandomOrder() {
        /*本来应该将所有订单的id放在一个集合中,通过随机取集合中的一个元素,来实现取随机订单的功能*/
        /*但这里为了方便,先将订单id写死*/
        //目前数据库中可用的订单id只有133和139这两个
        //new一个BasicResponse类对象,将它的三个属性封装完毕,并返回
        //由于是@RestController,会自动将Java实体转为Json对象
        //1.new一个BasicResponse类对象
        BasicResponse basicResponse = new BasicResponse();
        //2.完成code message data三个属性的封装
        //模拟取得一个订单[该订单的id写死为139]
        Orders randomOrder = ordersRepository.getOne(139);
        /*该订单中的具体订单项*/
        List<OrderItem> items = randomOrder.getItems();
        //如果该订单中的订单项为空,则返回
        if(items==null || items.size()==0){
            basicResponse.setCode(StatusCode.ORDERITEM_EMPTY_ERROR.getCode());
            basicResponse.setMessage(StatusCode.ORDERITEM_EMPTY_ERROR.getMsg());
            basicResponse.setData(null);
        }else{
            //订单项不为空
            //订单中有订单项,订单项里有具体的商品
            //那么传回的data是什么?
/*
            "orderId":123,
            "products":[
            			{
            				"productsId":"123456",
            				"name":"可乐",
            				"price":"12.",
            				"count":"2"
            			},
            			{
            				"productsId":"123457",
            				"name":"可乐",
            				"price":"12.7",
            				"count":"2"
            			},
            			{
            				"productsId":"123458",
            				"name":"可乐",
            				"price":"12.6",
            				"count":"2"
            			}]
*/
            //返回的data是Map<String,Object>
            //第一个key-value对 : "orderId" - orderId的数值
            //第二个key-value对 : "products" - List<Map<String,String>
            Map<String,Object> data = new HashMap<>();
            //将第一个key-value对put进data中
            data.put("orderId",randomOrder.getId());
            List<Map<String,String>> list = new ArrayList<>();
            //遍历订单项
            for(OrderItem orderItem : items){
                Map<String,String> productInfoMap = new HashMap<>();
                //value部分+""是因为int不能直接toString()
                productInfoMap.put("productsId",orderItem.getProduct().getProid()+"");
                productInfoMap.put("name",orderItem.getProduct().getName()+"");
                productInfoMap.put("price",orderItem.getPricing()+"");
                productInfoMap.put("count",orderItem.getCount()+"");
                //将productInfoMap添加进valueOfMap2中
                list.add(productInfoMap);
            }
            //将第二个key-value对put进data中
            data.put("products",list);

            //至此,订单项不为空的时候,data封装完毕
            //basicResponse赋值3个属性,并返回
            basicResponse.setCode(StatusCode.SUCCESS.getCode());
            basicResponse.setMessage(StatusCode.SUCCESS.getMsg());
            basicResponse.setData(data);
        }
        //3.返回该对象
        return basicResponse;
    }

    /**
     * 删除订单,并不是将订单记录从数据库中删除,而是改一个状态标识.
     * @param ordersId 要删除的订单的订单id
     * @param products
     * @return
     */
    @PostMapping("api/return")
    public BasicResponse deleteOrders(@RequestParam("ordersId") Integer ordersId,
                                      @RequestParam("products") List<Integer> products){

        return null;
    }
}
