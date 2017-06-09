package com.niit.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.back.dao.MycartDAO;
import com.niit.back.dao.ShippingDAO;
import com.niit.back.dao.UserDAO;
import com.niit.back.domain.Mycart;
import com.niit.back.domain.Shipping;
import com.niit.back.domain.User;

@Controller
public class ShippingController {

	@Autowired
	private ShippingDAO shippingDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private MycartDAO mycartDAO;
	
	@RequestMapping("newShipping")
	public String addShippingaddress(Principal p, @ModelAttribute Shipping shipping){
		User user = userDAO.getByEmailId(p.getName());
		/*shippingaddress.setUserId(user.getUserId());
		shippingaddress.setEmailId(email);
		*/
		
		shipping.setMail(p.getName());
		shipping.setMail(user.getEmail());
		
		
		
		shippingDAO.saveOrUpdate(shipping);
		return "redirect:Address";
	}
	
	@RequestMapping("/Address")
	public String Proceed(Principal p, Model model){
		String email = 	p.getName();
		List<Shipping> shippingList = shippingDAO.list(email);
		model.addAttribute("shippingList", shippingList);
		model.addAttribute("isUserClickedAddress", true);
	 return "userLogin";
	}
	
	@RequestMapping("/NewAddress")
	public ModelAndView newShippingaddress(){
		
	ModelAndView mv = new ModelAndView("userLogin");
	mv.addObject("isUserClickedNewAddress", "true");
	return mv;
	}
	
	@RequestMapping("deleteShipping")
	public String deleteshippingAddress(@RequestParam("Id") String shippingid, Model model){
		shippingDAO.delete(shippingid);
		return "redirect:Address";
		
	}
	
	@RequestMapping("Payment")
	public String payment(@RequestParam("Id") int shippingId, Principal p, Model model)
	{
		String email = p.getName();
		List<Mycart> mycartList = mycartDAO.getByEmail(email);
		
		for(Mycart c : mycartList){
			c.setShippingId(shippingId);
			c.setStatus("P");
			mycartDAO.saveOrUpdate(c);
		}
		
		model.addAttribute("isUserPayment", "true");
		
		return "userLogin";
	}
	
	@RequestMapping("Thankyou")
	public String thankyou(Model model)
	{
		model.addAttribute("isUserClickedThankyou", "true");
		
		return "userLogin";
	}
	
	@ModelAttribute
	public void userMycart(Model model) {
		model.addAttribute("isUser", "true");
	}
}
