package com.company;

public class Teacher {

    String TeacherId;

    String TeacherName;

    int[][]  availability;

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

    public int[][] getAvailability() {
        return availability;
    }

    public void setAvailability(int[][] availability) {
        this.availability = availability;
    }
}
