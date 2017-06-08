package com.cognizant.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.dao.ApplyEducationLoanDAO;
import com.cognizant.dao.ViewHomeLoanDAO;
import com.cognizant.entity.HomeLoanDetails;
import com.cognizant.entity.UserDetails;

@Component
/*@Transactional*/
public class ViewHomeLoanService {
	
	UserDetails user = new UserDetails();
	@Autowired
	ViewHomeLoanDAO getHomeLoanDetails;
	
	static Logger logger = Logger.getLogger(ViewHomeLoanService.class);
	@Transactional
	public UserDetails retrieveUserHomeLoanDetails(long accountNumber)
	{
		 user = getHomeLoanDetails.retrieveUserHomeLoanDetails(accountNumber);
		// List<HomeLoanDetails> homeLoan1=new ArrayList<HomeLoanDetails>();
		 //homeLoan1 = user.getHomeloan();
		// System.out.println(homeLoan1.get(0).getDesignation());
		//System.out.println(user);
		return user;
	}

}
