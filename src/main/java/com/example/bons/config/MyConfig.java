package com.example.bons.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

import javax.sql.DataSource;

@Configuration
public class MyConfig {

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder builder = DataSourceBuilder.create()
                .type(com.zaxxer.hikari.HikariDataSource.class)
                .driverClassName("org.postgresql.Driver")
                .url("jdbc:postgresql://localhost:5432/bondb")
                .username("richard")
                .password("test123");
        return builder.build();
    }

    @Bean
    @Autowired
    public SessionFactory localSessionFactoryBean(DataSource dataSource) {
        return new LocalSessionFactoryBuilder(dataSource)
                .addResource("Address.hbm.xml")
                .addResource("Bon.hbm.xml")
                .addResource("Payment.hbm.xml")
                .addResource("PetrolStation.hbm.xml")
                .configure() //zeigt per default auf hibernate.cfg.xml im classpath
                .buildSessionFactory();
    }

    @Bean
    @Autowired
    public HibernateTransactionManager hibernateTransactionmanager(SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }
}
