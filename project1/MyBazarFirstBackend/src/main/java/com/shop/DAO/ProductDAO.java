package com.shop.DAO;

import java.util.List;

import com.shop.model.Product;

public interface ProductDAO 
{
	public boolean addProduct(Product product);
	public boolean deleteProduct(Product product);
	public boolean updateProduct(Product product);
	public Product getProduct(int ProductId);
	public List<Product> listProducts();

}
