package com.team1.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team1.entity.Menu;
import com.team1.entity.MenuRole;
import com.team1.entity.Role;
import com.team1.service.MenuRoleService;
import com.team1.service.MenuService;
import com.team1.service.RoleService;

/**
 * Project name: Team1-SpringBoot-JPA Package name: com.team1.controller File
 * name: ABCZ.java Author: ...Hai95 Created date: Jan 11, 2019 Created time:
 * 8:49:43 AM
 */
@Controller
@RequestMapping("/admin/menuRole")
public class MenuRoleController {

	private static final Logger log = org.slf4j.LoggerFactory.getLogger(MenuRoleController.class);

	@Autowired
	MenuRoleService menuRoleService;

	@Autowired
	MenuService menuService;

	@Autowired
	RoleService roleService;

	/**
	 * Create by: Hai - CMC Create date: Jan 12, 2019 Modifier: Hai Modified date:
	 * 2019 Description: .... Version 1.0
	 */
	@GetMapping("/list-menuRole")
	public String getAll(ModelMap modelMap) {
		List<MenuRole> list = menuRoleService.getAll();
		modelMap.addAttribute("list", list);
		return "listMenuRole";
	}

	/**
	 * Create by: Hai - CMC Create date: Jan 12, 2019 Modifier: Hai Modified date:
	 * 2019 Description: .... Version 1.0
	 */
	@PostMapping("/list-menuRole")
	public String filterByStatus(@RequestParam String status, ModelMap modelMap) {
		List<MenuRole> list = menuRoleService.filterStatus(status);
		modelMap.addAttribute("list", list);
		return "listMenuRole";
	}

	/**
	 * Create by: Hai - CMC Create date: Jan 12, 2019 Modifier: Hai Modified date:
	 * 2019 Description: .... Version 1.0
	 */
	@GetMapping("/add-menuRole")
	public String menuRoleinsert(ModelMap modelMap) {
		MenuRole menuRole = new MenuRole();
		modelMap.addAttribute("menuRole", menuRole);
		List<Role> roles = roleService.getAll();
		modelMap.addAttribute("roles", roles);
		modelMap.addAttribute("menus", menuService.getListAllMenu());
		return "addMenuRole";
	}

	/**
	 * Create by: Hai - CMC Create date: Jan 12, 2019 Modifier: Hai Modified date:
	 * 2019 Description: .... Version 1.0
	 */
	@PostMapping("/add-menuRole")
	public String insertMenuRole(@ModelAttribute MenuRole menuRole, @RequestParam int menuId, @RequestParam int roleId,
			ModelMap modelMap, RedirectAttributes attributes) {
		try {
			Role role = roleService.getOne(roleId);
			Menu menu = menuService.findMenuByID(menuId);
			menuRole.setRole(role);
			menuRole.setMenu(menu);
			if (menuRole.getMenu() == null || menuRole.getRole() == null) {
				String mess = "no matching foreignKey";
				modelMap.addAttribute("mess", mess);
				log.error(mess);
				return "addMenuRole";
			}
			menuRoleService.insert(menuRole);
		} catch (Exception e) {
			String mess = "trùng lặp cặp key rồi!";
			attributes.addFlashAttribute("mess", mess);
			String e1 = String.valueOf(e);
			log.error(e1);
			return "redirect:/admin/menuRole/add-menuRole";
		}
		return "redirect:/admin/menuRole/list-menuRole";
	}

//	/**
//	 * Create by: Hai - CMC
//	 * Create date: Jan 12, 2019
//	 * Modifier: Hai
//	 * Modified date: 2019
//	 * Description: ....
//	 * Version 1.0
//	 */
//	@GetMapping("/detail-menuRole/{menu}")
//	public String getOne(@PathVariable Menu menu, ModelMap modelMap) {
//		MenuRole menuRole = menuRoleService.getOne(menu);
//		modelMap.addAttribute("menuRole", menuRole);
//		return "detailMenuRole";
//	}

//	
//	/**
//	 * Create by: Hai - CMC
//	 * Create date: Jan 12, 2019
//	 * Modifier: Hai
//	 * Modified date: 2019
//	 * Description: ....
//	 * Version 1.0
//	 */
//	@GetMapping("/update-menuRole/{menu}")
//	public String menuRoleUpdate(@PathVariable Menu menu, ModelMap modelMap) {
//		MenuRole menuRole = menuRoleService.getOne(menu);
//		modelMap.addAttribute("menuRole", menuRole);
//		return "updateMenuRole";
//	}
//	
//	/**
//	 * Create by: Hai - CMC
//	 * Create date: Jan 12, 2019
//	 * Modifier: Hai
//	 * Modified date: 2019
//	 * Description: ....
//	 * Version 1.0
//	 */
//	@PostMapping("/update-menuRole")
//	public String updateMenuRole(@ModelAttribute MenuRole menuRole, ModelMap modelMap) {
//		try {
//			if(menuRole.getMenu() == null || menuRole.getRole() == null) {
//				String mess = "no matching foreignKey";
//				modelMap.addAttribute("mess", mess);
//				log.error(mess);
//				return "updateMenuRole";
//			}
//			menuRoleService.update(menuRole);
//		} catch (Exception e) {
//			String s = String.valueOf(e);
//			log.info(s);
//			modelMap.addAttribute("mess", "there're some error");
//			return "updateMenuRole";
//		}
//		return "redirect:/list-menuRole";
//	}
//	
//	/**
//	 * Create by: Hai - CMC
//	 * Create date: Jan 12, 2019
//	 * Modifier: Hai
//	 * Modified date: 2019
//	 * Description: ....
//	 * Version 1.0
//	 */
//	@GetMapping("/delete-menuRole/{menuId}")
//	public String insertMenuRole(@PathVariable String menuId) {
//		menuRoleService.delete(Integer.parseInt(menuId));
//		return "redirect:/list-menuRole";
//	}

}
