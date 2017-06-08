package com.cognizant.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.common.Utility;
import com.cognizant.dao.ApplyEducationLoanDAO;
import com.cognizant.dao.ApplyHomeLoanDAO;
import com.cognizant.entity.HomeLoanDetails;
import com.cognizant.entity.UserDetails;
import com.cognizant.exception.BankManagementException;

@Component
@Transactional
public class ApplyHomeLoanService {
	@Autowired
	ApplyHomeLoanDAO homeLoanDao;
	
	static Logger logger = Logger.getLogger(ApplyHomeLoanService.class);
	UserDetails user = new UserDetails();
	java.sql.Date systemDate = new java.sql.Date(System.currentTimeMillis());
	public long insertHomeLoanDetails(HomeLoanDetails homeLoan) throws BankManagementException
	{
		//user.setAccountNumber(4161000100125568l);
		
		String sb2 = Utility.loanAccountNumber();
		homeLoan.setHomeLoanAccountNumber(sb2);
		
		
		long accountNumber = homeLoan.getAccountNumber();
		
		 String loanId = Utility.loanId(accountNumber);
		homeLoan.setHomeLoanId(loanId);
		
		
		
		
		UserDetails ud = homeLoanDao.gettHomeLoanUserDetails(accountNumber);
		List<HomeLoanDetails> list = ud.getHomeloan();
		if(homeLoan.getLoanDuration()%5!=0 || homeLoan.getLoanDuration()>=20 || homeLoan.getLoanDuration()<=0)
			throw new BankManagementException("loanDuration:Please enter valid loan duration");
		
		long income= homeLoan.getAnnualIncome();
		long loanAmount = homeLoan.getLoanAmount();
		if(income!=(.10*loanAmount))
			throw new BankManagementException("loanAmount:Please enter valid loan amount");
		Date d1 = homeLoan.getLoanApplyDate(); 

		if(!(d1.after(systemDate))){
			throw new BankManagementException("loanApplyDate:Please enter valid date");
		}
		
				
		
		
		
		homeLoan.setUser(ud);
		list.add(homeLoan);
		
		ud.setHomeloan(list);
		return 3l;
	}

}
