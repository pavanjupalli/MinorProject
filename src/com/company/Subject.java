package com.company;

public class Subject {

    String subjectId;

    String subjectName;

    Teacher teacher;

    Branch Branch;

    ScheduledTime scheduledTime;

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public com.company.Branch getBranch() {
        return Branch;
    }

    public void setBranch(com.company.Branch branch) {
        Branch = branch;
    }

    public ScheduledTime getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(ScheduledTime scheduledTime) {
        this.scheduledTime = scheduledTime;
    }
}
