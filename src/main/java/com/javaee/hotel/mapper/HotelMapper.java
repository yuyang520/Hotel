package com.javaee.hotel.mapper;

import com.javaee.hotel.domain.Hotel;
import com.javaee.hotel.domain.HotelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HotelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hotel
     *
     * @mbg.generated Wed Aug 07 17:18:17 GMT+08:00 2019
     */
    long countByExample(HotelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hotel
     *
     * @mbg.generated Wed Aug 07 17:18:17 GMT+08:00 2019
     */
    int deleteByExample(HotelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hotel
     *
     * @mbg.generated Wed Aug 07 17:18:17 GMT+08:00 2019
     */
    int deleteByPrimaryKey(String hotelId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hotel
     *
     * @mbg.generated Wed Aug 07 17:18:17 GMT+08:00 2019
     */
    int insert(Hotel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hotel
     *
     * @mbg.generated Wed Aug 07 17:18:17 GMT+08:00 2019
     */
    int insertSelective(Hotel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hotel
     *
     * @mbg.generated Wed Aug 07 17:18:17 GMT+08:00 2019
     */
    List<Hotel> selectByExample(HotelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hotel
     *
     * @mbg.generated Wed Aug 07 17:18:17 GMT+08:00 2019
     */
    Hotel selectByPrimaryKey(String hotelId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hotel
     *
     * @mbg.generated Wed Aug 07 17:18:17 GMT+08:00 2019
     */
    int updateByExampleSelective(@Param("record") Hotel record, @Param("example") HotelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hotel
     *
     * @mbg.generated Wed Aug 07 17:18:17 GMT+08:00 2019
     */
    int updateByExample(@Param("record") Hotel record, @Param("example") HotelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hotel
     *
     * @mbg.generated Wed Aug 07 17:18:17 GMT+08:00 2019
     */
    int updateByPrimaryKeySelective(Hotel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hotel
     *
     * @mbg.generated Wed Aug 07 17:18:17 GMT+08:00 2019
     */
    int updateByPrimaryKey(Hotel record);
}