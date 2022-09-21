package com.surveyApp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.surveyApp.entity.Brands;
import com.surveyApp.service.BrandsService;

@RestController
public class homeController {
	
	private BrandsService brandsService;
	
	@Autowired
	public homeController(BrandsService brandsService) {
		this.brandsService = brandsService;
	}
	/*
	@GetMapping("/home")
	public String goHome(Model model) {
		List<Brands> brands = brandsService.getBrands();
		model.addAttribute("brands",brands);
		return "home";
	}
	*/
	@GetMapping("/home")
	public ModelAndView goHome() {
		List<Brands> brands = brandsService.getBrands();
		ModelAndView model = new ModelAndView();
		model.addObject("brands",brands);
		model.setViewName("home");
		return model;
	}
}
