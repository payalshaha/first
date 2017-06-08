package com.cog.test;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cognizant.entity.HomeLoanDetails;
import com.cognizant.entity.UserDetails;
import com.cognizant.service.ViewHomeLoanService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class ViewHomeLoanTest {

	@Autowired
	ViewHomeLoanService homeLoanService; 
	
	/*  @Test
	public void test() {
		fail("Not yet implemented");
	}
	*/
	@Before
	public void setup(){
		
		
		 
	}
	@Test
	public void viewHomeLoanTest()
	{
		homeLoanService.retrieveUserHomeLoanDetails(4161000100125568l);
		assert(true);
		
	}
	
	

}
