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
import org.springframework.web.bind.annotation.RequestParam;

import com.team1.entity.Role;
import com.team1.service.RoleService;
import com.team1.utils.Validation;

/**
 * Project name: Team1-SpringBoot-JPA
 * Package name: com.team1.controller
 * File name: ABCZ.java
 * Author: ...Hai95 + Dong97
 * Created date: Jan 11, 2019
 * Created time: 8:49:43 AM
 */
@Controller
@RequestMapping("/admin/Role")
public class RoleController {
	
	@Autowired
	RoleService roleService;
	
	Validation val = new Validation();
	
	/**
	 * Create by: Hai - CMC
	 * Create date: Jan 12, 2019
	 * Modifier: Hai95 + Dong97
	 * Modified date: 2019
	 * Description: ....
	 * Version 1.0
	 */
	@GetMapping("/list-role")
	public String getAll(ModelMap modelMap) {
		
		List<Role> listRole = roleService.getAll();
		modelMap.addAttribute("listRole", listRole);
		return "listRole";
	}
	
	@PostMapping("/list-role")
	public String filterByName(@RequestParam String name, ModelMap modelMap) {
		List<Role> listRole = roleService.filterByName(name);
		modelMap.addAttribute("listRole", listRole);
		return "listRole";
	}
	
	/**
	 * Create by: Hai - CMC
	 * Create date: Jan 12, 2019
	 * Modifier: Hai95 + Dong97
	 * Modified date: 2019
	 * Description: ....
	 * Version 1.0
	 */
	@GetMapping("/detail-role/{id}")
	public String getOne(@PathVariable String id, ModelMap modelMap) {
		Role role = roleService.getOne(Integer.parseInt(id));
		modelMap.addAttribute("role", role);
		return "detailRole";
	}
	
	/**
	 * Create by: Hai - CMC
	 * Create date: Jan 12, 2019
	 * Modifier: Hai95 + Dong97
	 * Modified date: 2019
	 * Description: ....
	 * Version 1.0
	 */
	@GetMapping("/add-role")
	public String roleInsert(ModelMap modelMap) {
		Role role = new Role();
		modelMap.addAttribute("role", role);
		return "addRole";
	}
	
	/**
	 * Create by: Hai - CMC
	 * Create date: Jan 12, 2019
	 * Modifier: Hai95 + Dong97
	 * Modified date: 2019
	 * Description: ....
	 * Version 1.0
	 */
	@PostMapping("/add-role")
	public String insertRole(@ModelAttribute Role role, ModelMap modelMap) {
		while(!val.validateRolename(role.getName()))
		{
			String val = "*the name can just contain letter*";
			modelMap.addAttribute("val", val);
			return "addRole";
		}
		roleService.insert(role);
		return "redirect:/admin/Role/list-role";
	}
	
	/**
	 * Create by: Hai - CMC
	 * Create date: Jan 12, 2019
	 * Modifier: Hai95 + Dong97
	 * Modified date: 2019
	 * Description: ....
	 * Version 1.0
	 */
	@GetMapping("delete-role/{id}")
	public String delete(@PathVariable String id) {
		roleService.delete(Integer.parseInt(id));
		return "redirect:/admin/Role/list-role";
	}
	
	/**
	 * Create by: Hai - CMC
	 * Create date: Jan 12, 2019
	 * Modifier: Hai95 + Dong97
	 * Modified date: 2019
	 * Description: ....
	 * Version 1.0
	 */
	@GetMapping("/update-role/{id}")
	public String roleUpdate(ModelMap modelMap, @PathVariable String id) {
		Role role = roleService.getOne(Integer.parseInt(id));
		modelMap.addAttribute("role", role);
		return "updateRole";
	}
	
	/**
	 * Create by: Hai - CMC
	 * Create date: Jan 12, 2019
	 * Modifier: Hai95 + Dong97
	 * Modified date: 2019
	 * Description: ....
	 * Version 1.0
	 */
	@PostMapping("/update-role")
	public String updateRole(@ModelAttribute Role role, ModelMap modelMap) {
		while(!val.validateRolename(role.getName()))
		{
			String val = "*the name can just contain letter*";
			modelMap.addAttribute("val", val);
			return "updateRole";
		}
		roleService.update(role);
		return "redirect:/admin/Role/list-role";
	}
}