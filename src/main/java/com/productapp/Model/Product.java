package com.productapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pid;

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", name=" + name + ", description=" + description + ", price=" + price + "]";
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int pid, String name, String description, long price) {
		super();
		this.pid = pid;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public Product(String name, String description, long price) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
	}

	private String name;
	private String description;
	private long price;
}
