package com.cmzj21.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


/**
 * Spring配置类
 * @author cmzj21
 */
@Configuration
public class ApplicationContextConfig {
    /**
     * 创建一个RestTemplate对象
     * @return 用于发送请求的RestTemplate对象
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
