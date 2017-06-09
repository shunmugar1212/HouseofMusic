package com.niit.back.dao;

import java.util.List;

import com.niit.back.domain.Supplier;

public interface SupplierDAO {

	public  boolean save(Supplier supplier);
	public boolean update(Supplier supplier);
	

	public Supplier get(String id);
	
	public void delete(String id);
	
	public void editSupplier(Supplier supplier);
	
	public List<Supplier> search(String keyWord);
    
	public List<Supplier>     list();
}
