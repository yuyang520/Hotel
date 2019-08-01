package com.javaee.hotel.domain;

public class Icon {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column icon_table.icon_id
     *
     * @mbg.generated Wed Jul 31 14:50:03 CST 2019
     */
    private Integer iconId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column icon_table.group_type
     *
     * @mbg.generated Wed Jul 31 14:50:03 CST 2019
     */
    private String groupType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column icon_table.icon_class
     *
     * @mbg.generated Wed Jul 31 14:50:03 CST 2019
     */
    private String iconClass;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column icon_table.icon_text
     *
     * @mbg.generated Wed Jul 31 14:50:03 CST 2019
     */
    private String iconText;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column icon_table.icon_id
     *
     * @return the value of icon_table.icon_id
     *
     * @mbg.generated Wed Jul 31 14:50:03 CST 2019
     */
    public Integer getIconId() {
        return iconId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column icon_table.icon_id
     *
     * @param iconId the value for icon_table.icon_id
     *
     * @mbg.generated Wed Jul 31 14:50:03 CST 2019
     */
    public void setIconId(Integer iconId) {
        this.iconId = iconId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column icon_table.group_type
     *
     * @return the value of icon_table.group_type
     *
     * @mbg.generated Wed Jul 31 14:50:03 CST 2019
     */
    public String getGroupType() {
        return groupType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column icon_table.group_type
     *
     * @param groupType the value for icon_table.group_type
     *
     * @mbg.generated Wed Jul 31 14:50:03 CST 2019
     */
    public void setGroupType(String groupType) {
        this.groupType = groupType == null ? null : groupType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column icon_table.icon_class
     *
     * @return the value of icon_table.icon_class
     *
     * @mbg.generated Wed Jul 31 14:50:03 CST 2019
     */
    public String getIconClass() {
        return iconClass;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column icon_table.icon_class
     *
     * @param iconClass the value for icon_table.icon_class
     *
     * @mbg.generated Wed Jul 31 14:50:03 CST 2019
     */
    public void setIconClass(String iconClass) {
        this.iconClass = iconClass == null ? null : iconClass.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column icon_table.icon_text
     *
     * @return the value of icon_table.icon_text
     *
     * @mbg.generated Wed Jul 31 14:50:03 CST 2019
     */
    public String getIconText() {
        return iconText;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column icon_table.icon_text
     *
     * @param iconText the value for icon_table.icon_text
     *
     * @mbg.generated Wed Jul 31 14:50:03 CST 2019
     */
    public void setIconText(String iconText) {
        this.iconText = iconText == null ? null : iconText.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table icon_table
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
        Icon other = (Icon) that;
        return (this.getIconId() == null ? other.getIconId() == null : this.getIconId().equals(other.getIconId()))
            && (this.getGroupType() == null ? other.getGroupType() == null : this.getGroupType().equals(other.getGroupType()))
            && (this.getIconClass() == null ? other.getIconClass() == null : this.getIconClass().equals(other.getIconClass()))
            && (this.getIconText() == null ? other.getIconText() == null : this.getIconText().equals(other.getIconText()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table icon_table
     *
     * @mbg.generated Wed Jul 31 14:50:03 CST 2019
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIconId() == null) ? 0 : getIconId().hashCode());
        result = prime * result + ((getGroupType() == null) ? 0 : getGroupType().hashCode());
        result = prime * result + ((getIconClass() == null) ? 0 : getIconClass().hashCode());
        result = prime * result + ((getIconText() == null) ? 0 : getIconText().hashCode());
        return result;
    }
}