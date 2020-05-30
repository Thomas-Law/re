package com.pccw.re.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pccw.re.model.Customer;
import com.pccw.re.model.Product;
import com.pccw.re.service.ReService;

@RestController
public class ReController {
	
	@Autowired ReService reService;
	
	@GetMapping("/product")
	public Product getProduct(
			@RequestParam(required = true) String customerType,
			@RequestParam(required = true) String productId) {
		Customer customer = new Customer();
		customer.setType(customerType);
		Product product = new Product();
		product.setId(productId);
		return reService.getProduct(customer, product);
	}
	
}
