package com.xlh.chat.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;

public class UserGroup {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_group.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_group.user_id
     *
     * @mbg.generated
     */
    private Long userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_group.name
     *
     * @mbg.generated
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_group.announcement
     *
     * @mbg.generated
     */
    private String announcement;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_group.show_nick_name
     *
     * @mbg.generated
     */
    private Boolean showNickName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_group.mute
     *
     * @mbg.generated
     */
    private Boolean mute;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_group.create_time
     *
     * @mbg.generated
     */
    private Timestamp createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_group.modify_time
     *
     * @mbg.generated
     */
    private Timestamp modifyTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_group.id
     *
     * @return the value of user_group.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_group.id
     *
     * @param id the value for user_group.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_group.user_id
     *
     * @return the value of user_group.user_id
     *
     * @mbg.generated
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_group.user_id
     *
     * @param userId the value for user_group.user_id
     *
     * @mbg.generated
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_group.name
     *
     * @return the value of user_group.name
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_group.name
     *
     * @param name the value for user_group.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_group.announcement
     *
     * @return the value of user_group.announcement
     *
     * @mbg.generated
     */
    public String getAnnouncement() {
        return announcement;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_group.announcement
     *
     * @param announcement the value for user_group.announcement
     *
     * @mbg.generated
     */
    public void setAnnouncement(String announcement) {
        this.announcement = announcement == null ? null : announcement.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_group.show_nick_name
     *
     * @return the value of user_group.show_nick_name
     *
     * @mbg.generated
     */
    public Boolean getShowNickName() {
        return showNickName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_group.show_nick_name
     *
     * @param showNickName the value for user_group.show_nick_name
     *
     * @mbg.generated
     */
    public void setShowNickName(Boolean showNickName) {
        this.showNickName = showNickName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_group.mute
     *
     * @return the value of user_group.mute
     *
     * @mbg.generated
     */
    public Boolean getMute() {
        return mute;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_group.mute
     *
     * @param mute the value for user_group.mute
     *
     * @mbg.generated
     */
    public void setMute(Boolean mute) {
        this.mute = mute;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_group.create_time
     *
     * @return the value of user_group.create_time
     *
     * @mbg.generated
     */
    public Timestamp getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_group.create_time
     *
     * @param createTime the value for user_group.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_group.modify_time
     *
     * @return the value of user_group.modify_time
     *
     * @mbg.generated
     */
    public Timestamp getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_group.modify_time
     *
     * @param modifyTime the value for user_group.modify_time
     *
     * @mbg.generated
     */
    public void setModifyTime(Timestamp modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * This enum was generated by MyBatis Generator.
     * This enum corresponds to the database table user_group
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public enum Column {
        id("id", "id", "BIGINT", false),
        userId("user_id", "userId", "BIGINT", false),
        name("name", "name", "VARCHAR", false),
        announcement("announcement", "announcement", "VARCHAR", false),
        showNickName("show_nick_name", "showNickName", "BIT", false),
        mute("mute", "mute", "BIT", false),
        createTime("create_time", "createTime", "TIMESTAMP", false),
        modifyTime("modify_time", "modifyTime", "TIMESTAMP", false);

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table user_group
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private static final String BEGINNING_DELIMITER = "\"";

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table user_group
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private static final String ENDING_DELIMITER = "\"";

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table user_group
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String column;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table user_group
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final boolean isColumnNameDelimited;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table user_group
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String javaProperty;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table user_group
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String jdbcType;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table user_group
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String value() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table user_group
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getValue() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table user_group
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getJavaProperty() {
            return this.javaProperty;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table user_group
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getJdbcType() {
            return this.jdbcType;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table user_group
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        Column(String column, String javaProperty, String jdbcType, boolean isColumnNameDelimited) {
            this.column = column;
            this.javaProperty = javaProperty;
            this.jdbcType = jdbcType;
            this.isColumnNameDelimited = isColumnNameDelimited;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table user_group
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String desc() {
            return this.getEscapedColumnName() + " DESC";
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table user_group
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String asc() {
            return this.getEscapedColumnName() + " ASC";
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table user_group
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public static Column[] excludes(Column ... excludes) {
            ArrayList<Column> columns = new ArrayList<>(Arrays.asList(Column.values()));
            if (excludes != null && excludes.length > 0) {
                columns.removeAll(new ArrayList<>(Arrays.asList(excludes)));
            }
            return columns.toArray(new Column[]{});
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table user_group
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getEscapedColumnName() {
            if (this.isColumnNameDelimited) {
                return new StringBuilder().append(BEGINNING_DELIMITER).append(this.column).append(ENDING_DELIMITER).toString();
            } else {
                return this.column;
            }
        }
    }
}