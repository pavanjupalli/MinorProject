package com.company;

public class Branch {

    String branchId;

    String branchName;

    int branchSize;

    Boolean[][] availability;

    public Branch(String branchId, int branchSize, int noOfWorkingDaysPerWeek, int noOfSlotsPerDay) {
        this.branchId = branchId;
        this.branchSize = branchSize;
        this.availability = new Boolean[noOfWorkingDaysPerWeek][noOfSlotsPerDay];
        for (int i = 0; i < noOfWorkingDaysPerWeek; i++)
            for (int j = 0; j < noOfSlotsPerDay; j++) {
                this.availability[i][j] = true;
            }
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
