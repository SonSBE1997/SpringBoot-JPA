/**
 * Project name: News
 * Package name: dev.sanero.controller
 * File name: Controller.java
 * Author: Sanero.
 * Created date: Jan 10, 2019
 * Created time: 4:45:48 PM
 */

package com.team1.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * @author Sanero.
 * Created date: Jan 10, 2019
 * Created time: 4:45:48 PM
 * Description: TODO - Home Controller
 */
@Controller
public class HomeController {

  /**
   * Author: Sanero.
   * Created date: Jan 10, 2019
   * Created time: 5:42:00 PM
   * Description: TODO - .
   * @return
   */
  @RequestMapping("/")
  public String home() {
    return "home";
  }

  /**
   * Author: Sanero.
   * Created date: Jan 10, 2019
   * Created time: 5:42:00 PM
   * Description: TODO - .
   * @return
   */
  @RequestMapping("/admin")
  public String index() {
    return "index";
  }

  @RequestMapping("/admin/logout")
  public String handleLogout(HttpSession session) {
    session.removeAttribute("userLogin");
    return "redirect:/admin";
  }
}
