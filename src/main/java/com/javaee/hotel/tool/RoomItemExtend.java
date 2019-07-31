package com.javaee.hotel.tool;

public class RoomItemExtend extends RoomItem {
    private int iconId;

    public RoomItemExtend(String icon, String text, int iconId) {
        super(icon, text);
        this.iconId = iconId;
    }

    public RoomItemExtend(int iconId) {
        this.iconId = iconId;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public RoomItemExtend() {
    }
}
