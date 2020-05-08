package com.xlh.chat.enums;

/**
 * 用户关系状态枚举类
 *
 * @author 胡晓磊
 * @company xxx
 * @date 2020年05月08日 21:46 胡晓磊 Exp $
 */
public enum UserRelationStatusEnum {
    /**
     * 正常
     */
    NORMAL(0, "正常"),

    /**
     * 拉黑
     */
    BLACKLIST(1, "拉黑");

    /**
     * 枚举值
     */
    private Integer value;

    /**
     * 描述
     */
    private String desc;

    UserRelationStatusEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    /**
     * Getter method for property <tt>value</tt>.
     *
     * @return property value of value
     */
    public Integer getValue() {
        return value;
    }

    /**
     * Getter method for property <tt>desc</tt>.
     *
     * @return property value of desc
     */
    public String getDesc() {
        return desc;
    }

    public static String getDescByValue(Integer value) {
        for (UserRelationStatusEnum userRelationStatusEnum : UserRelationStatusEnum.values()) {
            if (userRelationStatusEnum.getValue().equals(value)) {
                return userRelationStatusEnum.getDesc();
            }
        }
        return "";
    }
}
