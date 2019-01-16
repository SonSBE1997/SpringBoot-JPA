package com.team1.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.team1.entity.Slider;
import com.team1.service.SliderService;

/*
 * @author ntmduyen
 * Created date: Jan 12, 2019
 * Created time: 1:31:25 AM
 * Description: TODO -
 */
@Controller
@RequestMapping("/admin")
public class SliderController {
  @Autowired
  SliderService sliderService;

  /*
   * Author: ntmduyen
   * Created date: Jan 14, 2019
   * Created time: 9:55:40 AM
   * Description: TODO - View list.
   * @param modelMap
   * @return
   */
  @GetMapping("/list-slider")
  public String getAll(ModelMap modelMap) {

    List<Slider> listSlider = sliderService.getAll();
    modelMap.addAttribute("listSlider", listSlider);
    return "slider/listSlider";
  }

  /*
   * Author: ntmduyen
   * Created date: Jan 14, 2019
   * Created time: 9:55:52 AM
   * Description: TODO - get detail infomation of slider
   * @param slider_id
   * @param modelMap
   * @return
   */
  @GetMapping(value = "/detail-slider/{slider_id}")
  public String GetOne(@PathVariable String slider_id, ModelMap modelMap) {
    Slider slider = sliderService.getOne(Integer.parseInt(slider_id));
    modelMap.addAttribute("slider", slider);
    return "slider/detailSlider";
  }

  /*
   * Author: ntmduyen
   * Created date: Jan 14, 2019
   * Created time: 9:56:21 AM
   * Description: TODO - insert a slider.
   * @param modelMap
   * @return
   */
  @GetMapping("/add-slider")
  public String sliderInsert(ModelMap modelMap) {
    Slider slider = new Slider();
    modelMap.addAttribute("slider", slider);
    return "slider/addSlider";
  }

  /*
   * Author: ntmduyen
   * Created date: Jan 14, 2019
   * Created time: 9:56:37 AM
   * Description: TODO - insert a slider and redirect to list.
   * @param slider
   * @return
   */
  @PostMapping("/add-slider")
  public String insertSlider(@ModelAttribute Slider slider) {
    sliderService.insert(slider);
    return "redirect:/admin/list-slider";
  }

  /*
   * Author: ntmduyen
   * Created date: Jan 14, 2019
   * Created time: 9:57:02 AM
   * Description: TODO - Delete a slider by ID.
   * @param slider_id
   * @return
   */
  @GetMapping("/delete-slider/{slider_id}")
  public String delete(@PathVariable String slider_id) {
    sliderService.delete(Integer.parseInt(slider_id));
    return "redirect:/admin/list-slider";
  }

  /*
   * Author: ntmduyen
   * Created date: Jan 14, 2019
   * Created time: 9:57:20 AM
   * Description: TODO - Edit a slider.
   * @param modelMap
   * @param slider_id
   * @return
   */
  @GetMapping("/update-slider/{slider_id}")
  public String sliderUpdate(ModelMap modelMap,
      @PathVariable String slider_id) {
    Slider slider = sliderService.getOne(Integer.parseInt(slider_id));
    modelMap.addAttribute("slider", slider);
    return "slider/updateSlider";
  }

  /*
   * Author: ntmduyen
   * Created date: Jan 14, 2019
   * Created time: 9:57:34 AM
   * Description: TODO - .
   * @param slider
   * @return
   */
  @PostMapping("/update-slider")
  public String updateSlider(@ModelAttribute Slider slider) {
    sliderService.update(slider);
    return "redirect:/admin/list-slider";
  }

  /**
   * Author: ntmduyen
   * Created date: Jan 15, 2019
   * Created time: 8:16:19 AM
   * Description: TODO - .
   * @param name
   * @param modelMap
   * @return
   */
  @PostMapping("/list-slider")
  public String filterByName(@RequestParam String name, ModelMap modelMap) {
    List<Slider> listSlider = sliderService.filterByName(name);
    modelMap.addAttribute("listSlider", listSlider);
    return "slider/listSlider";
  }

}