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

/*
 * @author CHai.
 * Created date: Jan 11, 2019
 * Created time: 8:49:43 AM
 * Description: TODO - 
 */

@Controller
@RequestMapping
public class RoleController {

  @Autowired
  RoleService roleService;

  // ....getAll
  @GetMapping("/list-role")
  public String getAll(ModelMap modelMap) {

    List<Role> listRole = roleService.getAll();
    modelMap.addAttribute("listRole", listRole);
    return "listRole";
  }

  // .....getOne
  @GetMapping(value = "/detail-role/{roleId}")
  public String GetOne(@PathVariable String roleId, ModelMap modelMap) {
    Role role = roleService.getOne(Integer.parseInt(roleId));
    modelMap.addAttribute("role", role);
    return "detailRole";
  }

  // .....insert
  @GetMapping("/add-role")
  public String roleInsert(ModelMap modelMap) {
    Role role = new Role();
    modelMap.addAttribute("role", role);
    return "addRole";
  }

  @PostMapping("/add-role")
  public String insertRole(@ModelAttribute Role role) {
    roleService.insert(role);
    return "redirect:/list-role";
  }

  // .....delete
  @GetMapping("/delete-role/{roleId}")
  public String delete(@PathVariable String roleId) {
    roleService.delete(Integer.parseInt(roleId));
    return "redirect:/list-role";
  }

  // .....update
  @GetMapping("/update-role/{roleId}")
  public String roleUpdate(ModelMap modelMap, @PathVariable String roleId) {
    Role role = roleService.getOne(Integer.parseInt(roleId));
    modelMap.addAttribute("role", role);
    return "updateRole";
  }

  @PostMapping("/update-role")
  public String updateRole(@ModelAttribute Role role) {
    roleService.update(role);
    return "redirect:/list-role";
  }
}
