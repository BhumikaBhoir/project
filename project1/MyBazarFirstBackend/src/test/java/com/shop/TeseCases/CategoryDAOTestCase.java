package com.shop.TeseCases;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shop.DAO.CategoryDAO;
import com.shop.model.Category;

public class CategoryDAOTestCase {

	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	
	@Test
	public void addCategoryTest()
	{
		Category category=new Category();
		
		category.setCategoryName("Mobile Phone");
		category.setCategoryDesc("newly launched");
		
		assertTrue("Problem in Adding Category",categoryDAO.addCategory(category));
	}

}
