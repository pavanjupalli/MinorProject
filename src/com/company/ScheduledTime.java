package com.company;

public class ScheduledTime implements Comparable<ScheduledTime> {

    int day;

    int slot;

    Room room;

    public ScheduledTime(int day, int slot, Room room) {
        this.day = day;
        this.slot = slot;
        this.room = room;
    }

    @Override
    public int compareTo(ScheduledTime scheduledTime) {
        if(this.room.size == scheduledTime.room.size)
            return 0;
        else if(this.room.size>scheduledTime.room.size)
            return 1;
        else
            return -1;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
