package com.experiment.conditioninject.service;

import com.experiment.conditioninject.model.Order;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@ConditionalOnProperty(name = "service.impl", havingValue = "memory")
public class OrderServiceMemoryImpl implements OrderService {

    private final List<Order> orders;

    public OrderServiceMemoryImpl() {
        orders = new ArrayList<>();
        orders.add(new Order(1L, "张三", 299.99, new Date()));
        orders.add(new Order(2L, "李四", 599.50, new Date()));
        orders.add(new Order(3L, "王五", 189.00, new Date()));
    }

    @Override
    public List<Order> getAllOrders() {
        return orders;
    }
}
