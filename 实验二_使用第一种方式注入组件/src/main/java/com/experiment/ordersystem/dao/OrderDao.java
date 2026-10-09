package com.experiment.ordersystem.dao;

import com.experiment.ordersystem.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * OrderDao - 数据访问层
 * 使用 @Repository 注解声明为 Spring Bean
 * 使用 JdbcTemplate 进行数据库操作
 */
@Repository
public class OrderDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 初始化: 打印 DAO 初始化信息
     */
    @PostConstruct
    public void init() {
        System.out.println("[OrderDao] @Repository Bean 已初始化, 使用第一种方式(@Autowired)注入 JdbcTemplate");
    }

    /**
     * RowMapper: 将数据库行映射为 Order 对象
     */
    private static class OrderRowMapper implements RowMapper<Order> {
        @Override
        public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
            Order order = new Order();
            order.setId(rs.getLong("id"));
            order.setCustomerName(rs.getString("customer_name"));
            order.setProductItem(rs.getString("product_item"));
            order.setAddress(rs.getString("address"));
            order.setAmount(rs.getDouble("amount"));
            order.setOrderDate(rs.getTimestamp("order_date"));
            return order;
        }
    }

    /**
     * 查询所有订单
     */
    public List<Order> findAll() {
        String sql = "SELECT id, customer_name, product_item, address, amount, order_date FROM t_order ORDER BY order_date DESC";
        return jdbcTemplate.query(sql, new OrderRowMapper());
    }

    /**
     * 根据 ID 查询订单
     */
    public Order findById(Long id) {
        String sql = "SELECT id, customer_name, product_item, address, amount, order_date FROM t_order WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new OrderRowMapper(), id);
    }

    /**
     * 查询订单总数
     */
    public int count() {
        String sql = "SELECT COUNT(*) FROM t_order";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count != null ? count : 0;
    }

    /**
     * 查询所有客户
     */
    public List<String> findAllCustomers() {
        String sql = "SELECT DISTINCT name FROM customer ORDER BY name";
        return jdbcTemplate.queryForList(sql, String.class);
    }

    /**
     * 查询所有产品
     */
    public List<String> findAllProducts() {
        String sql = "SELECT product_name FROM product_item ORDER BY product_name";
        return jdbcTemplate.queryForList(sql, String.class);
    }
}
