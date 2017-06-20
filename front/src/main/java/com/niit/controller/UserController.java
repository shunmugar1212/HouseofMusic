package com.niit.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.back.dao.ProductDAO;
import com.niit.back.dao.RoleDAO;
import com.niit.back.dao.ShippingDAO;
import com.niit.back.dao.UserDAO;
import com.niit.back.domain.Product;
import com.niit.back.domain.Role;
import com.niit.back.domain.Shipping;
import com.niit.back.domain.User;

@Controller
public class UserController {

	@Autowired
	UserDAO userDAO;
	@Autowired
	ProductDAO productDAO;
	@Autowired
	User user;
	@Autowired
	Role role;
	@Autowired
	RoleDAO roleDAO;
	@Autowired
	ShippingDAO shippingDAO;

	@RequestMapping("newUser")
	public String newUser(@ModelAttribute User user,@ModelAttribute Shipping shipping, Model model) {

		user.setEnabled(true);
		role.setName(user.getName());
		role.setEmail(user.getEmail());
		role.setRole("ROLE_USER");

		user.setRole(role);
		role.setUser(user);

		userDAO.save(user);
		roleDAO.save(role);

		shipping.setMail(user.getEmail());
		shippingDAO.saveOrUpdate(shipping);
		/*model.addAttribute("isUserClickedSign Up", "true");*/
		return "Home";

	}

	@RequestMapping("afterlogin")
	public String afterlogin(Principal p, Model model){
	
	//	User user = userDAO.getByEmailId( p.getName());
		Role role = roleDAO.getByEmailId(p.getName());
		String r = role.getRole();
		System.out.println(r);
		if(r.equals("ROLE_USER")){
		model.addAttribute("isUser", "true");
		List<Product> ProductList = productDAO.list();
		model.addAttribute("ProductList",ProductList);
			return "userLogin";
		}
		else if(r.equals("ROLE_ADMIN")) {
			model.addAttribute("isAdmin", "true");
			model.addAttribute("isUser", "false");
			return "adminLogin";
		}
		else{
			return "LoginError";
		}
		
	}
	
	@RequestMapping("/aboutPage")
	public String about(Model model)
	{
		model.addAttribute("isUserClickedAbout", "true");
		
		return "userLogin";
	}
	
	@RequestMapping("/CartPage")
	public String cartpage(Model model)
	{
		model.addAttribute("isUserClickedAddtoCart", "true");
		
		return "userLogin";
	}
	
	@RequestMapping("/Categories3")
	public  String    categories1(Model model)
	
	{
		List<Product> ProductList = productDAO.list();
		model.addAttribute("ProductList",ProductList);
		model.addAttribute("IsUserClickedExplore1", "true");
		return "userLogin";
	}
	
	@RequestMapping("/Categories2")
	public  String    categories(@RequestParam(value = "CategoryName") String categoryName, Model model)
	
	{
		System.out.println(categoryName);
		List<Product> ProductList = productDAO.list(categoryName);
		model.addAttribute("ProductList",ProductList);
		model.addAttribute("IsUserClickedExplore1", "true");
		return "userLogin";
	}

	@ModelAttribute
	public void adminCategory(Model model) {
		model.addAttribute("isUser", "true");
	}
}
