package com.cognizant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.entity.UserDetails;
import com.cognizant.service.ApplyHomeLoanService;
import com.cognizant.service.ViewHomeLoanService;

@Controller
public class HomePageController {
	@Autowired
	ViewHomeLoanService service;
	@RequestMapping(value="/{accountNumber}", method=RequestMethod.GET)
	public ModelAndView getAccountNumber(@PathVariable("accountNumber")  String accountNumber)
	{
		UserDetails user = new UserDetails();
		 long number=Long.parseLong(accountNumber);
		user = service.retrieveUserHomeLoanDetails(number);
		user.setHld(null);
		user.setHomeloan(null);
		user.setTrans(null);
		
		
		ModelAndView model = new ModelAndView("Main");
		model.addObject("user", user);
		//System.out.println(accountNumber);
		
		return model;
		
	}
	
	

}
