package com.javaee.hotel.domain;

public class Room {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column room.room_id
     *
     * @mbg.generated Wed Jul 31 14:50:03 CST 2019
     */
    private String roomId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column room.hotel_id
     *
     * @mbg.generated Wed Jul 31 14:50:03 CST 2019
     */
    private String hotelId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column room.detail
     *
     * @mbg.generated Wed Jul 31 14:50:03 CST 2019
     */
    private String detail;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column room.left_number
     *
     * @mbg.generated Wed Jul 31 14:50:03 CST 2019
     */
    private Integer leftNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column room.photo
     *
     * @mbg.generated Wed Jul 31 14:50:03 CST 2019
     */
    private String photo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column room.price
     *
     * @mbg.generated Wed Jul 31 14:50:03 CST 2019
     */
    private Float price;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column room.chinese_name
     *
     * @mbg.generated Wed Jul 31 14:50:03 CST 2019
     */
    private String chineseName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column room.english_name
     *
     * @mbg.generated Wed Jul 31 14:50:03 CST 2019
     */
    private String englishName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column room.room_no
     *
     * @mbg.generated Wed Jul 31 14:50:03 CST 2019
     */
    private String roomNo;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column room.room_id
     *
     * @return the value of room.room_id
     *
     * @mbg.generated Wed Jul 31 14:50:03 CST 2019
     */
    public String getRoomId() {
        return roomId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column room.room_id
     *
     * @param roomId the value for room.room_id
     *
     * @mbg.generated Wed Jul 31 14:50:03 CST 2019
     */
    public void setRoomId(String roomId) {
        this.roomId = roomId == null ? null : roomId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column room.hotel_id
     *
     * @return the value of room.hotel_id
     *
     * @mbg.generated Wed Jul 31 14:50:03 CST 2019
     */
    public String getHotelId() {
        return hotelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column room.hotel_id
     *
     * @param hotelId the value for room.hotel_id
     *
     * @mbg.generated Wed Jul 31 14:50:03 CST 2019
     */
    public void setHotelId(String hotelId) {
        this.hotelId = hotelId == null ? null : hotelId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column room.detail
     *
     * @return the value of room.detail
     *
     * @mbg.generated Wed Jul 31 14:50:03 CST 2019
     */
    public String getDetail() {
        return detail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column room.detail
     *
     * @param detail the value for room.detail
     *
     * @mbg.generated Wed Jul 31 14:50:03 CST 2019
     */
    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column room.left_number
     *
     * @return the value of room.left_number
     *
     * @mbg.generated Wed Jul 31 14:50:03 CST 2019
     */
    public Integer getLeftNumber() {
        return leftNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column room.left_number
     *
     * @param leftNumber the value for room.left_number
     *
     * @mbg.generated Wed Jul 31 14:50:03 CST 2019
     */
    public void setLeftNumber(Integer leftNumber) {
        this.leftNumber = leftNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column room.photo
     *
     * @return the value of room.photo
     *
     * @mbg.generated Wed Jul 31 14:50:03 CST 2019
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column room.photo
     *
     * @param photo the value for room.photo
     *
     * @mbg.generated Wed Jul 31 14:50:03 CST 2019
     */
    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column room.price
     *
     * @return the value of room.price
     *
     * @mbg.generated Wed Jul 31 14:50:03 CST 2019
     */
    public Float getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column room.price
     *
     * @param price the value for room.price
     *
     * @mbg.generated Wed Jul 31 14:50:03 CST 2019
     */
    public void setPrice(Float price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column room.chinese_name
     *
     * @return the value of room.chinese_name
     *
     * @mbg.generated Wed Jul 31 14:50:03 CST 2019
     */
    public String getChineseName() {
        return chineseName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column room.chinese_name
     *
     * @param chineseName the value for room.chinese_name
     *
     * @mbg.generated Wed Jul 31 14:50:03 CST 2019
     */
    public void setChineseName(String chineseName) {
        this.chineseName = chineseName == null ? null : chineseName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column room.english_name
     *
     * @return the value of room.english_name
     *
     * @mbg.generated Wed Jul 31 14:50:03 CST 2019
     */
    public String getEnglishName() {
        return englishName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column room.english_name
     *
     * @param englishName the value for room.english_name
     *
     * @mbg.generated Wed Jul 31 14:50:03 CST 2019
     */
    public void setEnglishName(String englishName) {
        this.englishName = englishName == null ? null : englishName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column room.room_no
     *
     * @return the value of room.room_no
     *
     * @mbg.generated Wed Jul 31 14:50:03 CST 2019
     */
    public String getRoomNo() {
        return roomNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column room.room_no
     *
     * @param roomNo the value for room.room_no
     *
     * @mbg.generated Wed Jul 31 14:50:03 CST 2019
     */
    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo == null ? null : roomNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table room
     *
     * @mbg.generated Wed Jul 31 14:50:03 CST 2019
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
        Room other = (Room) that;
        return (this.getRoomId() == null ? other.getRoomId() == null : this.getRoomId().equals(other.getRoomId()))
            && (this.getHotelId() == null ? other.getHotelId() == null : this.getHotelId().equals(other.getHotelId()))
            && (this.getDetail() == null ? other.getDetail() == null : this.getDetail().equals(other.getDetail()))
            && (this.getLeftNumber() == null ? other.getLeftNumber() == null : this.getLeftNumber().equals(other.getLeftNumber()))
            && (this.getPhoto() == null ? other.getPhoto() == null : this.getPhoto().equals(other.getPhoto()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getChineseName() == null ? other.getChineseName() == null : this.getChineseName().equals(other.getChineseName()))
            && (this.getEnglishName() == null ? other.getEnglishName() == null : this.getEnglishName().equals(other.getEnglishName()))
            && (this.getRoomNo() == null ? other.getRoomNo() == null : this.getRoomNo().equals(other.getRoomNo()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table room
     *
     * @mbg.generated Wed Jul 31 14:50:03 CST 2019
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRoomId() == null) ? 0 : getRoomId().hashCode());
        result = prime * result + ((getHotelId() == null) ? 0 : getHotelId().hashCode());
        result = prime * result + ((getDetail() == null) ? 0 : getDetail().hashCode());
        result = prime * result + ((getLeftNumber() == null) ? 0 : getLeftNumber().hashCode());
        result = prime * result + ((getPhoto() == null) ? 0 : getPhoto().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getChineseName() == null) ? 0 : getChineseName().hashCode());
        result = prime * result + ((getEnglishName() == null) ? 0 : getEnglishName().hashCode());
        result = prime * result + ((getRoomNo() == null) ? 0 : getRoomNo().hashCode());
        return result;
    }
}