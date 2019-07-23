package com.javaee.hotel.domain;

import java.util.Arrays;
import java.util.Date;

public class Hotel {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hotel.hotel_id
     *
     * @mbg.generated Tue Jul 23 21:10:39 CST 2019
     */
    private String hotelId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hotel.hotel_chinese_name
     *
     * @mbg.generated Tue Jul 23 21:10:39 CST 2019
     */
    private String hotelChineseName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hotel.hotel_address
     *
     * @mbg.generated Tue Jul 23 21:10:39 CST 2019
     */
    private String hotelAddress;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hotel.hotel_stars
     *
     * @mbg.generated Tue Jul 23 21:10:39 CST 2019
     */
    private Integer hotelStars;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hotel.hotel_longitude
     *
     * @mbg.generated Tue Jul 23 21:10:39 CST 2019
     */
    private Float hotelLongitude;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hotel.hotel_latitude
     *
     * @mbg.generated Tue Jul 23 21:10:39 CST 2019
     */
    private Float hotelLatitude;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hotel.hotel_profile
     *
     * @mbg.generated Tue Jul 23 21:10:39 CST 2019
     */
    private String hotelProfile;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hotel.hotel_rating
     *
     * @mbg.generated Tue Jul 23 21:10:39 CST 2019
     */
    private Float hotelRating;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hotel.min_hotel_price
     *
     * @mbg.generated Tue Jul 23 21:10:39 CST 2019
     */
    private Float minHotelPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hotel.hotel_rest_room
     *
     * @mbg.generated Tue Jul 23 21:10:39 CST 2019
     */
    private Integer hotelRestRoom;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hotel.hotel_checkin_time
     *
     * @mbg.generated Tue Jul 23 21:10:39 CST 2019
     */
    private Date hotelCheckinTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hotel.hotel_checkout_time
     *
     * @mbg.generated Tue Jul 23 21:10:39 CST 2019
     */
    private Date hotelCheckoutTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hotel.hotel_contact
     *
     * @mbg.generated Tue Jul 23 21:10:39 CST 2019
     */
    private String hotelContact;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hotel.parking
     *
     * @mbg.generated Tue Jul 23 21:10:39 CST 2019
     */
    private Byte parking;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hotel.hotal_english_name
     *
     * @mbg.generated Tue Jul 23 21:10:39 CST 2019
     */
    private String hotalEnglishName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hotel.picture
     *
     * @mbg.generated Tue Jul 23 21:10:39 CST 2019
     */
    private byte[] picture;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hotel.hotel_id
     *
     * @return the value of hotel.hotel_id
     *
     * @mbg.generated Tue Jul 23 21:10:39 CST 2019
     */
    public String getHotelId() {
        return hotelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hotel.hotel_id
     *
     * @param hotelId the value for hotel.hotel_id
     *
     * @mbg.generated Tue Jul 23 21:10:39 CST 2019
     */
    public void setHotelId(String hotelId) {
        this.hotelId = hotelId == null ? null : hotelId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hotel.hotel_chinese_name
     *
     * @return the value of hotel.hotel_chinese_name
     *
     * @mbg.generated Tue Jul 23 21:10:39 CST 2019
     */
    public String getHotelChineseName() {
        return hotelChineseName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hotel.hotel_chinese_name
     *
     * @param hotelChineseName the value for hotel.hotel_chinese_name
     *
     * @mbg.generated Tue Jul 23 21:10:39 CST 2019
     */
    public void setHotelChineseName(String hotelChineseName) {
        this.hotelChineseName = hotelChineseName == null ? null : hotelChineseName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hotel.hotel_address
     *
     * @return the value of hotel.hotel_address
     *
     * @mbg.generated Tue Jul 23 21:10:39 CST 2019
     */
    public String getHotelAddress() {
        return hotelAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hotel.hotel_address
     *
     * @param hotelAddress the value for hotel.hotel_address
     *
     * @mbg.generated Tue Jul 23 21:10:39 CST 2019
     */
    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress == null ? null : hotelAddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hotel.hotel_stars
     *
     * @return the value of hotel.hotel_stars
     *
     * @mbg.generated Tue Jul 23 21:10:39 CST 2019
     */
    public Integer getHotelStars() {
        return hotelStars;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hotel.hotel_stars
     *
     * @param hotelStars the value for hotel.hotel_stars
     *
     * @mbg.generated Tue Jul 23 21:10:39 CST 2019
     */
    public void setHotelStars(Integer hotelStars) {
        this.hotelStars = hotelStars;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hotel.hotel_longitude
     *
     * @return the value of hotel.hotel_longitude
     *
     * @mbg.generated Tue Jul 23 21:10:39 CST 2019
     */
    public Float getHotelLongitude() {
        return hotelLongitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hotel.hotel_longitude
     *
     * @param hotelLongitude the value for hotel.hotel_longitude
     *
     * @mbg.generated Tue Jul 23 21:10:39 CST 2019
     */
    public void setHotelLongitude(Float hotelLongitude) {
        this.hotelLongitude = hotelLongitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hotel.hotel_latitude
     *
     * @return the value of hotel.hotel_latitude
     *
     * @mbg.generated Tue Jul 23 21:10:39 CST 2019
     */
    public Float getHotelLatitude() {
        return hotelLatitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hotel.hotel_latitude
     *
     * @param hotelLatitude the value for hotel.hotel_latitude
     *
     * @mbg.generated Tue Jul 23 21:10:39 CST 2019
     */
    public void setHotelLatitude(Float hotelLatitude) {
        this.hotelLatitude = hotelLatitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hotel.hotel_profile
     *
     * @return the value of hotel.hotel_profile
     *
     * @mbg.generated Tue Jul 23 21:10:39 CST 2019
     */
    public String getHotelProfile() {
        return hotelProfile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hotel.hotel_profile
     *
     * @param hotelProfile the value for hotel.hotel_profile
     *
     * @mbg.generated Tue Jul 23 21:10:39 CST 2019
     */
    public void setHotelProfile(String hotelProfile) {
        this.hotelProfile = hotelProfile == null ? null : hotelProfile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hotel.hotel_rating
     *
     * @return the value of hotel.hotel_rating
     *
     * @mbg.generated Tue Jul 23 21:10:39 CST 2019
     */
    public Float getHotelRating() {
        return hotelRating;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hotel.hotel_rating
     *
     * @param hotelRating the value for hotel.hotel_rating
     *
     * @mbg.generated Tue Jul 23 21:10:39 CST 2019
     */
    public void setHotelRating(Float hotelRating) {
        this.hotelRating = hotelRating;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hotel.min_hotel_price
     *
     * @return the value of hotel.min_hotel_price
     *
     * @mbg.generated Tue Jul 23 21:10:39 CST 2019
     */
    public Float getMinHotelPrice() {
        return minHotelPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hotel.min_hotel_price
     *
     * @param minHotelPrice the value for hotel.min_hotel_price
     *
     * @mbg.generated Tue Jul 23 21:10:39 CST 2019
     */
    public void setMinHotelPrice(Float minHotelPrice) {
        this.minHotelPrice = minHotelPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hotel.hotel_rest_room
     *
     * @return the value of hotel.hotel_rest_room
     *
     * @mbg.generated Tue Jul 23 21:10:39 CST 2019
     */
    public Integer getHotelRestRoom() {
        return hotelRestRoom;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hotel.hotel_rest_room
     *
     * @param hotelRestRoom the value for hotel.hotel_rest_room
     *
     * @mbg.generated Tue Jul 23 21:10:39 CST 2019
     */
    public void setHotelRestRoom(Integer hotelRestRoom) {
        this.hotelRestRoom = hotelRestRoom;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hotel.hotel_checkin_time
     *
     * @return the value of hotel.hotel_checkin_time
     *
     * @mbg.generated Tue Jul 23 21:10:39 CST 2019
     */
    public Date getHotelCheckinTime() {
        return hotelCheckinTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hotel.hotel_checkin_time
     *
     * @param hotelCheckinTime the value for hotel.hotel_checkin_time
     *
     * @mbg.generated Tue Jul 23 21:10:39 CST 2019
     */
    public void setHotelCheckinTime(Date hotelCheckinTime) {
        this.hotelCheckinTime = hotelCheckinTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hotel.hotel_checkout_time
     *
     * @return the value of hotel.hotel_checkout_time
     *
     * @mbg.generated Tue Jul 23 21:10:39 CST 2019
     */
    public Date getHotelCheckoutTime() {
        return hotelCheckoutTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hotel.hotel_checkout_time
     *
     * @param hotelCheckoutTime the value for hotel.hotel_checkout_time
     *
     * @mbg.generated Tue Jul 23 21:10:39 CST 2019
     */
    public void setHotelCheckoutTime(Date hotelCheckoutTime) {
        this.hotelCheckoutTime = hotelCheckoutTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hotel.hotel_contact
     *
     * @return the value of hotel.hotel_contact
     *
     * @mbg.generated Tue Jul 23 21:10:39 CST 2019
     */
    public String getHotelContact() {
        return hotelContact;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hotel.hotel_contact
     *
     * @param hotelContact the value for hotel.hotel_contact
     *
     * @mbg.generated Tue Jul 23 21:10:39 CST 2019
     */
    public void setHotelContact(String hotelContact) {
        this.hotelContact = hotelContact == null ? null : hotelContact.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hotel.parking
     *
     * @return the value of hotel.parking
     *
     * @mbg.generated Tue Jul 23 21:10:39 CST 2019
     */
    public Byte getParking() {
        return parking;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hotel.parking
     *
     * @param parking the value for hotel.parking
     *
     * @mbg.generated Tue Jul 23 21:10:39 CST 2019
     */
    public void setParking(Byte parking) {
        this.parking = parking;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hotel.hotal_english_name
     *
     * @return the value of hotel.hotal_english_name
     *
     * @mbg.generated Tue Jul 23 21:10:39 CST 2019
     */
    public String getHotalEnglishName() {
        return hotalEnglishName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hotel.hotal_english_name
     *
     * @param hotalEnglishName the value for hotel.hotal_english_name
     *
     * @mbg.generated Tue Jul 23 21:10:39 CST 2019
     */
    public void setHotalEnglishName(String hotalEnglishName) {
        this.hotalEnglishName = hotalEnglishName == null ? null : hotalEnglishName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hotel.picture
     *
     * @return the value of hotel.picture
     *
     * @mbg.generated Tue Jul 23 21:10:39 CST 2019
     */
    public byte[] getPicture() {
        return picture;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hotel.picture
     *
     * @param picture the value for hotel.picture
     *
     * @mbg.generated Tue Jul 23 21:10:39 CST 2019
     */
    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hotel
     *
     * @mbg.generated Tue Jul 23 21:10:39 CST 2019
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
        Hotel other = (Hotel) that;
        return (this.getHotelId() == null ? other.getHotelId() == null : this.getHotelId().equals(other.getHotelId()))
            && (this.getHotelChineseName() == null ? other.getHotelChineseName() == null : this.getHotelChineseName().equals(other.getHotelChineseName()))
            && (this.getHotelAddress() == null ? other.getHotelAddress() == null : this.getHotelAddress().equals(other.getHotelAddress()))
            && (this.getHotelStars() == null ? other.getHotelStars() == null : this.getHotelStars().equals(other.getHotelStars()))
            && (this.getHotelLongitude() == null ? other.getHotelLongitude() == null : this.getHotelLongitude().equals(other.getHotelLongitude()))
            && (this.getHotelLatitude() == null ? other.getHotelLatitude() == null : this.getHotelLatitude().equals(other.getHotelLatitude()))
            && (this.getHotelProfile() == null ? other.getHotelProfile() == null : this.getHotelProfile().equals(other.getHotelProfile()))
            && (this.getHotelRating() == null ? other.getHotelRating() == null : this.getHotelRating().equals(other.getHotelRating()))
            && (this.getMinHotelPrice() == null ? other.getMinHotelPrice() == null : this.getMinHotelPrice().equals(other.getMinHotelPrice()))
            && (this.getHotelRestRoom() == null ? other.getHotelRestRoom() == null : this.getHotelRestRoom().equals(other.getHotelRestRoom()))
            && (this.getHotelCheckinTime() == null ? other.getHotelCheckinTime() == null : this.getHotelCheckinTime().equals(other.getHotelCheckinTime()))
            && (this.getHotelCheckoutTime() == null ? other.getHotelCheckoutTime() == null : this.getHotelCheckoutTime().equals(other.getHotelCheckoutTime()))
            && (this.getHotelContact() == null ? other.getHotelContact() == null : this.getHotelContact().equals(other.getHotelContact()))
            && (this.getParking() == null ? other.getParking() == null : this.getParking().equals(other.getParking()))
            && (this.getHotalEnglishName() == null ? other.getHotalEnglishName() == null : this.getHotalEnglishName().equals(other.getHotalEnglishName()))
            && (Arrays.equals(this.getPicture(), other.getPicture()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hotel
     *
     * @mbg.generated Tue Jul 23 21:10:39 CST 2019
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getHotelId() == null) ? 0 : getHotelId().hashCode());
        result = prime * result + ((getHotelChineseName() == null) ? 0 : getHotelChineseName().hashCode());
        result = prime * result + ((getHotelAddress() == null) ? 0 : getHotelAddress().hashCode());
        result = prime * result + ((getHotelStars() == null) ? 0 : getHotelStars().hashCode());
        result = prime * result + ((getHotelLongitude() == null) ? 0 : getHotelLongitude().hashCode());
        result = prime * result + ((getHotelLatitude() == null) ? 0 : getHotelLatitude().hashCode());
        result = prime * result + ((getHotelProfile() == null) ? 0 : getHotelProfile().hashCode());
        result = prime * result + ((getHotelRating() == null) ? 0 : getHotelRating().hashCode());
        result = prime * result + ((getMinHotelPrice() == null) ? 0 : getMinHotelPrice().hashCode());
        result = prime * result + ((getHotelRestRoom() == null) ? 0 : getHotelRestRoom().hashCode());
        result = prime * result + ((getHotelCheckinTime() == null) ? 0 : getHotelCheckinTime().hashCode());
        result = prime * result + ((getHotelCheckoutTime() == null) ? 0 : getHotelCheckoutTime().hashCode());
        result = prime * result + ((getHotelContact() == null) ? 0 : getHotelContact().hashCode());
        result = prime * result + ((getParking() == null) ? 0 : getParking().hashCode());
        result = prime * result + ((getHotalEnglishName() == null) ? 0 : getHotalEnglishName().hashCode());
        result = prime * result + (Arrays.hashCode(getPicture()));
        return result;
    }
}