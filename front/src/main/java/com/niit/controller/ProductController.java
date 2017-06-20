package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.niit.back.dao.CategoryDAO;
import com.niit.back.dao.ProductDAO;
import com.niit.back.dao.SupplierDAO;
import com.niit.back.domain.Category;
import com.niit.back.domain.Product;
import com.niit.back.domain.Supplier;
import com.niit.util.FileUtil;

@Controller
public class ProductController {

	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private SupplierDAO supplierDAO;
	
	@RequestMapping("newProduct")
	public String newProduct(@ModelAttribute Product product, @RequestParam("image") MultipartFile file, Model model) {
		
		
		
		String path = "C://Users/Shunmugar Rajan G/workspace/front/src/main/webapp/WEB-INF/resources/images/product/";
		
				boolean flag = productDAO.saveorupdate(product);
		 		
				FileUtil.upload(path, file, product.getProductId()+ ".jpg");

		model.addAttribute("isUserClickedProduct", "true");
		System.out.println(flag);
		return "redirect:/ViewProductPage";

	}
	
	@RequestMapping("/ProductPage")
	public String productPage(Model model)
	{
		List<Category> categoryList = categoryDAO.list();
		model.addAttribute("categoryList",categoryList);
		
		List<Supplier> supplierList = supplierDAO.list();
		model.addAttribute("supplierList",supplierList);
		
		model.addAttribute("isUserClickedAdd2", "true");
	
		return "adminLogin";
	}
	
	@RequestMapping("/ViewProductPage")
	public String viewroductPage(Model model)
	{
		List<Product> productList = productDAO.list();
		model.addAttribute("productList", productList);	
		model.addAttribute("isUserClickedView2", "true");
	
		return "adminLogin";
	}
	
	@RequestMapping("/deleteProduct")
		public String deleteProduct(@RequestParam(value="productId")String id) {
	
		productDAO.delete(id);
	
		return "redirect:/ViewProductPage";
	}
	
	@RequestMapping("editProduct")
	public String editProduct(@RequestParam(value = "productId") String id, Model model) {

		List<Category> categoryList = categoryDAO.list();
		model.addAttribute("categoryList",categoryList);
		
		List<Supplier> supplierList = supplierDAO.list();
		model.addAttribute("supplierList",supplierList);
		
		Product product = productDAO.get(id);
		model.addAttribute("product", product);
		model.addAttribute("isUserClickedEdit1", "true");
		return "adminLogin";

	}
	
	@RequestMapping("afterEditProduct")
	public String afterEditProduct(@ModelAttribute Product product, Model model){
		productDAO.save(product);
		
		return "redirect:/ViewProductPage";
		
	}

	
	@ModelAttribute
	public void adminProduct(Model model) {
	 model.addAttribute("isAdmin", "true");
	}
}
