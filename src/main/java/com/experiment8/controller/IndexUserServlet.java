package com.experiment8.controller;

import com.experiment8.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import com.experiment8.service.getAllUsersService;

@WebServlet("/experiment8/index")
public class IndexUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        List<User> users=getAllUsersService.getAllUsers();
        System.out.println("I am coming");
        req.setAttribute("users",users);
        req.getRequestDispatcher("/WEB-INF/jsp/E8/index.jsp").forward(req,resp);

    }
}
