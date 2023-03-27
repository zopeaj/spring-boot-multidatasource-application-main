package com.zopeaj.config.datasource;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
//import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariDataSource;


@Configuration
@EnableJpaRepositories(basePackages="com.zopeaj.repository.product", entityManagerFactoryRef="productEntityManager", transactionManagerRef="productTransactionManager")
public class ProductDataSourceConfiguration {
	
	@Autowired
	Environment env;

	@Bean
	@ConfigurationProperties(prefix="app.product.jpa")
	public JpaProperties productJpaProperties() {
		return new JpaProperties();
	}	
	
	@Bean
	@ConfigurationProperties(prefix="app.product.datasource")
	public DataSourceProperties productDataSourceProperties() {
		return new DataSourceProperties();
	}
	
	@Bean
	public DataSource productDataSource() {
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setUrl(productDataSourceProperties().getUrl());      //env.getProperty("app.product.datasource.url")); //jdbc:h2:mem:testdb
	    dataSource.setUsername(productDataSourceProperties().getUsername());  //env.getProperty("app.product.datasource.username")); //sa
	    dataSource.setPassword(productDataSourceProperties().getPassword()); //env.getProperty("app.product.datasource.password")); //password
	    dataSource.setDriverClassName(productDataSourceProperties().getDriverClassName()); //env.getProperty("app.prime.datasource.driver-class-name")); //org.h2.Driver
	    return dataSource;
	}
	
	
	@Bean
	public LocalContainerEntityManagerFactoryBean productEntityManager() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		
		HashMap<String, Object> properties = new HashMap<String, Object>();
		//properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		//properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
	    properties.put("hibernate.hbm2ddl.auto", "create");
	    properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	    properties.put("hibernate.format_sql", "true");
		
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setShowSql(productJpaProperties().isShowSql());
		vendorAdapter.setDatabase(productJpaProperties().getDatabase());
		vendorAdapter.setDatabasePlatform(productJpaProperties().getDatabasePlatform());
		vendorAdapter.setGenerateDdl(productJpaProperties().isGenerateDdl());
		
		em.setPersistenceUnitName("productdbContext");
		em.setPackagesToScan("com.zopeaj.model.product");
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaPropertyMap(properties);
		em.setDataSource(productDataSource());
		
		return em;
	}
	
	@Bean 
	public PlatformTransactionManager productTransactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(productEntityManager().getObject());
		return transactionManager;
	}
}
