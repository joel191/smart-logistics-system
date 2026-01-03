package com.joel.logistics.controller;

import com.joel.logistics.dto.CreateOrderRequest;
import com.joel.logistics.dto.UpdateOrderStatusRequest;
import com.joel.logistics.order.Order;
import com.joel.logistics.order.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order createOrder(@RequestBody CreateOrderRequest request) {
        return orderService.createOrder(request);
    }

    @PutMapping("/{id}/status")
    public Order updateStatus(@PathVariable Long id,
            @RequestBody UpdateOrderStatusRequest request) {
        return orderService.updateStatus(id, request);
    }

    @GetMapping
    public List<Order> getOrders() {
        return orderService.getOrdersForCurrentUser();
    }
}
