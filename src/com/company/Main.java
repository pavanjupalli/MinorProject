package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.*;

public class Main {

    private List<Subject> subjectList;

    public static void main(String[] args) throws FileNotFoundException {
      Scanner scanner=new Scanner(new FileInputStream("E:\\MyData.txt"));
      int noOfWorkingDaysPerWeek,noOfSlotsPerDay;
      List<Subject> subjectList = new ArrayList<>();
      List<Room> roomList = new ArrayList<>();
      List<Branch> branchList =new ArrayList<>();
      List<Teacher> teacherList = new ArrayList<>();
      List<ScheduledTime> scheduledTimeList = new ArrayList<>();
    }
}
