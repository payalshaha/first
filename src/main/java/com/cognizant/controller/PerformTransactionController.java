package com.cognizant.controller;

import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Set;

import javax.validation.Valid;

import org.apache.log4j.Logger;
//import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.dao.ApplyEducationLoanDAO;
import com.cognizant.entity.TransactionDetails;
import com.cognizant.service.PerformTransactionService;
//import javax.validation.ConstraintViolation;
//import javax.validation.ConstraintViolationException;
//import javax.validation.Valid;

@Controller
public class PerformTransactionController {
	
	@Autowired
	PerformTransactionService service;
	
	static Logger logger = Logger.getLogger(PerformTransactionController.class);
	
	
	
	@RequestMapping(value="/performtransaction/{accountNumber}", method=RequestMethod.GET)
	public String getTransaction(@ModelAttribute("transaction") @Valid TransactionDetails transaction,
			BindingResult result,@PathVariable("accountNumber") String accountNumber, Model model){
		model.addAttribute("accountNumber", accountNumber);
		return "PerformTransaction";
	}
	
	@RequestMapping(value ="/performtransaction/{accountNumber}", method = RequestMethod.POST)
	public String performTransaction1(@ModelAttribute("transaction") @Valid TransactionDetails transaction,
	BindingResult result, 
	Model model) {
	
	System.out.println(transaction);
	long acc=transaction.getAccountNumber();
	
	service.performTransaction(acc,transaction);

	model.addAttribute("m1", transaction.getTransactionId());
	return "member";
/*try {
>>>>>>> fdc880d9d9eacf6155f9e99232cb732aeca9d238
		
	} 
	catch (ConstraintViolationException e) {

		Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
		Iterator<ConstraintViolation<?>> iterator = constraintViolations.iterator();
		while(iterator.hasNext()){
			ConstraintViolation<?> next = iterator.next();
			System.out.println("Validation message: "+next.getMessage());
			System.out.println("Invalid field: "+next.getPropertyPath());
			System.out.println("Validation class/bean: "+next.getRootBean());
//			 result.reject(next.getPropertyPath(), next.getMessage());
			result.rejectValue(next.getPropertyPath().toString(), "", next.getMessage());
//			result.rejectValue(arg0, arg1, arg2);
		}
	}
	catch (Exception e) {
		
		e.printStackTrace();
	}
	

	if (result.hasErrors()) {
		return "employee";
<<<<<<< HEAD
	}
	
	model.addAttribute("m1", transaction.getTransactionId());
	return "member";
=======
	} 
>>>>>>> fdc880d9d9eacf6155f9e99232cb732aeca9d238
	
	//return "member";
*/
}


}
