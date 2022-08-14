package com.cmzj21.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author cmzj21
 */
@Configuration
public class ApplicationContextConfig {
    /**
     * 配置日志级别
     * @return 返回配置好的日志级别
     */
    @Bean
    Logger.Level feignLoggerLevel(){
        return  Logger.Level.FULL;
    }
}
