package com.company;

public class Branch {

    String branchId;

    int branchSize;

    Boolean[][] availability;

    public Branch(String branchId, int branchSize, Boolean[][] availability) {
        this.branchId = branchId;
        this.branchSize = branchSize;
        this.availability = availability;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public int getBranchSize() {
        return branchSize;
    }

    public void setBranchSize(int branchSize) {
        this.branchSize = branchSize;
    }

    public Boolean[][] getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean[][] availability) {
        this.availability = availability;
    }
}
