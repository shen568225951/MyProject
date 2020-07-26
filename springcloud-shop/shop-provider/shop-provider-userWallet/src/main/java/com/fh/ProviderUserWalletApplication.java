package com.fh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 15136
 */
@SpringBootApplication
@EnableEurekaClient
public class ProviderUserWalletApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderUserWalletApplication.class,args);
    }
}
