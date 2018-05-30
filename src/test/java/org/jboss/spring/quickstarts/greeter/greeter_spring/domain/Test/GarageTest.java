package org.jboss.spring.quickstarts.greeter.greeter_spring.domain.Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jboss.spring.quickstarts.greeter.greeter_spring.domain.Company;
import org.jboss.spring.quickstarts.greeter.greeter_spring.domain.Garage;
import org.jboss.spring.quickstarts.greeter.greeter_spring.domain.GarageDaoImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GarageTest {

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
	public void getForCompanyId(){
		GarageDaoImpl garageDao = new GarageDaoImpl();
		

		garageDao.setEntityManager(em);
		
		Garage garage = getGarage();
		em.persist(garage);
		em.persist(garage);
		List<Company> companies = garage.getCompany();
		List companiesId = new ArrayList<String>();
		
		for (Company company : companies) {
			companiesId.add(company.getId().toString());
		}
		
	
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		 List<Garage> garages = garageDao.getForCompanyId((String)companiesId.get(0));
		 
		transaction.commit();
		
		assertEquals(2, garages.size());
		
		for (Garage g : garages) {
			
			assertEquals(2, g.getCompany().size());
		}
		
		
	
		
	}
	
	@Test
	public void createGarage(){
		Garage garage = getGarage();
		em.persist(garage);

		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		Garage garageRetrive = null ;
		try {
			Query query = em.createQuery("select g from Garage g where g.name = ?");
			query.setParameter(1, "SC-401");
			garageRetrive = (Garage) query.getSingleResult();
			
			
		} catch (NoResultException e) {
			
		}
		transaction.commit();
		assertEquals(garageRetrive.getName(), "SC-401");
		assertEquals(garageRetrive.getInitials(), "sc");
	}

	private Garage getGarage() {
		Garage garareTest = new Garage();
		garareTest.setName("SC-401");
		garareTest.setInitials("sc");
		List<Company> l = new ArrayList<Company>();
		l.add(getComany());
		l.add(getComany());
		
		return garareTest;
	}
	
	public static Company getComany() {
		Company companyTest = new Company();
		companyTest.setName("wplex");
		companyTest.setInitials("wp");
		return companyTest;
	}
    
}
