package com.experiment.conditioninject.controller;

import com.experiment.conditioninject.model.Order;
import com.experiment.conditioninject.service.OrderService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/index")
    public List<Order> index() {
        return orderService.getAllOrders();
    }
}
