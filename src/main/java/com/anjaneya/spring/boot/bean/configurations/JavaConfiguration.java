package com.anjaneya.spring.boot.bean.configurations;

import com.anjaneya.spring.boot.bean.configurations.entity.Company;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfiguration {

    @Bean
    public Company getCustomer() {
        return new Company();
    }
}
