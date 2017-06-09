package com.niit.back.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.back.domain.Category;
import com.niit.back.dao.CategoryDAO;

@Repository("CategoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public CategoryDAOImpl(SessionFactory sessionFactory)
	{
		this.setSessionFactory(sessionFactory);
	}

	public boolean save(Category category) {
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(category);
		}catch (Exception e) {
			//if any excpetion comes during execute of try block, catch will excute
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(Category category) {
		try
		{
		sessionFactory.getCurrentSession().update(category);
		}catch (Exception e) {
			//if any excpetion comes during execute of try block, catch will excute
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<Category> list() {
		return  sessionFactory.getCurrentSession().createQuery("from Category").list();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public void delete(String id) {
		Category categoryToDelete = new Category();
		categoryToDelete.setCategoryId(id);
		sessionFactory.getCurrentSession().delete(categoryToDelete);
	}


	public void editCategory(Category category) {

		sessionFactory.getCurrentSession().saveOrUpdate(category);
	}

	public Category get(String id) {
		// TODO Auto-generated method stub
		return (Category) sessionFactory.getCurrentSession().get(Category.class, id);
	}

	public List<Category> search(String keyWord) {
		// TODO Auto-generated method stub
		return null;
	}
}
