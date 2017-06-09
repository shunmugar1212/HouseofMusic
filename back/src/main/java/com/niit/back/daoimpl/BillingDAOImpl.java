package com.niit.back.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.back.dao.BillingDAO;
import com.niit.back.domain.Billing;

@Repository("BillingDAO")
@Transactional
public class BillingDAOImpl implements BillingDAO {
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Autowired
	public BillingDAOImpl(SessionFactory sessionFactory)
	{
		this.setSessionFactory(sessionFactory);
	}
	public Billing get(String id) {
		return 	(Billing)  sessionFactory.getCurrentSession().get(Billing.class, id);	
	}
	@SuppressWarnings("unchecked")
	public List<Billing> list() {
		return  sessionFactory.getCurrentSession().createQuery("from Billing").list();
	}
	
	public boolean save(Billing billing) {
		try
		{
		sessionFactory.getCurrentSession().save(billing);
		}catch (Exception e) {
			//if any exception comes during execute of try block, catch will execute
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(Billing billing) {
		try
		{
		sessionFactory.getCurrentSession().update(billing);
		}catch (Exception e) {
			//if any exception comes during execute of try block, catch will excute
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
}
