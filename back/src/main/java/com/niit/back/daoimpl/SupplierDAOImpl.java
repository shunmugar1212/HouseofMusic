package com.niit.back.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.back.dao.SupplierDAO;
import com.niit.back.domain.Supplier;

@Repository("SupplierDAO")
@Transactional
public class SupplierDAOImpl implements SupplierDAO{
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Autowired
	public SupplierDAOImpl(SessionFactory sessionFactory)
	{
		this.setSessionFactory(sessionFactory);
	}
	
	public boolean save(Supplier supplier) {
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
		}catch (Exception e) {
			//if any exception comes during execute of try block, catch will execute
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
public Supplier get(String id) {
		
		// TODO Auto-generated method stub
		  return 	(Supplier)  sessionFactory.getCurrentSession().get(Supplier.class, id);
	}

	public boolean update(Supplier supplier) {
		try
		{
		sessionFactory.getCurrentSession().update(supplier);
		}catch (Exception e) {
			//if any exception comes during execute of try block, catch will execute
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Transactional
	public void delete(String id){
		Supplier supplierToDelete = new Supplier();
		supplierToDelete.setSupplierId(id);
		sessionFactory.getCurrentSession().delete(supplierToDelete);
	}
	public void editSupplier(Supplier supplier) {

		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
	}
	
	public List<Supplier> search(String keyWord) {
		// TODO Auto-generated method stub
		return null;
	}
	@SuppressWarnings("unchecked")
	public List<Supplier> list() {
		return  sessionFactory.getCurrentSession().createQuery("from Supplier").list();
	}

	
}
