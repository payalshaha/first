package com.cog.test;


import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cognizant.dao.PerformTransactionDAO;
import com.cognizant.entity.TransactionDetails;
import com.cognizant.entity.UserDetails;
import com.cognizant.service.PerformTransactionService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class TestUserDetails {
	

	
	@Autowired
	PerformTransactionDAO performtransaction;
	
	@Autowired
	PerformTransactionService service;
	
	UserDetails user1;
	
	
	@Before
	public void setup(){
		 user1 = new UserDetails(1234l,"savings","sangha", 34344.44);
		TransactionDetails trans1=new TransactionDetails(10l,"test","deposit",5000.00,user1);
		List<TransactionDetails> trans=new ArrayList<TransactionDetails>();
		trans.add(trans1);
		user1.setTrans(trans);
	}
	
	
		
		
		
		
	//@Test
		public void addUser(){
			UserDetails user1 = new UserDetails(9876543212345678l,"savings","shubham", 80000.00);
			//UserDetails user1 = new UserDetails(5432167890987654l,"salary","anant", 80000.00);
			service.addSingleUser(user1);
			
		}
		
		
	//@Test
	public void addUserDetails(){
		UserDetails user1 = new UserDetails(9876543212345678l,"savings","shubbham", 50000.00);
		TransactionDetails trans=new TransactionDetails("test","deposit",5000.00);
		service.addUser(user1,trans);
		
	}
	@Test
	public void transactionDeposit(){
		long acc=9876543212345678l;
		
		/*boolean isdeposit=false;*/
		TransactionDetails trans1=new TransactionDetails("test","deposit",5000.00);
		service.performTransaction(acc,trans1);
		
		}
	
	//@Test
	/*public void transactionWithdrawal(){
		long acc=1234l;
		double amt=10000.00;
		boolean isdeposit=false;
		TransactionDetails trans1=new TransactionDetails(8l,"test",false);
		service.performTransaction(acc,amt,trans1);
		
		}*/
	//@Test
	public void retriveDetails(){
		long acc=1234123456789876l;
		service.retriveDetails(acc);
	}
	
	//@Test
		public void transactionDepositNegativeType(){
			long acc=9876543212345678l;
			
			
			TransactionDetails trans1=new TransactionDetails("test","blah",5000.00);
			service.performTransaction(acc,trans1);
			
			}
	
	//@Test
	public void transactionDepositNegativeAmount(){
		long acc=9876543212345678l;
		
		
		TransactionDetails trans1=new TransactionDetails("test","withdrawal",51000.00);
		service.performTransaction(acc,trans1);
		
		}
	
//	@Test
	public void NegativeAccountBalance(){
		UserDetails user1 = new UserDetails(9876543212345678l,"savings","shubham", 2000.00);
		//UserDetails user1 = new UserDetails(5432167890987654l,"salary","anant", 80000.00);
		service.addSingleUser(user1);
		
	}
	
}
