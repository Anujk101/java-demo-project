/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thetechquizapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Vini
 */
public class DBConnection {
    private static Connection conn;
    static
    {
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
            conn=DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-SR9NL2C:1521/xe","onlineexam","student");
            JOptionPane.showMessageDialog(null,"Successfully connectd to the DB","Success !",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Error : "+ex,"Error !",JOptionPane.ERROR_MESSAGE);
        }
        
    }
    public static Connection getConnection()
    {
        return conn;   
    }
    public static void closeConnection()
    {
        if(conn!=null)
        {
            try
            {
                conn.close();
                JOptionPane.showMessageDialog(null,"Successfully disconnectd to the DB","Success !",JOptionPane.INFORMATION_MESSAGE);
            }
            catch(SQLException ex)
            {
                JOptionPane.showMessageDialog(null,"Error : "+ex,"Error !",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
