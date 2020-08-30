package com.example.bons.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

@EnableTransactionManagement
@EnableJpaRepositories
@Configuration
public class MyConfiguration {


    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
