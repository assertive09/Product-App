package com.productapp.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	public String home(Model m) {
		List<Product> products = productDao.getAllPoducts();
		m.addAttribute("products", products);
		return "home";
	}

	// show add product form
	@RequestMapping("/add-product")
	public String addProduct(Model m) {

		m.addAttribute("title", "Add Product");
		return "add_product_form";
	}

	@RequestMapping(path = "/handle-product", method = RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute("product") Product product, HttpServletRequest request) {
		this.productDao.createProduct(product);
		RedirectView rv = new RedirectView();

		rv.setUrl(request.getContextPath() + "/");
		return rv;
	}

	// delete product handler
	@RequestMapping("/delete/{pid}")
	public RedirectView deleteProduct(@PathVariable("pid") int pid, HttpServletRequest request) {
		productDao.deleteProduct(pid);
		RedirectView rv = new RedirectView();
		rv.setUrl(request.getContextPath() + "/");
		return rv;
	}
	
	
	@RequestMapping("/update/{pid}")
	public String updateProduct(@PathVariable("pid") int pid, Model m) {
		Product product=this.productDao.getProduct(pid);
		m.addAttribute(product);
		return "update_form";
	}
	
	@RequestMapping(path="/update-submit" ,method = RequestMethod.POST )
	public RedirectView updateSubmit(@ModelAttribute("product") Product p , HttpServletRequest request)
	{
		this.productDao.updateProduct(p);
		RedirectView rv = new RedirectView();
		rv.setUrl(request.getContextPath() + "/");
		return rv;
		
	}
}
