/**
 * Project name: News
 * Package name: dev.sanero.repository
 * File name: NewsRepository.java
 * Author: Sanero.
 * Created date: Jan 11, 2019
 * Created time: 9:19:48 AM
 */

package com.team1.repository;

import com.team1.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * @author Sanero.
 * Created date: Jan 11, 2019
 * Created time: 9:19:48 AM
 * Description: TODO - news repository
 */
public interface NewsRepository extends JpaRepository<News, Integer> {
}
