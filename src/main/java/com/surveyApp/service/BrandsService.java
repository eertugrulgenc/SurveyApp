package com.surveyApp.service;

import java.util.List;

import com.surveyApp.entity.Brands;

public interface BrandsService {
	public List<Brands> getBrands();
	public void save(Brands brands);
}
