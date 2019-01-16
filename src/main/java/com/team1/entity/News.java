/**
 * Project name: News
 * Package name: dev.sanero.entity
 * File name: News.java
 * Author: Sanero.
 * Created date: Jan 11, 2019
 * Created time: 8:14:22 AM
 */

package com.team1.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 * @author Sanero.
 * Created date: Jan 11, 2019
 * Created time: 8:14:22 AM
 * Description: TODO - News entity.
 */
@Entity(name = "news")
@Table(name = "news")
public class News {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "news_id")
  private int newsId;

  @Column(name = "url", length = 100)
  private String url;

  @Column(name = "title")
  private String title;

  @Column(name = "description")
  private String description;

  @Column(name = "content")
  private String content;

  @Column(name = "status", length = 50)
  private String status;

  @Column(name = "is_hot")
  private boolean isHot;

  @Column(name = "created_at")
  private Date createdAt;

  @Column(name = "updated_at", nullable = true)
  private Date updatedAt;

  @Column(name = "approved_at", nullable = true)
  private Date approvedAt;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne
  @JoinColumn(name = "approver_id", nullable = true)
  private User approver;

  /*
   * Author: Sanero.
   * Created date: Jan 11, 2019
   * Created time: 9:01:21 AM
   * @return the newId
   */
  public int getNewsId() {
    return newsId;
  }

  /*
   * Author: Sanero.
   * Created date: Jan 11, 2019
   * Created time: 9:01:21 AM
   * @param newId the newId to set
   */
  public void setNewsId(int newId) {
    this.newsId = newId;
  }

  /*
   * Author: Sanero.
   * Created date: Jan 11, 2019
   * Created time: 9:01:21 AM
   * @return the url
   */
  public String getUrl() {
    return url;
  }

  /*
   * Author: Sanero.
   * Created date: Jan 11, 2019
   * Created time: 9:01:21 AM
   * @param url the url to set
   */
  public void setUrl(String url) {
    this.url = url;
  }

  /*
   * Author: Sanero.
   * Created date: Jan 11, 2019
   * Created time: 9:01:21 AM
   * @return the title
   */
  public String getTitle() {
    return title;
  }

  /*
   * Author: Sanero.
   * Created date: Jan 11, 2019
   * Created time: 9:01:21 AM
   * @param title the title to set
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /*
   * Author: Sanero.
   * Created date: Jan 11, 2019
   * Created time: 4:19:37 PM
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /*
   * Author: Sanero.
   * Created date: Jan 11, 2019
   * Created time: 4:19:37 PM
   * @param description the description to set
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /*
   * Author: Sanero.
   * Created date: Jan 11, 2019
   * Created time: 9:01:21 AM
   * @return the content
   */
  public String getContent() {
    return content;
  }

  /*
   * Author: Sanero.
   * Created date: Jan 11, 2019
   * Created time: 9:01:21 AM
   * @param content the content to set
   */
  public void setContent(String content) {
    this.content = content;
  }

  /*
   * Author: Sanero.
   * Created date: Jan 11, 2019
   * Created time: 9:01:21 AM
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /*
   * Author: Sanero.
   * Created date: Jan 11, 2019
   * Created time: 9:01:21 AM
   * @param status the status to set
   */
  public void setStatus(String status) {
    this.status = status;
  }

  /*
   * Author: Sanero.
   * Created date: Jan 11, 2019
   * Created time: 9:01:21 AM
   * @return the isHot
   */
  public boolean isHot() {
    return isHot;
  }

  /*
   * Author: Sanero.
   * Created date: Jan 11, 2019
   * Created time: 9:01:21 AM
   * @param isHot the isHot to set
   */
  public void setHot(boolean isHot) {
    this.isHot = isHot;
  }

  /*
   * Author: Sanero.
   * Created date: Jan 11, 2019
   * Created time: 9:01:21 AM
   * @return the createdAt
   */
  public Date getCreatedAt() {
    return createdAt;
  }

  /*
   * Author: Sanero.
   * Created date: Jan 11, 2019
   * Created time: 9:01:21 AM
   * @param createdAt the createdAt to set
   */
  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  /*
   * Author: Sanero.
   * Created date: Jan 11, 2019
   * Created time: 9:01:21 AM
   * @return the updatedAt
   */
  public Date getUpdatedAt() {
    return updatedAt;
  }

  /*
   * Author: Sanero.
   * Created date: Jan 11, 2019
   * Created time: 9:01:21 AM
   * @param updatedAt the updatedAt to set
   */
  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  /*
   * Author: Sanero.
   * Created date: Jan 11, 2019
   * Created time: 9:01:21 AM
   * @return the approvedAt
   */
  public Date getApprovedAt() {
    return approvedAt;
  }

  /*
   * Author: Sanero.
   * Created date: Jan 11, 2019
   * Created time: 9:01:21 AM
   * @param approvedAt the approvedAt to set
   */
  public void setApprovedAt(Date approvedAt) {
    this.approvedAt = approvedAt;
  }

  /*
   * Author: Sanero.
   * Created date: Jan 11, 2019
   * Created time: 9:01:21 AM
   * @return the user
   */
  public User getUser() {
    return user;
  }

  /*
   * Author: Sanero.
   * Created date: Jan 11, 2019
   * Created time: 9:01:21 AM
   * @param user the user to set
   */
  public void setUser(User user) {
    this.user = user;
  }

  /*
   * Author: Sanero.
   * Created date: Jan 11, 2019
   * Created time: 9:01:21 AM
   * @return the approve
   */
  public User getApprover() {
    return approver;
  }

  /*
   * Author: Sanero.
   * Created date: Jan 11, 2019
   * Created time: 9:01:21 AM
   * @param approve the approve to set
   */
  public void setApprover(User approve) {
    this.approver = approve;
  }
}
