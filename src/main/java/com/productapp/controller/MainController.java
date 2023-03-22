package com.productapp.controller;

import java.net.http.HttpRequest;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.productapp.dao.ProductDao;
import com.productapp.model.Product;

@Controller
public class MainController {

	@Autowired
	private ProductDao productDao;
	@RequestMapping("/home")
	public String home() {
		return "home";
	}

	//show add product form
	@RequestMapping("/add-product")
	public String addProduct(Model  m) {
 
		m.addAttribute("title" , "Add Product");
		return "add_product_form";
	}
	
	@RequestMapping(path="/handle-product" , method = RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute ("product") Product product, HttpServletRequest request) {
		 RedirectView rv=new RedirectView();
		 rv.setUrl(request.getContextPath()+"/");
		 return rv;
		
	}
}

