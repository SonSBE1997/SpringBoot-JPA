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
import com.team1.utils.Constant;

@Controller
@RequestMapping
public class MenuController {
	
	@Autowired
	MenuService menuService;
	
	@GetMapping("/"+Constant.Menu_URL.URL_LIST_MENU)
	public String getAll(ModelMap modelMap) {
		List<Menu> listMenu = menuService.getAll();
		modelMap.addAttribute("listMenu", listMenu);
		return "listMenu";
	}
	
	@GetMapping("/" + Constant.Menu_URL.URL_DETAIL_MENU + "/{id}")
	public String getOne(@PathVariable String id ,ModelMap modelMap) {
		Menu menu = menuService.getOne(Integer.parseInt(id));
		modelMap.addAttribute("menu", menu);
		return "detailMenu";
	}
	
	@GetMapping("/" + Constant.Menu_URL.URL_ADD_MENU)
	public String menuAdd(ModelMap modelMap) {
		Menu menu = new Menu();
		modelMap.addAttribute("menu", menu);
		return "addMenu";
	}
	
	@PostMapping("/" + Constant.Menu_URL.URL_ADD_MENU)
	public String addMenu(@ModelAttribute Menu menu) {
		menuService.insert(menu);
		return "redirect:/" + Constant.Menu_URL.URL_LIST_MENU;
	}
	
	@GetMapping("/" + Constant.Menu_URL.URL_UPDATE_MENU  + "/{menu_id}")
	public String menuUpdate(@PathVariable String menu_id, ModelMap modelMap) {
		Menu menu = menuService.getOne(Integer.parseInt(menu_id));
		modelMap.addAttribute("menu", menu);
		return "updateMenu";
	}
	
	@PostMapping("/" + Constant.Menu_URL.URL_UPDATE_MENU)
	public String updateMenu(@ModelAttribute Menu menu) {
		menuService.update(menu);
		return "redirect:/" + Constant.Menu_URL.URL_LIST_MENU;
	}
	
	@GetMapping("/" + Constant.Menu_URL.URL_DELETE_MENU + "/{id}")
	public String deleteMenu(@PathVariable String id) {
		menuService.delete(Integer.parseInt(id));
		return "redirect:/" + Constant.Menu_URL.URL_LIST_MENU;
	}
	
}
