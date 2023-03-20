package com.productapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {
	@Autowired
	private HibernateTemplate template;

	public void createProduct(Product product) {

		template.save(product);
	}
}
