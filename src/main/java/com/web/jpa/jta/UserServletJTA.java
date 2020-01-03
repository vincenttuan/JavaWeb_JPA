package com.web.jpa.jta;

import com.web.jpa.entity.User;
import java.io.IOException;
import java.util.Random;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

@WebServlet("/user/servlet/jta")
public class UserServletJTA extends HttpServlet {
    
    @PersistenceUnit(name = "demo2")
    EntityManagerFactory emf;
    
    @Resource 
    UserTransaction tx;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/plain;charset=utf-8");
        EntityManager em = emf.createEntityManager();
        try {
            resp.getWriter().println(em);
            resp.getWriter().println(tx);
            tx.begin();
            em.joinTransaction(); // JTA 版 Servlet 一定要加
            em.persist(new User("vin", new Random().nextInt(100)));
            tx.commit();
            resp.getWriter().println(em.createQuery("SELECT u FROM User u").getResultList());
        } catch (Exception e) {
            e.printStackTrace(resp.getWriter());
        }
        
    }
    
    
}
