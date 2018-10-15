package com.shop.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shop.model.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO
{
	@Autowired
	private SessionFactory sessionFactory;

	public boolean addCategory(Category category) 
	{
		try 
		{
			sessionFactory.getCurrentSession().saveOrUpdate(category);
			return true;
		} 
		catch (HibernateException e) 
		{
			e.printStackTrace();
			return false;
		}

	}

	public boolean deleteCategory(Category category) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateCategory(Category category) {
		// TODO Auto-generated method stub
		return false;
	}

	public Category getCategory(int categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Category> listCategories() {
		// TODO Auto-generated method stub
		return null;
	}

}
