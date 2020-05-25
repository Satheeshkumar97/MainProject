package com.niit.Backend.config;

import java.util.Properties;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages="com.niit")
public class DBConfig {

	@Bean (name="dataSource")
	public DataSource dataSource()
	
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		
		return dataSource;
	}
	public Properties getHibernateProperties()
	{
		Properties hp = new Properties();
		hp.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		hp.setProperty("hiberate.hbm2ddl.auto", "update");
		hp.setProperty("hibernate.show_sql","true");
		
		return hp;
	}
	
	@Bean(name="sessionFactory")
	@Autowired
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource)
	{
		LocalSessionFactoryBean sessionFactory =new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setHibernateProperties(getHibernateProperties());
		sessionFactory.setPackagesToScan("com.niit");
		
		return sessionFactory;
		
	}
	
@Bean (name="transactionManager")
@Autowired 
public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
{
HibernateTransactionManager tM = new HibernateTransactionManager();
tM.setSessionFactory(sessionFactory);

return tM;
}
}
