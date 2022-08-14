package com.cmzj21.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author cmzj21
 */
@Configuration
public class MyselfRule {
    /**
     * 随机负载均衡
     * @return RandomRule对象
     */
    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}