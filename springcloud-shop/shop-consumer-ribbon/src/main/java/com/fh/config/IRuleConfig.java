package com.fh.config;

import com.fh.rule.CustomRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 15136
 */
@Configuration
public class IRuleConfig {

    @Bean
    public IRule iRule(){
        /**
         * 随机负载均衡算法
         */
        // return new RandomRule();

        /**
         * 自定义负载均衡算法
         */
        return new CustomRule();
    }

}
