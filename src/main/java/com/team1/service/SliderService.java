package com.team1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team1.entity.Slider;
import com.team1.repository.SliderRepository;

@Service
@Transactional
public class SliderService {
	@Autowired
	private SliderRepository sliderRepository;

	/**
	 * Author: ntmduyen
	 * Created date: Jan 12, 2019
	 * Created time: 1:30:21 AM
	 * Description: TODO - .
	 * @return
	 */
	public List<Slider> findAll() {
		return sliderRepository.findAll();
	}

	/**
	 * Author: ntmduyen
	 * Created date: Jan 12, 2019
	 * Created time: 1:30:25 AM
	 * Description: TODO - .
	 * @param id
	 * @return
	 */
	public Slider findById(final Long id) {
		return sliderRepository.findById(id);
	}

	/**
	 * Author: ntmduyen
	 * Created date: Jan 12, 2019
	 * Created time: 1:30:28 AM
	 * Description: TODO - .
	 * @param slider
	 */
	public void save(final Slider slider) {
		// check if customer exist -> throw exception
		sliderRepository.persist(slider);
	}

	/**
	 * Author: ntmduyen
	 * Created date: Jan 12, 2019
	 * Created time: 1:30:33 AM
	 * Description: TODO - .
	 * @param slider
	 */
	public void update(final Slider slider) {
		// if customerDB = null -> throw Exception
		Slider sliderDB = sliderRepository.findById(slider.getSlider_id());
		sliderDB.setName(slider.getName());
		sliderDB.setContent(slider.getContent());
		sliderDB.setImgUrl(slider.getImgUrl());
		sliderRepository.persist(sliderDB);
	}

	/**
	 * Author: ntmduyen
	 * Created date: Jan 12, 2019
	 * Created time: 1:30:38 AM
	 * Description: TODO - .
	 * @param slider_id
	 */
	public void delete(final Long slider_id) {
		Slider slider = sliderRepository.findById(slider_id);
		if (slider != null) {
			sliderRepository.delete(slider);
		}
	}
}