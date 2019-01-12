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
import com.team1.service.MenuService;


/**
 * Project name: Team1-SpringBoot-JPA
 * Package name: com.team1.controller
 * File name: ABCZ.java
 * Author: ...
 * Created date: Jan 11, 2019
 * Created time: 8:49:43 AM
 */

@Controller
@RequestMapping
public class MenuRoleController {
	
	
	
	@Autowired
	MenuRoleService menuRoleService;
	
	@Autowired
	MenuService menuService;
	
	
	//......getAll
	@GetMapping("/list-menuRole")
	public String getAll(ModelMap modelMap) {
		List<MenuRole> list = menuRoleService.getAll();
		modelMap.addAttribute("list", list);
		return "listMenuRole";
	}
	
	//......getOne
	@GetMapping("/detail-menuRole/{id}")
	public String getOne(@PathVariable String id, ModelMap modelMap) {
		MenuRole menuRole = menuRoleService.getOne(Integer.parseInt(id));
		modelMap.addAttribute("menuRole", menuRole);
		return "detailMenuRole";
	}
	
	//......add
	@GetMapping("/add-menuRole")
	public String menuRoleinsert(ModelMap modelMap) {
		MenuRole menuRole = new MenuRole();
		modelMap.addAttribute("menuRole", menuRole);
		return "addMenuRole";
	}
	
	@PostMapping("/add-menuRole")
	public String insertMenuRole(@ModelAttribute MenuRole menuRole, ModelMap modelMap) {
		if(menuRole.getMenu() == null || menuRole.getRole() == null) {
			String mess = "no matching foreignKey";
			modelMap.addAttribute("mess", mess);
			return "addMenuRole";
			
		}else {
			menuRoleService.insert(menuRole);
		}
		return "redirect:/list-menuRole";
	}
	
	//.....update
	@GetMapping("/update-menuRole/{id}")
	public String menuRoleUpdate(@PathVariable String id, ModelMap modelMap) {
		MenuRole menuRole = menuRoleService.getOne(Integer.parseInt(id));
		modelMap.addAttribute("menuRole", menuRole);
		return "updateMenuRole";
	}
	
	@PostMapping("/update-menuRole")
	public String updateMenuRole(@ModelAttribute MenuRole menuRole, ModelMap modelMap) {
		if(menuRole.getMenu() == null || menuRole.getRole() == null) {
			String mess = "no matching foreignKey";
			modelMap.addAttribute("mess", mess);
			return "updateMenuRole";
			
		}else {
			menuRoleService.update(menuRole);
		}
		return "redirect:/list-menuRole";
	}
	
	//.....delete
	@GetMapping("/delete-menuRole/{id}")
	public String insertMenuRole(@PathVariable String id) {
		menuRoleService.delete(Integer.parseInt(id));
		return "redirect:/list-menuRole";
	}
	
}
