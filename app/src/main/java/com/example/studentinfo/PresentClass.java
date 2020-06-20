package com.example.studentinfo;

public class PresentClass {
    int present;
    int absent;

    public PresentClass(Class<PresentClass> presentClassClass) {
    }

    public PresentClass(int present) {
        this.present = present;
    }

    public int getAbsent() {
        return absent;
    }

    public void setAbsent(int absent) {
        this.absent = absent;
    }

    public int getPresent() {
        return present;
    }

    public void setPresent(int present) {
        this.present = present;
    }
}
