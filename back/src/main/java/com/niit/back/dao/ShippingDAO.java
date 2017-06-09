package com.niit.back.dao;

import java.util.List;

import com.niit.back.domain.Shipping;

public interface ShippingDAO {

	public  boolean save(Shipping shipping);
	public boolean update(Shipping shipping);
    
	public List<Shipping> list(String mail);
	
	public Shipping getByShippingAddress(String address);


	public Shipping getByUserName(String username);

	public void saveOrUpdate(Shipping address);

	public void delete(String sid);
	
	public Shipping getBySid(int sid);
	
}
