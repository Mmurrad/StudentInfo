package com.example.studentinfo;

public class AddCourseDetails {
    String teachername;
    String coursename;
    String referencebook;
    String writtername;
    String year;
    String semister;

    public AddCourseDetails() {

    }

    public AddCourseDetails(String teachername, String coursename, String referencebook, String writtername, String year, String semister) {
        this.teachername = teachername;
        this.coursename = coursename;
        this.referencebook = referencebook;
        this.writtername = writtername;
        this.year = year;
        this.semister = semister;
    }


    public String getTeachername() { return teachername; }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getReferencebook() {
        return referencebook;
    }

    public void setReferencebook(String referencebook) {
        this.referencebook = referencebook;
    }

    public String getWrittername() {
        return writtername;
    }

    public void setWrittername(String writtername) {
        this.writtername = writtername;
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
}
