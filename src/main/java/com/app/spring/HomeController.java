package com.app.spring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.spring.service.LoginService;
import com.apps.spring.entity.Product;

/**
 * Handles requests for the application home page.
 */
@RestController
@RequestMapping(value="home")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private LoginService loginService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/api/productDetails", method = RequestMethod.GET)
	public ResponseEntity<List> getProductDetails(/*@RequestParam String id*/) {
		
		logger.info("Method entry to get the product details");
		
		List<Product> lstProdDetails = new ArrayList<Product>();
		try{
			
			lstProdDetails.add(new Product(1,"Prod1","dfdsf"));
			
		}
		
		catch(Exception e){
			logger.error("Exception in getProductDetails "+ e);
		}
		
		
		return new ResponseEntity<List>(lstProdDetails, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/configDetails", method = RequestMethod.GET)
	public Map<String,String> getConfigDetails(/*@RequestParam String id*/) {
		
		logger.info("Method entry to get the config details");
		
		Map<String,String> configDetails = new HashMap<String, String>();
		try{
			
			configDetails.put("ip","11.23.167.199");
			configDetails.put("port","8080");
			
		}
		
		catch(Exception e){
			logger.error("Exception in getProductDetails "+ e);
		}
		
		
		return configDetails;
	}
	
	
	
	@RequestMapping(value="/login.do", method = RequestMethod.GET)
	public boolean loginUser(@RequestParam String userName, @RequestParam String password){
		
		System.out.println("Login method1"+userName+" "+password);
		
		if("Guhan".equalsIgnoreCase(userName) && "12345".equalsIgnoreCase(password)){
			return loginService.validateLogin(userName, password);
		}
		return false;
	}
	
}
