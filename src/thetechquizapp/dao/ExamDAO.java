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
import thetechquizapp.pojo.Exam;
import thetechquizapp.util.DBConnection;

/**
 *
 * @author Vini
 */
public class ExamDAO {
    public static String getExamId() throws SQLException
    {
        String qry="select count (*) as totalrows from Exam";
        int rowCount=0;
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(qry);
        if(rs.next())
          rowCount=rs.getInt(1);
        String newId="EX-"+(rowCount+1);
        return newId;
        
        
    }
    public static void addExam(Exam newExam) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("insert into Exam values(?,?,?)");
        ps.setString(1,newExam.getExamId());
        ps.setString(2,newExam.getLanguage());
        ps.setInt(3,newExam.getQuestion());
        ps.executeUpdate();
    }
    public static ArrayList <String> getExamIdBySubject(String subject) throws SQLException
    {
       Connection conn=DBConnection.getConnection();
       String qry="Select examid from Exam where language=? ";
       PreparedStatement ps=conn.prepareStatement(qry);
       ps.setString(1,subject);
       ResultSet rs=ps.executeQuery();
       ArrayList <String> examList= new ArrayList <>();
       while(rs.next())
               {
                   examList.add(rs.getString(1));
               }
       return examList;
    }
    public static int getQuestionCountByExam(String examid) throws SQLException
    {
      Connection conn=DBConnection.getConnection();
      String qry="Select total_question from Exam where examid=?";
      PreparedStatement ps=conn.prepareStatement(qry);
      ps.setString(1, examid);
      ResultSet rs=ps.executeQuery();
      rs.next();
      int rowCount=rs.getInt(1);
      return rowCount;
    }
}
