/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author 84375
 */
public class Student {
    int Id ;
    String Name;
    boolean Gender;
    Date DOB;

    public Student() {
    }

    public Student(int Id, String Name, boolean Gender, Date DOB) {
        this.Id = Id;
        this.Name = Name;
        this.Gender = Gender;
        this.DOB = DOB;
    }

    public String getId() {
        return String.valueOf(Id);
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public boolean isGender() {
        return Gender;
    }

    public void setGender(boolean Gender) {
        this.Gender = Gender;
    }

    public String getDOB() {
        SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
        
        return f.format(DOB);
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }
    
}
