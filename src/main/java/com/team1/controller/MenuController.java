package com.team1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.team1.entity.Menu;
import com.team1.service.MenuService;

/*
 * @author Hung.
 * Created date: Jan 11, 2019
 * Created time: 10:40:50 AM
 * Description: handle menu controller
 */
@Controller
public class MenuController {
  @Autowired
  MenuService menuService;

  @GetMapping(value = "/listmenu")
  public String getAllUser(ModelMap map) {
    map.addAttribute("menu", new Menu());
    List<Menu> menu = menuService.getListAllMenu();
    map.addAttribute("list", menu);
    return "listMenu";
  }
  
  @GetMapping(value = "/login")
  public String handlogin(ModelMap map) {
    return "user/viewLogin";
  }
  @GetMapping(value = "/delete-menu/{id}")
  public String handleDeleteMenu(ModelMap map, @PathVariable("id") int id) {
    menuService.deleteMenuByID(id);
    return "redirect:/listmenu";
  }
  
  @PostMapping(value = "/add-menu")
  public String handleAddMenu(ModelMap map,@ModelAttribute("menu") Menu menu) {
    menuService.insertMenu(menu);
    return "redirect:/listmenu";
  }
}
