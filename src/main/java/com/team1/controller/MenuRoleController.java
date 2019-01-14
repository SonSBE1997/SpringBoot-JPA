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

import org.slf4j.Logger;

import com.team1.entity.Menu;
import com.team1.entity.MenuRole;
import com.team1.service.MenuRoleService;
import com.team1.service.MenuService;

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
public class MenuRoleController {
	
	private static final Logger log = org.slf4j.LoggerFactory.getLogger(MenuRoleController.class);
	
	@Autowired
	MenuRoleService menuRoleService;
	
	@Autowired
	MenuService menuService;
	
	
	/**
	 * Create by: Hai - CMC
	 * Create date: Jan 12, 2019
	 * Modifier: Hai
	 * Modified date: 2019
	 * Description: ....
	 * Version 1.0
	 */
	@GetMapping("/list-menuRole")
	public String getAll(ModelMap modelMap) {
		List<MenuRole> list = menuRoleService.getAll();
		modelMap.addAttribute("list", list);
		return "listMenuRole";
	}
	
	/**
	 * Create by: Hai - CMC
	 * Create date: Jan 12, 2019
	 * Modifier: Hai
	 * Modified date: 2019
	 * Description: ....
	 * Version 1.0
	 */
	@GetMapping("/detail-menuRole/{menu}")
	public String getOne(@PathVariable Menu menu, ModelMap modelMap) {
		MenuRole menuRole = menuRoleService.getOne(menu);
		modelMap.addAttribute("menuRole", menuRole);
		return "detailMenuRole";
	}
	
	/**
	 * Create by: Hai - CMC
	 * Create date: Jan 12, 2019
	 * Modifier: Hai
	 * Modified date: 2019
	 * Description: ....
	 * Version 1.0
	 */
	@GetMapping("/add-menuRole")
	public String menuRoleinsert(ModelMap modelMap) {
		MenuRole menuRole = new MenuRole();
		modelMap.addAttribute("menuRole", menuRole);
		return "addMenuRole";
	}
	
	/**
	 * Create by: Hai - CMC
	 * Create date: Jan 12, 2019
	 * Modifier: Hai
	 * Modified date: 2019
	 * Description: ....
	 * Version 1.0
	 */
	@PostMapping("/add-menuRole")
	public String insertMenuRole(@ModelAttribute MenuRole menuRole, ModelMap modelMap) {
		try {
			if(menuRole.getMenu() == null || menuRole.getRole() == null) {
				String mess = "no matching foreignKey";
				modelMap.addAttribute("mess", mess);
				log.error(mess);
				return "addMenuRole";	
			}
			menuRoleService.insert(menuRole);
		} catch (Exception e) {
			String s = String.valueOf(e);
			log.info(s);
			modelMap.addAttribute("mess", "there're some error");
			return "addMenuRole";
		}
		return "redirect:/list-menuRole";
	}
	
	/**
	 * Create by: Hai - CMC
	 * Create date: Jan 12, 2019
	 * Modifier: Hai
	 * Modified date: 2019
	 * Description: ....
	 * Version 1.0
	 */
	@GetMapping("/update-menuRole/{menu}")
	public String menuRoleUpdate(@PathVariable Menu menu, ModelMap modelMap) {
		MenuRole menuRole = menuRoleService.getOne(menu);
		modelMap.addAttribute("menuRole", menuRole);
		return "updateMenuRole";
	}
	
	/**
	 * Create by: Hai - CMC
	 * Create date: Jan 12, 2019
	 * Modifier: Hai
	 * Modified date: 2019
	 * Description: ....
	 * Version 1.0
	 */
	@PostMapping("/update-menuRole")
	public String updateMenuRole(@ModelAttribute MenuRole menuRole, ModelMap modelMap) {
		try {
			if(menuRole.getMenu() == null || menuRole.getRole() == null) {
				String mess = "no matching foreignKey";
				modelMap.addAttribute("mess", mess);
				log.error(mess);
				return "updateMenuRole";
			}
			menuRoleService.update(menuRole);
		} catch (Exception e) {
			String s = String.valueOf(e);
			log.info(s);
			modelMap.addAttribute("mess", "there're some error");
			return "updateMenuRole";
		}
		return "redirect:/list-menuRole";
	}
	
	/**
	 * Create by: Hai - CMC
	 * Create date: Jan 12, 2019
	 * Modifier: Hai
	 * Modified date: 2019
	 * Description: ....
	 * Version 1.0
	 */
	@GetMapping("/delete-menuRole/{menuId}")
	public String insertMenuRole(@PathVariable String menuId) {
		menuRoleService.delete(Integer.parseInt(menuId));
		return "redirect:/list-menuRole";
	}
	
}
