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
import java.util.stream.Collectors;

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
import com.team1.validator.UserValidator;

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

	@GetMapping(value = "/login")
	public String login(ModelMap model, @RequestParam(name = "e", required = false) String error) {
		if (error != null) {
			model.addAttribute("e", error);
		}
		return "user/login";
	}

	@GetMapping(value = "/admin/list-user")
	public String listUserRole(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
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
	public String detailUserRole(Model model, @RequestParam(value = "email", required = false) String email) {
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
	public String addUser(ModelMap model, @ModelAttribute("user") User user, BindingResult bindingResult) {
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

	@GetMapping(value = "/admin/edit-user/{id}")
	public String editUser(ModelMap model, @PathVariable("id") String id) {

		List<UserRole> lst = new ArrayList<UserRole>();
		UserRole ur1 = new UserRole();
		Role r1 = new Role();
		r1.setName("ROLE_ADMIN");
		ur1.setRole(r1);
		ur1.setUser(userService.findUser(Integer.parseInt(id)));
		UserRole ur2 = new UserRole();
		Role r2 = new Role();
		r2.setName("ROLE_USER");
		ur2.setRole(r2);
		ur2.setUser(userService.findUser(Integer.parseInt(id)));
		UserRole ur3 = new UserRole();
		Role r3 = new Role();
		r3.setName("ROLE_DELETE");
		ur3.setRole(r3);
		ur3.setUser(userService.findUser(Integer.parseInt(id)));
		lst.add(ur1);
		lst.add(ur2);
		lst.add(ur3);
		List<String> collect = userService.findUser(Integer.parseInt(id)).getUserRoles().stream()
				.map(item -> item.getRole().getName()).collect(Collectors.toList());

		model.addAttribute("user", userService.findUser(Integer.parseInt(id)));
		model.addAttribute("urs", lst);
		model.addAttribute("abc", collect.toString());
		return "user/editUser";
	}

	@PostMapping(value = "/admin/edit-user")
	public String editUser(ModelMap model, @ModelAttribute("user") User user, BindingResult bindingResult,
			@RequestParam(value = "userRoles", required = false) List<String> lstRole) {
		User findUser = userService.findUser(user.getUserId());
		findUser.setEmail(user.getEmail());
		findUser.setFullName(user.getFullName());
		findUser.setMobile(user.getMobile());
		findUser.setPassword(user.getPassword());
		List<UserRole> userRoles = findUser.getUserRoles();
		for (UserRole userRole : userRoles) {
			userRole.getRole().setName("");

		}
		List<UserRole> lst = new ArrayList<UserRole>();
		UserRole ur = new UserRole();
		Role r = new Role();
		r.setName(String.join(",", lstRole).trim());
		ur.setRole(r);
		ur.setUser(findUser);
		lst.add(ur);
		findUser.getUserRoles().addAll(lst);
		/*userValidator.validate(findUser, bindingResult);
		if (bindingResult.hasErrors()) {
			return "user/editUser";
		}*/

		userService.updateUser(findUser);
		return "redirect:/admin/list-user";

	}
}
