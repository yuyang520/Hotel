package com.javaee.hotel.tool;

public class RoomLeftNumberDeliver {
    private int[] roomLeftNumberByDate = new int[30];
    private String roomId;

    public RoomLeftNumberDeliver(int[] roomLeftNumberByDate, String roomId) {
        this.roomLeftNumberByDate = roomLeftNumberByDate;
        this.roomId = roomId;
    }
    public RoomLeftNumberDeliver() {

    }

    public int[] getRoomLeftNumberByDate() {
        return roomLeftNumberByDate;
    }

    public void setRoomLeftNumberByDate(int[] roomLeftNumberByDate) {
        this.roomLeftNumberByDate = roomLeftNumberByDate;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
}
