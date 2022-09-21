package com.surveyApp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.surveyApp.entity.Brands;

@Repository
public class BrandsDAOImp implements BrandsDAO{
	private EntityManager entityManager;
	
	@Autowired
	public BrandsDAOImp(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Brands> getBrands() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Brands> theQuery = currentSession.createQuery("from Brands",Brands.class);
		List<Brands> brands = theQuery.getResultList();
		return brands;
	}

	@Override
	public void save(Brands brands) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.save(brands);
	}
	
}
