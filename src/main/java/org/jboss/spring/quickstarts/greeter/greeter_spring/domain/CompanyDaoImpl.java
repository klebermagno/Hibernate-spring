 package org.jboss.spring.quickstarts.greeter.greeter_spring.domain;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CompanyDaoImpl implements CompanyDao {

	    @Autowired
	    private EntityManager entityManager;

	    @Transactional
	    public Company getForName(String name) {
	        try {
	        	Query query = entityManager.createQuery("select c from Company c where c.name = ?");
	            query.setParameter(1, name);
	            return (Company) query.getSingleResult(); 
	        } catch (NoResultException e) {
	            return null;
	        }
	    	
	    }
	    
	    @Transactional
	    public List<Company> findAll() {
	        try {
	        	Query query = entityManager.createQuery("select c from Company c ");
	            
	            return (List<Company>) query.getSingleResult(); 
	        } catch (NoResultException e) {
	            return null;
	        }
	    	
	    }

	    @Transactional
	    public void createCompany(Company company) {
	        entityManager.persist(company);
	    }
	    
	    public void setEntityManager(EntityManager em){
	    	entityManager = em;
	    }

	    
}
