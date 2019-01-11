/**
 * Project name: News
 * Package name: dev.sanero.controller
 * File name: NewsController.java
 * Author: Sanero.
 * Created date: Jan 11, 2019
 * Created time: 9:37:15 AM
 */

package com.team1.controller;

import com.team1.entity.News;
import com.team1.entity.User;
import com.team1.service.NewsService;
import com.team1.service.UserService;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/*
 * @author Sanero.
 * Created date: Jan 11, 2019
 * Created time: 9:37:15 AM
 * Description: TODO - news controller.
 */
@Controller
@RequestMapping("/admin/news")
public class NewsController {
  @Autowired
  NewsService newsService;
  @Autowired
  UserService userService;

  /**
   * Author: Sanero.
   * Created date: Jan 11, 2019
   * Created time: 9:41:05 AM
   * Description: TODO - show all news.
   * @param model - Model Map.
   * @return page show.
   */
  @GetMapping
  public String showAll(ModelMap model) {
    List<News> listNews = newsService.getAll();
    model.addAttribute("listNews", listNews);
    return "news/show";
  }

  /**
   * Author: Sanero.
   * Created date: Jan 11, 2019
   * Created time: 10:43:33 AM
   * Description: TODO - Show all information of news.
   * @param newsId - news id.
   * @param model - model map.
   * @return - page detail.
   */
  @GetMapping("/detail/{newsId}")
  public String detail(@PathVariable int newsId, ModelMap model) {
    News news = newsService.findById(newsId);
    model.addAttribute("news", news);
    return "news/detail";
  }

  /**
   * Author: Sanero.
   * Created date: Jan 11, 2019
   * Created time: 1:31:41 PM
   * Description: TODO - show page create.
   * @return - page create.
   */
  @GetMapping("/add-new")
  public String create() {
    return "news/create";
  }

  /**
   * Author: Sanero.
   * Created date: Jan 11, 2019
   * Created time: 1:31:39 PM
   * Description: TODO - handle create news.
   * @param news - news information.
   * @param model - model map.
   * @param attributes - redirect attribute.
   * @return redirect to page list.
   */
  @PostMapping("/add-new")
  public String create(HttpSession session, @ModelAttribute News news,
      ModelMap model, RedirectAttributes attributes) {
    User user = (User) session.getAttribute("userLogin");
    news.setUser(user);
    news.setStatus("chua phe duyet");
    long now = new Date().getTime();
    news.setCreatedAt(new java.sql.Date(now));
    newsService.addNew(news);
    return "redirect:/admin/news";
  }

  /**
   * Author: Sanero.
   * Created date: Jan 11, 2019
   * Created time: 2:52:30 PM
   * Description: TODO - .
   * @param id - news id.
   * @return
   */
  @GetMapping("/edit/{id}")
  public String editNews(@PathVariable int id, ModelMap model) {
    News news = newsService.findById(id);
    model.addAttribute("news", news);
    return "news/edit";
  }

  /**
   * Author: Sanero.
   * Created date: Jan 11, 2019
   * Created time: 3:28:18 PM
   * Description: TODO - .
   * @param news - news.
   * @return
   */
  @PostMapping("/edit")
  public String editNews(@ModelAttribute News news, @RequestParam int userId,
      @RequestParam String approverId) {
    long now = new Date().getTime();
    news.setUpdatedAt(new java.sql.Date(now));
    news.setUser(userService.findUser(userId));
    if (!("".equals(approverId))) {
      news.setApprover(userService.findUser(Integer.parseInt(approverId)));
    }
    newsService.update(news);
    return "redirect:/admin/news";
  }

  /**
   * Author: Sanero.
   * Created date: Jan 11, 2019
   * Created time: 2:52:30 PM
   * Description: TODO - .
   * @param id - news id.
   * @return
   */
  @GetMapping("/delete/{id}")
  public String delete(@PathVariable int id, RedirectAttributes attribute) {
    newsService.deleteById(id);
    return "redirect:/admin/news";
  }

  /**
   * Author: Sanero.
   * Created date: Jan 11, 2019
   * Created time: 4:45:32 PM
   * Description: TODO - .
   * @param id - news id.
   * @return
   */
  @PostMapping("/changeHot")
  @ResponseBody
  public String changeHot(@RequestParam int id) {
    News news = newsService.findById(id);
    long now = new Date().getTime();
    news.setUpdatedAt(new java.sql.Date(now));
    news.setHot(!news.isHot());
    newsService.update(news);
    if (news.isHot()) {
      return "hot news";
    }
    return "normal";
  }

  /**
   * Author: Sanero.
   * Created date: Jan 11, 2019
   * Created time: 4:45:32 PM
   * Description: TODO - .
   * @param id - news id.
   * @return
   */
  @PostMapping("/approve")
  @ResponseBody
  public String approve(HttpSession session, @RequestParam int id) {
    News news = newsService.findById(id);
    long now = new Date().getTime();
    news.setApprovedAt(new java.sql.Date(now));
    User user = (User) session.getAttribute("userLogin");
    news.setApprover(user);
    news.setStatus("da phe duyet");

    newsService.update(news);
    return user.getFullName();
  }
}
