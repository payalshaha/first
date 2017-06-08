package com.cognizant.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;
@Entity

public class HomeLoanDetails {
	private String homeLoanId;
	@Id
	private String homeLoanAccountNumber;
	private Long loanAmount;
	private Date loanApplyDate;
	private long annualIncome;
	private String companyName;
	private String designation;
	int totalExp;
	int expCurrentDate;
	int loanDuration;
	private transient long accountNumber;
	

	@ManyToOne(fetch = FetchType.LAZY,cascade= CascadeType.ALL)
	@JoinColumn(name="accountNumber")
	private UserDetails user;
	
	
	public HomeLoanDetails(){
		
	}

	public HomeLoanDetails(String homeLoanId,String homeLoanAccountNumber, Long loanAccount,
			Date loanApplyDate, long annualIncome, String companyName, String designation, int totalExp,
			int expCurrentDate,int loanDuration) {
		super();
		this.homeLoanId = homeLoanId;
		this.homeLoanAccountNumber = homeLoanAccountNumber;
		this.loanAmount = loanAccount;
		this.loanApplyDate = loanApplyDate;
		this.annualIncome = annualIncome;
		this.companyName = companyName;
		this.designation = designation;
		this.totalExp = totalExp;
		this.expCurrentDate = expCurrentDate;
		this.loanDuration = loanDuration;
	}

	public HomeLoanDetails(long loanAccount, Date loanApplyDate, long annualIncome, String companyName, String designation, int totalExp, int expCurrentDate,UserDetails user,int loanDuration) {
		// TODO Auto-generated constructor stub
		super();
		
		
		
		this.loanAmount = loanAccount;
		this.loanApplyDate = loanApplyDate;
		this.annualIncome = annualIncome;
		this.companyName = companyName;
		this.designation = designation;
		this.totalExp = totalExp;
		this.expCurrentDate = expCurrentDate;
		this.loanDuration = loanDuration;
		this.user = user;
		
	}
	public HomeLoanDetails(long loanAccount, Date loanApplyDate, long annualIncome, String companyName, String designation, int totalExp, int expCurrentDate,int loanDuration) {
		// TODO Auto-generated constructor stub
		super();
		
		
		
		this.loanAmount = loanAccount;
		this.loanApplyDate = loanApplyDate;
		this.annualIncome = annualIncome;
		this.companyName = companyName;
		this.designation = designation;
		this.totalExp = totalExp;
		this.expCurrentDate = expCurrentDate;
		this.loanDuration = loanDuration;
		
		
	}
	
	

	public HomeLoanDetails(String homeLoanId, String homeLoanAccountNumber, Long loanAmount,
			Date loanApplyDate, long annualIncome, String companyName, String designation, int totalExp,
			int expCurrentDate, UserDetails user,int loanDuration) {
		super();
		this.homeLoanId = homeLoanId;
		
		this.homeLoanAccountNumber = homeLoanAccountNumber;
		this.loanAmount = loanAmount;
		this.loanApplyDate = loanApplyDate;
		this.annualIncome = annualIncome;
		this.companyName = companyName;
		this.designation = designation;
		this.totalExp = totalExp;
		this.expCurrentDate = expCurrentDate;
		this.user = user;
		this.loanDuration = loanDuration;
	}

	public String getHomeLoanId() {
		return homeLoanId;
	}

	public void setHomeLoanId(String homeLoanId) {
		this.homeLoanId = homeLoanId;
	}

	

	

	public String getHomeLoanAccountNumber() {
		return homeLoanAccountNumber;
	}

	public void setHomeLoanAccountNumber(String homeLoanAccountNumber) {
		this.homeLoanAccountNumber = homeLoanAccountNumber;
	}

	public Long getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Long loanAccount) {
		this.loanAmount = loanAccount;
	}

	public Date getLoanApplyDate() {
		return loanApplyDate;
	}

	public void setLoanApplyDate(Date loanApplyDate) {
		this.loanApplyDate = loanApplyDate;
	}

	public long getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(long annualIncome) {
		this.annualIncome = annualIncome;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getTotalExp() {
		return totalExp;
	}

	public void setTotalExp(int totalExp) {
		this.totalExp = totalExp;
	}

	public int getExpCurrentDate() {
		return expCurrentDate;
	}

	public void setExpCurrentDate(int expCurrentDate) {
		this.expCurrentDate = expCurrentDate;
	}
	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}
	public int getLoanDuration() {
		return loanDuration;
	}

	public void setLoanDuration(int loanDuration) {
		this.loanDuration = loanDuration;
	}
	
	

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Override
	public String toString() {
		return "HomeLoanDetails [homeLoanId=" + homeLoanId + ", homeLoanAccountNumber=" + homeLoanAccountNumber
				+ ", loanAmount=" + loanAmount + ", loanApplyDate=" + loanApplyDate + ", annualIncome=" + annualIncome
				+ ", companyName=" + companyName + ", designation=" + designation + ", totalExp=" + totalExp
				+ ", expCurrentDate=" + expCurrentDate + ", loanDuration=" + loanDuration + "]";
	}

	
	

}
