/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thetechquizapp.pojo;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Vini
 */
public class Questions {
    private String examId;
    private int qno;

    public Questions(String examId, int qno, String language, String answer1, String answer2, String answer3, String answer4, String correctAnswer, String Question) {
        this.examId = examId;
        this.qno = qno;
        this.language = language;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.correctAnswer = correctAnswer;
        this.Question = Question;
    }
    private String language;
    private String answer1,answer2,answer3,answer4;
    private String correctAnswer;
    private String Question;

    @Override
    public String toString() {
        return "Question{" + "examId=" + examId + ", qno=" + qno + ", language=" + language + ", answer1=" + answer1 + ", answer2=" + answer2 + ", answer3=" + answer3 + ", answer4=" + answer4 + ", correctAnswer=" + correctAnswer + ", Question=" + Question + '}';
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public void setQno(int qno) {
        this.qno = qno;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void setQuestion(String Question) {
        this.Question = Question;
    }

    public String getExamId() {
        return examId;
    }

    public int getQno() {
        return qno;
    }

    public String getLanguage() {
        return language;
    }

    public String getAnswer1() {
        return answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getQuestion() {
        return Question;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Questions other = (Questions) obj;
        if (this.qno != other.qno) {
            return false;
        }
        if (!Objects.equals(this.examId, other.examId)) {
            return false;
        }
        if (!Objects.equals(this.language, other.language)) {
            return false;
        }
        if (!Objects.equals(this.answer1, other.answer1)) {
            return false;
        }
        if (!Objects.equals(this.answer2, other.answer2)) {
            return false;
        }
        if (!Objects.equals(this.answer3, other.answer3)) {
            return false;
        }
        if (!Objects.equals(this.answer4, other.answer4)) {
            return false;
        }
        if (!Objects.equals(this.correctAnswer, other.correctAnswer)) {
            return false;
        }
        if (!Objects.equals(this.Question, other.Question)) {
            return false;
        }
        return true;
    }   
}
