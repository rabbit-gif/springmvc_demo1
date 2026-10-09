package com.experiment.ordersystem.controller;

import com.experiment.ordersystem.model.Order;
import com.experiment.ordersystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * OrderController - 订单控制器
 * 使用 @RestController 声明为 REST 控制器 Bean
 * 使用第一种方式 @Autowired 注入 OrderService
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    /**
     * 第一种注入方式: @Autowired 字段注入
     * Spring IOC 容器会自动将 OrderService 的实现类 Bean 注入到该字段
     */
    @Autowired
    private OrderService orderService;

    /**
     * 注入 ApplicationContext 以演示 IOC 容器功能
     */
    @Autowired
    private ApplicationContext applicationContext;

    /**
     * GET /order/index
     * 返回所有订单列表,并打印控制器信息
     */
    @GetMapping("/index")
    public List<Order> getAll() {
        // 打印当前控制器类名 (通过 IOC 容器上下文)
        String controllerName = this.getClass().getName();
        System.out.println("================================================");
        System.out.println("  控制器被调用: " + controllerName);
        System.out.println("  IOC 容器中的 Bean 定义数量: " + applicationContext.getBeanDefinitionCount());
        System.out.println("  注入方式: 第一种方式 - @Autowired 字段注入");
        System.out.println("================================================");

        // 从 IOC 容器获取当前 Controller Bean 并打印信息
        OrderController self = applicationContext.getBean(OrderController.class);
        System.out.println("[IOC验证] 从容器获取的 Controller Bean: " + self.getClass().getName());
        System.out.println("[IOC验证] 注入的 OrderService Bean: " + self.orderService.getClass().getName());

        // 调用 Service 层获取所有订单
        List<Order> orders = orderService.getAllOrders();
        System.out.println("[OrderController] 返回订单数量: " + orders.size());

        return orders;
    }
}
