package com.chnu.zno.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:database.properties")
@EnableTransactionManagement
@EnableAutoConfiguration
@EnableJpaRepositories("com.chnu.zno.*")
@ComponentScan("com.chnu.zno.*")
@EntityScan("com.chnu.zno.*")
public class ApplicationDataSource {

    @Autowired
    private Environment environment;

    @Bean
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(environment.getRequiredProperty("hikari.datasource.url"));
        dataSource.setUsername(environment.getRequiredProperty("hikari.datasource.username"));
        dataSource.setPassword(environment.getRequiredProperty("hikari.datasource.password"));
        return dataSource;
    }
}
