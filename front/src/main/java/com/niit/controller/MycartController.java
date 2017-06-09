package com.niit.controller;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.back.dao.MycartDAO;
import com.niit.back.dao.ProductDAO;
import com.niit.back.dao.UserDAO;
import com.niit.back.domain.Mycart;
import com.niit.back.domain.Product;
import com.niit.back.domain.User;
@Controller
public class MycartController {

	@Autowired
	private MycartDAO mycartDAO;
	
	@Autowired
	private Mycart mycart;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private Product product;
	
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping("/MycartPage")
	public String MykartPage(Principal principal, Model model) {
		
		List<Mycart> mycartList = mycartDAO.getByEmail(principal.getName());
		Long GrandTotal = mycartDAO.getTotal(principal.getName());

		model.addAttribute("GrandTotal ", GrandTotal);
		model.addAttribute("mycartList", mycartList);
		model.addAttribute("isUserClickedAddtoCart", true);
		return "userLogin";

	}
	
	@RequestMapping("/ProductDesPage")
	public String productdespage(@RequestParam(value = "productId") String productId, Model model)
	{
		
		Product product = productDAO.get(productId);
		model.addAttribute("isUserClickedDescription", true);
		
		model.addAttribute("product", product);
		return "userLogin"; 
	}
	
	@RequestMapping("/deleteMycart")
	public String deleteMycart(@RequestParam("cartid") int cartid, Model model) {
		
		mycart = mycartDAO.getByCartId(cartid);
		
		int qty = product.getStock() + mycart.getQuantity();
		
		product.setStock(qty);
		productDAO.saveorupdate(product);
		
		mycartDAO.delete(cartid);
		return "redirect:/MycartPage";
	}
	
	@RequestMapping("addtoCart")
	public String addtocart(@RequestParam("productId") String productId, Principal p, Model model) {

		product = productDAO.get(productId);
		String email = p.getName();
		User user = userDAO.getByEmailId(email);

/*		mycart = mycartDAO.getByUserandProduct(email, productId);
*//*System.out.println(mycart.getQuantity());*/
		if (product.getStock() > 0) {

			if (mycartDAO.itemAlreadyExist(p.getName(), productId, true)) {
				
				int qty = mycart.getQuantity() + 1;
				mycart.setQuantity(qty);
				mycart.setTotal(product.getPrice() * qty);
				boolean flag = mycartDAO.Update(mycart);
				System.out.println(flag);
				System.out.println(qty);
			} else {
				Random t = new Random();
				int day = 2 + t.nextInt(7);
				
				mycart.setEmail(email);
				mycart.setPrice(product.getPrice());
				mycart.setProductName(product.getProductName());
				mycart.setProductId(product.getProductId());
				mycart.setQuantity(1);
				mycart.setStatus("N");
				mycart.setUserId(user.getId());
				mycart.setTotal(product.getPrice() * mycart.getQuantity());
				mycart.setDays(day);
				Long currentTime = System.currentTimeMillis();
				Date currentDate = new Date(currentTime);
				mycart.setDate(currentDate);

				boolean flag = mycartDAO.Save(mycart);
				System.out.println(flag);

			}
			int stc = product.getStock() - 1;
			product.setStock(stc);

			productDAO.saveorupdate(product);
			return "redirect:/MycartPage";
		}
		else {
			model.addAttribute("product", product);

			model.addAttribute("isUserClickedDescription", true);
		
			model.addAttribute("message", "Out of stock");
			return "userLogin";
		}
	}
			
	@ModelAttribute
	public void userMycart(Model model) {
		model.addAttribute("isUser", "true");
	}
}


