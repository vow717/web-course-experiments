package com.experiment7.controller;

import com.experiment7.entity.User;
import com.experiment7.util.DataSourceUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

@WebServlet("/experiment7/getuser")
public class GetUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user=null;
        String sql="select * from user where id=?";
        try(Connection conn= DataSourceUtils.getConnection();
            PreparedStatement ps= conn.prepareStatement(sql)){
            ps.setString(1,req.getParameter("uid"));
            try(ResultSet rs= ps.executeQuery()){
                while(rs.next()){
                    user = new User();
                    user.setId(rs.getString("id"));
                    user.setName(rs.getString("name"));
                    user.setInsertTime(rs.getObject("insert_time",LocalDateTime.class));
                }
            }
            }catch (SQLException e){
                e.printStackTrace();
            }
            req.setAttribute("user",user);
            req.getRequestDispatcher("/WEB-INF/jsp/E7/query.jsp").forward(req,resp);
        }

}
