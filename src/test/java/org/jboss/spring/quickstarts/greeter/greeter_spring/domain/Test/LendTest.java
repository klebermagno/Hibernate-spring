package org.jboss.spring.quickstarts.greeter.greeter_spring.domain.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jboss.spring.quickstarts.greeter.greeter_spring.domain.User;
import org.jboss.spring.quickstarts.greeter.greeter_spring.web.EntityManagerUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LendTest {

	 private EntityManager em;

	   @Before
	   public void beforeEach()
	   {
		   EntityManagerFactory emf = Persistence.createEntityManagerFactory("hsqldb-ds");
		   em =  emf.createEntityManager();
	   }

	   @After
	   public void afterEach()
	   {
	     // em.close();
	   }

	   
	@Test
	public void test() {
		 EntityTransaction transaction = em.getTransaction();
	      transaction.begin();
	        try {
	            Query query = em
	                    .createQuery("select u from User u where u.username = ?");
	            query.setParameter(1, "joe");
	            User u = (User)query.getSingleResult();
	        } catch (NoResultException e) {
	            
	        }
	      transaction.commit();
	}

}
