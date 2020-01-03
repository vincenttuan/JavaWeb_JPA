package com.web.jpa.console;

import com.web.jpa.entity.User;
import com.web.jpa.jta.UserDao;
import java.util.List;
import java.util.Random;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JPADemoNamedQuery {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");
        EntityManager em = emf.createEntityManager();
        
        List list = em.createNamedQuery("User.findAll").getResultList();
        System.out.println(list);
        
        Query query = em.createNamedQuery("User.findByName");
        query.setParameter("name", "demo");
        System.out.println(query.getResultList());
        
        em.close();
  
    }
}