package com.sap.devcamp.bookstore.conf;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration public class DataSourceConfig {

    @Value ("${db.url}") private String dbUrl;
    @Value ("${db.driver}") private String dbDriver;
    @Value ("${db.user}") private String dbUser;
    @Value ("${db.pass}") private String dbPass;

    @Value ("${hibernate.dialect}") private String hibernateDialect;
    @Value ("${hibernate.hbm2ddl.auto}") private String hibernateDdlAuto;
    @Value ("${hibernate.ejb.naming_strategy}") private String hibernateNamingStrategy;
    @Value ("${hibernate.show_sql}") private String hibernateShowSql;
    @Value ("${hibernate.format_sql}") private String hibernateFormatSql;

    @Bean (destroyMethod = "close") public DataSource dataSource () {
        HikariConfig dataSourceConfig = new HikariConfig();
        dataSourceConfig.setDriverClassName(dbDriver);
        dataSourceConfig.setJdbcUrl(dbUrl);
        dataSourceConfig.setUsername(dbUser);
        dataSourceConfig.setPassword(dbPass);
        return new HikariDataSource(dataSourceConfig);
    }

    @Bean public LocalContainerEntityManagerFactoryBean entityManagerFactory (DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan("com.sap.devcamp.bookstore.model");

        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.dialect", hibernateDialect);
        jpaProperties.put("hibernate.hbm2ddl.auto", hibernateDdlAuto);
        jpaProperties.put("hibernate.ejb.naming_strategy", hibernateNamingStrategy);
        jpaProperties.put("hibernate.show_sql", hibernateShowSql);
        jpaProperties.put("hibernate.format_sql", hibernateFormatSql);

        entityManagerFactoryBean.setJpaProperties(jpaProperties);
        return entityManagerFactoryBean;
    }

    @Bean public JpaTransactionManager transactionManager (EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

    @Bean public EntityManager entityManager (EntityManagerFactory entityManagerFactory) {
        return entityManagerFactory.createEntityManager();
    }

}
