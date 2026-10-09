package com.experiment.conditioninject.config;

import com.experiment.conditioninject.service.OrderService;
import com.experiment.conditioninject.service.OrderServiceDatabaseImpl;
import com.experiment.conditioninject.service.OrderServiceMemoryImpl;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class AppConfig {

    private final Environment environment;

    public AppConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public OrderService orderService(ObjectProvider<OrderServiceMemoryImpl> memoryProvider,
                                      ObjectProvider<OrderServiceDatabaseImpl> databaseProvider) {
        String impl = environment.getProperty("service.impl", "memory");
        System.out.println("[AppConfig] 从 Environment 读取 service.impl = " + impl);
        System.out.println("[AppConfig] 使用第二种方式(@Configuration + @Bean + ObjectProvider)注入 OrderService 组件");
        if ("database".equals(impl)) {
            return databaseProvider.getIfAvailable();
        }
        return memoryProvider.getIfAvailable();
    }
}
