package com.experiment.ordersystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 实验2: 使用第一种方式(Autowired)注入组件
 * Spring Boot 主启动类
 */
@SpringBootApplication
public class OrderSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderSystemApplication.class, args);
        System.out.println("======================================");
        System.out.println("  实验2: 使用第一种方式注入组件");
        System.out.println("  Order System started on port 8088");
        System.out.println("  Context Path: /order-system");
        System.out.println("  H2 Console: http://localhost:8088/order-system/h2-console");
        System.out.println("======================================");
    }
}
