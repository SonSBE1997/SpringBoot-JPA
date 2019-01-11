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

import com.team1.entity.Menu;
import com.team1.service.MenuService;

@Controller
@RequestMapping
public class MenuController {
	
	@Autowired
	MenuService menuService;
	
	@GetMapping("/list-menu")
	public String getAll(ModelMap modelMap) {
		List<Menu> listMenu = menuService.getAll();
		modelMap.addAttribute("listMenu", listMenu);
		return "listMenu";
	}
	
	@GetMapping("/detail-menu/{id}")
	public String getOne(@PathVariable String id ,ModelMap modelMap) {
		Menu menu = menuService.getOne(Integer.parseInt(id));
		modelMap.addAttribute("menu", menu);
		return "detailMenu";
	}
	
	@GetMapping("/add-menu")
	public String menuAdd(ModelMap modelMap) {
		Menu menu = new Menu();
		modelMap.addAttribute("menu", menu);
		return "addMenu";
	}
	
	@PostMapping("/add-menu")
	public String addMenu(@ModelAttribute Menu menu) {
		menuService.insert(menu);
		return "redirect:/list-menu";
	}
	
	@GetMapping("/update-menu/{menu_id}")
	public String menuUpdate(@PathVariable String menu_id, ModelMap modelMap) {
		Menu menu = menuService.getOne(Integer.parseInt(menu_id));
		modelMap.addAttribute("menu", menu);
		return "updateMenu";
	}
	
	@PostMapping("/update-menu")
	public String updateMenu(@ModelAttribute Menu menu) {
		menuService.update(menu);
		return "redirect:/list-menu";
	}
	
	@GetMapping("/delete-menu/{id}")
	public String deleteMenu(@PathVariable String id) {
		menuService.delete(Integer.parseInt(id));
		return "redirect:/list-menu";
	}
	
}
