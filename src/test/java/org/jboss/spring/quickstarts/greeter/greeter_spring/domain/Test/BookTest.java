package org.jboss.spring.quickstarts.greeter.greeter_spring.domain.Test;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jboss.spring.quickstarts.greeter.greeter_spring.domain.Book;
import org.jboss.spring.quickstarts.greeter.greeter_spring.domain.Lend;
import org.jboss.spring.quickstarts.greeter.greeter_spring.domain.Rating;
import org.jboss.spring.quickstarts.greeter.greeter_spring.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BookTest {

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
	      em.close();
	   }

	   
	@Test
	public void test() {
		
		Lend l = new Lend();
		User user = UserTest.getUser();
		em.persist(user);
		
		l.setUser(user);
		
		Book b = getBook();
		em.persist(b);
		
		Set<Book> books = new HashSet();
		books.add(b);

		l.setBooks(books );
		l.setLendDate(new Date(2016, 07, 31));
		
		em.persist(l);
		
		 EntityTransaction transaction = em.getTransaction();
	      transaction.begin();
	      Book book = null;
	        try {
	            Query query = em
	                    .createQuery("select b from Book b where b.name = ?");
	            query.setParameter(1, "BookTest");
	             book = (Book)query.getSingleResult();
	        } catch (NoResultException e) {
	            
	        }
	      transaction.commit();
	      assertEquals(book.getName(), "BookTest");
	      assertEquals(book.getRating(), Rating.PG13);
	}

	public static Book getBook() {
		Book b = new Book();
		b.setEditionDate(new Date(1981, 07, 31));
		b.setName("BookTest");
		b.setRating(Rating.PG13);
		b.setWriter("Writer");
		return b;
	}



}
