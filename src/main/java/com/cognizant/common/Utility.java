package com.cognizant.common;

import java.util.Random;

import com.cognizant.entity.EducationLoanDetails;

public class Utility {
	
	public static String loanId(long accountNumber)
	{
		StringBuffer sb3 = new StringBuffer();
		
		String account = Long.toString(accountNumber);
		String lastThreeDigit = account.substring(13, 16);
		sb3.append("HL").append("-").append(lastThreeDigit);
		String loanId = sb3.toString();
		
		
		return loanId;
	}
	
	public static String loanAccountNumber()
	{
		long time = System.nanoTime();
		Random rd = new Random();
		int i= rd.nextInt(10);
		String random= Integer.toString(i);
		String timeInString1 = Long.toString(time);
		StringBuffer sb = new StringBuffer();
	    sb.append(timeInString1).append(random);
	    String sb2 = sb.toString();
		
		return sb2;
	}
public static String generateLoanAccountNumber(EducationLoanDetails eld){
		
		long time=System.nanoTime();
		Random rd=new Random();
		int i=rd.nextInt(10);
		StringBuffer sb=new StringBuffer();
		String s1=Long.toString(time);
		String s2=Integer.toString(i);
		sb.append(s1).append(s2);
		String eduLoanNumber=sb.toString();
		
		return eduLoanNumber;
		
	}
	
	public static String generateLoanId(EducationLoanDetails eld){
		String idNumber=Long.toString(eld.getIdNumber());
		String idNumberLast=idNumber.substring(0, 5);
		String loanId="EL_".concat(idNumberLast);
		
		
		return loanId;
		
	}
	
	
 
}
