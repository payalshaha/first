package com.cognizant.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cognizant.dao.ApplyEducationLoanDAO;
import com.cognizant.entity.EducationLoanDetails;
import com.cognizant.entity.UserDetails;
import com.cognizant.service.ViewEducationLoanService;

@Controller
public class ViewEducationLoanController {
	
	
	@Autowired
	ViewEducationLoanService service;
	
	static Logger logger = Logger.getLogger(ViewEducationLoanController.class);
	

	@RequestMapping(value="/viewLoan", method=RequestMethod.GET)
	public String getJsp(){
		
		return "ViewEducationLoan";
	}

@RequestMapping(value="/viewEducationLoanDetails",method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
public @ResponseBody  List<UserDetails> getEmployees(){
		
	/*UserDetails ud=new UserDetails(1234567891234567l,"Savings","Arjun",20000.0);
	UserDetails ud1=new UserDetails(1234567891234568l,"Salary","Karna",30000.0);*/
		
		long accountNumber=4161000100125568l;
		UserDetails user=new UserDetails();
		user=service.retrieveEducationLoanDetails(accountNumber);
		user.setHomeloan(null);
		user.setTrans(null);
		logger.debug("User details in ViewEducationLoanController :"+ user);
        /* user.setHld(null);*/
		/*li = new ArrayList<>();
	li.add(ud);
	li.add(ud1);*/
		
	List<EducationLoanDetails> list=user.getHld();
	List<EducationLoanDetails> newList=new ArrayList<EducationLoanDetails>();
	List<UserDetails> li=new ArrayList<UserDetails>();
	for(int i=0;i<list.size();i++){
		EducationLoanDetails eld=null;
		eld=list.get(i);
		eld.setUser(null);
		newList.add(eld);
	}
	
	user.setHld(newList);
	li.add(user);
	logger.debug("list of User details in ViewEducationLoanController is :"+li);
	return li;
	}
	
}
