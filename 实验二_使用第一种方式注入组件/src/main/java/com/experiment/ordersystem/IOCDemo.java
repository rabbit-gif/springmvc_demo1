package com.experiment.ordersystem;

import com.experiment.ordersystem.controller.OrderController;
import com.experiment.ordersystem.dao.OrderDao;
import com.experiment.ordersystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * IOCDemo - 演示 IOC 容器使用
 * 实现 CommandLineRunner 接口,在应用启动后自动执行
 * 使用 @Component 注解声明为 Spring Bean
 * 使用第一种方式 @Autowired 注入 ApplicationContext
 */
@Component
public class IOCDemo implements CommandLineRunner {

    /**
     * 第一种注入方式: @Autowired 字段注入 ApplicationContext
     * ApplicationContext 是 Spring IOC 容器的核心接口
     */
    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void run(String... args) throws Exception {
        System.out.println();
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║         实验2: 使用第一种方式(@Autowired)注入组件            ║");
        System.out.println("║              IOC 容器演示 (CommandLineRunner)                 ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
        System.out.println();

        // 1. 打印 IOC 容器信息
        System.out.println(">>> 一、IOC 容器基本信息");
        System.out.println("  ApplicationContext 实现类: " + applicationContext.getClass().getName());
        System.out.println("  Bean 定义总数: " + applicationContext.getBeanDefinitionCount());
        System.out.println("  容器启动时间: " + applicationContext.getStartupDate());
        System.out.println();

        // 2. 从容器中获取关键 Bean 并打印信息
        System.out.println(">>> 二、从 IOC 容器获取关键 Bean");
        printBeanInfo("orderSystemApplication", OrderSystemApplication.class);
        printBeanInfo("orderController", OrderController.class);
        printBeanInfo("orderService", OrderService.class);
        printBeanInfo("orderDao", OrderDao.class);
        printBeanInfo("iocDemo", IOCDemo.class);
        System.out.println();

        // 3. 验证第一种注入方式的效果
        System.out.println(">>> 三、验证第一种注入方式(@Autowired 字段注入)");
        OrderController controller = applicationContext.getBean(OrderController.class);
        OrderService service = applicationContext.getBean(OrderService.class);
        OrderDao dao = applicationContext.getBean(OrderDao.class);

        System.out.println("  OrderController 实例: " + controller.getClass().getName());
        System.out.println("  OrderService 实现类实例: " + service.getClass().getName());
        System.out.println("  OrderDao 实例: " + dao.getClass().getName());
        System.out.println("  说明: 以上 Bean 均通过 @Autowired 字段注入方式完成装配");
        System.out.println();

        // 4. 打印所有 Bean 名称
        System.out.println(">>> 四、IOC 容器中所有 Bean 名称");
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        int count = 0;
        for (String name : beanNames) {
            if (name.startsWith("com.experiment") || name.contains("order")
                    || name.contains("Order") || name.contains("IOC")) {
                System.out.println("  [" + (++count) + "] " + name);
            }
        }
        System.out.println("  (共显示 " + count + " 个项目相关 Bean)");
        System.out.println();

        // 5. 演示数据访问
        System.out.println(">>> 五、验证数据库初始化");
        int orderCount = dao.count();
        System.out.println("  订单表中记录数: " + orderCount);
        System.out.println("  客户表记录数: " + dao.findAllCustomers().size());
        System.out.println("  产品表记录数: " + dao.findAllProducts().size());
        System.out.println();

        System.out.println("═══════════════════════════════════════════");
        System.out.println("  IOC 容器演示完成, 应用已就绪!");
        System.out.println("  访问地址: http://localhost:8088/order-system/order/index");
        System.out.println("═══════════════════════════════════════════");
        System.out.println();
    }

    /**
     * 打印 Bean 信息
     */
    private <T> void printBeanInfo(String beanName, Class<T> clazz) {
        try {
            T bean = applicationContext.getBean(clazz);
            System.out.println("  Bean名[" + beanName + "] -> 实现类: " + bean.getClass().getSimpleName()
                    + " | 注入方式: @Autowired字段注入");
        } catch (Exception e) {
            System.out.println("  Bean名[" + beanName + "] -> 不存在或获取失败: " + e.getMessage());
        }
    }
}
