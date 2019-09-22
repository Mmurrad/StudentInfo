package com.example.studentinfo;

public class UploadPdf {
    private String pdf;
    private String name;

    public UploadPdf() {

    }

    public UploadPdf(String pdf,String name) {
        this.pdf = pdf;
        this.name=name;
    }

    public UploadPdf(String name) {
        this.name = name;
    }

    public String toString()
    {
        return this.name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }
}
