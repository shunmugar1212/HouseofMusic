package com.niit.back.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.back.dao.MycartDAO;
import com.niit.back.domain.Mycart;

@Repository("MycartDAO")
@Transactional
public class MycartDAOImpl implements MycartDAO {
	@Autowired
	private SessionFactory sessionFactory;
	public MycartDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	
	public Mycart getByCartId(int cartid) {
		return 	(Mycart)  sessionFactory.getCurrentSession().get(Mycart.class, cartid);
		
		
	}

	@SuppressWarnings("unchecked")
	public List<Mycart> list() {
		return  sessionFactory.getCurrentSession().createQuery("from Mycart").list();

	}

	public boolean validate(String cartid, String password) {
		Query query=sessionFactory.getCurrentSession().createQuery(" from Mykart where cartid = ? and password = ?");
		query.setString(1, cartid);     
		query.setString(2, password);
		 if(  query.uniqueResult()  == null)
		 {
			 
			 return false;
		 }
		 else
		 {
			 
			 return true;
		 }
		
		}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Mycart> listCartByStatus(String userID, String status) {

		return sessionFactory.getCurrentSession()
			.createQuery("from Mycart where email=" + "'" + userID + "' " + "  and status = " + "'" + status + "'")
				.list();

	}
	
	public boolean delete(int cartid) {
		try {
			sessionFactory.getCurrentSession().delete(getByCartId(cartid));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public boolean saveOrUpdate(Mycart mycart) {
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(mycart);
		}catch (Exception e) {
						e.printStackTrace();
			return false;
		}
		return true;
	}


	public List<Mycart> getByEmail(String email) {
		String hql = "from Mycart where email ='" + email +"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Mycart> list = (List<Mycart>) query.list();
		
		return list;
	}
	public Mycart getByProductId(String productId) {
		String hql = "from Mycart where productid ='" + productId + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Mycart> listMycart = (List<Mycart>) (query).list();

		if (listMycart != null && !listMycart.isEmpty()) {
			return listMycart.get(0);
		}
		return null;}

	public Mycart getByProductname(String productname) {
		String hql = "from Mycart where Productname ='" + productname + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Mycart> listMycart = (List<Mycart>) (query).list();

		if (listMycart != null && !listMycart.isEmpty()) {
			return listMycart.get(0);
		}
		return null;
	}


	public boolean itemAlreadyExist(String email, String productId , boolean b) {
		String hql = "from Mycart where email= '" + email + "' and " + " productid ='" + productId +"'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Mycart> list = (List<Mycart>) query.list();
		if (list != null && !list.isEmpty()) {
			return true;
		}
		return false;
	}


	public Mycart getByUserandProduct(String email, String productId ) {
		String hql = "from Mycart where email= '" + email + "' and " + " productid ='" + productId +"'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Mycart> listMycart = (List<Mycart>) query.list();
		
		if (listMycart != null && !listMycart.isEmpty()){
			return listMycart.get(0);
		}
		return null;
	}

	@Transactional
	public Long getTotal(String id) {
		String hql = "select sum(total) from Mycart where email = " + "'" + id + "'" + "and status = '" + "N" +"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		Long sum = (Long) query.uniqueResult();
			return sum;
	}

	@Transactional
	public void updateshipping(String email, int sid) {
		String hql = " update Mycart set sid = '" + sid + "' where email = '" + email + "'";
		sessionFactory.getCurrentSession().createQuery(hql);
	
	}


	public boolean Save(Mycart mycart) {
		try
		{
		sessionFactory.getCurrentSession().save(mycart);
		}catch (Exception e) {
						e.printStackTrace();
			return false;
		}
		return true;
	}


	public boolean Update(Mycart mycart) {
		try
		{
		sessionFactory.getCurrentSession().update(mycart);
		}catch (Exception e) {
						e.printStackTrace();
			return false;
		}
		return true;
	}


	public boolean itemAlreadyExist1(String email, String productName, boolean b) {
		String hql = "from Mycart where email= '" + email + "' and " + " Name ='" + productName +"'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Mycart> list = (List<Mycart>) query.list();
		if (list != null && !list.isEmpty()) {
			return true;
		}
		return false;
	}

}
