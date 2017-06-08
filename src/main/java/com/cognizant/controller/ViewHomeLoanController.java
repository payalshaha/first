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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.dao.ApplyEducationLoanDAO;
import com.cognizant.entity.HomeLoanDetails;
import com.cognizant.entity.UserDetails;
import com.cognizant.service.ApplyHomeLoanService;
import com.cognizant.service.ViewHomeLoanService;

@Controller
public class ViewHomeLoanController {
	/*@Autowired
	ApplyHomeLoanService service;*/
	/*List<UserDetails> list;*/
	UserDetails user = new UserDetails();
	
	@Autowired
	ViewHomeLoanService viewHome;
	
	static Logger logger = Logger.getLogger(ViewHomeLoanController.class);
	
	/*@RequestMapping(value="/viewuserhomeloandetails", method=RequestMethod.GET)
	public String getHomeLoanDetails(@ModelAttribute("homeLoanDetails") @Valid HomeLoanDetails homeLoanDetails,
			BindingResult result, Model model){
		service.retrieveUserHomeLoanDetails();
		return "";
	}

	
	@RequestMapping(value="/viewuserhomeloandetails", method=RequestMethod.POST)
	public String applyHomeLoanDetails(@ModelAttribute("homeLoanDetails")  @Valid HomeLoanDetails homeLoanDetails,
			BindingResult result, Model model){
		
		service.insertHomeLoanDetails(homeLoanDetails);
		String loanAccountNumber= homeLoanDetails.getHomeLoanAccountNumber();
		model.addAttribute("loanAccountNumber",loanAccountNumber);
		
		return "Success";
	}*/
	@RequestMapping(value="/viewuserhomeloandetails1/{accountNumber}", method=RequestMethod.GET)
	public String getHomeLoanDetails(Model model , @PathVariable("accountNumber") String accountNumber){
		model.addAttribute("accountNumber", accountNumber);
		System.out.println("In upper controller"+accountNumber);
		return "ViewHomeLoan";
	}
	
	
	@RequestMapping(value="/viewuserhomeloandetails",method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody  List<UserDetails> getEmployees(@PathVariable("accountNumber") String accountNumber){
		
		
		System.out.println("In lower account number"+accountNumber);
		long l = Long.parseLong(accountNumber);
		user= viewHome.retrieveUserHomeLoanDetails(4161000100125568l);
		user.setHld(null);
		   user.setTrans(null);
		  //user.setHomeloan(null);
		   List<UserDetails> user1=new ArrayList<UserDetails>();
		List<HomeLoanDetails> home=new ArrayList<HomeLoanDetails>();
		List<HomeLoanDetails> home1=user.getHomeloan();
		
	   
	   for(int i=0;i<home1.size();i++)
	   {
		 HomeLoanDetails  hm=null;
		    hm = home1.get(i);
		    hm.setUser(null);
		    home.add(hm);
		   
	   }
		user.setHomeloan(home);
		user1.add(user);
		
		
		return user1;
	}

}
