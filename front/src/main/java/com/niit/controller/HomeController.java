package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.back.dao.ProductDAO;
import com.niit.back.domain.Product;

@Controller
public class HomeController {
	@Autowired ProductDAO productDAO;	
	@RequestMapping("/")
	public  String    goToHome(Model model)
	
	{
		List<Product> ProductList = productDAO.list();
		model.addAttribute("ProductList",ProductList);
		model.addAttribute("message", "Thank you for visiting Shopping Cart");
		return "Home";
	}

	
}
