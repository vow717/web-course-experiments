package com.experiment7.controller;

import com.experiment7.util.DataSourceUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.stream.Collectors;

@WebServlet("/experiment7/delete")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String sql="delete from user where name=?";
        try(Connection conn = DataSourceUtils.getConnection();
            PreparedStatement ps =conn.prepareStatement(sql)){
            ps.setString(1,name);
            int rowsAffected = ps.executeUpdate();
            System.out.println(rowsAffected);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect(req.getContextPath()+"/experiment7/index");
    }
}
