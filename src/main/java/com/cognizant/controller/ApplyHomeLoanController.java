package com.cognizant.controller;

import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.dao.ApplyEducationLoanDAO;
import com.cognizant.entity.HomeLoanDetails;
import com.cognizant.exception.BankManagementException;
import com.cognizant.service.ApplyHomeLoanService;

@Controller
public class ApplyHomeLoanController {
	@Autowired
	ApplyHomeLoanService service;
	boolean flag = true;
	
	static Logger logger = Logger.getLogger(ApplyHomeLoanController.class);
	
	@RequestMapping(value="/adduserhomeloandetails/{accountNumber}", method=RequestMethod.GET)
	public String getHomeLoanDetails(@ModelAttribute("homeLoanDetails") @Valid HomeLoanDetails homeLoanDetails,
			BindingResult result,@PathVariable("accountNumber") String accountNumber , Model model){
		model.addAttribute("accountNumber", accountNumber);
		
		return "ApplyHomeLoan";
	}

	
	@RequestMapping(value="/adduserhomeloandetails/{accountNumber}", method=RequestMethod.POST)
	public String applyHomeLoanDetails(@ModelAttribute("homeLoanDetails")  @Valid HomeLoanDetails homeLoanDetails,
			BindingResult result, Model model){
		try{
			
		service.insertHomeLoanDetails(homeLoanDetails);
		}catch(ConstraintViolationException e)
		{
			flag = false;
			// TODO Auto-generated catch block
//			e.printStackTrace();
			Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
			Iterator<ConstraintViolation<?>> iterator = constraintViolations.iterator();
			while(iterator.hasNext()){
				
				ConstraintViolation<?> next = iterator.next();
				logger.error("Validation message: "+next.getMessage());
				logger.error("Invalid field: "+next.getPropertyPath());
				logger.error("Validation class/bean: "+next.getRootBean());
//				 result.reject(next.getPropertyPath(), next.getMessage());
				result.rejectValue(next.getPropertyPath().toString(), "", next.getMessage());
//				result.rejectValue(arg0, arg1, arg2);
		}
		}
		catch (BankManagementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag = false;
			logger.error("Validation message: "+e.getMessage());
			String sb = e.getMessage();
			String sb1[] = sb.split(":");
			
			result.rejectValue(sb1[0],"", sb1[1]);
			
		}
		

		if (result.hasErrors()) {
			return "ApplyHomeLoan";
		} 
		String loanAccountNumber= homeLoanDetails.getHomeLoanAccountNumber();
		String loanId = homeLoanDetails.getHomeLoanId();
		
		model.addAttribute("loanAccountNumber",loanAccountNumber);
		model.addAttribute("loanId",loanId);
		
		if(flag)
		return "Success";
		else
			return "ApplyHomeLoan";
 	}
/*	@RequestMapping(value="/adduserhomeloandetails", method=RequestMethod.POST)
	public String getEmployee(@ModelAttribute("homeLoanDetails") @Valid HomeLoanDetails homeLoanDetails,
			BindingResult result, Model model){
		
		return "employee";
	}
*/
}

