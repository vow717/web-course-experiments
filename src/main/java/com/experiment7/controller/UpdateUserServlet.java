package com.experiment7.controller;

import com.experiment7.util.DataSourceUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/experiment7/update")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("uid");
        String newName=req.getParameter("newName");
        String sql="update user set name=? where id=?";
        try(Connection conn= DataSourceUtils.getConnection();
            PreparedStatement ps=conn.prepareStatement(sql)){
            ps.setString(1,newName);
            ps.setString(2,id);
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        resp.sendRedirect(req.getContextPath()+"/experiment7/index");
    }
}
