/**
 * Project name: Day4
 * Package name: com.team1.controller
 * File name: LoginController.java
 * Author: Sanero.
 * Created date: Jan 10, 2019
 * Created time: 8:56:58 AM
 */

package com.team1.controller;

import com.team1.entity.User;
import com.team1.service.impl.UserServiceImpl;
import com.team1.utils.Encryptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

/*
 * @author Sanero.
 * Created date: Jan 10, 2019
 * Created time: 8:56:58 AM
 * Description: TODO - 
 */
@Controller
@RequestMapping("/admin/login")
@SessionAttributes("userLogin")
public class LoginController {
  @Autowired
  UserServiceImpl userService;

  /**
   * Author: Sanero.
   * Created date: Jan 10, 2019
   * Created time: 5:59:02 PM
   * Description: TODO - .
   * @param session - session.
   * @return
   */
  @GetMapping
  public String login(HttpSession session, HttpServletRequest request,
      ModelMap model) {
    if (session.getAttribute("userLogin") != null) {
      return "redirect:/admin";
    }
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
      for (Cookie cookie : cookies) {
        if ("email".equals(cookie.getName())) {
          model.addAttribute("email", cookie.getValue());
        }
        if ("password".equals(cookie.getName())) {
          model.addAttribute("password", cookie.getValue());
        }
      }
    }
    return "login";
  }

  /**
   * Author: Sanero.
   * Created date: Jan 10, 2019
   * Created time: 5:07:51 PM
   * Description: TODO - .
   * @param user - user Login.
   * @param model - Model map.
   * @param attributes - redirect attribute.
   * @return
   */
  @PostMapping
  public RedirectView handleLogin(@ModelAttribute User user, ModelMap model,
      RedirectAttributes attributes, HttpServletResponse response) {
    String password = Encryptor.getMd5(user.getPassword());
    User userLogin = userService.findUserByEmailAndPassword(user.getEmail(),
        password);

    if (userLogin == null) {
      attributes.addFlashAttribute("mess", "Email or password incorrect");
      return new RedirectView("/admin/login");
    }

    Cookie cookieEmail = new Cookie("email", userLogin.getEmail());
    Cookie cookiePassword = new Cookie("password", user.getPassword());
    cookieEmail.setMaxAge(24 * 60 * 60);
    cookiePassword.setMaxAge(24 * 60 * 60);
    response.addCookie(cookieEmail);
    response.addCookie(cookiePassword);
    model.addAttribute("userLogin", userLogin);
    return new RedirectView("/admin");
  }
}
