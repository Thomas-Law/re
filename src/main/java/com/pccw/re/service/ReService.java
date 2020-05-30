package com.pccw.re.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pccw.re.model.Customer;
import com.pccw.re.model.Product;

@Service
public class ReService {
	
	@Autowired KieContainer kieContainer;
	
	public Product getProduct(Customer customer, Product product) {
		KieSession kieSession = kieContainer.newKieSession("rulesSession");
		kieSession.insert(product);
		kieSession.insert(customer);
		kieSession.fireAllRules();
		kieSession.dispose();
		return product;
	}
	
}
