package com.experiment6.controller;

import com.experiment6.util.DatabaseUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/experiment6/listteachers")
public class ListTeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("teachers", DatabaseUtils.listTeachers());
        req.getRequestDispatcher("/WEB-INF/jsp/listteachers.jsp")
                .forward(req, resp);
    }
}
