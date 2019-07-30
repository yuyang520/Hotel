package com.javaee.hotel.domain;

public class CustomerInfo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_info.id
     *
     * @mbg.generated Tue Jul 30 10:36:50 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_info.telephone
     *
     * @mbg.generated Tue Jul 30 10:36:50 CST 2019
     */
    private String telephone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_info.email
     *
     * @mbg.generated Tue Jul 30 10:36:50 CST 2019
     */
    private String email;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_info.nick_name
     *
     * @mbg.generated Tue Jul 30 10:36:50 CST 2019
     */
    private String nickName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_info.icon
     *
     * @mbg.generated Tue Jul 30 10:36:50 CST 2019
     */
    private String icon;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_info.person_id
     *
     * @mbg.generated Tue Jul 30 10:36:50 CST 2019
     */
    private String personId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_info.name
     *
     * @mbg.generated Tue Jul 30 10:36:50 CST 2019
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_info.username
     *
     * @mbg.generated Tue Jul 30 10:36:50 CST 2019
     */
    private String username;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_info.id
     *
     * @return the value of customer_info.id
     *
     * @mbg.generated Tue Jul 30 10:36:50 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_info.id
     *
     * @param id the value for customer_info.id
     *
     * @mbg.generated Tue Jul 30 10:36:50 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_info.telephone
     *
     * @return the value of customer_info.telephone
     *
     * @mbg.generated Tue Jul 30 10:36:50 CST 2019
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_info.telephone
     *
     * @param telephone the value for customer_info.telephone
     *
     * @mbg.generated Tue Jul 30 10:36:50 CST 2019
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_info.email
     *
     * @return the value of customer_info.email
     *
     * @mbg.generated Tue Jul 30 10:36:50 CST 2019
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_info.email
     *
     * @param email the value for customer_info.email
     *
     * @mbg.generated Tue Jul 30 10:36:50 CST 2019
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_info.nick_name
     *
     * @return the value of customer_info.nick_name
     *
     * @mbg.generated Tue Jul 30 10:36:50 CST 2019
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_info.nick_name
     *
     * @param nickName the value for customer_info.nick_name
     *
     * @mbg.generated Tue Jul 30 10:36:50 CST 2019
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_info.icon
     *
     * @return the value of customer_info.icon
     *
     * @mbg.generated Tue Jul 30 10:36:50 CST 2019
     */
    public String getIcon() {
        return icon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_info.icon
     *
     * @param icon the value for customer_info.icon
     *
     * @mbg.generated Tue Jul 30 10:36:50 CST 2019
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_info.person_id
     *
     * @return the value of customer_info.person_id
     *
     * @mbg.generated Tue Jul 30 10:36:50 CST 2019
     */
    public String getPersonId() {
        return personId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_info.person_id
     *
     * @param personId the value for customer_info.person_id
     *
     * @mbg.generated Tue Jul 30 10:36:50 CST 2019
     */
    public void setPersonId(String personId) {
        this.personId = personId == null ? null : personId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_info.name
     *
     * @return the value of customer_info.name
     *
     * @mbg.generated Tue Jul 30 10:36:50 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_info.name
     *
     * @param name the value for customer_info.name
     *
     * @mbg.generated Tue Jul 30 10:36:50 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_info.username
     *
     * @return the value of customer_info.username
     *
     * @mbg.generated Tue Jul 30 10:36:50 CST 2019
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_info.username
     *
     * @param username the value for customer_info.username
     *
     * @mbg.generated Tue Jul 30 10:36:50 CST 2019
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer_info
     *
     * @mbg.generated Tue Jul 30 10:36:50 CST 2019
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
        CustomerInfo other = (CustomerInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTelephone() == null ? other.getTelephone() == null : this.getTelephone().equals(other.getTelephone()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getNickName() == null ? other.getNickName() == null : this.getNickName().equals(other.getNickName()))
            && (this.getIcon() == null ? other.getIcon() == null : this.getIcon().equals(other.getIcon()))
            && (this.getPersonId() == null ? other.getPersonId() == null : this.getPersonId().equals(other.getPersonId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer_info
     *
     * @mbg.generated Tue Jul 30 10:36:50 CST 2019
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTelephone() == null) ? 0 : getTelephone().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getNickName() == null) ? 0 : getNickName().hashCode());
        result = prime * result + ((getIcon() == null) ? 0 : getIcon().hashCode());
        result = prime * result + ((getPersonId() == null) ? 0 : getPersonId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        return result;
    }
}