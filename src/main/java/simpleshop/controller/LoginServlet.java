package simpleshop.controller;


import simpleshop.service.Autorization;
import simpleshop.utility.FillDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/")
public class LoginServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        FillDB.initDB();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Get method from Login Servlet");
        resp.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Post method from Login Servlet");
        new Autorization().autorization(req.getParameter("login"), req.getParameter("password"));
        req.getSession().setAttribute("wrong", "Wrong login and/or password");
        resp.sendRedirect("login.jsp");

//        if (req.getParameter("login").equals("client")) resp.sendRedirect("client.jsp");
//        if (req.getParameter("password").equals("manager")) resp.sendRedirect("manager.jsp");
//        else req.setAttribute("wrong", "Wrong login and/or password");

    }
}
