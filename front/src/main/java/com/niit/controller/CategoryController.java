package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.back.dao.CategoryDAO;
import com.niit.back.domain.Category;

@Controller
public class CategoryController {

	@Autowired
	private CategoryDAO categoryDAO;

	@RequestMapping("newCategory")
	public String newCategory(@ModelAttribute Category category, Model model) {
		categoryDAO.save(category);
		return "redirect:/ViewCategoryPage";
	}

	@RequestMapping("/CategoryPage")
	public String categoryPage(Model model) {
		model.addAttribute("isUserClickedAdd1", "true");

		return "adminLogin";
	}

	@RequestMapping("/deleteCategory")
	public String deleteCategory(@RequestParam(value = "categoryId") String id) {

		categoryDAO.delete(id);

		return "redirect:/ViewCategoryPage";
	}

	@RequestMapping("/ViewCategoryPage")
	public String viewcategoryPage(Model model) {

		List<Category> categoryList = categoryDAO.list();
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("isUserClickedView1", "true");

		return "adminLogin";
	}

	@RequestMapping("editCategory")
	public String editCategory(@RequestParam(value = "categoryId") String id, Model model) {

		Category category = categoryDAO.get(id);
		model.addAttribute("category", category);
		model.addAttribute("isUserClickedEdit", "true");
		return "adminLogin";

	}
	@RequestMapping("afterEditCategory")
	public String afterEditCategory(@ModelAttribute Category category, Model model){
		categoryDAO.save(category);
		
		return "redirect:/ViewCategoryPage";
		
	}

	@ModelAttribute
	public void adminCategory(Model model) {
		model.addAttribute("isAdmin", "true");
	}
}
