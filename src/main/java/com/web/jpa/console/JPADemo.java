package com.web.jpa.console;

import com.web.jpa.entity.User;
import com.web.jpa.jta.UserDao;
import java.util.Random;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPADemo {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        User user = em.find(User.class, 1);
        user.setAge(100);
        //User user = new User("demo", new Random().nextInt(100));
        em.persist(user);
        System.out.println(em.contains(user));
        em.getTransaction().commit();
        System.out.println(em.createQuery("SELECT u FROM User u").getResultList());
        
        em.detach(user);
        //em.getTransaction().begin();
        user.setAge(300);
        em.persist(user);
        //em.getTransaction().commit();
        System.out.println(em.createQuery("SELECT u FROM User u").getResultList());
        
        
        em.close();
        
//        em = emf.createEntityManager();
//        System.out.println(em.contains(user));
//        em.getTransaction().begin();
//        user.setAge(200);
//        em.merge(user);
//        em.getTransaction().commit();
//        System.out.println(em.createQuery("SELECT u FROM User u").getResultList());
//        em.close();
    }
}