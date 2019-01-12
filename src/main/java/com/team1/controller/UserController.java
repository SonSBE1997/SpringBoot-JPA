/**
 * Project name: Team1-SpringBoot-JPA
 * Package name: com.team1.controller
 * File name: UserController.java
 * Author: Sanero.
 * Created date: Jan 11, 2019
 * Created time: 8:49:43 AM
 */

package com.team1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.team1.entity.User;
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
	
	@GetMapping(value = "/login")
	public String login(ModelMap model, @RequestParam(name = "e", required = false) String error) {
		if (error != null) {
			model.addAttribute("e", error);
		}
		return "user/login";
	}

	@GetMapping(value = "/list-user")
	public String listUserRole(Model model) {
		List<User> users = userService.getAllUser();
		model.addAttribute("list", users);
		return "user/listUser";
	}
	@GetMapping(value = "/detail-user/{id}")
	public String detailUser(Model model,@PathVariable("id") int id) {
		model.addAttribute("user", userService.findUser(id));
		return "user/detailUser";
	}
	@GetMapping(value = "/search")
	public String detailUserRole(Model model,@RequestParam(value="email",required = false) String email) {
		List<User> users = userRepository.findBy(email);
		model.addAttribute("list",users);
		return "user/searchUser";
	}
	@GetMapping(value = "/delete-user/{id}")
	public String deleteUser(Model model,@PathVariable("id") int id) {
		userService.deleteUser(id);
		return "redirect:/list-user";
	}

	@GetMapping(value = "/add-user")
	public String addUser(ModelMap model) {
		model.addAttribute("user", new User());
		return "user/addUser";
	}

	@PostMapping(value = "/add-user")
	public String addUser(ModelMap model, @ModelAttribute("user") User user, BindingResult bindingResult) {
		userValidator.validate(user, bindingResult);
		if (bindingResult.hasErrors()) {
			return "user/addUser";
		}
		user.setStatus("Thanh cong");
		userService.addUser(user);
		return "redirect:/list-user";

	}
	@GetMapping(value = "/edit-user/{id}")
	public String editUser(ModelMap model,@PathVariable("id") String id) {
		model.addAttribute("user", userService.findUser(Integer.parseInt(id)));
		return "user/editUser";
	}

	@PostMapping(value = "/edit-user")
	public String editUser(ModelMap model, @ModelAttribute("user") User user, BindingResult bindingResult) {
		userValidator.validate(user, bindingResult);
		if (bindingResult.hasErrors()) {
			
			return "user/editUser";
		}
		user.setStatus("Thanh cong");
		userService.updateUser(user);
		return "redirect:/list-user";

	}
}
