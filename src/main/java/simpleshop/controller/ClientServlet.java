package simpleshop.controller;

import simpleshop.entity.Product;
import simpleshop.service.DAO;
import simpleshop.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/client")
public class ClientServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Post method from Client Servlet"); // for log
        List<Product> products = new ProductService(DAO.getInstance()).findAll();
        req.setAttribute("products", products );
        req.getRequestDispatcher("client.jsp").forward(req, resp);
    }
}
