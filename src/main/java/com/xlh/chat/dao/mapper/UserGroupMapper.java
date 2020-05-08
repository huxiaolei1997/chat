package com.xlh.chat.dao.mapper;

import com.xlh.chat.model.UserGroup;
import com.xlh.chat.model.UserGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserGroupMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_group
     *
     * @mbg.generated
     */
    long countByExample(UserGroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_group
     *
     * @mbg.generated
     */
    int deleteByExample(UserGroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_group
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_group
     *
     * @mbg.generated
     */
    int insert(UserGroup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_group
     *
     * @mbg.generated
     */
    int insertSelective(UserGroup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_group
     *
     * @mbg.generated
     */
    List<UserGroup> selectByExample(UserGroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_group
     *
     * @mbg.generated
     */
    UserGroup selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_group
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") UserGroup record, @Param("example") UserGroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_group
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") UserGroup record, @Param("example") UserGroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_group
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(UserGroup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_group
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(UserGroup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_group
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int batchInsert(@Param("list") List<UserGroup> list);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_group
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int batchInsertSelective(@Param("list") List<UserGroup> list, @Param("selective") UserGroup.Column ... selective);
}