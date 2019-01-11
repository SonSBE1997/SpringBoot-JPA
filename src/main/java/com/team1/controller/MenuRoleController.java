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

import com.team1.entity.MenuRole;
import com.team1.service.MenuRoleService;

@Controller
@RequestMapping
public class MenuRoleController {
	
	@Autowired
	MenuRoleService menuRoleService;
	
	@GetMapping("/list-menuRole")
	public String getAll(ModelMap modelMap) {
		List<MenuRole> list = menuRoleService.getAll();
		modelMap.addAttribute("list", list);
		return "listMenuRole";
	}
	
	@GetMapping("/detail-menuRole/{id}")
	public String getOne(@PathVariable String id, ModelMap modelMap) {
		MenuRole menuRole = menuRoleService.getOne(Integer.parseInt(id));
		modelMap.addAttribute("menuRole", menuRole);
		return "detailMenuRole";
	}
	
	@GetMapping("/add-menuRole")
	public String menuRoleinsert(ModelMap modelMap) {
		MenuRole menuRole = new MenuRole();
		modelMap.addAttribute("menuRole", menuRole);
		return "addMenuRole";
	}
	
	@PostMapping("/add-menuRole")
	public String insertMenuRole(@ModelAttribute MenuRole menuRole) {
		menuRoleService.insert(menuRole);
		return "redirect:/list-menuRole";
	}
	
	@GetMapping("/update-menuRole/{id}")
	public String menuRoleUpdate(@PathVariable String id, ModelMap modelMap) {
		MenuRole menuRole = menuRoleService.getOne(Integer.parseInt(id));
		modelMap.addAttribute("menuRole", menuRole);
		return "updateMenuRole";
	}
	
	@PostMapping("/update-menuRole")
	public String updateMenuRole(@ModelAttribute MenuRole menuRole) {
		menuRoleService.update(menuRole);
		return "redirect:/list-menuRole";
	}
	
	@GetMapping("/delete-menuRole/{id}")
	public String insertMenuRole(@PathVariable String id) {
		menuRoleService.delete(Integer.parseInt(id));
		return "redirect:/list-menuRole";
	}
	
}
