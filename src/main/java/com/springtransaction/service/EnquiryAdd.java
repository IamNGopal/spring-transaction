package com.springtransaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.springtransaction.model.SalesOppr;
import com.springtransaction.repo.ContactRepo;
import com.springtransaction.repo.CustomerRepo;
import com.springtransaction.repo.OpprRepo;

@Service
public class EnquiryAdd {
	@Autowired
	ContactRepo contactRepo;
	
	@Autowired
	CustomerRepo customerRepo;
	
	@Autowired
	OpprRepo opprRepo;
	
	
	public ModelAndView getModelAndView(Model model,  ModelAndView modelAndView) {
		modelAndView.addObject("salesOppr", new SalesOppr());
		ModelMap modelMap = new ModelMap();
		modelMap.put("AnyKey", "Hello");
		modelAndView.addAllObjects(modelMap);
		modelAndView.addObject("anyKey", "123");
		model.addAttribute("123", "abc");
		modelAndView.setViewName("enquiry-add");
		return modelAndView;
		
	}

	public ModelAndView postModelAndView(Model model,SalesOppr salesOppr, ModelAndView modelAndView) {
/*		The basic requirement of my project is to get Customer Name And generate the CustomerId
		Than Contact first name And Last name And store to Contact table With Customer Id in contact Table
		and generate The contact Id
		At last get the oppr details and store into oppr table with customer id and contact Id */
		
		//The validations also needed to be done on all the fields of Customer , Contact And Oppr
		
		
//		 There are 3 questions
//		1. How  to bind one form with multiple object in thymeleaf// If possible
//		2.If i have to execute some query at the time of getmapping how i can store that values 
//		into Model or modelView
//		by that i can re populate on error with out executing the same queries
//		3.How do i save multiple entity which was bound with the form one after another as i mentioned above 
//		 with the help of JPA (Using MYSQL)
		
		System.out.println("modelAndView==1=="+salesOppr.getContactFname()); //Getting the Value
		System.out.println("modelAndView==2=="+modelAndView.getModelMap()); //not getting
		System.out.println("modelAndView==3=="+model.asMap().toString()); //not getting
		
//		Store and get the Id = contactRepo.save(salesOppr.getAxelaCustomerContact());
//		Store and get the Id =  customerRepo.save(salesOppr.getAxelaCustomer());
//		At last store this opprRepo.save(salesOppr);
		opprRepo.save(salesOppr);
		// On error i will do validation and re populate 
		modelAndView.addObject("salesOppr",salesOppr);
//		else redirection will be done 
		modelAndView.setViewName("enquiry-add");
		return modelAndView;
		
	}
	
}
