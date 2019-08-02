package com.javaee.hotel.domain;

import java.util.Date;

public class OrderList {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_list.order_id
     *
     * @mbg.generated Fri Aug 02 09:31:38 CST 2019
     */
    private String orderId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_list.id
     *
     * @mbg.generated Fri Aug 02 09:31:38 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_list.hotel_id
     *
     * @mbg.generated Fri Aug 02 09:31:38 CST 2019
     */
    private String hotelId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_list.room_id
     *
     * @mbg.generated Fri Aug 02 09:31:38 CST 2019
     */
    private String roomId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_list.identify
     *
     * @mbg.generated Fri Aug 02 09:31:38 CST 2019
     */
    private String identify;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_list.name
     *
     * @mbg.generated Fri Aug 02 09:31:38 CST 2019
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_list.check_in
     *
     * @mbg.generated Fri Aug 02 09:31:38 CST 2019
     */
    private Date checkIn;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_list.check_out
     *
     * @mbg.generated Fri Aug 02 09:31:38 CST 2019
     */
    private Date checkOut;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_list.register_time
     *
     * @mbg.generated Fri Aug 02 09:31:38 CST 2019
     */
    private Date registerTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_list.price
     *
     * @mbg.generated Fri Aug 02 09:31:38 CST 2019
     */
    private Float price;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_list.connect_phone
     *
     * @mbg.generated Fri Aug 02 09:31:38 CST 2019
     */
    private String connectPhone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_list.status
     *
     * @mbg.generated Fri Aug 02 09:31:38 CST 2019
     */
    private Byte status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_list.room_number
     *
     * @mbg.generated Fri Aug 02 09:31:38 CST 2019
     */
    private Byte roomNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_list.serial_number
     *
     * @mbg.generated Fri Aug 02 09:31:38 CST 2019
     */
    private String serialNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_list.room_no
     *
     * @mbg.generated Fri Aug 02 09:31:38 CST 2019
     */
    private String roomNo;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_list.order_id
     *
     * @return the value of order_list.order_id
     *
     * @mbg.generated Fri Aug 02 09:31:38 CST 2019
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_list.order_id
     *
     * @param orderId the value for order_list.order_id
     *
     * @mbg.generated Fri Aug 02 09:31:38 CST 2019
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_list.id
     *
     * @return the value of order_list.id
     *
     * @mbg.generated Fri Aug 02 09:31:38 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_list.id
     *
     * @param id the value for order_list.id
     *
     * @mbg.generated Fri Aug 02 09:31:38 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_list.hotel_id
     *
     * @return the value of order_list.hotel_id
     *
     * @mbg.generated Fri Aug 02 09:31:38 CST 2019
     */
    public String getHotelId() {
        return hotelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_list.hotel_id
     *
     * @param hotelId the value for order_list.hotel_id
     *
     * @mbg.generated Fri Aug 02 09:31:38 CST 2019
     */
    public void setHotelId(String hotelId) {
        this.hotelId = hotelId == null ? null : hotelId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_list.room_id
     *
     * @return the value of order_list.room_id
     *
     * @mbg.generated Fri Aug 02 09:31:38 CST 2019
     */
    public String getRoomId() {
        return roomId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_list.room_id
     *
     * @param roomId the value for order_list.room_id
     *
     * @mbg.generated Fri Aug 02 09:31:38 CST 2019
     */
    public void setRoomId(String roomId) {
        this.roomId = roomId == null ? null : roomId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_list.identify
     *
     * @return the value of order_list.identify
     *
     * @mbg.generated Fri Aug 02 09:31:38 CST 2019
     */
    public String getIdentify() {
        return identify;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_list.identify
     *
     * @param identify the value for order_list.identify
     *
     * @mbg.generated Fri Aug 02 09:31:38 CST 2019
     */
    public void setIdentify(String identify) {
        this.identify = identify == null ? null : identify.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_list.name
     *
     * @return the value of order_list.name
     *
     * @mbg.generated Fri Aug 02 09:31:38 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_list.name
     *
     * @param name the value for order_list.name
     *
     * @mbg.generated Fri Aug 02 09:31:38 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_list.check_in
     *
     * @return the value of order_list.check_in
     *
     * @mbg.generated Fri Aug 02 09:31:38 CST 2019
     */
    public Date getCheckIn() {
        return checkIn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_list.check_in
     *
     * @param checkIn the value for order_list.check_in
     *
     * @mbg.generated Fri Aug 02 09:31:38 CST 2019
     */
    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_list.check_out
     *
     * @return the value of order_list.check_out
     *
     * @mbg.generated Fri Aug 02 09:31:38 CST 2019
     */
    public Date getCheckOut() {
        return checkOut;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_list.check_out
     *
     * @param checkOut the value for order_list.check_out
     *
     * @mbg.generated Fri Aug 02 09:31:38 CST 2019
     */
    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_list.register_time
     *
     * @return the value of order_list.register_time
     *
     * @mbg.generated Fri Aug 02 09:31:38 CST 2019
     */
    public Date getRegisterTime() {
        return registerTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_list.register_time
     *
     * @param registerTime the value for order_list.register_time
     *
     * @mbg.generated Fri Aug 02 09:31:38 CST 2019
     */
    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_list.price
     *
     * @return the value of order_list.price
     *
     * @mbg.generated Fri Aug 02 09:31:38 CST 2019
     */
    public Float getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_list.price
     *
     * @param price the value for order_list.price
     *
     * @mbg.generated Fri Aug 02 09:31:38 CST 2019
     */
    public void setPrice(Float price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_list.connect_phone
     *
     * @return the value of order_list.connect_phone
     *
     * @mbg.generated Fri Aug 02 09:31:38 CST 2019
     */
    public String getConnectPhone() {
        return connectPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_list.connect_phone
     *
     * @param connectPhone the value for order_list.connect_phone
     *
     * @mbg.generated Fri Aug 02 09:31:38 CST 2019
     */
    public void setConnectPhone(String connectPhone) {
        this.connectPhone = connectPhone == null ? null : connectPhone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_list.status
     *
     * @return the value of order_list.status
     *
     * @mbg.generated Fri Aug 02 09:31:38 CST 2019
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_list.status
     *
     * @param status the value for order_list.status
     *
     * @mbg.generated Fri Aug 02 09:31:38 CST 2019
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_list.room_number
     *
     * @return the value of order_list.room_number
     *
     * @mbg.generated Fri Aug 02 09:31:38 CST 2019
     */
    public Byte getRoomNumber() {
        return roomNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_list.room_number
     *
     * @param roomNumber the value for order_list.room_number
     *
     * @mbg.generated Fri Aug 02 09:31:38 CST 2019
     */
    public void setRoomNumber(Byte roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_list.serial_number
     *
     * @return the value of order_list.serial_number
     *
     * @mbg.generated Fri Aug 02 09:31:38 CST 2019
     */
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_list.serial_number
     *
     * @param serialNumber the value for order_list.serial_number
     *
     * @mbg.generated Fri Aug 02 09:31:38 CST 2019
     */
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber == null ? null : serialNumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_list.room_no
     *
     * @return the value of order_list.room_no
     *
     * @mbg.generated Fri Aug 02 09:31:38 CST 2019
     */
    public String getRoomNo() {
        return roomNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_list.room_no
     *
     * @param roomNo the value for order_list.room_no
     *
     * @mbg.generated Fri Aug 02 09:31:38 CST 2019
     */
    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo == null ? null : roomNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_list
     *
     * @mbg.generated Fri Aug 02 09:31:38 CST 2019
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        OrderList other = (OrderList) that;
        return (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getHotelId() == null ? other.getHotelId() == null : this.getHotelId().equals(other.getHotelId()))
            && (this.getRoomId() == null ? other.getRoomId() == null : this.getRoomId().equals(other.getRoomId()))
            && (this.getIdentify() == null ? other.getIdentify() == null : this.getIdentify().equals(other.getIdentify()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getCheckIn() == null ? other.getCheckIn() == null : this.getCheckIn().equals(other.getCheckIn()))
            && (this.getCheckOut() == null ? other.getCheckOut() == null : this.getCheckOut().equals(other.getCheckOut()))
            && (this.getRegisterTime() == null ? other.getRegisterTime() == null : this.getRegisterTime().equals(other.getRegisterTime()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getConnectPhone() == null ? other.getConnectPhone() == null : this.getConnectPhone().equals(other.getConnectPhone()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRoomNumber() == null ? other.getRoomNumber() == null : this.getRoomNumber().equals(other.getRoomNumber()))
            && (this.getSerialNumber() == null ? other.getSerialNumber() == null : this.getSerialNumber().equals(other.getSerialNumber()))
            && (this.getRoomNo() == null ? other.getRoomNo() == null : this.getRoomNo().equals(other.getRoomNo()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_list
     *
     * @mbg.generated Fri Aug 02 09:31:38 CST 2019
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getHotelId() == null) ? 0 : getHotelId().hashCode());
        result = prime * result + ((getRoomId() == null) ? 0 : getRoomId().hashCode());
        result = prime * result + ((getIdentify() == null) ? 0 : getIdentify().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getCheckIn() == null) ? 0 : getCheckIn().hashCode());
        result = prime * result + ((getCheckOut() == null) ? 0 : getCheckOut().hashCode());
        result = prime * result + ((getRegisterTime() == null) ? 0 : getRegisterTime().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getConnectPhone() == null) ? 0 : getConnectPhone().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRoomNumber() == null) ? 0 : getRoomNumber().hashCode());
        result = prime * result + ((getSerialNumber() == null) ? 0 : getSerialNumber().hashCode());
        result = prime * result + ((getRoomNo() == null) ? 0 : getRoomNo().hashCode());
        return result;
    }
}