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
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

  public News findById(int id) {
    Optional<News> news = newsRepository.findById(id);
    return news.get();
  }

  public void addNew(News news) {
    news = newsRepository.save(news);
  }

  public void update(News news) {
    news = newsRepository.save(news);
  }

  public void deleteById(int id) {
    newsRepository.deleteById(id);
  }
}
