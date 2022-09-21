package com.surveyApp.dao;

import java.util.List;

import com.surveyApp.entity.Brands;

public interface BrandsDAO {
	public List<Brands> getBrands();
	public void save(Brands brands);
}
