package com.experiment.ordersystem.model;

import java.util.Date;

/**
 * Order 实体类
 */
public class Order {

    private Long id;
    private String customerName;
    private String productItem;
    private String address;
    private Double amount;
    private Date orderDate;

    public Order() {
    }

    public Order(Long id, String customerName, String productItem, String address, Double amount, Date orderDate) {
        this.id = id;
        this.customerName = customerName;
        this.productItem = productItem;
        this.address = address;
        this.amount = amount;
        this.orderDate = orderDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductItem() {
        return productItem;
    }

    public void setProductItem(String productItem) {
        this.productItem = productItem;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", productItem='" + productItem + '\'' +
                ", address='" + address + '\'' +
                ", amount=" + amount +
                ", orderDate=" + orderDate +
                '}';
    }
}
