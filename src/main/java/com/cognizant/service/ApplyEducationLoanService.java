package com.cognizant.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.common.Utility;
import com.cognizant.dao.ApplyEducationLoanDAO;
import com.cognizant.entity.EducationLoanDetails;
import com.cognizant.entity.UserDetails;
import com.cognizant.exception.BankManagementException;

@Transactional
@Component
public class ApplyEducationLoanService {
	
	@Autowired
	ApplyEducationLoanDAO eduDao;
	
	static Logger logger = Logger.getLogger(ApplyEducationLoanService.class);
	
	UserDetails ud=new UserDetails();
	

	public Long insertEducationLoanDetails(EducationLoanDetails eld) throws BankManagementException {
		// TODO Auto-generated method stub
		
		/*long time=System.nanoTime();
		Random rd=new Random();
		int i=rd.nextInt(10);
		StringBuffer sb=new StringBuffer();
		String s1=Long.toString(time);
		String s2=Integer.toString(i);
		sb.append(s1).append(s2);
		String eduLoanNumber=sb.toString();
		eld.setEduLoanAccountNumber(eduLoanNumber);*/
	
		String eduLoanNumber=Utility.generateLoanAccountNumber(eld);
		eld.setEduLoanAccountNumber(eduLoanNumber);
		
		String loanId=Utility.generateLoanId(eld);
		eld.setEducationLoanId(loanId);
		logger.warn("LoanAccountNumber is "+eld.getEduLoanAccountNumber());
		logger.warn("Loan id is "+eld.getEducationLoanId());
		
		
		UserDetails user=eduDao.getUserDetails(eld.getAccountNumber());
		logger.debug(user);
		
		List<EducationLoanDetails> eldList=user.getHld();
		
		if(!eld.getFatherName().matches("^[a-zA-Z\\s]*$"))
		{
			throw new BankManagementException("fatherName:Father name should contain only alphabets and spaces");
		}
		
		if(eld.getEduLoanDuration()!=5&&eld.getEduLoanDuration()!=10){
			throw new BankManagementException("eduLoanDuration:Loan duration should be only 5 or 10 years");
		}
		
		if(eld.getCourseFee()>2000000){
			throw new BankManagementException("courseFee:Course fee cant be greater than 20 Lakhs");
		}
		
		eld.setUser(user);
		eldList.add(eld);
		user.setHld(eldList);
		
		return null;
		
		
		
		
		
		
		
		
		
		
		
	}

	
	
	
}
