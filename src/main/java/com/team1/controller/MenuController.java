package com.team1.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.team1.entity.Menu;
import com.team1.service.MenuService;
import com.team1.utils.Constant;

/**
 * Project name: Team1-SpringBoot-JPA
 * Package name: com.team1.controller
 * File name: ABCZ.java
 * Author: ...Hai95
 * Created date: Jan 11, 2019
 * Created time: 8:49:43 AM
 */
@Controller
@RequestMapping
public class MenuController implements WebMvcConfigurer{
	
	@Autowired
	MenuService menuService;
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// TODO Auto-generated method stub
		// WebMvcConfigurer.super.addViewControllers(registry);
		registry.addViewController("/results").setViewName("results");
	}
	
	/**
	 * Create by: Hai - CMC
	 * Create date: Jan 12, 2019
	 * Modifier: Hai
	 * Modified date: 2019
	 * Description: ....
	 * Version 1.0
	 */
	@GetMapping("/"+Constant.Menu_URL.URL_LIST_MENU)
	public String getAll(ModelMap modelMap) {
		List<Menu> listMenu = menuService.getAll();
		modelMap.addAttribute("listMenu", listMenu);
		return "listMenu";
	}
	
	/**
	 * Create by: Hai - CMC
	 * Create date: Jan 12, 2019
	 * Modifier: Hai
	 * Modified date: 2019
	 * Description: ....
	 * Version 1.0
	 */
	@GetMapping("/" + Constant.Menu_URL.URL_DETAIL_MENU + "/{id}")
	public String getOne(@PathVariable String id ,ModelMap modelMap) {
		Menu menu = menuService.getOne(Integer.parseInt(id));
		modelMap.addAttribute("menu", menu);
		return "detailMenu";
	}
	
	/**
	 * Create by: Hai - CMC
	 * Create date: Jan 12, 2019
	 * Modifier: Hai
	 * Modified date: 2019
	 * Description: ....
	 * Version 1.0
	 */
	@GetMapping("/" + Constant.Menu_URL.URL_ADD_MENU)
	public String menuAdd(ModelMap modelMap) {
		Menu menu = new Menu();
		modelMap.addAttribute("menu", menu);
		return "addMenu";
	}
	
	/**
	 * Create by: Hai - CMC
	 * Create date: Jan 12, 2019
	 * Modifier: Hai
	 * Modified date: 2019
	 * Description: ....
	 * Version 1.0
	 */
	@PostMapping("/" + Constant.Menu_URL.URL_ADD_MENU)
	public String addMenu(@ModelAttribute Menu menu, @Valid Menu menuVal, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "addMenu";
		}
		menuService.insert(menu);
		return "redirect:/" + Constant.Menu_URL.URL_LIST_MENU;
	}
	
	/**
	 * Create by: Hai - CMC
	 * Create date: Jan 12, 2019
	 * Modifier: Hai
	 * Modified date: 2019
	 * Description: ....
	 * Version 1.0
	 */
	@GetMapping("/" + Constant.Menu_URL.URL_UPDATE_MENU  + "/{menu_id}")
	public String menuUpdate(@PathVariable String menu_id, ModelMap modelMap) {
		Menu menu = menuService.getOne(Integer.parseInt(menu_id));
		modelMap.addAttribute("menu", menu);
		return "updateMenu";
	}
	
	/**
	 * Create by: Hai - CMC
	 * Create date: Jan 12, 2019
	 * Modifier: Hai
	 * Modified date: 2019
	 * Description: ....
	 * Version 1.0
	 */
	@PostMapping("/" + Constant.Menu_URL.URL_UPDATE_MENU)
	public String updateMenu(@ModelAttribute Menu menu) {
		menuService.update(menu);
		return "redirect:/" + Constant.Menu_URL.URL_LIST_MENU;
	}
	
	/**
	 * Create by: Hai - CMC
	 * Create date: Jan 12, 2019
	 * Modifier: Hai
	 * Modified date: 2019
	 * Description: ....
	 * Version 1.0
	 */
	@GetMapping("/" + Constant.Menu_URL.URL_DELETE_MENU + "/{id}")
	public String deleteMenu(@PathVariable String id) {
		menuService.delete(Integer.parseInt(id));
		return "redirect:/" + Constant.Menu_URL.URL_LIST_MENU;
	}
	
}
