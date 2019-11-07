package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.*;

public class Main {

    private List<Subject> subjectList;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("E:\\MyData.txt"));
        int noOfWorkingDaysPerWeek, noOfSlotsPerDay, noOfLecperSub;
        List<Subject> subjectList = new ArrayList<>();
        List<Room> roomList = new ArrayList<>();
        List<Branch> branchList = new ArrayList<>();
        List<Teacher> teacherList = new ArrayList<>();
        List<ScheduledTime> scheduledTimeList = new ArrayList<>();
        noOfWorkingDaysPerWeek = scanner.nextInt();
        noOfSlotsPerDay = scanner.nextInt();
        noOfLecperSub = scanner.nextInt();
        Boolean[][] teacherAvailiability = new Boolean[noOfWorkingDaysPerWeek][noOfSlotsPerDay];
        Boolean[][] branchAvailiability = new Boolean[noOfWorkingDaysPerWeek][noOfSlotsPerDay];
        Boolean[][] errorFixing = new Boolean[noOfWorkingDaysPerWeek][noOfSlotsPerDay];
        for (int i = 0; i < noOfWorkingDaysPerWeek; i++)
            for (int j = 0; j < noOfSlotsPerDay; j++) {
                teacherAvailiability[i][j] = true;
                branchAvailiability[i][j] = false;
                errorFixing[i][j] = false;
            }
        while (scanner.hasNext()) {
            if (scanner.next().equals("----")) {
                break;
            }
            roomList.add(new Room(scanner.next(), scanner.nextInt()));
        }

        while (scanner.hasNext()) {
            if (scanner.next().equals("----"))
                break;
            branchList.add(new Branch(scanner.next(),scanner.nextInt(),branchAvailiability));
        }

        while (scanner.hasNext()) {
            if (scanner.next().equals("----"))
                break;
            teacherList.add(new Teacher(scanner.next(), scanner.next(), teacherAvailiability));
        }
        for (Room room : roomList) {
            for (int i = 1; i <= noOfWorkingDaysPerWeek; i++) {
                for (int j = 1; j <= noOfSlotsPerDay; j++) {
                    scheduledTimeList.add(new ScheduledTime(i, j, room));
                }
            }
        }

        while (scanner.hasNext()) {
            if (scanner.next().equals("----"))
                break;
            String subjectId = scanner.next(), subjectName = scanner.next(), teacherId = scanner.next(), branchId = scanner.next();
            for (int i = 0; i < noOfLecperSub; i++) {
                subjectList.add(new Subject(subjectId, subjectName, teacherId, branchId));
            }
        }

        HashMap<String, Branch> branchHashMap = new HashMap<>();
        HashMap<String, Teacher> teacherHashMap = new HashMap<>();
        for (Branch branch : branchList) {
            branchHashMap.put(branch.branchId, branch);
        }
        for (Teacher teacher : teacherList) {
            teacherHashMap.put(teacher.TeacherId, teacher);
        }

        Collections.sort(subjectList);
        Collections.sort(scheduledTimeList);

        Boolean matched = false, temp = false;
        ScheduledTime tempScheduleTime = null;
        List<Subject> errorSubjectList = new ArrayList<>();
        for (Subject subject : subjectList) {
            matched = false;
            temp = false;
            for (ScheduledTime scheduledTime : scheduledTimeList) {
                if (branchHashMap.get(subject.branchId).branchSize <= scheduledTime.room.size) {
                    if (temp == false) {
                        tempScheduleTime = scheduledTime;
                        temp = true;
                    }
                    if (teacherHashMap.get(subject.teacherId).availability[scheduledTime.day][scheduledTime.slot] == true
                            && branchHashMap.get(subject.branchId).availability[scheduledTime.day][scheduledTime.slot] == true) {
                        subject.scheduledTime = scheduledTime;
                        branchHashMap.get(subject.branchId).availability[scheduledTime.day][scheduledTime.slot] = false;
                        teacherHashMap.get(subject.teacherId).availability[scheduledTime.day][scheduledTime.slot] = false;
                        matched = true;
                    }
                }
            }
            if (matched == false) {
                if (temp == true) {
                    subject.scheduledTime = tempScheduleTime;
                    errorFixing[tempScheduleTime.day][tempScheduleTime.slot] = true;
                    errorSubjectList.add(subject);
                } else
                    return;
            }
        }
        HashMap<String, List<Subject>> finalHashMap = new HashMap<>();
        List<Subject> list;
        for (Integer i = 0; i < noOfWorkingDaysPerWeek; i++) {
            for (Integer j = 0; j < noOfSlotsPerDay; j++) {
                list = new ArrayList<>();
                finalHashMap.put(Integer.toString(i) + Integer.toString(j), list);
            }
        }


        List<ScheduledTime>  slotScheduleTime;
        HashMap<String,List<ScheduledTime> > scheduleTimeHasMap =  new HashMap<>();
        for (int i = 0; i < noOfWorkingDaysPerWeek; i++) {
            for (int j = 0; j < noOfSlotsPerDay; j++) {
                slotScheduleTime = new ArrayList<>();
                scheduleTimeHasMap.put(Integer.toString(i) + Integer.toString(j),slotScheduleTime);
            }
        }
        ScheduledTime tempScheduleTime1;
        for (Subject subject : errorSubjectList) {
            int matchingSlot = subject.scheduledTime.slot,matchingDay = subject.scheduledTime.day;
            for(int i = 0; i < noOfWorkingDaysPerWeek ; i++){
                for(int j = 0; j < noOfSlotsPerDay; j++){
                    for (Subject subject1: finalHashMap.get(i+j)){
                        if(branchHashMap.get(subject.branchId).branchSize <= subject1.scheduledTime.room.size
                                && branchHashMap.get(subject1.branchId).branchSize <= subject1.scheduledTime.room.size){

                        }
                    }
                }
            }

            for (int i = 0; i < noOfWorkingDaysPerWeek; i++) {
                for (int j = 0; j < noOfSlotsPerDay; j++) {

                        if (teacherHashMap.get(subject.teacherId).availability[i][j] == true
                                && branchHashMap.get(subject.branchId).availability[i][j] == true) {

                            for (Subject subject1 : finalHashMap.get(i + j)) {
                                if (teacherHashMap.get(subject1.teacherId).availability[matchingDay][matchingSlot] = true
                                        && branchHashMap.get(subject.branchId).availability[matchingDay][matchingSlot] == true) {
                                    if (branchHashMap.get(subject.branchId).branchSize <= subject1.scheduledTime.room.size
                                            && branchHashMap.get(subject1.branchId).branchSize <= subject1.scheduledTime.room.size) {
                                        tempScheduleTime1 = subject.scheduledTime;
                                        subject.scheduledTime = subject1.scheduledTime;
                                        subject1.scheduledTime = tempScheduleTime1;
                                    }
                                }
                            }

                        }

                }
            }
        }

    }
}
