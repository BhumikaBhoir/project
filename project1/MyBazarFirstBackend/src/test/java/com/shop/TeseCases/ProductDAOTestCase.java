package com.shop.TeseCases;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shop.DAO.ProductDAO;
import com.shop.model.Product;

public class ProductDAOTestCase 
{
	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		
		productDAO = (ProductDAO) context.getBean("productDAO");
	}

	
	@Test
	public void addProductTest()
	{
		Product product=new Product();
		
		product.setProdName("Samsung J7");
		product.setProdDesc("4g phone with new features");
		product.setPrice(2200);
		product.setStock(12);
		product.setCategoryId(1);
		
		assertTrue("Problem in Adding Product",productDAO.addProduct(product));
	}

	
}
