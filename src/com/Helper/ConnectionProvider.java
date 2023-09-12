package com.Helper;

import java.sql.*;

public class ConnectionProvider {
    private static Connection con;
    public static Connection getConnection()
    {
        try
        {
            if(con==null)
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/bankmanagementsystem";
                String username= "root";
                String password="Pratik@123";
                
                con = DriverManager.getConnection(url,username,password);
            }
        }catch(ClassNotFoundException | SQLException e)
        {e.printStackTrace();}
        return con; 
    }
}
