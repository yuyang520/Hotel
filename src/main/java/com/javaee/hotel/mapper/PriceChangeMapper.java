package com.javaee.hotel.mapper;

import com.javaee.hotel.domain.PriceChange;
import com.javaee.hotel.domain.PriceChangeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface  PriceChangeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table price_change
     *
     * @mbg.generated Fri Jul 26 00:06:46 CST 2019
     */
    long countByExample(PriceChangeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table price_change
     *
     * @mbg.generated Fri Jul 26 00:06:46 CST 2019
     */
    int deleteByExample(PriceChangeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table price_change
     *
     * @mbg.generated Fri Jul 26 00:06:46 CST 2019
     */
    int insert(PriceChange record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table price_change
     *
     * @mbg.generated Fri Jul 26 00:06:46 CST 2019
     */
    int insertSelective(PriceChange record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table price_change
     *
     * @mbg.generated Fri Jul 26 00:06:46 CST 2019
     */
    List<PriceChange> selectByExample(PriceChangeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table price_change
     *
     * @mbg.generated Fri Jul 26 00:06:46 CST 2019
     */
    int updateByExampleSelective(@Param("record") PriceChange record, @Param("example") PriceChangeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table price_change
     *
     * @mbg.generated Fri Jul 26 00:06:46 CST 2019
     */
    int updateByExample(@Param("record") PriceChange record, @Param("example") PriceChangeExample example);
}