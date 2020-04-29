package com.qintess.webapp.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;


// A classe deve ser anotadas com a anotação Configuration e precisa lidar com Transações do SQL por meio do EnableTransictionManagement
@Configuration
@EnableTransactionManagement
public class HibernateConfig {
	//A anotação @Bean em um metodo significa que ele será involcado pelo spring, de forma automatica
	
	@Bean       
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("com.qintess.webapp.model");  //HibernateConfig, do spring lida com pacotes e nao classes para fazer o scan de entidades do hibernate
		sessionFactory.setHibernateProperties(hibernateProperties());
		
		return sessionFactory;
	}
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:~/desafio4_eventoswebapp");
		//os dados de user e pass precisam ser passados
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		return dataSource;
	}
	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}
	
	private final Properties hibernateProperties() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.hbm2dd1.auto", "create-drop");
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		hibernateProperties.setProperty("hibernate.jdbc.time_zone","UTC");
		
		return hibernateProperties;
	}
}
