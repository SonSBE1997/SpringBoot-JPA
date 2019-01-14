package com.team1.service;

import com.team1.entity.Slider;
import com.team1.repository.SliderRepository;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SliderService {
  @Autowired
  SliderRepository sliderRepository;
  @Autowired
  EntityManager entityManager;

  /**
   * Author: ntmduyen
   * Created date: Jan 14, 2019
   * Created time: 8:55:17 AM
   * Description: TODO - .
   * @return
   */
  public List<Slider> getAll() {
    return sliderRepository.findAll();
  }

  /**
   * Author: ntmduyen
   * Created date: Jan 14, 2019
   * Created time: 8:55:22 AM
   * Description: TODO - .
   * @param slider_id - slide id.
   * @return
   */
  public Slider getOne(int slider_id) {
    return entityManager.find(Slider.class, slider_id);
  }

  /**
   * Author: ntmduyen
   * Created date: Jan 14, 2019
   * Created time: 8:55:31 AM
   * Description: TODO - .
   * @param slider - slider.
   */
  public void insert(Slider slider) {
    entityManager.persist(slider);
  }

  /**
   * Author: ntmduyen
   * Created date: Jan 14, 2019
   * Created time: 8:55:27 AM
   * Description: TODO - .
   * @param slider - slider.
   */
  public void update(Slider slider) {
    entityManager.merge(slider);
  }

  /**
   * Author: ntmduyen
   * Created date: Jan 14, 2019
   * Created time: 8:55:36 AM
   * Description: TODO - .
   * @param slider_id - slider.
   */
  public void delete(int slider_id) {
    sliderRepository.deleteById(slider_id);
  }
}