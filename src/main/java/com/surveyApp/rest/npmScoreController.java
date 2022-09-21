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
public class npmScoreController {
	private BrandsService brandsService;
	private static ArrayList<String> topicNames;
	private static ArrayList<Integer> topicId;
	@Autowired
	public npmScoreController(BrandsService brandsService) {
		this.brandsService = brandsService;
	}
	@GetMapping("/home/showNpmScorePage")
	public ModelAndView showNpmScorePage() {
		ModelAndView mv = new ModelAndView();
		topicNames = new ArrayList<String>();
		topicId = new ArrayList<Integer>();
		ArrayList<Double> npmScores = new ArrayList<Double>();
		for(BrandsTopic bt: BrandsTopic.values()) {
			topicNames.add(bt.toString());
			
		}
		for(int i=1; i<topicNames.size()+1; i++) {
			topicId.add(i);
		}
		List<Brands> brandsData = brandsService.getBrands();
		for(int i=0; i<topicNames.size(); i++) {
			int detractors = 0;
			int promoters = 0;
			int passives = 0;
			int totalSurvey = 0;
			double npmScore = 0;
			int counter = 0;
			for(Brands bd: brandsData) {
				if(topicNames.get(i).equals(bd.getTopic())) {
					if(bd.getScore()<7) {
						detractors++;
						
					}
					if(bd.getScore()==9 || bd.getScore()==10) {
						promoters++;
				
					}
					if(bd.getScore()==7 || bd.getScore()==8) {
						passives++;
				
					}
					totalSurvey=promoters+detractors+passives;
					npmScore = (promoters/totalSurvey)-(detractors/totalSurvey);
					counter++;
					if(counter>1) {
						double score = npmScores.get(i);
						npmScores.set(i, score+npmScore);
						
					}
					else {
						npmScores.add(npmScore);
					}
					 detractors = 0;
					 promoters = 0;
					 passives = 0;
				}
			}
			
		}
		mv.addObject("topicId",topicId);
		mv.addObject("topicNames",topicNames);
		mv.addObject("npmScores",npmScores);
		mv.setViewName("npmScore");
		return mv;
	}
}
