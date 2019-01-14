package com.team1.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

  /**
   * Author: Hung.
   * Created date: Jan 14, 2019
   * Created time: 1:17:54 PM
   * Description: display list menu
   * @param map
   * @return
   */
  @GetMapping(value = "/menu")
  public String getAllUser(ModelMap map) {
    map.addAttribute("menu", new Menu());
    List<Menu> menu = menuService.getListAllMenu();
    map.addAttribute("list", menu);
    return "/user/viewMenu";
  }
  

  /**
   * Author: Hung.
   * Created date: Jan 14, 2019
   * Created time: 1:18:15 PM
   * Description: handle delete menu by id
   * @param map
   * @param id
   * @return
   */
  @GetMapping(value = "/menu/delete/{id}")
  public String handleDeleteMenu(ModelMap map, @PathVariable("id") int id) {
    menuService.deleteMenuByID(id);
    return "redirect:/menu";
  }
  
  /**
   * Author: Hung.
   * Created date: Jan 14, 2019
   * Created time: 1:18:36 PM
   * Description: handle add menu
   * @param map
   * @param menu
   * @return
   */
  @PostMapping(value = "/menu/add")
  public String handleAddMenu(ModelMap map,@ModelAttribute("menuEdit") Menu menu) {
    menuService.insertMenu(menu);
    return "redirect:/menu";
  }
  
  
  /**
   * Author: Hung.
   * Created date: Jan 14, 2019
   * Created time: 1:19:33 PM
   * Description: handle edit menu
   * @param request
   * @param menu
   * @return
   */
  @PostMapping(value = "/menu/edit")
  public String handleEditMenu(HttpServletRequest request, Menu menu) {
    int id = Integer.parseInt(request.getParameter("id"));
    String name = request.getParameter("name");
    String desc = request.getParameter("desc");
    String controll = request.getParameter("controll");
    String function = request.getParameter("function");
    menu.setMenu_id(id);
    menu.setName(name);
    menu.setController(controll);
    menu.setDescription(desc);
    menu.setAction(function);
    menuService.updateMenu(menu);
    return "redirect:/menu";
  }
  
  
  /**
   * Author: Hung.
   * Created date: Jan 14, 2019
   * Created time: 1:19:45 PM
   * Description: handle search menu
   * @param map
   * @param menu
   * @return
   */
  @PostMapping(value = "/menu")
  public String handleSearchMenu(ModelMap map,@ModelAttribute("menu") Menu menu) {
    map.addAttribute("menu", new Menu());
    List<Menu> listMenu = menuService.findNameContaining(menu.getName());
    map.addAttribute("list", listMenu);
    return "/user/viewMenu";
  }
}
