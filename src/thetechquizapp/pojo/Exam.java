/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thetechquizapp.pojo;

/**
 *
 * @author Vini
 */
public class Exam {
    private String examId;
    private String language;
    private int question;

    public Exam(String examId, String language, int question) {
        this.examId = examId;
        this.language = language;
        this.question = question;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setQuestion(int question) {
        this.question = question;
    }

    public String getExamId() {
        return examId;
    }

    public String getLanguage() {
        return language;
    }

    public int getQuestion() {
        return question;
    }
    
}
