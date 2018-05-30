package org.jboss.spring.quickstarts.greeter.greeter_spring.domain;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GarageDaoImpl implements GarageDao{

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Garage getForName(String name) {
        try {
       	Query query = entityManager.createQuery("select g from Garage g where g.name = ?");
          query.setParameter(1, name);
        	
            return (Garage) query.getSingleResult(); 
        } catch (NoResultException e) {
            return null;
        }
    	
    }
    

	@Transactional
    public List<Garage> getForCompanyId(String companyId) {
        try {
        	Query query = entityManager.createQuery("select g from Garage g where g.company_id = ?");
            query.setParameter(1, companyId);
            return (List<Garage>) query.getSingleResult(); 
        } catch (NoResultException e) {
            return null;
        }
    	
    }
    @Transactional
    public void createGarage(Garage garage) {
        entityManager.persist(garage);
    }
    
    public void setEntityManager(EntityManager em){
    	entityManager = em;
    }


}
