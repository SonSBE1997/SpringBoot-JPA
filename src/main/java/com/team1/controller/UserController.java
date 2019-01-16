/**
 * Project name: Team1-SpringBoot-JPA
 * Package name: com.team1.controller
 * File name: UserController.java
 * Author: Sanero.
 * Created date: Jan 11, 2019
 * Created time: 8:49:43 AM
 */

package com.team1.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.team1.entity.Role;
import com.team1.entity.User;
import com.team1.entity.UserRole;
import com.team1.repository.UserRepository;
import com.team1.service.UserService;

/*
 * @author Sanero.
 * Created date: Jan 11, 2019
 * Created time: 8:49:43 AM
 * Description: TODO - 
 */
@Controller
public class UserController {
  @Autowired
  UserService userService;
  @Autowired
  UserRepository userRepository;

  @GetMapping(value = "/login")
  public String login(ModelMap model,
      @RequestParam(name = "e", required = false) String error,
      HttpServletRequest request) {
    if (error != null) {
      model.addAttribute("e", error);
    }
    HttpSession session = request.getSession();
    session.setMaxInactiveInterval(6000);
    return "user/login";
  }

  @GetMapping(value = "/admin/list-user")
  public String listUserRole(Model model) {
    Authentication authentication = SecurityContextHolder.getContext()
        .getAuthentication();
    model.addAttribute("name", authentication.getName());
    List<User> users = userService.getAllUser();
    model.addAttribute("list", users);
    return "user/listUser";
  }

  @GetMapping(value = "/admin/detail-user/{id}")
  public String detailUser(Model model, @PathVariable("id") int id) {
    model.addAttribute("user", userService.findUser(id));
    return "user/detailUser";
  }

  @GetMapping(value = "/admin/search")
  public String detailUserRole(Model model,
      @RequestParam(value = "email", required = false) String email) {
    List<User> users = userRepository.findBy(email);
    model.addAttribute("list", users);
    return "user/searchUser";
  }

  @GetMapping(value = "/admin/delete-user/{id}")
  public String deleteUser(Model model, @PathVariable("id") int id) {
    userService.deleteUser(id);
    List<User> users = userService.getAllUser();
    model.addAttribute("list", users);
    return "redirect:/admin/list-user";
  }

  @GetMapping(value = "/admin/add-user")
  public String addUser(ModelMap model) {
    model.addAttribute("user", new User());
    return "user/addUser";
  }

  @PostMapping(value = "/admin/add-user")
  public String addUser(ModelMap model,
      @ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return "user/addUser";
    }

    userService.addUser(user);
    if (user.getStatus() != null) {
      if (user.getStatus().equals("That Bại")) {
        model.addAttribute("Msg", "Email đã tồn tại");
        return "user/addUser";
      }
    }
    return "redirect:/admin/list-user";

  }

  @GetMapping(value = "/admin/edit-user/{id}")
  public String editUser(ModelMap model, @PathVariable("id") String id) {
    model.addAttribute("user", userService.findUser(Integer.parseInt(id)));
    List<String> role = userService.getRoleName(Integer.parseInt(id));
    String join = String.join(",", role);
    System.out.println(join);
    List<String> roles = new ArrayList<String>();
    roles.add("ROLE_ADMIN");
    roles.add("ROLE_USER");
    roles.add("ROLE_DELETE");
    model.addAttribute("list", roles);
    model.addAttribute("join", join);
    return "user/editUser";
  }

  @PostMapping(value = "/admin/edit-user")
  public String editUser(ModelMap model, @ModelAttribute("user") User user,
      BindingResult bindingResult,
      @RequestParam(value = "role", required = false) List<String> lstRole) {
    User findUser = userService.findUser(user.getUserId());
    findUser.setEmail(user.getEmail());
    findUser.setFullName(user.getFullName());
    findUser.setMobile(user.getMobile());
    findUser.setPassword(user.getPassword());
    List<UserRole> lst = findUser.getUserRoles();
    UserRole ur = lst.get(0);
    Role r = ur.getRole();
    r.setName(String.join(",", lstRole).trim());
    ur.setRole(r);
    ur.setUser(findUser);
    lst.add(ur);
    findUser.setUserRoles(lst);
    if (bindingResult.hasErrors()) {
      return "user/addUser";
    }
    userService.updateUser(findUser);
    return "redirect:/admin/list-user";

  }
}
