package com.shop.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shop.model.User;

@Repository("userDAO")
@Transactional

public class UserDAOImpl implements UserDAO
{
	@Autowired
	private SessionFactory sessionFactory;

	public boolean save(User user) 
	{
		try 
		{
			sessionFactory.getCurrentSession().save(user);
		}
		catch(Exception e)
		{
			//e.printStackTrace();
			return false;
		}
		
		return true;
}

	public boolean delete(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	public User getUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> list(String role) {
		// TODO Auto-generated method stub
		return null;
	}

	public User validate(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
