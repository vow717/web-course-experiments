package com.experiment8.controller;

import com.experiment8.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.experiment8.service.getOneUserService;
import java.io.IOException;

@WebServlet("/experiment8/query")
public class QueryUserSevlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("uid");
        User user=getOneUserService.getOneUser(id);
        req.setAttribute("user",user);
        req.getRequestDispatcher("/WEB-INF/jsp/E8/query.jsp").forward(req,resp);
    }
}
