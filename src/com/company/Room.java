package com.company;

public class Room {
    String roomId;

    String roomName;

    int size;

    public String getRoomId() {
        return roomId;
    }

    public Room(String roomId, int size) {
        this.roomId = roomId;
        this.size = size;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
