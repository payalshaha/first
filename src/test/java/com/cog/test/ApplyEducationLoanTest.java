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

import com.cognizant.dao.ApplyEducationLoanDAO;
import com.cognizant.entity.EducationLoanDetails;
import com.cognizant.entity.UserDetails;
import com.cognizant.service.ApplyEducationLoanService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class ApplyEducationLoanTest {
	
	
	UserDetails ud=new UserDetails();
	
	EducationLoanDetails eld=new EducationLoanDetails();
	EducationLoanDetails eld1=new EducationLoanDetails();
	EducationLoanDetails eld2=new EducationLoanDetails();
	EducationLoanDetails eld3=new EducationLoanDetails();
	EducationLoanDetails eld4=new EducationLoanDetails();
	
	@Autowired
	ApplyEducationLoanDAO eduLoanDAO;
	@Autowired
	ApplyEducationLoanService els;
	
	
	
	@Before
	public void setup(){
		
		ud=new UserDetails(4161000100125567l, "Salary","Rohit",15000.0);
		/*Date d=new Date(0);
		List<EducationLoanDetails> eduList=new ArrayList<>();
		ud=new UserDetails(4161000100125569l, "Salary","Virat",15000.0);
		eld=new EducationLoanDetails("EL_12345","1234567890123456",50000, d, 10, 500000, 80000, "MBA",ud, "Father", 1234567890123452l);
		eld1=new EducationLoanDetails(20000l, d, 5,200000l, 50000, "MBA","FatherA",1234567891234567l);
		eduList.add(eld);
		ud.setHld(eduList);*/
		Date d=new Date(0);
		eld1=new EducationLoanDetails(90000l, d,10,100000l, 60000, "MBA","Mr G",3789467891234567l);
		eld2=new EducationLoanDetails(20000l, d,5,200000l, 50000, "Eng","Om Prakash2",7845667891234567l);
		eld3=new EducationLoanDetails(50000l, d,5,200000l, 5000000, "Eng","Om Prakash",7845667891234567l);
		eld4=new EducationLoanDetails(50000l, d,3,200000l, 10000, "Eng","Om Prakash",7845667891234567l);
	}
	//@Test
	public void addUser() {
		
		
		
	eduLoanDAO.addUser(ud);
	
		
	}
	
	@Test
	public void applyEducationLoan(){
		
		els.insertEducationLoanDetails(eld1);
	}
	
	//@Test
	public void applyEducationLoanNegativeName(){
		
		els.insertEducationLoanDetails(eld2);
	}
	
	//@Test
	public void applyEducationLoanNegativeCourseFee(){
		
		els.insertEducationLoanDetails(eld3);
	}
	
	//@Test
	public void applyEducationLoanNegativeLoanDuration(){
		
		els.insertEducationLoanDetails(eld4);
	}
	
	
	
	
	
	
}