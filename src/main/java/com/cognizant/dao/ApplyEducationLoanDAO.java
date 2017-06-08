package com.cognizant.dao;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.entity.EducationLoanDetails;
import com.cognizant.entity.Employee;
import com.cognizant.entity.UserDetails;

@Component
public class ApplyEducationLoanDAO {
	
	static Logger logger = Logger.getLogger(ApplyEducationLoanDAO.class);
	 @PersistenceContext
	    private EntityManager em;
	
	@Transactional
	public void addUser(UserDetails ud) {
		
		em.persist(ud);
		// TODO Auto-generated method stub
		
	}

	public UserDetails getUserDetails(long accountNumber) {
		// TODO Auto-generated method stub
		
		logger.warn("Account Number is : "+accountNumber);
		UserDetails user = em.find(UserDetails.class, accountNumber);
		logger.debug(user);
		
		return user;
		
	}
	
}