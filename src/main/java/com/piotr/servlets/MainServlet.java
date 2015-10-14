package com.piotr.servlets;

import com.piotr.dao.UserDAO;
import com.piotr.dao.impl.UserDAOImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Created by Piotr on 10/10/2015.
 */
@WebServlet(urlPatterns = {"/", "/main"})
public class MainServlet extends HttpServlet {
    //validacja po stronie servera + klienta
    //zrob tak, zeby kazdy nowy User z formy mial unique id, np. za pomoca statycznej zmiennej w klasie user
    private UserDAO userDAO = new UserDAOImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String confirmEmail = req.getParameter("confirmEmail");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/index.jsp");
        requestDispatcher.forward(req,resp);

    }
}
