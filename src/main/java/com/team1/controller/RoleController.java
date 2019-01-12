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
import com.team1.utils.Constant;

@Controller
@RequestMapping
public class RoleController {
	
	@Autowired
	RoleService roleService;
	
	//....getAll
	@GetMapping("/" + Constant.Role_URL.URL_LIST_ROLE)
	public String getAll(ModelMap modelMap) {
		
		List<Role> listRole = roleService.getAll();
		modelMap.addAttribute("listRole", listRole);
		return "listRole";
	}
	
	@GetMapping("/" + Constant.Role_URL.URL_DETAIL_ROLE + "/{id}")
	public String getOne(@PathVariable String id, ModelMap modelMap) {
		Role role = roleService.getOne(Integer.parseInt(id));
		modelMap.addAttribute("role", role);
		return "detailRole";
	}
	
	//.....insert
	@GetMapping("/" + Constant.Role_URL.URL_ADD_ROLE)
	public String roleInsert(ModelMap modelMap) {
		Role role = new Role();
		modelMap.addAttribute("role", role);
		return "addRole";
	}
	
	@PostMapping("/" + Constant.Role_URL.URL_ADD_ROLE)
	public String insertRole(@ModelAttribute Role role) {
		roleService.insert(role);
		return "redirect:/"+Constant.Role_URL.URL_LIST_ROLE;
	}
	
	//.....delete
	@GetMapping("/" + Constant.Role_URL.URL_DELETE_ROLE +"/{id}")
	public String delete(@PathVariable String id) {
		roleService.delete(Integer.parseInt(id));
		return "redirect:/"+Constant.Role_URL.URL_LIST_ROLE;
	}
	
	//.....update
	@GetMapping("/" + Constant.Role_URL.URL_UPDATE_ROLE + "/{id}")
	public String roleUpdate(ModelMap modelMap, @PathVariable String id) {
		Role role = roleService.getOne(Integer.parseInt(id));
		modelMap.addAttribute("role", role);
		return "updateRole";
	}
	
	@PostMapping("/" + Constant.Role_URL.URL_UPDATE_ROLE)
	public String updateRole(@ModelAttribute Role role) {
		roleService.update(role);
		return "redirect:/"+Constant.Role_URL.URL_LIST_ROLE;
	}
}
