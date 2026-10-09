package com.experiment.conditioninject.runner;

import com.experiment.conditioninject.service.OrderService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class SecondCommandLineRunner implements CommandLineRunner {

    private final OrderService orderService;

    public SecondCommandLineRunner(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("========================================");
        System.out.println("SecondCommandLineRunner (Order 2) 开始执行");
        System.out.println("OrderService 实现类名: " + orderService.getClass().getName());
        System.out.println("========================================");
    }
}
