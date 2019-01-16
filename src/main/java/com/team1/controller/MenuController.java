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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
   * Created date: Jan 16, 2019
   * Created time: 10:35:15 AM
   * Description: TODO - .
   * @param page
   * @param model
   * @return
   */
  @GetMapping(value ="/admin/menu/{page}")
  public String showByPaging(@PathVariable int page, ModelMap model) {
    model.addAttribute("menu", new Menu());
    int pageSize = 2;
    List<Menu> listMenu = menuService.getAllByPaging(page, pageSize);
    model.addAttribute("list", listMenu);
    model.addAttribute("current", page);
    long total = menuService.countAll();
    int maxPage = (int) Math.ceil(((double) total) / pageSize);
    model.addAttribute("total", maxPage);
    return "menu/viewMenu";
  }
  
  /**
   * Author: Hung.
   * Created date: Jan 14, 2019
   * Created time: 1:17:54 PM
   * Description: display list menu
   * @param map
   * @return
   */
  @GetMapping(value = "/admin/menu")
  public String getAllUser(ModelMap map) {
    map.addAttribute("menu", new Menu());
    List<Menu> menu = menuService.getListAllMenu();
    map.addAttribute("list", menu);
    return "menu/viewMenu";
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
  @GetMapping(value = "/admin/menu/delete/{id}")
  public String handleDeleteMenu(ModelMap map, @PathVariable("id") int id,RedirectAttributes attributes) {
    try {
      menuService.deleteMenuByID(id);
      return "redirect:/admin/menu/1";
    } catch (Exception e) {
      attributes.addFlashAttribute("err", "Can't not delete!");
      return "redirect:/admin/menu/1";
    }
    
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
  @PostMapping(value = "/admin/menu/add")
  public String handleAddMenu(ModelMap map,
      @ModelAttribute("menuEdit") Menu menu) {
    menuService.insertMenu(menu);
   
    return "redirect:/admin/menu/1";
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
  @PostMapping(value = "/admin/menu/edit")
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
    return "redirect:/admin/menu/1";
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
  
  @GetMapping("admin/menu/filter/{filter}/{page}")
  public String handleSearchMenu(@PathVariable int page,
      @PathVariable String filter, ModelMap model) {
    model.addAttribute("menu", new Menu());
    int pageSize = 1;
    List<Menu> listMenu = menuService.filterByPaging(page, pageSize, filter);
    model.addAttribute("list", listMenu);
    model.addAttribute("current", page);
    long total = menuService.filterCount(filter);
    int maxPage = (int) Math.ceil(((double) total) / pageSize);
    model.addAttribute("total", maxPage);
    model.addAttribute("searchStr", filter);
    return "menu/viewMenu";
  }
}
