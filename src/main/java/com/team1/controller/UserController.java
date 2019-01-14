/**
 * Project name: Team1-SpringBoot-JPA
 * Package name: com.team1.controller
 * File name: UserController.java
 * Author: Sanero.
 * Created date: Jan 11, 2019
 * Created time: 8:49:43 AM
 */

package com.team1.controller;

import com.team1.entity.Role;
import com.team1.entity.User;
import com.team1.entity.UserRole;
import com.team1.repository.UserRepository;
import com.team1.service.UserService;
import com.team1.validator.UserValidator;
import java.util.ArrayList;
import java.util.List;

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
  UserValidator userValidator;
  @Autowired
  UserRepository userRepository;

  @GetMapping(value = "/")
  public String login() {
    return "index";
  }

  /**
   * Author: Sanero.
   * Created date: Jan 14, 2019
   * Created time: 2:59:17 PM
   * Description: TODO - .
   * @param model - model map.
   * @param error handle error.
   * @return
   */
  @GetMapping(value = "/login")
  public String login(ModelMap model,
      @RequestParam(name = "e", required = false) String error) {
    if (error != null) {
      model.addAttribute("e", error);
    }
    return "user/login";
  }

  /**
   * Author: Sanero.
   * Created date: Jan 14, 2019
   * Created time: 2:59:34 PM
   * Description: TODO - .
   * @param model - model map.
   * @return
   */
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

  /**
   * Author: Sanero.
   * Created date: Jan 14, 2019
   * Created time: 2:59:42 PM
   * Description: TODO - .
   * @param model - model map.
   * @param email - email.
   * @return
   */
  @GetMapping(value = "/admin/search")
  public String detailUserRole(Model model,
      @RequestParam(value = "email", required = false) String email) {
    List<User> users = userRepository.findBy(email);
    model.addAttribute("list", users);
    return "user/searchUser";
  }

  /**
   * Author: Sanero.
   * Created date: Jan 14, 2019
   * Created time: 2:59:57 PM
   * Description: TODO - .
   * @param model - model map.
   * @param id - id.
   * @return
   */
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

  /**
   * Author: Sanero.
   * Created date: Jan 14, 2019
   * Created time: 3:00:11 PM
   * Description: TODO - .
   * @param model - model map.
   * @param user - user map.
   * @param bindingResult - binding result.
   * @return
   */
  @PostMapping(value = "/admin/add-user")
  public String addUser(ModelMap model, @ModelAttribute("user") User user,
      BindingResult bindingResult) {
    userValidator.validate(user, bindingResult);
    if (bindingResult.hasErrors()) {
      return "user/addUser";
    }
    user.setStatus("Thanh cong");
    userService.addUser(user);
    if (user.getStatus().equals("That Bại")) {
      model.addAttribute("Msg", "Email đã tồn tại");
      return "user/addUser";
    }
    return "redirect:/admin/list-user";

  }

  /**
   * Author: Sanero.
   * Created date: Jan 14, 2019
   * Created time: 3:00:40 PM
   * Description: TODO - .
   * @param model - model map.
   * @param id - user id.
   * @return
   */
  @GetMapping(value = "/admin/edit-user/{id}")
  public String editUser(ModelMap model, @PathVariable("id") String id) {

    model.addAttribute("user", userService.findUser(Integer.parseInt(id)));
    List<Role> roles = new ArrayList<Role>();
    Role role = new Role();
    role.setName("ROLE_USER");
    role.setName("ROLE_ADMIN");
    roles.add(role);
    model.addAttribute("list", roles);
    return "user/editUser";
  }

  /**
   * Author: Sanero.
   * Created date: Jan 14, 2019
   * Created time: 3:01:15 PM
   * Description: TODO - .
   * @param model - model map.
   * @param user user.
   * @param bindingResult - binding result.
   * @param lstRole - lstRole.
   * @return
   */
  @PostMapping(value = "/admin/edit-user")
  public String editUser(ModelMap model, @ModelAttribute("user") User user,
      BindingResult bindingResult,
      @RequestParam(value = "userRoles", required = false) List<String> lstRole) {
    User findUser = userService.findUser(user.getUserId());
    findUser.setEmail(user.getEmail());
    findUser.setFullName(user.getFullName());
    findUser.setMobile(user.getMobile());
    findUser.setPassword(user.getPassword());
    /*
     * List<UserRole> userRoles = userService.getUserRoleName(user.getUserId()); for
     * (UserRole userRole : userRoles) { userRole.getRole().setName("");
     * 
     * }
     */

    UserRole ur = new UserRole();
    Role r = new Role();
    r.setName(String.join(",", lstRole).trim());
    ur.setRole(r);
    ur.setUser(findUser);
    List<UserRole> lst = new ArrayList<UserRole>();
    lst.add(ur);
    findUser.getUserRoles().addAll(lst);
    userService.updateUser(findUser);
    return "redirect:/admin/list-user";

  }
}
