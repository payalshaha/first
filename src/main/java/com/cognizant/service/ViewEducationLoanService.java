package com.cognizant.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.dao.ApplyEducationLoanDAO;
import com.cognizant.dao.ViewEducationLoanDAO;
import com.cognizant.entity.UserDetails;

@Component
public class ViewEducationLoanService{
	@Autowired
	ViewEducationLoanDAO vld;
	
	static Logger logger = Logger.getLogger(ViewEducationLoanService.class);
	
	@Transactional
	public UserDetails retrieveEducationLoanDetails(long accountNumber) {
		// TODO Auto-generated method stub
		UserDetails ud=new UserDetails();
		ud=vld.retrieveEducationLoanDetails(accountNumber);
		logger.debug("User Details in ViewEducationLoanService is :"+ud);
		return ud;
	}
	
	
}