package com.web.jpa.jta;

import com.web.jpa.entity.User;
import java.util.List;
import java.util.Random;
import javax.ejb.Remove;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class UserDao {
    @PersistenceContext(unitName = "demo2")
    EntityManager em;
    public List query() {
        Query q = em.createQuery("SELECT u FROM User u");
        return q.getResultList();
    }
    public void save() {
        User user = new User();
        user.setName("Anita");
        user.setAge(new Random().nextInt(100));
        em.persist(user);
    }
    public void update() {
        User user = em.find(User.class, 1);
        user.setAge(new Random().nextInt(100));
        System.out.println(em.contains(user));
        em.persist(user);
    }
    @Remove
    public void clearup() {
    }
}
