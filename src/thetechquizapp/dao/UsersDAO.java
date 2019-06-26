/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thetechquizapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import thetechquizapp.pojo.Users;
import thetechquizapp.util.DBConnection;


/**
 *
 * @author Vini
 */
public class UsersDAO {
    public static boolean validateUser(Users user) throws SQLException
    {
        String qry="Select * from Users where userid=? and password =? and usertype=?";
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1, user.getUserId());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getUserType());
        ResultSet rs=ps.executeQuery();
        if(rs.next())
        {
            System.out.println("welcome"+rs.getString(1));
            return true;
        }
        else
            return false;
        
     }
    public static boolean addUsers(Users u) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        String qry="select * from Users where userid=?";
        boolean status=true;
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1,u.getUserId());
        ResultSet rs=ps.executeQuery();
                if(rs.next())
                {
                    status=false;
                }
                else
                {
                     qry="insert into Users values(?,?,?)";
                     ps=conn.prepareStatement(qry);
                     ps.setString(1, u.getUserId());
                     ps.setString(2, u.getPassword());
                     ps.setString(3,u.getUserType());
                     ps.executeUpdate();
                    
                }
               return status; 
    }
    public static boolean changePassword(String userid,String password) throws SQLException
    {
        String qry="Update Users set password=? where userid=?";
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1,password);
        ps.setString(2, userid);
        int ans=ps.executeUpdate();
        if(ans!=0)
            return true;
        else
            return false;
    }
    
}
