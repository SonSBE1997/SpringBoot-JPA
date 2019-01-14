package com.team1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 * @author ntmduyen
 * Created date: Jan 12, 2019
 * Created time: 12:58:17 AM
 * Description: TODO -
 */
@Entity
public class Slider {
  @Id
  @Column(name = "slider_id", length = 10)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int slider_id;
  @Column(name = "name", length = 50)
  private String name;
  @Column(name = "content", length = 50)
  private String content;
  @Column(name = "imgUrl", length = 50)
  private String imgUrl;

  public Slider() {

  }

  /**
   * Author: ntmduyen
   * Created date: Jan 12, 2019
   * Created time: 12:58:08 AM
   * Description: - .
   * @param slider_id
   * @param name
   * @param content
   * @param imgUrl
   */
  public Slider(int slider_id, String name, String content, String imgUrl) {
    super();
    this.slider_id = slider_id;
    this.name = name;
    this.content = content;
    this.imgUrl = imgUrl;
  }

  /**
   * Author: ntmduyen
   * Created date: Jan 12, 2019
   * Created time: 12:57:08 AM
   * Description: TODO - .
   * @return
   */
  public int getSlider_id() {
    return slider_id;
  }

  /**
   * Author: ntmduyen
   * Created date: Jan 12, 2019
   * Created time: 12:57:16 AM
   * Description: TODO - .
   * @param slider_id
   */
  public void setSlider_id(int slider_id) {
    this.slider_id = slider_id;
  }

  /**
   * Author: ntmduyen
   * Created date: Jan 12, 2019
   * Created time: 12:57:21 AM
   * Description: TODO - .
   * @return
   */
  public String getName() {
    return name;
  }

  /**
   * Author: ntmduyen
   * Created date: Jan 12, 2019
   * Created time: 12:57:26 AM
   * Description: TODO - .
   * @param name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Author: ntmduyen
   * Created date: Jan 12, 2019
   * Created time: 12:57:32 AM
   * Description: TODO - get the content.
   * @return
   */
  public String getContent() {
    return content;
  }

  /**
   * Author: ntmduyen
   * Created date: Jan 12, 2019
   * Created time: 12:57:36 AM
   * Description: TODO - set the content.
   * @param content
   */
  public void setContent(String content) {
    this.content = content;
  }

  /**
   * Author: ntmduyen
   * Created date: Jan 12, 2019
   * Created time: 12:57:40 AM
   * Description: TODO - get an img url .
   * @return
   */
  public String getImgUrl() {
    return imgUrl;
  }

  /**
   * Author: ntmduyen
   * Created date: Jan 12, 2019
   * Created time: 12:57:45 AM
   * Description: TODO - set a image url .
   * @param imgUrl
   */
  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }
}
