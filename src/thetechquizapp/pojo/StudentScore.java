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
public class StudentScore {
    private String language;
    private double per;

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setPer(double per) {
        this.per = per;
    }

    public String getLanguage() {
        return language;
    }

    public double getPer() {
        return per;
    }
}
