package com.niit.back.dao;

import java.util.List;

import com.niit.back.domain.Billing;

public interface BillingDAO {

	public  boolean save(Billing billing);
	public boolean update(Billing billing);
    
	public List<Billing>     list();
}
