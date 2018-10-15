package com.shop.TeseCases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shop.DAO.UserDAO;
import com.shop.model.User;

public class UserDAOTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	
	@Ignore
	@Test
	public void saveUserTestCase()
	{
		User user = new User();
		user.setUsername("C");
		user.setPassword("143");
		user.setRole("ROLE_USER");
		user.setCustomerName("Mali");
		user.setMobileNo("254875525");
		user.setEmailId("C@abc.com");
		user.setAddress("India");
		
		
		assertTrue("Problem in Saving User", userDAO.save(user));
	}
	
	
	@Ignore
	@Test
	public void deleteUserTestCase()
	{
		boolean actual = userDAO.delete("asd");
		assertEquals("Delete User", true, actual);
	}
	@Ignore
	@Test
	public void getParticularUsers()
	{
		int size = userDAO.list("user").size();
		assertEquals(2, size);
	}
}
