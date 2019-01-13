/*package com.team1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.team1.entity.Menu;
import com.team1.service.MenuService;

@Controller
public class MenuController {
	@Autowired
	MenuService menuService;

	@GetMapping(value = "/list-menu")
	public String listMenu(ModelMap map) {
		List<Menu> menus = menuService.fillAll();
		map.addAttribute("list", menus);
		return "menu/listMenu";
	}
}
*/