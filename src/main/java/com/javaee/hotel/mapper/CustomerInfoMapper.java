package com.javaee.hotel.mapper;

import com.javaee.hotel.domain.CustomerInfo;
import com.javaee.hotel.domain.CustomerInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer_info
     *
     * @mbg.generated Thu Jul 25 09:33:45 CST 2019
     */
    long countByExample(CustomerInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer_info
     *
     * @mbg.generated Thu Jul 25 09:33:45 CST 2019
     */
    int deleteByExample(CustomerInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer_info
     *
     * @mbg.generated Thu Jul 25 09:33:45 CST 2019
     */
    int insert(CustomerInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer_info
     *
     * @mbg.generated Thu Jul 25 09:33:45 CST 2019
     */
    int insertSelective(CustomerInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer_info
     *
     * @mbg.generated Thu Jul 25 09:33:45 CST 2019
     */
    List<CustomerInfo> selectByExample(CustomerInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer_info
     *
     * @mbg.generated Thu Jul 25 09:33:45 CST 2019
     */
    int updateByExampleSelective(@Param("record") CustomerInfo record, @Param("example") CustomerInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer_info
     *
     * @mbg.generated Thu Jul 25 09:33:45 CST 2019
     */
    int updateByExample(@Param("record") CustomerInfo record, @Param("example") CustomerInfoExample example);
}