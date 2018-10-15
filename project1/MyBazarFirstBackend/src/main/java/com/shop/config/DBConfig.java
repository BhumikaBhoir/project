package com.shop.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.shop.model.Cart;
import com.shop.model.Category;
import com.shop.model.Orders;
import com.shop.model.Product;
import com.shop.model.User;

@Configuration
@ComponentScan("com.shop")
@EnableTransactionManagement
class DBConfig 
{ 
		@Autowired
		@Bean(name="dataSource")
		public DataSource getH2DataSource()
		{
			DriverManagerDataSource dataSource=new DriverManagerDataSource();
			
			dataSource.setDriverClassName("org.h2.Driver");
			dataSource.setUrl("jdbc:h2:tcp://localhost/~/test"); //if error db already in use or file is locked
			dataSource.setUsername("sa");
			dataSource.setPassword("");

			System.out.println("DB Connected");
			return dataSource;
		}
		
		@Autowired
		@Bean(name="sessionFactory")
		public SessionFactory getSessionFactory(DataSource dataSource)
		{
			
			Properties properties=new Properties();
			
			properties.put("hibernate.hbm2ddl.auto", "update");
			properties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
			
			LocalSessionFactoryBuilder sessionFactoryBuilder=new LocalSessionFactoryBuilder(dataSource);
			sessionFactoryBuilder.addAnnotatedClass(Product.class);
			sessionFactoryBuilder.addAnnotatedClass(Category.class);
			sessionFactoryBuilder.addAnnotatedClass(User.class);
			sessionFactoryBuilder.addAnnotatedClass(Cart.class);
			sessionFactoryBuilder.addAnnotatedClass(Orders.class);
				
			/*sessionFactoryBuilder.addAnnotatedClass(Supplier.class);*/
			sessionFactoryBuilder.addProperties(properties);
			
			SessionFactory sessionFactory=sessionFactoryBuilder.buildSessionFactory();
			System.out.println("Creating SessionFactory Bean");
			return sessionFactory;
		}
		
		@Autowired
		@Bean(name="transactionManager")
		public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
		{
			System.out.println("Hibernate Transaction Object Created");
			return new HibernateTransactionManager(sessionFactory);
		}
}
