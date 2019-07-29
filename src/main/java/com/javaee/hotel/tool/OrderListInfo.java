package com.javaee.hotel.tool;

import com.javaee.hotel.domain.OrderList;


public class OrderListInfo {
    private String hotelChineseName;
    private OrderList orderList;
    private String roomName;
    private String createTime;
    private String checkInTime;
    private String checkOutTime;
    public String getHotelChineseName() {
        return hotelChineseName;
    }
    public void setHotelChineseName(String hotelChineseName) {
        this.hotelChineseName = hotelChineseName == null ? null : hotelChineseName.trim();
    }
    public OrderList getOrderList(){return orderList;}
    public void setOrderList(OrderList orderList){
        this.orderList = orderList == null ? null : orderList;
    }
    public String getRoomName() {
        return roomName;
    }
    public void setRoomName(String roomName) {
        this.roomName = roomName == null ? null : roomName.trim();
    }
    public String getCreateTime() {
        return createTime;
    }
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }
    public String getCheckInTime() {
        return checkInTime;
    }
    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime == null ? null : checkInTime.trim();
    }
    public String getCheckOutTime() {
        return checkOutTime;
    }
    public void setCheckOutTime(String checkOutTime) {
        this.checkOutTime = checkOutTime == null ? null : checkOutTime.trim();
    }
}
