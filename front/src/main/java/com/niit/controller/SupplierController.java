package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.back.dao.SupplierDAO;
import com.niit.back.domain.Supplier;

@Controller
public class SupplierController {

	@Autowired
	private SupplierDAO supplierDAO;
	
	@RequestMapping("newSupplier")
	public String newSupplier(@ModelAttribute Supplier supplier, Model model){
		supplierDAO.save(supplier);
		return "redirect:/ViewSupplierPage";
	}
	
	@RequestMapping("/SupplierPage")
	public String supplierPage(Model model)
	{
		model.addAttribute("isUserClickedAdd3", "true");
	
		return "adminLogin";
	}
	
	@RequestMapping("/ViewSupplierPage")
	public String viewsupplierPage(Model model)
	{
		List<Supplier> supplierList = supplierDAO.list();
		model.addAttribute("supplierList", supplierList);	
		model.addAttribute("isUserClickedView3", "true");
	
		return "adminLogin";
	}
	
	@RequestMapping("/deleteSupplier")
	public String deleteSupplier(@RequestParam(value="supplierId")String id) {
	
		supplierDAO.delete(id);
	
		return "redirect:/ViewSupplierPage";
	}
	
	@RequestMapping("editSupplier")
	public String editSupplier(@RequestParam(value = "supplierId") String id, Model model) {

		Supplier supplier = supplierDAO.get(id);
		model.addAttribute("supplier", supplier);
		model.addAttribute("isUserClickedEdit2", "true");
		return "adminLogin";

	}
	@RequestMapping("afterEditSupplier")
	public String afterEditSupplier(@ModelAttribute Supplier supplier, Model model){
		supplierDAO.save(supplier);
		
		return "redirect:/ViewSupplierPage";
		
	}
	
	@ModelAttribute
	public void adminSupplier(Model model) {
	 model.addAttribute("isAdmin", "true");
	}
}
