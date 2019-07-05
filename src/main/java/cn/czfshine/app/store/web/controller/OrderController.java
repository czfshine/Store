package cn.czfshine.app.store.web.controller;

import cn.czfshine.app.store.model.dto.BasicResponse;
import cn.czfshine.app.store.model.dto.OrderInfoDO;
import cn.czfshine.app.store.model.dto.ReturnGoodsInfo;
import cn.czfshine.app.store.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * 订单相关的控制器
 */
@RestController
@Slf4j
public class OrderController {


    /**
     * 上传一个新的订单
     *
     * @param json
     */
    @PostMapping("/api/order/post")
    public void recvPost(@RequestBody HashMap<String, Object> json) {
        orderService.addOrder(json);
    }

    @Autowired
    private OrderService orderService;


    @GetMapping("/api/order/getall")
    public BasicResponse getAllOrder() {
        BasicResponse basicResponse = new BasicResponse();
        List<OrderInfoDO> allOrder = orderService.getAllOrder();
        basicResponse.setData(allOrder);
        return basicResponse;
    }


//    @GetMapping("/api/order/getOne/{orderId}")
//    public BasicResponse getOrderById(@PathVariable String orderId){
//        BasicResponse basicResponse = new BasicResponse();
//        basicResponse.setData(orderService.getOrderById(Integer.valueOf(orderId)));
//        return basicResponse;
//    }

    // modified
    // 参数的类型由String改为了Integer,因为orders表设计的时候该字段是int类型的
    @GetMapping("/api/order/getOne/{id}")
    public List<HashMap<String, Object>> getOrderById(@PathVariable("id") Integer id) {
        return orderService.getOrderById(id);
    }

    /**
     * 退货
     */
    @PostMapping("/api/order/return")
    public BasicResponse returnGoods(@RequestBody ReturnGoodsInfo returnGoodsInfo) {
        log.warn(String.valueOf(returnGoodsInfo));
        orderService.returnProducts(returnGoodsInfo.getOrderId(), returnGoodsInfo.getItemsIds());
        return new BasicResponse();
    }
}