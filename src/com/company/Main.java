package com.company;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new FileInputStream("E:\\MyData.txt"));

        int a = 1, noOfWorkingDaysPerWeek, noOfSlotsPerDay;

        //decleration of each list.

        List<Subject> subjectList = new ArrayList<>();
        List<Room> roomList = new ArrayList<>();
        List<Branch> branchList = new ArrayList<>();
        List<Teacher> teacherList = new ArrayList<>();
        List<ScheduledTime> scheduledTimeList = new ArrayList<>();


        noOfWorkingDaysPerWeek = scanner.nextInt();
        noOfSlotsPerDay = scanner.nextInt();

        //scaning each room from input file  & making room List
        String string;
        while (scanner.hasNext()) {
            string = scanner.next();
            if (!string.equals("&&&")) {
                roomList.add(new Room(string, scanner.nextInt()));
            } else
                break;
        }
        //scanning each Branch && making Branch List

        while (scanner.hasNext()) {
            string = scanner.next();
            if (!string.equals("&&&"))
                branchList.add(new Branch(string, scanner.nextInt(), noOfWorkingDaysPerWeek, noOfSlotsPerDay));
            else
                break;
        }


        //scanning each Teacher & making Teacher List

        while (scanner.hasNext()) {
            string = scanner.next();
            if (!string.equals("&&&"))
                teacherList.add(new Teacher(string, scanner.next(), noOfWorkingDaysPerWeek, noOfSlotsPerDay));
            else
                break;
        }


        // scanning each Subject and Making subject List

        while (scanner.hasNext()) {
            String subjectId = scanner.next();
            if (!subjectId.equals("&&&")) {
                String subjectName = scanner.next(), teacherId = scanner.next(), branchId = scanner.next();
                subjectList.add(new Subject(subjectId, subjectName, teacherId, branchId));
            } else
                break;

        }


        // making schedule Time List

        for (Room room : roomList) {
            for (int i = 0; i < noOfWorkingDaysPerWeek; i++) {
                for (int j = 0; j < noOfSlotsPerDay; j++) {
                    scheduledTimeList.add(new ScheduledTime(i, j, room));
                }
            }
        }


        // intializing hashMaps

        HashMap<String, Branch> branchHashMap = new HashMap<>();
        HashMap<String, Teacher> teacherHashMap = new HashMap<>();


        // adding data into hashMap

        for (Branch branch : branchList) {
            branchHashMap.put(branch.branchId, branch);
        }
        for (Teacher teacher : teacherList) {
            teacherHashMap.put(teacher.TeacherId, teacher);
        }


        // assigning branch Size Values

        for (Subject subject : subjectList) {
            subject.branchSize = branchHashMap.get(subject.branchId).branchSize;
        }

        // sorting SubjectList on the basis of branch Size

        Collections.sort(subjectList);

        // sorting scheduleTimeList on the basis of room Size

        Collections.sort(scheduledTimeList);

        // making final hashmap.


        HashMap<String, List<Subject>> finalHashMap = new HashMap<>();
        List<Subject> list;
        for (int i = 0; i < noOfWorkingDaysPerWeek; i++) {
            for (int j = 0; j < noOfSlotsPerDay; j++) {
                list = new ArrayList<>();
                finalHashMap.put(Integer.toString(i).concat(Integer.toString(j)), list);
            }
        }


        //mapping the sorted subject list and scheduleTime List, making errorSubjectList.

        int k = 0;
        boolean matched, temp;
        ScheduledTime tempScheduleTime = null;
        List<Subject> errorSubjectList = new ArrayList<>();
        for (Subject subject : subjectList) {
            matched = false;
            temp = false;
            for (ScheduledTime scheduledTime : scheduledTimeList) {
                if (branchHashMap.get(subject.branchId).branchSize <= scheduledTime.room.size) {
                    if (!temp) {
                        tempScheduleTime = scheduledTime;
                        temp = true;
                    }
                    if (teacherHashMap.get(subject.teacherId).availability[scheduledTime.day][scheduledTime.slot]
                            && branchHashMap.get(subject.branchId).availability[scheduledTime.day][scheduledTime.slot]) {
                        subject.scheduledTime = scheduledTime;
                        branchHashMap.get(subject.branchId).availability[scheduledTime.day][scheduledTime.slot] = false;
                        teacherHashMap.get(subject.teacherId).availability[scheduledTime.day][scheduledTime.slot] = false;
                        finalHashMap.get(Integer.toString(subject.scheduledTime.day).concat(Integer.toString(subject.scheduledTime.slot))).add(subject);
                        matched = true;
                        break;
                    }
                }
            }
            if (!matched && temp) {
                subject.scheduledTime = tempScheduleTime;
                errorSubjectList.add(subject);
                k++;
            }
        }


        // reducing errors

        if (k != 0) {
            ScheduledTime tempScheduleTime1;
            for (Subject subject : errorSubjectList) {
                int erroredSlot = subject.scheduledTime.slot, erroredDay = subject.scheduledTime.day;

                if (a != 1) {

                    for (int i = 0; i < noOfWorkingDaysPerWeek; i++) {
                        for (int j = 0; j < noOfSlotsPerDay; j++) {
                            for (Subject subject1 : finalHashMap.get(Integer.toString(i).concat(Integer.toString(j)))) {
                                if (branchHashMap.get(subject.branchId).branchSize <= subject1.scheduledTime.room.size
                                        && branchHashMap.get(subject1.branchId).branchSize <= subject1.scheduledTime.room.size) {
                                    System.out.println("nothing will be done");

                                }
                            }
                        }
                    }
                }

                for (int i = 0; i < noOfWorkingDaysPerWeek; i++) {
                    for (int j = 0; j < noOfSlotsPerDay; j++) {

                        if (teacherHashMap.get(subject.teacherId).availability[i][j]
                                && branchHashMap.get(subject.branchId).availability[i][j]) {

                            for (Subject subject1 : finalHashMap.get(Integer.toString(i).concat(Integer.toString(j)))) {
                                if (teacherHashMap.get(subject1.teacherId).availability[erroredDay][erroredSlot]
                                        && branchHashMap.get(subject1.branchId).availability[erroredDay][erroredSlot]
                                        && branchHashMap.get(subject.branchId).branchSize <= subject1.scheduledTime.room.size
                                        && branchHashMap.get(subject1.branchId).branchSize <= subject1.scheduledTime.room.size) {
                                    if (!finalHashMap.get(Integer.toString(subject.scheduledTime.day).concat(Integer.toString(subject.scheduledTime.slot))).remove(subject)) {
                                        return;
                                    }
                                    tempScheduleTime1 = subject.scheduledTime;
                                    subject.scheduledTime = subject1.scheduledTime;
                                    subject1.scheduledTime = tempScheduleTime1;
                                    finalHashMap.get(Integer.toString(subject.scheduledTime.day).concat(Integer.toString(subject.scheduledTime.slot))).add(subject1);
                                    finalHashMap.get(Integer.toString(subject.scheduledTime.day).concat(Integer.toString(subject.scheduledTime.slot))).add(subject);
                                }
                            }

                        }

                    }
                }
            }
        }


        //printing output
        scanner.close();
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\MyData1.txt");
        String finalString;
        for (Branch branch : branchList) {
            fileOutputStream.write(branch.branchId.getBytes());
            fileOutputStream.write('\n');
            fileOutputStream.write('\n');
            for (Subject subject : subjectList) {
                if (branchHashMap.get(subject.branchId).equals(branch)) {
                    finalString = subject.subjectId + " " + subject.subjectName + " " + subject.branchId + " " + subject.teacherId + " "
                            + subject.scheduledTime.day + " " + subject.scheduledTime.slot + " " + subject.scheduledTime.room.roomId;
                    fileOutputStream.write(finalString.getBytes());
                    fileOutputStream.write('\n');
                }
            }
            fileOutputStream.write('\n');
            fileOutputStream.write('\n');
        }

    }
}
