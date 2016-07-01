package org.jboss.spring.quickstarts.greeter.greeter_spring.domain.Test;

import static org.junit.Assert.*;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jboss.spring.quickstarts.greeter.greeter_spring.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserTest {

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
	public void createUsertest() {
		User user = getUser();
		em.persist(user);

		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		User u = null ;
		try {
			Query query = em.createQuery("select u from User u where u.username = ?");
			query.setParameter(1, "klebermagno");
			u = (User) query.getSingleResult();
			
			
		} catch (NoResultException e) {

		}
		transaction.commit();
		assertEquals(u.getFirstName(), "Kleber");
		assertEquals(u.getBirthDay(),new Date(1981, 07, 31));
	}

	public static User getUser() {
		User user = new User();
		user.setFirstName("Kleber");
		user.setUsername("klebermagno");
		user.setBirthDay(new Date(1981, 07, 31));
		user.setLastName("Vieira");
		user.setCPF("00000000000");
		return user;
	}

}
