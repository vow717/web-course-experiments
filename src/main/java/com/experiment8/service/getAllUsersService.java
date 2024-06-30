package com.experiment8.service;
import com.experiment8.util.DataSourceUtils;
import com.experiment8.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class getAllUsersService {

    public static List<User> getAllUsers(){
        return createUserList();
    }
    private static List<User>createUserList(){
        List<User> usersList = new ArrayList<>();
        String sql="select * from user";
        try(Connection conn= DataSourceUtils.getConnection();
        PreparedStatement ps=conn.prepareStatement(sql)) {
            try(ResultSet rs = ps.executeQuery()){
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                usersList.add(user);
            }
        }
        }catch(SQLException e){
                e.printStackTrace();
        }
        return usersList;
    }
}
