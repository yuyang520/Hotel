package com.javaee.hotel.mapper;

import com.javaee.hotel.domain.Icon;
import com.javaee.hotel.domain.IconExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IconMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table icon_table
     *
     * @mbg.generated Wed Aug 07 17:18:17 GMT+08:00 2019
     */
    long countByExample(IconExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table icon_table
     *
     * @mbg.generated Wed Aug 07 17:18:17 GMT+08:00 2019
     */
    int deleteByExample(IconExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table icon_table
     *
     * @mbg.generated Wed Aug 07 17:18:17 GMT+08:00 2019
     */
    int deleteByPrimaryKey(Integer iconId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table icon_table
     *
     * @mbg.generated Wed Aug 07 17:18:17 GMT+08:00 2019
     */
    int insert(Icon record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table icon_table
     *
     * @mbg.generated Wed Aug 07 17:18:17 GMT+08:00 2019
     */
    int insertSelective(Icon record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table icon_table
     *
     * @mbg.generated Wed Aug 07 17:18:17 GMT+08:00 2019
     */
    List<Icon> selectByExample(IconExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table icon_table
     *
     * @mbg.generated Wed Aug 07 17:18:17 GMT+08:00 2019
     */
    Icon selectByPrimaryKey(Integer iconId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table icon_table
     *
     * @mbg.generated Wed Aug 07 17:18:17 GMT+08:00 2019
     */
    int updateByExampleSelective(@Param("record") Icon record, @Param("example") IconExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table icon_table
     *
     * @mbg.generated Wed Aug 07 17:18:17 GMT+08:00 2019
     */
    int updateByExample(@Param("record") Icon record, @Param("example") IconExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table icon_table
     *
     * @mbg.generated Wed Aug 07 17:18:17 GMT+08:00 2019
     */
    int updateByPrimaryKeySelective(Icon record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table icon_table
     *
     * @mbg.generated Wed Aug 07 17:18:17 GMT+08:00 2019
     */
    int updateByPrimaryKey(Icon record);
}