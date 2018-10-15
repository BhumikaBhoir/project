package com.shop.DAO;

import com.shop.model.Orders;

public interface OrdersDAO 
{
	public boolean receiptGenerate(Orders order);
	public boolean updateCartItemStatus(String username);

}
