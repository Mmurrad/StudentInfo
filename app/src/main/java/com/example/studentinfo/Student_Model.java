package com.example.studentinfo;

public class Student_Model {
    private String name;
    private String roll;
    private String school_name;
    private String college_name;
    private String home_town;
    private String birthday;
    private String phone;
    private String email;
    private String year;
    private String semister;
    private String image;


    public Student_Model() {

    }

    public Student_Model(String name,String roll, String school_name, String college_name, String home_town, String birthday, String phone, String email,String year,String semister, String image) {
        this.name = name;
        this.roll=roll;
        this.school_name = school_name;
        this.college_name = college_name;
        this.home_town = home_town;
        this.birthday = birthday;
        this.phone = phone;
        this.email = email;
        this.year = year;
        this.semister = semister;
        this.image = image;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSemister() {
        return semister;
    }

    public void setSemister(String semister) {
        this.semister = semister;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getCollege_name() {
        return college_name;
    }

    public void setCollege_name(String college_name) {
        this.college_name = college_name;
    }

    public String getHome_town() {
        return home_town;
    }

    public void setHome_town(String home_town) {
        this.home_town = home_town;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
