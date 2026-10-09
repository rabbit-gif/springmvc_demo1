package com.experiment.conditioninject.runner;

import com.experiment.conditioninject.controller.OrderController;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class FirstCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("========================================");
        System.out.println("FirstCommandLineRunner (Order 1) 开始执行");
        System.out.println("OrderController 类名: " + OrderController.class.getName());
        System.out.println("========================================");
    }
}
