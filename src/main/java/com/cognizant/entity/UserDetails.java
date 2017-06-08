package com.cognizant.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.IndexColumn;
import org.springframework.stereotype.Component;

@Entity

/*@Table(name="USER_DETAILS")*/
public class UserDetails {
	@Id
	Long accountNumber;
	String accountType;
	String accountHolderName;
	Double accountBalance;
	/*@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	List<TransactionDetails> trans;*/
	
	
	
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL, fetch=FetchType.EAGER) @Fetch(FetchMode.SELECT)
	List<HomeLoanDetails> homeloan;
	
	@OneToMany(mappedBy="user" ,cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<EducationLoanDetails> hld;
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	//@IndexColumn(name="INDEX_COL")
	List<TransactionDetails> trans;
	
	
	public UserDetails()
	{
	}
	public UserDetails(Long accountNumber, String accountType, String accountHolderName, Double accountBalance) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.accountHolderName = accountHolderName;
		this.accountBalance = accountBalance;
	}
	public UserDetails(Long accountNumber, String accountType, String accountHolderName, Double accountBalance,
			List<HomeLoanDetails> homeloan) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.accountHolderName = accountHolderName;
		this.accountBalance = accountBalance;
		this.homeloan = homeloan;
	}
	
	/*
	public UserDetails(Long accountNumber, String accountType, String accountHolderName, Double accountBalance,
			List<EducationLoanDetails> hld) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.accountHolderName = accountHolderName;
		this.accountBalance = accountBalance;
		this.hld = hld;
	}*/
	
	public UserDetails(long accountNumber, String accountType, String accountHolderName, double accountBalance,
			List<TransactionDetails> trans) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.accountHolderName = accountHolderName;
		this.accountBalance = accountBalance;
		this.trans = trans;
	}
	
	
/*	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)*/
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public Double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public List<HomeLoanDetails> getHomeloan() {
		return homeloan;
	}
	public void setHomeloan(List<HomeLoanDetails> homeloan) {
		this.homeloan = homeloan;
	}
	public List<EducationLoanDetails> getHld() {
		return hld;
	}

public void setHld(List<EducationLoanDetails> hld) {
		this.hld = hld;
	}
public List<TransactionDetails> getTrans() {
	return trans;
}

public void setTrans(List<TransactionDetails> trans) {
	this.trans = trans;
}
	@Override
	public String toString() {
		return "UserDetails [accountNumber=" + accountNumber + ", accountType=" + accountType + ", accountHolderName="
				+ accountHolderName + ", accountBalance=" + accountBalance + "]";
	}
	
	
	
	

}
