package com.cognizant.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.entity.Employee;
import com.cognizant.entity.HomeLoanDetails;
import com.cognizant.entity.UserDetails;

@Component
public class ApplyHomeLoanDAO {
	
	@PersistenceContext
    private EntityManager em;
	static Logger logger = Logger.getLogger(ApplyHomeLoanDAO.class);
	
        @Transactional	
 	    public boolean applyHomeLoanUserDetails(UserDetails ud)
	    {
				logger.debug("In ApplyHomeLoanDAO in applyHomeLoanUserDetails method  ");
				em.persist(ud);
				
					
	    	
	    	return true;
	    }
	    
        public long insertHomeLoanDetails(UserDetails user)
        {
        	
        	
        	
        	return 3l;
        }
        
        public UserDetails gettHomeLoanUserDetails(long accountNumber)
        {
        	
        	UserDetails ud = em.find(UserDetails.class, accountNumber);
    		return ud;
        	
        	
        	
        }
	
	
	

}
