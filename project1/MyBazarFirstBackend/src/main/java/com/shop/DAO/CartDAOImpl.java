package com.shop.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shop.model.Cart;

@Repository("cartDAO")
@Transactional
public class CartDAOImpl implements CartDAO
{
	@Autowired
	private SessionFactory sessionFactory;

	public boolean addToCart(Cart cart) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(cart);	
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;	
		}

	}

	public boolean deleteFromCart(Cart cart) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateCart(Cart cart) {
		// TODO Auto-generated method stub
		return false;
	}

	public Cart getCartItem(int cartId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Cart> listCartItems(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
