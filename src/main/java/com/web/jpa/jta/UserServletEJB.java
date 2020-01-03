package com.web.jpa.jta;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user/servlet/ejb")
public class UserServletEJB extends HttpServlet {

    @EJB
    UserDao dao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/plain;charset=utf-8");
        resp.getWriter().println(dao);

        //dao.save();
        dao.update();
        resp.getWriter().println(dao.query());

    }
}
