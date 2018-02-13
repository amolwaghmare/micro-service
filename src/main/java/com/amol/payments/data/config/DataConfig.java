package com.amol.payments.data.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @author Amol Waghmare
 * Spring configuration class for database configuration using Spring Data JPA and Hibernate.
 *  TODO: Externalize thehard coded values of database configuration.
 *
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.amol.payments.data.repository", transactionManagerRef = "tx-manager", entityManagerFactoryRef = "emf")
public class DataConfig {

	final static Logger logger = LogManager.getLogger(DataConfig.class);
	
	
	@Value("${db.server}")
	private String dbServer;
	
	@Value("${db.port}")
	private String dbPort;
	
	//root
	@Value("${db.user}")
	private String dbUser;
	
	//mysql_Amol
	@Value("${db.password}")
	private String dbPassword;
	

	@Bean(name = "emf")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		logger.debug(" Getting entityManagerFactory..");
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] { "com.amol.payments.data" });

		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());

		return em;
	}

	@Bean
	public DataSource dataSource() {
		logger.debug(" Getting Datasource..param.");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		//dataSource.setUrl("jdbc:mysql://localhost:3306/First_DB");
		dataSource.setUrl("jdbc:mysql://"+dbServer+":"+dbPort+"/First_DB");
		dataSource.setUsername(dbUser);
		dataSource.setPassword(dbPassword);
		return dataSource;
	}

	@Bean(name = "tx-manager")
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);

		return transactionManager;
	}

	Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "create");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		properties.setProperty("hibernate.show_sql", "true");
		return properties;
	}
}