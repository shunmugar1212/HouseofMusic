package com.niit.back.config;

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

import com.niit.back.domain.Billing;
import com.niit.back.domain.Category;
import com.niit.back.domain.Mycart;
import com.niit.back.domain.Product;
import com.niit.back.domain.Role;
import com.niit.back.domain.Shipping;
import com.niit.back.domain.Supplier;
import com.niit.back.domain.User;
import com.niit.back.dao.BillingDAO;
import com.niit.back.dao.CategoryDAO;
import com.niit.back.dao.MycartDAO;
import com.niit.back.dao.ProductDAO;
import com.niit.back.dao.RoleDAO;
import com.niit.back.dao.ShippingDAO;
import com.niit.back.dao.SupplierDAO;
import com.niit.back.dao.UserDAO;
import com.niit.back.daoimpl.BillingDAOImpl;
import com.niit.back.daoimpl.CategoryDAOImpl;
import com.niit.back.daoimpl.MycartDAOImpl;
import com.niit.back.daoimpl.ProductDAOImpl;
import com.niit.back.daoimpl.RoleDAOImpl;
import com.niit.back.daoimpl.ShippingDAOImpl;
import com.niit.back.daoimpl.SupplierDAOImpl;
import com.niit.back.daoimpl.UserDAOImpl;

@Configuration
@ComponentScan("com.niit.back")
@EnableTransactionManagement
public class ApplicationContextConfig {

	@Autowired
	@Bean(name = "dataSource")
	public DataSource getH2DataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setUrl("jdbc:h2:tcp://localhost/~/back");

		dataSource.setDriverClassName("org.h2.Driver");

		dataSource.setUsername("aaa");
		dataSource.setPassword("aaa");

		return dataSource;
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();

		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {

		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(User.class);
		sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addAnnotatedClass(Product.class);
		sessionBuilder.addAnnotatedClass(Billing.class);
		sessionBuilder.addAnnotatedClass(Mycart.class);
		sessionBuilder.addAnnotatedClass(Role.class);
		sessionBuilder.addAnnotatedClass(Shipping.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
	
		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

		return transactionManager;
	}

	@Autowired(required=true)
	@Bean(name = "userDAO")
	public UserDAO getuserDAO(SessionFactory sessionFactory) {
		return new UserDAOImpl(sessionFactory);
	}
	

	@Autowired(required=true)
	@Bean(name = "categoryDAO")
	public CategoryDAO getcategoryDAO(SessionFactory sessionFactory) {
		return new CategoryDAOImpl(sessionFactory);
	}
	
	@Autowired(required=true)
	@Bean(name = "productDAO")
	public ProductDAO getproductDAO(SessionFactory sessionFactory) {
		return new ProductDAOImpl(sessionFactory);
	}

	@Autowired(required=true)
	@Bean(name = "billingDAO")
	public BillingDAO getbillingDAO(SessionFactory sessionFactory) {
		return new BillingDAOImpl(sessionFactory);
	}
	
	@Autowired(required=true)
	@Bean(name = "mycartDAO")
	public MycartDAO getmycartDAO(SessionFactory sessionFactory) {
		return new MycartDAOImpl(sessionFactory);
	}
	
	@Autowired(required=true)
	@Bean(name = "roleDAO")
	public RoleDAO getroleDAO(SessionFactory sessionFactory) {
		return new RoleDAOImpl(sessionFactory);
	}
	
	@Autowired(required=true)
	@Bean(name = "shippingDAO")
	public ShippingDAO getshippingDAO(SessionFactory sessionFactory) {
		return new ShippingDAOImpl(sessionFactory);
	}
	
	@Autowired(required=true)
	@Bean(name = "supplierDAO")
	public SupplierDAO getsupplierDAO(SessionFactory sessionFactory) {
		return new SupplierDAOImpl(sessionFactory);
	}
}
