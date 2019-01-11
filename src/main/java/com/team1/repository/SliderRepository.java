package com.team1.repository;

import java.util.List;
import com.team1.entity.Slider;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(rollbackFor = Exception.class)
public class SliderRepository {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Author: ntmduyen
	 * Created date: Jan 12, 2019
	 * Created time: 1:29:54 AM
	 * Description: TODO - .
	 * @param slider
	 */
	public void persist(final Slider slider) {
		entityManager.persist(slider);
	}

	/**
	 * Author: ntmduyen
	 * Created date: Jan 12, 2019
	 * Created time: 1:29:49 AM
	 * Description: TODO - .
	 * @param slider_id
	 * @return
	 */
	public Slider findById(final Long slider_id) {
		return entityManager.find(Slider.class, slider_id);
	}

	/**
	 * Author: ntmduyen
	 * Created date: Jan 12, 2019
	 * Created time: 1:30:01 AM
	 * Description: TODO - .
	 * @param slider
	 */
	public void delete(final Slider slider) {
		entityManager.remove(slider);
	}

	/**
	 * Author: ntmduyen
	 * Created date: Jan 12, 2019
	 * Created time: 1:30:05 AM
	 * Description: TODO - .
	 * @return
	 */
	public List<Slider> findAll() {
		return entityManager.createQuery("FROM Slider", Slider.class).getResultList();
	}
}
