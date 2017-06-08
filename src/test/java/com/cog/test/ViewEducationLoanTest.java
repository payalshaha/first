package com.cog.test;
import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cognizant.dao.ViewEducationLoanDAO;
import com.cognizant.entity.EducationLoanDetails;
import com.cognizant.entity.UserDetails;
import com.cognizant.service.ViewEducationLoanService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class ViewEducationLoanTest {
	
	@Autowired
	ViewEducationLoanService vls;

	
	
	/*@Before
	public void setup(){
		viewdao=new ViewEducationLoanDAO();
	}*/
	@Test
	public void viewLoanDao() {
		
	 
		vls.retrieveEducationLoanDetails(4161000100125568l);
		
	}
}