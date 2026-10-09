package com.experiment.conditioninject.model;

import java.util.Date;

public class Order {

    private Long id;
    private String customerName;
    private Double amount;
    private Date orderDate;

    public Order() {
    }

    public Order(Long id, String customerName, Double amount, Date orderDate) {
        this.id = id;
        this.customerName = customerName;
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
}
