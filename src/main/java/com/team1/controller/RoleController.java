package com.team1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team1.entity.Role;
import com.team1.service.RoleService;

@Controller
@RequestMapping
public class RoleController {
	
	@Autowired
	RoleService roleService;
	
	//....getAll
	@GetMapping("/list-role")
	public String getAll(ModelMap modelMap) {
		
		List<Role> listRole = roleService.getAll();
		modelMap.addAttribute("listRole", listRole);
		return "listRole";
	}
	
	//.....insert
	@GetMapping("/add-role")
	public String roleInsert(ModelMap modelMap) {
		Role role = new Role();
		modelMap.addAttribute("role", role);
		return "addRole";
	}
	
	@PostMapping("/add-role")
	public String insertRole(@ModelAttribute Role role) {
		roleService.insert(role);
		return "redirect:/list-role";
	}
	
	//.....delete
	@GetMapping("/delete-role/{id}")
	public String delete(@PathVariable String id) {
		roleService.delete(Integer.parseInt(id));
		return "redirect:/list-role";
	}
	
	//.....update
	@GetMapping("/update-role/{id}")
	public String roleUpdate(ModelMap modelMap, @PathVariable String id) {
		Role role = roleService.getOne(Integer.parseInt(id));
		modelMap.addAttribute("role", role);
		return "updateRole";
	}
	
	@PostMapping("/update-role")
	public String updateRole(@ModelAttribute Role role) {
		roleService.update(role);
		return "redirect:/list-role";
	}
}
