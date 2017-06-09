package com.niit.back.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.back.dao.UserDAO;
import com.niit.back.domain.User;

//Note : we will get errors  - will solve tomorrow

@Repository("UserDAO")
@Transactional
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	//write user defined constructor with one parameter i.e., sessionFactory
	
	public UserDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	/**
	 * This save method create record in the User table.
	 * If the record is created successfully, it will return true
	 * else will return false
	 */

	public void save(User user) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		
	}
	/**
	 * This update method update record in the User table.
	 * If the record is updated successfully, it will return true
	 * else will return false
	 */
	public boolean update(User user) {
		try
		{
		sessionFactory.getCurrentSession().update(user);
		}catch (Exception e) {
			//if any excpetion comes during execute of try block, catch will excute
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * validate method will return true if the credetails are correct
	 * else will return false
	 */
	public boolean validate(String id, String password) {
		
		
	Query query=	 sessionFactory.getCurrentSession().
			createQuery(" from User where id = ? and password = ?");
	query.setString(0, id);     //actually the index will start from zero  - will get once exception.
	query.setString(1, password);
	//in the User table with this id and password there will one or zero records will exist
	//i.e., uniqueResult
	//uniqueResult method will return object if a row exist, else it will return null
	 if(  query.uniqueResult()  == null)
	 {
		 //means no row exist i.e., invalid credentials
		 return false;
	 }
	 else
	 {
		 //means row exist i.e., valid credentials
		 return true;
	 }
	
	}

	@SuppressWarnings("unchecked")
	public List<User> list() {
		
		
		return  sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	public User get(String id) {
		
		//get method get the date from user table based on primary key i.e., id
		// and set it to User class
		//like select * from user where id = ?
	  return 	(User)  sessionFactory.getCurrentSession().get(User.class, id);
		
	}

	public User getByEmailId(String email) {
		String hql = "from User where email ='"+ email +"'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) query.list();
		
		if (listUser != null && !listUser.isEmpty()){
			return listUser.get(0);
		}
		return null;

	}

}















