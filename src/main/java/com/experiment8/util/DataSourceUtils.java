package com.experiment8.util;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import java.sql.Connection;
import javax.sql.DataSource;
import java.sql.SQLException;


@WebListener
public class DataSourceUtils implements ServletContextListener {
    @Resource(name = "jdbc/MySQL")
    private static DataSource dSource;
    public static Connection getConnection() throws SQLException{
        return dSource.getConnection();
    }
}
