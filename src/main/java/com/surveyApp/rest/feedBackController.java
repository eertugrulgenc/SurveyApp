package com.surveyApp.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.surveyApp.entity.Brands;
import com.surveyApp.entity.BrandsTopic;
import com.surveyApp.service.BrandsService;

@RestController
public class feedBackController {
	private BrandsService brandsService;
	private static ArrayList<String> topicNames;
	@Autowired
	public feedBackController(BrandsService brandsService) {
		this.brandsService = brandsService;
	}
	@GetMapping("/home/showFeedPage")
	public ModelAndView showSurveyPage() {
		ModelAndView mv = new ModelAndView();
		topicNames = new ArrayList<String>();
		topicNames.add("--Please Select Topic--");
		for(BrandsTopic bt: BrandsTopic.values()) {
			topicNames.add(bt.toString());
		}
		mv.addObject("topicNames",topicNames);
		List<Brands> brandsData = brandsService.getBrands();
		mv.addObject("dataBrands",brandsData);
		mv.setViewName("feedBack");
		return mv;
	}
}
