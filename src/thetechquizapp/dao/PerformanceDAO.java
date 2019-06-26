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
import java.util.ArrayList;
import thetechquizapp.pojo.Performance;
import thetechquizapp.pojo.StudentScore;
import thetechquizapp.util.DBConnection;

/**
 *
 * @author Vini
 */
public class PerformanceDAO {
    public static ArrayList <String> getAllStudentId() throws SQLException
    {
        String qry="Select distinct userid from Performance";
        ArrayList <String> studentIdList=new ArrayList<>();
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(qry);
        while(rs.next())
                {
                    String id=rs.getString(1);
                    studentIdList.add(id);
                }
        return studentIdList;
        
    }
    public static ArrayList <String> getAllExamId(String studentId) throws SQLException
    {
        String qry="select examid from Performance where userid=?";
        ArrayList <String> examIdList=new ArrayList<>();
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1,studentId);
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
            String id=rs.getString(1);
            examIdList.add(id);
        }
        return examIdList;
        
    }
    public static StudentScore getScore(String studentId,String examId) throws SQLException
    {
        String qry="Select language,percentage from Performance where userid=? and examid=?";
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1,studentId);
        ps.setString(2,examId);
        ResultSet rs=ps.executeQuery();
        rs.next();
        StudentScore scoreobj=new StudentScore();
        scoreobj.setLanguage(rs.getString(1));
        scoreobj.setPer(rs.getDouble(2));
        return scoreobj;
    }
    public static ArrayList <Performance> getAllData() throws SQLException
    {
        String qry="select * from Performance";
        ArrayList <Performance> performanceList=new ArrayList <>();
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(qry);
        while(rs.next())
        {
            String userid=rs.getString("userid");
            String examid=rs.getString("examid");
            int right=rs.getInt("right");
            int wrong=rs.getInt("wrong");
            int unattempted=rs.getInt("unattempted");
            double per=rs.getDouble("percentage");
            String language=rs.getString("language");
            Performance p=new Performance(userid, examid, right, wrong, unattempted, per, language);
            performanceList.add(p);    
        }
        return performanceList;
    }
    public static void addPerformance(Performance performance) throws SQLException
    {
        String qry="insert into performance values (?,?,?,?,?,?,?) ";
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1, performance.getUserid());
        ps.setString(2, performance.getExamid());
        ps.setInt(3, performance.getRight());
        ps.setInt(4, performance.getWrong());
        ps.setInt(5, performance.getUnattempted());
        ps.setDouble(6, performance.getPer());
        ps.setString(7,performance.getLanguage());
        ps.executeUpdate();
        
    }
    
}
