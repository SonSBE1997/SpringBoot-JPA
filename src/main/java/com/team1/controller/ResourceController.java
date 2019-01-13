package com.team1.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.team1.service.UserService;
@RestController
public class ResourceController {
	@Autowired
	UserService userService;

	@PostMapping(value = "deleteList")
	public String deleteList(@RequestBody ArrayList<String> listUserId, Model model) {
		for (String id : listUserId) {
			String userId = id.substring(8);
			userService.deleteUser(Integer.parseInt(userId));
		}
		return "delete success";
	}
}
