package com.surveyApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.surveyApp.dao.BrandsDAO;
import com.surveyApp.entity.Brands;

@Service
public class BrandsServiceImp implements BrandsService{

	private BrandsDAO brandsDAO;
	
	@Autowired
	public BrandsServiceImp(BrandsDAO brandsDAO) {
		this.brandsDAO = brandsDAO;
	}

	@Override
	@Transactional
	public List<Brands> getBrands() {
		return brandsDAO.getBrands();
	}

	@Override
	@Transactional
	public void save(Brands brands) {
		brandsDAO.save(brands);
	}
		
}
