package com.cognizant.dao;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.entity.EducationLoanDetails;
import com.cognizant.entity.UserDetails;

@Component
public class ViewEducationLoanDAO {
	
	@PersistenceContext
    private EntityManager em;
	
	static Logger logger = Logger.getLogger(ViewEducationLoanDAO.class);


	@Transactional
	public UserDetails retrieveEducationLoanDetails(long accountNumber) {
		// TODO Auto-generated method stub
		
		/*EducationLoanDetails eld=em.find(EducationLoanDetails.class,loanAccountNumber);*/
		UserDetails ud=em.find(UserDetails.class,accountNumber);
		List<EducationLoanDetails> eldList=ud.getHld();
		logger.warn("User details are : "+ud);
		logger.warn("Education loan details are : "+eldList);
		return ud;
	}
}