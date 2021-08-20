package com.example.bons.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.TransactionManager;

import javax.sql.DataSource;

@Configuration
public class MyConfig {

    @Bean
    public DataSource dataSource(){
        DataSourceBuilder builder = DataSourceBuilder.create()
                .type(com.zaxxer.hikari.HikariDataSource.class)
                .driverClassName("org.postgresql.Driver")
                .url("jdbc:postgresql://localhost:5432/bondb")
                .username("richard")
                .password("test123");
        return builder.build();
    }

    @Bean(name = "sessionFactory")
    @Autowired
    public LocalSessionFactoryBean localSessionFactoryBean(DataSource dataSource){
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource);
        localSessionFactoryBean.setConfigLocation(new ClassPathResource("hibernate.cfg.xml"));
        localSessionFactoryBean.setMappingResources("Address.hbm.xml");
        return localSessionFactoryBean;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager hibernateTransactionmanager(SessionFactory sessionFactory){
        return new HibernateTransactionManager(sessionFactory);
    }
}
