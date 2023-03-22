package com.productapp.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.productapp.model.Product;

@Repository
public class ProductDao {
	
	@Autowired
	private HibernateTemplate template;

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	// adding product into table
	@Transactional
	public void createProduct(Product product) {
		template.save(product);
	}

	// getting all products
	public List<Product> getAllPoducts() {
		List<Product> products = this.template.loadAll(Product.class);
		return products;
	}

	// delete single product
	@Transactional
	public void deleteProduct(int pid) {

		this.template.delete(this.template.get(Product.class, pid));

	}

	// getting single product
	public Product getProduct(int pid) {

		return this.template.get(Product.class, pid);
	}
	@Transactional
	public void updateProduct(Product p) {
		
		this.template.update(p);
	}

}
