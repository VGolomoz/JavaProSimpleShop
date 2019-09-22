package simpleshop.controller;

import simpleshop.entity.User;
import simpleshop.utility.FillDB;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Get method from Login Servlet");

        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("SimpleShop");
        EntityManager em = emFactory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            User client = new User("client", "client", "client");
            em.persist(client);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive())
                transaction.rollback();
            throw new RuntimeException(e);
        }

        resp.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getAttribute("user").equals("client")) resp.sendRedirect("client.jsp");
        if (req.getAttribute("user").equals("manager")) resp.sendRedirect("manager.jsp");
        //else req.setAttribute("wrong");

    }
}
