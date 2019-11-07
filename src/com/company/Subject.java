package com.company;

public class Subject implements Comparable<Subject>{

    String subjectId;

    String subjectName;

    String teacherId;

    int branchSize;

    String branchId;

    ScheduledTime scheduledTime;

    public Subject(String subjectId, String subjectName, String teacherId, String branchId) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.teacherId = teacherId;
        this.branchId = branchId;
    }

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

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public ScheduledTime getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(ScheduledTime scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    @Override
    public int compareTo(Subject subject) {
        if(this.branchSize==subject.branchSize)
            return 0;
        else if(this.branchSize>subject.branchSize)
            return 1;
        else
            return -1;
    }
}
