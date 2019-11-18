package com.company;

public class Teacher {

    String TeacherId;

    String TeacherName;

    Boolean[][] availability;

    public Teacher(String teacherId, String teacherName, int noOfWorkingDaysPerWeek, int noOfSlotsPerDay) {
        TeacherId = teacherId;
        TeacherName = teacherName;
        this.availability = new Boolean[noOfWorkingDaysPerWeek][noOfSlotsPerDay];
        for (int i = 0; i < noOfWorkingDaysPerWeek; i++)
            for (int j = 0; j < noOfSlotsPerDay; j++) {
                this.availability[i][j] = true;
            }
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
