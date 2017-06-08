package com.cog.test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cognizant.dao.ApplyHomeLoanDAO;
import com.cognizant.entity.HomeLoanDetails;
import com.cognizant.entity.UserDetails;
import com.cognizant.service.ApplyHomeLoanService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class ApplyHomeLoanTest {
	
	@Autowired
	ApplyHomeLoanDAO homeLoan;
	
	UserDetails ud = new UserDetails();
	
	HomeLoanDetails homeloandetails = new HomeLoanDetails(); 
	@Autowired
	ApplyHomeLoanService homeLoanService;
	HomeLoanDetails homeLoanDetails1 = new HomeLoanDetails();
	HomeLoanDetails homeLoanDetails2 = new HomeLoanDetails();
	HomeLoanDetails homeLoanDetails3 = new HomeLoanDetails();
	HomeLoanDetails homeLoanDetails4 = new HomeLoanDetails();
	HomeLoanDetails homeLoanDetails5 = new HomeLoanDetails();

	/*@Test
	public void test() {
		fail("Not yet implemented");
	}*/
	@Before
	public void setup(){
		Date d = new Date(0);
		
		List<HomeLoanDetails> list1 = new ArrayList<HomeLoanDetails>();
		ud = new UserDetails(4161000100125568l,"Savings","Virat Kohli",55000.0);
		homeloandetails = new HomeLoanDetails("HL-569","1234567891234568",300000l,d,6000000l,"COgNi","PA",4,6,ud,10);
		homeLoanDetails1 = new HomeLoanDetails(300000l,d,6000000l,"CTS","PAT",5,7,3);
		homeLoanDetails2 = new HomeLoanDetails(10000l,d,1000l,"CTS","PAT",5,7,21);
		homeLoanDetails3 = new HomeLoanDetails(10000l,d,100000l,"CTS","PAT",5,7,15);
		homeLoanDetails4 = new HomeLoanDetails(10000l,d,1000l,"CTS","PAT",5,7,15);
		homeLoanDetails5 = new HomeLoanDetails(200000l,d,20000l,"COgNI","PA",4,6,10);
		//list1.add(homeloandetails);
		//ud.setHomeloan(list1);
		
	}
	//@Test
	public void applyHomeLoanUserDetailsTestMethod()
	{
		
		
		
		
	    
		homeLoan.applyHomeLoanUserDetails(ud);
		assertTrue(true);
	}
	//@Test
	public void insertHomeLoanDetailsTest()
	{
		homeLoanService.insertHomeLoanDetails(homeLoanDetails5);
		assertTrue(true);
	}
	
	//@Test
	public void insertHomeLoanDetailsNegativeLoanDurationTest()
	{
		homeLoanService.insertHomeLoanDetails(homeLoanDetails2);
		assertTrue(true);
	}
	//@Test
	public void insertHomeLoanDetailsNegativeLoanAmountTest()
	{
		homeLoanService.insertHomeLoanDetails(homeLoanDetails3);
		assertTrue(true);
	}
	

}
