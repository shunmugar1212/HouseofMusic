package com.niit.back.dao;

import java.util.List;

import com.niit.back.domain.Product;

public interface ProductDAO {

	public boolean save(Product product);

	public boolean update(Product product);

	public Product get(String productId);

	public void delete(String id);

	public void editProduct(Product product);

	public List<Product> search(String keyWord);

	public List<Product> list();

	public boolean saveorupdate(Product product);

	public List<Product> getAllProductsByCategoryID(String categoryID) ;

	public List<Product> getSimilarProducts(String search_string) ;


}
