package com.niit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.back.dao.ProductDAO;
import com.niit.back.domain.Product;

@Controller
public class HomeController {
	@Autowired ProductDAO productDAO;
	@Autowired
	HttpSession session;
	@RequestMapping("/")
	public  String    goToHome(Model model)
	
	{
		List<Product> ProductList = productDAO.list();
		model.addAttribute("ProductList",ProductList);
		model.addAttribute("message", "Thank you for visiting Shopping Cart");
		return "Home";
	}

	@RequestMapping("/LoginError")
	public  String    goToHomePage(Model model)
	
	{
		List<Product> ProductList = productDAO.list();
		model.addAttribute("ProductList",ProductList);
		model.addAttribute("IsUserLoginFail", "true");
		model.addAttribute("message", "INVALID EMAIL ID OR PASSWORD");
		return "Home";
	}
	
	@RequestMapping("/Categories1")
	public  String    categories1(Model model)
	
	{
		List<Product> ProductList = productDAO.list();
		model.addAttribute("ProductList",ProductList);
		model.addAttribute("IsUserClickedExplore", "true");
		return "Home";
	}
	
	@RequestMapping("/Categories")
	public  String    categories(@RequestParam(value = "CategoryName") String categoryName, Model model)
	
	{
		System.out.println(categoryName);
		List<Product> ProductList = productDAO.list(categoryName);
		model.addAttribute("ProductList",ProductList);
		model.addAttribute("IsUserClickedExplore", "true");
		return "Home";
	}
}
