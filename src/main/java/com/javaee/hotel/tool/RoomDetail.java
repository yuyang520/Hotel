package com.javaee.hotel.tool;

import com.javaee.hotel.domain.Room;

public class RoomDetail {
    private Room room;
    private RoomItemContent roomItemContent;

    public RoomDetail(Room room, RoomItemContent roomItemContent) {
        this.room = room;
        this.roomItemContent = roomItemContent;
    }

    public RoomDetail() {
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public RoomItemContent getRoomItemContent() {
        return roomItemContent;
    }

    public void setRoomItemContent(RoomItemContent roomItemContent) {
        this.roomItemContent = roomItemContent;
    }
}
