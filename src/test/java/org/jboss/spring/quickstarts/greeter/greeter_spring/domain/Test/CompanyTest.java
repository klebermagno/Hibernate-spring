package org.jboss.spring.quickstarts.greeter.greeter_spring.domain.Test;
import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jboss.spring.quickstarts.greeter.greeter_spring.domain.Company;
import org.jboss.spring.quickstarts.greeter.greeter_spring.domain.CompanyDaoImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CompanyTest {


	private EntityManager em;

	@Before
	public void beforeEach() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hsqldb-ds");
		em = emf.createEntityManager();
	}

	@After
	public void afterEach() {
		em.close();
	}
	
	@Test
	public void createComanyTest() {
		Company company = getComany();
		em.persist(company);

		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Company companyRetrive = null ;
		try {
			Query query = em.createQuery("select c from Company c where c.name = ?");
			query.setParameter(1, "wplex");
			companyRetrive = (Company) query.getSingleResult();
			
			
		} catch (NoResultException e) {
			
		}
		transaction.commit();
		assertEquals(companyRetrive.getName(), "wplex");
		assertEquals(companyRetrive.getInitials(), "wp");
	}
	
	@Test
	public void getForNameTest(){
		CompanyDaoImpl compDao = new CompanyDaoImpl();
		

		compDao.setEntityManager(em);
		
		Company company = getComany();
		em.persist(company);
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		Company companyRetrive = compDao.getForName("wplex");
		transaction.commit();
		
		assertEquals(companyRetrive.getName(), "wplex");
		assertEquals(companyRetrive.getInitials(), "wp");
		
	}
	
	@Test
	public void findAll(){
		
		CompanyDaoImpl compDao = new CompanyDaoImpl();
		

		compDao.setEntityManager(em);
		
		Company company = getComany();
		em.persist(company);
		em.persist(company);
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		List<Company> companies = compDao.findAll();
	
		transaction.commit();
		
		assertEquals(companies.size(),2);
	}

	private Company getComany() {
		Company companyTest = new Company();
		companyTest.setName("wplex");
		companyTest.setInitials("wp");
		return companyTest;
	}

}
