package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.back.dao.BillingDAO;
import com.niit.back.domain.Billing;

@Controller
public class BillingController {

	@Autowired
	private BillingDAO billingDAO;
	
	@RequestMapping("newBilling")
	public String newBilling(@ModelAttribute Billing billing, Model model){
		billingDAO.save(billing);
		return "Billing";
	}
}
