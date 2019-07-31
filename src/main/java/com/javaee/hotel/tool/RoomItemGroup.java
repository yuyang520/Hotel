package com.javaee.hotel.tool;

import java.util.ArrayList;
import java.util.List;

public class RoomItemGroup {
    private String header;
    private List<RoomItem> roomItemList;
    private String type;
    public RoomItemGroup() {
        roomItemList = new ArrayList<RoomItem>();
    }

    public RoomItemGroup(String header, List<RoomItem> roomItemList,String type) {
        this.header = header;
        this.roomItemList = roomItemList;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public List<RoomItem> getRoomItemList() {
        return roomItemList;
    }

    public void setRoomItemList(List<RoomItem> roomItemList) {
        this.roomItemList = roomItemList;
    }
}
