package org.jboss.spring.quickstarts.greeter.greeter_spring.domain;

import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LendDaoImpl implements LendDao {

	@Autowired
	private EntityManager entityManager;

	@Transactional
	public Lend CreateLend(Lend lend) {
		
		try {
			Query query = entityManager.createQuery("select u from User u where u.username = ?");
			//query.setParameter(1, username);
			// (User) query.getSingleResult();
		} catch(NoResultException e){
			
		}
		
		entityManager.persist(lend);
		return lend;
	}




}
