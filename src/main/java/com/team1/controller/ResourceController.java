package com.team1.controller;

import com.team1.service.UserService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {
  @Autowired
  UserService userService;

  /**
   * Author: Sanero.
   * Created date: Jan 14, 2019
   * Created time: 2:56:46 PM
   * Description: TODO - .
   * @param listUserId - all entity.
   * @param model - model map.
   * @return
   */
  @PostMapping(value = "deleteList")
  public String deleteList(@RequestBody ArrayList<String> listUserId,
      Model model) {
    for (String id : listUserId) {
      String userId = id.substring(8);
      userService.deleteUser(Integer.parseInt(userId));
    }
    return "delete success";
  }
}
