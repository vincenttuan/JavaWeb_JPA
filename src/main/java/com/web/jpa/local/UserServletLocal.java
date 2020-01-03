package com.web.jpa.local;

import com.web.jpa.entity.User;
import java.io.IOException;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user/servlet/local")
public class UserServletLocal extends HttpServlet {
    
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");
    EntityManager em = emf.createEntityManager();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/plain;charset=utf-8");
        EntityManager em = emf.createEntityManager();
        try {
            resp.getWriter().println(em);
            em.getTransaction().begin();
            em.persist(new User("vin", new Random().nextInt(100)));
            em.getTransaction().commit();
            resp.getWriter().println(em.createQuery("SELECT u FROM User u").getResultList());
        } catch (Exception e) {
            e.printStackTrace(resp.getWriter());
        }
        
    }
    
    
}
