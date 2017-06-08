package com.cognizant.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.entity.HomeLoanDetails;
import com.cognizant.entity.UserDetails;


@Component
public class ViewHomeLoanDAO {
	@PersistenceContext
    private EntityManager em;
	
	static Logger logger = Logger.getLogger(ViewHomeLoanDAO.class);

	
	UserDetails user = new UserDetails();
	
	@Transactional
	public UserDetails retrieveUserHomeLoanDetails(long accountNumber)
	{
		//List<HomeLoanDetails> homeloan=new ArrayList<HomeLoanDetails>();
		
		UserDetails home=em.find(UserDetails.class, accountNumber);
		//UserDetails user = em.find(UserDetails.class, home.getAccountNumber());
		//List<HomeLoanDetails> details = home.getHomeloan();
		logger.debug("User details in ViewHomeLoanDAO are :"+home);
		//System.out.println(details);
		//homeloan.add(home);
		//user.setHomeloan(homeloan);
		return home;
	}

}
