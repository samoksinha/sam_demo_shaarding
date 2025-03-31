package com.sam.db.shard.read.write.split.sam_demo_sharding.controller;

import com.sam.db.shard.read.write.split.sam_demo_sharding.model.TOrderModel;
import com.sam.db.shard.read.write.split.sam_demo_sharding.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/createOrder")
    public TOrderModel createUser(
            @RequestBody TOrderModel orderModel) {
        return orderService.saveOrder(orderModel);
    }

    @GetMapping("/fetchAllUsersOrders")
    public List<TOrderModel> fetchAllUsersOrders() {
        return orderService.findAllUsersOrders();
    }

    @GetMapping(value = "/fetchOrder", params = "orderId")
    public TOrderModel fetchOrder(
            @RequestParam("orderId") String orderId) {
        return orderService.findByOrderId(orderId);
    }

    @GetMapping(value = "/fetchUserOrders", params = "userId")
    public List<TOrderModel> fetchUserOrders(
            @RequestParam("userId") String userId) {
        return orderService.findByUserId(userId);
    }

    @GetMapping(value = "/fetchUserOrder", params = {"userId", "orderId"})
    public TOrderModel fetchUserOrder(
            @RequestParam("userId") String userId,
            @RequestParam("orderId") String orderId) {
        return orderService.findByUserIdOrderId(userId, orderId);
    }
}
