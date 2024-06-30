package com.experiment8.service;
import com.experiment8.entity.User;
import com.experiment8.util.DataSourceUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class getOneUserService {
    private static User createUser(String idStr){
        int id=Integer.parseInt(idStr);
        User user=new User();
        String sql = "select * from user where id = ?";
        try(Connection conn= DataSourceUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,id);
            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    user.setId(rs.getInt("id"));
                    user.setName(rs.getString("name"));
                    user.setInsertTime(rs.getObject("insert_time",LocalDateTime.class));
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }
    public static User getOneUser(String id){
        return createUser(id);
    }
}
