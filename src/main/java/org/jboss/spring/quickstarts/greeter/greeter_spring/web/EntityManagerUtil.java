package org.jboss.spring.quickstarts.greeter.greeter_spring.web;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil
{
   public static EntityManagerFactory getEntityManagerFactory()
   {
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("hsqldb-ds");
      return emf;
   }
}