/**
 * Project name: News
 * Package name: dev.sanero.service
 * File name: NewsService.java
 * Author: Sanero.
 * Created date: Jan 11, 2019
 * Created time: 9:21:35 AM
 */

package com.team1.service;

import com.team1.entity.News;
import com.team1.repository.NewsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

/*
 * @author Sanero.
 * Created date: Jan 11, 2019
 * Created time: 9:21:35 AM
 * Description: TODO - news service.
 */
@Service
@Transactional
public class NewsService {
  @Autowired
  EntityManager entityManager;

  @Autowired
  NewsRepository newsRepository;

  /**
   * Author: Sanero.
   * Created date: Jan 11, 2019
   * Created time: 9:33:32 AM
   * Description: TODO - get all news.
   * @return list news.
   */
  public List<News> getAll() {
    return newsRepository.findAll();
  }

  /**
   * Author: Sanero.
   * Created date: Jan 14, 2019
   * Created time: 1:48:56 PM
   * Description: TODO - get list news by page.
   * @param page - current page.
   * @param pageSize - size of one page.
   * @return
   */
  @SuppressWarnings("unchecked")
  public List<News> getAllByPaging(int page, int pageSize) {
    List<News> listNews = new ArrayList<News>();
    Query query = entityManager.createQuery("from news");
    query.setFirstResult((page - 1) * pageSize);
    query.setMaxResults(pageSize);
    listNews = query.getResultList();
    return listNews;
  }
  
  /**
   * Author: Sanero.
   * Created date: Jan 14, 2019
   * Created time: 1:57:46 PM
   * Description: TODO - count number of entity.
   * @return
   */
  public long countAll() {
    return newsRepository.count();
  }

  public News findById(int id) {
    Optional<News> news = newsRepository.findById(id);
    return news.get();
  }

  /**
   * Author: Sanero.
   * Created date: Jan 14, 2019
   * Created time: 11:02:53 AM
   * Description: TODO - .
   * @param news - object news.
   * @param errors - error validation.
   */
  public void addNew(News news, Errors errors) {
    validateData(news, errors);
    if (errors.hasErrors()) {
      return;
    }
    news = newsRepository.save(news);
  }

  /**
   * Author: Sanero.
   * Created date: Jan 14, 2019
   * Created time: 11:06:44 AM
   * Description: TODO - .
   * @param news - news object.
   * @param errors - errors validation.
   */
  private void validateData(News news, Errors errors) {
    if (news.getTitle().length() < 20) {
      errors.rejectValue("title", "News.Title.field.required");
    }
    if (news.getUser() == null) {
      errors.rejectValue("user", "News.User.field.required");
    }

    if (news.getDescription().isEmpty()) {
      errors.rejectValue("description", "News.Description.field.required");
    }

    if (news.getContent().isEmpty()) {
      errors.rejectValue("content", "News.Content.field.required");
    }

    if (news.getUrl().isEmpty()) {
      errors.rejectValue("url", "News.URL.field.required");
    }
  }

  /**
   * Author: Sanero.
   * Created date: Jan 14, 2019
   * Created time: 11:05:05 AM
   * Description: TODO - .
   * @param news - news object.
   */
  public void update(News news, Errors errors) {
    validateData(news, errors);
    if (errors.hasErrors()) {
      return;
    }
    news = newsRepository.save(news);
  }

  /**
   * Author: Sanero.
   * Created date: Jan 14, 2019
   * Created time: 11:05:14 AM
   * Description: TODO - .
   * @param id - news id.
   */
  public void deleteById(int id) {
    newsRepository.deleteById(id);
  }
}
