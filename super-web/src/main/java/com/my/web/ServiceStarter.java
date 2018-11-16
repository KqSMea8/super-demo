package com.my.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by lilianga on 2018/11/12.
 */
/*Spring Boot 的核心注解，它是一个组合注解，该注解组合了：@Configuration、@EnableAutoConfiguration、@ComponentScan*/
@SpringBootApplication
public class ServiceStarter {
    public static void main(String[] args) {
        SpringApplication.run(ServiceStarter.class, args);
    }
}
