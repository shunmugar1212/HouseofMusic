package com.niit.back.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.back.dao.ProductDAO;
import com.niit.back.domain.Product;


@Repository("ProductDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public ProductDAOImpl(SessionFactory sessionFactory)
	{
		this.setSessionFactory(sessionFactory);
	}

	public boolean save(Product product) {
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(product);
		}catch (Exception e) {
			//if any excpetion comes during execute of try block, catch will excute
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(Product product) {
		try
		{
		sessionFactory.getCurrentSession().update(product);
		}catch (Exception e) {
			//if any excpetion comes during execute of try block, catch will excute
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<Product> list() {
		return  sessionFactory.getCurrentSession().createQuery("from Product").list();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	@Transactional
	public void delete(String id) {
		Product productToDelete = new Product();
		productToDelete.setProductId(id);
		sessionFactory.getCurrentSession().delete(productToDelete);
	}
	
	public List<Product> list(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	public Product get(String productId) {
		
		// TODO Auto-generated method stub
		  return 	(Product)  sessionFactory.getCurrentSession().get(Product.class, productId);
	}

	public List<Product> search(String keyWord) {
		// TODO Auto-generated method stub
		return null;
	}

	public void editProduct(Product product) {

		sessionFactory.getCurrentSession().saveOrUpdate(product);
	}

	public boolean saveorupdate(Product product) {
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(product);
		}catch (Exception e) {
			//if any excpetion comes during execute of try block, catch will excute
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<Product> getAllProductsByCategoryID(String categoryID) {
		Query query=	getCurrentSession().createQuery("from Product where categoryID=?");
		query.setString(0, categoryID);
		
	    return	query.list();
	}


	private SharedSessionContract getCurrentSession() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> getSimilarProducts(String search_string) {
		// TODO Auto-generated method stub
		return null;
	}




}
