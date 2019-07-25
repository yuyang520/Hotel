package com.javaee.hotel.tool;

import java.util.ArrayList;
import java.util.List;

public class RoomItemContent {
    private List<RoomItemGroup> roomItemGroupList;

    public RoomItemContent(List<RoomItemGroup> roomItemGroupList) {
        this.roomItemGroupList = roomItemGroupList;
    }

    public List<RoomItemGroup> getRoomItemGroupList() {
        return roomItemGroupList;
    }

    public void setRoomItemGroupList(List<RoomItemGroup> roomItemGroupList) {
        this.roomItemGroupList = roomItemGroupList;
    }

    public RoomItemContent() {
        roomItemGroupList = new ArrayList<RoomItemGroup>();
    }
}
