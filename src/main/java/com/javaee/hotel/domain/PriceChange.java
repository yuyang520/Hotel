package com.javaee.hotel.domain;

import java.util.Date;

public class PriceChange {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column price_change.room_id
     *
     * @mbg.generated Tue Jul 30 11:36:49 CST 2019
     */
    private String roomId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column price_change.price
     *
     * @mbg.generated Tue Jul 30 11:36:49 CST 2019
     */
    private Float price;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column price_change.date
     *
     * @mbg.generated Tue Jul 30 11:36:49 CST 2019
     */
    private Date date;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column price_change.room_id
     *
     * @return the value of price_change.room_id
     *
     * @mbg.generated Tue Jul 30 11:36:49 CST 2019
     */
    public String getRoomId() {
        return roomId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column price_change.room_id
     *
     * @param roomId the value for price_change.room_id
     *
     * @mbg.generated Tue Jul 30 11:36:49 CST 2019
     */
    public void setRoomId(String roomId) {
        this.roomId = roomId == null ? null : roomId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column price_change.price
     *
     * @return the value of price_change.price
     *
     * @mbg.generated Tue Jul 30 11:36:49 CST 2019
     */
    public Float getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column price_change.price
     *
     * @param price the value for price_change.price
     *
     * @mbg.generated Tue Jul 30 11:36:49 CST 2019
     */
    public void setPrice(Float price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column price_change.date
     *
     * @return the value of price_change.date
     *
     * @mbg.generated Tue Jul 30 11:36:49 CST 2019
     */
    public Date getDate() {
        return date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column price_change.date
     *
     * @param date the value for price_change.date
     *
     * @mbg.generated Tue Jul 30 11:36:49 CST 2019
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table price_change
     *
     * @mbg.generated Tue Jul 30 11:36:49 CST 2019
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
        PriceChange other = (PriceChange) that;
        return (this.getRoomId() == null ? other.getRoomId() == null : this.getRoomId().equals(other.getRoomId()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getDate() == null ? other.getDate() == null : this.getDate().equals(other.getDate()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table price_change
     *
     * @mbg.generated Tue Jul 30 11:36:49 CST 2019
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRoomId() == null) ? 0 : getRoomId().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getDate() == null) ? 0 : getDate().hashCode());
        return result;
    }
}