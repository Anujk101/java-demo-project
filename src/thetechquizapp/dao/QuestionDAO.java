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
import java.util.ArrayList;
import thetechquizapp.pojo.Questions;
import thetechquizapp.pojo.QuestionStore;
import thetechquizapp.util.DBConnection;

/**
 *
 * @author Vini
 */
public class QuestionDAO {
    public static void addQuestion(QuestionStore qstore) throws SQLException
    {
        String qry="insert into Questions values (?,?,?,?,?,?,?,?,?)";
        ArrayList <Questions> questionList=qstore.getAllQuestion();
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement(qry);
        for(Questions obj:questionList)
        {
            ps.setString(1, obj.getExamId());
            ps.setInt(4,obj.getQno());
            ps.setString(3,obj.getQuestion());
            ps.setString(5,obj.getAnswer1());
            ps.setString(6,obj.getAnswer2());
            ps.setString(7,obj.getAnswer3());
            ps.setString(8,obj.getAnswer4());
            ps.setString(9,obj.getCorrectAnswer());
            ps.setString(2, obj.getLanguage());
            ps.executeUpdate();
            
        }
    }
    public static ArrayList <Questions> getQuestionsByExamId(String examId) throws SQLException
        {
          String qry="Select * from Questions where examid=? order by qno";
          ArrayList <Questions> questionList=new ArrayList<>();
          Connection conn=DBConnection.getConnection();
          PreparedStatement ps=conn.prepareStatement(qry);
          ps.setString(1,examId);
          ResultSet rs=ps.executeQuery();
          
          
          while(rs.next())
          {
              int qno=rs.getInt(4);
              String question=rs.getString(3);
              String option1=rs.getString(5);
              String option2=rs.getString(6);
              String option3=rs.getString(7);
              String option4=rs.getString(8);
              String correctAnswer=rs.getString(9);
              String language=rs.getString(2);
              Questions obj=new Questions(examId,qno,language,option1,option2,option3,option4,correctAnswer,question);
              questionList.add(obj);
          }
          System.out.println(" Hello Total Ques "+questionList.size());
          return questionList;
        }
    public static void updateQuestion(QuestionStore qstore) throws SQLException
    {
        String qry="update Questions set question=?,answer1=?,answer2=?,answer3=?,answer4=?,correctanswer=? where examid=? and qno=?";
        ArrayList <Questions> questionList=qstore.getAllQuestion();
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement(qry);
        for(Questions obj:questionList)
        {
            ps.setString(1,obj.getQuestion());
            ps.setString(2, obj.getAnswer1());
            ps.setString(3,obj.getAnswer2());
            ps.setString(4,obj.getAnswer3());
            ps.setString(5,obj.getAnswer4());
            ps.setString(6,obj.getCorrectAnswer());
            ps.setString(7,obj.getExamId());
            ps.setInt(8, obj.getQno());
            ps.executeQuery();
        }
    }
    
    
}
