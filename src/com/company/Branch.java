package com.company;

public class Branch {
    String branchId;

    String branchName;

    int[][] availability;

    public int[][] getAvailability() {
        return availability;
    }

    public void setAvailability(int[][] availability) {
        this.availability = availability;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
}
