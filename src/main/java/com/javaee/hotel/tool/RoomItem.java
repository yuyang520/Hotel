package com.javaee.hotel.tool;

public class RoomItem {
    private String icon;
    private String text;

    public RoomItem(String icon, String text) {
        this.icon = icon;
        this.text = text;
    }

    public RoomItem() {
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
