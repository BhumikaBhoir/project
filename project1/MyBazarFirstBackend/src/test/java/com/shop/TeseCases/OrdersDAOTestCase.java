package com.shop.TeseCases;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shop.DAO.OrdersDAO;
import com.shop.model.Orders;

public class OrdersDAOTestCase {

	private static AnnotationConfigApplicationContext context;
	private static OrdersDAO orderDAO;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		
		orderDAO = (OrdersDAO) context.getBean("orderDAO");
	}
	
	@Ignore
	@Test
	public void receipts()
	{
		Orders order = new Orders();
		order.setUsername("adnan");
		order.setPurchaseValue(2200);
		order.setPaymentMode("Cash");
		order.setOrderDate(new java.util.Date());
		
		boolean result = orderDAO.receiptGenerate(order);
		assertEquals("New Order", true, result);
		
	}

}
