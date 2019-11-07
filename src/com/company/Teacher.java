package com.company;

public class Teacher {

    String TeacherId;

    String TeacherName;

    Boolean[][]  availability;

    public Teacher(String teacherId, String teacherName, Boolean[][] availability) {
        TeacherId = teacherId;
        TeacherName = teacherName;
        this.availability = availability;
    }

    public String getTeacherId() {
        return TeacherId;
    }

    public void setTeacherId(String teacherId) {
        TeacherId = teacherId;
    }

    public String getTeacherName() {
        return TeacherName;
    }

    public void setTeacherName(String teacherName) {
        TeacherName = teacherName;
    }

    public Boolean[][] getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean[][] availability) {
        this.availability = availability;
    }
}
