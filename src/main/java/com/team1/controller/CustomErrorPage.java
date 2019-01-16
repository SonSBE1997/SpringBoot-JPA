/**
 * Project name: News
 * Package name: dev.sanero.controller
 * File name: CustomErrorPage.java
 * Author: Sanero.
 * Created date: Jan 15, 2019
 * Created time: 10:45:01 AM
 */

package com.team1.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * @author Sanero.
 * Created date: Jan 15, 2019
 * Created time: 10:45:01 AM
 * Description: TODO - custome error page.
 */
@Controller
public class CustomErrorPage implements ErrorController {

  /* (non-Javadoc)
   * @see org.springframework.boot.web.servlet.error.ErrorController#getErrorPath()
   * Author: Sanero.
   * Created date: Jan 15, 2019
   * Created time: 10:45:22 AM
   */
  @Override
  public String getErrorPath() {
    return "/error";
  }

  /**
   * Author: Sanero.
   * Created date: Jan 15, 2019
   * Created time: 10:50:01 AM
   * Description: TODO - handle error page.
   * @param request - client request.
   * @param model - model map.
   * @return
   */
  @RequestMapping("/error")
  public String handleError(HttpServletRequest request, ModelMap model) {
    Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

    if (status != null) {
      Integer statusCode = Integer.valueOf(status.toString());

      if (statusCode == HttpStatus.NOT_FOUND.value()) { // 404
        model.addAttribute("status", HttpStatus.NOT_FOUND);
      } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) { // 500
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR);
      } else if (statusCode == HttpStatus.BAD_REQUEST.value()) { // 400
        model.addAttribute("status", HttpStatus.BAD_REQUEST);
      } else if (statusCode == HttpStatus.FORBIDDEN.value()) { // 403
        model.addAttribute("status", HttpStatus.FORBIDDEN);
      } else if (statusCode == HttpStatus.UNAUTHORIZED.value()) { // 401
        model.addAttribute("status", HttpStatus.UNAUTHORIZED);
      } else if (statusCode == HttpStatus.METHOD_NOT_ALLOWED.value()) { // 405
        model.addAttribute("status", HttpStatus.METHOD_NOT_ALLOWED);
      } else if (statusCode == HttpStatus.BAD_GATEWAY.value()) { // 502
        model.addAttribute("status", HttpStatus.BAD_GATEWAY);
      }
    }
    return "error";
  }
}
