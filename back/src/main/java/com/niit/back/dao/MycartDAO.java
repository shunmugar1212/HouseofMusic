package com.niit.back.dao;

import java.util.List;

import com.niit.back.domain.Mycart;

public interface MycartDAO {

	public Mycart getByCartId(int cartid);
	
	public List<Mycart> list();
	
	public boolean validate(String kartid, String password);
	
	public boolean delete(int cartid);
	
	public boolean Save(Mycart mycart);
	
	public boolean Update(Mycart mycart);
	
	public  List<Mycart> getByEmail(String email);

	public Mycart getByProductId(int productId);
	
	public Long getTotal(String id);

	public boolean itemAlreadyExist(String email, String productId, boolean b);

	public Mycart getByUserandProduct(String email, String productId);
	
	public void updateshipping(String email, int sid);

	public boolean saveOrUpdate(Mycart c);
}
