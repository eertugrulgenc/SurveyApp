package com.surveyApp.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.surveyApp.entity.Brands;
import com.surveyApp.entity.BrandsTopic;
import com.surveyApp.service.BrandsService;

@RestController
public class surveyController {
	private BrandsService brandsService;
	private static ArrayList<String> topicNames;
	

	@Autowired
	public surveyController(BrandsService brandsService) {
		this.brandsService = brandsService;
	}
	@GetMapping("/home/showSurveyPage")
	public ModelAndView showSurveyPage() {
		ModelAndView mv = new ModelAndView();
		topicNames = new ArrayList<String>();
		for(BrandsTopic bt: BrandsTopic.values()) {
			topicNames.add(bt.toString());
		}
		
		Brands brands = new Brands();
		mv.addObject("brands",brands);
	//	List<Brands> brandsData = brandsService.getBrands();
		
		mv.addObject("brandsData",topicNames);
		mv.setViewName("survey");
		return mv;
	}
	@PostMapping("/createSurvey")
	public ModelAndView submitSurvey(@ModelAttribute("brands") Brands brands) {
		ModelAndView mv = new ModelAndView();
		for(int i=0; i<topicNames.size(); i++) {
			if(topicNames.get(i).equals(brands.getTopic())) {
				brands.setTopicId(i+1);
			}
		}
	
		brandsService.save(brands);
		mv.setViewName("home");
		return mv;
	}
}
