package com.example.demo.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2017/7/26.
 */
@Configuration
public class MybatisMapperScannerConfig {
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer scanner = new MapperScannerConfigurer();
        scanner.setSqlSessionFactoryBeanName("sqlSessionFactory");  //set 手动配置的sqlSessionFactory
        scanner.setBasePackage("com.example.demo.mapper");
        return scanner;
    }
}
