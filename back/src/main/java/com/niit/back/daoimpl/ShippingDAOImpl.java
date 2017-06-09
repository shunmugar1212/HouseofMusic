package com.niit.back.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.back.dao.ShippingDAO;
import com.niit.back.domain.Shipping;

@Repository("ShippingDAO")
@Transactional
public class ShippingDAOImpl implements ShippingDAO{
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Autowired
	public ShippingDAOImpl(SessionFactory sessionFactory)
	{
		this.setSessionFactory(sessionFactory);
	}
	public Shipping get(String id) {
		return 	(Shipping)  sessionFactory.getCurrentSession().get(Shipping.class, id);	
	}
	@SuppressWarnings("unchecked")
	public List<Shipping> list() {
		return  sessionFactory.getCurrentSession().createQuery("from Shipping").list();
	}
	
	public boolean save(Shipping shipping) {
		try
		{
		sessionFactory.getCurrentSession().save(shipping);
		}catch (Exception e) {
			//if any exception comes during execute of try block, catch will execute
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(Shipping shipping) {
		try
		{
		sessionFactory.getCurrentSession().update(shipping);
		}catch (Exception e) {
			//if any exception comes during execute of try block, catch will excute
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public List<Shipping> list(String mail) {
		String hql = "from Shipping where mail='" + mail + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Shipping> list = (List<Shipping>) query.list();
		
		return list;
	}
	public Shipping getByShippingAddress(String address) {
		String hql = "from Shippingaddress where address ='" + address + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Shipping> listShipping = (List<Shipping>) (query).list();

		if (listShipping != null && !listShipping.isEmpty()) {
			return listShipping.get(0);
		}
		return null;
	}
	public Shipping getByUserName(String username) {
		String hql = "from Shippingaddress where username='" + username + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Shipping> listShippingaddress = (List<Shipping>) (query).list();

		if (listShippingaddress != null && !listShippingaddress.isEmpty()) {
			return listShippingaddress.get(0);
		}
		return null;
	}
	public void saveOrUpdate(Shipping address) {
		sessionFactory.getCurrentSession().saveOrUpdate(address);		
	}
	public void delete(String id) {
		Shipping shippingToDelete = new Shipping();
		shippingToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(shippingToDelete);		
	}
	public Shipping getBySid(int id) {
		String hql = "from Shipping where ShippingId='" + id + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Shipping> listShipping = (List<Shipping>) (query).list();

		if (listShipping != null && !listShipping.isEmpty()) {
			return listShipping.get(0);
		}
		return null;
	}

	
}
