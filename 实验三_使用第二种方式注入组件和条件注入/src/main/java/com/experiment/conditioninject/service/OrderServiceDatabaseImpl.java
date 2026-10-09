package com.experiment.conditioninject.service;

import com.experiment.conditioninject.model.Order;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
@ConditionalOnProperty(name = "service.impl", havingValue = "database")
public class OrderServiceDatabaseImpl implements OrderService {

    private final JdbcTemplate jdbcTemplate;

    public OrderServiceDatabaseImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        initDatabase();
    }

    private void initDatabase() {
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS orders (" +
                "id BIGINT AUTO_INCREMENT PRIMARY KEY, " +
                "customer_name VARCHAR(100), " +
                "amount DOUBLE, " +
                "order_date TIMESTAMP)");

        jdbcTemplate.update("INSERT INTO orders (customer_name, amount, order_date) VALUES (?, ?, CURRENT_TIMESTAMP)",
                "数据库用户A", 399.99);
        jdbcTemplate.update("INSERT INTO orders (customer_name, amount, order_date) VALUES (?, ?, CURRENT_TIMESTAMP)",
                "数据库用户B", 799.50);
        jdbcTemplate.update("INSERT INTO orders (customer_name, amount, order_date) VALUES (?, ?, CURRENT_TIMESTAMP)",
                "数据库用户C", 259.00);
    }

    @Override
    public List<Order> getAllOrders() {
        String sql = "SELECT id, customer_name, amount, order_date FROM orders";
        return jdbcTemplate.query(sql, new OrderRowMapper());
    }

    private static class OrderRowMapper implements RowMapper<Order> {
        @Override
        public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
            Order order = new Order();
            order.setId(rs.getLong("id"));
            order.setCustomerName(rs.getString("customer_name"));
            order.setAmount(rs.getDouble("amount"));
            order.setOrderDate(rs.getTimestamp("order_date"));
            return order;
        }
    }
}
