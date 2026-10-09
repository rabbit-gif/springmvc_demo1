package com.experiment.ordersystem.service;

import com.experiment.ordersystem.dao.OrderDao;
import com.experiment.ordersystem.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.List;

/**
 * OrderServiceImpl - 订单业务层实现
 * 使用 @Service 注解声明为 Spring Bean
 * 使用第一种方式 @Autowired 注入 OrderDao
 */
@Service
public class OrderServiceImpl implements OrderService {

    /**
     * 第一种注入方式: @Autowired 字段注入
     * 通过 @Autowired 注解将 OrderDao Bean 自动注入到该字段
     */
    @Autowired
    private OrderDao orderDao;

    /**
     * 初始化回调: 验证 Bean 是否正确注入
     */
    @PostConstruct
    public void init() {
        System.out.println("[OrderServiceImpl] @Service Bean 已初始化");
        System.out.println("[OrderServiceImpl] 使用第一种方式 @Autowired 注入了 OrderDao: " + (orderDao != null ? "成功" : "失败"));
        System.out.println("[OrderServiceImpl] 当前订单总数: " + orderDao.count());
    }

    @Override
    public List<Order> getAllOrders() {
        System.out.println("[OrderServiceImpl] 调用 OrderDao.findAll() 获取所有订单...");
        return orderDao.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        System.out.println("[OrderServiceImpl] 调用 OrderDao.findById(" + id + ") ...");
        return orderDao.findById(id);
    }

    @Override
    public int getOrderCount() {
        return orderDao.count();
    }
}
