package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.back.dao.RoleDAO;
import com.niit.back.domain.Role;

@Controller
public class RoleController {

	@Autowired
	private RoleDAO roleDAO;
	
	@RequestMapping("newRole")
	public String newRole(@ModelAttribute Role role, Model model){
		roleDAO.save(role);
		return "Role";
	}
}
