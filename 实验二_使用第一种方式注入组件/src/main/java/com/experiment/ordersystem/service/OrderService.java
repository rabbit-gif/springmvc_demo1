package com.experiment.ordersystem.service;

import com.experiment.ordersystem.model.Order;

import java.util.List;

/**
 * OrderService 接口 - 订单业务层接口
 */
public interface OrderService {

    /**
     * 获取所有订单
     * @return 订单列表
     */
    List<Order> getAllOrders();

    /**
     * 根据 ID 获取订单
     * @param id 订单ID
     * @return 订单对象
     */
    Order getOrderById(Long id);

    /**
     * 获取订单总数
     * @return 订单数量
     */
    int getOrderCount();
}
