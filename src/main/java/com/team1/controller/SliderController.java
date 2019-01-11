package com.team1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.team1.entity.Slider;
import com.team1.service.SliderService;

/**
 * @author ntmduyen
 * Created date: Jan 12, 2019
 * Created time: 1:31:25 AM
 * Description: TODO -
 */
@Controller
public class SliderController {
	@Autowired
	private SliderService sliderService;

	/**
	 * Author: ntmduyen
	 * Created date: Jan 12, 2019
	 * Created time: 1:31:16 AM
	 * Description: TODO - .
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/slider-list" })
	public String listSlider(Model model) {
		model.addAttribute("listSlider", sliderService.findAll());
		return "slider/slider-list";
	}

	/**
	 * Author: ntmduyen
	 * Created date: Jan 12, 2019
	 * Created time: 1:31:12 AM
	 * Description: TODO - .
	 * @param model
	 * @return
	 */
	@RequestMapping("/slider-save")
	public String insertSlider(Model model) {
		model.addAttribute("slider", new Slider());
		return "slider/slider-save";
	}

	/**
	 * Author: ntmduyen
	 * Created date: Jan 12, 2019
	 * Created time: 1:31:08 AM
	 * Description: TODO - .
	 * @param slider_id
	 * @param model
	 * @return
	 */
	@RequestMapping("/slider-view/{slider_id}")
	public String viewSlider(@PathVariable Long slider_id, Model model) {
		Slider slider = sliderService.findById(slider_id);
		model.addAttribute("slider", slider);
		return "slider/slider-view";
	}

	/**
	 * Author: ntmduyen
	 * Created date: Jan 12, 2019
	 * Created time: 1:31:04 AM
	 * Description: TODO - .
	 * @param slider_id
	 * @param model
	 * @return
	 */
	@RequestMapping("/slider-update/{slider_id}")
	public String updateSlider(@PathVariable Long slider_id, Model model) {
		Slider slider = sliderService.findById(slider_id);
		model.addAttribute("slider", slider);
		return "slider/slider-update";
	}

	@RequestMapping("/saveSlider")
	public String doSaveSlider(@ModelAttribute("Slider") Slider slider, Model model) {
		sliderService.save(slider);
		model.addAttribute("listSlider", sliderService.findAll());
		return "slider/slider-list";
	}

	/**
	 * Author: ntmduyen
	 * Created date: Jan 12, 2019
	 * Created time: 1:31:00 AM
	 * Description: TODO - .
	 * @param slider
	 * @param model
	 * @return
	 */
	@RequestMapping("/updateSlider")
	public String doUpdateSlider(@ModelAttribute("Slider") Slider slider, Model model) {
		sliderService.update(slider);
		model.addAttribute("listSlider", sliderService.findAll());
		return "slider/slider-list";
	}

	/**
	 * Author: ntmduyen
	 * Created date: Jan 12, 2019
	 * Created time: 1:30:56 AM
	 * Description: TODO - .
	 * @param slider_id
	 * @param model
	 * @return
	 */
	@RequestMapping("/sliderDelete/{slider_id}")
	public String doDeleteSlider(@PathVariable Long slider_id, Model model) {
		sliderService.delete(slider_id);
		model.addAttribute("listCustomer", sliderService.findAll());
		return "slider/slider-list";
	}
}