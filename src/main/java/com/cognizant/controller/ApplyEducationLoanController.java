package com.cognizant.controller;


import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
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
import com.cognizant.entity.EducationLoanDetails;
import com.cognizant.exception.BankManagementException;
import com.cognizant.service.ApplyEducationLoanService;

@Controller
public class ApplyEducationLoanController {
	
    @Autowired
	ApplyEducationLoanService service;
    
    static Logger logger = Logger.getLogger(ApplyEducationLoanController.class);
	
	//private List<EducationLoanDetails> educationLoanDetailsList;
	
	


	@RequestMapping(value="/applyLoan/{accountNumber}", method=RequestMethod.GET)
	public String getEmployee(@ModelAttribute("educationLoanDetails") @Valid EducationLoanDetails educationLoanDetails,
			BindingResult result, @PathVariable("accountNumber") String accountNumber,
			Model model){
		model.addAttribute("accountNumber", accountNumber);
		return "ApplyEducationLoan";
	}
	
	
	@RequestMapping(value = "/applyLoan/{accountNumber}", method = RequestMethod.POST)
	public String saveOrUpdateEmployee(@ModelAttribute("educationLoanDetails") @Valid EducationLoanDetails educationLoanDetails,
		
		BindingResult result,
		Model model) {
		
		boolean flag=true;
		/*SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date parsed = format.parse(educationLoanDetails.getEduLoanApplyDate());*/
		
		
        //java.sql.Date sql = new java.sql.Date(educationLoanDetails.getEduLoanApplyDate().getTime());
        //educationLoanDetails.setEduLoanApplyDate(sql);
	
		logger.debug("Education Loan Details in EducationLoanController in saveOrUpdateEmployee method is :"+educationLoanDetails);
		//educationLoanDetailsList = new ArrayList<>();	
		//educationLoanDetailsList.add(educationLoanDetails);
		try{
			java.sql.Date d = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		educationLoanDetails.setEduLoanApplyDate(d);
		
			service.insertEducationLoanDetails(educationLoanDetails);
		}
		catch (ConstraintViolationException e) {
			flag=false;
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
			flag=false;
			// TODO Auto-generated catch block
			
			String msg=e.getMessage();
			String arr[]=msg.split(":");
			logger.error("Validation message: "+e.getMessage());
			result.rejectValue(arr[0], "", e.getMessage());
			
		}
		

		if (result.hasErrors()) {
			return "ApplyEducationLoan";
		} 
		if(flag==false)
		{
			return "ApplyEducationLoan";
		}
		else{
		model.addAttribute("loanId",educationLoanDetails.getEducationLoanId());
		model.addAttribute("loanAccountNumber",educationLoanDetails.getEduLoanAccountNumber());
		
		return "EducationSuccess";
		}
}
}
