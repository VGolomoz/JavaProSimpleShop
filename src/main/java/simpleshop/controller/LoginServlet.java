package simpleshop.controller;


import simpleshop.service.Autorization;
import simpleshop.service.DAO;
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
        System.out.println("Get method from Login Servlet"); // for log
        resp.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Post method from Login Servlet"); // for log
        String result = new Autorization(DAO.getInstance()).autorization(req.getParameter("login"), req.getParameter("password"));

        if (result.equals("wrong")) {
            req.getSession().setAttribute("wrong", "Wrong login and/or password");
            resp.sendRedirect("login.jsp");
        } else req.getRequestDispatcher(result).forward(req, resp);
    }
}
