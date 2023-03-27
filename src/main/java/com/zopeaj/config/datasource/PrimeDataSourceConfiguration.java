 package com.zopeaj.config.datasource;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
 @EnableJpaRepositories(basePackages="com.zopeaj.repository.prime", entityManagerFactoryRef="primeEntityManager", transactionManagerRef="primeTransactionManager")
 public class PrimeDataSourceConfiguration {
	
	@Autowired
	Environment env;

	@Bean
	@Primary
	@ConfigurationProperties(prefix="app.prime.jpa")
	public JpaProperties primeJpaProperties() {
		return new JpaProperties();
	}	
	
	@Bean
	@Primary
	@ConfigurationProperties(prefix="app.prime.datasource")
	public DataSourceProperties primeDataSourceProperties() {
		return new DataSourceProperties();
	}
	
	@Bean
	@Primary
	public DataSource primeDataSource() {
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setUrl(primeDataSourceProperties().getUrl());      //env.getProperty("app.product.datasource.url")); //jdbc:h2:mem:testdb
	    dataSource.setUsername(primeDataSourceProperties().getUsername());  //env.getProperty("app.product.datasource.username")); //sa
	    dataSource.setPassword(primeDataSourceProperties().getPassword()); //env.getProperty("app.product.datasource.password")); //password
	    dataSource.setDriverClassName(primeDataSourceProperties().getDriverClassName()); //env.getProperty("app.prime.datasource.driver-class-name")); //org.h2.Driver
	    return dataSource;
	}
	
	
	@Bean
	@Primary
	public LocalContainerEntityManagerFactoryBean primeEntityManager() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		
		HashMap<String, Object> properties = new HashMap<String, Object>();
		//properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		//properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
	    properties.put("hibernate.hbm2ddl.auto", "create");
	    properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	    properties.put("hibernate.format_sql", "true");
		
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setShowSql(primeJpaProperties().isShowSql());
		vendorAdapter.setDatabase(primeJpaProperties().getDatabase());
		vendorAdapter.setDatabasePlatform(primeJpaProperties().getDatabasePlatform());
		vendorAdapter.setGenerateDdl(primeJpaProperties().isGenerateDdl());
		
		em.setPersistenceUnitName("primedbContext");
		em.setPackagesToScan("com.zopeaj.model.prime");
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaPropertyMap(properties);
		em.setDataSource(primeDataSource());
		
		return em;
	}
	
	@Bean 
	@Primary
	public PlatformTransactionManager primeTransactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(primeEntityManager().getObject());
		return transactionManager;
	}	
 }