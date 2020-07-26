package com.fh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 15136
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class ProviderOrderInfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderOrderInfoApplication.class,args);
    }
}
