package com.experiment.conditioninject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class ConditionInjectApplication implements CommandLineRunner {

    private final Environment environment;

    public ConditionInjectApplication(Environment environment) {
        this.environment = environment;
    }

    public static void main(String[] args) {
        SpringApplication.run(ConditionInjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String impl = environment.getProperty("service.impl", "memory");
        System.out.println("========================================");
        System.out.println("ConditionInjectApplication 启动完成");
        System.out.println("当前使用的 service.impl 配置值: " + impl);
        System.out.println("========================================");
    }
}
